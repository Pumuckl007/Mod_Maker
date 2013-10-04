package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

final class StatTypeSimple implements IStatType
{
    @SideOnly(Side.CLIENT)
    public String func_75843_a(int p_75843_1_)
    {
        return StatBase.func_75965_j().format((long)p_75843_1_);
    }
}
