package net.silverfishstone.mintmc.mixin;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.silverfishstone.mintmc.resource.entity.CustomTexturedEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ZombieEntity.class)
public class ZombieEntityMixin extends HostileEntity implements CustomTexturedEntity {
    private static final TrackedData<Integer> VARIANT = DataTracker.registerData(ZombieEntityMixin.class, TrackedDataHandlerRegistry.INTEGER);
    protected ZombieEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }


    @Inject(at = @At("TAIL"), method = "initDataTracker")
    protected void initDataTracker(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(VARIANT, 0);
    }

    public void setVariant(Integer variant) {
        this.dataTracker.set(VARIANT, variant);
    }

    @Inject(at = @At("TAIL"), method = "initialize")
    protected void initDataTracker(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CallbackInfoReturnable<EntityData> cir) {
        int random = this.random.nextInt(3) + 1;
        this.setVariant(random);
    }

    public Integer getVariant() {
        return this.dataTracker.get(VARIANT);
    }

    @Inject(at = @At("TAIL"), method = "writeCustomDataToNbt")
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt("Variant", this.dataTracker.get(VARIANT));
    }

    @Inject(at = @At("TAIL"), method = "readCustomDataFromNbt")
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("Variant")) {
            this.setVariant(nbt.getInt("Variant"));
        }
    }

    @Override
    public String getCustomTexture() {
        if (this.getDataTracker().get(VARIANT) == 1) {
            return "textures/entity/zombie/hank";
        } else if (this.getDataTracker().get(VARIANT) == 2) {
            return "textures/entity/zombie/zombie";
        } else if (this.getDataTracker().get(VARIANT) == 3) {
            return "textures/entity/zombie/jeff";
        } else {
            return "textures/entity/zombie/zombie";
        }
    }

    @Override
    public void setCustomTexture(Integer textureId) {
        this.dataTracker.set(VARIANT, textureId);
    }


}
