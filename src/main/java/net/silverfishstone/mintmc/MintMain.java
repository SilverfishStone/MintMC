package net.silverfishstone.mintmc;

import net.fabricmc.api.ModInitializer;
import net.silverfishstone.mintmc.resource.blocks.MintBlocks;
import net.silverfishstone.mintmc.resource.items.MintItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MintMain implements ModInitializer {
	public static final String MOD_ID = "mintmc";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		MintItems.registerItems();
		MintBlocks.registerBlocks();
	}
}