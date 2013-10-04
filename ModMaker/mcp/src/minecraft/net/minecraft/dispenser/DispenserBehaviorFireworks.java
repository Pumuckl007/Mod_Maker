package net.minecraft.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

final class DispenserBehaviorFireworks extends BehaviorDefaultDispenseItem
{
    public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_)
    {
        EnumFacing enumfacing = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
        double d0 = p_82487_1_.func_82615_a() + (double)enumfacing.func_82601_c();
        double d1 = (double)((float)p_82487_1_.func_82622_e() + 0.2F);
        double d2 = p_82487_1_.func_82616_c() + (double)enumfacing.func_82599_e();
        EntityFireworkRocket entityfireworkrocket = new EntityFireworkRocket(p_82487_1_.func_82618_k(), d0, d1, d2, p_82487_2_);
        p_82487_1_.func_82618_k().func_72838_d(entityfireworkrocket);
        p_82487_2_.func_77979_a(1);
        return p_82487_2_;
    }

    protected void func_82485_a(IBlockSource p_82485_1_)
    {
        p_82485_1_.func_82618_k().func_72926_e(1002, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
    }
}
