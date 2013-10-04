package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class MapGenCavesHell extends MapGenBase
{
    protected void func_75044_a(long p_75044_1_, int p_75044_3_, int p_75044_4_, byte[] p_75044_5_, double p_75044_6_, double p_75044_8_, double p_75044_10_)
    {
        this.func_75043_a(p_75044_1_, p_75044_3_, p_75044_4_, p_75044_5_, p_75044_6_, p_75044_8_, p_75044_10_, 1.0F + this.field_75038_b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
    }

    protected void func_75043_a(long p_75043_1_, int p_75043_3_, int p_75043_4_, byte[] p_75043_5_, double p_75043_6_, double p_75043_8_, double p_75043_10_, float p_75043_12_, float p_75043_13_, float p_75043_14_, int p_75043_15_, int p_75043_16_, double p_75043_17_)
    {
        double d4 = (double)(p_75043_3_ * 16 + 8);
        double d5 = (double)(p_75043_4_ * 16 + 8);
        float f3 = 0.0F;
        float f4 = 0.0F;
        Random random = new Random(p_75043_1_);

        if (p_75043_16_ <= 0)
        {
            int j1 = this.field_75040_a * 16 - 16;
            p_75043_16_ = j1 - random.nextInt(j1 / 4);
        }

        boolean flag = false;

        if (p_75043_15_ == -1)
        {
            p_75043_15_ = p_75043_16_ / 2;
            flag = true;
        }

        int k1 = random.nextInt(p_75043_16_ / 2) + p_75043_16_ / 4;

        for (boolean flag1 = random.nextInt(6) == 0; p_75043_15_ < p_75043_16_; ++p_75043_15_)
        {
            double d6 = 1.5D + (double)(MathHelper.func_76126_a((float)p_75043_15_ * (float)Math.PI / (float)p_75043_16_) * p_75043_12_ * 1.0F);
            double d7 = d6 * p_75043_17_;
            float f5 = MathHelper.func_76134_b(p_75043_14_);
            float f6 = MathHelper.func_76126_a(p_75043_14_);
            p_75043_6_ += (double)(MathHelper.func_76134_b(p_75043_13_) * f5);
            p_75043_8_ += (double)f6;
            p_75043_10_ += (double)(MathHelper.func_76126_a(p_75043_13_) * f5);

            if (flag1)
            {
                p_75043_14_ *= 0.92F;
            }
            else
            {
                p_75043_14_ *= 0.7F;
            }

            p_75043_14_ += f4 * 0.1F;
            p_75043_13_ += f3 * 0.1F;
            f4 *= 0.9F;
            f3 *= 0.75F;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;

            if (!flag && p_75043_15_ == k1 && p_75043_12_ > 1.0F)
            {
                this.func_75043_a(random.nextLong(), p_75043_3_, p_75043_4_, p_75043_5_, p_75043_6_, p_75043_8_, p_75043_10_, random.nextFloat() * 0.5F + 0.5F, p_75043_13_ - ((float)Math.PI / 2F), p_75043_14_ / 3.0F, p_75043_15_, p_75043_16_, 1.0D);
                this.func_75043_a(random.nextLong(), p_75043_3_, p_75043_4_, p_75043_5_, p_75043_6_, p_75043_8_, p_75043_10_, random.nextFloat() * 0.5F + 0.5F, p_75043_13_ + ((float)Math.PI / 2F), p_75043_14_ / 3.0F, p_75043_15_, p_75043_16_, 1.0D);
                return;
            }

            if (flag || random.nextInt(4) != 0)
            {
                double d8 = p_75043_6_ - d4;
                double d9 = p_75043_10_ - d5;
                double d10 = (double)(p_75043_16_ - p_75043_15_);
                double d11 = (double)(p_75043_12_ + 2.0F + 16.0F);

                if (d8 * d8 + d9 * d9 - d10 * d10 > d11 * d11)
                {
                    return;
                }

                if (p_75043_6_ >= d4 - 16.0D - d6 * 2.0D && p_75043_10_ >= d5 - 16.0D - d6 * 2.0D && p_75043_6_ <= d4 + 16.0D + d6 * 2.0D && p_75043_10_ <= d5 + 16.0D + d6 * 2.0D)
                {
                    int l1 = MathHelper.func_76128_c(p_75043_6_ - d6) - p_75043_3_ * 16 - 1;
                    int i2 = MathHelper.func_76128_c(p_75043_6_ + d6) - p_75043_3_ * 16 + 1;
                    int j2 = MathHelper.func_76128_c(p_75043_8_ - d7) - 1;
                    int k2 = MathHelper.func_76128_c(p_75043_8_ + d7) + 1;
                    int l2 = MathHelper.func_76128_c(p_75043_10_ - d6) - p_75043_4_ * 16 - 1;
                    int i3 = MathHelper.func_76128_c(p_75043_10_ + d6) - p_75043_4_ * 16 + 1;

                    if (l1 < 0)
                    {
                        l1 = 0;
                    }

                    if (i2 > 16)
                    {
                        i2 = 16;
                    }

                    if (j2 < 1)
                    {
                        j2 = 1;
                    }

                    if (k2 > 120)
                    {
                        k2 = 120;
                    }

                    if (l2 < 0)
                    {
                        l2 = 0;
                    }

                    if (i3 > 16)
                    {
                        i3 = 16;
                    }

                    boolean flag2 = false;
                    int j3;
                    int k3;

                    for (j3 = l1; !flag2 && j3 < i2; ++j3)
                    {
                        for (int l3 = l2; !flag2 && l3 < i3; ++l3)
                        {
                            for (int i4 = k2 + 1; !flag2 && i4 >= j2 - 1; --i4)
                            {
                                k3 = (j3 * 16 + l3) * 128 + i4;

                                if (i4 >= 0 && i4 < 128)
                                {
                                    if (p_75043_5_[k3] == Block.field_71944_C.field_71990_ca || p_75043_5_[k3] == Block.field_71938_D.field_71990_ca)
                                    {
                                        flag2 = true;
                                    }

                                    if (i4 != j2 - 1 && j3 != l1 && j3 != i2 - 1 && l3 != l2 && l3 != i3 - 1)
                                    {
                                        i4 = j2;
                                    }
                                }
                            }
                        }
                    }

                    if (!flag2)
                    {
                        for (j3 = l1; j3 < i2; ++j3)
                        {
                            double d12 = ((double)(j3 + p_75043_3_ * 16) + 0.5D - p_75043_6_) / d6;

                            for (k3 = l2; k3 < i3; ++k3)
                            {
                                double d13 = ((double)(k3 + p_75043_4_ * 16) + 0.5D - p_75043_10_) / d6;
                                int j4 = (j3 * 16 + k3) * 128 + k2;

                                for (int k4 = k2 - 1; k4 >= j2; --k4)
                                {
                                    double d14 = ((double)k4 + 0.5D - p_75043_8_) / d7;

                                    if (d14 > -0.7D && d12 * d12 + d14 * d14 + d13 * d13 < 1.0D)
                                    {
                                        byte b0 = p_75043_5_[j4];

                                        if (b0 == Block.field_72012_bb.field_71990_ca || b0 == Block.field_71979_v.field_71990_ca || b0 == Block.field_71980_u.field_71990_ca)
                                        {
                                            p_75043_5_[j4] = 0;
                                        }
                                    }

                                    --j4;
                                }
                            }
                        }

                        if (flag)
                        {
                            break;
                        }
                    }
                }
            }
        }
    }

    protected void func_75037_a(World p_75037_1_, int p_75037_2_, int p_75037_3_, int p_75037_4_, int p_75037_5_, byte[] p_75037_6_)
    {
        int i1 = this.field_75038_b.nextInt(this.field_75038_b.nextInt(this.field_75038_b.nextInt(10) + 1) + 1);

        if (this.field_75038_b.nextInt(5) != 0)
        {
            i1 = 0;
        }

        for (int j1 = 0; j1 < i1; ++j1)
        {
            double d0 = (double)(p_75037_2_ * 16 + this.field_75038_b.nextInt(16));
            double d1 = (double)this.field_75038_b.nextInt(128);
            double d2 = (double)(p_75037_3_ * 16 + this.field_75038_b.nextInt(16));
            int k1 = 1;

            if (this.field_75038_b.nextInt(4) == 0)
            {
                this.func_75044_a(this.field_75038_b.nextLong(), p_75037_4_, p_75037_5_, p_75037_6_, d0, d1, d2);
                k1 += this.field_75038_b.nextInt(4);
            }

            for (int l1 = 0; l1 < k1; ++l1)
            {
                float f = this.field_75038_b.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = (this.field_75038_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float f2 = this.field_75038_b.nextFloat() * 2.0F + this.field_75038_b.nextFloat();
                this.func_75043_a(this.field_75038_b.nextLong(), p_75037_4_, p_75037_5_, p_75037_6_, d0, d1, d2, f2 * 2.0F, f, f1, 0, 0, 0.5D);
            }
        }
    }
}
