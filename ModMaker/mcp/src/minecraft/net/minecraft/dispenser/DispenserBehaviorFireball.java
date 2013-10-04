package net.minecraft.dispenser;

import java.util.Random;
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

final class DispenserBehaviorFireball extends BehaviorDefaultDispenseItem
{
    public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_)
    {
        EnumFacing enumfacing = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
        IPosition iposition = BlockDispenser.func_82525_a(p_82487_1_);
        double d0 = iposition.func_82615_a() + (double)((float)enumfacing.func_82601_c() * 0.3F);
        double d1 = iposition.func_82617_b() + (double)((float)enumfacing.func_82601_c() * 0.3F);
        double d2 = iposition.func_82616_c() + (double)((float)enumfacing.func_82599_e() * 0.3F);
        World world = p_82487_1_.func_82618_k();
        Random random = world.field_73012_v;
        double d3 = random.nextGaussian() * 0.05D + (double)enumfacing.func_82601_c();
        double d4 = random.nextGaussian() * 0.05D + (double)enumfacing.func_96559_d();
        double d5 = random.nextGaussian() * 0.05D + (double)enumfacing.func_82599_e();
        world.func_72838_d(new EntitySmallFireball(world, d0, d1, d2, d3, d4, d5));
        p_82487_2_.func_77979_a(1);
        return p_82487_2_;
    }

    protected void func_82485_a(IBlockSource p_82485_1_)
    {
        p_82485_1_.func_82618_k().func_72926_e(1009, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
    }
}
