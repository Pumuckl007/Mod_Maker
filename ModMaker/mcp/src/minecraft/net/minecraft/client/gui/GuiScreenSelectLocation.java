package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class GuiScreenSelectLocation
{
    private final Minecraft field_104092_f;
    private int field_104093_g;
    private int field_104105_h;
    protected int field_104098_a;
    protected int field_104096_b;
    private int field_104106_i;
    private int field_104103_j;
    protected final int field_104097_c;
    private int field_104104_k;
    private int field_104101_l;
    protected int field_104094_d;
    protected int field_104095_e;
    private float field_104102_m = -2.0F;
    private float field_104099_n;
    private float field_104100_o;
    private int field_104111_p = -1;
    private long field_104110_q;
    private boolean field_104109_r = true;
    private boolean field_104108_s;
    private int field_104107_t;

    public GuiScreenSelectLocation(Minecraft p_i1116_1_, int p_i1116_2_, int p_i1116_3_, int p_i1116_4_, int p_i1116_5_, int p_i1116_6_)
    {
        this.field_104092_f = p_i1116_1_;
        this.field_104093_g = p_i1116_2_;
        this.field_104105_h = p_i1116_3_;
        this.field_104098_a = p_i1116_4_;
        this.field_104096_b = p_i1116_5_;
        this.field_104097_c = p_i1116_6_;
        this.field_104103_j = 0;
        this.field_104106_i = p_i1116_2_;
    }

    public void func_104084_a(int p_104084_1_, int p_104084_2_, int p_104084_3_, int p_104084_4_)
    {
        this.field_104093_g = p_104084_1_;
        this.field_104105_h = p_104084_2_;
        this.field_104098_a = p_104084_3_;
        this.field_104096_b = p_104084_4_;
        this.field_104103_j = 0;
        this.field_104106_i = p_104084_1_;
    }

    protected abstract int func_77217_a();

    protected abstract void func_77213_a(int i, boolean flag);

    protected abstract boolean func_77218_a(int i);

    protected abstract boolean func_104086_b(int i);

    protected int func_130003_b()
    {
        return this.func_77217_a() * this.field_104097_c + this.field_104107_t;
    }

    protected abstract void func_130004_c();

    protected abstract void func_77214_a(int i, int j, int k, int l, Tessellator tessellator);

    protected void func_104088_a(int p_104088_1_, int p_104088_2_, Tessellator p_104088_3_) {}

    protected void func_104089_a(int p_104089_1_, int p_104089_2_) {}

    protected void func_104087_b(int p_104087_1_, int p_104087_2_) {}

    private void func_104091_h()
    {
        int i = this.func_104085_d();

        if (i < 0)
        {
            i /= 2;
        }

        if (this.field_104100_o < 0.0F)
        {
            this.field_104100_o = 0.0F;
        }

        if (this.field_104100_o > (float)i)
        {
            this.field_104100_o = (float)i;
        }
    }

    public int func_104085_d()
    {
        return this.func_130003_b() - (this.field_104096_b - this.field_104098_a - 4);
    }

    public void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73742_g)
        {
            if (p_73875_1_.field_73741_f == this.field_104104_k)
            {
                this.field_104100_o -= (float)(this.field_104097_c * 2 / 3);
                this.field_104102_m = -2.0F;
                this.func_104091_h();
            }
            else if (p_73875_1_.field_73741_f == this.field_104101_l)
            {
                this.field_104100_o += (float)(this.field_104097_c * 2 / 3);
                this.field_104102_m = -2.0F;
                this.func_104091_h();
            }
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.field_104094_d = p_73863_1_;
        this.field_104095_e = p_73863_2_;
        this.func_130004_c();
        int k = this.func_77217_a();
        int l = this.func_104090_g();
        int i1 = l + 6;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;

        if (Mouse.isButtonDown(0))
        {
            if (this.field_104102_m == -1.0F)
            {
                boolean flag = true;

                if (p_73863_2_ >= this.field_104098_a && p_73863_2_ <= this.field_104096_b)
                {
                    int k2 = this.field_104093_g / 2 - 110;
                    j1 = this.field_104093_g / 2 + 110;
                    k1 = p_73863_2_ - this.field_104098_a - this.field_104107_t + (int)this.field_104100_o - 4;
                    l1 = k1 / this.field_104097_c;

                    if (p_73863_1_ >= k2 && p_73863_1_ <= j1 && l1 >= 0 && k1 >= 0 && l1 < k)
                    {
                        boolean flag1 = l1 == this.field_104111_p && Minecraft.func_71386_F() - this.field_104110_q < 250L;
                        this.func_77213_a(l1, flag1);
                        this.field_104111_p = l1;
                        this.field_104110_q = Minecraft.func_71386_F();
                    }
                    else if (p_73863_1_ >= k2 && p_73863_1_ <= j1 && k1 < 0)
                    {
                        this.func_104089_a(p_73863_1_ - k2, p_73863_2_ - this.field_104098_a + (int)this.field_104100_o - 4);
                        flag = false;
                    }

                    if (p_73863_1_ >= l && p_73863_1_ <= i1)
                    {
                        this.field_104099_n = -1.0F;
                        j2 = this.func_104085_d();

                        if (j2 < 1)
                        {
                            j2 = 1;
                        }

                        i2 = (int)((float)((this.field_104096_b - this.field_104098_a) * (this.field_104096_b - this.field_104098_a)) / (float)this.func_130003_b());

                        if (i2 < 32)
                        {
                            i2 = 32;
                        }

                        if (i2 > this.field_104096_b - this.field_104098_a - 8)
                        {
                            i2 = this.field_104096_b - this.field_104098_a - 8;
                        }

                        this.field_104099_n /= (float)(this.field_104096_b - this.field_104098_a - i2) / (float)j2;
                    }
                    else
                    {
                        this.field_104099_n = 1.0F;
                    }

                    if (flag)
                    {
                        this.field_104102_m = (float)p_73863_2_;
                    }
                    else
                    {
                        this.field_104102_m = -2.0F;
                    }
                }
                else
                {
                    this.field_104102_m = -2.0F;
                }
            }
            else if (this.field_104102_m >= 0.0F)
            {
                this.field_104100_o -= ((float)p_73863_2_ - this.field_104102_m) * this.field_104099_n;
                this.field_104102_m = (float)p_73863_2_;
            }
        }
        else
        {
            while (!this.field_104092_f.field_71474_y.field_85185_A && Mouse.next())
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

                    this.field_104100_o += (float)(l2 * this.field_104097_c / 2);
                }
            }

            this.field_104102_m = -1.0F;
        }

        this.func_104091_h();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        Tessellator tessellator = Tessellator.field_78398_a;
        this.field_104092_f.func_110434_K().func_110577_a(Gui.field_110325_k);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f1 = 32.0F;
        tessellator.func_78382_b();
        tessellator.func_78378_d(2105376);
        tessellator.func_78374_a((double)this.field_104103_j, (double)this.field_104096_b, 0.0D, (double)((float)this.field_104103_j / f1), (double)((float)(this.field_104096_b + (int)this.field_104100_o) / f1));
        tessellator.func_78374_a((double)this.field_104106_i, (double)this.field_104096_b, 0.0D, (double)((float)this.field_104106_i / f1), (double)((float)(this.field_104096_b + (int)this.field_104100_o) / f1));
        tessellator.func_78374_a((double)this.field_104106_i, (double)this.field_104098_a, 0.0D, (double)((float)this.field_104106_i / f1), (double)((float)(this.field_104098_a + (int)this.field_104100_o) / f1));
        tessellator.func_78374_a((double)this.field_104103_j, (double)this.field_104098_a, 0.0D, (double)((float)this.field_104103_j / f1), (double)((float)(this.field_104098_a + (int)this.field_104100_o) / f1));
        tessellator.func_78381_a();
        j1 = this.field_104093_g / 2 - 92 - 16;
        k1 = this.field_104098_a + 4 - (int)this.field_104100_o;

        if (this.field_104108_s)
        {
            this.func_104088_a(j1, k1, tessellator);
        }

        int i3;

        for (l1 = 0; l1 < k; ++l1)
        {
            j2 = k1 + l1 * this.field_104097_c + this.field_104107_t;
            i2 = this.field_104097_c - 4;

            if (j2 <= this.field_104096_b && j2 + i2 >= this.field_104098_a)
            {
                int j3;

                if (this.field_104109_r && this.func_104086_b(l1))
                {
                    i3 = this.field_104093_g / 2 - 110;
                    j3 = this.field_104093_g / 2 + 110;
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glDisable(GL11.GL_TEXTURE_2D);
                    tessellator.func_78382_b();
                    tessellator.func_78378_d(0);
                    tessellator.func_78374_a((double)i3, (double)(j2 + i2 + 2), 0.0D, 0.0D, 1.0D);
                    tessellator.func_78374_a((double)j3, (double)(j2 + i2 + 2), 0.0D, 1.0D, 1.0D);
                    tessellator.func_78374_a((double)j3, (double)(j2 - 2), 0.0D, 1.0D, 0.0D);
                    tessellator.func_78374_a((double)i3, (double)(j2 - 2), 0.0D, 0.0D, 0.0D);
                    tessellator.func_78381_a();
                    GL11.glEnable(GL11.GL_TEXTURE_2D);
                }

                if (this.field_104109_r && this.func_77218_a(l1))
                {
                    i3 = this.field_104093_g / 2 - 110;
                    j3 = this.field_104093_g / 2 + 110;
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
        this.func_104083_b(0, this.field_104098_a, 255, 255);
        this.func_104083_b(this.field_104096_b, this.field_104105_h, 255, 255);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        tessellator.func_78382_b();
        tessellator.func_78384_a(0, 0);
        tessellator.func_78374_a((double)this.field_104103_j, (double)(this.field_104098_a + b0), 0.0D, 0.0D, 1.0D);
        tessellator.func_78374_a((double)this.field_104106_i, (double)(this.field_104098_a + b0), 0.0D, 1.0D, 1.0D);
        tessellator.func_78384_a(0, 255);
        tessellator.func_78374_a((double)this.field_104106_i, (double)this.field_104098_a, 0.0D, 1.0D, 0.0D);
        tessellator.func_78374_a((double)this.field_104103_j, (double)this.field_104098_a, 0.0D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        tessellator.func_78382_b();
        tessellator.func_78384_a(0, 255);
        tessellator.func_78374_a((double)this.field_104103_j, (double)this.field_104096_b, 0.0D, 0.0D, 1.0D);
        tessellator.func_78374_a((double)this.field_104106_i, (double)this.field_104096_b, 0.0D, 1.0D, 1.0D);
        tessellator.func_78384_a(0, 0);
        tessellator.func_78374_a((double)this.field_104106_i, (double)(this.field_104096_b - b0), 0.0D, 1.0D, 0.0D);
        tessellator.func_78374_a((double)this.field_104103_j, (double)(this.field_104096_b - b0), 0.0D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        j2 = this.func_104085_d();

        if (j2 > 0)
        {
            i2 = (this.field_104096_b - this.field_104098_a) * (this.field_104096_b - this.field_104098_a) / this.func_130003_b();

            if (i2 < 32)
            {
                i2 = 32;
            }

            if (i2 > this.field_104096_b - this.field_104098_a - 8)
            {
                i2 = this.field_104096_b - this.field_104098_a - 8;
            }

            i3 = (int)this.field_104100_o * (this.field_104096_b - this.field_104098_a - i2) / j2 + this.field_104098_a;

            if (i3 < this.field_104098_a)
            {
                i3 = this.field_104098_a;
            }

            tessellator.func_78382_b();
            tessellator.func_78384_a(0, 255);
            tessellator.func_78374_a((double)l, (double)this.field_104096_b, 0.0D, 0.0D, 1.0D);
            tessellator.func_78374_a((double)i1, (double)this.field_104096_b, 0.0D, 1.0D, 1.0D);
            tessellator.func_78374_a((double)i1, (double)this.field_104098_a, 0.0D, 1.0D, 0.0D);
            tessellator.func_78374_a((double)l, (double)this.field_104098_a, 0.0D, 0.0D, 0.0D);
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

        this.func_104087_b(p_73863_1_, p_73863_2_);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glDisable(GL11.GL_BLEND);
    }

    protected int func_104090_g()
    {
        return this.field_104093_g / 2 + 124;
    }

    private void func_104083_b(int p_104083_1_, int p_104083_2_, int p_104083_3_, int p_104083_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        this.field_104092_f.func_110434_K().func_110577_a(Gui.field_110325_k);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32.0F;
        tessellator.func_78382_b();
        tessellator.func_78384_a(4210752, p_104083_4_);
        tessellator.func_78374_a(0.0D, (double)p_104083_2_, 0.0D, 0.0D, (double)((float)p_104083_2_ / f));
        tessellator.func_78374_a((double)this.field_104093_g, (double)p_104083_2_, 0.0D, (double)((float)this.field_104093_g / f), (double)((float)p_104083_2_ / f));
        tessellator.func_78384_a(4210752, p_104083_3_);
        tessellator.func_78374_a((double)this.field_104093_g, (double)p_104083_1_, 0.0D, (double)((float)this.field_104093_g / f), (double)((float)p_104083_1_ / f));
        tessellator.func_78374_a(0.0D, (double)p_104083_1_, 0.0D, 0.0D, (double)((float)p_104083_1_ / f));
        tessellator.func_78381_a();
    }
}
