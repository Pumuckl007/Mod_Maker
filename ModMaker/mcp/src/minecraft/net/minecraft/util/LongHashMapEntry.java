package net.minecraft.util;

class LongHashMapEntry
{
    final long field_76150_a;
    Object field_76148_b;
    LongHashMapEntry field_76149_c;
    final int field_76147_d;

    LongHashMapEntry(int p_i1553_1_, long p_i1553_2_, Object p_i1553_4_, LongHashMapEntry p_i1553_5_)
    {
        this.field_76148_b = p_i1553_4_;
        this.field_76149_c = p_i1553_5_;
        this.field_76150_a = p_i1553_2_;
        this.field_76147_d = p_i1553_1_;
    }

    public final long func_76146_a()
    {
        return this.field_76150_a;
    }

    public final Object func_76145_b()
    {
        return this.field_76148_b;
    }

    public final boolean equals(Object p_equals_1_)
    {
        if (!(p_equals_1_ instanceof LongHashMapEntry))
        {
            return false;
        }
        else
        {
            LongHashMapEntry longhashmapentry = (LongHashMapEntry)p_equals_1_;
            Long olong = Long.valueOf(this.func_76146_a());
            Long olong1 = Long.valueOf(longhashmapentry.func_76146_a());

            if (olong == olong1 || olong != null && olong.equals(olong1))
            {
                Object object1 = this.func_76145_b();
                Object object2 = longhashmapentry.func_76145_b();

                if (object1 == object2 || object1 != null && object1.equals(object2))
                {
                    return true;
                }
            }

            return false;
        }
    }

    public final int hashCode()
    {
        return LongHashMap.func_76151_f(this.field_76150_a);
    }

    public final String toString()
    {
        return this.func_76146_a() + "=" + this.func_76145_b();
    }
}
