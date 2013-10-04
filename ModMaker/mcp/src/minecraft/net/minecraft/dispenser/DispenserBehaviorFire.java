package net.minecraft.dispenser;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

final class DispenserBehaviorFire extends BehaviorDefaultDispenseItem
{
    private boolean field_96466_b = true;

    protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_)
    {
        EnumFacing enumfacing = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
        World world = p_82487_1_.func_82618_k();
        int i = p_82487_1_.func_82623_d() + enumfacing.func_82601_c();
        int j = p_82487_1_.func_82622_e() + enumfacing.func_96559_d();
        int k = p_82487_1_.func_82621_f() + enumfacing.func_82599_e();

        if (world.func_72799_c(i, j, k))
        {
            world.func_94575_c(i, j, k, Block.field_72067_ar.field_71990_ca);

            if (p_82487_2_.func_96631_a(1, world.field_73012_v))
            {
                p_82487_2_.field_77994_a = 0;
            }
        }
        else if (world.func_72798_a(i, j, k) == Block.field_72091_am.field_71990_ca)
        {
            Block.field_72091_am.func_71898_d(world, i, j, k, 1);
            world.func_94571_i(i, j, k);
        }
        else
        {
            this.field_96466_b = false;
        }

        return p_82487_2_;
    }

    protected void func_82485_a(IBlockSource p_82485_1_)
    {
        if (this.field_96466_b)
        {
            p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
        }
        else
        {
            p_82485_1_.func_82618_k().func_72926_e(1001, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
        }
    }
}
