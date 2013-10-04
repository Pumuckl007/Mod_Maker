package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenShrub extends WorldGenerator
{
    private int field_76527_a;
    private int field_76526_b;

    public WorldGenShrub(int p_i2015_1_, int p_i2015_2_)
    {
        this.field_76526_b = p_i2015_1_;
        this.field_76527_a = p_i2015_2_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int l;

        for (boolean flag = false; ((l = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_)) == 0 || l == Block.field_71952_K.field_71990_ca) && p_76484_4_ > 0; --p_76484_4_)
        {
            ;
        }

        int i1 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_);

        if (i1 == Block.field_71979_v.field_71990_ca || i1 == Block.field_71980_u.field_71990_ca)
        {
            ++p_76484_4_;
            this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, Block.field_71951_J.field_71990_ca, this.field_76526_b);

            for (int j1 = p_76484_4_; j1 <= p_76484_4_ + 2; ++j1)
            {
                int k1 = j1 - p_76484_4_;
                int l1 = 2 - k1;

                for (int i2 = p_76484_3_ - l1; i2 <= p_76484_3_ + l1; ++i2)
                {
                    int j2 = i2 - p_76484_3_;

                    for (int k2 = p_76484_5_ - l1; k2 <= p_76484_5_ + l1; ++k2)
                    {
                        int l2 = k2 - p_76484_5_;

                        if ((Math.abs(j2) != l1 || Math.abs(l2) != l1 || p_76484_2_.nextInt(2) != 0) && !Block.field_71970_n[p_76484_1_.func_72798_a(i2, j1, k2)])
                        {
                            this.func_76485_a(p_76484_1_, i2, j1, k2, Block.field_71952_K.field_71990_ca, this.field_76527_a);
                        }
                    }
                }
            }
        }

        return true;
    }
}
