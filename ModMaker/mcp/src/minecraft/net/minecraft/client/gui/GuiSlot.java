package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class GuiSlot
{
    private final Minecraft field_77233_a;
    private int field_77228_g;
    private int field_77240_h;
    protected int field_77231_b;
    protected int field_77232_c;
    private int field_77241_i;
    private int field_77238_j;
    protected final int field_77229_d;
    private int field_77239_k;
    private int field_77236_l;
    protected int field_77230_e;
    protected int field_77227_f;
    private float field_77237_m = -2.0F;
    private float field_77234_n;
    private float field_77235_o;
    private int field_77246_p = -1;
    private long field_77245_q;
    private boolean field_77244_r = true;
    private boolean field_77243_s;
    private int field_77242_t;

    public GuiSlot(Minecraft p_i1052_1_, int p_i1052_2_, int p_i1052_3_, int p_i1052_4_, int p_i1052_5_, int p_i1052_6_)
    {
        this.field_77233_a = p_i1052_1_;
        this.field_77228_g = p_i1052_2_;
        this.field_77240_h = p_i1052_3_;
        this.field_77231_b = p_i1052_4_;
        this.field_77232_c = p_i1052_5_;
        this.field_77229_d = p_i1052_6_;
        this.field_77238_j = 0;
        this.field_77241_i = p_i1052_2_;
    }

    public void func_77207_a(int p_77207_1_, int p_77207_2_, int p_77207_3_, int p_77207_4_)
    {
        this.field_77228_g = p_77207_1_;
        this.field_77240_h = p_77207_2_;
        this.field_77231_b = p_77207_3_;
        this.field_77232_c = p_77207_4_;
        this.field_77238_j = 0;
        this.field_77241_i = p_77207_1_;
    }

    public void func_77216_a(boolean p_77216_1_)
    {
        this.field_77244_r = p_77216_1_;
    }

    protected void func_77223_a(boolean p_77223_1_, int p_77223_2_)
    {
        this.field_77243_s = p_77223_1_;
        this.field_77242_t = p_77223_2_;

        if (!p_77223_1_)
        {
            this.field_77242_t = 0;
        }
    }

    protected abstract int func_77217_a();

    protected abstract void func_77213_a(int i, boolean flag);

    protected abstract boolean func_77218_a(int i);

    protected int func_77212_b()
    {
        return this.func_77217_a() * this.field_77229_d + this.field_77242_t;
    }

    protected abstract void func_77221_c();

    protected abstract void func_77214_a(int i, int j, int k, int l, Tessellator tessellator);

    protected void func_77222_a(int p_77222_1_, int p_77222_2_, Tessellator p_77222_3_) {}

    protected void func_77224_a(int p_77224_1_, int p_77224_2_) {}

    protected void func_77215_b(int p_77215_1_, int p_77215_2_) {}

    public int func_77210_c(int p_77210_1_, int p_77210_2_)
    {
        int k = this.field_77228_g / 2 - 110;
        int l = this.field_77228_g / 2 + 110;
        int i1 = p_77210_2_ - this.field_77231_b - this.field_77242_t + (int)this.field_77235_o - 4;
        int j1 = i1 / this.field_77229_d;
        return p_77210_1_ >= k && p_77210_1_ <= l && j1 >= 0 && i1 >= 0 && j1 < this.func_77217_a() ? j1 : -1;
    }

    public void func_77220_a(int p_77220_1_, int p_77220_2_)
    {
        this.field_77239_k = p_77220_1_;
        this.field_77236_l = p_77220_2_;
    }

    private void func_77226_h()
    {
        int i = this.func_77209_d();

        if (i < 0)
        {
            i /= 2;
        }

        if (this.field_77235_o < 0.0F)
        {
            this.field_77235_o = 0.0F;
        }

        if (this.field_77235_o > (float)i)
        {
            this.field_77235_o = (float)i;
        }
    }

    public int func_77209_d()
    {
        return this.func_77212_b() - (this.field_77232_c - this.field_77231_b - 4);
    }

    public void func_77208_b(int p_77208_1_)
    {
        this.field_77235_o += (float)p_77208_1_;
        this.func_77226_h();
        this.field_77237_m = -2.0F;
    }

    public void func_77219_a(GuiButton p_77219_1_)
    {
        if (p_77219_1_.field_73742_g)
        {
            if (p_77219_1_.field_73741_f == this.field_77239_k)
            {
                this.field_77235_o -= (float)(this.field_77229_d * 2 / 3);
                this.field_77237_m = -2.0F;
                this.func_77226_h();
            }
            else if (p_77219_1_.field_73741_f == this.field_77236_l)
            {
                this.field_77235_o += (float)(this.field_77229_d * 2 / 3);
                this.field_77237_m = -2.0F;
                this.func_77226_h();
            }
        }
    }

    public void func_77211_a(int p_77211_1_, int p_77211_2_, float p_77211_3_)
    {
        this.field_77230_e = p_77211_1_;
        this.field_77227_f = p_77211_2_;
        this.func_77221_c();
        int k = this.func_77217_a();
        int l = this.func_77225_g();
        int i1 = l + 6;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;

        if (Mouse.isButtonDown(0))
        {
            if (this.field_77237_m == -1.0F)
            {
                boolean flag = true;

                if (p_77211_2_ >= this.field_77231_b && p_77211_2_ <= this.field_77232_c)
                {
                    int k2 = this.field_77228_g / 2 - 110;
                    j1 = this.field_77228_g / 2 + 110;
                    k1 = p_77211_2_ - this.field_77231_b - this.field_77242_t + (int)this.field_77235_o - 4;
                    l1 = k1 / this.field_77229_d;

                    if (p_77211_1_ >= k2 && p_77211_1_ <= j1 && l1 >= 0 && k1 >= 0 && l1 < k)
                    {
                        boolean flag1 = l1 == this.field_77246_p && Minecraft.func_71386_F() - this.field_77245_q < 250L;
                        this.func_77213_a(l1, flag1);
                        this.field_77246_p = l1;
                        this.field_77245_q = Minecraft.func_71386_F();
                    }
                    else if (p_77211_1_ >= k2 && p_77211_1_ <= j1 && k1 < 0)
                    {
                        this.func_77224_a(p_77211_1_ - k2, p_77211_2_ - this.field_77231_b + (int)this.field_77235_o - 4);
                        flag = false;
                    }

                    if (p_77211_1_ >= l && p_77211_1_ <= i1)
                    {
                        this.field_77234_n = -1.0F;
                        j2 = this.func_77209_d();

                        if (j2 < 1)
                        {
                            j2 = 1;
                        }

                        i2 = (int)((float)((this.field_77232_c - this.field_77231_b) * (this.field_77232_c - this.field_77231_b)) / (float)this.func_77212_b());

                        if (i2 < 32)
                        {
                            i2 = 32;
                        }

                        if (i2 > this.field_77232_c - this.field_77231_b - 8)
                        {
                            i2 = this.field_77232_c - this.field_77231_b - 8;
                        }

                        this.field_77234_n /= (float)(this.field_77232_c - this.field_77231_b - i2) / (float)j2;
                    }
                    else
                    {
                        this.field_77234_n = 1.0F;
                    }

                    if (flag)
                    {
                        this.field_77237_m = (float)p_77211_2_;
                    }
                    else
                    {
                        this.field_77237_m = -2.0F;
                    }
                }
                else
                {
                    this.field_77237_m = -2.0F;
                }
            }
            else if (this.field_77237_m >= 0.0F)
            {
                this.field_77235_o -= ((float)p_77211_2_ - this.field_77237_m) * this.field_77234_n;
                this.field_77237_m = (float)p_77211_2_;
            }
        }
        else
        {
            while (!this.field_77233_a.field_71474_y.field_85185_A && Mouse.next())
            {
                int l2 = Mouse.getEventDWheel();

                if (l2 != 0)
                {
                    if (l2 > 0)
                    {
                        l2 = -1;
                    }
                    else if (l2 < 0)
                    {
                        l2 = 1;
                    }

                    this.field_77235_o += (float)(l2 * this.field_77229_d / 2);
                }
            }

            this.field_77237_m = -1.0F;
        }

        this.func_77226_h();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        Tessellator tessellator = Tessellator.field_78398_a;
        this.field_77233_a.func_110434_K().func_110577_a(Gui.field_110325_k);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f1 = 32.0F;
        tessellator.func_78382_b();
        tessellator.func_78378_d(2105376);
        tessellator.func_78374_a((double)this.field_77238_j, (double)this.field_77232_c, 0.0D, (double)((float)this.field_77238_j / f1), (double)((float)(this.field_77232_c + (int)this.field_77235_o) / f1));
        tessellator.func_78374_a((double)this.field_77241_i, (double)this.field_77232_c, 0.0D, (double)((float)this.field_77241_i / f1), (double)((float)(this.field_77232_c + (int)this.field_77235_o) / f1));
        tessellator.func_78374_a((double)this.field_77241_i, (double)this.field_77231_b, 0.0D, (double)((float)this.field_77241_i / f1), (double)((float)(this.field_77231_b + (int)this.field_77235_o) / f1));
        tessellator.func_78374_a((double)this.field_77238_j, (double)this.field_77231_b, 0.0D, (double)((float)this.field_77238_j / f1), (double)((float)(this.field_77231_b + (int)this.field_77235_o) / f1));
        tessellator.func_78381_a();
        j1 = this.field_77228_g / 2 - 92 - 16;
        k1 = this.field_77231_b + 4 - (int)this.field_77235_o;

        if (this.field_77243_s)
        {
            this.func_77222_a(j1, k1, tessellator);
        }

        int i3;

        for (l1 = 0; l1 < k; ++l1)
        {
            j2 = k1 + l1 * this.field_77229_d + this.field_77242_t;
            i2 = this.field_77229_d - 4;

            if (j2 <= this.field_77232_c && j2 + i2 >= this.field_77231_b)
            {
                if (this.field_77244_r && this.func_77218_a(l1))
                {
                    i3 = this.field_77228_g / 2 - 110;
                    int j3 = this.field_77228_g / 2 + 110;
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glDisable(GL11.GL_TEXTURE_2D);
                    tessellator.func_78382_b();
                    tessellator.func_78378_d(8421504);
                    tessellator.func_78374_a((double)i3, (double)(j2 + i2 + 2), 0.0D, 0.0D, 1.0D);
                    tessellator.func_78374_a((double)j3, (double)(j2 + i2 + 2), 0.0D, 1.0D, 1.0D);
                    tessellator.func_78374_a((double)j3, (double)(j2 - 2), 0.0D, 1.0D, 0.0D);
                    tessellator.func_78374_a((double)i3, (double)(j2 - 2), 0.0D, 0.0D, 0.0D);
                    tessellator.func_78378_d(0);
                    tessellator.func_78374_a((double)(i3 + 1), (double)(j2 + i2 + 1), 0.0D, 0.0D, 1.0D);
                    tessellator.func_78374_a((double)(j3 - 1), (double)(j2 + i2 + 1), 0.0D, 1.0D, 1.0D);
                    tessellator.func_78374_a((double)(j3 - 1), (double)(j2 - 1), 0.0D, 1.0D, 0.0D);
                    tessellator.func_78374_a((double)(i3 + 1), (double)(j2 - 1), 0.0D, 0.0D, 0.0D);
                    tessellator.func_78381_a();
                    GL11.glEnable(GL11.GL_TEXTURE_2D);
                }

                this.func_77214_a(l1, j1, j2, i2, tessellator);
            }
        }

        GL11.glDisable(GL11.GL_DEPTH_TEST);
        byte b0 = 4;
        this.func_77206_b(0, this.field_77231_b, 255, 255);
        this.func_77206_b(this.field_77232_c, this.field_77240_h, 255, 255);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        tessellator.func_78382_b();
        tessellator.func_78384_a(0, 0);
        tessellator.func_78374_a((double)this.field_77238_j, (double)(this.field_77231_b + b0), 0.0D, 0.0D, 1.0D);
        tessellator.func_78374_a((double)this.field_77241_i, (double)(this.field_77231_b + b0), 0.0D, 1.0D, 1.0D);
        tessellator.func_78384_a(0, 255);
        tessellator.func_78374_a((double)this.field_77241_i, (double)this.field_77231_b, 0.0D, 1.0D, 0.0D);
        tessellator.func_78374_a((double)this.field_77238_j, (double)this.field_77231_b, 0.0D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78384_a(0, 255);
        tessellator.func_78374_a((double)this.field_77238_j, (double)this.field_77232_c, 0.0D, 0.0D, 1.0D);
        tessellator.func_78374_a((double)this.field_77241_i, (double)this.field_77232_c, 0.0D, 1.0D, 1.0D);
        tessellator.func_78384_a(0, 0);
        tessellator.func_78374_a((double)this.field_77241_i, (double)(this.field_77232_c - b0), 0.0D, 1.0D, 0.0D);
        tessellator.func_78374_a((double)this.field_77238_j, (double)(this.field_77232_c - b0), 0.0D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        j2 = this.func_77209_d();

        if (j2 > 0)
        {
            i2 = (this.field_77232_c - this.field_77231_b) * (this.field_77232_c - this.field_77231_b) / this.func_77212_b();

            if (i2 < 32)
            {
                i2 = 32;
            }

            if (i2 > this.field_77232_c - this.field_77231_b - 8)
            {
                i2 = this.field_77232_c - this.field_77231_b - 8;
            }

            i3 = (int)this.field_77235_o * (this.field_77232_c - this.field_77231_b - i2) / j2 + this.field_77231_b;

            if (i3 < this.field_77231_b)
            {
                i3 = this.field_77231_b;
            }

            tessellator.func_78382_b();
            tessellator.func_78384_a(0, 255);
            tessellator.func_78374_a((double)l, (double)this.field_77232_c, 0.0D, 0.0D, 1.0D);
            tessellator.func_78374_a((double)i1, (double)this.field_77232_c, 0.0D, 1.0D, 1.0D);
            tessellator.func_78374_a((double)i1, (double)this.field_77231_b, 0.0D, 1.0D, 0.0D);
            tessellator.func_78374_a((double)l, (double)this.field_77231_b, 0.0D, 0.0D, 0.0D);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78384_a(8421504, 255);
            tessellator.func_78374_a((double)l, (double)(i3 + i2), 0.0D, 0.0D, 1.0D);
            tessellator.func_78374_a((double)i1, (double)(i3 + i2), 0.0D, 1.0D, 1.0D);
            tessellator.func_78374_a((double)i1, (double)i3, 0.0D, 1.0D, 0.0D);
            tessellator.func_78374_a((double)l, (double)i3, 0.0D, 0.0D, 0.0D);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78384_a(12632256, 255);
            tessellator.func_78374_a((double)l, (double)(i3 + i2 - 1), 0.0D, 0.0D, 1.0D);
            tessellator.func_78374_a((double)(i1 - 1), (double)(i3 + i2 - 1), 0.0D, 1.0D, 1.0D);
            tessellator.func_78374_a((double)(i1 - 1), (double)i3, 0.0D, 1.0D, 0.0D);
            tessellator.func_78374_a((double)l, (double)i3, 0.0D, 0.0D, 0.0D);
            tessellator.func_78381_a();
        }

        this.func_77215_b(p_77211_1_, p_77211_2_);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glDisable(GL11.GL_BLEND);
    }

    protected int func_77225_g()
    {
        return this.field_77228_g / 2 + 124;
    }

    protected void func_77206_b(int p_77206_1_, int p_77206_2_, int p_77206_3_, int p_77206_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        this.field_77233_a.func_110434_K().func_110577_a(Gui.field_110325_k);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32.0F;
        tessellator.func_78382_b();
        tessellator.func_78384_a(4210752, p_77206_4_);
        tessellator.func_78374_a(0.0D, (double)p_77206_2_, 0.0D, 0.0D, (double)((float)p_77206_2_ / f));
        tessellator.func_78374_a((double)this.field_77228_g, (double)p_77206_2_, 0.0D, (double)((float)this.field_77228_g / f), (double)((float)p_77206_2_ / f));
        tessellator.func_78384_a(4210752, p_77206_3_);
        tessellator.func_78374_a((double)this.field_77228_g, (double)p_77206_1_, 0.0D, (double)((float)this.field_77228_g / f), (double)((float)p_77206_1_ / f));
        tessellator.func_78374_a(0.0D, (double)p_77206_1_, 0.0D, 0.0D, (double)((float)p_77206_1_ / f));
        tessellator.func_78381_a();
    }
}
