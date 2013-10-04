package net.minecraft.world.gen;

import java.util.Random;

public class NoiseGeneratorPerlin extends NoiseGenerator
{
    private int[] field_76312_d;
    public double field_76315_a;
    public double field_76313_b;
    public double field_76314_c;

    public NoiseGeneratorPerlin()
    {
        this(new Random());
    }

    public NoiseGeneratorPerlin(Random p_i2110_1_)
    {
        this.field_76312_d = new int[512];
        this.field_76315_a = p_i2110_1_.nextDouble() * 256.0D;
        this.field_76313_b = p_i2110_1_.nextDouble() * 256.0D;
        this.field_76314_c = p_i2110_1_.nextDouble() * 256.0D;
        int i;

        for (i = 0; i < 256; this.field_76312_d[i] = i++)
        {
            ;
        }

        for (i = 0; i < 256; ++i)
        {
            int j = p_i2110_1_.nextInt(256 - i) + i;
            int k = this.field_76312_d[i];
            this.field_76312_d[i] = this.field_76312_d[j];
            this.field_76312_d[j] = k;
            this.field_76312_d[i + 256] = this.field_76312_d[i];
        }
    }

    public final double func_76311_b(double p_76311_1_, double p_76311_3_, double p_76311_5_)
    {
        return p_76311_3_ + p_76311_1_ * (p_76311_5_ - p_76311_3_);
    }

    public final double func_76309_a(int p_76309_1_, double p_76309_2_, double p_76309_4_)
    {
        int j = p_76309_1_ & 15;
        double d2 = (double)(1 - ((j & 8) >> 3)) * p_76309_2_;
        double d3 = j < 4 ? 0.0D : (j != 12 && j != 14 ? p_76309_4_ : p_76309_2_);
        return ((j & 1) == 0 ? d2 : -d2) + ((j & 2) == 0 ? d3 : -d3);
    }

    public final double func_76310_a(int p_76310_1_, double p_76310_2_, double p_76310_4_, double p_76310_6_)
    {
        int j = p_76310_1_ & 15;
        double d3 = j < 8 ? p_76310_2_ : p_76310_4_;
        double d4 = j < 4 ? p_76310_4_ : (j != 12 && j != 14 ? p_76310_6_ : p_76310_2_);
        return ((j & 1) == 0 ? d3 : -d3) + ((j & 2) == 0 ? d4 : -d4);
    }

