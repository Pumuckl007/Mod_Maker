package net.minecraft.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

final class DispenserBehaviorEmptyBucket extends BehaviorDefaultDispenseItem
{
    private final BehaviorDefaultDispenseItem field_96460_b = new BehaviorDefaultDispenseItem();

    public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_)
    {
        EnumFacing enumfacing = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
        World world = p_82487_1_.func_82618_k();
        int i = p_82487_1_.func_82623_d() + enumfacing.func_82601_c();
        int j = p_82487_1_.func_82622_e() + enumfacing.func_96559_d();
        int k = p_82487_1_.func_82621_f() + enumfacing.func_82599_e();
        Material material = world.func_72803_f(i, j, k);
        int l = world.func_72805_g(i, j, k);
        Item item;

        if (Material.field_76244_g.equals(material) && l == 0)
        {
            item = Item.field_77786_ax;
        }
        else
        {
            if (!Material.field_76256_h.equals(material) || l != 0)
            {
                return super.func_82487_b(p_82487_1_, p_82487_2_);
            }

            item = Item.field_77775_ay;
        }

        world.func_94571_i(i, j, k);

        if (--p_82487_2_.field_77994_a == 0)
        {
            p_82487_2_.field_77993_c = item.field_77779_bT;
            p_82487_2_.field_77994_a = 1;
        }
        else if (((TileEntityDispenser)p_82487_1_.func_82619_j()).func_70360_a(new ItemStack(item)) < 0)
        {
            this.field_96460_b.func_82482_a(p_82487_1_, new ItemStack(item));
        }

        return p_82487_2_;
    }
}
