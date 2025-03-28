package net.silverfishstone.mintmc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.silverfishstone.mintmc.datagen.tags.MintTags;

import java.util.concurrent.CompletableFuture;

public class MintTagGens {

    public static class MintBlockTagGens extends FabricTagProvider.BlockTagProvider {

        public MintBlockTagGens(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(MintTags.Resources.INCORRECT_FOR_STEEL_TOOL);
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                    .addTag(MintTags.Resources.INCORRECT_FOR_STEEL_TOOL)
                    .add(Blocks.DEEPSLATE,
                            Blocks.DEEPSLATE_BRICKS,
                            Blocks.DEEPSLATE_BRICK_SLAB,
                            Blocks.DEEPSLATE_BRICK_STAIRS,
                            Blocks.DEEPSLATE_BRICK_WALL,
                            Blocks.COBBLED_DEEPSLATE_SLAB,
                            Blocks.COBBLED_DEEPSLATE_STAIRS,
                            Blocks.COBBLED_DEEPSLATE_WALL,
                            Blocks.DEEPSLATE_COAL_ORE,
                            Blocks.DEEPSLATE_EMERALD_ORE,
                            Blocks.DEEPSLATE_COPPER_ORE,
                            Blocks.DEEPSLATE_IRON_ORE,
                            Blocks.DEEPSLATE_DIAMOND_ORE,
                            Blocks.DEEPSLATE_REDSTONE_ORE,
                            Blocks.DEEPSLATE_LAPIS_ORE,
                            Blocks.DEEPSLATE_GOLD_ORE);
        }
    }

    public static class MintItemTagGens extends FabricTagProvider.ItemTagProvider {

        public MintItemTagGens(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            getOrCreateTagBuilder(MintTags.Resources.LEATHER_ARMOR)
                    .add(Items.LEATHER_BOOTS,
                            Items.LEATHER_CHESTPLATE,
                            Items.LEATHER_HELMET,
                            Items.LEATHER_LEGGINGS);
            getOrCreateTagBuilder(MintTags.Resources.GOLD_ARMOR)
                    .add(Items.GOLDEN_BOOTS,
                            Items.GOLDEN_CHESTPLATE,
                            Items.GOLDEN_HELMET,
                            Items.GOLDEN_LEGGINGS);
            getOrCreateTagBuilder(MintTags.Resources.IRON_ARMOR)
                    .add(Items.IRON_BOOTS,
                            Items.IRON_CHESTPLATE,
                            Items.IRON_HELMET,
                            Items.IRON_LEGGINGS);

            getOrCreateTagBuilder(MintTags.Resources.CHAINMAIL_ARMOR)
                    .add(Items.CHAINMAIL_BOOTS,
                            Items.CHAINMAIL_CHESTPLATE,
                            Items.CHAINMAIL_HELMET,
                            Items.CHAINMAIL_LEGGINGS);

            getOrCreateTagBuilder(MintTags.Resources.DIAMOND_ARMOR)
                    .add(Items.DIAMOND_BOOTS,
                            Items.DIAMOND_CHESTPLATE,
                            Items.DIAMOND_HELMET,
                            Items.DIAMOND_LEGGINGS);

        }
    }

    public static class MintDamageTagGens extends TagProvider<DamageType> {

        public MintDamageTagGens(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, RegistryKeys.DAMAGE_TYPE, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup registries) {
            this.getOrCreateTagBuilder(MintTags.Resources.PVP)
                    .add(DamageTypes.PLAYER_ATTACK,
                            DamageTypes.MOB_ATTACK,
                            DamageTypes.MOB_ATTACK_NO_AGGRO);
        }
    }
}
