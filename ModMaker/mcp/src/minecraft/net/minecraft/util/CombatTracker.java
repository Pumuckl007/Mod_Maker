package net.minecraft.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class CombatTracker
{
    private final List field_94556_a = new ArrayList();
    private final EntityLivingBase field_94554_b;
    private int field_94555_c;
    private boolean field_94552_d;
    private boolean field_94553_e;
    private String field_94551_f;

    public CombatTracker(EntityLivingBase p_i1565_1_)
    {
        this.field_94554_b = p_i1565_1_;
    }

    public void func_94545_a()
    {
        this.func_94542_g();

        if (this.field_94554_b.func_70617_f_())
        {
            int i = this.field_94554_b.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_94554_b.field_70165_t), MathHelper.func_76128_c(this.field_94554_b.field_70121_D.field_72338_b), MathHelper.func_76128_c(this.field_94554_b.field_70161_v));

            if (i == Block.field_72055_aF.field_71990_ca)
            {
                this.field_94551_f = "ladder";
            }
            else if (i == Block.field_71998_bu.field_71990_ca)
            {
                this.field_94551_f = "vines";
            }
        }
        else if (this.field_94554_b.func_70090_H())
        {
            this.field_94551_f = "water";
        }
    }

    public void func_94547_a(DamageSource p_94547_1_, float p_94547_2_, float p_94547_3_)
    {
        this.func_94549_h();
        this.func_94545_a();
        CombatEntry combatentry = new CombatEntry(p_94547_1_, this.field_94554_b.field_70173_aa, p_94547_2_, p_94547_3_, this.field_94551_f, this.field_94554_b.field_70143_R);
        this.field_94556_a.add(combatentry);
        this.field_94555_c = this.field_94554_b.field_70173_aa;
        this.field_94553_e = true;
        this.field_94552_d |= combatentry.func_94559_f();
    }

    public ChatMessageComponent func_94546_b()
    {
        if (this.field_94556_a.size() == 0)
        {
            return ChatMessageComponent.func_111082_b("death.attack.generic", new Object[] {this.field_94554_b.func_96090_ax()});
        }
        else
        {
            CombatEntry combatentry = this.func_94544_f();
            CombatEntry combatentry1 = (CombatEntry)this.field_94556_a.get(this.field_94556_a.size() - 1);
            String s = combatentry1.func_94558_h();
            Entity entity = combatentry1.func_94560_a().func_76346_g();
            ChatMessageComponent chatmessagecomponent;

            if (combatentry != null && combatentry1.func_94560_a() == DamageSource.field_76379_h)
            {
                String s1 = combatentry.func_94558_h();

                if (combatentry.func_94560_a() != DamageSource.field_76379_h && combatentry.func_94560_a() != DamageSource.field_76380_i)
                {
                    if (s1 != null && (s == null || !s1.equals(s)))
                    {
                        Entity entity1 = combatentry.func_94560_a().func_76346_g();
                        ItemStack itemstack = entity1 instanceof EntityLivingBase ? ((EntityLivingBase)entity1).func_70694_bm() : null;

                        if (itemstack != null && itemstack.func_82837_s())
                        {
                            chatmessagecomponent = ChatMessageComponent.func_111082_b("death.fell.assist.item", new Object[] {this.field_94554_b.func_96090_ax(), s1, itemstack.func_82833_r()});
                        }
                        else
                        {
                            chatmessagecomponent = ChatMessageComponent.func_111082_b("death.fell.assist", new Object[] {this.field_94554_b.func_96090_ax(), s1});
                        }
                    }
                    else if (s != null)
                    {
                        ItemStack itemstack1 = entity instanceof EntityLivingBase ? ((EntityLivingBase)entity).func_70694_bm() : null;

                        if (itemstack1 != null && itemstack1.func_82837_s())
                        {
                            chatmessagecomponent = ChatMessageComponent.func_111082_b("death.fell.finish.item", new Object[] {this.field_94554_b.func_96090_ax(), s, itemstack1.func_82833_r()});
                        }
                        else
                        {
                            chatmessagecomponent = ChatMessageComponent.func_111082_b("death.fell.finish", new Object[] {this.field_94554_b.func_96090_ax(), s});
                        }
                    }
                    else
                    {
                        chatmessagecomponent = ChatMessageComponent.func_111082_b("death.fell.killer", new Object[] {this.field_94554_b.func_96090_ax()});
                    }
                }
                else
                {
                    chatmessagecomponent = ChatMessageComponent.func_111082_b("death.fell.accident." + this.func_94548_b(combatentry), new Object[] {this.field_94554_b.func_96090_ax()});
                }
            }
            else
            {
                chatmessagecomponent = combatentry1.func_94560_a().func_76360_b(this.field_94554_b);
            }

            return chatmessagecomponent;
        }
    }

    public EntityLivingBase func_94550_c()
    {
        EntityLivingBase entitylivingbase = null;
        EntityPlayer entityplayer = null;
        float f = 0.0F;
        float f1 = 0.0F;
        Iterator iterator = this.field_94556_a.iterator();

        while (iterator.hasNext())
        {
            CombatEntry combatentry = (CombatEntry)iterator.next();

            if (combatentry.func_94560_a().func_76346_g() instanceof EntityPlayer && (entityplayer == null || combatentry.func_94563_c() > f1))
            {
                f1 = combatentry.func_94563_c();
                entityplayer = (EntityPlayer)combatentry.func_94560_a().func_76346_g();
            }

            if (combatentry.func_94560_a().func_76346_g() instanceof EntityLivingBase && (entitylivingbase == null || combatentry.func_94563_c() > f))
            {
                f = combatentry.func_94563_c();
                entitylivingbase = (EntityLivingBase)combatentry.func_94560_a().func_76346_g();
            }
        }

        if (entityplayer != null && f1 >= f / 3.0F)
        {
            return entityplayer;
        }
        else
        {
            return entitylivingbase;
        }
    }

    private CombatEntry func_94544_f()
    {
        CombatEntry combatentry = null;
        CombatEntry combatentry1 = null;
        byte b0 = 0;
        float f = 0.0F;

        for (int i = 0; i < this.field_94556_a.size(); ++i)
        {
            CombatEntry combatentry2 = (CombatEntry)this.field_94556_a.get(i);
            CombatEntry combatentry3 = i > 0 ? (CombatEntry)this.field_94556_a.get(i - 1) : null;

            if ((combatentry2.func_94560_a() == DamageSource.field_76379_h || combatentry2.func_94560_a() == DamageSource.field_76380_i) && combatentry2.func_94561_i() > 0.0F && (combatentry == null || combatentry2.func_94561_i() > f))
            {
                if (i > 0)
                {
                    combatentry = combatentry3;
                }
                else
                {
                    combatentry = combatentry2;
                }

                f = combatentry2.func_94561_i();
            }

            if (combatentry2.func_94562_g() != null && (combatentry1 == null || combatentry2.func_94563_c() > (float)b0))
            {
                combatentry1 = combatentry2;
            }
        }

        if (f > 5.0F && combatentry != null)
        {
            return combatentry;
        }
        else if (b0 > 5 && combatentry1 != null)
        {
            return combatentry1;
        }
        else
        {
            return null;
        }
    }

    private String func_94548_b(CombatEntry p_94548_1_)
    {
        return p_94548_1_.func_94562_g() == null ? "generic" : p_94548_1_.func_94562_g();
    }

    private void func_94542_g()
    {
        this.field_94551_f = null;
    }

    private void func_94549_h()
    {
        int i = this.field_94552_d ? 300 : 100;

        if (this.field_94553_e && this.field_94554_b.field_70173_aa - this.field_94555_c > i)
        {
            this.field_94556_a.clear();
            this.field_94553_e = false;
            this.field_94552_d = false;
        }
    }
}
