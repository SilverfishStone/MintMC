package net.silverfishstone.mintmc.datagen.model;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.silverfishstone.mintmc.resource.blocks.MintBlocks;
import net.silverfishstone.mintmc.resource.items.MintItems;

import java.util.ArrayList;
import java.util.List;

public class MintModelGens extends FabricModelProvider {
    public static List<Block> CUBE_ALL = new ArrayList<>();
    public MintModelGens(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        CUBE_ALL.forEach(blockStateModelGenerator::registerSimpleCubeAll);
        blockStateModelGenerator.registerSimpleState(MintBlocks.EBON);
        registEndSoils(blockStateModelGenerator);

    }

    private void registEndSoils(BlockStateModelGenerator gen) {
        registerEndstoneBottomCustomTop(MintBlocks.WILD_OMELLA, gen);
        registerEndstoneBottomCustomTop(MintBlocks.CORRUPTED_OMELLA, gen);
    }

    public final void registerEndstoneBottomCustomTop(Block block, BlockStateModelGenerator gen) {
        TextureMap textureMap = new TextureMap()
                .put(TextureKey.BOTTOM, TextureMap.getId(Blocks.END_STONE))
                .put(TextureKey.TOP, TextureMap.getId(block))
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"));
        gen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, Models.CUBE_BOTTOM_TOP.upload(block, textureMap, gen.modelCollector)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(MintItems.COPPER_HELMET, Models.GENERATED);
        itemModelGenerator.register(MintItems.COPPER_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(MintItems.COPPER_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(MintItems.COPPER_BOOTS, Models.GENERATED);



        itemModelGenerator.register(MintItems.LEAD_INGOT, Models.GENERATED);
        itemModelGenerator.register(MintItems.SOUL_COAL, Models.GENERATED);



        itemModelGenerator.register(MintItems.SILVER_AXE, Models.HANDHELD);
        itemModelGenerator.register(MintItems.SILVER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(MintItems.SILVER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MintItems.SILVER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MintItems.SILVER_HOE, Models.HANDHELD);

        itemModelGenerator.register(MintItems.RAW_SILVER, Models.GENERATED);
        itemModelGenerator.register(MintItems.SILVER_INGOT, Models.GENERATED);
        itemModelGenerator.register(MintItems.SILVER_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(MintItems.SILVER_BOOTS, Models.GENERATED);
        itemModelGenerator.register(MintItems.SILVER_HELMET, Models.GENERATED);
        itemModelGenerator.register(MintItems.SILVER_LEGGINGS, Models.GENERATED);



        itemModelGenerator.register(MintItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MintItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(MintItems.RUBY_HOE, Models.HANDHELD);
        itemModelGenerator.register(MintItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MintItems.RUBY_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(MintItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(MintItems.RUBY_BOOTS, Models.GENERATED);
        itemModelGenerator.register(MintItems.RUBY_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(MintItems.RUBY_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(MintItems.RUBY_HELMET, Models.GENERATED);



        itemModelGenerator.register(MintItems.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MintItems.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(MintItems.STEEL_HOE, Models.HANDHELD);
        itemModelGenerator.register(MintItems.STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MintItems.STEEL_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(MintItems.STEEL_SCRAP, Models.GENERATED);
        itemModelGenerator.register(MintItems.STEEL_ROD, Models.HANDHELD);
        itemModelGenerator.register(MintItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(MintItems.STEEL_BOOTS, Models.GENERATED);
        itemModelGenerator.register(MintItems.STEEL_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(MintItems.STEEL_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(MintItems.STEEL_HELMET, Models.GENERATED);



        itemModelGenerator.register(MintItems.TWILITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MintItems.TWILITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(MintItems.TWILITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(MintItems.TWILITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MintItems.TWILITE_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(MintItems.TWILITE, Models.GENERATED);
        itemModelGenerator.register(MintItems.TWILITE_BOOTS, Models.GENERATED);
        itemModelGenerator.register(MintItems.TWILITE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(MintItems.TWILITE_HELMET, Models.GENERATED);
        itemModelGenerator.register(MintItems.TWILITE_LEGGINGS, Models.GENERATED);



        itemModelGenerator.register(MintItems.ROSE_GOLD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MintItems.ROSE_GOLD_AXE, Models.HANDHELD);
        itemModelGenerator.register(MintItems.ROSE_GOLD_HOE, Models.HANDHELD);
        itemModelGenerator.register(MintItems.ROSE_GOLD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MintItems.ROSE_GOLD_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(MintItems.ROSE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(MintItems.ROSE_GOLD_BOOTS, Models.GENERATED);
        itemModelGenerator.register(MintItems.ROSE_GOLD_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(MintItems.ROSE_GOLD_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(MintItems.ROSE_GOLD_HELMET, Models.GENERATED);
    }
}



