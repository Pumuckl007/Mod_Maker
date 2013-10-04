package net.minecraft.world.gen.layer;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;

public class GenLayerBiome extends GenLayer
{
    private BiomeGenBase[] field_75914_b;

    public GenLayerBiome(long p_i2122_1_, GenLayer p_i2122_3_, WorldType p_i2122_4_)
    {
        super(p_i2122_1_);
        this.field_75914_b = new BiomeGenBase[] {BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76772_c, BiomeGenBase.field_76768_g, BiomeGenBase.field_76782_w};
        this.field_75909_a = p_i2122_3_;

        if (p_i2122_4_ == WorldType.field_77136_e)
        {
            this.field_75914_b = new BiomeGenBase[] {BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76772_c, BiomeGenBase.field_76768_g};
        }
    }

    public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int[] aint = this.field_75909_a.func_75904_a(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
        int[] aint1 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

        for (int i1 = 0; i1 < p_75904_4_; ++i1)
        {
            for (int j1 = 0; j1 < p_75904_3_; ++j1)
            {
                this.func_75903_a((long)(j1 + p_75904_1_), (long)(i1 + p_75904_2_));
                int k1 = aint[j1 + i1 * p_75904_3_];

                if (k1 == 0)
                {
                    aint1[j1 + i1 * p_75904_3_] = 0;
                }
                else if (k1 == BiomeGenBase.field_76789_p.field_76756_M)
                {
                    aint1[j1 + i1 * p_75904_3_] = k1;
                }
                else if (k1 == 1)
                {
                    aint1[j1 + i1 * p_75904_3_] = this.field_75914_b[this.func_75902_a(this.field_75914_b.length)].field_76756_M;
                }
                else
                {
                    int l1 = this.field_75914_b[this.func_75902_a(this.field_75914_b.length)].field_76756_M;

                    if (l1 == BiomeGenBase.field_76768_g.field_76756_M)
                    {
                        aint1[j1 + i1 * p_75904_3_] = l1;
                    }
                    else
                    {
                        aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.field_76774_n.field_76756_M;
                    }
                }
            }
        }

        return aint1;
    }
}
