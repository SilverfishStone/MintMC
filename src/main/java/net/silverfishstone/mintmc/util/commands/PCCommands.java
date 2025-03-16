package net.silverfishstone.mintmc.util.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.silverfishstone.mintmc.MintMain;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class PCCommands {
    public static void registerCommands () {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            listVariantsCommand(dispatcher);
            mobCommands(dispatcher);
        });
        MintMain.LOGGER.info("initialized Modded Commands");
    }

    private static void mobCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("dropEggs").executes(PCCommands::mobCommands));
        dispatcher.register(CommandManager.literal("ageUp").executes(PCCommands::ageUpCommand));
    }

    private static void listVariantsCommand (CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("listVariants")
                .executes(commandContext -> runVariantListCommand(commandContext, "all"))
                .then(CommandManager.literal("wolf")
                        .executes(commandContext -> runVariantListCommand(commandContext, "wolf")))
                .then(CommandManager.literal("cow")
                        .executes(commandContext -> runVariantListCommand(commandContext, "cow")))
                .then(CommandManager.literal("pig")
                        .executes(commandContext -> runVariantListCommand(commandContext, "pig")))
                .then(CommandManager.literal("frog")
                        .executes(commandContext -> runVariantListCommand(commandContext, "frog")))
                .then(CommandManager.literal("chicken")
                        .executes(commandContext -> runVariantListCommand(commandContext, "chicken")))
                .then(CommandManager.literal("cat")
                        .executes(commandContext -> runVariantListCommand(commandContext, "cat")))
                .then(CommandManager.literal("clear")
                        .executes(commandContext -> runVariantListCommand(commandContext, "clear"))));
    }

    private static int mobCommands(CommandContext<ServerCommandSource> context) {
        ServerWorld world = context.getSource().getWorld();
        dropEggs(world);
        context.getSource().sendFeedback(() -> Text.of("Nudged Chickens"), false);
        return 1;
    }
    private static int ageUpCommand(CommandContext<ServerCommandSource> context) {
        ServerWorld world = context.getSource().getWorld();
        age(world);
        context.getSource().sendFeedback(() -> Text.of("Aged mobs"), false);
        return 1;
    }

    private static int runVariantListCommand(CommandContext<ServerCommandSource> context, String variants) {
        PlayerEntity player = context.getSource().getPlayer();
        listVariants(context.getSource().getRegistryManager(), player, variants);
        context.getSource().sendFeedback(() -> Text.of("Listed " + variants + " variants"), false);
        return 1;
    }
    private static void age(ServerWorld world) {
        world.iterateEntities().forEach(entity -> {
            if (entity instanceof LivingEntity chicken && !(chicken instanceof PlayerEntity)) {
                NbtCompound nbt = new NbtCompound();
                nbt.putInt("Age", 40000);
                chicken.readCustomDataFromNbt(nbt);
            }
        });
    }

    private static void dropEggs(ServerWorld world) {
        world.iterateEntities().forEach(entity -> {
            if (entity instanceof ChickenEntity chicken) {
                NbtCompound nbt = new NbtCompound();
                nbt.putInt("EggLayTime", 0);
                chicken.readCustomDataFromNbt(nbt);
            }
            if (entity instanceof ArmadilloEntity armadillo) {
                NbtCompound nbt = new NbtCompound();
                nbt.putInt("scute_time", 0);
                armadillo.readCustomDataFromNbt(nbt);
            }
        });
        world.iterateEntities().forEach(entity -> {
            if (entity instanceof SnifferEntity sniffer) {
                sniffer.getCommandTags().add("droptimeTag");
            }
        });
    }

    private static void listVariants (RegistryWrapper.WrapperLookup registries, PlayerEntity player, String version) {
        RegistryWrapper.Impl<WolfVariant> wolfV = registries.getOrThrow(RegistryKeys.WOLF_VARIANT);
        RegistryWrapper.Impl<PigVariant> pigV = registries.getOrThrow(RegistryKeys.PIG_VARIANT);
        RegistryWrapper.Impl<FrogVariant> frogV = registries.getOrThrow(RegistryKeys.FROG_VARIANT);
        RegistryWrapper.Impl<ChickenVariant> chickenV = registries.getOrThrow(RegistryKeys.CHICKEN_VARIANT);
        RegistryWrapper.Impl<CatVariant> catV = registries.getOrThrow(RegistryKeys.CAT_VARIANT);
        RegistryWrapper.Impl<CowVariant> cowV = registries.getOrThrow(RegistryKeys.COW_VARIANT);
        List<String> options = new ArrayList<>();
        List<String> wolf = new ArrayList<>();
        List<String> cat = new ArrayList<>();
        List<String> pig = new ArrayList<>();
        List<String> chicken = new ArrayList<>();
        List<String> frog = new ArrayList<>();
        List<String> cow = new ArrayList<>();
        if (version.equals("all")) {
            options.add("wolf");
            options.add("cat");
            options.add("pig");
            options.add("chicken");
            options.add("frog");
            options.add("cow");
        } else {
            options.add(version);
        }
        if (options.contains("wolf")) wolfV.streamKeys()
                .sorted(Comparator.comparing(RegistryKey::getValue))
                .forEach(
                        key -> {
                            RegistryEntry<WolfVariant> registryEntry = wolfV.getOrThrow(key);
                            wolf.add(registryEntry.getIdAsString());
                        }
                );
        if (options.contains("pig")) pigV.streamKeys()
                .sorted(Comparator.comparing(RegistryKey::getValue))
                .forEach(
                        key -> {
                            RegistryEntry<PigVariant> registryEntry = pigV.getOrThrow(key);
                            pig.add(registryEntry.getIdAsString());
                        }
                );
        if (options.contains("cow")) cowV.streamKeys()
                .sorted(Comparator.comparing(RegistryKey::getValue))
                .forEach(
                        key -> {
                            RegistryEntry<CowVariant> registryEntry = cowV.getOrThrow(key);
                            cow.add(registryEntry.getIdAsString());
                        }
                );
        if (options.contains("frog")) frogV.streamKeys()
                .sorted(Comparator.comparing(RegistryKey::getValue))
                .forEach(
                        key -> {
                            RegistryEntry<FrogVariant> registryEntry = frogV.getOrThrow(key);
                            frog.add(registryEntry.getIdAsString());
                        }
                );
        if (options.contains("chicken")) chickenV.streamKeys()
                .sorted(Comparator.comparing(RegistryKey::getValue))
                .forEach(
                        key -> {
                            RegistryEntry<ChickenVariant> registryEntry = chickenV.getOrThrow(key);
                            chicken.add(registryEntry.getIdAsString());
                        }
                );
        if (options.contains("cat")) catV.streamKeys()
                .sorted(Comparator.comparing(RegistryKey::getValue))
                .forEach(
                        key -> {
                            RegistryEntry<CatVariant> registryEntry = catV.getOrThrow(key);
                            cat.add(registryEntry.getIdAsString());
                        }
                );
        player.sendMessage(Text.of(String.valueOf("Wolf Variants:").formatted(Formatting.AQUA) + variantsListing(wolf) + "; "), false);
        player.sendMessage(Text.of(String.valueOf("Cow Variants:").formatted(Formatting.AQUA) + variantsListing(cow) + "; "), false);
        player.sendMessage(Text.of(String.valueOf("Pig Variants:").formatted(Formatting.AQUA) + variantsListing(pig) + "; "), false);
        player.sendMessage(Text.of(String.valueOf("Cat Variants:").formatted(Formatting.AQUA) + variantsListing(cat) + "; "), false);
        player.sendMessage(Text.of(String.valueOf("Chicken Variants:").formatted(Formatting.AQUA) + variantsListing(chicken) + "; "), false);
        player.sendMessage(Text.of(String.valueOf("Frog Variants:").formatted(Formatting.AQUA) + variantsListing(frog)), false);
    }
    private static String variantsListing (List<String> variants) {
        AtomicReference<String> RETURN = new AtomicReference<>("");
        variants.forEach(string -> RETURN.set(RETURN + ", " +string));
        return RETURN.get();
    }
}
