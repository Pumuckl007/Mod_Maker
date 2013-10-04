package net.minecraft.entity.monster;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public abstract class EntityMob extends EntityCreature implements IMob
{
    public EntityMob(World p_i1738_1_)
    {
        super(p_i1738_1_);
        this.field_70728_aV = 5;
    }

    public void func_70636_d()
    {
        this.func_82168_bl();
        float f = this.func_70013_c(1.0F);

        if (f > 0.5F)
        {
            this.field_70708_bq += 2;
        }

        super.func_70636_d();
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();

        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0)
        {
            this.func_70106_y();
        }
    }

    protected Entity func_70782_k()
    {
        EntityPlayer entityplayer = this.field_70170_p.func_72856_b(this, 16.0D);
        return entityplayer != null && this.func_70685_l(entityplayer) ? entityplayer : null;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (this.func_85032_ar())
        {
            return false;
        }
        else if (super.func_70097_a(p_70097_1_, p_70097_2_))
        {
            Entity entity = p_70097_1_.func_76346_g();

            if (this.field_70153_n != entity && this.field_70154_o != entity)
            {
                if (entity != this)
                {
                    this.field_70789_a = entity;
                }

                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public boolean func_70652_k(Entity p_70652_1_)
    {
        float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
        int i = 0;

        if (p_70652_1_ instanceof EntityLivingBase)
        {
            f += EnchantmentHelper.func_77512_a(this, (EntityLivingBase)p_70652_1_);
            i += EnchantmentHelper.func_77507_b(this, (EntityLivingBase)p_70652_1_);
        }

        boolean flag = p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), f);

        if (flag)
        {
            if (i > 0)
            {
                p_70652_1_.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70177_z * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.func_76134_b(this.field_70177_z * (float)Math.PI / 180.0F) * (float)i * 0.5F));
                this.field_70159_w *= 0.6D;
                this.field_70179_y *= 0.6D;
            }

            int j = EnchantmentHelper.func_90036_a(this);

            if (j > 0)
            {
                p_70652_1_.func_70015_d(j * 4);
            }

            if (p_70652_1_ instanceof EntityLivingBase)
            {
                EnchantmentThorns.func_92096_a(this, (EntityLivingBase)p_70652_1_, this.field_70146_Z);
            }
        }

        return flag;
    }

    protected void func_70785_a(Entity p_70785_1_, float p_70785_2_)
    {
        if (this.field_70724_aR <= 0 && p_70785_2_ < 2.0F && p_70785_1_.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && p_70785_1_.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e)
        {
            this.field_70724_aR = 20;
            this.func_70652_k(p_70785_1_);
        }
    }

    public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_)
    {
        return 0.5F - this.field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_);
    }

    protected boolean func_70814_o()
    {
        int i = MathHelper.func_76128_c(this.field_70165_t);
        int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
        int k = MathHelper.func_76128_c(this.field_70161_v);

        if (this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, i, j, k) > this.field_70146_Z.nextInt(32))
        {
            return false;
        }
        else
        {
            int l = this.field_70170_p.func_72957_l(i, j, k);

            if (this.field_70170_p.func_72911_I())
            {
                int i1 = this.field_70170_p.field_73008_k;
                this.field_70170_p.field_73008_k = 10;
                l = this.field_70170_p.func_72957_l(i, j, k);
                this.field_70170_p.field_73008_k = i1;
            }

            return l <= this.field_70146_Z.nextInt(8);
        }
    }

    public boolean func_70601_bi()
    {
        return this.field_70170_p.field_73013_u > 0 && this.func_70814_o() && super.func_70601_bi();
    }

    protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
    }
}