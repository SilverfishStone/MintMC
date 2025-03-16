package net.silverfishstone.mintmc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class MintRecipeGens extends FabricRecipeProvider {
    public MintRecipeGens(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                this.createShaped(RecipeCategory.MISC, Items.BONE)
                        .input('B', Items.BONE)
                        .input('D', Items.DIAMOND)
                        .pattern("BBB")
                        .pattern("BDB")
                        .pattern("BBB")
                        .criterion(hasItem(Items.BONE), this.conditionsFromItem(Items.BONE))
                        .offerTo(exporter);
            }
        };
    }

    private void woodRecipes (RecipeExporter exporter, RecipeGenerator gen, Block planks, Block log, Block strippedLog, TagKey<Item> logs, Block wood, Block strippedWood, Block stairs, Block slab, Block fence, Block gate, Block door, Block trapdoor, Block button, Block pressurePlate) {
        gen.offerBarkBlockRecipe(wood, log);
        gen.offerBarkBlockRecipe(strippedWood, strippedLog);
        gen.offerPlanksRecipe(planks, logs, 4);
        gen.createStairsRecipe(stairs, Ingredient.ofItem(planks))
                .criterion(RecipeGenerator.hasItem(planks), gen.conditionsFromItem(planks))
                .offerTo(exporter);
        gen.createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.ofItem(planks))
                .criterion(RecipeGenerator.hasItem(planks), gen.conditionsFromItem(planks))
                .offerTo(exporter);
        gen.createFenceRecipe(fence, Ingredient.ofItem(planks))
                .criterion(RecipeGenerator.hasItem(planks), gen.conditionsFromItem(planks))
                .offerTo(exporter);
        gen.createFenceGateRecipe(gate, Ingredient.ofItem(planks))
                .criterion(RecipeGenerator.hasItem(planks), gen.conditionsFromItem(planks))
                .offerTo(exporter);
        gen.createDoorRecipe(door, Ingredient.ofItem(planks))
                .criterion(RecipeGenerator.hasItem(planks), gen.conditionsFromItem(planks))
                .offerTo(exporter);
        gen.createTrapdoorRecipe(trapdoor, Ingredient.ofItem(planks))
                .criterion(RecipeGenerator.hasItem(planks), gen.conditionsFromItem(planks))
                .offerTo(exporter);
        gen.createButtonRecipe(button, Ingredient.ofItem(planks))
                .criterion(RecipeGenerator.hasItem(planks), gen.conditionsFromItem(planks))
                .offerTo(exporter);
        gen.createPressurePlateRecipe(RecipeCategory.REDSTONE, pressurePlate, Ingredient.ofItem(planks))
                .criterion(RecipeGenerator.hasItem(planks), gen.conditionsFromItem(planks))
                .offerTo(exporter);

    }

    @Override
    public String getName() {
        return "SDTRecipeProvider";
    }
}