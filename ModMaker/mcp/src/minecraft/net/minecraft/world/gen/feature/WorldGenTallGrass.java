package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenTallGrass extends WorldGenerator
{
    private int field_76535_a;
    private int field_76534_b;

    public WorldGenTallGrass(int p_i2026_1_, int p_i2026_2_)
    {
        this.field_76535_a = p_i2026_1_;
        this.field_76534_b = p_i2026_2_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int l;

        for (boolean flag = false; ((l = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_)) == 0 || l == Block.field_71952_K.field_71990_ca) && p_76484_4_ > 0; --p_76484_4_)
        {
            ;
        }

        for (int i1 = 0; i1 < 128; ++i1)
        {
            int j1 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
            int k1 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
            int l1 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);

            if (p_76484_1_.func_72799_c(j1, k1, l1) && Block.field_71973_m[this.field_76535_a].func_71854_d(p_76484_1_, j1, k1, l1))
            {
                p_76484_1_.func_72832_d(j1, k1, l1, this.field_76535_a, this.field_76534_b, 2);
            }
        }

        return true;
    }
}
