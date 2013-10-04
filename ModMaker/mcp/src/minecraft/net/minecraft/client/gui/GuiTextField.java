package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ChatAllowedCharacters;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiTextField extends Gui
{
    private final FontRenderer field_73815_a;
    private final int field_73813_b;
    private final int field_73814_c;
    private final int field_73811_d;
    private final int field_73812_e;
    private String field_73809_f = "";
    private int field_73810_g = 32;
    private int field_73822_h;
    private boolean field_73820_j = true;
    private boolean field_73821_k = true;
    private boolean field_73818_l;
    private boolean field_73819_m = true;
    private int field_73816_n;
    private int field_73817_o;
    private int field_73826_p;
    private int field_73825_q = 14737632;
    private int field_73824_r = 7368816;
    private boolean field_73823_s = true;

    public GuiTextField(FontRenderer p_i1032_1_, int p_i1032_2_, int p_i1032_3_, int p_i1032_4_, int p_i1032_5_)
    {
        this.field_73815_a = p_i1032_1_;
        this.field_73813_b = p_i1032_2_;
        this.field_73814_c = p_i1032_3_;
        this.field_73811_d = p_i1032_4_;
        this.field_73812_e = p_i1032_5_;
    }

    public void func_73780_a()
    {
        ++this.field_73822_h;
    }

    public void func_73782_a(String p_73782_1_)
    {
        if (p_73782_1_.length() > this.field_73810_g)
        {
            this.field_73809_f = p_73782_1_.substring(0, this.field_73810_g);
        }
        else
        {
            this.field_73809_f = p_73782_1_;
        }

        this.func_73803_e();
    }

    public String func_73781_b()
    {
        return this.field_73809_f;
    }

    public String func_73807_c()
    {
        int i = this.field_73817_o < this.field_73826_p ? this.field_73817_o : this.field_73826_p;
        int j = this.field_73817_o < this.field_73826_p ? this.field_73826_p : this.field_73817_o;
        return this.field_73809_f.substring(i, j);
    }

    public void func_73792_b(String p_73792_1_)
    {
        String s1 = "";
        String s2 = ChatAllowedCharacters.func_71565_a(p_73792_1_);
        int i = this.field_73817_o < this.field_73826_p ? this.field_73817_o : this.field_73826_p;
        int j = this.field_73817_o < this.field_73826_p ? this.field_73826_p : this.field_73817_o;
        int k = this.field_73810_g - this.field_73809_f.length() - (i - this.field_73826_p);
        boolean flag = false;

        if (this.field_73809_f.length() > 0)
        {
            s1 = s1 + this.field_73809_f.substring(0, i);
        }

        int l;

        if (k < s2.length())
        {
            s1 = s1 + s2.substring(0, k);
            l = k;
        }
        else
        {
            s1 = s1 + s2;
            l = s2.length();
        }

        if (this.field_73809_f.length() > 0 && j < this.field_73809_f.length())
        {
            s1 = s1 + this.field_73809_f.substring(j);
        }

        this.field_73809_f = s1;
        this.func_73784_d(i - this.field_73826_p + l);
    }

    public void func_73779_a(int p_73779_1_)
    {
        if (this.field_73809_f.length() != 0)
        {
            if (this.field_73826_p != this.field_73817_o)
            {
                this.func_73792_b("");
            }
            else
            {
                this.func_73777_b(this.func_73788_c(p_73779_1_) - this.field_73817_o);
            }
        }
    }

    public void func_73777_b(int p_73777_1_)
    {
        if (this.field_73809_f.length() != 0)
        {
            if (this.field_73826_p != this.field_73817_o)
            {
                this.func_73792_b("");
            }
            else
            {
                boolean flag = p_73777_1_ < 0;
                int j = flag ? this.field_73817_o + p_73777_1_ : this.field_73817_o;
                int k = flag ? this.field_73817_o : this.field_73817_o + p_73777_1_;
                String s = "";

                if (j >= 0)
                {
                    s = this.field_73809_f.substring(0, j);
                }

                if (k < this.field_73809_f.length())
                {
                    s = s + this.field_73809_f.substring(k);
                }

                this.field_73809_f = s;

                if (flag)
                {
                    this.func_73784_d(p_73777_1_);
                }
            }
        }
    }

    public int func_73788_c(int p_73788_1_)
    {
        return this.func_73785_a(p_73788_1_, this.func_73799_h());
    }

    public int func_73785_a(int p_73785_1_, int p_73785_2_)
    {
        return this.func_73798_a(p_73785_1_, this.func_73799_h(), true);
    }

    public int func_73798_a(int p_73798_1_, int p_73798_2_, boolean p_73798_3_)
    {
        int k = p_73798_2_;
        boolean flag1 = p_73798_1_ < 0;
        int l = Math.abs(p_73798_1_);

        for (int i1 = 0; i1 < l; ++i1)
        {
            if (flag1)
            {
                while (p_73798_3_ && k > 0 && this.field_73809_f.charAt(k - 1) == 32)
                {
                    --k;
                }

                while (k > 0 && this.field_73809_f.charAt(k - 1) != 32)
                {
                    --k;
                }
            }
            else
            {
                int j1 = this.field_73809_f.length();
                k = this.field_73809_f.indexOf(32, k);

                if (k == -1)
                {
                    k = j1;
                }
                else
                {
                    while (p_73798_3_ && k < j1 && this.field_73809_f.charAt(k) == 32)
                    {
                        ++k;
                    }
                }
            }
        }

        return k;
    }

    public void func_73784_d(int p_73784_1_)
    {
        this.func_73791_e(this.field_73826_p + p_73784_1_);
    }

    public void func_73791_e(int p_73791_1_)
    {
        this.field_73817_o = p_73791_1_;
        int j = this.field_73809_f.length();

        if (this.field_73817_o < 0)
        {
            this.field_73817_o = 0;
        }

        if (this.field_73817_o > j)
        {
            this.field_73817_o = j;
        }

        this.func_73800_i(this.field_73817_o);
    }

    public void func_73797_d()
    {
        this.func_73791_e(0);
    }

    public void func_73803_e()
    {
        this.func_73791_e(this.field_73809_f.length());
    }

    public boolean func_73802_a(char p_73802_1_, int p_73802_2_)
    {
        if (this.field_73819_m && this.field_73818_l)
        {
            switch (p_73802_1_)
            {
                case 1:
                    this.func_73803_e();
                    this.func_73800_i(0);
                    return true;
                case 3:
                    GuiScreen.func_73865_d(this.func_73807_c());
                    return true;
                case 22:
                    this.func_73792_b(GuiScreen.func_73870_l());
                    return true;
                case 24:
                    GuiScreen.func_73865_d(this.func_73807_c());
                    this.func_73792_b("");
                    return true;
                default:
                    switch (p_73802_2_)
                    {
                        case 14:
                            if (GuiScreen.func_73861_o())
                            {
                                this.func_73779_a(-1);
                            }
                            else
                            {
                                this.func_73777_b(-1);
                            }

                            return true;
                        case 199:
                            if (GuiScreen.func_73877_p())
                            {
                                this.func_73800_i(0);
                            }
                            else
                            {
                                this.func_73797_d();
                            }

                            return true;
                        case 203:
                            if (GuiScreen.func_73877_p())
                            {
                                if (GuiScreen.func_73861_o())
                                {
                                    this.func_73800_i(this.func_73785_a(-1, this.func_73787_n()));
                                }
                                else
                                {
                                    this.func_73800_i(this.func_73787_n() - 1);
                                }
                            }
                            else if (GuiScreen.func_73861_o())
                            {
                                this.func_73791_e(this.func_73788_c(-1));
                            }
                            else
                            {
                                this.func_73784_d(-1);
                            }

                            return true;
                        case 205:
                            if (GuiScreen.func_73877_p())
                            {
                                if (GuiScreen.func_73861_o())
                                {
                                    this.func_73800_i(this.func_73785_a(1, this.func_73787_n()));
                                }
                                else
                                {
                                    this.func_73800_i(this.func_73787_n() + 1);
                                }
                            }
                            else if (GuiScreen.func_73861_o())
                            {
                                this.func_73791_e(this.func_73788_c(1));
                            }
                            else
                            {
                                this.func_73784_d(1);
                            }

                            return true;
                        case 207:
                            if (GuiScreen.func_73877_p())
                            {
                                this.func_73800_i(this.field_73809_f.length());
                            }
                            else
                            {
                                this.func_73803_e();
                            }

                            return true;
                        case 211:
                            if (GuiScreen.func_73861_o())
                            {
                                this.func_73779_a(1);
                            }
                            else
                            {
                                this.func_73777_b(1);
                            }

                            return true;
                        default:
                            if (ChatAllowedCharacters.func_71566_a(p_73802_1_))
                            {
                                this.func_73792_b(Character.toString(p_73802_1_));
                                return true;
                            }
                            else
                            {
                                return false;
                            }
                    }
            }
        }
        else
        {
            return false;
        }
    }

    public void func_73793_a(int p_73793_1_, int p_73793_2_, int p_73793_3_)
    {
        boolean flag = p_73793_1_ >= this.field_73813_b && p_73793_1_ < this.field_73813_b + this.field_73811_d && p_73793_2_ >= this.field_73814_c && p_73793_2_ < this.field_73814_c + this.field_73812_e;

        if (this.field_73821_k)
        {
            this.func_73796_b(this.field_73819_m && flag);
        }

        if (this.field_73818_l && p_73793_3_ == 0)
        {
            int l = p_73793_1_ - this.field_73813_b;

            if (this.field_73820_j)
            {
                l -= 4;
            }

            String s = this.field_73815_a.func_78269_a(this.field_73809_f.substring(this.field_73816_n), this.func_73801_o());
            this.func_73791_e(this.field_73815_a.func_78269_a(s, l).length() + this.field_73816_n);
        }
    }

    public void func_73795_f()
    {
        if (this.func_73778_q())
        {
            if (this.func_73783_i())
            {
                func_73734_a(this.field_73813_b - 1, this.field_73814_c - 1, this.field_73813_b + this.field_73811_d + 1, this.field_73814_c + this.field_73812_e + 1, -6250336);
                func_73734_a(this.field_73813_b, this.field_73814_c, this.field_73813_b + this.field_73811_d, this.field_73814_c + this.field_73812_e, -16777216);
            }

            int i = this.field_73819_m ? this.field_73825_q : this.field_73824_r;
            int j = this.field_73817_o - this.field_73816_n;
            int k = this.field_73826_p - this.field_73816_n;
            String s = this.field_73815_a.func_78269_a(this.field_73809_f.substring(this.field_73816_n), this.func_73801_o());
            boolean flag = j >= 0 && j <= s.length();
            boolean flag1 = this.field_73818_l && this.field_73822_h / 6 % 2 == 0 && flag;
            int l = this.field_73820_j ? this.field_73813_b + 4 : this.field_73813_b;
            int i1 = this.field_73820_j ? this.field_73814_c + (this.field_73812_e - 8) / 2 : this.field_73814_c;
            int j1 = l;

            if (k > s.length())
            {
                k = s.length();
            }

            if (s.length() > 0)
            {
                String s1 = flag ? s.substring(0, j) : s;
                j1 = this.field_73815_a.func_78261_a(s1, l, i1, i);
            }

            boolean flag2 = this.field_73817_o < this.field_73809_f.length() || this.field_73809_f.length() >= this.func_73808_g();
            int k1 = j1;

            if (!flag)
            {
                k1 = j > 0 ? l + this.field_73811_d : l;
            }
            else if (flag2)
            {
                k1 = j1 - 1;
                --j1;
            }

            if (s.length() > 0 && flag && j < s.length())
            {
                this.field_73815_a.func_78261_a(s.substring(j), j1, i1, i);
            }

            if (flag1)
            {
                if (flag2)
                {
                    Gui.func_73734_a(k1, i1 - 1, k1 + 1, i1 + 1 + this.field_73815_a.field_78288_b, -3092272);
                }
                else
                {
                    this.field_73815_a.func_78261_a("_", k1, i1, i);
                }
            }

            if (k != j)
            {
                int l1 = l + this.field_73815_a.func_78256_a(s.substring(0, k));
                this.func_73789_c(k1, i1 - 1, l1 - 1, i1 + 1 + this.field_73815_a.field_78288_b);
            }
        }
    }

    private void func_73789_c(int p_73789_1_, int p_73789_2_, int p_73789_3_, int p_73789_4_)
    {
        int i1;

        if (p_73789_1_ < p_73789_3_)
        {
            i1 = p_73789_1_;
            p_73789_1_ = p_73789_3_;
            p_73789_3_ = i1;
        }

        if (p_73789_2_ < p_73789_4_)
        {
            i1 = p_73789_2_;
            p_73789_2_ = p_73789_4_;
            p_73789_4_ = i1;
        }

        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glColor4f(0.0F, 0.0F, 255.0F, 255.0F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_COLOR_LOGIC_OP);
        GL11.glLogicOp(GL11.GL_OR_REVERSE);
        tessellator.func_78382_b();
        tessellator.func_78377_a((double)p_73789_1_, (double)p_73789_4_, 0.0D);
        tessellator.func_78377_a((double)p_73789_3_, (double)p_73789_4_, 0.0D);
        tessellator.func_78377_a((double)p_73789_3_, (double)p_73789_2_, 0.0D);
        tessellator.func_78377_a((double)p_73789_1_, (double)p_73789_2_, 0.0D);
        tessellator.func_78381_a();
        GL11.glDisable(GL11.GL_COLOR_LOGIC_OP);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

    public void func_73804_f(int p_73804_1_)
    {
        this.field_73810_g = p_73804_1_;

        if (this.field_73809_f.length() > p_73804_1_)
        {
            this.field_73809_f = this.field_73809_f.substring(0, p_73804_1_);
        }
    }

    public int func_73808_g()
    {
        return this.field_73810_g;
    }

    public int func_73799_h()
    {
        return this.field_73817_o;
    }

    public boolean func_73783_i()
    {
        return this.field_73820_j;
    }

    public void func_73786_a(boolean p_73786_1_)
    {
        this.field_73820_j = p_73786_1_;
    }

    public void func_73794_g(int p_73794_1_)
    {
        this.field_73825_q = p_73794_1_;
    }

    public void func_82266_h(int p_82266_1_)
    {
        this.field_73824_r = p_82266_1_;
    }

    public void func_73796_b(boolean p_73796_1_)
    {
        if (p_73796_1_ && !this.field_73818_l)
        {
            this.field_73822_h = 0;
        }

        this.field_73818_l = p_73796_1_;
    }

    public boolean func_73806_l()
    {
        return this.field_73818_l;
    }

    public void func_82265_c(boolean p_82265_1_)
    {
        this.field_73819_m = p_82265_1_;
    }

    public int func_73787_n()
    {
        return this.field_73826_p;
    }

    public int func_73801_o()
    {
        return this.func_73783_i() ? this.field_73811_d - 8 : this.field_73811_d;
    }

    public void func_73800_i(int p_73800_1_)
    {
        int j = this.field_73809_f.length();

        if (p_73800_1_ > j)
        {
            p_73800_1_ = j;
        }

        if (p_73800_1_ < 0)
        {
            p_73800_1_ = 0;
        }

        this.field_73826_p = p_73800_1_;

        if (this.field_73815_a != null)
        {
            if (this.field_73816_n > j)
            {
                this.field_73816_n = j;
            }

            int k = this.func_73801_o();
            String s = this.field_73815_a.func_78269_a(this.field_73809_f.substring(this.field_73816_n), k);
            int l = s.length() + this.field_73816_n;

            if (p_73800_1_ == this.field_73816_n)
            {
                this.field_73816_n -= this.field_73815_a.func_78262_a(this.field_73809_f, k, true).length();
            }

            if (p_73800_1_ > l)
            {
                this.field_73816_n += p_73800_1_ - l;
            }
            else if (p_73800_1_ <= this.field_73816_n)
            {
                this.field_73816_n -= this.field_73816_n - p_73800_1_;
            }

            if (this.field_73816_n < 0)
            {
                this.field_73816_n = 0;
            }

            if (this.field_73816_n > j)
            {
                this.field_73816_n = j;
            }
        }
    }

    public void func_73805_d(boolean p_73805_1_)
    {
        this.field_73821_k = p_73805_1_;
    }

    public boolean func_73778_q()
    {
        return this.field_73823_s;
    }

    public void func_73790_e(boolean p_73790_1_)
    {
        this.field_73823_s = p_73790_1_;
    }
}
