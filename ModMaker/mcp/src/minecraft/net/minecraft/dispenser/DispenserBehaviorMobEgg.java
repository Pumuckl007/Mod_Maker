package net.minecraft.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

final class DispenserBehaviorMobEgg extends BehaviorDefaultDispenseItem
{
    public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_)
    {
        EnumFacing enumfacing = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
        double d0 = p_82487_1_.func_82615_a() + (double)enumfacing.func_82601_c();
        double d1 = (double)((float)p_82487_1_.func_82622_e() + 0.2F);
        double d2 = p_82487_1_.func_82616_c() + (double)enumfacing.func_82599_e();
        Entity entity = ItemMonsterPlacer.func_77840_a(p_82487_1_.func_82618_k(), p_82487_2_.func_77960_j(), d0, d1, d2);

        if (entity instanceof EntityLivingBase && p_82487_2_.func_82837_s())
        {
            ((EntityLiving)entity).func_94058_c(p_82487_2_.func_82833_r());
        }

        p_82487_2_.func_77979_a(1);
        return p_82487_2_;
    }
}
