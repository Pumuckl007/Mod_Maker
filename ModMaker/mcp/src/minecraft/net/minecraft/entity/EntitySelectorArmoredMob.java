package net.minecraft.entity;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class EntitySelectorArmoredMob implements IEntitySelector
{
    private final ItemStack field_96567_c;

    public EntitySelectorArmoredMob(ItemStack p_i1584_1_)
    {
        this.field_96567_c = p_i1584_1_;
    }

    public boolean func_82704_a(Entity p_82704_1_)
    {
        if (!p_82704_1_.func_70089_S())
        {
            return false;
        }
        else if (!(p_82704_1_ instanceof EntityLivingBase))
        {
            return false;
        }
        else
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)p_82704_1_;
            return entitylivingbase.func_71124_b(EntityLiving.func_82159_b(this.field_96567_c)) != null ? false : (entitylivingbase instanceof EntityLiving ? ((EntityLiving)entitylivingbase).func_98052_bS() : entitylivingbase instanceof EntityPlayer);
        }
    }
}
