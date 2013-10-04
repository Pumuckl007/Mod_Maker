package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenPumpkin extends WorldGenerator
{
    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        for (int l = 0; l < 64; ++l)
        {
            int i1 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
            int j1 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
            int k1 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);

            if (p_76484_1_.func_72799_c(i1, j1, k1) && p_76484_1_.func_72798_a(i1, j1 - 1, k1) == Block.field_71980_u.field_71990_ca && Block.field_72061_ba.func_71930_b(p_76484_1_, i1, j1, k1))
            {
                p_76484_1_.func_72832_d(i1, j1, k1, Block.field_72061_ba.field_71990_ca, p_76484_2_.nextInt(4), 2);
            }
        }

        return true;
    }
}