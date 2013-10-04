package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;

@SideOnly(Side.CLIENT)
class CallableLaunchedVersion implements Callable
{
    final Minecraft field_74421_a;

    CallableLaunchedVersion(Minecraft p_i1009_1_)
    {
        this.field_74421_a = p_i1009_1_;
    }

    public String func_74420_a()
    {
        return Minecraft.func_110431_a(this.field_74421_a);
    }

    public Object call()
    {
        return this.func_74420_a();
    }
}
