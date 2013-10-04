package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;

@SideOnly(Side.CLIENT)
class CallableParticleScreenName implements Callable
{
    final Minecraft field_90053_a;

    CallableParticleScreenName(Minecraft p_i1008_1_)
    {
        this.field_90053_a = p_i1008_1_;
    }

    public String func_90052_a()
    {
        return this.field_90053_a.field_71462_r.getClass().getCanonicalName();
    }

    public Object call()
    {
        return this.func_90052_a();
    }
}
