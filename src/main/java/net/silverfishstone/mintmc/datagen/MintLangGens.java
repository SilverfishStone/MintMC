package net.silverfishstone.mintmc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.silverfishstone.mintmc.MintMain;
import net.silverfishstone.mintmc.resource.blocks.MintBlocks;
import net.silverfishstone.mintmc.resource.items.MintItems;

import java.util.concurrent.CompletableFuture;

public class MintLangGens extends FabricLanguageProvider {
    public MintLangGens(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translateFullSetAndOre(translationBuilder, "silver", "Silver");
        translateFullSet(translationBuilder, "steel", "Steel");
        translateFullSet(translationBuilder, "rose_gold", "Rose Gold");
        translateFullSetAndOre(translationBuilder, "twilite", "Twilite");
        translateFullSetAndOre(translationBuilder, "ruby", "Ruby");
        translateFullSet(translationBuilder, "lead", "Lead");
        translateArmorSet(translationBuilder, "copper", "Copper");
        translateExistingOres(translationBuilder, "copper", "Copper");
        translateExistingOres(translationBuilder, "coal", "Coal");
        translateExistingOres(translationBuilder, "iron", "Iron");
        translateExistingOres(translationBuilder, "gold", "Gold");
        translateExistingOres(translationBuilder, "diamond", "Diamond");
        translateExistingOres(translationBuilder, "redstone", "Redstone");
        translateExistingOres(translationBuilder, "lapis", "Lapis");
        translateExistingOres(translationBuilder, "emerald", "Emerald");
        translationBuilder.add(MintItems.STEEL_ROD, "Steel Rod");
        translationBuilder.add(MintItems.STEEL_SCRAP, "Steel Scrap");
        translationBuilder.add(MintBlocks.COBBLED_GRANITE, "Cobbled Granite");
        translationBuilder.add(MintBlocks.COBBLED_LIMESTONE, "Cobbled Limestone");
        translationBuilder.add(MintBlocks.LIMESTONE, "Limestone");
        translationBuilder.add("itemGroup.mint_mc", "Mint MC");
    }

    private static void translateFullSetAndOre (TranslationBuilder builder, String name, String translation) {
        translateOreSets(builder, name, translation);
        translateArmorSet(builder, name, translation);
        translateToolSet(builder, name, translation);
    }

    private static void translateFullSet (TranslationBuilder builder, String name, String translation) {
        translateArmorSet(builder, name, translation);
        translateToolSet(builder, name, translation);
    }

    public static void translateArmorSet (TranslationBuilder builder, String name, String translation) {
        builder.add("item." + MintMain.MOD_ID + "." + name + "_helmet", translation + " Helmet");
        builder.add("item." + MintMain.MOD_ID + "." + name + "_chestplate", translation + " Chestplate");
        builder.add("item." + MintMain.MOD_ID + "." + name + "_leggings", translation + " Leggings");
        builder.add("item." + MintMain.MOD_ID + "." + name + "_boots", translation + " Boots");
    }

    public static void translateToolSet (TranslationBuilder builder, String name, String translation) {
        builder.add("item." + MintMain.MOD_ID + "." + name + "_pickaxe", translation + " Pickaxe");
        builder.add("item." + MintMain.MOD_ID + "." + name + "_axe", translation + " Axe");
        builder.add("item." + MintMain.MOD_ID + "." + name + "_sword", translation + " Sword");
        builder.add("item." + MintMain.MOD_ID + "." + name + "_shovel", translation + " Shovel");
        builder.add("item." + MintMain.MOD_ID + "." + name + "_hoe", translation + " Hoe");
        builder.add("item." + MintMain.MOD_ID + "." + name + "_ingot", translation + " Ingot");
    }

    public static void translateOreSets (TranslationBuilder builder, String name, String translation) {
        builder.add("block." + MintMain.MOD_ID + "." + name + "_ore", translation + " Ore");
        translateExistingOres(builder, name, translation);
        builder.add("block." + MintMain.MOD_ID + ".deepslate_" + name + "_ore",  "Deepslate " + translation + " Ore");
    }

