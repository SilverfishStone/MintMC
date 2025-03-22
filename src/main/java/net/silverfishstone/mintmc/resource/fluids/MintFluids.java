package net.silverfishstone.mintmc.resource.fluids;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.silverfishstone.mintmc.MintMain;

public class MintFluids {
    public static final FlowableFluid FLOWING_EBON = register("flowing_ebon", new EbonFluid.Flowing());
    public static final FlowableFluid EBON = register("ebon", new EbonFluid.Still());

    private static <T extends Fluid> T register(String id, T value) {
        return Registry.register(Registries.FLUID, Identifier.of(MintMain.MOD_ID, id), value);
    }
}
