package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class WorldGenReed extends WorldGenerator
{
    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        for (int l = 0; l < 20; ++l)
        {
            int i1 = p_76484_3_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
            int j1 = p_76484_4_;
            int k1 = p_76484_5_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);

            if (p_76484_1_.func_72799_c(i1, p_76484_4_, k1) && (p_76484_1_.func_72803_f(i1 - 1, p_76484_4_ - 1, k1) == Material.field_76244_g || p_76484_1_.func_72803_f(i1 + 1, p_76484_4_ - 1, k1) == Material.field_76244_g || p_76484_1_.func_72803_f(i1, p_76484_4_ - 1, k1 - 1) == Material.field_76244_g || p_76484_1_.func_72803_f(i1, p_76484_4_ - 1, k1 + 1) == Material.field_76244_g))
            {
                int l1 = 2 + p_76484_2_.nextInt(p_76484_2_.nextInt(3) + 1);

                for (int i2 = 0; i2 < l1; ++i2)
                {
                    if (Block.field_72040_aX.func_71854_d(p_76484_1_, i1, j1 + i2, k1))
                    {
                        p_76484_1_.func_72832_d(i1, j1 + i2, k1, Block.field_72040_aX.field_71990_ca, 0, 2);
                    }
                }
            }
        }

        return true;
    }
}
