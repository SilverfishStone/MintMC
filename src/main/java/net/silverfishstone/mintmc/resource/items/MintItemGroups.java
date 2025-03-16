package net.silverfishstone.mintmc.resource.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.silverfishstone.mintmc.MintMain;

public class MintItemGroups {
    public static final RegistryKey<ItemGroup> MINTMC = register("mintmc_tab");



    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MintMain.MOD_ID, id));
    }


    public static final ItemGroup MINT_MC = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MintItems.RUBY))
            .displayName(Text.translatable("itemGroup.mint_mc"))
            .build();

}