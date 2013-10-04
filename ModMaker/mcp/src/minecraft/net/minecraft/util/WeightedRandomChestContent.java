package net.minecraft.util;

import java.util.Random;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;

public class WeightedRandomChestContent extends WeightedRandomItem
{
    public ItemStack field_76297_b;
    public int field_76295_d;
    public int field_76296_e;

    public WeightedRandomChestContent(int p_i1557_1_, int p_i1557_2_, int p_i1557_3_, int p_i1557_4_, int p_i1557_5_)
    {
        super(p_i1557_5_);
        this.field_76297_b = new ItemStack(p_i1557_1_, 1, p_i1557_2_);
        this.field_76295_d = p_i1557_3_;
        this.field_76296_e = p_i1557_4_;
    }

    public WeightedRandomChestContent(ItemStack p_i1558_1_, int p_i1558_2_, int p_i1558_3_, int p_i1558_4_)
    {
        super(p_i1558_4_);
        this.field_76297_b = p_i1558_1_;
        this.field_76295_d = p_i1558_2_;
        this.field_76296_e = p_i1558_3_;
    }

    public static void func_76293_a(Random p_76293_0_, WeightedRandomChestContent[] p_76293_1_, IInventory p_76293_2_, int p_76293_3_)
    {
        for (int j = 0; j < p_76293_3_; ++j)
        {
            WeightedRandomChestContent weightedrandomchestcontent = (WeightedRandomChestContent)WeightedRandom.func_76274_a(p_76293_0_, p_76293_1_);
            int k = weightedrandomchestcontent.field_76295_d + p_76293_0_.nextInt(weightedrandomchestcontent.field_76296_e - weightedrandomchestcontent.field_76295_d + 1);

            if (weightedrandomchestcontent.field_76297_b.func_77976_d() >= k)
            {
                ItemStack itemstack = weightedrandomchestcontent.field_76297_b.func_77946_l();
                itemstack.field_77994_a = k;
                p_76293_2_.func_70299_a(p_76293_0_.nextInt(p_76293_2_.func_70302_i_()), itemstack);
            }
            else
            {
                for (int l = 0; l < k; ++l)
                {
                    ItemStack itemstack1 = weightedrandomchestcontent.field_76297_b.func_77946_l();
                    itemstack1.field_77994_a = 1;
                    p_76293_2_.func_70299_a(p_76293_0_.nextInt(p_76293_2_.func_70302_i_()), itemstack1);
                }
            }
        }
    }

    public static void func_76294_a(Random p_76294_0_, WeightedRandomChestContent[] p_76294_1_, TileEntityDispenser p_76294_2_, int p_76294_3_)
    {
        for (int j = 0; j < p_76294_3_; ++j)
        {
            WeightedRandomChestContent weightedrandomchestcontent = (WeightedRandomChestContent)WeightedRandom.func_76274_a(p_76294_0_, p_76294_1_);
            int k = weightedrandomchestcontent.field_76295_d + p_76294_0_.nextInt(weightedrandomchestcontent.field_76296_e - weightedrandomchestcontent.field_76295_d + 1);

            if (weightedrandomchestcontent.field_76297_b.func_77976_d() >= k)
            {
                ItemStack itemstack = weightedrandomchestcontent.field_76297_b.func_77946_l();
                itemstack.field_77994_a = k;
                p_76294_2_.func_70299_a(p_76294_0_.nextInt(p_76294_2_.func_70302_i_()), itemstack);
            }
            else
            {
                for (int l = 0; l < k; ++l)
                {
                    ItemStack itemstack1 = weightedrandomchestcontent.field_76297_b.func_77946_l();
                    itemstack1.field_77994_a = 1;
                    p_76294_2_.func_70299_a(p_76294_0_.nextInt(p_76294_2_.func_70302_i_()), itemstack1);
                }
            }
        }
    }

    public static WeightedRandomChestContent[] func_92080_a(WeightedRandomChestContent[] p_92080_0_, WeightedRandomChestContent ... p_92080_1_)
    {
        WeightedRandomChestContent[] aweightedrandomchestcontent1 = new WeightedRandomChestContent[p_92080_0_.length + p_92080_1_.length];
        int i = 0;

        for (int j = 0; j < p_92080_0_.length; ++j)
        {
            aweightedrandomchestcontent1[i++] = p_92080_0_[j];
        }

        WeightedRandomChestContent[] aweightedrandomchestcontent2 = p_92080_1_;
        int k = p_92080_1_.length;

        for (int l = 0; l < k; ++l)
        {
            WeightedRandomChestContent weightedrandomchestcontent1 = aweightedrandomchestcontent2[l];
            aweightedrandomchestcontent1[i++] = weightedrandomchestcontent1;
        }

        return aweightedrandomchestcontent1;
    }
}
