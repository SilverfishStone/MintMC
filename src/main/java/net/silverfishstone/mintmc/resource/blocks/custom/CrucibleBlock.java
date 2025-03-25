package net.silverfishstone.mintmc.resource.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.silverfishstone.mintmc.resource.blocks.entity.CrucibleBlockEntity;
import net.silverfishstone.mintmc.resource.screens.CrucibleScreenHandler;
import net.silverfishstone.mintmc.resource.screens.CrucibleScreenHandlerFactory;
import org.jetbrains.annotations.Nullable;

public class CrucibleBlock extends BlockWithEntity {
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    public CrucibleBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(ACTIVATED, false));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrucibleBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = createScreenHandlerFactory(null, world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(@Nullable BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof CrucibleBlockEntity) {
            return new CrucibleScreenHandlerFactory((CrucibleBlockEntity) blockEntity);
        }
        return null;
    }


    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }
}
