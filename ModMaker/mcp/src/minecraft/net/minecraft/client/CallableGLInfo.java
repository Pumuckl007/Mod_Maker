package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
class CallableGLInfo implements Callable
{
    final Minecraft field_79002_a;

    CallableGLInfo(Minecraft p_i1011_1_)
    {
        this.field_79002_a = p_i1011_1_;
    }

    public String func_79001_a()
    {
        return GL11.glGetString(GL11.GL_RENDERER) + " GL version " + GL11.glGetString(GL11.GL_VERSION) + ", " + GL11.glGetString(GL11.GL_VENDOR);
    }

    public Object call()
    {
        return this.func_79001_a();
    }
}
