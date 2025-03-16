package net.silverfishstone.mintmc.mixin;

import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;
import net.silverfishstone.mintmc.MintMain;
import net.silverfishstone.mintmc.resource.entity.CustomTexturedEntity;
import net.silverfishstone.mintmc.resource.entity.CustomTexturedRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(ZombieBaseEntityRenderer.class)
public class ZombieRendererMixin {

    @Inject(method = "updateRenderState(Lnet/minecraft/entity/mob/ZombieEntity;Lnet/minecraft/client/render/entity/state/ZombieEntityRenderState;F)V", at = @At("TAIL"))
    private void injectCustomTextureIntoRenderState(ZombieEntity entity, ZombieEntityRenderState state, float f, CallbackInfo ci) {
        if (entity instanceof CustomTexturedEntity texturedEntity && state instanceof CustomTexturedRenderState texturedState) {
            texturedState.setCustomTexture(texturedEntity.getCustomTexture());
        }
    }

    @Inject(at = @At("HEAD"), method = "getTexture(Lnet/minecraft/client/render/entity/state/ZombieEntityRenderState;)Lnet/minecraft/util/Identifier;", cancellable = true)
    protected void getTexture(ZombieEntityRenderState zombieEntityRenderState, CallbackInfoReturnable<Identifier> cir) {
        if (zombieEntityRenderState instanceof CustomTexturedRenderState texturedState) {
            String customTexture = texturedState.getCustomTexture();
            if (customTexture != null) {
                Identifier textureId = Identifier.of(customTexture + ".png");
                cir.setReturnValue(textureId);
                cir.cancel();
            }
        }
    }
}
