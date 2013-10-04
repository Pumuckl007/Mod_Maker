package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenBigMushroom extends WorldGenerator
{
    private int field_76523_a = -1;

    public WorldGenBigMushroom(int p_i2017_1_)
    {
        super(true);
        this.field_76523_a = p_i2017_1_;
    }

    public WorldGenBigMushroom()
    {
        super(false);
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int l = p_76484_2_.nextInt(2);

        if (this.field_76523_a >= 0)
        {
            l = this.field_76523_a;
        }

        int i1 = p_76484_2_.nextInt(3) + 4;
        boolean flag = true;

        if (p_76484_4_ >= 1 && p_76484_4_ + i1 + 1 < 256)
        {
            int j1;
            int k1;
            int l1;
            int i2;

            for (j1 = p_76484_4_; j1 <= p_76484_4_ + 1 + i1; ++j1)
            {
                byte b0 = 3;

                if (j1 <= p_76484_4_ + 3)
                {
                    b0 = 0;
                }

                for (k1 = p_76484_3_ - b0; k1 <= p_76484_3_ + b0 && flag; ++k1)
                {
                    for (l1 = p_76484_5_ - b0; l1 <= p_76484_5_ + b0 && flag; ++l1)
                    {
                        if (j1 >= 0 && j1 < 256)
                        {
                            i2 = p_76484_1_.func_72798_a(k1, j1, l1);

                            if (i2 != 0 && i2 != Block.field_71952_K.field_71990_ca)
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
                j1 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);

                if (j1 != Block.field_71979_v.field_71990_ca && j1 != Block.field_71980_u.field_71990_ca && j1 != Block.field_71994_by.field_71990_ca)
                {
                    return false;
                }
                else
                {
                    int j2 = p_76484_4_ + i1;

                    if (l == 1)
                    {
                        j2 = p_76484_4_ + i1 - 3;
                    }

                    for (k1 = j2; k1 <= p_76484_4_ + i1; ++k1)
                    {
                        l1 = 1;

                        if (k1 < p_76484_4_ + i1)
                        {
                            ++l1;
                        }

                        if (l == 0)
                        {
                            l1 = 3;
                        }

                        for (i2 = p_76484_3_ - l1; i2 <= p_76484_3_ + l1; ++i2)
                        {
                            for (int k2 = p_76484_5_ - l1; k2 <= p_76484_5_ + l1; ++k2)
                            {
                                int l2 = 5;

                                if (i2 == p_76484_3_ - l1)
                                {
                                    --l2;
                                }

                                if (i2 == p_76484_3_ + l1)
                                {
                                    ++l2;
                                }

                                if (k2 == p_76484_5_ - l1)
                                {
                                    l2 -= 3;
                                }

                                if (k2 == p_76484_5_ + l1)
                                {
                                    l2 += 3;
                                }

                                if (l == 0 || k1 < p_76484_4_ + i1)
                                {
                                    if ((i2 == p_76484_3_ - l1 || i2 == p_76484_3_ + l1) && (k2 == p_76484_5_ - l1 || k2 == p_76484_5_ + l1))
                                    {
                                        continue;
                                    }

                                    if (i2 == p_76484_3_ - (l1 - 1) && k2 == p_76484_5_ - l1)
                                    {
                                        l2 = 1;
                                    }

                                    if (i2 == p_76484_3_ - l1 && k2 == p_76484_5_ - (l1 - 1))
                                    {
                                        l2 = 1;
                                    }

                                    if (i2 == p_76484_3_ + (l1 - 1) && k2 == p_76484_5_ - l1)
                                    {
                                        l2 = 3;
                                    }

                                    if (i2 == p_76484_3_ + l1 && k2 == p_76484_5_ - (l1 - 1))
                                    {
                                        l2 = 3;
                                    }

                                    if (i2 == p_76484_3_ - (l1 - 1) && k2 == p_76484_5_ + l1)
                                    {
                                        l2 = 7;
                                    }

                                    if (i2 == p_76484_3_ - l1 && k2 == p_76484_5_ + (l1 - 1))
                                    {
                                        l2 = 7;
                                    }

                                    if (i2 == p_76484_3_ + (l1 - 1) && k2 == p_76484_5_ + l1)
                                    {
                                        l2 = 9;
                                    }

                                    if (i2 == p_76484_3_ + l1 && k2 == p_76484_5_ + (l1 - 1))
                                    {
                                        l2 = 9;
                                    }
                                }

                                if (l2 == 5 && k1 < p_76484_4_ + i1)
                                {
                                    l2 = 0;
                                }

                                if ((l2 != 0 || p_76484_4_ >= p_76484_4_ + i1 - 1) && !Block.field_71970_n[p_76484_1_.func_72798_a(i2, k1, k2)])
                                {
                                    this.func_76485_a(p_76484_1_, i2, k1, k2, Block.field_72000_bn.field_71990_ca + l, l2);
                                }
                            }
                        }
                    }

                    for (k1 = 0; k1 < i1; ++k1)
                    {
                        l1 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + k1, p_76484_5_);

                        if (!Block.field_71970_n[l1])
                        {
                            this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + k1, p_76484_5_, Block.field_72000_bn.field_71990_ca + l, 10);
                        }
                    }

                    return true;
                }
            }
        }
        else
        {
            return false;
        }
    }
}
