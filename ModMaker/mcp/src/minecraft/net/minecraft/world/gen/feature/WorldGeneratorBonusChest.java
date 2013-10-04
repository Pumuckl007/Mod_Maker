package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class WorldGeneratorBonusChest extends WorldGenerator
{
    private final WeightedRandomChestContent[] field_76546_a;
    private final int field_76545_b;

    public WorldGeneratorBonusChest(WeightedRandomChestContent[] p_i2010_1_, int p_i2010_2_)
    {
        this.field_76546_a = p_i2010_1_;
        this.field_76545_b = p_i2010_2_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int l;

        for (boolean flag = false; ((l = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_)) == 0 || l == Block.field_71952_K.field_71990_ca) && p_76484_4_ > 1; --p_76484_4_)
        {
            ;
        }

        if (p_76484_4_ < 1)
        {
            return false;
        }
        else
        {
            ++p_76484_4_;

            for (int i1 = 0; i1 < 4; ++i1)
            {
                int j1 = p_76484_3_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
                int k1 = p_76484_4_ + p_76484_2_.nextInt(3) - p_76484_2_.nextInt(3);
                int l1 = p_76484_5_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);

                if (p_76484_1_.func_72799_c(j1, k1, l1) && p_76484_1_.func_72797_t(j1, k1 - 1, l1))
                {
                    p_76484_1_.func_72832_d(j1, k1, l1, Block.field_72077_au.field_71990_ca, 0, 2);
                    TileEntityChest tileentitychest = (TileEntityChest)p_76484_1_.func_72796_p(j1, k1, l1);

                    if (tileentitychest != null && tileentitychest != null)
                    {
                        WeightedRandomChestContent.func_76293_a(p_76484_2_, this.field_76546_a, tileentitychest, this.field_76545_b);
                    }

                    if (p_76484_1_.func_72799_c(j1 - 1, k1, l1) && p_76484_1_.func_72797_t(j1 - 1, k1 - 1, l1))
                    {
                        p_76484_1_.func_72832_d(j1 - 1, k1, l1, Block.field_72069_aq.field_71990_ca, 0, 2);
                    }

                    if (p_76484_1_.func_72799_c(j1 + 1, k1, l1) && p_76484_1_.func_72797_t(j1 - 1, k1 - 1, l1))
                    {
                        p_76484_1_.func_72832_d(j1 + 1, k1, l1, Block.field_72069_aq.field_71990_ca, 0, 2);
                    }

                    if (p_76484_1_.func_72799_c(j1, k1, l1 - 1) && p_76484_1_.func_72797_t(j1 - 1, k1 - 1, l1))
                    {
                        p_76484_1_.func_72832_d(j1, k1, l1 - 1, Block.field_72069_aq.field_71990_ca, 0, 2);
                    }

                    if (p_76484_1_.func_72799_c(j1, k1, l1 + 1) && p_76484_1_.func_72797_t(j1 - 1, k1 - 1, l1))
                    {
                        p_76484_1_.func_72832_d(j1, k1, l1 + 1, Block.field_72069_aq.field_71990_ca, 0, 2);
                    }

                    return true;
                }
            }

            return false;
        }
    }
}
