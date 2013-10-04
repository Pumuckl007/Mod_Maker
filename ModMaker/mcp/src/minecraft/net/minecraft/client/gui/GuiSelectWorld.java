package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.client.resources.I18n;
import net.minecraft.stats.StatList;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveFormatComparator;
import net.minecraft.world.storage.WorldInfo;

@SideOnly(Side.CLIENT)
public class GuiSelectWorld extends GuiScreen
{
    private final DateFormat field_74076_c = new SimpleDateFormat();
    protected GuiScreen field_74077_a;
    protected String field_74075_b = "Select world";
    private boolean field_74074_d;
    private int field_74080_m;
    private List field_74078_n;
    private GuiWorldSlot field_74079_o;
    private String field_74087_p;
    private String field_74086_q;
    private String[] field_74085_r = new String[3];
    private boolean field_74084_s;
    private GuiButton field_74083_t;
    private GuiButton field_74082_u;
    private GuiButton field_74081_v;
    private GuiButton field_82316_w;

    public GuiSelectWorld(GuiScreen p_i1054_1_)
    {
        this.field_74077_a = p_i1054_1_;
    }

    public void func_73866_w_()
    {
        this.field_74075_b = I18n.func_135053_a("selectWorld.title");

        try
        {
            this.func_74073_h();
        }
        catch (AnvilConverterException anvilconverterexception)
        {
            anvilconverterexception.printStackTrace();
            this.field_73882_e.func_71373_a(new GuiErrorScreen("Unable to load words", anvilconverterexception.getMessage()));
            return;
        }

        this.field_74087_p = I18n.func_135053_a("selectWorld.world");
        this.field_74086_q = I18n.func_135053_a("selectWorld.conversion");
        this.field_74085_r[EnumGameType.SURVIVAL.func_77148_a()] = I18n.func_135053_a("gameMode.survival");
        this.field_74085_r[EnumGameType.CREATIVE.func_77148_a()] = I18n.func_135053_a("gameMode.creative");
        this.field_74085_r[EnumGameType.ADVENTURE.func_77148_a()] = I18n.func_135053_a("gameMode.adventure");
        this.field_74079_o = new GuiWorldSlot(this);
        this.field_74079_o.func_77220_a(4, 5);
        this.func_74065_g();
    }

    private void func_74073_h() throws AnvilConverterException
    {
        ISaveFormat isaveformat = this.field_73882_e.func_71359_d();
        this.field_74078_n = isaveformat.func_75799_b();
        Collections.sort(this.field_74078_n);
        this.field_74080_m = -1;
    }

    protected String func_74069_a(int p_74069_1_)
    {
        return ((SaveFormatComparator)this.field_74078_n.get(p_74069_1_)).func_75786_a();
    }

    protected String func_74063_d(int p_74063_1_)
    {
        String s = ((SaveFormatComparator)this.field_74078_n.get(p_74063_1_)).func_75788_b();

        if (s == null || MathHelper.func_76139_a(s))
        {
            s = I18n.func_135053_a("selectWorld.world") + " " + (p_74063_1_ + 1);
        }

        return s;
    }

