package net.silverfishstone.mintmc.minecart;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

import java.util.*;

public class MinecartChainHandler {
    private static final Map<UUID, AbstractMinecartEntity> chainingPlayers = new HashMap<>();
    private static final List<List<AbstractMinecartEntity>> minecartChains = new ArrayList<>();
    private static final Map<UUID, Long> cooldowns = new HashMap<>();

    private static final long COOLDOWN_TICKS = 10;
    private static final double CHAIN_DISTANCE = 1.2;
    private static final double FOLLOW_SPEED = 0.1;

    public static void register() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> onMinecartInteract(player, world, hand, entity));
        ServerTickEvents.END_WORLD_TICK.register(MinecartChainHandler::onServerTick);
    }

    private static ActionResult onMinecartInteract(PlayerEntity player, World world, Hand hand, net.minecraft.entity.Entity entity) {
        if (!(entity instanceof AbstractMinecartEntity minecart)) return ActionResult.PASS;
        if (!player.isSneaking() || player.getStackInHand(hand).getItem() != Items.CHAIN) return ActionResult.PASS;

        UUID playerId = player.getUuid();
        long currentTime = world.getTime();

        if (cooldowns.containsKey(playerId) && currentTime - cooldowns.get(playerId) < COOLDOWN_TICKS) {
            return ActionResult.FAIL;
        }
        cooldowns.put(playerId, currentTime);

        if (chainingPlayers.containsKey(playerId)) {
            AbstractMinecartEntity firstCart = chainingPlayers.remove(playerId);

            if (firstCart == minecart) {
                return ActionResult.SUCCESS;
            }

            if (getMinecartChain(firstCart) != null || getMinecartChain(minecart) != null) {
                return ActionResult.SUCCESS;
            }

            List<AbstractMinecartEntity> newChain = new ArrayList<>();
            newChain.add(firstCart);
            newChain.add(minecart);
            minecartChains.add(newChain);

            world.syncWorldEvent(WorldEvents.BLOCK_SCRAPED, player.getBlockPos(), 0);
        } else {
            chainingPlayers.put(playerId, minecart);
        }

        return ActionResult.SUCCESS;
    }

    private static void onServerTick(ServerWorld world) {
        for (List<AbstractMinecartEntity> chain : minecartChains) {
            if (chain.isEmpty()) continue;

            AbstractMinecartEntity leader = chain.get(0);
            Vec3d leaderVelocity = leader.getVelocity();

            for (int i = 1; i < chain.size(); i++) {
                AbstractMinecartEntity follower = chain.get(i);

                if (!leader.isAlive() || !follower.isAlive()) {
                    chain.remove(i);
                    i--;
                    continue;
                }

                Vec3d leaderPos = leader.getPos();
                Vec3d followerPos = follower.getPos();
                Vec3d difference = leaderPos.subtract(followerPos);

                double distance = difference.length();

                if (distance > CHAIN_DISTANCE) {
                    Vec3d direction = difference.normalize();
                    Vec3d moveToLeader = direction.multiply(FOLLOW_SPEED);
                    follower.setVelocity(follower.getVelocity().add(moveToLeader));
                }

                follower.setVelocity(follower.getVelocity().multiply(0.8).add(leaderVelocity.multiply(0.2)));
            }
        }

        minecartChains.removeIf(List::isEmpty);
    }

    private static List<AbstractMinecartEntity> getMinecartChain(AbstractMinecartEntity cart) {
        for (List<AbstractMinecartEntity> chain : minecartChains) {
            if (chain.contains(cart)) return chain;
        }
        return null;
    }
}
