package net.silverfishstone.mintmc;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.silverfishstone.mintmc.minecart.MinecartChainHandler;
import net.silverfishstone.mintmc.resource.screens.CrucibleScreen;

public class MintClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MinecartChainHandler.register();
		HandledScreens.register(MintMain.CRUCIBLE_SCREEN_HANDLER, CrucibleScreen::new);
	}
}