    public void func_76308_a(double[] p_76308_1_, double p_76308_2_, double p_76308_4_, double p_76308_6_, int p_76308_8_, int p_76308_9_, int p_76308_10_, double p_76308_11_, double p_76308_13_, double p_76308_15_, double p_76308_17_)
    {
        int l;
        int i1;
        double d7;
        double d8;
        double d9;
        int j1;
        double d10;
        int k1;
        int l1;
        int i2;
        int j2;

        if (p_76308_9_ == 1)
        {
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            double d11 = 0.0D;
            double d12 = 0.0D;
            j2 = 0;
            double d13 = 1.0D / p_76308_17_;

            for (int k2 = 0; k2 < p_76308_8_; ++k2)
            {
                d7 = p_76308_2_ + (double)k2 * p_76308_11_ + this.field_76315_a;
                int l2 = (int)d7;

                if (d7 < (double)l2)
                {
                    --l2;
                }

                int i3 = l2 & 255;
                d7 -= (double)l2;
                d8 = d7 * d7 * d7 * (d7 * (d7 * 6.0D - 15.0D) + 10.0D);

                for (j1 = 0; j1 < p_76308_10_; ++j1)
                {
                    d9 = p_76308_6_ + (double)j1 * p_76308_15_ + this.field_76314_c;
                    k1 = (int)d9;

                    if (d9 < (double)k1)
                    {
                        --k1;
                    }

                    l1 = k1 & 255;
                    d9 -= (double)k1;
                    d10 = d9 * d9 * d9 * (d9 * (d9 * 6.0D - 15.0D) + 10.0D);
                    l = this.field_76312_d[i3] + 0;
                    int j3 = this.field_76312_d[l] + l1;
                    int k3 = this.field_76312_d[i3 + 1] + 0;
                    i1 = this.field_76312_d[k3] + l1;
                    d11 = this.func_76311_b(d8, this.func_76309_a(this.field_76312_d[j3], d7, d9), this.func_76310_a(this.field_76312_d[i1], d7 - 1.0D, 0.0D, d9));
                    d12 = this.func_76311_b(d8, this.func_76310_a(this.field_76312_d[j3 + 1], d7, 0.0D, d9 - 1.0D), this.func_76310_a(this.field_76312_d[i1 + 1], d7 - 1.0D, 0.0D, d9 - 1.0D));
                    double d14 = this.func_76311_b(d10, d11, d12);
                    i2 = j2++;
                    p_76308_1_[i2] += d14 * d13;
                }
            }
        }
        else
        {
            l = 0;
            double d15 = 1.0D / p_76308_17_;
            i1 = -1;
            boolean flag4 = false;
            boolean flag5 = false;
            boolean flag6 = false;
            boolean flag7 = false;
            boolean flag8 = false;
            boolean flag9 = false;
            double d16 = 0.0D;
            d7 = 0.0D;
            double d17 = 0.0D;
            d8 = 0.0D;

            for (j1 = 0; j1 < p_76308_8_; ++j1)
            {
                d9 = p_76308_2_ + (double)j1 * p_76308_11_ + this.field_76315_a;
                k1 = (int)d9;

                if (d9 < (double)k1)
                {
                    --k1;
                }

                l1 = k1 & 255;
                d9 -= (double)k1;
                d10 = d9 * d9 * d9 * (d9 * (d9 * 6.0D - 15.0D) + 10.0D);

                for (int l3 = 0; l3 < p_76308_10_; ++l3)
                {
                    double d18 = p_76308_6_ + (double)l3 * p_76308_15_ + this.field_76314_c;
                    int i4 = (int)d18;

                    if (d18 < (double)i4)
                    {
                        --i4;
                    }

                    int j4 = i4 & 255;
                    d18 -= (double)i4;
                    double d19 = d18 * d18 * d18 * (d18 * (d18 * 6.0D - 15.0D) + 10.0D);

                    for (int k4 = 0; k4 < p_76308_9_; ++k4)
                    {
                        double d20 = p_76308_4_ + (double)k4 * p_76308_13_ + this.field_76313_b;
                        int l4 = (int)d20;

                        if (d20 < (double)l4)
                        {
                            --l4;
                        }

                        int i5 = l4 & 255;
                        d20 -= (double)l4;
                        double d21 = d20 * d20 * d20 * (d20 * (d20 * 6.0D - 15.0D) + 10.0D);

                        if (k4 == 0 || i5 != i1)
                        {
                            i1 = i5;
                            int j5 = this.field_76312_d[l1] + i5;
                            int k5 = this.field_76312_d[j5] + j4;
                            int l5 = this.field_76312_d[j5 + 1] + j4;
                            int i6 = this.field_76312_d[l1 + 1] + i5;
                            j2 = this.field_76312_d[i6] + j4;
                            int j6 = this.field_76312_d[i6 + 1] + j4;
                            d16 = this.func_76311_b(d10, this.func_76310_a(this.field_76312_d[k5], d9, d20, d18), this.func_76310_a(this.field_76312_d[j2], d9 - 1.0D, d20, d18));
                            d7 = this.func_76311_b(d10, this.func_76310_a(this.field_76312_d[l5], d9, d20 - 1.0D, d18), this.func_76310_a(this.field_76312_d[j6], d9 - 1.0D, d20 - 1.0D, d18));
                            d17 = this.func_76311_b(d10, this.func_76310_a(this.field_76312_d[k5 + 1], d9, d20, d18 - 1.0D), this.func_76310_a(this.field_76312_d[j2 + 1], d9 - 1.0D, d20, d18 - 1.0D));
                            d8 = this.func_76311_b(d10, this.func_76310_a(this.field_76312_d[l5 + 1], d9, d20 - 1.0D, d18 - 1.0D), this.func_76310_a(this.field_76312_d[j6 + 1], d9 - 1.0D, d20 - 1.0D, d18 - 1.0D));
                        }

                        double d22 = this.func_76311_b(d21, d16, d7);
                        double d23 = this.func_76311_b(d21, d17, d8);
                        double d24 = this.func_76311_b(d19, d22, d23);
                        i2 = l++;
                        p_76308_1_[i2] += d24 * d15;
                    }
                }
            }
        }
    }
}
