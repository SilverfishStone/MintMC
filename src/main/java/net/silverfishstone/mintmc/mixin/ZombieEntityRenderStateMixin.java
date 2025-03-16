package net.silverfishstone.mintmc.mixin;

import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.silverfishstone.mintmc.resource.entity.CustomTexturedRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ZombieEntityRenderState.class)
public class ZombieEntityRenderStateMixin implements CustomTexturedRenderState {
    @Unique
    private String variant;

    @Override
    public String getCustomTexture() {
        return this.variant;
    }

    @Override
    public void setCustomTexture(String textureId) {
        this.variant = textureId;
    }
}
