package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

final class StatTypeDistance implements IStatType
{
    @SideOnly(Side.CLIENT)
    public String func_75843_a(int p_75843_1_)
    {
        double d0 = (double)p_75843_1_ / 100.0D;
        double d1 = d0 / 1000.0D;
        return d1 > 0.5D ? StatBase.func_75969_k().format(d1) + " km" : (d0 > 0.5D ? StatBase.func_75969_k().format(d0) + " m" : p_75843_1_ + " cm");
    }
}
