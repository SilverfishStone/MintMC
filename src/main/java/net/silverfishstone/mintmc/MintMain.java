package net.silverfishstone.mintmc;

import net.fabricmc.api.ModInitializer;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.silverfishstone.mintmc.resource.blocks.MintBlocks;
import net.silverfishstone.mintmc.resource.items.MintItems;
import net.silverfishstone.mintmc.resource.screens.CrucibleScreenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MintMain implements ModInitializer {
	public static final String MOD_ID = "mintmc";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ScreenHandlerType<CrucibleScreenHandler> CRUCIBLE_SCREEN_HANDLER =
			Registry.register(
					Registries.SCREEN_HANDLER,
					Identifier.of("mintmc", "crucible"),
					new ScreenHandlerType<>((syncId, playerInventory) -> new CrucibleScreenHandler(syncId, playerInventory, new SimpleInventory(8)), FeatureSet.empty())
			);

	@Override
	public void onInitialize() {
		MintItems.registerItems();
		MintBlocks.registerBlocks();
	}
}