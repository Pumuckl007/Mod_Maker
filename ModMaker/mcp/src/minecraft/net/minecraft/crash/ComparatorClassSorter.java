package net.minecraft.crash;

import java.util.Comparator;

class ComparatorClassSorter implements Comparator
{
    final CallableSuspiciousClasses field_85082_a;

    ComparatorClassSorter(CallableSuspiciousClasses p_i1345_1_)
    {
        this.field_85082_a = p_i1345_1_;
    }

    public int func_85081_a(Class p_85081_1_, Class p_85081_2_)
    {
        String s = p_85081_1_.getPackage() == null ? "" : p_85081_1_.getPackage().getName();
        String s1 = p_85081_2_.getPackage() == null ? "" : p_85081_2_.getPackage().getName();
        return s.compareTo(s1);
    }

    public int compare(Object p_compare_1_, Object p_compare_2_)
    {
        return this.func_85081_a((Class)p_compare_1_, (Class)p_compare_2_);
    }
}
