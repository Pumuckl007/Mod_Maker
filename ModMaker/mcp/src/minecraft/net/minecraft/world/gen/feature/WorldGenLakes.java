package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldGenLakes extends WorldGenerator
{
    private int field_76524_a;

    public WorldGenLakes(int p_i2018_1_)
    {
        this.field_76524_a = p_i2018_1_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        p_76484_3_ -= 8;

        for (p_76484_5_ -= 8; p_76484_4_ > 5 && p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_); --p_76484_4_)
        {
            ;
        }

        if (p_76484_4_ <= 4)
        {
            return false;
        }
        else
        {
            p_76484_4_ -= 4;
            boolean[] aboolean = new boolean[2048];
            int l = p_76484_2_.nextInt(4) + 4;
            int i1;

            for (i1 = 0; i1 < l; ++i1)
            {
                double d0 = p_76484_2_.nextDouble() * 6.0D + 3.0D;
                double d1 = p_76484_2_.nextDouble() * 4.0D + 2.0D;
                double d2 = p_76484_2_.nextDouble() * 6.0D + 3.0D;
                double d3 = p_76484_2_.nextDouble() * (16.0D - d0 - 2.0D) + 1.0D + d0 / 2.0D;
                double d4 = p_76484_2_.nextDouble() * (8.0D - d1 - 4.0D) + 2.0D + d1 / 2.0D;
                double d5 = p_76484_2_.nextDouble() * (16.0D - d2 - 2.0D) + 1.0D + d2 / 2.0D;

                for (int j1 = 1; j1 < 15; ++j1)
                {
                    for (int k1 = 1; k1 < 15; ++k1)
                    {
                        for (int l1 = 1; l1 < 7; ++l1)
                        {
                            double d6 = ((double)j1 - d3) / (d0 / 2.0D);
                            double d7 = ((double)l1 - d4) / (d1 / 2.0D);
                            double d8 = ((double)k1 - d5) / (d2 / 2.0D);
                            double d9 = d6 * d6 + d7 * d7 + d8 * d8;

                            if (d9 < 1.0D)
                            {
                                aboolean[(j1 * 16 + k1) * 8 + l1] = true;
                            }
                        }
                    }
                }
            }

            int i2;
            int j2;
            boolean flag;

            for (i1 = 0; i1 < 16; ++i1)
            {
                for (j2 = 0; j2 < 16; ++j2)
                {
                    for (i2 = 0; i2 < 8; ++i2)
                    {
                        flag = !aboolean[(i1 * 16 + j2) * 8 + i2] && (i1 < 15 && aboolean[((i1 + 1) * 16 + j2) * 8 + i2] || i1 > 0 && aboolean[((i1 - 1) * 16 + j2) * 8 + i2] || j2 < 15 && aboolean[(i1 * 16 + j2 + 1) * 8 + i2] || j2 > 0 && aboolean[(i1 * 16 + (j2 - 1)) * 8 + i2] || i2 < 7 && aboolean[(i1 * 16 + j2) * 8 + i2 + 1] || i2 > 0 && aboolean[(i1 * 16 + j2) * 8 + (i2 - 1)]);

                        if (flag)
                        {
                            Material material = p_76484_1_.func_72803_f(p_76484_3_ + i1, p_76484_4_ + i2, p_76484_5_ + j2);

                            if (i2 >= 4 && material.func_76224_d())
                            {
                                return false;
                            }

                            if (i2 < 4 && !material.func_76220_a() && p_76484_1_.func_72798_a(p_76484_3_ + i1, p_76484_4_ + i2, p_76484_5_ + j2) != this.field_76524_a)
                            {
                                return false;
                            }
                        }
                    }
                }
            }

            for (i1 = 0; i1 < 16; ++i1)
            {
                for (j2 = 0; j2 < 16; ++j2)
                {
                    for (i2 = 0; i2 < 8; ++i2)
                    {
                        if (aboolean[(i1 * 16 + j2) * 8 + i2])
                        {
                            p_76484_1_.func_72832_d(p_76484_3_ + i1, p_76484_4_ + i2, p_76484_5_ + j2, i2 >= 4 ? 0 : this.field_76524_a, 0, 2);
                        }
                    }
                }
            }

            for (i1 = 0; i1 < 16; ++i1)
            {
                for (j2 = 0; j2 < 16; ++j2)
                {
                    for (i2 = 4; i2 < 8; ++i2)
                    {
                        if (aboolean[(i1 * 16 + j2) * 8 + i2] && p_76484_1_.func_72798_a(p_76484_3_ + i1, p_76484_4_ + i2 - 1, p_76484_5_ + j2) == Block.field_71979_v.field_71990_ca && p_76484_1_.func_72972_b(EnumSkyBlock.Sky, p_76484_3_ + i1, p_76484_4_ + i2, p_76484_5_ + j2) > 0)
                        {
                            BiomeGenBase biomegenbase = p_76484_1_.func_72807_a(p_76484_3_ + i1, p_76484_5_ + j2);

                            if (biomegenbase.field_76752_A == Block.field_71994_by.field_71990_ca)
                            {
                                p_76484_1_.func_72832_d(p_76484_3_ + i1, p_76484_4_ + i2 - 1, p_76484_5_ + j2, Block.field_71994_by.field_71990_ca, 0, 2);
                            }
                            else
                            {
                                p_76484_1_.func_72832_d(p_76484_3_ + i1, p_76484_4_ + i2 - 1, p_76484_5_ + j2, Block.field_71980_u.field_71990_ca, 0, 2);
                            }
                        }
                    }
                }
            }

            if (Block.field_71973_m[this.field_76524_a].field_72018_cp == Material.field_76256_h)
            {
                for (i1 = 0; i1 < 16; ++i1)
                {
                    for (j2 = 0; j2 < 16; ++j2)
                    {
                        for (i2 = 0; i2 < 8; ++i2)
                        {
                            flag = !aboolean[(i1 * 16 + j2) * 8 + i2] && (i1 < 15 && aboolean[((i1 + 1) * 16 + j2) * 8 + i2] || i1 > 0 && aboolean[((i1 - 1) * 16 + j2) * 8 + i2] || j2 < 15 && aboolean[(i1 * 16 + j2 + 1) * 8 + i2] || j2 > 0 && aboolean[(i1 * 16 + (j2 - 1)) * 8 + i2] || i2 < 7 && aboolean[(i1 * 16 + j2) * 8 + i2 + 1] || i2 > 0 && aboolean[(i1 * 16 + j2) * 8 + (i2 - 1)]);

                            if (flag && (i2 < 4 || p_76484_2_.nextInt(2) != 0) && p_76484_1_.func_72803_f(p_76484_3_ + i1, p_76484_4_ + i2, p_76484_5_ + j2).func_76220_a())
                            {
                                p_76484_1_.func_72832_d(p_76484_3_ + i1, p_76484_4_ + i2, p_76484_5_ + j2, Block.field_71981_t.field_71990_ca, 0, 2);
                            }
                        }
                    }
                }
            }

            if (Block.field_71973_m[this.field_76524_a].field_72018_cp == Material.field_76244_g)
            {
                for (i1 = 0; i1 < 16; ++i1)
                {
                    for (j2 = 0; j2 < 16; ++j2)
                    {
                        byte b0 = 4;

                        if (p_76484_1_.func_72884_u(p_76484_3_ + i1, p_76484_4_ + b0, p_76484_5_ + j2))
                        {
                            p_76484_1_.func_72832_d(p_76484_3_ + i1, p_76484_4_ + b0, p_76484_5_ + j2, Block.field_72036_aT.field_71990_ca, 0, 2);
                        }
                    }
                }
            }

            return true;
        }
    }
}
