package net.minecraft.util;

public class LongHashMap
{
    private transient LongHashMapEntry[] field_76169_a = new LongHashMapEntry[16];
    private transient int field_76167_b;
    private int field_76168_c = 12;
    private final float field_76165_d = 0.75F;
    private transient volatile int field_76166_e;

    private static int func_76155_g(long p_76155_0_)
    {
        return func_76157_a((int)(p_76155_0_ ^ p_76155_0_ >>> 32));
    }

    private static int func_76157_a(int p_76157_0_)
    {
        p_76157_0_ ^= p_76157_0_ >>> 20 ^ p_76157_0_ >>> 12;
        return p_76157_0_ ^ p_76157_0_ >>> 7 ^ p_76157_0_ >>> 4;
    }

    private static int func_76158_a(int p_76158_0_, int p_76158_1_)
    {
        return p_76158_0_ & p_76158_1_ - 1;
    }

    public int func_76162_a()
    {
        return this.field_76167_b;
    }

    public Object func_76164_a(long p_76164_1_)
    {
        int j = func_76155_g(p_76164_1_);

        for (LongHashMapEntry longhashmapentry = this.field_76169_a[func_76158_a(j, this.field_76169_a.length)]; longhashmapentry != null; longhashmapentry = longhashmapentry.field_76149_c)
        {
            if (longhashmapentry.field_76150_a == p_76164_1_)
            {
                return longhashmapentry.field_76148_b;
            }
        }

        return null;
    }

    public boolean func_76161_b(long p_76161_1_)
    {
        return this.func_76160_c(p_76161_1_) != null;
    }

    final LongHashMapEntry func_76160_c(long p_76160_1_)
    {
        int j = func_76155_g(p_76160_1_);

        for (LongHashMapEntry longhashmapentry = this.field_76169_a[func_76158_a(j, this.field_76169_a.length)]; longhashmapentry != null; longhashmapentry = longhashmapentry.field_76149_c)
        {
            if (longhashmapentry.field_76150_a == p_76160_1_)
            {
                return longhashmapentry;
            }
        }

        return null;
    }

    public void func_76163_a(long p_76163_1_, Object p_76163_3_)
    {
        int j = func_76155_g(p_76163_1_);
        int k = func_76158_a(j, this.field_76169_a.length);

        for (LongHashMapEntry longhashmapentry = this.field_76169_a[k]; longhashmapentry != null; longhashmapentry = longhashmapentry.field_76149_c)
        {
            if (longhashmapentry.field_76150_a == p_76163_1_)
            {
                longhashmapentry.field_76148_b = p_76163_3_;
                return;
            }
        }

        ++this.field_76166_e;
        this.func_76156_a(j, p_76163_1_, p_76163_3_, k);
    }

    private void func_76153_b(int p_76153_1_)
    {
        LongHashMapEntry[] alonghashmapentry = this.field_76169_a;
        int j = alonghashmapentry.length;

        if (j == 1073741824)
        {
            this.field_76168_c = Integer.MAX_VALUE;
        }
        else
        {
            LongHashMapEntry[] alonghashmapentry1 = new LongHashMapEntry[p_76153_1_];
            this.func_76154_a(alonghashmapentry1);
            this.field_76169_a = alonghashmapentry1;
            this.field_76168_c = (int)((float)p_76153_1_ * this.field_76165_d);
        }
    }

    private void func_76154_a(LongHashMapEntry[] p_76154_1_)
    {
        LongHashMapEntry[] alonghashmapentry1 = this.field_76169_a;
        int i = p_76154_1_.length;

        for (int j = 0; j < alonghashmapentry1.length; ++j)
        {
            LongHashMapEntry longhashmapentry = alonghashmapentry1[j];

            if (longhashmapentry != null)
            {
                alonghashmapentry1[j] = null;
                LongHashMapEntry longhashmapentry1;

                do
                {
                    longhashmapentry1 = longhashmapentry.field_76149_c;
                    int k = func_76158_a(longhashmapentry.field_76147_d, i);
                    longhashmapentry.field_76149_c = p_76154_1_[k];
                    p_76154_1_[k] = longhashmapentry;
                    longhashmapentry = longhashmapentry1;
                }
                while (longhashmapentry1 != null);
            }
        }
    }

    public Object func_76159_d(long p_76159_1_)
    {
        LongHashMapEntry longhashmapentry = this.func_76152_e(p_76159_1_);
        return longhashmapentry == null ? null : longhashmapentry.field_76148_b;
    }

    final LongHashMapEntry func_76152_e(long p_76152_1_)
    {
        int j = func_76155_g(p_76152_1_);
        int k = func_76158_a(j, this.field_76169_a.length);
        LongHashMapEntry longhashmapentry = this.field_76169_a[k];
        LongHashMapEntry longhashmapentry1;
        LongHashMapEntry longhashmapentry2;

        for (longhashmapentry1 = longhashmapentry; longhashmapentry1 != null; longhashmapentry1 = longhashmapentry2)
        {
            longhashmapentry2 = longhashmapentry1.field_76149_c;

            if (longhashmapentry1.field_76150_a == p_76152_1_)
            {
                ++this.field_76166_e;
                --this.field_76167_b;

                if (longhashmapentry == longhashmapentry1)
                {
                    this.field_76169_a[k] = longhashmapentry2;
                }
                else
                {
                    longhashmapentry.field_76149_c = longhashmapentry2;
                }

                return longhashmapentry1;
            }

            longhashmapentry = longhashmapentry1;
        }

        return longhashmapentry1;
    }

    private void func_76156_a(int p_76156_1_, long p_76156_2_, Object p_76156_4_, int p_76156_5_)
    {
        LongHashMapEntry longhashmapentry = this.field_76169_a[p_76156_5_];
        this.field_76169_a[p_76156_5_] = new LongHashMapEntry(p_76156_1_, p_76156_2_, p_76156_4_, longhashmapentry);

        if (this.field_76167_b++ >= this.field_76168_c)
        {
            this.func_76153_b(2 * this.field_76169_a.length);
        }
    }

    static int func_76151_f(long p_76151_0_)
    {
        return func_76155_g(p_76151_0_);
    }
}
