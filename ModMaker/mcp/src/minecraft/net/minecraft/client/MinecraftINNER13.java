package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;

@SideOnly(Side.CLIENT)
class MinecraftINNER13 implements Callable
{
    final Minecraft field_142056_a;

    MinecraftINNER13(Minecraft p_i2341_1_)
    {
        this.field_142056_a = p_i2341_1_;
    }

    public String func_142055_a()
    {
        int i = this.field_142056_a.field_71441_e.func_82732_R().func_82591_c();
        int j = 56 * i;
        int k = j / 1024 / 1024;
        int l = this.field_142056_a.field_71441_e.func_82732_R().func_82590_d();
        int i1 = 56 * l;
        int j1 = i1 / 1024 / 1024;
        return i + " (" + j + " bytes; " + k + " MB) allocated, " + l + " (" + i1 + " bytes; " + j1 + " MB) used";
    }

    public Object call()
    {
        return this.func_142055_a();
    }
}
