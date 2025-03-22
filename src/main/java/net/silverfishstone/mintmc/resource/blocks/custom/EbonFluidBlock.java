package net.silverfishstone.mintmc.resource.blocks.custom;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.block.WireOrientation;
import net.silverfishstone.mintmc.datagen.tags.MintTags;
import net.silverfishstone.mintmc.resource.blocks.MintBlocks;
import org.jetbrains.annotations.Nullable;

public class EbonFluidBlock extends FluidBlock implements FluidDrainable {
    public EbonFluidBlock(FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    protected boolean isTransparent(BlockState state) {
        return true;
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return !this.fluid.isIn(MintTags.FluidTags.EBON);
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (this.receiveNeighborFluids(world, pos, state)) {
            world.scheduleFluidTick(pos, state.getFluidState().getFluid(), this.fluid.getTickRate(world));
        }
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        if (this.receiveNeighborFluids(world, pos, state)) {
            world.scheduleFluidTick(pos, state.getFluidState().getFluid(), this.fluid.getTickRate(world));
        }
    }

    private boolean receiveNeighborFluids(World world, BlockPos pos, BlockState state) {
        if (this.fluid.isIn(FluidTags.WATER)) {
            for (Direction direction : FLOW_DIRECTIONS) {
                BlockPos blockPos = pos.offset(direction.getOpposite());
                if (world.getFluidState(blockPos).isIn(MintTags.FluidTags.EBON)) {
                    Block block = world.getFluidState(pos).isStill() ? Blocks.PACKED_ICE : Blocks.ICE;
                    world.setBlockState(pos, block.getDefaultState());
                    this.playExtinguishSound(world, pos);
                    return false;
                }
            }
        }
        if (this.fluid.isIn(FluidTags.LAVA)) {
            for (Direction direction : FLOW_DIRECTIONS) {
                BlockPos blockPos = pos.offset(direction.getOpposite());
                if (world.getFluidState(blockPos).isIn(MintTags.FluidTags.EBON)) {
                    Block block = world.getFluidState(pos).isStill() ? MintBlocks.NEW_BLOCK : Blocks.OBSIDIAN;
                    world.setBlockState(pos, block.getDefaultState());
                    this.playExtinguishSound(world, pos);
                    return false;
                }
            }
        }

        return true;
    }
    private void playExtinguishSound(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(WorldEvents.LAVA_EXTINGUISHED, pos, 0);
    }
}
