package net.silverfishstone.mintmc.datagen.tags;

import net.minecraft.block.Block;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.silverfishstone.mintmc.MintMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MintTags {
    public static final HashMap<TagKey<Item>, Integer> ITEM_ARMOR_TAGS = new HashMap<>();

    private static final RegistryKey<Registry<DamageType>> DAMAGE_TYPE = RegistryKeys.DAMAGE_TYPE;
    private static final RegistryKey<Registry<Biome>> BIOME = RegistryKeys.BIOME;
    private static final RegistryKey<Registry<Item>> ITEM = RegistryKeys.ITEM;
    private static final RegistryKey<Registry<Block>> BLOCK = RegistryKeys.BLOCK;

    public static class GeneralTagGen {
        // example class to register multiple tag types in one class. I may or may not use this later.
        public static final TagKey<Item> EXAMPLE = createTag("example", ITEM);
    }

    public static class WorldGen {
        public static final TagKey<Biome> CONIFER = createBiomeTag("conifer");

        private static TagKey<Biome> createBiomeTag(String name) {
            return createTag(name, BIOME);
        }
    }
    public static class Resources {
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = createBlockTag("incorrect_for_steel_tool");

        private static TagKey<Block> createBlockTag(String name) {
            return createTag(name, BLOCK);
        }

        public static final TagKey<Item> LEATHER_ARMOR = createItemTagToList("leather_armor");
        public static final TagKey<Item> COPPER_ARMOR = createItemTagToList("copper_armor");
        public static final TagKey<Item> GOLD_ARMOR = createItemTagToList("gold_armor");
        public static final TagKey<Item> IRON_ARMOR = createItemTagToList("iron_armor");
        public static final TagKey<Item> CHAINMAIL_ARMOR = createItemTagToList("chainmail_armor");
        public static final TagKey<Item> DIAMOND_ARMOR = createItemTagToList("diamond_armor");

        private static TagKey<Item> createItemTagToList(String name) {
            TagKey<Item> tag = createItemTag(name);
            return tag;
        }

        private static TagKey<Item> createItemTag(String name) {
            return createTag(name, ITEM);
        }

        public static final TagKey<DamageType> PVP = createDamageTypeTag("pvp");

        private static TagKey<DamageType> createDamageTypeTag(String name) {
            return createTag(name, DAMAGE_TYPE);
        }
    }

    public final class FluidTags {
        public static final TagKey<Fluid> EBON = of("ebon");

        private static TagKey<Fluid> of(String id) {
            return createTag(id, RegistryKeys.FLUID);
        }
    }

    private static <V> TagKey<V> createTag (String name, RegistryKey<Registry<V>> key) {
        return TagKey.of(key, Identifier.of(MintMain.MOD_ID, name));
    }
}

