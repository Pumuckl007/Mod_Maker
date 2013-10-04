package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenHellLava extends WorldGenerator
{
    private int field_76525_a;
    private boolean field_94524_b;

    public WorldGenHellLava(int p_i2016_1_, boolean p_i2016_2_)
    {
        this.field_76525_a = p_i2016_1_;
        this.field_94524_b = p_i2016_2_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        if (p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + 1, p_76484_5_) != Block.field_72012_bb.field_71990_ca)
        {
            return false;
        }
        else if (p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_) != 0 && p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_) != Block.field_72012_bb.field_71990_ca)
        {
            return false;
        }
        else
        {
            int l = 0;

            if (p_76484_1_.func_72798_a(p_76484_3_ - 1, p_76484_4_, p_76484_5_) == Block.field_72012_bb.field_71990_ca)
            {
                ++l;
            }

            if (p_76484_1_.func_72798_a(p_76484_3_ + 1, p_76484_4_, p_76484_5_) == Block.field_72012_bb.field_71990_ca)
            {
                ++l;
            }

            if (p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_ - 1) == Block.field_72012_bb.field_71990_ca)
            {
                ++l;
            }

            if (p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_ + 1) == Block.field_72012_bb.field_71990_ca)
            {
                ++l;
            }

            if (p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_) == Block.field_72012_bb.field_71990_ca)
            {
                ++l;
            }

            int i1 = 0;

            if (p_76484_1_.func_72799_c(p_76484_3_ - 1, p_76484_4_, p_76484_5_))
            {
                ++i1;
            }

            if (p_76484_1_.func_72799_c(p_76484_3_ + 1, p_76484_4_, p_76484_5_))
            {
                ++i1;
            }

            if (p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_ - 1))
            {
                ++i1;
            }

            if (p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_ + 1))
            {
                ++i1;
            }

            if (p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_ - 1, p_76484_5_))
            {
                ++i1;
            }

            if (!this.field_94524_b && l == 4 && i1 == 1 || l == 5)
            {
                p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_, p_76484_5_, this.field_76525_a, 0, 2);
                p_76484_1_.field_72999_e = true;
                Block.field_71973_m[this.field_76525_a].func_71847_b(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, p_76484_2_);
                p_76484_1_.field_72999_e = false;
            }

            return true;
        }
    }
}
