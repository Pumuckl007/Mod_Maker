package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.world.World;

public class WorldGenSpikes extends WorldGenerator
{
    private int field_76538_a;

    public WorldGenSpikes(int p_i2023_1_)
    {
        this.field_76538_a = p_i2023_1_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        if (p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_) == this.field_76538_a)
        {
            int l = p_76484_2_.nextInt(32) + 6;
            int i1 = p_76484_2_.nextInt(4) + 1;
            int j1;
            int k1;
            int l1;
            int i2;

            for (j1 = p_76484_3_ - i1; j1 <= p_76484_3_ + i1; ++j1)
            {
                for (k1 = p_76484_5_ - i1; k1 <= p_76484_5_ + i1; ++k1)
                {
                    l1 = j1 - p_76484_3_;
                    i2 = k1 - p_76484_5_;

                    if (l1 * l1 + i2 * i2 <= i1 * i1 + 1 && p_76484_1_.func_72798_a(j1, p_76484_4_ - 1, k1) != this.field_76538_a)
                    {
                        return false;
                    }
                }
            }

            for (j1 = p_76484_4_; j1 < p_76484_4_ + l && j1 < 128; ++j1)
            {
                for (k1 = p_76484_3_ - i1; k1 <= p_76484_3_ + i1; ++k1)
                {
                    for (l1 = p_76484_5_ - i1; l1 <= p_76484_5_ + i1; ++l1)
                    {
                        i2 = k1 - p_76484_3_;
                        int j2 = l1 - p_76484_5_;

                        if (i2 * i2 + j2 * j2 <= i1 * i1 + 1)
                        {
                            p_76484_1_.func_72832_d(k1, j1, l1, Block.field_72089_ap.field_71990_ca, 0, 2);
                        }
                    }
                }
            }

            EntityEnderCrystal entityendercrystal = new EntityEnderCrystal(p_76484_1_);
            entityendercrystal.func_70012_b((double)((float)p_76484_3_ + 0.5F), (double)(p_76484_4_ + l), (double)((float)p_76484_5_ + 0.5F), p_76484_2_.nextFloat() * 360.0F, 0.0F);
            p_76484_1_.func_72838_d(entityendercrystal);
            p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_ + l, p_76484_5_, Block.field_71986_z.field_71990_ca, 0, 2);
            return true;
        }
        else
        {
            return false;
        }
    }
}