    public static void translateExistingOres (TranslationBuilder builder, String name, String translation) {
        builder.add("block." + MintMain.MOD_ID + ".granite_" + name + "_ore",  "Granite " + translation + " Ore");
        builder.add("block." + MintMain.MOD_ID + ".limestone_" + name + "_ore",  "Limestone " + translation + " Ore");
    }

    public static void translateWoodBlockVariants (TranslationBuilder builder, String blockBase, String translation) {
        String translatable = "block."+ MintMain.MOD_ID + "." + blockBase;
        builder.add(translatable + "_log", translation + " Log");
        builder.add("stripped_" + translatable + "_log", translation + " Stripped Log");
        builder.add(translatable + "_wood", translation + " Wood");
        builder.add("stripped_" + translatable + "_wood", translation + " Stripped Wood");
        builder.add(translatable + "_planks", translation + " Planks");
        builder.add(translatable + "_slab", translation + " Slab");
        builder.add(translatable + "_stairs", translation + " Stairs");
        builder.add(translatable + "_fence", translation + " Fence");
        builder.add(translatable + "_fence_gate", translation + " Fence Gate");
        builder.add(translatable + "_door", translation + " Door");
        builder.add(translatable + "_trapdoor", translation + " Trapdoor");
        builder.add(translatable + "_pressure_plate", translation + " Pressure Plate");
        builder.add(translatable + "_button", translation + " Button");
        builder.add(translatable + "_sapling", translation + " Sapling");
        if (!blockBase.equals("azalea")) builder.add(translatable + "_leaves", translation + " Leaves");
    }

    private static void translateDeathMessage (TranslationBuilder builder, RegistryKey<DamageType> type, String translation, String player) {
        builder.add("death.attack." + type.getValue().getPath(), translation);
        builder.add("death.attack." + type.getValue().getPath() + ".player", translation + player);
    }

    public static void translatePotion (TranslationBuilder translationBuilder, RegistryEntry<StatusEffect> effect, String translation) {
        translationBuilder.add(effect(effect), translation);
        translationBuilder.add(potionEffect(effect), translation + " Potion");
        translationBuilder.add(splashPotionEffect(effect), translation + " Splash Potion");
        translationBuilder.add(lingeringPotionEffect(effect), translation + " Lingering Potion");
        translationBuilder.add(tippedArrowEffect(effect), translation + " Tipped Arrow");
    }
    public static void translateAdvancement (TranslationBuilder translationBuilder, String group, String action, String title, String description) {
        translationBuilder.add(advancementTitleTranslations(group, action), title);
        translationBuilder.add(advancementDescriptionTranslations(group, action), description);
    }

    public static String advancementTitleTranslations (String group, String action) {
        return "advancements." + group + "." + action + ".title";
    }
    public static String advancementDescriptionTranslations (String group, String action) {
        return "advancements." + group + "." + action + ".description";
    }
    private static String tippedArrowEffect(RegistryEntry<StatusEffect> effect) {
        return itemEffect(effect, Items.TIPPED_ARROW);
    }
    private static String potionEffect(RegistryEntry<StatusEffect> effect) {
        return itemEffect(effect, Items.POTION);
    }
    private static String splashPotionEffect(RegistryEntry<StatusEffect> effect) {
        return itemEffect(effect, Items.SPLASH_POTION);
    }
    private static String lingeringPotionEffect(RegistryEntry<StatusEffect> effect) {
        return itemEffect(effect, Items.LINGERING_POTION);
    }

    private static String itemEffect(RegistryEntry<StatusEffect> effect, Item item) {
        return item.getTranslationKey() + "." + effect(effect);
    }
    private static String effect(RegistryEntry<StatusEffect> effect) {
        return effect.value().getTranslationKey();
    }

}
