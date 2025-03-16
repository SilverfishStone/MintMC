package net.silverfishstone.mintmc.resource.entity;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.random.Random;

import java.util.Arrays;
import java.util.function.IntFunction;

public enum ZombieVariantEnum implements StringIdentifiable {
    NORMAL(0, "norma;", true),
    HANK(1, "hank", true),
    JEFF(2, "jeff", true);

    private static final IntFunction<ZombieVariantEnum> INDEX_MAPPER = ValueLists.createIndexToValueFunction(
            ZombieVariantEnum::getIndex, values(), ValueLists.OutOfBoundsHandling.ZERO
    );
    public static final PacketCodec<ByteBuf, ZombieVariantEnum> PACKET_CODEC = PacketCodecs.indexed(INDEX_MAPPER, ZombieVariantEnum::getIndex);
    public static final Codec<ZombieVariantEnum> CODEC = StringIdentifiable.createCodec(ZombieVariantEnum::values);
    @Deprecated
    public static final Codec<ZombieVariantEnum> INDEX_CODEC = Codec.INT.xmap(INDEX_MAPPER::apply, ZombieVariantEnum::getIndex);
    private final int index;
    private final String id;
    private final boolean natural;

    private ZombieVariantEnum(final int index, final String id, final boolean natural) {
        this.index = index;
        this.id = id;
        this.natural = natural;
    }

    public int getIndex() {
        return this.index;
    }

    public String getVariantId() {
        return this.id;
    }

    @Override
    public String asString() {
        return this.id;
    }

    public static ZombieVariantEnum byIndex(int index) {
        return (ZombieVariantEnum)INDEX_MAPPER.apply(index);
    }

    public static ZombieVariantEnum getRandomNatural(Random random) {
        return getRandom(random, true);
    }

    public static ZombieVariantEnum getRandomUnnatural(Random random) {
        return getRandom(random, false);
    }

    private static ZombieVariantEnum getRandom(Random random, boolean natural) {
        ZombieVariantEnum[] variants = Arrays.stream(values())
                .filter(variant -> variant.natural == natural)
                .toArray(ZombieVariantEnum[]::new);
        return Util.getRandom(variants, random);
    }
}
