package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;

@SideOnly(Side.CLIENT)
public class GuiVideoSettings extends GuiScreen
{
    private GuiScreen field_74105_b;
    protected String field_74107_a = "Video Settings";
    private GameSettings field_74106_c;
    private boolean field_74104_d;
    private static EnumOptions[] field_74108_m = new EnumOptions[] {EnumOptions.GRAPHICS, EnumOptions.RENDER_DISTANCE, EnumOptions.AMBIENT_OCCLUSION, EnumOptions.FRAMERATE_LIMIT, EnumOptions.ANAGLYPH, EnumOptions.VIEW_BOBBING, EnumOptions.GUI_SCALE, EnumOptions.ADVANCED_OPENGL, EnumOptions.GAMMA, EnumOptions.RENDER_CLOUDS, EnumOptions.PARTICLES, EnumOptions.USE_SERVER_TEXTURES, EnumOptions.USE_FULLSCREEN, EnumOptions.ENABLE_VSYNC};

    public GuiVideoSettings(GuiScreen p_i1062_1_, GameSettings p_i1062_2_)
    {
        this.field_74105_b = p_i1062_1_;
        this.field_74106_c = p_i1062_2_;
    }

    public void func_73866_w_()
    {
        this.field_74107_a = I18n.func_135053_a("options.videoTitle");
        this.field_73887_h.clear();
        this.field_73887_h.add(new GuiButton(200, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 168, I18n.func_135053_a("gui.done")));
        this.field_74104_d = false;
        String[] astring = new String[] {"sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"};
        String[] astring1 = astring;
        int i = astring.length;

        for (int j = 0; j < i; ++j)
        {
            String s = astring1[j];
            String s1 = System.getProperty(s);

            if (s1 != null && s1.contains("64"))
            {
                this.field_74104_d = true;
                break;
            }
        }

        int k = 0;
        i = this.field_74104_d ? 0 : -15;
        EnumOptions[] aenumoptions = field_74108_m;
        int l = aenumoptions.length;

        for (int i1 = 0; i1 < l; ++i1)
        {
            EnumOptions enumoptions = aenumoptions[i1];

            if (enumoptions.func_74380_a())
            {
                this.field_73887_h.add(new GuiSlider(enumoptions.func_74381_c(), this.field_73880_f / 2 - 155 + k % 2 * 160, this.field_73881_g / 7 + i + 24 * (k >> 1), enumoptions, this.field_74106_c.func_74297_c(enumoptions), this.field_74106_c.func_74296_a(enumoptions)));
            }
            else
            {
                this.field_73887_h.add(new GuiSmallButton(enumoptions.func_74381_c(), this.field_73880_f / 2 - 155 + k % 2 * 160, this.field_73881_g / 7 + i + 24 * (k >> 1), enumoptions, this.field_74106_c.func_74297_c(enumoptions)));
            }

            ++k;
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73742_g)
        {
            int i = this.field_74106_c.field_74335_Z;

            if (p_73875_1_.field_73741_f < 100 && p_73875_1_ instanceof GuiSmallButton)
            {
                this.field_74106_c.func_74306_a(((GuiSmallButton)p_73875_1_).func_73753_a(), 1);
                p_73875_1_.field_73744_e = this.field_74106_c.func_74297_c(EnumOptions.func_74379_a(p_73875_1_.field_73741_f));
            }

            if (p_73875_1_.field_73741_f == 200)
            {
                this.field_73882_e.field_71474_y.func_74303_b();
                this.field_73882_e.func_71373_a(this.field_74105_b);
            }

            if (this.field_74106_c.field_74335_Z != i)
            {
                ScaledResolution scaledresolution = new ScaledResolution(this.field_73882_e.field_71474_y, this.field_73882_e.field_71443_c, this.field_73882_e.field_71440_d);
                int j = scaledresolution.func_78326_a();
                int k = scaledresolution.func_78328_b();
                this.func_73872_a(this.field_73882_e, j, k);
            }
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this.field_74107_a, this.field_73880_f / 2, this.field_74104_d ? 20 : 5, 16777215);

        if (!this.field_74104_d && this.field_74106_c.field_74339_e == 0)
        {
            this.func_73732_a(this.field_73886_k, I18n.func_135053_a("options.farWarning1"), this.field_73880_f / 2, this.field_73881_g / 6 + 144 + 1, 11468800);
            this.func_73732_a(this.field_73886_k, I18n.func_135053_a("options.farWarning2"), this.field_73880_f / 2, this.field_73881_g / 6 + 144 + 13, 11468800);
        }

        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
