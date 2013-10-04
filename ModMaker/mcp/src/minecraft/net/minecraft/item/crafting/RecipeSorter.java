package net.minecraft.item.crafting;

import java.util.Comparator;

class RecipeSorter implements Comparator
{
    final CraftingManager field_77582_a;

    RecipeSorter(CraftingManager p_i1916_1_)
    {
        this.field_77582_a = p_i1916_1_;
    }

    public int func_77581_a(IRecipe p_77581_1_, IRecipe p_77581_2_)
    {
        return p_77581_1_ instanceof ShapelessRecipes && p_77581_2_ instanceof ShapedRecipes ? 1 : (p_77581_2_ instanceof ShapelessRecipes && p_77581_1_ instanceof ShapedRecipes ? -1 : (p_77581_2_.func_77570_a() < p_77581_1_.func_77570_a() ? -1 : (p_77581_2_.func_77570_a() > p_77581_1_.func_77570_a() ? 1 : 0)));
    }

    public int compare(Object p_compare_1_, Object p_compare_2_)
    {
        return this.func_77581_a((IRecipe)p_compare_1_, (IRecipe)p_compare_2_);
    }
}