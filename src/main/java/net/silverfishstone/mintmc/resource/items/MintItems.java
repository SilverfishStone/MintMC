package net.silverfishstone.mintmc.resource.items;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.silverfishstone.mintmc.MintMain;
import net.silverfishstone.mintmc.datagen.model.MintModelGens;
import net.silverfishstone.mintmc.resource.items.armor.MintArmorMaterials;
import net.silverfishstone.mintmc.resource.items.tool.MintToolMaterial;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MintItems {
    static List<Item> ITEMS = new ArrayList<>();

    public static final Item SOUL_COAL = registerItem("soul_coal", new Item(new Item.Settings()), new Item.Settings());

    // Copper Armor
    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            new ArmorItem(MintArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Settings()), new Item.Settings());
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            new ArmorItem(MintArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Settings()), new Item.Settings());
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            new ArmorItem(MintArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Settings()), new Item.Settings());
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            new ArmorItem(MintArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Settings()), new Item.Settings());

    // Steel Tools and Armor
    public static final Item STEEL_SWORD = registerItem("steel_sword",
            new SwordItem(MintToolMaterial.STEEL, 3, -2.4f, new Item.Settings()), new Item.Settings());
    public static final Item STEEL_AXE = registerItem("steel_axe",
            new AxeItem(MintToolMaterial.STEEL, 5.0f, -3.1f, new Item.Settings()), new Item.Settings());
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe",
            new PickaxeItem(MintToolMaterial.STEEL, 1, -2.8f, new Item.Settings()), new Item.Settings());
    public static final Item STEEL_SHOVEL = registerItem("steel_shovel",
            new ShovelItem(MintToolMaterial.STEEL, 1.5f, -3.0f, new Item.Settings()), new Item.Settings());
    public static final Item STEEL_HOE = registerItem("steel_hoe",
            new HoeItem(MintToolMaterial.STEEL, -1, -2.0f, new Item.Settings()), new Item.Settings());

    public static final Item STEEL_SCRAP = registerItem("steel_scrap",
            new Item(new Item.Settings()), new Item.Settings());
    public static final Item STEEL_ROD = registerItem("steel_rod",
            new Item(new Item.Settings()), new Item.Settings());
    public static final Item STEEL_INGOT = registerItem("steel_ingot",
            new Item(new Item.Settings()), new Item.Settings());
    public static final Item STEEL_HELMET = registerItem("steel_helmet",
            new ArmorItem(MintArmorMaterials.STEEL, ArmorItem.Type.HELMET, new Item.Settings()), new Item.Settings());
    public static final Item STEEL_CHESTPLATE = registerItem("steel_chestplate",
            new ArmorItem(MintArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Settings()), new Item.Settings());
    public static final Item STEEL_LEGGINGS = registerItem("steel_leggings",
            new ArmorItem(MintArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new Item.Settings()), new Item.Settings());
    public static final Item STEEL_BOOTS = registerItem("steel_boots",
            new ArmorItem(MintArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new Item.Settings()), new Item.Settings());

    // Ruby Tools and Armor
    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(MintToolMaterial.STEEL, 3, -2.4f, new Item.Settings()), new Item.Settings());
    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new AxeItem(MintToolMaterial.STEEL, 5.0f, -3.1f, new Item.Settings()), new Item.Settings());
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(MintToolMaterial.STEEL, 1, -2.8f, new Item.Settings()), new Item.Settings());
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(MintToolMaterial.STEEL, 1.5f, -3.0f, new Item.Settings()), new Item.Settings());
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new HoeItem(MintToolMaterial.STEEL, -1, -2.0f, new Item.Settings()), new Item.Settings());

    public static final Item RUBY = registerItem("ruby",
            new Item(new Item.Settings()), new Item.Settings());
    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ArmorItem(MintArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Settings()), new Item.Settings());
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(MintArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Settings()), new Item.Settings());
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(MintArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Settings()), new Item.Settings());
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(MintArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Settings()), new Item.Settings());

    // Silver Tools and Armor
    public static final Item SILVER_SWORD = registerItem("silver_sword",
            new SwordItem(MintToolMaterial.STEEL, 3, -2.4f, new Item.Settings()), new Item.Settings());
    public static final Item SILVER_AXE = registerItem("silver_axe",
            new AxeItem(MintToolMaterial.STEEL, 5.0f, -3.1f, new Item.Settings()), new Item.Settings());
    public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe",
            new PickaxeItem(MintToolMaterial.STEEL, 1, -2.8f, new Item.Settings()), new Item.Settings());
    public static final Item SILVER_SHOVEL = registerItem("silver_shovel",
            new ShovelItem(MintToolMaterial.STEEL, 1.5f, -3.0f, new Item.Settings()), new Item.Settings());
    public static final Item SILVER_HOE = registerItem("silver_hoe",
            new HoeItem(MintToolMaterial.STEEL, -1, -2.0f, new Item.Settings()), new Item.Settings());

    public static final Item RAW_SILVER = registerItem("raw_silver",
            new Item(new Item.Settings()), new Item.Settings());
    public static final Item SILVER_INGOT = registerItem("silver_ingot",
            new Item(new Item.Settings()), new Item.Settings());
    public static final Item SILVER_HELMET = registerItem("silver_helmet",
            new ArmorItem(MintArmorMaterials.SILVER, ArmorItem.Type.HELMET, new Item.Settings()), new Item.Settings());
    public static final Item SILVER_CHESTPLATE = registerItem("silver_chestplate",
            new ArmorItem(MintArmorMaterials.SILVER, ArmorItem.Type.CHESTPLATE, new Item.Settings()), new Item.Settings());
    public static final Item SILVER_LEGGINGS = registerItem("silver_leggings",
            new ArmorItem(MintArmorMaterials.SILVER, ArmorItem.Type.LEGGINGS, new Item.Settings()), new Item.Settings());
    public static final Item SILVER_BOOTS = registerItem("silver_boots",
            new ArmorItem(MintArmorMaterials.SILVER, ArmorItem.Type.BOOTS, new Item.Settings()), new Item.Settings());

    // Rose Gold Tools and Armor
    public static final Item ROSE_GOLD_SWORD = registerItem("rose_gold_sword",
            new SwordItem(MintToolMaterial.STEEL, 3, -2.4f, new Item.Settings()), new Item.Settings());
    public static final Item ROSE_GOLD_AXE = registerItem("rose_gold_axe",
            new AxeItem(MintToolMaterial.STEEL, 5.0f, -3.1f, new Item.Settings()), new Item.Settings());
    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe",
            new PickaxeItem(MintToolMaterial.STEEL, 1, -2.8f, new Item.Settings()), new Item.Settings());
    public static final Item ROSE_GOLD_SHOVEL = registerItem("rose_gold_shovel",
            new ShovelItem(MintToolMaterial.STEEL, 1.5f, -3.0f, new Item.Settings()), new Item.Settings());
    public static final Item ROSE_GOLD_HOE = registerItem("rose_gold_hoe",
            new HoeItem(MintToolMaterial.STEEL, -1, -2.0f, new Item.Settings()), new Item.Settings());

    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
            new Item(new Item.Settings()), new Item.Settings());
    public static final Item ROSE_GOLD_HELMET = registerItem("rose_gold_helmet",
            new ArmorItem(MintArmorMaterials.ROSE_GOLD, ArmorItem.Type.HELMET, new Item.Settings()), new Item.Settings());
    public static final Item ROSE_GOLD_CHESTPLATE = registerItem("rose_gold_chestplate",
            new ArmorItem(MintArmorMaterials.ROSE_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Settings()), new Item.Settings());
    public static final Item ROSE_GOLD_LEGGINGS = registerItem("rose_gold_leggings",
            new ArmorItem(MintArmorMaterials.ROSE_GOLD, ArmorItem.Type.LEGGINGS, new Item.Settings()), new Item.Settings());
    public static final Item ROSE_GOLD_BOOTS = registerItem("rose_gold_boots",
            new ArmorItem(MintArmorMaterials.ROSE_GOLD, ArmorItem.Type.BOOTS, new Item.Settings()), new Item.Settings());

    // Lead
    public static final Item LEAD_INGOT = registerItem("lead_ingot",
            new Item(new Item.Settings()), new Item.Settings());

    // Twilite Tools and Armor
    public static final Item TWILITE_SWORD = registerItem("twilite_sword",
            new SwordItem(MintToolMaterial.STEEL, 3, -2.4f, new Item.Settings()), new Item.Settings());
    public static final Item TWILITE_AXE = registerItem("twilite_axe",
            new AxeItem(MintToolMaterial.STEEL, 5.0f, -3.1f, new Item.Settings()), new Item.Settings());
    public static final Item TWILITE_PICKAXE = registerItem("twilite_pickaxe",
            new PickaxeItem(MintToolMaterial.STEEL, 1, -2.8f, new Item.Settings()), new Item.Settings());
    public static final Item TWILITE_SHOVEL = registerItem("twilite_shovel",
            new ShovelItem(MintToolMaterial.STEEL, 1.5f, -3.0f, new Item.Settings()), new Item.Settings());
    public static final Item TWILITE_HOE = registerItem("twilite_hoe",
            new HoeItem(MintToolMaterial.STEEL, -1, -2.0f, new Item.Settings()), new Item.Settings());

    public static final Item TWILITE = registerItem("twilite_ingot",
            new Item(new Item.Settings()), new Item.Settings());
    public static final Item TWILITE_HELMET = registerItem("twilite_helmet",
            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new Item.Settings()), new Item.Settings());
    public static final Item TWILITE_CHESTPLATE = registerItem("twilite_chestplate",
            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings()), new Item.Settings());
    public static final Item TWILITE_LEGGINGS = registerItem("twilite_leggings",
            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Settings()), new Item.Settings());
    public static final Item TWILITE_BOOTS = registerItem("twilite_boots",
            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS, new Item.Settings()), new Item.Settings());

    public static final Item EBON_BUCKET = registerItem("ebon_bucket",
            new BucketItem(Fluids.WATER, new Item.Settings()), new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1));


    private static Item registerItem(String id, Item i, Item.Settings settings) {
        Item item = Items.register(keyOf(id), i);
        ITEMS.add(item);
        return item;
    }

    public static Item registerItem(String id, Item item) {
        return Items.register(id, item);
    }

    public static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MintMain.MOD_ID, id));
    }

    public static void registerItems () {
        MintMain.LOGGER.info("Registering {} items", MintMain.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {

            entries.add(MintItems.COPPER_HELMET);
            entries.add(MintItems.COPPER_CHESTPLATE);
            entries.add(MintItems.COPPER_LEGGINGS);
            entries.add(MintItems.COPPER_BOOTS);

            entries.add(MintItems.STEEL_INGOT);
            entries.add(MintItems.STEEL_HELMET);
            entries.add(MintItems.STEEL_CHESTPLATE);
            entries.add(MintItems.STEEL_LEGGINGS);
            entries.add(MintItems.STEEL_BOOTS);

            entries.add(MintItems.RUBY);
            entries.add(MintItems.RUBY_HELMET);
            entries.add(MintItems.RUBY_CHESTPLATE);
            entries.add(MintItems.RUBY_LEGGINGS);
            entries.add(MintItems.RUBY_BOOTS);

            entries.add(MintItems.SILVER_INGOT);
            entries.add(MintItems.SILVER_HELMET);
            entries.add(MintItems.SILVER_CHESTPLATE);
            entries.add(MintItems.SILVER_LEGGINGS);
            entries.add(MintItems.SILVER_BOOTS);

            entries.add(MintItems.LEAD_INGOT);
        });

        Registry.register(Registries.ITEM_GROUP, MintItemGroups.MINTMC, MintItemGroups.MINT_MC);

        ItemGroupEvents.modifyEntriesEvent(MintItemGroups.MINTMC).register(entries -> {
            ITEMS.forEach(entries::add);
            MintModelGens.CUBE_ALL.forEach(entries::add);
        });
    }
}
