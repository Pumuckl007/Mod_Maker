package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerFoliage;

public class ItemLeaves extends ItemBlock
{
    public ItemLeaves(int p_i1883_1_)
    {
        super(p_i1883_1_);
        this.func_77656_e(0);
        this.func_77627_a(true);
    }

    public int func_77647_b(int p_77647_1_)
    {
        return p_77647_1_ | 4;
    }

    @SideOnly(Side.CLIENT)
    public Icon func_77617_a(int p_77617_1_)
    {
        return Block.field_71952_K.func_71858_a(0, p_77617_1_);
    }

    @SideOnly(Side.CLIENT)
    public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_)
    {
        int j = p_82790_1_.func_77960_j();
        return (j & 1) == 1 ? ColorizerFoliage.func_77466_a() : ((j & 2) == 2 ? ColorizerFoliage.func_77469_b() : ColorizerFoliage.func_77468_c());
    }

    public String func_77667_c(ItemStack p_77667_1_)
    {
        int i = p_77667_1_.func_77960_j();

        if (i < 0 || i >= BlockLeaves.field_72136_a.length)
        {
            i = 0;
        }

        return super.func_77658_a() + "." + BlockLeaves.field_72136_a[i];
    }
}
