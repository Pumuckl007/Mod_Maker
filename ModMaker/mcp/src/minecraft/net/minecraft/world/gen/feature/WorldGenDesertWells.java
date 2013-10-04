package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenDesertWells extends WorldGenerator
{
    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        while (p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_4_ > 2)
        {
            --p_76484_4_;
        }

        int l = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_);

        if (l != Block.field_71939_E.field_71990_ca)
        {
            return false;
        }
        else
        {
            int i1;
            int j1;

            for (i1 = -2; i1 <= 2; ++i1)
            {
                for (j1 = -2; j1 <= 2; ++j1)
                {
                    if (p_76484_1_.func_72799_c(p_76484_3_ + i1, p_76484_4_ - 1, p_76484_5_ + j1) && p_76484_1_.func_72799_c(p_76484_3_ + i1, p_76484_4_ - 2, p_76484_5_ + j1))
                    {
                        return false;
                    }
                }
            }

            for (i1 = -1; i1 <= 0; ++i1)
            {
                for (j1 = -2; j1 <= 2; ++j1)
                {
                    for (int k1 = -2; k1 <= 2; ++k1)
                    {
                        p_76484_1_.func_72832_d(p_76484_3_ + j1, p_76484_4_ + i1, p_76484_5_ + k1, Block.field_71957_Q.field_71990_ca, 0, 2);
                    }
                }
            }

            p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_, p_76484_5_, Block.field_71942_A.field_71990_ca, 0, 2);
            p_76484_1_.func_72832_d(p_76484_3_ - 1, p_76484_4_, p_76484_5_, Block.field_71942_A.field_71990_ca, 0, 2);
            p_76484_1_.func_72832_d(p_76484_3_ + 1, p_76484_4_, p_76484_5_, Block.field_71942_A.field_71990_ca, 0, 2);
            p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_, p_76484_5_ - 1, Block.field_71942_A.field_71990_ca, 0, 2);
            p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_, p_76484_5_ + 1, Block.field_71942_A.field_71990_ca, 0, 2);

            for (i1 = -2; i1 <= 2; ++i1)
            {
                for (j1 = -2; j1 <= 2; ++j1)
                {
                    if (i1 == -2 || i1 == 2 || j1 == -2 || j1 == 2)
                    {
                        p_76484_1_.func_72832_d(p_76484_3_ + i1, p_76484_4_ + 1, p_76484_5_ + j1, Block.field_71957_Q.field_71990_ca, 0, 2);
                    }
                }
            }

            p_76484_1_.func_72832_d(p_76484_3_ + 2, p_76484_4_ + 1, p_76484_5_, Block.field_72079_ak.field_71990_ca, 1, 2);
            p_76484_1_.func_72832_d(p_76484_3_ - 2, p_76484_4_ + 1, p_76484_5_, Block.field_72079_ak.field_71990_ca, 1, 2);
            p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_ + 1, p_76484_5_ + 2, Block.field_72079_ak.field_71990_ca, 1, 2);
            p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_ + 1, p_76484_5_ - 2, Block.field_72079_ak.field_71990_ca, 1, 2);

            for (i1 = -1; i1 <= 1; ++i1)
            {
                for (j1 = -1; j1 <= 1; ++j1)
                {
                    if (i1 == 0 && j1 == 0)
                    {
                        p_76484_1_.func_72832_d(p_76484_3_ + i1, p_76484_4_ + 4, p_76484_5_ + j1, Block.field_71957_Q.field_71990_ca, 0, 2);
                    }
                    else
                    {
                        p_76484_1_.func_72832_d(p_76484_3_ + i1, p_76484_4_ + 4, p_76484_5_ + j1, Block.field_72079_ak.field_71990_ca, 1, 2);
                    }
                }
            }

            for (i1 = 1; i1 <= 3; ++i1)
            {
                p_76484_1_.func_72832_d(p_76484_3_ - 1, p_76484_4_ + i1, p_76484_5_ - 1, Block.field_71957_Q.field_71990_ca, 0, 2);
                p_76484_1_.func_72832_d(p_76484_3_ - 1, p_76484_4_ + i1, p_76484_5_ + 1, Block.field_71957_Q.field_71990_ca, 0, 2);
                p_76484_1_.func_72832_d(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_ - 1, Block.field_71957_Q.field_71990_ca, 0, 2);
                p_76484_1_.func_72832_d(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_ + 1, Block.field_71957_Q.field_71990_ca, 0, 2);
            }

            return true;
        }
    }
}
