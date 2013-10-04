package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenGlowStone2 extends WorldGenerator
{
    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        if (!p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_))
        {
            return false;
        }
        else if (p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + 1, p_76484_5_) != Block.field_72012_bb.field_71990_ca)
        {
            return false;
        }
        else
        {
            p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_, p_76484_5_, Block.field_72014_bd.field_71990_ca, 0, 2);

            for (int l = 0; l < 1500; ++l)
            {
                int i1 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
                int j1 = p_76484_4_ - p_76484_2_.nextInt(12);
                int k1 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);

                if (p_76484_1_.func_72798_a(i1, j1, k1) == 0)
                {
                    int l1 = 0;

                    for (int i2 = 0; i2 < 6; ++i2)
                    {
                        int j2 = 0;

                        if (i2 == 0)
                        {
                            j2 = p_76484_1_.func_72798_a(i1 - 1, j1, k1);
                        }

                        if (i2 == 1)
                        {
                            j2 = p_76484_1_.func_72798_a(i1 + 1, j1, k1);
                        }

                        if (i2 == 2)
                        {
                            j2 = p_76484_1_.func_72798_a(i1, j1 - 1, k1);
                        }

                        if (i2 == 3)
                        {
                            j2 = p_76484_1_.func_72798_a(i1, j1 + 1, k1);
                        }

                        if (i2 == 4)
                        {
                            j2 = p_76484_1_.func_72798_a(i1, j1, k1 - 1);
                        }

                        if (i2 == 5)
                        {
                            j2 = p_76484_1_.func_72798_a(i1, j1, k1 + 1);
                        }

                        if (j2 == Block.field_72014_bd.field_71990_ca)
                        {
                            ++l1;
                        }
                    }

                    if (l1 == 1)
                    {
                        p_76484_1_.func_72832_d(i1, j1, k1, Block.field_72014_bd.field_71990_ca, 0, 2);
                    }
                }
            }

            return true;
        }
    }
}
