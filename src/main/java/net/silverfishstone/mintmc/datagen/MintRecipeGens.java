package net.silverfishstone.mintmc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.registry.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class MintRecipeGens extends FabricRecipeProvider {
    public MintRecipeGens(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output);
    }

    @Override
    public String getName() {
        return "SDTRecipeProvider";
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {

    }
}