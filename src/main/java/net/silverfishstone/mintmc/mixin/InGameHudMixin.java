package net.silverfishstone.mintmc.mixin;


import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    private static void renderArmor(DrawContext context, PlayerEntity player, int i, int j, int k, int x) {
        int l = 0;
    }
}
