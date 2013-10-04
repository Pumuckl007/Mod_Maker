package net.minecraft.world.gen.layer;

import net.minecraft.world.WorldType;

public abstract class GenLayer
{
    private long field_75907_b;
    protected GenLayer field_75909_a;
    private long field_75908_c;
    private long field_75906_d;

    public static GenLayer[] func_75901_a(long p_75901_0_, WorldType p_75901_2_)
    {
        GenLayerIsland genlayerisland = new GenLayerIsland(1L);
        GenLayerFuzzyZoom genlayerfuzzyzoom = new GenLayerFuzzyZoom(2000L, genlayerisland);
        GenLayerAddIsland genlayeraddisland = new GenLayerAddIsland(1L, genlayerfuzzyzoom);
        GenLayerZoom genlayerzoom = new GenLayerZoom(2001L, genlayeraddisland);
        genlayeraddisland = new GenLayerAddIsland(2L, genlayerzoom);
        GenLayerAddSnow genlayeraddsnow = new GenLayerAddSnow(2L, genlayeraddisland);
        genlayerzoom = new GenLayerZoom(2002L, genlayeraddsnow);
        genlayeraddisland = new GenLayerAddIsland(3L, genlayerzoom);
        genlayerzoom = new GenLayerZoom(2003L, genlayeraddisland);
        genlayeraddisland = new GenLayerAddIsland(4L, genlayerzoom);
        GenLayerAddMushroomIsland genlayeraddmushroomisland = new GenLayerAddMushroomIsland(5L, genlayeraddisland);
        byte b0 = 4;

        if (p_75901_2_ == WorldType.field_77135_d)
        {
            b0 = 6;
        }

        GenLayer genlayer = GenLayerZoom.func_75915_a(1000L, genlayeraddmushroomisland, 0);
        GenLayerRiverInit genlayerriverinit = new GenLayerRiverInit(100L, genlayer);
        genlayer = GenLayerZoom.func_75915_a(1000L, genlayerriverinit, b0 + 2);
        GenLayerRiver genlayerriver = new GenLayerRiver(1L, genlayer);
        GenLayerSmooth genlayersmooth = new GenLayerSmooth(1000L, genlayerriver);
        GenLayer genlayer1 = GenLayerZoom.func_75915_a(1000L, genlayeraddmushroomisland, 0);
        GenLayerBiome genlayerbiome = new GenLayerBiome(200L, genlayer1, p_75901_2_);
        genlayer1 = GenLayerZoom.func_75915_a(1000L, genlayerbiome, 2);
        Object object = new GenLayerHills(1000L, genlayer1);

        for (int j = 0; j < b0; ++j)
        {
            object = new GenLayerZoom((long)(1000 + j), (GenLayer)object);

            if (j == 0)
            {
                object = new GenLayerAddIsland(3L, (GenLayer)object);
            }

            if (j == 1)
            {
                object = new GenLayerShore(1000L, (GenLayer)object);
            }

            if (j == 1)
            {
                object = new GenLayerSwampRivers(1000L, (GenLayer)object);
            }
        }

        GenLayerSmooth genlayersmooth1 = new GenLayerSmooth(1000L, (GenLayer)object);
        GenLayerRiverMix genlayerrivermix = new GenLayerRiverMix(100L, genlayersmooth1, genlayersmooth);
        GenLayerVoronoiZoom genlayervoronoizoom = new GenLayerVoronoiZoom(10L, genlayerrivermix);
        genlayerrivermix.func_75905_a(p_75901_0_);
        genlayervoronoizoom.func_75905_a(p_75901_0_);
        return new GenLayer[] {genlayerrivermix, genlayervoronoizoom, genlayerrivermix};
    }

    public GenLayer(long p_i2125_1_)
    {
        this.field_75906_d = p_i2125_1_;
        this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
        this.field_75906_d += p_i2125_1_;
        this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
        this.field_75906_d += p_i2125_1_;
        this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
        this.field_75906_d += p_i2125_1_;
    }

    public void func_75905_a(long p_75905_1_)
    {
        this.field_75907_b = p_75905_1_;

        if (this.field_75909_a != null)
        {
            this.field_75909_a.func_75905_a(p_75905_1_);
        }

        this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
        this.field_75907_b += this.field_75906_d;
        this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
        this.field_75907_b += this.field_75906_d;
        this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
        this.field_75907_b += this.field_75906_d;
    }

    public void func_75903_a(long p_75903_1_, long p_75903_3_)
    {
        this.field_75908_c = this.field_75907_b;
        this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
        this.field_75908_c += p_75903_1_;
        this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
        this.field_75908_c += p_75903_3_;
        this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
        this.field_75908_c += p_75903_1_;
        this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
        this.field_75908_c += p_75903_3_;
    }

    protected int func_75902_a(int p_75902_1_)
    {
        int j = (int)((this.field_75908_c >> 24) % (long)p_75902_1_);

        if (j < 0)
        {
            j += p_75902_1_;
        }

        this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
        this.field_75908_c += this.field_75907_b;
        return j;
    }

    public abstract int[] func_75904_a(int i, int j, int k, int l);
}
