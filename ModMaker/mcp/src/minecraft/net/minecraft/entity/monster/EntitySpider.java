package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpiderEffectsGroupData;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySpider extends EntityMob
{
    public EntitySpider(World p_i1743_1_)
    {
        super(p_i1743_1_);
        this.func_70105_a(1.4F, 0.9F);
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, new Byte((byte)0));
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();

        if (!this.field_70170_p.field_72995_K)
        {
            this.func_70839_e(this.field_70123_F);
        }
    }

    protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(16.0D);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.800000011920929D);
    }

    protected Entity func_70782_k()
    {
        float f = this.func_70013_c(1.0F);

        if (f < 0.5F)
        {
            double d0 = 16.0D;
            return this.field_70170_p.func_72856_b(this, d0);
        }
        else
        {
            return null;
        }
    }

    protected String func_70639_aQ()
    {
        return "mob.spider.say";
    }

    protected String func_70621_aR()
    {
        return "mob.spider.say";
    }

    protected String func_70673_aS()
    {
        return "mob.spider.death";
    }

    protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_)
    {
        this.func_85030_a("mob.spider.step", 0.15F, 1.0F);
    }

    protected void func_70785_a(Entity p_70785_1_, float p_70785_2_)
    {
        float f1 = this.func_70013_c(1.0F);

        if (f1 > 0.5F && this.field_70146_Z.nextInt(100) == 0)
        {
            this.field_70789_a = null;
        }
        else
        {
            if (p_70785_2_ > 2.0F && p_70785_2_ < 6.0F && this.field_70146_Z.nextInt(10) == 0)
            {
                if (this.field_70122_E)
                {
                    double d0 = p_70785_1_.field_70165_t - this.field_70165_t;
                    double d1 = p_70785_1_.field_70161_v - this.field_70161_v;
                    float f2 = MathHelper.func_76133_a(d0 * d0 + d1 * d1);
                    this.field_70159_w = d0 / (double)f2 * 0.5D * 0.800000011920929D + this.field_70159_w * 0.20000000298023224D;
                    this.field_70179_y = d1 / (double)f2 * 0.5D * 0.800000011920929D + this.field_70179_y * 0.20000000298023224D;
                    this.field_70181_x = 0.4000000059604645D;
                }
            }
            else
            {
                super.func_70785_a(p_70785_1_, p_70785_2_);
            }
        }
    }

    protected int func_70633_aT()
    {
        return Item.field_77683_K.field_77779_bT;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
    {
        super.func_70628_a(p_70628_1_, p_70628_2_);

        if (p_70628_1_ && (this.field_70146_Z.nextInt(3) == 0 || this.field_70146_Z.nextInt(1 + p_70628_2_) > 0))
        {
            this.func_70025_b(Item.field_77728_bu.field_77779_bT, 1);
        }
    }

    public boolean func_70617_f_()
    {
        return this.func_70841_p();
    }

    public void func_70110_aj() {}

    public EnumCreatureAttribute func_70668_bt()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    public boolean func_70687_e(PotionEffect p_70687_1_)
    {
        return p_70687_1_.func_76456_a() == Potion.field_76436_u.field_76415_H ? false : super.func_70687_e(p_70687_1_);
    }

    public boolean func_70841_p()
    {
        return (this.field_70180_af.func_75683_a(16) & 1) != 0;
    }

    public void func_70839_e(boolean p_70839_1_)
    {
        byte b0 = this.field_70180_af.func_75683_a(16);

        if (p_70839_1_)
        {
            b0 = (byte)(b0 | 1);
        }
        else
        {
            b0 &= -2;
        }

        this.field_70180_af.func_75692_b(16, Byte.valueOf(b0));
    }

    public EntityLivingData func_110161_a(EntityLivingData p_110161_1_)
    {
        Object p_110161_1_1 = super.func_110161_a(p_110161_1_);

        if (this.field_70170_p.field_73012_v.nextInt(100) == 0)
        {
            EntitySkeleton entityskeleton = new EntitySkeleton(this.field_70170_p);
            entityskeleton.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            entityskeleton.func_110161_a((EntityLivingData)null);
            this.field_70170_p.func_72838_d(entityskeleton);
            entityskeleton.func_70078_a(this);
        }

        if (p_110161_1_1 == null)
        {
            p_110161_1_1 = new SpiderEffectsGroupData();

            if (this.field_70170_p.field_73013_u > 2 && this.field_70170_p.field_73012_v.nextFloat() < 0.1F * this.field_70170_p.func_110746_b(this.field_70165_t, this.field_70163_u, this.field_70161_v))
            {
                ((SpiderEffectsGroupData)p_110161_1_1).func_111104_a(this.field_70170_p.field_73012_v);
            }
        }

        if (p_110161_1_1 instanceof SpiderEffectsGroupData)
        {
            int i = ((SpiderEffectsGroupData)p_110161_1_1).field_111105_a;

            if (i > 0 && Potion.field_76425_a[i] != null)
            {
                this.func_70690_d(new PotionEffect(i, Integer.MAX_VALUE));
            }
        }

        return (EntityLivingData)p_110161_1_1;
    }
}
