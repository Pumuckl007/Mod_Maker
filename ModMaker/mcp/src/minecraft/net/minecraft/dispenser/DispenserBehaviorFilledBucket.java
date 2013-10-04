package net.minecraft.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

final class DispenserBehaviorFilledBucket extends BehaviorDefaultDispenseItem
{
    private final BehaviorDefaultDispenseItem field_96459_b = new BehaviorDefaultDispenseItem();

    public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_)
    {
        ItemBucket itembucket = (ItemBucket)p_82487_2_.func_77973_b();
        int i = p_82487_1_.func_82623_d();
        int j = p_82487_1_.func_82622_e();
        int k = p_82487_1_.func_82621_f();
        EnumFacing enumfacing = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());

        if (itembucket.func_77875_a(p_82487_1_.func_82618_k(), i + enumfacing.func_82601_c(), j + enumfacing.func_96559_d(), k + enumfacing.func_82599_e()))
        {
            p_82487_2_.field_77993_c = Item.field_77788_aw.field_77779_bT;
            p_82487_2_.field_77994_a = 1;
            return p_82487_2_;
        }
        else
        {
            return this.field_96459_b.func_82482_a(p_82487_1_, p_82487_2_);
        }
    }
}
