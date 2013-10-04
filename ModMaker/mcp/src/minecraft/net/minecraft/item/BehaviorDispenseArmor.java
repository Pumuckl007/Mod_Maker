package net.minecraft.item;

import java.util.List;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntitySelectorArmoredMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;

final class BehaviorDispenseArmor extends BehaviorDefaultDispenseItem
{
    protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_)
    {
        EnumFacing enumfacing = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
        int i = p_82487_1_.func_82623_d() + enumfacing.func_82601_c();
        int j = p_82487_1_.func_82622_e() + enumfacing.func_96559_d();
        int k = p_82487_1_.func_82621_f() + enumfacing.func_82599_e();
        AxisAlignedBB axisalignedbb = AxisAlignedBB.func_72332_a().func_72299_a((double)i, (double)j, (double)k, (double)(i + 1), (double)(j + 1), (double)(k + 1));
        List list = p_82487_1_.func_82618_k().func_82733_a(EntityLivingBase.class, axisalignedbb, new EntitySelectorArmoredMob(p_82487_2_));

        if (list.size() > 0)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)list.get(0);
            int l = entitylivingbase instanceof EntityPlayer ? 1 : 0;
            int i1 = EntityLiving.func_82159_b(p_82487_2_);
            ItemStack itemstack1 = p_82487_2_.func_77946_l();
            itemstack1.field_77994_a = 1;
            entitylivingbase.func_70062_b(i1 - l, itemstack1);

            if (entitylivingbase instanceof EntityLiving)
            {
                ((EntityLiving)entitylivingbase).func_96120_a(i1, 2.0F);
            }

            --p_82487_2_.field_77994_a;
            return p_82487_2_;
        }
        else
        {
            return super.func_82487_b(p_82487_1_, p_82487_2_);
        }
    }
}
