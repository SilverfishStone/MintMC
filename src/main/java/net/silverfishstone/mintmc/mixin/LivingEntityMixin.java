package net.silverfishstone.mintmc.mixin;


import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.entity.DamageUtil;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.TagKey;
import net.silverfishstone.mintmc.datagen.tags.MintTags;
import net.silverfishstone.mintmc.util.playerdata.ArmorStats;
import net.silverfishstone.mintmc.util.playerdata.DamageUtilPlusStat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Unique
    private static final Map<LivingEntity, ArmorStats> armorStatsMap = new HashMap<>();

    @ModifyReturnValue(at = @At("RETURN"), method = "applyArmorToDamage")
    private float applyArmorToDamage(float original, DamageSource source, float amount) {
        if (!source.isIn(DamageTypeTags.BYPASSES_ARMOR)) {
            LivingEntity entity = living();
            ArmorStats armorStats = armorStatsMap.computeIfAbsent(entity, k -> new ArmorStats());

            entity.damageArmor(source, amount);
            if (source.isIn(DamageTypeTags.IS_FIRE)) {
                amount = DamageUtilPlusStat.getDamageLeft(amount, armorStats.getFire(), entity.getAttributeValue(EntityAttributes.GENERIC_ARMOR_TOUGHNESS));
            } else if (source.isIn(DamageTypeTags.IS_EXPLOSION)) {
                amount = DamageUtilPlusStat.getDamageLeft(amount, armorStats.getBlast(), entity.getAttributeValue(EntityAttributes.GENERIC_ARMOR_TOUGHNESS));
            } else if (source.isIn(MintTags.Resources.PVP)) {
                amount = DamageUtilPlusStat.getDamageLeft(amount, armorStats.getCombat(), entity.getAttributeValue(EntityAttributes.GENERIC_ARMOR_TOUGHNESS));
            } else {
                amount = DamageUtilPlusStat.getDamageLeft(amount, armorStats.getDamage(), entity.getAttributeValue(EntityAttributes.GENERIC_ARMOR_TOUGHNESS));
            }
        }

        return amount;
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void setArmorStatsValues(CallbackInfo ci) {
        ArmorStats armorStats = armorStatsMap.computeIfAbsent(living(), k -> new ArmorStats());
        armorStats.setFire(fireStat());
        armorStats.setBlast(blastStat());
        armorStats.setCombat(combatStat());
        armorStatsMap.put(living(), armorStats);
    }

    @Unique
    private int blastStat () {
        List<ItemStack> rules = new ArrayList<>();
        rules.add(living().getEquippedStack(EquipmentSlot.FEET));
        rules.add(living().getEquippedStack(EquipmentSlot.LEGS));
        rules.add(living().getEquippedStack(EquipmentSlot.CHEST));
        rules.add(living().getEquippedStack(EquipmentSlot.HEAD));
        int blast = 0;
        for(ItemStack stack : rules) {
            if (stack.isIn(MintTags.Resources.LEATHER_ARMOR)) {
                blast += 12;
            } else if (stack.isIn(MintTags.Resources.GOLD_ARMOR)) {
                blast += 100;
            } else if (stack.isIn(MintTags.Resources.IRON_ARMOR)) {
                blast += 12;
            } else if (stack.isIn(MintTags.Resources.CHAINMAIL_ARMOR)) {
                blast += 12;
            } else if (stack.isIn(MintTags.Resources.DIAMOND_ARMOR)) {
                blast += 100;
            }
        }
        return blast;
    }

    @Unique
    private int fireStat () {
        List<ItemStack> rules = List.of(
                living().getEquippedStack(EquipmentSlot.FEET),
                living().getEquippedStack(EquipmentSlot.LEGS),
                living().getEquippedStack(EquipmentSlot.CHEST),
                living().getEquippedStack(EquipmentSlot.HEAD));
        Map<TagKey<Item>, Integer> fireValues = Map.of(
                MintTags.Resources.LEATHER_ARMOR, 12,
                MintTags.Resources.GOLD_ARMOR, 14,
                MintTags.Resources.IRON_ARMOR, 16,
                MintTags.Resources.CHAINMAIL_ARMOR, 18,
                MintTags.Resources.DIAMOND_ARMOR, 29);

        int fire = 0;
        for (ItemStack stack : rules) {
            for (Map.Entry<TagKey<Item>, Integer> entry : fireValues.entrySet()) {
                if (stack.isIn(entry.getKey())) {
                    fire += entry.getValue();
                    break;
                }
            }
        }
        return fire;
    }

    @Unique
    private int combatStat() {
        List<ItemStack> rules = List.of(
                living().getEquippedStack(EquipmentSlot.FEET),
                living().getEquippedStack(EquipmentSlot.LEGS),
                living().getEquippedStack(EquipmentSlot.CHEST),
                living().getEquippedStack(EquipmentSlot.HEAD));
        Map<TagKey<Item>, Integer> fireValues = Map.of(
                MintTags.Resources.LEATHER_ARMOR, 12,
                MintTags.Resources.GOLD_ARMOR, 100,
                MintTags.Resources.IRON_ARMOR, 16,
                MintTags.Resources.CHAINMAIL_ARMOR, 18,
                MintTags.Resources.DIAMOND_ARMOR, 100);

        int combat = 0;
        for (ItemStack stack : rules) {
            for (Map.Entry<TagKey<Item>, Integer> entry : fireValues.entrySet()) {
                if (stack.isIn(entry.getKey())) {
                    combat += entry.getValue();
                    break;
                }
            }
        }
        return combat;
    }

    @Unique
    private LivingEntity living () {
        return ((LivingEntity) (Object) this);
    }
}
