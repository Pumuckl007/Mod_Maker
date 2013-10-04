package net.minecraft.world.gen.layer;

public class GenLayerFuzzyZoom extends GenLayer
{
    public GenLayerFuzzyZoom(long p_i2123_1_, GenLayer p_i2123_3_)
    {
        super(p_i2123_1_);
        super.field_75909_a = p_i2123_3_;
    }

    public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int i1 = p_75904_1_ >> 1;
        int j1 = p_75904_2_ >> 1;
        int k1 = (p_75904_3_ >> 1) + 3;
        int l1 = (p_75904_4_ >> 1) + 3;
        int[] aint = this.field_75909_a.func_75904_a(i1, j1, k1, l1);
        int[] aint1 = IntCache.func_76445_a(k1 * 2 * l1 * 2);
        int i2 = k1 << 1;
        int j2;

        for (int k2 = 0; k2 < l1 - 1; ++k2)
        {
            j2 = k2 << 1;
            int l2 = j2 * i2;
            int i3 = aint[0 + (k2 + 0) * k1];
            int j3 = aint[0 + (k2 + 1) * k1];

            for (int k3 = 0; k3 < k1 - 1; ++k3)
            {
                this.func_75903_a((long)(k3 + i1 << 1), (long)(k2 + j1 << 1));
                int l3 = aint[k3 + 1 + (k2 + 0) * k1];
                int i4 = aint[k3 + 1 + (k2 + 1) * k1];
                aint1[l2] = i3;
                aint1[l2++ + i2] = this.func_75913_a(i3, j3);
                aint1[l2] = this.func_75913_a(i3, l3);
                aint1[l2++ + i2] = this.func_75912_b(i3, l3, j3, i4);
                i3 = l3;
                j3 = i4;
            }
        }

        int[] aint2 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

        for (j2 = 0; j2 < p_75904_4_; ++j2)
        {
            System.arraycopy(aint1, (j2 + (p_75904_2_ & 1)) * (k1 << 1) + (p_75904_1_ & 1), aint2, j2 * p_75904_3_, p_75904_3_);
        }

        return aint2;
    }

    protected int func_75913_a(int p_75913_1_, int p_75913_2_)
    {
        return this.func_75902_a(2) == 0 ? p_75913_1_ : p_75913_2_;
    }

    protected int func_75912_b(int p_75912_1_, int p_75912_2_, int p_75912_3_, int p_75912_4_)
    {
        int i1 = this.func_75902_a(4);
        return i1 == 0 ? p_75912_1_ : (i1 == 1 ? p_75912_2_ : (i1 == 2 ? p_75912_3_ : p_75912_4_));
    }
}
