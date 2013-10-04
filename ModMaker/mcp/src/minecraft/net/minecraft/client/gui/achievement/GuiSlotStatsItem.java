package net.minecraft.client.gui.achievement;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.stats.StatCrafting;
import net.minecraft.stats.StatList;

@SideOnly(Side.CLIENT)
class GuiSlotStatsItem extends GuiSlotStats
{
    final GuiStats field_77269_a;

    public GuiSlotStatsItem(GuiStats p_i1069_1_)
    {
        super(p_i1069_1_);
        this.field_77269_a = p_i1069_1_;
        this.field_77266_h = new ArrayList();
        Iterator iterator = StatList.field_75938_d.iterator();

        while (iterator.hasNext())
        {
            StatCrafting statcrafting = (StatCrafting)iterator.next();
            boolean flag = false;
            int i = statcrafting.func_75982_a();

            if (GuiStats.func_74127_c(p_i1069_1_).func_77444_a(statcrafting) > 0)
            {
                flag = true;
            }
            else if (StatList.field_75930_F[i] != null && GuiStats.func_74127_c(p_i1069_1_).func_77444_a(StatList.field_75930_F[i]) > 0)
            {
                flag = true;
            }
            else if (StatList.field_75928_D[i] != null && GuiStats.func_74127_c(p_i1069_1_).func_77444_a(StatList.field_75928_D[i]) > 0)
            {
                flag = true;
            }

            if (flag)
            {
                this.field_77266_h.add(statcrafting);
            }
        }

        this.field_77267_i = new SorterStatsItem(this, p_i1069_1_);
    }

    protected void func_77222_a(int p_77222_1_, int p_77222_2_, Tessellator p_77222_3_)
    {
        super.func_77222_a(p_77222_1_, p_77222_2_, p_77222_3_);

        if (this.field_77262_g == 0)
        {
            GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 115 - 18 + 1, p_77222_2_ + 1 + 1, 72, 18);
        }
        else
        {
            GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 115 - 18, p_77222_2_ + 1, 72, 18);
        }

        if (this.field_77262_g == 1)
        {
            GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 165 - 18 + 1, p_77222_2_ + 1 + 1, 18, 18);
        }
        else
        {
            GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 165 - 18, p_77222_2_ + 1, 18, 18);
        }

        if (this.field_77262_g == 2)
        {
            GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 215 - 18 + 1, p_77222_2_ + 1 + 1, 36, 18);
        }
        else
        {
            GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 215 - 18, p_77222_2_ + 1, 36, 18);
        }
    }

    protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_)
    {
        StatCrafting statcrafting = this.func_77257_d(p_77214_1_);
        int i1 = statcrafting.func_75982_a();
        GuiStats.func_74131_a(this.field_77269_a, p_77214_2_ + 40, p_77214_3_, i1);
        this.func_77260_a((StatCrafting)StatList.field_75930_F[i1], p_77214_2_ + 115, p_77214_3_, p_77214_1_ % 2 == 0);
        this.func_77260_a((StatCrafting)StatList.field_75928_D[i1], p_77214_2_ + 165, p_77214_3_, p_77214_1_ % 2 == 0);
        this.func_77260_a(statcrafting, p_77214_2_ + 215, p_77214_3_, p_77214_1_ % 2 == 0);
    }

    protected String func_77258_c(int p_77258_1_)
    {
        return p_77258_1_ == 1 ? "stat.crafted" : (p_77258_1_ == 2 ? "stat.used" : "stat.depleted");
    }
}
