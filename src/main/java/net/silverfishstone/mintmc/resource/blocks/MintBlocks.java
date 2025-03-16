package net.silverfishstone.mintmc.resource.blocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.silverfishstone.mintmc.MintMain;
import net.silverfishstone.mintmc.datagen.model.MintModelGens;
import net.silverfishstone.mintmc.resource.blocks.custom.EndSoilBlock;
import net.silverfishstone.mintmc.resource.items.MintItemGroups;
import net.silverfishstone.mintmc.resource.items.MintItems;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MintBlocks {

    public static final Block SOUL_COAL_BLOCK = registerBlock("soul_coal_block", Block::new, Block.Settings.copy(Blocks.COAL_BLOCK));

    public static final Block RUBY_ORE = registerBlock("ruby_ore", Block::new, Block.Settings.copy(Blocks.DIAMOND_ORE));
    public static final Block SILVER_ORE = registerBlock("silver_ore", Block::new, Block.Settings.copy(Blocks.GOLD_ORE));

    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", Block::new, Block.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE));
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", Block::new, Block.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE));

    public static final Block COBBLED_GRANITE = registerBlock("cobbled_granite", Block::new, Block.Settings.copy(Blocks.COBBLESTONE));
    public static final Block GRANITE_RUBY_ORE = registerBlock("granite_ruby_ore", Block::new, Block.Settings.copy(Blocks.DIAMOND_ORE));
    public static final Block GRANITE_SILVER_ORE = registerBlock("granite_silver_ore", Block::new, Block.Settings.copy(Blocks.GOLD_ORE));
    public static final Block GRANITE_COAL_ORE = registerBlock("granite_coal_ore", Block::new, Block.Settings.copy(Blocks.COAL_ORE));
    public static final Block GRANITE_COPPER_ORE = registerBlock("granite_copper_ore", Block::new, Block.Settings.copy(Blocks.COPPER_ORE));
    public static final Block GRANITE_IRON_ORE = registerBlock("granite_iron_ore", Block::new, Block.Settings.copy(Blocks.IRON_ORE));
    public static final Block GRANITE_GOLD_ORE = registerBlock("granite_gold_ore", Block::new, Block.Settings.copy(Blocks.GOLD_ORE));
    public static final Block GRANITE_REDSTONE_ORE = registerBlock("granite_redstone_ore", RedstoneOreBlock::new, AbstractBlock.Settings.copy(Blocks.REDSTONE_ORE));
    public static final Block GRANITE_DIAMOND_ORE = registerBlock("granite_diamond_ore", Block::new, Block.Settings.copy(Blocks.DIAMOND_ORE));
    public static final Block GRANITE_EMERALD_ORE = registerBlock("granite_emerald_ore", Block::new, Block.Settings.copy(Blocks.EMERALD_ORE));

    public static final Block LIMESTONE = registerBlock("limestone", Block::new, Block.Settings.copy(Blocks.STONE));
    public static final Block COBBLED_LIMESTONE = registerBlock("cobbled_limestone", Block::new, Block.Settings.copy(Blocks.COBBLESTONE));
    public static final Block LIMESTONE_RUBY_ORE = registerBlock("limestone_ruby_ore", Block::new, Block.Settings.copy(Blocks.DIAMOND_ORE));
    public static final Block LIMESTONE_SILVER_ORE = registerBlock("limestone_silver_ore", Block::new, Block.Settings.copy(Blocks.GOLD_ORE));
    public static final Block LIMESTONE_COAL_ORE = registerBlock("limestone_coal_ore", Block::new, Block.Settings.copy(Blocks.COAL_ORE));
    public static final Block LIMESTONE_COPPER_ORE = registerBlock("limestone_copper_ore", Block::new, Block.Settings.copy(Blocks.COPPER_ORE));
    public static final Block LIMESTONE_IRON_ORE = registerBlock("limestone_iron_ore", Block::new, Block.Settings.copy(Blocks.IRON_ORE));
    public static final Block LIMESTONE_GOLD_ORE = registerBlock("limestone_gold_ore", Block::new, Block.Settings.copy(Blocks.GOLD_ORE));
    public static final Block LIMESTONE_REDSTONE_ORE = registerBlock("limestone_redstone_ore", RedstoneOreBlock::new, AbstractBlock.Settings.copy(Blocks.REDSTONE_ORE));
    public static final Block LIMESTONE_DIAMOND_ORE = registerBlock("limestone_diamond_ore", Block::new, Block.Settings.copy(Blocks.DIAMOND_ORE));
    public static final Block LIMESTONE_EMERALD_ORE = registerBlock("limestone_emerald_ore", Block::new, Block.Settings.copy(Blocks.EMERALD_ORE));

    public static final Block ENDERIUM_ORE = registerBlock("enderium_ore", Block::new, Block.Settings.copy(Blocks.END_STONE));
    public static final Block WILD_OMELLA = registerNonCubeBlock("wild_omella", EndSoilBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_NYLIUM));
    public static final Block CORRUPTED_OMELLA = registerNonCubeBlock("corrupted_omella", EndSoilBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_NYLIUM));


    private static Block registerBlock(String id, Function<Block.Settings, Block> factory, Block.Settings settings) {
        Block block = Blocks.register(keyOf(id), factory, settings);
        Item item = registerBlockItem(block, BlockItem::new);
        MintModelGens.CUBE_ALL.add(block);
        return block;
    }

    private static Block registerNonCubeBlock(String id, Function<Block.Settings, Block> factory, Block.Settings settings) {
        Block block = Blocks.register(keyOf(id), factory, settings);
        Item item = registerBlockItem(block, BlockItem::new);
        return block;
    }

    private static Block registerBlocks(String id, Function<Block.Settings, Block> factory, Block.Settings settings) {
        Block block = Blocks.register(keyOf(id), factory, settings);
        Item item = registerBlockItem(block, BlockItem::new);
        return block;
    }

    public static Item registerBlockItem(Block block, BiFunction<Block, Item.Settings, Item> factory) {
        return Items.register(block, factory, new Item.Settings());
    }

    public static RegistryKey<Block> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MintMain.MOD_ID, id));
    }

    public static void registerBlocks() {
        MintMain.LOGGER.info("Registering {} blocks", MintMain.MOD_ID);

    }
}
