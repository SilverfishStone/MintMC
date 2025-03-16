package net.silverfishstone.mintmc.resource.items.armor;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.silverfishstone.mintmc.MintMain;

public interface MintEquipmentAssets {

    RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    RegistryKey<EquipmentAsset> COPPER = register("copper");
    RegistryKey<EquipmentAsset> STEEL = register("steel");
    RegistryKey<EquipmentAsset> RUBY = register("ruby");
    RegistryKey<EquipmentAsset> ONYX = register("onyx");
    RegistryKey<EquipmentAsset> FLORIUM = register("florium");
    RegistryKey<EquipmentAsset> ENDERIUM = register("enderium");

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(REGISTRY_KEY, Identifier.of(MintMain.MOD_ID, name));
    }
}
