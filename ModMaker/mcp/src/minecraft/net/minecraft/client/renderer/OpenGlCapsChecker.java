package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GLContext;

@SideOnly(Side.CLIENT)
public class OpenGlCapsChecker
{
    public static boolean func_74371_a()
    {
        return GLContext.getCapabilities().GL_ARB_occlusion_query;
    }
}
