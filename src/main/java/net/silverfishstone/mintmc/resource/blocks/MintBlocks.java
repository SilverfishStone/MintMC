package net.silverfishstone.mintmc.resource.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.silverfishstone.mintmc.MintMain;
import net.silverfishstone.mintmc.datagen.model.MintModelGens;
import net.silverfishstone.mintmc.resource.blocks.custom.EbonFluidBlock;
import net.silverfishstone.mintmc.resource.blocks.custom.EndSoilBlock;
import net.silverfishstone.mintmc.resource.fluids.MintFluids;
import net.silverfishstone.mintmc.resource.items.MintItems;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MintBlocks {

    public static final Block SOUL_COAL_BLOCK = registerBlock("soul_coal_block",
            new Block(Block.Settings.copy(Blocks.COAL_BLOCK)));

    // Ores
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new Block(Block.Settings.copy(Blocks.DIAMOND_ORE)));
    public static final Block SILVER_ORE = registerBlock("silver_ore",
            new Block(Block.Settings.copy(Blocks.GOLD_ORE)));

    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new Block(Block.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            new Block(Block.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    // Granite Blocks
    public static final Block COBBLED_GRANITE = registerBlock("cobbled_granite",
            new Block(Block.Settings.copy(Blocks.COBBLESTONE)));
    public static final Block GRANITE_RUBY_ORE = registerBlock("granite_ruby_ore",
            new Block(Block.Settings.copy(Blocks.DIAMOND_ORE)));
    public static final Block GRANITE_SILVER_ORE = registerBlock("granite_silver_ore",
            new Block(Block.Settings.copy(Blocks.GOLD_ORE)));
    public static final Block GRANITE_COAL_ORE = registerBlock("granite_coal_ore",
            new Block(Block.Settings.copy(Blocks.COAL_ORE)));
    public static final Block GRANITE_COPPER_ORE = registerBlock("granite_copper_ore",
            new Block(Block.Settings.copy(Blocks.COPPER_ORE)));
    public static final Block GRANITE_IRON_ORE = registerBlock("granite_iron_ore",
            new Block(Block.Settings.copy(Blocks.IRON_ORE)));
    public static final Block GRANITE_GOLD_ORE = registerBlock("granite_gold_ore",
            new Block(Block.Settings.copy(Blocks.GOLD_ORE)));
    public static final Block GRANITE_REDSTONE_ORE = registerBlock("granite_redstone_ore",
            new RedstoneOreBlock(AbstractBlock.Settings.copy(Blocks.REDSTONE_ORE)));
    public static final Block GRANITE_DIAMOND_ORE = registerBlock("granite_diamond_ore",
            new Block(Block.Settings.copy(Blocks.DIAMOND_ORE)));
    public static final Block GRANITE_EMERALD_ORE = registerBlock("granite_emerald_ore",
            new Block(Block.Settings.copy(Blocks.EMERALD_ORE)));

<<<<<<< Updated upstream
<<<<<<< Updated upstream
    // Crucible
    public static final Block CRUCIBLE = registerBlock("crucible",
            new CrucibleBlock(Block.Settings.copy(Blocks.STONE)));

    public static final BlockEntityType<CrucibleBlockEntity> CRUCIBLE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,
                    Identifier.of("mintmc", "crucible_entity"),
                    FabricBlockEntityTypeBuilder.create(CrucibleBlockEntity::new, CRUCIBLE).build());

    // Limestone Blocks
    public static final Block LIMESTONE = registerBlock("limestone",
            new Block(Block.Settings.copy(Blocks.STONE)));
    public static final Block COBBLED_LIMESTONE = registerBlock("cobbled_limestone",
            new Block(Block.Settings.copy(Blocks.COBBLESTONE)));
    public static final Block LIMESTONE_RUBY_ORE = registerBlock("limestone_ruby_ore",
            new Block(Block.Settings.copy(Blocks.DIAMOND_ORE)));
    public static final Block LIMESTONE_SILVER_ORE = registerBlock("limestone_silver_ore",
            new Block(Block.Settings.copy(Blocks.GOLD_ORE)));
    public static final Block LIMESTONE_COAL_ORE = registerBlock("limestone_coal_ore",
            new Block(Block.Settings.copy(Blocks.COAL_ORE)));
    public static final Block LIMESTONE_COPPER_ORE = registerBlock("limestone_copper_ore",
            new Block(Block.Settings.copy(Blocks.COPPER_ORE)));
    public static final Block LIMESTONE_IRON_ORE = registerBlock("limestone_iron_ore",
            new Block(Block.Settings.copy(Blocks.IRON_ORE)));
    public static final Block LIMESTONE_GOLD_ORE = registerBlock("limestone_gold_ore",
            new Block(Block.Settings.copy(Blocks.GOLD_ORE)));
    public static final Block LIMESTONE_REDSTONE_ORE = registerBlock("limestone_redstone_ore",
            new RedstoneOreBlock(AbstractBlock.Settings.copy(Blocks.REDSTONE_ORE)));
    public static final Block LIMESTONE_DIAMOND_ORE = registerBlock("limestone_diamond_ore",
            new Block(Block.Settings.copy(Blocks.DIAMOND_ORE)));
    public static final Block LIMESTONE_EMERALD_ORE = registerBlock("limestone_emerald_ore",
            new Block(Block.Settings.copy(Blocks.EMERALD_ORE)));
=======
=======
>>>>>>> Stashed changes
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
>>>>>>> Stashed changes

    // Special Blocks
    public static final Block ENDERIUM_ORE = registerBlock("enderium_ore",
            new Block(Block.Settings.copy(Blocks.END_STONE)));
    public static final Block WILD_OMELLA = registerNonCubeBlock("wild_omella",
            new EndSoilBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_NYLIUM)));
    public static final Block CORRUPTED_OMELLA = registerNonCubeBlock("corrupted_omella",
            new EndSoilBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_NYLIUM)));

    public static final Block EBON = registerNonCubeBlock("ebon",
            new EbonFluidBlock(MintFluids.EBON, AbstractBlock.Settings.copy(Blocks.WATER)));
    public static final Block EBON_ICE = registerBlock("ebon_ice",
            new TransparentBlock(Block.Settings.copy(Blocks.HONEY_BLOCK).mapColor(MapColor.BLUE)));
    public static final Block NEW_BLOCK = registerBlock("new_block",
            new Block(Block.Settings.copy(Blocks.OBSIDIAN)));


    private static Block registerBlock(String id, Block b) {
        Block block = Blocks.register(id, b);
        Item item = registerBlockItem(block, id);
        MintModelGens.CUBE_ALL.add(block);
        return block;
    }

    private static Block registerNonCubeBlock(String id, Block b) {
        Block block = Blocks.register(id, b);
        Item item = registerBlockItem(block, id);
        return block;
    }

    private static Block registerBlocks(String id, Block b) {
        Block block = Blocks.register(id, b);
        Item item = registerBlockItem(block, id);
        return block;
    }

    public static Item registerBlockItem(Block block, String id) {
        return MintItems.registerItem(id, new BlockItem(block, new Item.Settings()));
    }

    public static String keyOf(String id) {
        return String.valueOf(Identifier.of(MintMain.MOD_ID, id));
    }

    public static void registerBlocks() {
        MintMain.LOGGER.info("Registering {} blocks", MintMain.MOD_ID);
    }
}
