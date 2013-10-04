package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenHills extends BiomeGenBase
{
    private WorldGenerator field_82915_S;

    protected BiomeGenHills(int p_i1978_1_)
    {
        super(p_i1978_1_);
        this.field_82915_S = new WorldGenMinable(Block.field_72006_bl.field_71990_ca, 8);
    }

    public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        int k = 3 + p_76728_2_.nextInt(6);
        int l;
        int i1;
        int j1;

        for (l = 0; l < k; ++l)
        {
            i1 = p_76728_3_ + p_76728_2_.nextInt(16);
            j1 = p_76728_2_.nextInt(28) + 4;
            int k1 = p_76728_4_ + p_76728_2_.nextInt(16);
            int l1 = p_76728_1_.func_72798_a(i1, j1, k1);

            if (l1 == Block.field_71981_t.field_71990_ca)
            {
                p_76728_1_.func_72832_d(i1, j1, k1, Block.field_72068_bR.field_71990_ca, 0, 2);
            }
        }

        for (k = 0; k < 7; ++k)
        {
            l = p_76728_3_ + p_76728_2_.nextInt(16);
            i1 = p_76728_2_.nextInt(64);
            j1 = p_76728_4_ + p_76728_2_.nextInt(16);
            this.field_82915_S.func_76484_a(p_76728_1_, p_76728_2_, l, i1, j1);
        }
    }
}
