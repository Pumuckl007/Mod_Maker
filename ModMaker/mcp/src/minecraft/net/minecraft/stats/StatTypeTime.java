package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

final class StatTypeTime implements IStatType
{
    @SideOnly(Side.CLIENT)
    public String func_75843_a(int p_75843_1_)
    {
        double d0 = (double)p_75843_1_ / 20.0D;
        double d1 = d0 / 60.0D;
        double d2 = d1 / 60.0D;
        double d3 = d2 / 24.0D;
        double d4 = d3 / 365.0D;
        return d4 > 0.5D ? StatBase.func_75969_k().format(d4) + " y" : (d3 > 0.5D ? StatBase.func_75969_k().format(d3) + " d" : (d2 > 0.5D ? StatBase.func_75969_k().format(d2) + " h" : (d1 > 0.5D ? StatBase.func_75969_k().format(d1) + " m" : d0 + " s")));
    }
}
