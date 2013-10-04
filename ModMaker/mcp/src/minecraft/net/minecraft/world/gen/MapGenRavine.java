package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class MapGenRavine extends MapGenBase
{
    private float[] field_75046_d = new float[1024];

    protected void func_75045_a(long p_75045_1_, int p_75045_3_, int p_75045_4_, byte[] p_75045_5_, double p_75045_6_, double p_75045_8_, double p_75045_10_, float p_75045_12_, float p_75045_13_, float p_75045_14_, int p_75045_15_, int p_75045_16_, double p_75045_17_)
    {
        Random random = new Random(p_75045_1_);
        double d4 = (double)(p_75045_3_ * 16 + 8);
        double d5 = (double)(p_75045_4_ * 16 + 8);
        float f3 = 0.0F;
        float f4 = 0.0F;

        if (p_75045_16_ <= 0)
        {
            int j1 = this.field_75040_a * 16 - 16;
            p_75045_16_ = j1 - random.nextInt(j1 / 4);
        }

        boolean flag = false;

        if (p_75045_15_ == -1)
        {
            p_75045_15_ = p_75045_16_ / 2;
            flag = true;
        }

        float f5 = 1.0F;

        for (int k1 = 0; k1 < 128; ++k1)
        {
            if (k1 == 0 || random.nextInt(3) == 0)
            {
                f5 = 1.0F + random.nextFloat() * random.nextFloat() * 1.0F;
            }

            this.field_75046_d[k1] = f5 * f5;
        }

        for (; p_75045_15_ < p_75045_16_; ++p_75045_15_)
        {
            double d6 = 1.5D + (double)(MathHelper.func_76126_a((float)p_75045_15_ * (float)Math.PI / (float)p_75045_16_) * p_75045_12_ * 1.0F);
            double d7 = d6 * p_75045_17_;
            d6 *= (double)random.nextFloat() * 0.25D + 0.75D;
            d7 *= (double)random.nextFloat() * 0.25D + 0.75D;
            float f6 = MathHelper.func_76134_b(p_75045_14_);
            float f7 = MathHelper.func_76126_a(p_75045_14_);
            p_75045_6_ += (double)(MathHelper.func_76134_b(p_75045_13_) * f6);
            p_75045_8_ += (double)f7;
            p_75045_10_ += (double)(MathHelper.func_76126_a(p_75045_13_) * f6);
            p_75045_14_ *= 0.7F;
            p_75045_14_ += f4 * 0.05F;
            p_75045_13_ += f3 * 0.05F;
            f4 *= 0.8F;
            f3 *= 0.5F;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;

            if (flag || random.nextInt(4) != 0)
            {
                double d8 = p_75045_6_ - d4;
                double d9 = p_75045_10_ - d5;
                double d10 = (double)(p_75045_16_ - p_75045_15_);
                double d11 = (double)(p_75045_12_ + 2.0F + 16.0F);

                if (d8 * d8 + d9 * d9 - d10 * d10 > d11 * d11)
                {
                    return;
                }

                if (p_75045_6_ >= d4 - 16.0D - d6 * 2.0D && p_75045_10_ >= d5 - 16.0D - d6 * 2.0D && p_75045_6_ <= d4 + 16.0D + d6 * 2.0D && p_75045_10_ <= d5 + 16.0D + d6 * 2.0D)
                {
                    int l1 = MathHelper.func_76128_c(p_75045_6_ - d6) - p_75045_3_ * 16 - 1;
                    int i2 = MathHelper.func_76128_c(p_75045_6_ + d6) - p_75045_3_ * 16 + 1;
                    int j2 = MathHelper.func_76128_c(p_75045_8_ - d7) - 1;
                    int k2 = MathHelper.func_76128_c(p_75045_8_ + d7) + 1;
                    int l2 = MathHelper.func_76128_c(p_75045_10_ - d6) - p_75045_4_ * 16 - 1;
                    int i3 = MathHelper.func_76128_c(p_75045_10_ + d6) - p_75045_4_ * 16 + 1;

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

                    boolean flag1 = false;
                    int j3;
                    int k3;

                    for (j3 = l1; !flag1 && j3 < i2; ++j3)
                    {
                        for (int l3 = l2; !flag1 && l3 < i3; ++l3)
                        {
                            for (int i4 = k2 + 1; !flag1 && i4 >= j2 - 1; --i4)
                            {
                                k3 = (j3 * 16 + l3) * 128 + i4;

                                if (i4 >= 0 && i4 < 128)
                                {
                                    if (p_75045_5_[k3] == Block.field_71942_A.field_71990_ca || p_75045_5_[k3] == Block.field_71943_B.field_71990_ca)
                                    {
                                        flag1 = true;
                                    }

                                    if (i4 != j2 - 1 && j3 != l1 && j3 != i2 - 1 && l3 != l2 && l3 != i3 - 1)
                                    {
                                        i4 = j2;
                                    }
                                }
                            }
                        }
                    }

                    if (!flag1)
                    {
                        for (j3 = l1; j3 < i2; ++j3)
                        {
                            double d12 = ((double)(j3 + p_75045_3_ * 16) + 0.5D - p_75045_6_) / d6;

                            for (k3 = l2; k3 < i3; ++k3)
                            {
                                double d13 = ((double)(k3 + p_75045_4_ * 16) + 0.5D - p_75045_10_) / d6;
                                int j4 = (j3 * 16 + k3) * 128 + k2;
                                boolean flag2 = false;

                                if (d12 * d12 + d13 * d13 < 1.0D)
                                {
                                    for (int k4 = k2 - 1; k4 >= j2; --k4)
                                    {
                                        double d14 = ((double)k4 + 0.5D - p_75045_8_) / d7;

                                        if ((d12 * d12 + d13 * d13) * (double)this.field_75046_d[k4] + d14 * d14 / 6.0D < 1.0D)
                                        {
                                            byte b0 = p_75045_5_[j4];

                                            if (b0 == Block.field_71980_u.field_71990_ca)
                                            {
                                                flag2 = true;
                                            }

                                            if (b0 == Block.field_71981_t.field_71990_ca || b0 == Block.field_71979_v.field_71990_ca || b0 == Block.field_71980_u.field_71990_ca)
                                            {
                                                if (k4 < 10)
                                                {
                                                    p_75045_5_[j4] = (byte)Block.field_71944_C.field_71990_ca;
                                                }
                                                else
                                                {
                                                    p_75045_5_[j4] = 0;

                                                    if (flag2 && p_75045_5_[j4 - 1] == Block.field_71979_v.field_71990_ca)
                                                    {
                                                        p_75045_5_[j4 - 1] = this.field_75039_c.func_72807_a(j3 + p_75045_3_ * 16, k3 + p_75045_4_ * 16).field_76752_A;
                                                    }
                                                }
                                            }
                                        }

                                        --j4;
                                    }
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
        if (this.field_75038_b.nextInt(50) == 0)
        {
            double d0 = (double)(p_75037_2_ * 16 + this.field_75038_b.nextInt(16));
            double d1 = (double)(this.field_75038_b.nextInt(this.field_75038_b.nextInt(40) + 8) + 20);
            double d2 = (double)(p_75037_3_ * 16 + this.field_75038_b.nextInt(16));
            byte b0 = 1;

            for (int i1 = 0; i1 < b0; ++i1)
            {
                float f = this.field_75038_b.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = (this.field_75038_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float f2 = (this.field_75038_b.nextFloat() * 2.0F + this.field_75038_b.nextFloat()) * 2.0F;
                this.func_75045_a(this.field_75038_b.nextLong(), p_75037_4_, p_75037_5_, p_75037_6_, d0, d1, d2, f2, f, f1, 0, 0, 3.0D);
            }
        }
    }
}
