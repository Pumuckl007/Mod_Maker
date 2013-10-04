package net.minecraft.item;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class ItemLeash extends Item
{
    public ItemLeash(int p_i1884_1_)
    {
        super(p_i1884_1_);
        this.func_77637_a(CreativeTabs.field_78040_i);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        int i1 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);

        if (Block.field_71973_m[i1] != null && Block.field_71973_m[i1].func_71857_b() == 11)
        {
            if (p_77648_3_.field_72995_K)
            {
                return true;
            }
            else
            {
                func_135066_a(p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public static boolean func_135066_a(EntityPlayer p_135066_0_, World p_135066_1_, int p_135066_2_, int p_135066_3_, int p_135066_4_)
    {
        EntityLeashKnot entityleashknot = EntityLeashKnot.func_110130_b(p_135066_1_, p_135066_2_, p_135066_3_, p_135066_4_);
        boolean flag = false;
        double d0 = 7.0D;
        List list = p_135066_1_.func_72872_a(EntityLiving.class, AxisAlignedBB.func_72332_a().func_72299_a((double)p_135066_2_ - d0, (double)p_135066_3_ - d0, (double)p_135066_4_ - d0, (double)p_135066_2_ + d0, (double)p_135066_3_ + d0, (double)p_135066_4_ + d0));

        if (list != null)
        {
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                EntityLiving entityliving = (EntityLiving)iterator.next();

                if (entityliving.func_110167_bD() && entityliving.func_110166_bE() == p_135066_0_)
                {
                    if (entityleashknot == null)
                    {
                        entityleashknot = EntityLeashKnot.func_110129_a(p_135066_1_, p_135066_2_, p_135066_3_, p_135066_4_);
                    }

                    entityliving.func_110162_b(entityleashknot, true);
                    flag = true;
                }
            }
        }

        return flag;
    }
}
