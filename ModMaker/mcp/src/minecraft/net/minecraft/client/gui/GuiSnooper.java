package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;

@SideOnly(Side.CLIENT)
public class GuiSnooper extends GuiScreen
{
    private final GuiScreen field_74100_a;
    private final GameSettings field_74097_b;
    private final List field_74098_c = new ArrayList();
    private final List field_74096_d = new ArrayList();
    private String field_74103_m;
    private String[] field_74101_n;
    private GuiSnooperList field_74102_o;
    private GuiButton field_74099_p;

    public GuiSnooper(GuiScreen p_i1061_1_, GameSettings p_i1061_2_)
    {
        this.field_74100_a = p_i1061_1_;
        this.field_74097_b = p_i1061_2_;
    }

    public void func_73866_w_()
    {
        this.field_74103_m = I18n.func_135053_a("options.snooper.title");
        String s = I18n.func_135053_a("options.snooper.desc");
        ArrayList arraylist = new ArrayList();
        Iterator iterator = this.field_73886_k.func_78271_c(s, this.field_73880_f - 30).iterator();

        while (iterator.hasNext())
        {
            String s1 = (String)iterator.next();
            arraylist.add(s1);
        }

        this.field_74101_n = (String[])arraylist.toArray(new String[0]);
        this.field_74098_c.clear();
        this.field_74096_d.clear();
        this.field_73887_h.add(this.field_74099_p = new GuiButton(1, this.field_73880_f / 2 - 152, this.field_73881_g - 30, 150, 20, this.field_74097_b.func_74297_c(EnumOptions.SNOOPER_ENABLED)));
        this.field_73887_h.add(new GuiButton(2, this.field_73880_f / 2 + 2, this.field_73881_g - 30, 150, 20, I18n.func_135053_a("gui.done")));
        boolean flag = this.field_73882_e.func_71401_C() != null && this.field_73882_e.func_71401_C().func_80003_ah() != null;
        Iterator iterator1 = (new TreeMap(this.field_73882_e.func_71378_E().func_76465_c())).entrySet().iterator();
        Entry entry;

        while (iterator1.hasNext())
        {
            entry = (Entry)iterator1.next();
            this.field_74098_c.add((flag ? "C " : "") + (String)entry.getKey());
            this.field_74096_d.add(this.field_73886_k.func_78269_a((String)entry.getValue(), this.field_73880_f - 220));
        }

        if (flag)
        {
            iterator1 = (new TreeMap(this.field_73882_e.func_71401_C().func_80003_ah().func_76465_c())).entrySet().iterator();

            while (iterator1.hasNext())
            {
                entry = (Entry)iterator1.next();
                this.field_74098_c.add("S " + (String)entry.getKey());
                this.field_74096_d.add(this.field_73886_k.func_78269_a((String)entry.getValue(), this.field_73880_f - 220));
            }
        }

        this.field_74102_o = new GuiSnooperList(this);
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73742_g)
        {
            if (p_73875_1_.field_73741_f == 2)
            {
                this.field_74097_b.func_74303_b();
                this.field_74097_b.func_74303_b();
                this.field_73882_e.func_71373_a(this.field_74100_a);
            }

            if (p_73875_1_.field_73741_f == 1)
            {
                this.field_74097_b.func_74306_a(EnumOptions.SNOOPER_ENABLED, 1);
                this.field_74099_p.field_73744_e = this.field_74097_b.func_74297_c(EnumOptions.SNOOPER_ENABLED);
            }
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.func_73873_v_();
        this.field_74102_o.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
        this.func_73732_a(this.field_73886_k, this.field_74103_m, this.field_73880_f / 2, 8, 16777215);
        int k = 22;
        String[] astring = this.field_74101_n;
        int l = astring.length;

        for (int i1 = 0; i1 < l; ++i1)
        {
            String s = astring[i1];
            this.func_73732_a(this.field_73886_k, s, this.field_73880_f / 2, k, 8421504);
            k += this.field_73886_k.field_78288_b;
        }

        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    static List func_74095_a(GuiSnooper p_74095_0_)
    {
        return p_74095_0_.field_74098_c;
    }

    static List func_74094_b(GuiSnooper p_74094_0_)
    {
        return p_74094_0_.field_74096_d;
    }
}
