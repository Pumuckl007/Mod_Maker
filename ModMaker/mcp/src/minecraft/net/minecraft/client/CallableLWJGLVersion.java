package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import org.lwjgl.Sys;

@SideOnly(Side.CLIENT)
class CallableLWJGLVersion implements Callable
{
    final Minecraft field_74503_a;

    CallableLWJGLVersion(Minecraft p_i1010_1_)
    {
        this.field_74503_a = p_i1010_1_;
    }

    public String func_74502_a()
    {
        return Sys.getVersion();
    }

    public Object call()
    {
        return this.func_74502_a();
    }
}