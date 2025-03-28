package net.silverfishstone.mintmc.mixin;

import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.silverfishstone.mintmc.minecart.MinecartChainHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(AbstractMinecartEntity.class)
public abstract class AbstractMinecartEntityMixin {

    /*todo Mixin to DefaultMinecartController to change behavior
     */


    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void onTick(CallbackInfo ci) {
        if (isChainedFollower()) {
            ci.cancel();
        }
    }

    @Unique
    private boolean isChainedFollower() {
        AbstractMinecartEntity self = cart();
        for (List<AbstractMinecartEntity> chain : MinecartChainHandler.minecartChains) {
            int index = chain.indexOf(self);
            if (index > 0) {
                return true;
            }
        }
        return false;
    }

    @Unique
    private AbstractMinecartEntity cart() {
        return ((AbstractMinecartEntity) (Object) this);
    }
}
