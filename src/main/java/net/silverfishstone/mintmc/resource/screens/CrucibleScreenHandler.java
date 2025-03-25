package net.silverfishstone.mintmc.resource.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;
import net.silverfishstone.mintmc.MintMain;

public class CrucibleScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private static final int INVENTORY_SIZE = 7; // 1 fuel + 6 input + 1 output

    public CrucibleScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(8));
    }

    public CrucibleScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(MintMain.CRUCIBLE_SCREEN_HANDLER, syncId);

        // Ensure inventory has at least 8 slots
        checkSize(inventory, 8);
        this.inventory = inventory;

        // Fuel Slot (33, 67)
        this.addSlot(new Slot(inventory, 0, 33, 67));

        // 3x2 Input Grid (94, 53)
        int index = 1;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                this.addSlot(new Slot(inventory, index++, 94 + (col * 18), 53 + (row * 18)));
            }
        }

        // Output Slot (260, 60)
        this.addSlot(new FurnaceOutputSlot(playerInventory.player, inventory, index, 260, 60));

        // Player Inventory Slots
        int playerInvStartY = 84;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, playerInvStartY + row * 18));
            }
        }

        // Player Hotbar
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}