package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.network.packet.Packet203AutoComplete;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@SideOnly(Side.CLIENT)
public class GuiChat extends GuiScreen
{
    private String field_73898_b = "";
    private int field_73899_c = -1;
    private boolean field_73897_d;
    private boolean field_73905_m;
    private int field_73903_n;
    private List field_73904_o = new ArrayList();
    private URI field_73902_p;
    protected GuiTextField field_73901_a;
    private String field_73900_q = "";

    public GuiChat() {}

    public GuiChat(String p_i1024_1_)
    {
        this.field_73900_q = p_i1024_1_;
    }

    public void func_73866_w_()
    {
        Keyboard.enableRepeatEvents(true);
        this.field_73899_c = this.field_73882_e.field_71456_v.func_73827_b().func_73756_b().size();
        this.field_73901_a = new GuiTextField(this.field_73886_k, 4, this.field_73881_g - 12, this.field_73880_f - 4, 12);
        this.field_73901_a.func_73804_f(100);
        this.field_73901_a.func_73786_a(false);
        this.field_73901_a.func_73796_b(true);
        this.field_73901_a.func_73782_a(this.field_73900_q);
        this.field_73901_a.func_73805_d(false);
    }

    public void func_73874_b()
    {
        Keyboard.enableRepeatEvents(false);
        this.field_73882_e.field_71456_v.func_73827_b().func_73764_c();
    }

    public void func_73876_c()
    {
        this.field_73901_a.func_73780_a();
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        this.field_73905_m = false;

        if (p_73869_2_ == 15)
        {
            this.func_73895_u_();
        }
        else
        {
            this.field_73897_d = false;
        }

        if (p_73869_2_ == 1)
        {
            this.field_73882_e.func_71373_a((GuiScreen)null);
        }
        else if (p_73869_2_ != 28 && p_73869_2_ != 156)
        {
            if (p_73869_2_ == 200)
            {
                this.func_73892_a(-1);
            }
            else if (p_73869_2_ == 208)
            {
                this.func_73892_a(1);
            }
            else if (p_73869_2_ == 201)
            {
                this.field_73882_e.field_71456_v.func_73827_b().func_73758_b(this.field_73882_e.field_71456_v.func_73827_b().func_96127_i() - 1);
            }
            else if (p_73869_2_ == 209)
            {
                this.field_73882_e.field_71456_v.func_73827_b().func_73758_b(-this.field_73882_e.field_71456_v.func_73827_b().func_96127_i() + 1);
            }
            else
            {
                this.field_73901_a.func_73802_a(p_73869_1_, p_73869_2_);
            }
        }
        else
        {
            String s = this.field_73901_a.func_73781_b().trim();

            if (s.length() > 0)
            {
                this.field_73882_e.field_71456_v.func_73827_b().func_73767_b(s);

                if (!this.field_73882_e.func_71409_c(s))
                {
                    this.field_73882_e.field_71439_g.func_71165_d(s);
                }
            }

            this.field_73882_e.func_71373_a((GuiScreen)null);
        }
    }

    public void func_73867_d()
    {
        super.func_73867_d();
        int i = Mouse.getEventDWheel();

        if (i != 0)
        {
            if (i > 1)
            {
                i = 1;
            }

            if (i < -1)
            {
                i = -1;
            }

            if (!func_73877_p())
            {
                i *= 7;
            }

            this.field_73882_e.field_71456_v.func_73827_b().func_73758_b(i);
        }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        if (p_73864_3_ == 0 && this.field_73882_e.field_71474_y.field_74359_p)
        {
            ChatClickData chatclickdata = this.field_73882_e.field_71456_v.func_73827_b().func_73766_a(Mouse.getX(), Mouse.getY());

            if (chatclickdata != null)
            {
                URI uri = chatclickdata.func_78308_g();

                if (uri != null)
                {
                    if (this.field_73882_e.field_71474_y.field_74358_q)
                    {
                        this.field_73902_p = uri;
                        this.field_73882_e.func_71373_a(new GuiConfirmOpenLink(this, chatclickdata.func_78309_f(), 0, false));
                    }
                    else
                    {
                        this.func_73896_a(uri);
                    }

                    return;
                }
            }
        }

        this.field_73901_a.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
    }

