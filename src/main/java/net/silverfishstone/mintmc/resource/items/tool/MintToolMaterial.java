package net.silverfishstone.mintmc.resource.items.tool;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum MintToolMaterial implements ToolMaterial {
   STEEL(MiningLevels.IRON, 59, 2.0F, 0.0F, 15, () -> Ingredient.fromTag(ItemTags.IRON_ORES));

   private final int miningLevel;
   private final int itemDurability;
   private final float miningSpeed;
   private final float attackDamage;
   private final int enchantability;
   private final Lazy<Ingredient> repairIngredient;

   MintToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
      this.miningLevel = miningLevel;
      this.itemDurability = itemDurability;
      this.miningSpeed = miningSpeed;
      this.attackDamage = attackDamage;
      this.enchantability = enchantability;
      this.repairIngredient = new Lazy<>(repairIngredient);
   }

   @Override
   public int getDurability() {
      return this.itemDurability;
   }

   @Override
   public float getMiningSpeedMultiplier() {
      return this.miningSpeed;
   }

   @Override
   public float getAttackDamage() {
      return this.attackDamage;
   }

   @Override
   public int getMiningLevel() {
      return this.miningLevel;
   }

   @Override
   public int getEnchantability() {
      return this.enchantability;
   }

   @Override
   public Ingredient getRepairIngredient() {
      return this.repairIngredient.get();
   }
}
