package net.minecraft.item.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesWeapons
{
    private String[][] field_77585_a = new String[][] {{"X", "X", "#"}};
    private Object[][] field_77584_b;

    public RecipesWeapons()
    {
        this.field_77584_b = new Object[][] {{Block.field_71988_x, Block.field_71978_w, Item.field_77703_o, Item.field_77702_n, Item.field_77717_p}, {Item.field_77715_r, Item.field_77711_v, Item.field_77716_q, Item.field_77718_z, Item.field_77672_G}};
    }

    public void func_77583_a(CraftingManager p_77583_1_)
    {
        for (int i = 0; i < this.field_77584_b[0].length; ++i)
        {
            Object object = this.field_77584_b[0][i];

            for (int j = 0; j < this.field_77584_b.length - 1; ++j)
            {
                Item item = (Item)this.field_77584_b[j + 1][i];
                p_77583_1_.func_92103_a(new ItemStack(item), new Object[] {this.field_77585_a[j], '#', Item.field_77669_D, 'X', object});
            }
        }

        p_77583_1_.func_92103_a(new ItemStack(Item.field_77707_k, 1), new Object[] {" #X", "# X", " #X", 'X', Item.field_77683_K, '#', Item.field_77669_D});
        p_77583_1_.func_92103_a(new ItemStack(Item.field_77704_l, 4), new Object[] {"X", "#", "Y", 'Y', Item.field_77676_L, 'X', Item.field_77804_ap, '#', Item.field_77669_D});
    }
}