    public void func_74065_g()
    {
        this.field_73887_h.add(this.field_74082_u = new GuiButton(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 150, 20, I18n.func_135053_a("selectWorld.select")));
        this.field_73887_h.add(new GuiButton(3, this.field_73880_f / 2 + 4, this.field_73881_g - 52, 150, 20, I18n.func_135053_a("selectWorld.create")));
        this.field_73887_h.add(this.field_74081_v = new GuiButton(6, this.field_73880_f / 2 - 154, this.field_73881_g - 28, 72, 20, I18n.func_135053_a("selectWorld.rename")));
        this.field_73887_h.add(this.field_74083_t = new GuiButton(2, this.field_73880_f / 2 - 76, this.field_73881_g - 28, 72, 20, I18n.func_135053_a("selectWorld.delete")));
        this.field_73887_h.add(this.field_82316_w = new GuiButton(7, this.field_73880_f / 2 + 4, this.field_73881_g - 28, 72, 20, I18n.func_135053_a("selectWorld.recreate")));
        this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 + 82, this.field_73881_g - 28, 72, 20, I18n.func_135053_a("gui.cancel")));
        this.field_74082_u.field_73742_g = false;
        this.field_74083_t.field_73742_g = false;
        this.field_74081_v.field_73742_g = false;
        this.field_82316_w.field_73742_g = false;
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73742_g)
        {
            if (p_73875_1_.field_73741_f == 2)
            {
                String s = this.func_74063_d(this.field_74080_m);

                if (s != null)
                {
                    this.field_74084_s = true;
                    GuiYesNo guiyesno = func_74061_a(this, s, this.field_74080_m);
                    this.field_73882_e.func_71373_a(guiyesno);
                }
            }
            else if (p_73875_1_.field_73741_f == 1)
            {
                this.func_74064_e(this.field_74080_m);
            }
            else if (p_73875_1_.field_73741_f == 3)
            {
                this.field_73882_e.func_71373_a(new GuiCreateWorld(this));
            }
            else if (p_73875_1_.field_73741_f == 6)
            {
                this.field_73882_e.func_71373_a(new GuiRenameWorld(this, this.func_74069_a(this.field_74080_m)));
            }
            else if (p_73875_1_.field_73741_f == 0)
            {
                this.field_73882_e.func_71373_a(this.field_74077_a);
            }
            else if (p_73875_1_.field_73741_f == 7)
            {
                GuiCreateWorld guicreateworld = new GuiCreateWorld(this);
                ISaveHandler isavehandler = this.field_73882_e.func_71359_d().func_75804_a(this.func_74069_a(this.field_74080_m), false);
                WorldInfo worldinfo = isavehandler.func_75757_d();
                isavehandler.func_75759_a();
                guicreateworld.func_82286_a(worldinfo);
                this.field_73882_e.func_71373_a(guicreateworld);
            }
            else
            {
                this.field_74079_o.func_77219_a(p_73875_1_);
            }
        }
    }

    public void func_74064_e(int p_74064_1_)
    {
        this.field_73882_e.func_71373_a((GuiScreen)null);

        if (!this.field_74074_d)
        {
            this.field_74074_d = true;
            String s = this.func_74069_a(p_74064_1_);

            if (s == null)
            {
                s = "World" + p_74064_1_;
            }

            String s1 = this.func_74063_d(p_74064_1_);

            if (s1 == null)
            {
                s1 = "World" + p_74064_1_;
            }

            if (this.field_73882_e.func_71359_d().func_90033_f(s))
            {
                this.field_73882_e.func_71371_a(s, s1, (WorldSettings)null);
                this.field_73882_e.field_71413_E.func_77450_a(StatList.field_75949_h, 1);
            }
        }
    }

    public void func_73878_a(boolean p_73878_1_, int p_73878_2_)
    {
        if (this.field_74084_s)
        {
            this.field_74084_s = false;

            if (p_73878_1_)
            {
                ISaveFormat isaveformat = this.field_73882_e.func_71359_d();
                isaveformat.func_75800_d();
                isaveformat.func_75802_e(this.func_74069_a(p_73878_2_));

                try
                {
                    this.func_74073_h();
                }
                catch (AnvilConverterException anvilconverterexception)
                {
                    anvilconverterexception.printStackTrace();
                }
            }

            this.field_73882_e.func_71373_a(this);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.field_74079_o.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
        this.func_73732_a(this.field_73886_k, this.field_74075_b, this.field_73880_f / 2, 20, 16777215);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    public static GuiYesNo func_74061_a(GuiScreen p_74061_0_, String p_74061_1_, int p_74061_2_)
    {
        String s1 = I18n.func_135053_a("selectWorld.deleteQuestion");
        String s2 = "\'" + p_74061_1_ + "\' " + I18n.func_135053_a("selectWorld.deleteWarning");
        String s3 = I18n.func_135053_a("selectWorld.deleteButton");
        String s4 = I18n.func_135053_a("gui.cancel");
        GuiYesNo guiyesno = new GuiYesNo(p_74061_0_, s1, s2, s3, s4, p_74061_2_);
        return guiyesno;
    }

    static List func_74068_a(GuiSelectWorld p_74068_0_)
    {
        return p_74068_0_.field_74078_n;
    }

    static int func_74072_a(GuiSelectWorld p_74072_0_, int p_74072_1_)
    {
        return p_74072_0_.field_74080_m = p_74072_1_;
    }

    static int func_74062_b(GuiSelectWorld p_74062_0_)
    {
        return p_74062_0_.field_74080_m;
    }

    static GuiButton func_74070_c(GuiSelectWorld p_74070_0_)
    {
        return p_74070_0_.field_74082_u;
    }

    static GuiButton func_74059_d(GuiSelectWorld p_74059_0_)
    {
        return p_74059_0_.field_74083_t;
    }

    static GuiButton func_74071_e(GuiSelectWorld p_74071_0_)
    {
        return p_74071_0_.field_74081_v;
    }

    static GuiButton func_82312_f(GuiSelectWorld p_82312_0_)
    {
        return p_82312_0_.field_82316_w;
    }

    static String func_82313_g(GuiSelectWorld p_82313_0_)
    {
        return p_82313_0_.field_74087_p;
    }

    static DateFormat func_82315_h(GuiSelectWorld p_82315_0_)
    {
        return p_82315_0_.field_74076_c;
    }

    static String func_82311_i(GuiSelectWorld p_82311_0_)
    {
        return p_82311_0_.field_74086_q;
    }

    static String[] func_82314_j(GuiSelectWorld p_82314_0_)
    {
        return p_82314_0_.field_74085_r;
    }
}
