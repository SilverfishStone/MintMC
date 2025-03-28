package net.silverfishstone.mintmc.mixin;

import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;
import net.silverfishstone.mintmc.MintMain;
import net.silverfishstone.mintmc.resource.entity.CustomTexturedEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ZombieBaseEntityRenderer.class)
public class ZombieRendererMixin {

    @Inject(at = @At("HEAD"), method = "getTexture(Lnet/minecraft/entity/mob/ZombieEntity;)Lnet/minecraft/util/Identifier;", cancellable = true)
    protected void getTexture(ZombieEntity zombieEntity, CallbackInfoReturnable<Identifier> cir) {
        if (zombieEntity instanceof CustomTexturedEntity texturedState) {
            String customTexture = texturedState.getCustomTexture();
            if (customTexture != null) {
                Identifier textureId = Identifier.of(MintMain.MOD_ID, customTexture + ".png");
                cir.setReturnValue(textureId);
                cir.cancel();
            }
        }
    }
}
