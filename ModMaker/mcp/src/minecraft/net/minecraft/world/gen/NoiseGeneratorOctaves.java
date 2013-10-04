package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.util.MathHelper;

public class NoiseGeneratorOctaves extends NoiseGenerator
{
    private NoiseGeneratorPerlin[] field_76307_a;
    private int field_76306_b;

    public NoiseGeneratorOctaves(Random p_i2111_1_, int p_i2111_2_)
    {
        this.field_76306_b = p_i2111_2_;
        this.field_76307_a = new NoiseGeneratorPerlin[p_i2111_2_];

        for (int j = 0; j < p_i2111_2_; ++j)
        {
            this.field_76307_a[j] = new NoiseGeneratorPerlin(p_i2111_1_);
        }
    }

    public double[] func_76304_a(double[] p_76304_1_, int p_76304_2_, int p_76304_3_, int p_76304_4_, int p_76304_5_, int p_76304_6_, int p_76304_7_, double p_76304_8_, double p_76304_10_, double p_76304_12_)
    {
        if (p_76304_1_ == null)
        {
            p_76304_1_ = new double[p_76304_5_ * p_76304_6_ * p_76304_7_];
        }
        else
        {
            for (int k1 = 0; k1 < p_76304_1_.length; ++k1)
            {
                p_76304_1_[k1] = 0.0D;
            }
        }

        double d3 = 1.0D;

        for (int l1 = 0; l1 < this.field_76306_b; ++l1)
        {
            double d4 = (double)p_76304_2_ * d3 * p_76304_8_;
            double d5 = (double)p_76304_3_ * d3 * p_76304_10_;
            double d6 = (double)p_76304_4_ * d3 * p_76304_12_;
            long i2 = MathHelper.func_76124_d(d4);
            long j2 = MathHelper.func_76124_d(d6);
            d4 -= (double)i2;
            d6 -= (double)j2;
            i2 %= 16777216L;
            j2 %= 16777216L;
            d4 += (double)i2;
            d6 += (double)j2;
            this.field_76307_a[l1].func_76308_a(p_76304_1_, d4, d5, d6, p_76304_5_, p_76304_6_, p_76304_7_, p_76304_8_ * d3, p_76304_10_ * d3, p_76304_12_ * d3, d3);
            d3 /= 2.0D;
        }

        return p_76304_1_;
    }

    public double[] func_76305_a(double[] p_76305_1_, int p_76305_2_, int p_76305_3_, int p_76305_4_, int p_76305_5_, double p_76305_6_, double p_76305_8_, double p_76305_10_)
    {
        return this.func_76304_a(p_76305_1_, p_76305_2_, 10, p_76305_3_, p_76305_4_, 1, p_76305_5_, p_76305_6_, 1.0D, p_76305_8_);
    }
}
