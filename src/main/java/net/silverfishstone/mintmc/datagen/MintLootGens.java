package net.silverfishstone.mintmc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MintLootGens extends FabricBlockLootTableProvider {
    public static List<Block> DROP_SELF = new ArrayList<>();
    public MintLootGens(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    protected static final float[] SAPLING_DROP_CHANCE = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    /*
    static {
        DROP_SELF.add()
    }

     */

    @Override
    public void generate() {
        DROP_SELF.forEach(this::addDrop);

    }



    public LootTable.Builder singleWithSilkMultiWithout(Block original, Block drop, ItemConvertible drop2) {
        return LootTable.builder()
                .pool(
                        LootPool.builder()
                                .conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS))
                                .with(
                                        AlternativeEntry.builder(
                                                ItemEntry.builder(drop)
                                                        .conditionally(this.createWithoutSilkTouchCondition()),
                                                EmptyEntry.builder()
                                        )
                                )
                )
                .pool(
                        LootPool.builder()
                                .conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS))
                                .with(
                                        AlternativeEntry.builder(
                                                ItemEntry.builder(drop2)
                                                        .conditionally(this.createWithoutSilkTouchCondition()),
                                                ItemEntry.builder(original)
                                        )
                                )
                );
    }
    public LootTable.Builder oreDrops(Block withSilkTouch, Item withoutSilkTouch) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                withSilkTouch,
                this.applyExplosionDecay(
                        withSilkTouch, ItemEntry.builder(withoutSilkTouch).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
