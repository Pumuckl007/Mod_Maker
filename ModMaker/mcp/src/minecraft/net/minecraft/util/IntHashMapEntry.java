package net.minecraft.util;

class IntHashMapEntry
{
    final int field_76035_a;
    Object field_76033_b;
    IntHashMapEntry field_76034_c;
    final int field_76032_d;

    IntHashMapEntry(int p_i1552_1_, int p_i1552_2_, Object p_i1552_3_, IntHashMapEntry p_i1552_4_)
    {
        this.field_76033_b = p_i1552_3_;
        this.field_76034_c = p_i1552_4_;
        this.field_76035_a = p_i1552_2_;
        this.field_76032_d = p_i1552_1_;
    }

    public final int func_76031_a()
    {
        return this.field_76035_a;
    }

    public final Object func_76030_b()
    {
        return this.field_76033_b;
    }

    public final boolean equals(Object p_equals_1_)
    {
        if (!(p_equals_1_ instanceof IntHashMapEntry))
        {
            return false;
        }
        else
        {
            IntHashMapEntry inthashmapentry = (IntHashMapEntry)p_equals_1_;
            Integer integer = Integer.valueOf(this.func_76031_a());
            Integer integer1 = Integer.valueOf(inthashmapentry.func_76031_a());

            if (integer == integer1 || integer != null && integer.equals(integer1))
            {
                Object object1 = this.func_76030_b();
                Object object2 = inthashmapentry.func_76030_b();

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
        return IntHashMap.func_76042_f(this.field_76035_a);
    }

    public final String toString()
    {
        return this.func_76031_a() + "=" + this.func_76030_b();
    }
}
