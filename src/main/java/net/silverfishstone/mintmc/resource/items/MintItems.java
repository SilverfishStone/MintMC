package net.silverfishstone.mintmc.resource.items;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.silverfishstone.mintmc.MintMain;
import net.silverfishstone.mintmc.datagen.model.MintModelGens;
import net.silverfishstone.mintmc.resource.blocks.MintBlocks;
import net.silverfishstone.mintmc.resource.items.armor.MintArmorMaterials;
import net.silverfishstone.mintmc.resource.items.tool.MintToolMaterial;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MintItems {
    static List<Item> ITEMS = new ArrayList<>();

    public static final Item SOUL_COAL = registerItem("soul_coal", Item::new, new Item.Settings());

    public static final Item COPPER_HELMET = registerItem("copper_helmet", Item::new, new Item.Settings().armor(MintArmorMaterials.COPPER, EquipmentType.HELMET));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", Item::new, new Item.Settings().armor(MintArmorMaterials.COPPER, EquipmentType.CHESTPLATE));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", Item::new, new Item.Settings().armor(MintArmorMaterials.COPPER, EquipmentType.LEGGINGS));
    public static final Item COPPER_BOOTS = registerItem("copper_boots", Item::new, new Item.Settings().armor(MintArmorMaterials.COPPER, EquipmentType.BOOTS));



    public static final Item STEEL_SWORD = registerItem("steel_sword", Item::new, new Item.Settings().sword(MintToolMaterial.STEEL, 3.0F, -2.4F));
    public static final Item STEEL_AXE = registerItem("steel_axe", settings -> new AxeItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe", Item::new, new Item.Settings().pickaxe(MintToolMaterial.STEEL, 3.0F, -2.4F));
    public static final Item STEEL_SHOVEL = registerItem("steel_shovel", settings -> new ShovelItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));
    public static final Item STEEL_HOE = registerItem("steel_hoe", settings -> new HoeItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));

    public static final Item STEEL_SCRAP = registerItem("steel_scrap", Item::new, new Item.Settings());
    public static final Item STEEL_ROD = registerItem("steel_rod", Item::new, new Item.Settings());
    public static final Item STEEL_INGOT = registerItem("steel_ingot", Item::new, new Item.Settings());
    public static final Item STEEL_HELMET = registerItem("steel_helmet", Item::new, new Item.Settings().armor(MintArmorMaterials.STEEL, EquipmentType.HELMET));
    public static final Item STEEL_CHESTPLATE = registerItem("steel_chestplate", Item::new, new Item.Settings().armor(MintArmorMaterials.STEEL, EquipmentType.CHESTPLATE));
    public static final Item STEEL_LEGGINGS = registerItem("steel_leggings", Item::new, new Item.Settings().armor(MintArmorMaterials.STEEL, EquipmentType.LEGGINGS));
    public static final Item STEEL_BOOTS = registerItem("steel_boots", Item::new, new Item.Settings().armor(MintArmorMaterials.STEEL, EquipmentType.BOOTS));



    public static final Item RUBY_SWORD = registerItem("ruby_sword", Item::new, new Item.Settings().sword(MintToolMaterial.STEEL, 3.0F, -2.4F));
    public static final Item RUBY_AXE = registerItem("ruby_axe", settings -> new AxeItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", Item::new, new Item.Settings().pickaxe(MintToolMaterial.STEEL, 3.0F, -2.4F));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", settings -> new ShovelItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", settings -> new HoeItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));

    public static final Item RUBY = registerItem("ruby", Item::new, new Item.Settings());
    public static final Item RUBY_HELMET = registerItem("ruby_helmet", Item::new, new Item.Settings().armor(MintArmorMaterials.RUBY, EquipmentType.HELMET));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate", Item::new, new Item.Settings().armor(MintArmorMaterials.RUBY, EquipmentType.CHESTPLATE));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings", Item::new, new Item.Settings().armor(MintArmorMaterials.RUBY, EquipmentType.LEGGINGS));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots", Item::new, new Item.Settings().armor(MintArmorMaterials.RUBY, EquipmentType.BOOTS));



    public static final Item SILVER_SWORD = registerItem("silver_sword", Item::new, new Item.Settings().sword(MintToolMaterial.STEEL, 3.0F, -2.4F));
    public static final Item SILVER_AXE = registerItem("silver_axe", settings -> new AxeItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));
    public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe", Item::new, new Item.Settings().pickaxe(MintToolMaterial.STEEL, 3.0F, -2.4F));
    public static final Item SILVER_SHOVEL = registerItem("silver_shovel", settings -> new ShovelItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));
    public static final Item SILVER_HOE = registerItem("silver_hoe", settings -> new HoeItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));

    public static final Item RAW_SILVER = registerItem("raw_silver", Item::new, new Item.Settings());
    public static final Item SILVER_INGOT = registerItem("silver_ingot", Item::new, new Item.Settings());
    public static final Item SILVER_HELMET = registerItem("silver_helmet", Item::new, new Item.Settings().armor(MintArmorMaterials.SILVER, EquipmentType.HELMET));
    public static final Item SILVER_CHESTPLATE = registerItem("silver_chestplate", Item::new, new Item.Settings().armor(MintArmorMaterials.SILVER, EquipmentType.CHESTPLATE));
    public static final Item SILVER_LEGGINGS = registerItem("silver_leggings", Item::new, new Item.Settings().armor(MintArmorMaterials.SILVER, EquipmentType.LEGGINGS));
    public static final Item SILVER_BOOTS = registerItem("silver_boots", Item::new, new Item.Settings().armor(MintArmorMaterials.SILVER, EquipmentType.BOOTS));



    public static final Item ROSE_GOLD_SWORD = registerItem("rose_gold_sword", Item::new, new Item.Settings().sword(MintToolMaterial.STEEL, 3.0F, -2.4F));
    public static final Item ROSE_GOLD_AXE = registerItem("rose_gold_axe", settings -> new AxeItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));
    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe", Item::new, new Item.Settings().pickaxe(MintToolMaterial.STEEL, 3.0F, -2.4F));
    public static final Item ROSE_GOLD_SHOVEL = registerItem("rose_gold_shovel", settings -> new ShovelItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));
    public static final Item ROSE_GOLD_HOE = registerItem("rose_gold_hoe", settings -> new HoeItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));

    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", Item::new, new Item.Settings());
    public static final Item ROSE_GOLD_HELMET = registerItem("rose_gold_helmet", Item::new, new Item.Settings().armor(MintArmorMaterials.ROSE_GOLD, EquipmentType.HELMET));
    public static final Item ROSE_GOLD_CHESTPLATE = registerItem("rose_gold_chestplate", Item::new, new Item.Settings().armor(MintArmorMaterials.ROSE_GOLD, EquipmentType.CHESTPLATE));
    public static final Item ROSE_GOLD_LEGGINGS = registerItem("rose_gold_leggings", Item::new, new Item.Settings().armor(MintArmorMaterials.ROSE_GOLD, EquipmentType.LEGGINGS));
    public static final Item ROSE_GOLD_BOOTS = registerItem("rose_gold_boots", Item::new, new Item.Settings().armor(MintArmorMaterials.ROSE_GOLD, EquipmentType.BOOTS));



    public static final Item LEAD_INGOT = registerItem("lead_ingot", Item::new, new Item.Settings());



    public static final Item TWILITE_SWORD = registerItem("twilite_sword", Item::new, new Item.Settings().sword(MintToolMaterial.STEEL, 3.0F, -2.4F));
    public static final Item TWILITE_AXE = registerItem("twilite_axe", settings -> new AxeItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));
    public static final Item TWILITE_PICKAXE = registerItem("twilite_pickaxe", Item::new, new Item.Settings().pickaxe(MintToolMaterial.STEEL, 3.0F, -2.4F));
    public static final Item TWILITE_SHOVEL = registerItem("twilite_shovel", settings -> new ShovelItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));
    public static final Item TWILITE_HOE = registerItem("twilite_hoe", settings -> new HoeItem(MintToolMaterial.STEEL, 3.0F, -2.4F, settings));

    public static final Item TWILITE = registerItem("twilite_ingot", Item::new, new Item.Settings());
    public static final Item TWILITE_HELMET = registerItem("twilite_helmet", Item::new, new Item.Settings().armor(ArmorMaterials.NETHERITE, EquipmentType.HELMET));
    public static final Item TWILITE_CHESTPLATE = registerItem("twilite_chestplate", Item::new, new Item.Settings().armor(ArmorMaterials.NETHERITE, EquipmentType.CHESTPLATE));
    public static final Item TWILITE_LEGGINGS = registerItem("twilite_leggings", Item::new, new Item.Settings().armor(ArmorMaterials.NETHERITE, EquipmentType.LEGGINGS));
    public static final Item TWILITE_BOOTS = registerItem("twilite_boots", Item::new, new Item.Settings().armor(ArmorMaterials.NETHERITE, EquipmentType.BOOTS));




    private static Item registerItem(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = Items.register(keyOf(id), factory, settings);
        ITEMS.add(item);
        return item;
    }

    public static Item registerItem(String id, Function<Item.Settings, Item> factory) {
        return Items.register(keyOf(id), factory, new Item.Settings());
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
