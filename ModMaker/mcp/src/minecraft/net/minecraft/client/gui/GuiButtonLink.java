package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;

@SideOnly(Side.CLIENT)
public class GuiButtonLink extends GuiButton
{
    public GuiButtonLink(int p_i1044_1_, int p_i1044_2_, int p_i1044_3_, int p_i1044_4_, int p_i1044_5_, String p_i1044_6_)
    {
        super(p_i1044_1_, p_i1044_2_, p_i1044_3_, p_i1044_4_, p_i1044_5_, p_i1044_6_);
    }

    public void func_96135_a(String p_96135_1_)
    {
        try
        {
            URI uri = new URI(p_96135_1_);
            Class oclass = Class.forName("java.awt.Desktop");
            Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
            oclass.getMethod("browse", new Class[] {URI.class}).invoke(object, new Object[] {uri});
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }
}
