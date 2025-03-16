package net.silverfishstone.mintmc.resource.items.armor;

import com.google.common.collect.Maps;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.silverfishstone.mintmc.MintMain;

import java.util.Map;

public interface MintArmorMaterials {

    ArmorMaterial COPPER = new ArmorMaterial(
            5, createDefenseMap(1, 2, 3, 1, 3), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, ItemTags.REPAIRS_LEATHER_ARMOR, MintEquipmentAssets.COPPER
    );
    ArmorMaterial STEEL = new ArmorMaterial(
            5, createDefenseMap(1, 2, 3, 1, 3), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, ItemTags.REPAIRS_LEATHER_ARMOR, MintEquipmentAssets.STEEL
    );
    ArmorMaterial RUBY = new ArmorMaterial(
            5, createDefenseMap(1, 2, 3, 1, 3), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, ItemTags.REPAIRS_LEATHER_ARMOR, MintEquipmentAssets.RUBY
    );
    ArmorMaterial SILVER = new ArmorMaterial(
            5, createDefenseMap(1, 2, 3, 1, 3), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, ItemTags.REPAIRS_LEATHER_ARMOR, MintEquipmentAssets.ONYX
    );
    ArmorMaterial LEAD = new ArmorMaterial(
            5, createDefenseMap(1, 2, 3, 1, 3), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, ItemTags.REPAIRS_LEATHER_ARMOR, MintEquipmentAssets.ONYX
    );
    ArmorMaterial ROSE_GOLD = new ArmorMaterial(
            5, createDefenseMap(1, 2, 3, 1, 3), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, ItemTags.REPAIRS_LEATHER_ARMOR, MintEquipmentAssets.ONYX
    );
    ArmorMaterial TWILITE = new ArmorMaterial(
            5, createDefenseMap(1, 2, 3, 1, 3), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, ItemTags.REPAIRS_LEATHER_ARMOR, MintEquipmentAssets.ONYX
    );

    private static Map<EquipmentType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
        return Maps.newEnumMap(
                Map.of(
                        EquipmentType.BOOTS,
                        bootsDefense,
                        EquipmentType.LEGGINGS,
                        leggingsDefense,
                        EquipmentType.CHESTPLATE,
                        chestplateDefense,
                        EquipmentType.HELMET,
                        helmetDefense,
                        EquipmentType.BODY,
                        bodyDefense
                )
        );
    }
}