    public void func_73878_a(boolean p_73878_1_, int p_73878_2_)
    {
        if (p_73878_2_ == 0)
        {
            if (p_73878_1_)
            {
                this.func_73896_a(this.field_73902_p);
            }

            this.field_73902_p = null;
            this.field_73882_e.func_71373_a(this);
        }
    }

    private void func_73896_a(URI p_73896_1_)
    {
        try
        {
            Class oclass = Class.forName("java.awt.Desktop");
            Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
            oclass.getMethod("browse", new Class[] {URI.class}).invoke(object, new Object[] {p_73896_1_});
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void func_73895_u_()
    {
        String s;

        if (this.field_73897_d)
        {
            this.field_73901_a.func_73777_b(this.field_73901_a.func_73798_a(-1, this.field_73901_a.func_73799_h(), false) - this.field_73901_a.func_73799_h());

            if (this.field_73903_n >= this.field_73904_o.size())
            {
                this.field_73903_n = 0;
            }
        }
        else
        {
            int i = this.field_73901_a.func_73798_a(-1, this.field_73901_a.func_73799_h(), false);
            this.field_73904_o.clear();
            this.field_73903_n = 0;
            String s1 = this.field_73901_a.func_73781_b().substring(i).toLowerCase();
            s = this.field_73901_a.func_73781_b().substring(0, this.field_73901_a.func_73799_h());
            this.func_73893_a(s, s1);

            if (this.field_73904_o.isEmpty())
            {
                return;
            }

            this.field_73897_d = true;
            this.field_73901_a.func_73777_b(i - this.field_73901_a.func_73799_h());
        }

        if (this.field_73904_o.size() > 1)
        {
            StringBuilder stringbuilder = new StringBuilder();

            for (Iterator iterator = this.field_73904_o.iterator(); iterator.hasNext(); stringbuilder.append(s))
            {
                s = (String)iterator.next();

                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(", ");
                }
            }

            this.field_73882_e.field_71456_v.func_73827_b().func_73763_a(stringbuilder.toString(), 1);
        }

        this.field_73901_a.func_73792_b((String)this.field_73904_o.get(this.field_73903_n++));
    }

    private void func_73893_a(String p_73893_1_, String p_73893_2_)
    {
        if (p_73893_1_.length() >= 1)
        {
            this.field_73882_e.field_71439_g.field_71174_a.func_72552_c(new Packet203AutoComplete(p_73893_1_));
            this.field_73905_m = true;
        }
    }

    public void func_73892_a(int p_73892_1_)
    {
        int j = this.field_73899_c + p_73892_1_;
        int k = this.field_73882_e.field_71456_v.func_73827_b().func_73756_b().size();

        if (j < 0)
        {
            j = 0;
        }

        if (j > k)
        {
            j = k;
        }

        if (j != this.field_73899_c)
        {
            if (j == k)
            {
                this.field_73899_c = k;
                this.field_73901_a.func_73782_a(this.field_73898_b);
            }
            else
            {
                if (this.field_73899_c == k)
                {
                    this.field_73898_b = this.field_73901_a.func_73781_b();
                }

                this.field_73901_a.func_73782_a((String)this.field_73882_e.field_71456_v.func_73827_b().func_73756_b().get(j));
                this.field_73899_c = j;
            }
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73734_a(2, this.field_73881_g - 14, this.field_73880_f - 2, this.field_73881_g - 2, Integer.MIN_VALUE);
        this.field_73901_a.func_73795_f();
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    public void func_73894_a(String[] p_73894_1_)
    {
        if (this.field_73905_m)
        {
            this.field_73904_o.clear();
            String[] astring1 = p_73894_1_;
            int i = p_73894_1_.length;

            for (int j = 0; j < i; ++j)
            {
                String s = astring1[j];

                if (s.length() > 0)
                {
                    this.field_73904_o.add(s);
                }
            }

            if (this.field_73904_o.size() > 0)
            {
                this.field_73897_d = true;
                this.func_73895_u_();
            }
        }
    }

    public boolean func_73868_f()
    {
        return false;
    }
}
