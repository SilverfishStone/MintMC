package net.silverfishstone.mintmc.resource.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.CollisionEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.fluid.*;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.silverfishstone.mintmc.datagen.tags.MintTags;
import net.silverfishstone.mintmc.resource.blocks.MintBlocks;
import net.silverfishstone.mintmc.resource.items.MintItems;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class EbonFluid extends FlowableFluid {
    @Override
    public Fluid getFlowing() {
        return MintFluids.FLOWING_EBON;
    }

    @Override
    public Fluid getStill() {
        return MintFluids.EBON;
    }

    @Override
    public Item getBucketItem() {
        return MintItems.EBON_BUCKET;
    }

    @Override
    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        if (!state.isStill() && !(Boolean)state.get(FALLING)) {
            if (random.nextInt(64) == 0) {
                world.playSoundClient(
                        (double)pos.getX() + 0.5,
                        (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5,
                        SoundEvents.BLOCK_WATER_AMBIENT,
                        SoundCategory.BLOCKS,
                        random.nextFloat() * 0.25F + 0.75F,
                        random.nextFloat() + 0.5F,
                        false
                );
            }
        } else if (random.nextInt(10) == 0) {
            world.addParticleClient(
                    ParticleTypes.UNDERWATER,
                    (double)pos.getX() + random.nextDouble(),
                    (double)pos.getY() + random.nextDouble(),
                    (double)pos.getZ() + random.nextDouble(),
                    0.0,
                    0.0,
                    0.0
            );
        }
    }

    @Nullable
    @Override
    public ParticleEffect getParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }

    @Override
    protected boolean isInfinite(ServerWorld world) {
        return world.getGameRules().getBoolean(GameRules.WATER_SOURCE_CONVERSION);
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    protected void onEntityCollision(World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        handler.addEvent(CollisionEvent.FREEZE);
    }

    @Override
    public int getMaxFlowDistance(WorldView world) {
        return 4;
    }

    @Override
    public BlockState toBlockState(FluidState state) {
        return MintBlocks.EBON.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == MintFluids.EBON || fluid == MintFluids.FLOWING_EBON;
    }

    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return (!world.getDimension().bedWorks() && !world.getDimension().hasCeiling()) ? 1 : 2;
    }

    @Override
    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return state.getHeight(world, pos) >= 0.44444445F && fluid.isIn(FluidTags.WATER);
    }

    @Override
    public int getTickRate(WorldView world) {
        return world.getDimension().ultrawarm() ? 10 : 30;
    }

    @Override
    public int getNextTickDelay(World world, BlockPos pos, FluidState oldState, FluidState newState) {
        int i = this.getTickRate(world);
        if (!oldState.isEmpty()
                && !newState.isEmpty()
                && !(Boolean)oldState.get(FALLING)
                && !(Boolean)newState.get(FALLING)
                && newState.getHeight(world, pos) > oldState.getHeight(world, pos)
                && world.getRandom().nextInt(4) != 0) {
            i *= 4;
        }

        return i;
    }

    private void playExtinguishEvent(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(WorldEvents.LAVA_EXTINGUISHED, pos, 0);
    }

    @Override
    protected void flow(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState) {
        if (direction == Direction.DOWN) {
            FluidState fluidState2 = world.getFluidState(pos);
            if (this.isIn(MintTags.FluidTags.EBON) && fluidState2.isIn(FluidTags.WATER)) {
                if (state.getBlock() instanceof FluidBlock) {
                    world.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState(), Block.NOTIFY_ALL);
                }

                this.playExtinguishEvent(world, pos);
                return;
            }
        }

        super.flow(world, pos, state, direction, fluidState);
    }

    @Override
    protected boolean hasRandomTicks() {
        return true;
    }


    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
    }

    public static class Flowing extends EbonFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return (Integer)state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends EbonFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
