package net.silverfishstone.mintmc.resource.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.silverfishstone.mintmc.resource.blocks.entity.CrucibleBlockEntity;
import org.jetbrains.annotations.Nullable;

public class CrucibleScreenHandlerFactory implements NamedScreenHandlerFactory {
    private final CrucibleBlockEntity blockEntity;

    public CrucibleScreenHandlerFactory(CrucibleBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.crucible");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CrucibleScreenHandler(syncId, playerInventory, blockEntity);
    }
}
