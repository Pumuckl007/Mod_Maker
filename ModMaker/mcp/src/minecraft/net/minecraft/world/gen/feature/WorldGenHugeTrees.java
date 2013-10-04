package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class WorldGenHugeTrees extends WorldGenerator
{
    private final int field_76522_a;
    private final int field_76520_b;
    private final int field_76521_c;

    public WorldGenHugeTrees(boolean p_i2019_1_, int p_i2019_2_, int p_i2019_3_, int p_i2019_4_)
    {
        super(p_i2019_1_);
        this.field_76522_a = p_i2019_2_;
        this.field_76520_b = p_i2019_3_;
        this.field_76521_c = p_i2019_4_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int l = p_76484_2_.nextInt(3) + this.field_76522_a;
        boolean flag = true;

        if (p_76484_4_ >= 1 && p_76484_4_ + l + 1 <= 256)
        {
            int i1;
            int j1;
            int k1;
            int l1;

            for (i1 = p_76484_4_; i1 <= p_76484_4_ + 1 + l; ++i1)
            {
                byte b0 = 2;

                if (i1 == p_76484_4_)
                {
                    b0 = 1;
                }

                if (i1 >= p_76484_4_ + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (j1 = p_76484_3_ - b0; j1 <= p_76484_3_ + b0 && flag; ++j1)
                {
                    for (k1 = p_76484_5_ - b0; k1 <= p_76484_5_ + b0 && flag; ++k1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            l1 = p_76484_1_.func_72798_a(j1, i1, k1);

                            if (l1 != 0 && l1 != Block.field_71952_K.field_71990_ca && l1 != Block.field_71980_u.field_71990_ca && l1 != Block.field_71979_v.field_71990_ca && l1 != Block.field_71951_J.field_71990_ca && l1 != Block.field_71987_y.field_71990_ca)
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                i1 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);

                if ((i1 == Block.field_71980_u.field_71990_ca || i1 == Block.field_71979_v.field_71990_ca) && p_76484_4_ < 256 - l - 1)
                {
                    p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca, 0, 2);
                    p_76484_1_.func_72832_d(p_76484_3_ + 1, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca, 0, 2);
                    p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_ - 1, p_76484_5_ + 1, Block.field_71979_v.field_71990_ca, 0, 2);
                    p_76484_1_.func_72832_d(p_76484_3_ + 1, p_76484_4_ - 1, p_76484_5_ + 1, Block.field_71979_v.field_71990_ca, 0, 2);
                    this.func_76519_a(p_76484_1_, p_76484_3_, p_76484_5_, p_76484_4_ + l, 2, p_76484_2_);

                    for (int i2 = p_76484_4_ + l - 2 - p_76484_2_.nextInt(4); i2 > p_76484_4_ + l / 2; i2 -= 2 + p_76484_2_.nextInt(4))
                    {
                        float f = p_76484_2_.nextFloat() * (float)Math.PI * 2.0F;
                        k1 = p_76484_3_ + (int)(0.5F + MathHelper.func_76134_b(f) * 4.0F);
                        l1 = p_76484_5_ + (int)(0.5F + MathHelper.func_76126_a(f) * 4.0F);
                        this.func_76519_a(p_76484_1_, k1, l1, i2, 0, p_76484_2_);

                        for (int j2 = 0; j2 < 5; ++j2)
                        {
                            k1 = p_76484_3_ + (int)(1.5F + MathHelper.func_76134_b(f) * (float)j2);
                            l1 = p_76484_5_ + (int)(1.5F + MathHelper.func_76126_a(f) * (float)j2);
                            this.func_76485_a(p_76484_1_, k1, i2 - 3 + j2 / 2, l1, Block.field_71951_J.field_71990_ca, this.field_76520_b);
                        }
                    }

                    for (j1 = 0; j1 < l; ++j1)
                    {
                        k1 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + j1, p_76484_5_);

                        if (k1 == 0 || k1 == Block.field_71952_K.field_71990_ca)
                        {
                            this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + j1, p_76484_5_, Block.field_71951_J.field_71990_ca, this.field_76520_b);

                            if (j1 > 0)
                            {
                                if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ - 1, p_76484_4_ + j1, p_76484_5_))
                                {
                                    this.func_76485_a(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + j1, p_76484_5_, Block.field_71998_bu.field_71990_ca, 8);
                                }

                                if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_ + j1, p_76484_5_ - 1))
                                {
                                    this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + j1, p_76484_5_ - 1, Block.field_71998_bu.field_71990_ca, 1);
                                }
                            }
                        }

                        if (j1 < l - 1)
                        {
                            k1 = p_76484_1_.func_72798_a(p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_);

                            if (k1 == 0 || k1 == Block.field_71952_K.field_71990_ca)
                            {
                                this.func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_, Block.field_71951_J.field_71990_ca, this.field_76520_b);

                                if (j1 > 0)
                                {
                                    if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 2, p_76484_4_ + j1, p_76484_5_))
                                    {
                                        this.func_76485_a(p_76484_1_, p_76484_3_ + 2, p_76484_4_ + j1, p_76484_5_, Block.field_71998_bu.field_71990_ca, 2);
                                    }

                                    if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ - 1))
                                    {
                                        this.func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ - 1, Block.field_71998_bu.field_71990_ca, 1);
                                    }
                                }
                            }

                            k1 = p_76484_1_.func_72798_a(p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ + 1);

                            if (k1 == 0 || k1 == Block.field_71952_K.field_71990_ca)
                            {
                                this.func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ + 1, Block.field_71951_J.field_71990_ca, this.field_76520_b);

                                if (j1 > 0)
                                {
                                    if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 2, p_76484_4_ + j1, p_76484_5_ + 1))
                                    {
                                        this.func_76485_a(p_76484_1_, p_76484_3_ + 2, p_76484_4_ + j1, p_76484_5_ + 1, Block.field_71998_bu.field_71990_ca, 2);
                                    }

                                    if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ + 2))
                                    {
                                        this.func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ + 2, Block.field_71998_bu.field_71990_ca, 4);
                                    }
                                }
                            }

                            k1 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + j1, p_76484_5_ + 1);

                            if (k1 == 0 || k1 == Block.field_71952_K.field_71990_ca)
                            {
                                this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + j1, p_76484_5_ + 1, Block.field_71951_J.field_71990_ca, this.field_76520_b);

                                if (j1 > 0)
                                {
                                    if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ - 1, p_76484_4_ + j1, p_76484_5_ + 1))
                                    {
                                        this.func_76485_a(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + j1, p_76484_5_ + 1, Block.field_71998_bu.field_71990_ca, 8);
                                    }

                                    if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_ + j1, p_76484_5_ + 2))
                                    {
                                        this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + j1, p_76484_5_ + 2, Block.field_71998_bu.field_71990_ca, 4);
                                    }
                                }
                            }
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private void func_76519_a(World p_76519_1_, int p_76519_2_, int p_76519_3_, int p_76519_4_, int p_76519_5_, Random p_76519_6_)
    {
        byte b0 = 2;

        for (int i1 = p_76519_4_ - b0; i1 <= p_76519_4_; ++i1)
        {
            int j1 = i1 - p_76519_4_;
            int k1 = p_76519_5_ + 1 - j1;

            for (int l1 = p_76519_2_ - k1; l1 <= p_76519_2_ + k1 + 1; ++l1)
            {
                int i2 = l1 - p_76519_2_;

                for (int j2 = p_76519_3_ - k1; j2 <= p_76519_3_ + k1 + 1; ++j2)
                {
                    int k2 = j2 - p_76519_3_;

                    if ((i2 >= 0 || k2 >= 0 || i2 * i2 + k2 * k2 <= k1 * k1) && (i2 <= 0 && k2 <= 0 || i2 * i2 + k2 * k2 <= (k1 + 1) * (k1 + 1)) && (p_76519_6_.nextInt(4) != 0 || i2 * i2 + k2 * k2 <= (k1 - 1) * (k1 - 1)))
                    {
                        int l2 = p_76519_1_.func_72798_a(l1, i1, j2);

                        if (l2 == 0 || l2 == Block.field_71952_K.field_71990_ca)
                        {
                            this.func_76485_a(p_76519_1_, l1, i1, j2, Block.field_71952_K.field_71990_ca, this.field_76521_c);
                        }
                    }
                }
            }
        }
    }
}
