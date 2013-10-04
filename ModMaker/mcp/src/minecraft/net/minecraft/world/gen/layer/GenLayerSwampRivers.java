package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerSwampRivers extends GenLayer
{
    public GenLayerSwampRivers(long p_i2132_1_, GenLayer p_i2132_3_)
    {
        super(p_i2132_1_);
        this.field_75909_a = p_i2132_3_;
    }

    public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int[] aint = this.field_75909_a.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
        int[] aint1 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

        for (int i1 = 0; i1 < p_75904_4_; ++i1)
        {
            for (int j1 = 0; j1 < p_75904_3_; ++j1)
            {
                this.func_75903_a((long)(j1 + p_75904_1_), (long)(i1 + p_75904_2_));
                int k1 = aint[j1 + 1 + (i1 + 1) * (p_75904_3_ + 2)];

                if ((k1 != BiomeGenBase.field_76780_h.field_76756_M || this.func_75902_a(6) != 0) && (k1 != BiomeGenBase.field_76782_w.field_76756_M && k1 != BiomeGenBase.field_76792_x.field_76756_M || this.func_75902_a(8) != 0))
                {
                    aint1[j1 + i1 * p_75904_3_] = k1;
                }
                else
                {
                    aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.field_76781_i.field_76756_M;
                }
            }
        }

        return aint1;
    }
}
