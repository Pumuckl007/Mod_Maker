package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.client.resources.Resource;
import net.minecraft.client.resources.data.AnimationFrame;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.util.Icon;

@SideOnly(Side.CLIENT)
public class TextureAtlasSprite implements Icon
{
    private final String field_110984_i;
    protected List field_110976_a = Lists.newArrayList();
    private AnimationMetadataSection field_110982_k;
    protected boolean field_130222_e;
    protected int field_110975_c;
    protected int field_110974_d;
    protected int field_130223_c;
    protected int field_130224_d;
    private float field_110979_l;
    private float field_110980_m;
    private float field_110977_n;
    private float field_110978_o;
    protected int field_110973_g;
    protected int field_110983_h;

    protected TextureAtlasSprite(String p_i1282_1_)
    {
        this.field_110984_i = p_i1282_1_;
    }

    public void func_110971_a(int p_110971_1_, int p_110971_2_, int p_110971_3_, int p_110971_4_, boolean p_110971_5_)
    {
        this.field_110975_c = p_110971_3_;
        this.field_110974_d = p_110971_4_;
        this.field_130222_e = p_110971_5_;
        float f = (float)(0.009999999776482582D / (double)p_110971_1_);
        float f1 = (float)(0.009999999776482582D / (double)p_110971_2_);
        this.field_110979_l = (float)p_110971_3_ / (float)((double)p_110971_1_) + f;
        this.field_110980_m = (float)(p_110971_3_ + this.field_130223_c) / (float)((double)p_110971_1_) - f;
        this.field_110977_n = (float)p_110971_4_ / (float)p_110971_2_ + f1;
        this.field_110978_o = (float)(p_110971_4_ + this.field_130224_d) / (float)p_110971_2_ - f1;
    }

    public void func_94217_a(TextureAtlasSprite p_94217_1_)
    {
        this.field_110975_c = p_94217_1_.field_110975_c;
        this.field_110974_d = p_94217_1_.field_110974_d;
        this.field_130223_c = p_94217_1_.field_130223_c;
        this.field_130224_d = p_94217_1_.field_130224_d;
        this.field_130222_e = p_94217_1_.field_130222_e;
        this.field_110979_l = p_94217_1_.field_110979_l;
        this.field_110980_m = p_94217_1_.field_110980_m;
        this.field_110977_n = p_94217_1_.field_110977_n;
        this.field_110978_o = p_94217_1_.field_110978_o;
    }

    public int func_130010_a()
    {
        return this.field_110975_c;
    }

    public int func_110967_i()
    {
        return this.field_110974_d;
    }

    public int func_94211_a()
    {
        return this.field_130223_c;
    }

    public int func_94216_b()
    {
        return this.field_130224_d;
    }

    public float func_94209_e()
    {
        return this.field_110979_l;
    }

    public float func_94212_f()
    {
        return this.field_110980_m;
    }

    public float func_94214_a(double p_94214_1_)
    {
        float f = this.field_110980_m - this.field_110979_l;
        return this.field_110979_l + f * (float)p_94214_1_ / 16.0F;
    }

    public float func_94206_g()
    {
        return this.field_110977_n;
    }

    public float func_94210_h()
    {
        return this.field_110978_o;
    }

    public float func_94207_b(double p_94207_1_)
    {
        float f = this.field_110978_o - this.field_110977_n;
        return this.field_110977_n + f * ((float)p_94207_1_ / 16.0F);
    }

    public String func_94215_i()
    {
        return this.field_110984_i;
    }

    public void func_94219_l()
    {
        ++this.field_110983_h;

        if (this.field_110983_h >= this.field_110982_k.func_110472_a(this.field_110973_g))
        {
            int i = this.field_110982_k.func_110468_c(this.field_110973_g);
            int j = this.field_110982_k.func_110473_c() == 0 ? this.field_110976_a.size() : this.field_110982_k.func_110473_c();
            this.field_110973_g = (this.field_110973_g + 1) % j;
            this.field_110983_h = 0;
            int k = this.field_110982_k.func_110468_c(this.field_110973_g);

            if (i != k && k >= 0 && k < this.field_110976_a.size())
            {
                TextureUtil.func_110998_a((int[])this.field_110976_a.get(k), this.field_130223_c, this.field_130224_d, this.field_110975_c, this.field_110974_d, false, false);
            }
        }
    }

