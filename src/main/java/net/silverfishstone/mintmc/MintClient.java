package net.silverfishstone.mintmc;

import net.fabricmc.api.ClientModInitializer;
import net.silverfishstone.mintmc.minecart.MinecartChainHandler;

public class MintClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MinecartChainHandler.register();
	}
}