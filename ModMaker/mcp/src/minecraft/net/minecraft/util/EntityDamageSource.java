package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class EntityDamageSource extends DamageSource
{
    protected Entity field_76386_o;

    public EntityDamageSource(String p_i1567_1_, Entity p_i1567_2_)
    {
        super(p_i1567_1_);
        this.field_76386_o = p_i1567_2_;
    }

    public Entity func_76346_g()
    {
        return this.field_76386_o;
    }

    public ChatMessageComponent func_76360_b(EntityLivingBase p_76360_1_)
    {
        ItemStack itemstack = this.field_76386_o instanceof EntityLivingBase ? ((EntityLivingBase)this.field_76386_o).func_70694_bm() : null;
        String s = "death.attack." + this.field_76373_n;
        String s1 = s + ".item";
        return itemstack != null && itemstack.func_82837_s() && StatCollector.func_94522_b(s1) ? ChatMessageComponent.func_111082_b(s1, new Object[] {p_76360_1_.func_96090_ax(), this.field_76386_o.func_96090_ax(), itemstack.func_82833_r()}): ChatMessageComponent.func_111082_b(s, new Object[] {p_76360_1_.func_96090_ax(), this.field_76386_o.func_96090_ax()});
    }

    public boolean func_76350_n()
    {
        return this.field_76386_o != null && this.field_76386_o instanceof EntityLivingBase && !(this.field_76386_o instanceof EntityPlayer);
    }
}