    public int[] func_110965_a(int p_110965_1_)
    {
        return (int[])this.field_110976_a.get(p_110965_1_);
    }

    public int func_110970_k()
    {
        return this.field_110976_a.size();
    }

    public void func_110966_b(int p_110966_1_)
    {
        this.field_130223_c = p_110966_1_;
    }

    public void func_110969_c(int p_110969_1_)
    {
        this.field_130224_d = p_110969_1_;
    }

    public void func_130100_a(Resource p_130100_1_) throws IOException
    {
        this.func_130102_n();
        InputStream inputstream = p_130100_1_.func_110527_b();
        AnimationMetadataSection animationmetadatasection = (AnimationMetadataSection)p_130100_1_.func_110526_a("animation");
        BufferedImage bufferedimage = ImageIO.read(inputstream);
        this.field_130224_d = bufferedimage.getHeight();
        this.field_130223_c = bufferedimage.getWidth();
        int[] aint = new int[this.field_130224_d * this.field_130223_c];
        bufferedimage.getRGB(0, 0, this.field_130223_c, this.field_130224_d, aint, 0, this.field_130223_c);

        if (animationmetadatasection == null)
        {
            if (this.field_130224_d != this.field_130223_c)
            {
                throw new RuntimeException("broken aspect ratio and not an animation");
            }

            this.field_110976_a.add(aint);
        }
        else
        {
            int i = this.field_130224_d / this.field_130223_c;
            int j = this.field_130223_c;
            int k = this.field_130223_c;
            this.field_130224_d = this.field_130223_c;
            int l;

            if (animationmetadatasection.func_110473_c() > 0)
            {
                Iterator iterator = animationmetadatasection.func_130073_e().iterator();

                while (iterator.hasNext())
                {
                    l = ((Integer)iterator.next()).intValue();

                    if (l >= i)
                    {
                        throw new RuntimeException("invalid frameindex " + l);
                    }

                    this.func_130099_d(l);
                    this.field_110976_a.set(l, func_130101_a(aint, j, k, l));
                }

                this.field_110982_k = animationmetadatasection;
            }
            else
            {
                ArrayList arraylist = Lists.newArrayList();

                for (l = 0; l < i; ++l)
                {
                    this.field_110976_a.add(func_130101_a(aint, j, k, l));
                    arraylist.add(new AnimationFrame(l, -1));
                }

                this.field_110982_k = new AnimationMetadataSection(arraylist, this.field_130223_c, this.field_130224_d, animationmetadatasection.func_110469_d());
            }
        }
    }

    private void func_130099_d(int p_130099_1_)
    {
        if (this.field_110976_a.size() <= p_130099_1_)
        {
            for (int j = this.field_110976_a.size(); j <= p_130099_1_; ++j)
            {
                this.field_110976_a.add((Object)null);
            }
        }
    }

    private static int[] func_130101_a(int[] p_130101_0_, int p_130101_1_, int p_130101_2_, int p_130101_3_)
    {
        int[] aint1 = new int[p_130101_1_ * p_130101_2_];
        System.arraycopy(p_130101_0_, p_130101_3_ * aint1.length, aint1, 0, aint1.length);
        return aint1;
    }

    public void func_130103_l()
    {
        this.field_110976_a.clear();
    }

    public boolean func_130098_m()
    {
        return this.field_110982_k != null;
    }

    public void func_110968_a(List p_110968_1_)
    {
        this.field_110976_a = p_110968_1_;
    }

    private void func_130102_n()
    {
        this.field_110982_k = null;
        this.func_110968_a(Lists.newArrayList());
        this.field_110973_g = 0;
        this.field_110983_h = 0;
    }

    public String toString()
    {
        return "TextureAtlasSprite{name=\'" + this.field_110984_i + '\'' + ", frameCount=" + this.field_110976_a.size() + ", rotated=" + this.field_130222_e + ", x=" + this.field_110975_c + ", y=" + this.field_110974_d + ", height=" + this.field_130224_d + ", width=" + this.field_130223_c + ", u0=" + this.field_110979_l + ", u1=" + this.field_110980_m + ", v0=" + this.field_110977_n + ", v1=" + this.field_110978_o + '}';
    }
}
