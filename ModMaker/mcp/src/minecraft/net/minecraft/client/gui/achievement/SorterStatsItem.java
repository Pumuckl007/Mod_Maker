package net.minecraft.client.gui.achievement;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Comparator;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatCrafting;
import net.minecraft.stats.StatList;

@SideOnly(Side.CLIENT)
class SorterStatsItem implements Comparator
{
    final GuiStats field_78339_a;

    final GuiSlotStatsItem field_78338_b;

    SorterStatsItem(GuiSlotStatsItem p_i1068_1_, GuiStats p_i1068_2_)
    {
        this.field_78338_b = p_i1068_1_;
        this.field_78339_a = p_i1068_2_;
    }

    public int func_78337_a(StatCrafting p_78337_1_, StatCrafting p_78337_2_)
    {
        int i = p_78337_1_.func_75982_a();
        int j = p_78337_2_.func_75982_a();
        StatBase statbase = null;
        StatBase statbase1 = null;

        if (this.field_78338_b.field_77264_j == 0)
        {
            statbase = StatList.field_75930_F[i];
            statbase1 = StatList.field_75930_F[j];
        }
        else if (this.field_78338_b.field_77264_j == 1)
        {
            statbase = StatList.field_75928_D[i];
            statbase1 = StatList.field_75928_D[j];
        }
        else if (this.field_78338_b.field_77264_j == 2)
        {
            statbase = StatList.field_75929_E[i];
            statbase1 = StatList.field_75929_E[j];
        }

        if (statbase != null || statbase1 != null)
        {
            if (statbase == null)
            {
                return 1;
            }

            if (statbase1 == null)
            {
                return -1;
            }

            int k = GuiStats.func_74127_c(this.field_78338_b.field_77269_a).func_77444_a(statbase);
            int l = GuiStats.func_74127_c(this.field_78338_b.field_77269_a).func_77444_a(statbase1);

            if (k != l)
            {
                return (k - l) * this.field_78338_b.field_77265_k;
            }
        }

        return i - j;
    }

    public int compare(Object p_compare_1_, Object p_compare_2_)
    {
        return this.func_78337_a((StatCrafting)p_compare_1_, (StatCrafting)p_compare_2_);
    }
}
