package net.silverfishstone.mintmc;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.*;
import net.silverfishstone.mintmc.datagen.MintLangGens;
import net.silverfishstone.mintmc.datagen.MintLootGens;
import net.silverfishstone.mintmc.datagen.MintRecipeGens;
import net.silverfishstone.mintmc.datagen.MintTagGens;
import net.silverfishstone.mintmc.datagen.model.MintModelGens;
import net.silverfishstone.mintmc.resource.items.MintItemGroups;


public class MintDataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(MintTagGens.MintItemTagGens::new);
		pack.addProvider(MintTagGens.MintBlockTagGens::new);
		pack.addProvider(MintLangGens::new);
		pack.addProvider(MintModelGens::new);
		pack.addProvider(MintLootGens::new);
		pack.addProvider(MintRecipeGens::new);
		pack.addProvider(MintTagGens.MintDamageTagGens::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);

	}
}
