package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiScreenDemo extends GuiScreen
{
    private static final ResourceLocation field_110407_a = new ResourceLocation("textures/gui/demo_background.png");

    public void func_73866_w_()
    {
        this.field_73887_h.clear();
        byte b0 = -16;
        this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 116, this.field_73881_g / 2 + 62 + b0, 114, 20, I18n.func_135053_a("demo.help.buy")));
        this.field_73887_h.add(new GuiButton(2, this.field_73880_f / 2 + 2, this.field_73881_g / 2 + 62 + b0, 114, 20, I18n.func_135053_a("demo.help.later")));
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        switch (p_73875_1_.field_73741_f)
        {
            case 1:
                p_73875_1_.field_73742_g = false;

                try
                {
                    Class oclass = Class.forName("java.awt.Desktop");
                    Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
                    oclass.getMethod("browse", new Class[] {URI.class}).invoke(object, new Object[] {new URI("http://www.minecraft.net/store?source=demo")});
                }
                catch (Throwable throwable)
                {
                    throwable.printStackTrace();
                }

                break;
            case 2:
                this.field_73882_e.func_71373_a((GuiScreen)null);
                this.field_73882_e.func_71381_h();
        }
    }

    public void func_73876_c()
    {
        super.func_73876_c();
    }

    public void func_73873_v_()
    {
        super.func_73873_v_();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110407_a);
        int i = (this.field_73880_f - 248) / 2;
        int j = (this.field_73881_g - 166) / 2;
        this.func_73729_b(i, j, 0, 0, 248, 166);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.func_73873_v_();
        int k = (this.field_73880_f - 248) / 2 + 10;
        int l = (this.field_73881_g - 166) / 2 + 8;
        this.field_73886_k.func_78276_b(I18n.func_135053_a("demo.help.title"), k, l, 2039583);
        l += 12;
        GameSettings gamesettings = this.field_73882_e.field_71474_y;
        this.field_73886_k.func_78276_b(I18n.func_135052_a("demo.help.movementShort", new Object[] {GameSettings.func_74298_c(gamesettings.field_74351_w.field_74512_d), GameSettings.func_74298_c(gamesettings.field_74370_x.field_74512_d), GameSettings.func_74298_c(gamesettings.field_74368_y.field_74512_d), GameSettings.func_74298_c(gamesettings.field_74366_z.field_74512_d)}), k, l, 5197647);
        this.field_73886_k.func_78276_b(I18n.func_135053_a("demo.help.movementMouse"), k, l + 12, 5197647);
        this.field_73886_k.func_78276_b(I18n.func_135052_a("demo.help.jump", new Object[] {GameSettings.func_74298_c(gamesettings.field_74314_A.field_74512_d)}), k, l + 24, 5197647);
        this.field_73886_k.func_78276_b(I18n.func_135052_a("demo.help.inventory", new Object[] {GameSettings.func_74298_c(gamesettings.field_74315_B.field_74512_d)}), k, l + 36, 5197647);
        this.field_73886_k.func_78279_b(I18n.func_135053_a("demo.help.fullWrapped"), k, l + 68, 218, 2039583);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
