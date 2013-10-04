package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerShore extends GenLayer
{
    public GenLayerShore(long p_i2130_1_, GenLayer p_i2130_3_)
    {
        super(p_i2130_1_);
        this.field_75909_a = p_i2130_3_;
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
                int l1;
                int i2;
                int j2;
                int k2;

                if (k1 == BiomeGenBase.field_76789_p.field_76756_M)
                {
                    l1 = aint[j1 + 1 + (i1 + 1 - 1) * (p_75904_3_ + 2)];
                    i2 = aint[j1 + 1 + 1 + (i1 + 1) * (p_75904_3_ + 2)];
                    j2 = aint[j1 + 1 - 1 + (i1 + 1) * (p_75904_3_ + 2)];
                    k2 = aint[j1 + 1 + (i1 + 1 + 1) * (p_75904_3_ + 2)];

                    if (l1 != BiomeGenBase.field_76771_b.field_76756_M && i2 != BiomeGenBase.field_76771_b.field_76756_M && j2 != BiomeGenBase.field_76771_b.field_76756_M && k2 != BiomeGenBase.field_76771_b.field_76756_M)
                    {
                        aint1[j1 + i1 * p_75904_3_] = k1;
                    }
                    else
                    {
                        aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.field_76788_q.field_76756_M;
                    }
                }
                else if (k1 != BiomeGenBase.field_76771_b.field_76756_M && k1 != BiomeGenBase.field_76781_i.field_76756_M && k1 != BiomeGenBase.field_76780_h.field_76756_M && k1 != BiomeGenBase.field_76770_e.field_76756_M)
                {
                    l1 = aint[j1 + 1 + (i1 + 1 - 1) * (p_75904_3_ + 2)];
                    i2 = aint[j1 + 1 + 1 + (i1 + 1) * (p_75904_3_ + 2)];
                    j2 = aint[j1 + 1 - 1 + (i1 + 1) * (p_75904_3_ + 2)];
                    k2 = aint[j1 + 1 + (i1 + 1 + 1) * (p_75904_3_ + 2)];

                    if (l1 != BiomeGenBase.field_76771_b.field_76756_M && i2 != BiomeGenBase.field_76771_b.field_76756_M && j2 != BiomeGenBase.field_76771_b.field_76756_M && k2 != BiomeGenBase.field_76771_b.field_76756_M)
                    {
                        aint1[j1 + i1 * p_75904_3_] = k1;
                    }
                    else
                    {
                        aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.field_76787_r.field_76756_M;
                    }
                }
                else if (k1 == BiomeGenBase.field_76770_e.field_76756_M)
                {
                    l1 = aint[j1 + 1 + (i1 + 1 - 1) * (p_75904_3_ + 2)];
                    i2 = aint[j1 + 1 + 1 + (i1 + 1) * (p_75904_3_ + 2)];
                    j2 = aint[j1 + 1 - 1 + (i1 + 1) * (p_75904_3_ + 2)];
                    k2 = aint[j1 + 1 + (i1 + 1 + 1) * (p_75904_3_ + 2)];

                    if (l1 == BiomeGenBase.field_76770_e.field_76756_M && i2 == BiomeGenBase.field_76770_e.field_76756_M && j2 == BiomeGenBase.field_76770_e.field_76756_M && k2 == BiomeGenBase.field_76770_e.field_76756_M)
                    {
                        aint1[j1 + i1 * p_75904_3_] = k1;
                    }
                    else
                    {
                        aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.field_76783_v.field_76756_M;
                    }
                }
                else
                {
                    aint1[j1 + i1 * p_75904_3_] = k1;
                }
            }
        }

        return aint1;
    }
}
