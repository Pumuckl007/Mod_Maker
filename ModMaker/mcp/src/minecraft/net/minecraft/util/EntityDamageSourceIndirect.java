package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class EntityDamageSourceIndirect extends EntityDamageSource
{
    private Entity field_76387_p;

    public EntityDamageSourceIndirect(String p_i1568_1_, Entity p_i1568_2_, Entity p_i1568_3_)
    {
        super(p_i1568_1_, p_i1568_2_);
        this.field_76387_p = p_i1568_3_;
    }

    public Entity func_76364_f()
    {
        return this.field_76386_o;
    }

    public Entity func_76346_g()
    {
        return this.field_76387_p;
    }

    public ChatMessageComponent func_76360_b(EntityLivingBase p_76360_1_)
    {
        String s = this.field_76387_p == null ? this.field_76386_o.func_96090_ax() : this.field_76387_p.func_96090_ax();
        ItemStack itemstack = this.field_76387_p instanceof EntityLivingBase ? ((EntityLivingBase)this.field_76387_p).func_70694_bm() : null;
        String s1 = "death.attack." + this.field_76373_n;
        String s2 = s1 + ".item";
        return itemstack != null && itemstack.func_82837_s() && StatCollector.func_94522_b(s2) ? ChatMessageComponent.func_111082_b(s2, new Object[] {p_76360_1_.func_96090_ax(), s, itemstack.func_82833_r()}): ChatMessageComponent.func_111082_b(s1, new Object[] {p_76360_1_.func_96090_ax(), s});
    }
}
