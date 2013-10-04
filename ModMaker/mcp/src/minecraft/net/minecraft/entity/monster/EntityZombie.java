package net.minecraft.entity.monster;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityZombie extends EntityMob
{
    protected static final Attribute field_110186_bp = (new RangedAttribute("zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).func_111117_a("Spawn Reinforcements Chance");
    private static final UUID field_110187_bq = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    private static final AttributeModifier field_110188_br = new AttributeModifier(field_110187_bq, "Baby speed boost", 0.5D, 1);
    private int field_82234_d;

    public EntityZombie(World p_i1745_1_)
    {
        super(p_i1745_1_);
        this.func_70661_as().func_75498_b(true);
        this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        this.field_70714_bg.func_75776_a(1, new EntityAIBreakDoor(this));
        this.field_70714_bg.func_75776_a(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.field_70714_bg.func_75776_a(3, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
        this.field_70714_bg.func_75776_a(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.field_70714_bg.func_75776_a(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, 1.0D));
        this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
    }

    protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0D);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513D);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0D);
        this.func_110140_aT().func_111150_b(field_110186_bp).func_111128_a(this.field_70146_Z.nextDouble() * 0.10000000149011612D);
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        this.func_70096_w().func_75682_a(12, Byte.valueOf((byte)0));
        this.func_70096_w().func_75682_a(13, Byte.valueOf((byte)0));
        this.func_70096_w().func_75682_a(14, Byte.valueOf((byte)0));
    }

    public int func_70658_aO()
    {
        int i = super.func_70658_aO() + 2;

        if (i > 20)
        {
            i = 20;
        }

        return i;
    }

    protected boolean func_70650_aV()
    {
        return true;
    }

    public boolean func_70631_g_()
    {
        return this.func_70096_w().func_75683_a(12) == 1;
    }

    public void func_82227_f(boolean p_82227_1_)
    {
        this.func_70096_w().func_75692_b(12, Byte.valueOf((byte)(p_82227_1_ ? 1 : 0)));

        if (this.field_70170_p != null && !this.field_70170_p.field_72995_K)
        {
            AttributeInstance attributeinstance = this.func_110148_a(SharedMonsterAttributes.field_111263_d);
            attributeinstance.func_111124_b(field_110188_br);

            if (p_82227_1_)
            {
                attributeinstance.func_111121_a(field_110188_br);
            }
        }
    }

    public boolean func_82231_m()
    {
        return this.func_70096_w().func_75683_a(13) == 1;
    }

    public void func_82229_g(boolean p_82229_1_)
    {
        this.func_70096_w().func_75692_b(13, Byte.valueOf((byte)(p_82229_1_ ? 1 : 0)));
    }

    public void func_70636_d()
    {
        if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K && !this.func_70631_g_())
        {
            float f = this.func_70013_c(1.0F);

            if (f > 0.5F && this.field_70146_Z.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)))
            {
                boolean flag = true;
                ItemStack itemstack = this.func_71124_b(4);

                if (itemstack != null)
                {
                    if (itemstack.func_77984_f())
                    {
                        itemstack.func_77964_b(itemstack.func_77952_i() + this.field_70146_Z.nextInt(2));

                        if (itemstack.func_77952_i() >= itemstack.func_77958_k())
                        {
                            this.func_70669_a(itemstack);
                            this.func_70062_b(4, (ItemStack)null);
                        }
                    }

                    flag = false;
                }

                if (flag)
                {
                    this.func_70015_d(8);
                }
            }
        }

        super.func_70636_d();
    }

    public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (!super.func_70097_a(p_70097_1_, p_70097_2_))
        {
            return false;
        }
        else
        {
            EntityLivingBase entitylivingbase = this.func_70638_az();

            if (entitylivingbase == null && this.func_70777_m() instanceof EntityLivingBase)
            {
                entitylivingbase = (EntityLivingBase)this.func_70777_m();
            }

            if (entitylivingbase == null && p_70097_1_.func_76346_g() instanceof EntityLivingBase)
            {
                entitylivingbase = (EntityLivingBase)p_70097_1_.func_76346_g();
            }

            if (entitylivingbase != null && this.field_70170_p.field_73013_u >= 3 && (double)this.field_70146_Z.nextFloat() < this.func_110148_a(field_110186_bp).func_111126_e())
            {
                int i = MathHelper.func_76128_c(this.field_70165_t);
                int j = MathHelper.func_76128_c(this.field_70163_u);
                int k = MathHelper.func_76128_c(this.field_70161_v);
                EntityZombie entityzombie = new EntityZombie(this.field_70170_p);

                for (int l = 0; l < 50; ++l)
                {
                    int i1 = i + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j1 = j + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k1 = k + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);

                    if (this.field_70170_p.func_72797_t(i1, j1 - 1, k1) && this.field_70170_p.func_72957_l(i1, j1, k1) < 10)
                    {
                        entityzombie.func_70107_b((double)i1, (double)j1, (double)k1);

                        if (this.field_70170_p.func_72855_b(entityzombie.field_70121_D) && this.field_70170_p.func_72945_a(entityzombie, entityzombie.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(entityzombie.field_70121_D))
                        {
                            this.field_70170_p.func_72838_d(entityzombie);
                            entityzombie.func_70624_b(entitylivingbase);
                            entityzombie.func_110161_a((EntityLivingData)null);
                            this.func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
                            entityzombie.func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
                            break;
                        }
                    }
                }
            }

            return true;
        }
    }

    public void func_70071_h_()
    {
        if (!this.field_70170_p.field_72995_K && this.func_82230_o())
        {
            int i = this.func_82233_q();
            this.field_82234_d -= i;

            if (this.field_82234_d <= 0)
            {
                this.func_82232_p();
            }
        }

        super.func_70071_h_();
    }

    public boolean func_70652_k(Entity p_70652_1_)
    {
        boolean flag = super.func_70652_k(p_70652_1_);

        if (flag && this.func_70694_bm() == null && this.func_70027_ad() && this.field_70146_Z.nextFloat() < (float)this.field_70170_p.field_73013_u * 0.3F)
        {
            p_70652_1_.func_70015_d(2 * this.field_70170_p.field_73013_u);
        }

        return flag;
    }

    protected String func_70639_aQ()
    {
        return "mob.zombie.say";
    }

    protected String func_70621_aR()
    {
        return "mob.zombie.hurt";
    }

    protected String func_70673_aS()
    {
        return "mob.zombie.death";
    }

    protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_)
    {
        this.func_85030_a("mob.zombie.step", 0.15F, 1.0F);
    }

    protected int func_70633_aT()
    {
        return Item.field_77737_bm.field_77779_bT;
    }

    public EnumCreatureAttribute func_70668_bt()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    protected void func_70600_l(int p_70600_1_)
    {
        switch (this.field_70146_Z.nextInt(3))
        {
            case 0:
                this.func_70025_b(Item.field_77703_o.field_77779_bT, 1);
                break;
            case 1:
                this.func_70025_b(Item.field_82797_bK.field_77779_bT, 1);
                break;
            case 2:
                this.func_70025_b(Item.field_82794_bL.field_77779_bT, 1);
        }
    }

    protected void func_82164_bB()
    {
        super.func_82164_bB();

        if (this.field_70146_Z.nextFloat() < (this.field_70170_p.field_73013_u == 3 ? 0.05F : 0.01F))
        {
            int i = this.field_70146_Z.nextInt(3);

            if (i == 0)
            {
                this.func_70062_b(0, new ItemStack(Item.field_77716_q));
            }
            else
            {
                this.func_70062_b(0, new ItemStack(Item.field_77695_f));
            }
        }
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);

        if (this.func_70631_g_())
        {
            p_70014_1_.func_74757_a("IsBaby", true);
        }

        if (this.func_82231_m())
        {
            p_70014_1_.func_74757_a("IsVillager", true);
        }

        p_70014_1_.func_74768_a("ConversionTime", this.func_82230_o() ? this.field_82234_d : -1);
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);

        if (p_70037_1_.func_74767_n("IsBaby"))
        {
            this.func_82227_f(true);
        }

        if (p_70037_1_.func_74767_n("IsVillager"))
        {
            this.func_82229_g(true);
        }

        if (p_70037_1_.func_74764_b("ConversionTime") && p_70037_1_.func_74762_e("ConversionTime") > -1)
        {
            this.func_82228_a(p_70037_1_.func_74762_e("ConversionTime"));
        }
    }

    public void func_70074_a(EntityLivingBase p_70074_1_)
    {
        super.func_70074_a(p_70074_1_);

        if (this.field_70170_p.field_73013_u >= 2 && p_70074_1_ instanceof EntityVillager)
        {
            if (this.field_70170_p.field_73013_u == 2 && this.field_70146_Z.nextBoolean())
            {
                return;
            }

            EntityZombie entityzombie = new EntityZombie(this.field_70170_p);
            entityzombie.func_82149_j(p_70074_1_);
            this.field_70170_p.func_72900_e(p_70074_1_);
            entityzombie.func_110161_a((EntityLivingData)null);
            entityzombie.func_82229_g(true);

            if (p_70074_1_.func_70631_g_())
            {
                entityzombie.func_82227_f(true);
            }

            this.field_70170_p.func_72838_d(entityzombie);
            this.field_70170_p.func_72889_a((EntityPlayer)null, 1016, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
        }
    }

    public EntityLivingData func_110161_a(EntityLivingData p_110161_1_)
    {
        Object p_110161_1_1 = super.func_110161_a(p_110161_1_);
        float f = this.field_70170_p.func_110746_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.func_98053_h(this.field_70146_Z.nextFloat() < 0.55F * f);

        if (p_110161_1_1 == null)
        {
            p_110161_1_1 = new EntityZombieGroupData(this, this.field_70170_p.field_73012_v.nextFloat() < 0.05F, this.field_70170_p.field_73012_v.nextFloat() < 0.05F, (EntityZombieINNER1)null);
        }

        if (p_110161_1_1 instanceof EntityZombieGroupData)
        {
            EntityZombieGroupData entityzombiegroupdata = (EntityZombieGroupData)p_110161_1_1;

            if (entityzombiegroupdata.field_142046_b)
            {
                this.func_82229_g(true);
            }

            if (entityzombiegroupdata.field_142048_a)
            {
                this.func_82227_f(true);
            }
        }

        this.func_82164_bB();
        this.func_82162_bC();

        if (this.func_71124_b(4) == null)
        {
            Calendar calendar = this.field_70170_p.func_83015_S();

            if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25F)
            {
                this.func_70062_b(4, new ItemStack(this.field_70146_Z.nextFloat() < 0.1F ? Block.field_72008_bf : Block.field_72061_ba));
                this.field_82174_bp[4] = 0.0F;
            }
        }

        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111121_a(new AttributeModifier("Random spawn bonus", this.field_70146_Z.nextDouble() * 0.05000000074505806D, 0));
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(new AttributeModifier("Random zombie-spawn bonus", this.field_70146_Z.nextDouble() * 1.5D, 2));

        if (this.field_70146_Z.nextFloat() < f * 0.05F)
        {
            this.func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Leader zombie bonus", this.field_70146_Z.nextDouble() * 0.25D + 0.5D, 0));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111121_a(new AttributeModifier("Leader zombie bonus", this.field_70146_Z.nextDouble() * 3.0D + 1.0D, 2));
        }

        return (EntityLivingData)p_110161_1_1;
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.func_71045_bC();

        if (itemstack != null && itemstack.func_77973_b() == Item.field_77778_at && itemstack.func_77960_j() == 0 && this.func_82231_m() && this.func_70644_a(Potion.field_76437_t))
        {
            if (!p_70085_1_.field_71075_bZ.field_75098_d)
            {
                --itemstack.field_77994_a;
            }

            if (itemstack.field_77994_a <= 0)
            {
                p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, (ItemStack)null);
            }

            if (!this.field_70170_p.field_72995_K)
            {
                this.func_82228_a(this.field_70146_Z.nextInt(2401) + 3600);
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    protected void func_82228_a(int p_82228_1_)
    {
        this.field_82234_d = p_82228_1_;
        this.func_70096_w().func_75692_b(14, Byte.valueOf((byte)1));
        this.func_82170_o(Potion.field_76437_t.field_76415_H);
        this.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, p_82228_1_, Math.min(this.field_70170_p.field_73013_u - 1, 0)));
        this.field_70170_p.func_72960_a(this, (byte)16);
    }

    @SideOnly(Side.CLIENT)
    public void func_70103_a(byte p_70103_1_)
    {
        if (p_70103_1_ == 16)
        {
            this.field_70170_p.func_72980_b(this.field_70165_t + 0.5D, this.field_70163_u + 0.5D, this.field_70161_v + 0.5D, "mob.zombie.remedy", 1.0F + this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat() * 0.7F + 0.3F, false);
        }
        else
        {
            super.func_70103_a(p_70103_1_);
        }
    }

    protected boolean func_70692_ba()
    {
        return !this.func_82230_o();
    }

    public boolean func_82230_o()
    {
        return this.func_70096_w().func_75683_a(14) == 1;
    }

    protected void func_82232_p()
    {
        EntityVillager entityvillager = new EntityVillager(this.field_70170_p);
        entityvillager.func_82149_j(this);
        entityvillager.func_110161_a((EntityLivingData)null);
        entityvillager.func_82187_q();

        if (this.func_70631_g_())
        {
            entityvillager.func_70873_a(-24000);
        }

        this.field_70170_p.func_72900_e(this);
        this.field_70170_p.func_72838_d(entityvillager);
        entityvillager.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 200, 0));
        this.field_70170_p.func_72889_a((EntityPlayer)null, 1017, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
    }

    protected int func_82233_q()
    {
        int i = 1;

        if (this.field_70146_Z.nextFloat() < 0.01F)
        {
            int j = 0;

            for (int k = (int)this.field_70165_t - 4; k < (int)this.field_70165_t + 4 && j < 14; ++k)
            {
                for (int l = (int)this.field_70163_u - 4; l < (int)this.field_70163_u + 4 && j < 14; ++l)
                {
                    for (int i1 = (int)this.field_70161_v - 4; i1 < (int)this.field_70161_v + 4 && j < 14; ++i1)
                    {
                        int j1 = this.field_70170_p.func_72798_a(k, l, i1);

                        if (j1 == Block.field_72002_bp.field_71990_ca || j1 == Block.field_71959_S.field_71990_ca)
                        {
                            if (this.field_70146_Z.nextFloat() < 0.3F)
                            {
                                ++i;
                            }

                            ++j;
                        }
                    }
                }
            }
        }

        return i;
    }
}
