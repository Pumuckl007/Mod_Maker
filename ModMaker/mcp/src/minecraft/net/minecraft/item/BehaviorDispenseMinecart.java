package net.minecraft.item;

import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockRailBase;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

final class BehaviorDispenseMinecart extends BehaviorDefaultDispenseItem
{
    private final BehaviorDefaultDispenseItem field_96465_b = new BehaviorDefaultDispenseItem();

    public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_)
    {
        EnumFacing enumfacing = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
        World world = p_82487_1_.func_82618_k();
        double d0 = p_82487_1_.func_82615_a() + (double)((float)enumfacing.func_82601_c() * 1.125F);
        double d1 = p_82487_1_.func_82617_b() + (double)((float)enumfacing.func_96559_d() * 1.125F);
        double d2 = p_82487_1_.func_82616_c() + (double)((float)enumfacing.func_82599_e() * 1.125F);
        int i = p_82487_1_.func_82623_d() + enumfacing.func_82601_c();
        int j = p_82487_1_.func_82622_e() + enumfacing.func_96559_d();
        int k = p_82487_1_.func_82621_f() + enumfacing.func_82599_e();
        int l = world.func_72798_a(i, j, k);
        double d3;

        if (BlockRailBase.func_72184_d(l))
        {
            d3 = 0.0D;
        }
        else
        {
            if (l != 0 || !BlockRailBase.func_72184_d(world.func_72798_a(i, j - 1, k)))
            {
                return this.field_96465_b.func_82482_a(p_82487_1_, p_82487_2_);
            }

            d3 = -1.0D;
        }

        EntityMinecart entityminecart = EntityMinecart.func_94090_a(world, d0, d1 + d3, d2, ((ItemMinecart)p_82487_2_.func_77973_b()).field_77841_a);

        if (p_82487_2_.func_82837_s())
        {
            entityminecart.func_96094_a(p_82487_2_.func_82833_r());
        }

        world.func_72838_d(entityminecart);
        p_82487_2_.func_77979_a(1);
        return p_82487_2_;
    }

    protected void func_82485_a(IBlockSource p_82485_1_)
    {
        p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
    }
}
