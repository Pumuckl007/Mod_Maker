package net.minecraft.entity.passive;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRunAroundLikeCrazy;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityHorse extends EntityAnimal implements IInvBasic
{
    private static final IEntitySelector field_110276_bu = new EntityHorseBredSelector();
    private static final Attribute field_110271_bv = (new RangedAttribute("horse.jumpStrength", 0.7D, 0.0D, 2.0D)).func_111117_a("Jump Strength").func_111112_a(true);
    private static final String[] field_110270_bw = new String[] {null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png"};
    private static final String[] field_110273_bx = new String[] {"", "meo", "goo", "dio"};
    private static final int[] field_110272_by = new int[] {0, 5, 7, 11};
    private static final String[] field_110268_bz = new String[] {"textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png"};
    private static final String[] field_110269_bA = new String[] {"hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb"};
    private static final String[] field_110291_bB = new String[] {null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png"};
    private static final String[] field_110292_bC = new String[] {"", "wo_", "wmo", "wdo", "bdo"};
    private int field_110289_bD;
    private int field_110290_bE;
    private int field_110295_bF;
    public int field_110278_bp;
    public int field_110279_bq;
    protected boolean field_110275_br;
    private AnimalChest field_110296_bG;
    private boolean field_110293_bH;
    protected int field_110274_bs;
    protected float field_110277_bt;
    private boolean field_110294_bI;
    private float field_110283_bJ;
    private float field_110284_bK;
    private float field_110281_bL;
    private float field_110282_bM;
    private float field_110287_bN;
    private float field_110288_bO;
    private int field_110285_bP;
    private String field_110286_bQ;
    private String[] field_110280_bR = new String[3];

    public EntityHorse(World p_i1685_1_)
    {
        super(p_i1685_1_);
        this.func_70105_a(1.4F, 1.6F);
        this.field_70178_ae = false;
        this.func_110207_m(false);
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        this.field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 1.2D));
        this.field_70714_bg.func_75776_a(1, new EntityAIRunAroundLikeCrazy(this, 1.2D));
        this.field_70714_bg.func_75776_a(2, new EntityAIMate(this, 1.0D));
        this.field_70714_bg.func_75776_a(4, new EntityAIFollowParent(this, 1.0D));
        this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, 0.7D));
        this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.field_70714_bg.func_75776_a(8, new EntityAILookIdle(this));
        this.func_110226_cD();
    }

    protected void func_70088_a()
    {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, Integer.valueOf(0));
        this.field_70180_af.func_75682_a(19, Byte.valueOf((byte)0));
        this.field_70180_af.func_75682_a(20, Integer.valueOf(0));
        this.field_70180_af.func_75682_a(21, String.valueOf(""));
        this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
    }

    public void func_110214_p(int p_110214_1_)
    {
        this.field_70180_af.func_75692_b(19, Byte.valueOf((byte)p_110214_1_));
        this.func_110230_cF();
    }

    public int func_110265_bP()
    {
        return this.field_70180_af.func_75683_a(19);
    }

    public void func_110235_q(int p_110235_1_)
    {
        this.field_70180_af.func_75692_b(20, Integer.valueOf(p_110235_1_));
        this.func_110230_cF();
    }

    public int func_110202_bQ()
    {
        return this.field_70180_af.func_75679_c(20);
    }

    public String func_70023_ak()
    {
        if (this.func_94056_bM())
        {
            return this.func_94057_bL();
        }
        else
        {
            int i = this.func_110265_bP();

            switch (i)
            {
                case 0:
                default:
                    return StatCollector.func_74838_a("entity.horse.name");
                case 1:
                    return StatCollector.func_74838_a("entity.donkey.name");
                case 2:
                    return StatCollector.func_74838_a("entity.mule.name");
                case 3:
                    return StatCollector.func_74838_a("entity.zombiehorse.name");
                case 4:
                    return StatCollector.func_74838_a("entity.skeletonhorse.name");
            }
        }
    }

    private boolean func_110233_w(int p_110233_1_)
    {
        return (this.field_70180_af.func_75679_c(16) & p_110233_1_) != 0;
    }

    private void func_110208_b(int p_110208_1_, boolean p_110208_2_)
    {
        int j = this.field_70180_af.func_75679_c(16);

        if (p_110208_2_)
        {
            this.field_70180_af.func_75692_b(16, Integer.valueOf(j | p_110208_1_));
        }
        else
        {
            this.field_70180_af.func_75692_b(16, Integer.valueOf(j & ~p_110208_1_));
        }
    }

    public boolean func_110228_bR()
    {
        return !this.func_70631_g_();
    }

    public boolean func_110248_bS()
    {
        return this.func_110233_w(2);
    }

    public boolean func_110253_bW()
    {
        return this.func_110228_bR();
    }

    public String func_142019_cb()
    {
        return this.field_70180_af.func_75681_e(21);
    }

    public void func_110213_b(String p_110213_1_)
    {
        this.field_70180_af.func_75692_b(21, p_110213_1_);
    }

    public float func_110254_bY()
    {
        int i = this.func_70874_b();
        return i >= 0 ? 1.0F : 0.5F + (float)(-24000 - i) / -24000.0F * 0.5F;
    }

    public void func_98054_a(boolean p_98054_1_)
    {
        if (p_98054_1_)
        {
            this.func_98055_j(this.func_110254_bY());
        }
        else
        {
            this.func_98055_j(1.0F);
        }
    }

    public boolean func_110246_bZ()
    {
        return this.field_110275_br;
    }

    public void func_110234_j(boolean p_110234_1_)
    {
        this.func_110208_b(2, p_110234_1_);
    }

    public void func_110255_k(boolean p_110255_1_)
    {
        this.field_110275_br = p_110255_1_;
    }

    public boolean func_110164_bC()
    {
        return !this.func_110256_cu() && super.func_110164_bC();
    }

    protected void func_142017_o(float p_142017_1_)
    {
        if (p_142017_1_ > 6.0F && this.func_110204_cc())
        {
            this.func_110227_p(false);
        }
    }

    public boolean func_110261_ca()
    {
        return this.func_110233_w(8);
    }

    public int func_110241_cb()
    {
        return this.field_70180_af.func_75679_c(22);
    }

    public int func_110260_d(ItemStack p_110260_1_)
    {
        return p_110260_1_ == null ? 0 : (p_110260_1_.field_77993_c == Item.field_111215_ce.field_77779_bT ? 1 : (p_110260_1_.field_77993_c == Item.field_111216_cf.field_77779_bT ? 2 : (p_110260_1_.field_77993_c == Item.field_111213_cg.field_77779_bT ? 3 : 0)));
    }

    public boolean func_110204_cc()
    {
        return this.func_110233_w(32);
    }

    public boolean func_110209_cd()
    {
        return this.func_110233_w(64);
    }

    public boolean func_110205_ce()
    {
        return this.func_110233_w(16);
    }

    public boolean func_110243_cf()
    {
        return this.field_110293_bH;
    }

    public void func_110236_r(int p_110236_1_)
    {
        this.field_70180_af.func_75692_b(22, Integer.valueOf(p_110236_1_));
        this.func_110230_cF();
    }

    public void func_110242_l(boolean p_110242_1_)
    {
        this.func_110208_b(16, p_110242_1_);
    }

    public void func_110207_m(boolean p_110207_1_)
    {
        this.func_110208_b(8, p_110207_1_);
    }

    public void func_110221_n(boolean p_110221_1_)
    {
        this.field_110293_bH = p_110221_1_;
    }

    public void func_110251_o(boolean p_110251_1_)
    {
        this.func_110208_b(4, p_110251_1_);
    }

    public int func_110252_cg()
    {
        return this.field_110274_bs;
    }

    public void func_110238_s(int p_110238_1_)
    {
        this.field_110274_bs = p_110238_1_;
    }

    public int func_110198_t(int p_110198_1_)
    {
        int j = MathHelper.func_76125_a(this.func_110252_cg() + p_110198_1_, 0, this.func_110218_cm());
        this.func_110238_s(j);
        return j;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_)
    {
        Entity entity = p_70097_1_.func_76346_g();
        return this.field_70153_n != null && this.field_70153_n.equals(entity) ? false : super.func_70097_a(p_70097_1_, p_70097_2_);
    }

    public int func_70658_aO()
    {
        return field_110272_by[this.func_110241_cb()];
    }

    public boolean func_70104_M()
    {
        return this.field_70153_n == null;
    }

    public boolean func_110262_ch()
    {
        int i = MathHelper.func_76128_c(this.field_70165_t);
        int j = MathHelper.func_76128_c(this.field_70161_v);
        this.field_70170_p.func_72807_a(i, j);
        return true;
    }

    public void func_110224_ci()
    {
        if (!this.field_70170_p.field_72995_K && this.func_110261_ca())
        {
            this.func_70025_b(Block.field_72077_au.field_71990_ca, 1);
            this.func_110207_m(false);
        }
    }

    private void func_110266_cB()
    {
        this.func_110249_cI();
        this.field_70170_p.func_72956_a(this, "eating", 1.0F, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F);
    }

    protected void func_70069_a(float p_70069_1_)
    {
        if (p_70069_1_ > 1.0F)
        {
            this.func_85030_a("mob.horse.land", 0.4F, 1.0F);
        }

        int i = MathHelper.func_76123_f(p_70069_1_ * 0.5F - 3.0F);

        if (i > 0)
        {
            this.func_70097_a(DamageSource.field_76379_h, (float)i);

            if (this.field_70153_n != null)
            {
                this.field_70153_n.func_70097_a(DamageSource.field_76379_h, (float)i);
            }

            int j = this.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u - 0.2D - (double)this.field_70126_B), MathHelper.func_76128_c(this.field_70161_v));

            if (j > 0)
            {
                StepSound stepsound = Block.field_71973_m[j].field_72020_cn;
                this.field_70170_p.func_72956_a(this, stepsound.func_72675_d(), stepsound.func_72677_b() * 0.5F, stepsound.func_72678_c() * 0.75F);
            }
        }
    }

    private int func_110225_cC()
    {
        int i = this.func_110265_bP();
        return this.func_110261_ca() && (i == 1 || i == 2) ? 17 : 2;
    }

    private void func_110226_cD()
    {
        AnimalChest animalchest = this.field_110296_bG;
        this.field_110296_bG = new AnimalChest("HorseChest", this.func_110225_cC());
        this.field_110296_bG.func_110133_a(this.func_70023_ak());

        if (animalchest != null)
        {
            animalchest.func_110132_b(this);
            int i = Math.min(animalchest.func_70302_i_(), this.field_110296_bG.func_70302_i_());

            for (int j = 0; j < i; ++j)
            {
                ItemStack itemstack = animalchest.func_70301_a(j);

                if (itemstack != null)
                {
                    this.field_110296_bG.func_70299_a(j, itemstack.func_77946_l());
                }
            }

            animalchest = null;
        }

        this.field_110296_bG.func_110134_a(this);
        this.func_110232_cE();
    }

    private void func_110232_cE()
    {
        if (!this.field_70170_p.field_72995_K)
        {
            this.func_110251_o(this.field_110296_bG.func_70301_a(0) != null);

            if (this.func_110259_cr())
            {
                this.func_110236_r(this.func_110260_d(this.field_110296_bG.func_70301_a(1)));
            }
        }
    }

    public void func_76316_a(InventoryBasic p_76316_1_)
    {
        int i = this.func_110241_cb();
        boolean flag = this.func_110257_ck();
        this.func_110232_cE();

        if (this.field_70173_aa > 20)
        {
            if (i == 0 && i != this.func_110241_cb())
            {
                this.func_85030_a("mob.horse.armor", 0.5F, 1.0F);
            }

            if (!flag && this.func_110257_ck())
            {
                this.func_85030_a("mob.horse.leather", 0.5F, 1.0F);
            }
        }
    }

    public boolean func_70601_bi()
    {
        this.func_110262_ch();
        return super.func_70601_bi();
    }

    protected EntityHorse func_110250_a(Entity p_110250_1_, double p_110250_2_)
    {
        double d1 = Double.MAX_VALUE;
        Entity entity1 = null;
        List list = this.field_70170_p.func_94576_a(p_110250_1_, p_110250_1_.field_70121_D.func_72321_a(p_110250_2_, p_110250_2_, p_110250_2_), field_110276_bu);
        Iterator iterator = list.iterator();

        while (iterator.hasNext())
        {
            Entity entity2 = (Entity)iterator.next();
            double d2 = entity2.func_70092_e(p_110250_1_.field_70165_t, p_110250_1_.field_70163_u, p_110250_1_.field_70161_v);

            if (d2 < d1)
            {
                entity1 = entity2;
                d1 = d2;
            }
        }

        return (EntityHorse)entity1;
    }

    public double func_110215_cj()
    {
        return this.func_110148_a(field_110271_bv).func_111126_e();
    }

    protected String func_70673_aS()
    {
        this.func_110249_cI();
        int i = this.func_110265_bP();
        return i == 3 ? "mob.horse.zombie.death" : (i == 4 ? "mob.horse.skeleton.death" : (i != 1 && i != 2 ? "mob.horse.death" : "mob.horse.donkey.death"));
    }

    protected int func_70633_aT()
    {
        boolean flag = this.field_70146_Z.nextInt(4) == 0;
        int i = this.func_110265_bP();
        return i == 4 ? Item.field_77755_aX.field_77779_bT : (i == 3 ? (flag ? 0 : Item.field_77737_bm.field_77779_bT) : Item.field_77770_aF.field_77779_bT);
    }

    protected String func_70621_aR()
    {
        this.func_110249_cI();

        if (this.field_70146_Z.nextInt(3) == 0)
        {
            this.func_110220_cK();
        }

        int i = this.func_110265_bP();
        return i == 3 ? "mob.horse.zombie.hit" : (i == 4 ? "mob.horse.skeleton.hit" : (i != 1 && i != 2 ? "mob.horse.hit" : "mob.horse.donkey.hit"));
    }

    public boolean func_110257_ck()
    {
        return this.func_110233_w(4);
    }

    protected String func_70639_aQ()
    {
        this.func_110249_cI();

        if (this.field_70146_Z.nextInt(10) == 0 && !this.func_70610_aX())
        {
            this.func_110220_cK();
        }

        int i = this.func_110265_bP();
        return i == 3 ? "mob.horse.zombie.idle" : (i == 4 ? "mob.horse.skeleton.idle" : (i != 1 && i != 2 ? "mob.horse.idle" : "mob.horse.donkey.idle"));
    }

    protected String func_110217_cl()
    {
        this.func_110249_cI();
        this.func_110220_cK();
        int i = this.func_110265_bP();
        return i != 3 && i != 4 ? (i != 1 && i != 2 ? "mob.horse.angry" : "mob.horse.donkey.angry") : null;
    }

    protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_)
    {
        StepSound stepsound = Block.field_71973_m[p_70036_4_].field_72020_cn;

        if (this.field_70170_p.func_72798_a(p_70036_1_, p_70036_2_ + 1, p_70036_3_) == Block.field_72037_aS.field_71990_ca)
        {
            stepsound = Block.field_72037_aS.field_72020_cn;
        }

        if (!Block.field_71973_m[p_70036_4_].field_72018_cp.func_76224_d())
        {
            int i1 = this.func_110265_bP();

            if (this.field_70153_n != null && i1 != 1 && i1 != 2)
            {
                ++this.field_110285_bP;

                if (this.field_110285_bP > 5 && this.field_110285_bP % 3 == 0)
                {
                    this.func_85030_a("mob.horse.gallop", stepsound.func_72677_b() * 0.15F, stepsound.func_72678_c());

                    if (i1 == 0 && this.field_70146_Z.nextInt(10) == 0)
                    {
                        this.func_85030_a("mob.horse.breathe", stepsound.func_72677_b() * 0.6F, stepsound.func_72678_c());
                    }
                }
                else if (this.field_110285_bP <= 5)
                {
                    this.func_85030_a("mob.horse.wood", stepsound.func_72677_b() * 0.15F, stepsound.func_72678_c());
                }
            }
            else if (stepsound == Block.field_71967_e)
            {
                this.func_85030_a("mob.horse.soft", stepsound.func_72677_b() * 0.15F, stepsound.func_72678_c());
            }
            else
            {
                this.func_85030_a("mob.horse.wood", stepsound.func_72677_b() * 0.15F, stepsound.func_72678_c());
            }
        }
    }

    protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110140_aT().func_111150_b(field_110271_bv);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(53.0D);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.22499999403953552D);
    }

    public int func_70641_bl()
    {
        return 6;
    }

    public int func_110218_cm()
    {
        return 100;
    }

    protected float func_70599_aP()
    {
        return 0.8F;
    }

    public int func_70627_aG()
    {
        return 400;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_110239_cn()
    {
        return this.func_110265_bP() == 0 || this.func_110241_cb() > 0;
    }

    private void func_110230_cF()
    {
        this.field_110286_bQ = null;
    }

    @SideOnly(Side.CLIENT)
    private void func_110247_cG()
    {
        this.field_110286_bQ = "horse/";
        this.field_110280_bR[0] = null;
        this.field_110280_bR[1] = null;
        this.field_110280_bR[2] = null;
        int i = this.func_110265_bP();
        int j = this.func_110202_bQ();
        int k;

        if (i == 0)
        {
            k = j & 255;
            int l = (j & 65280) >> 8;
            this.field_110280_bR[0] = field_110268_bz[k];
            this.field_110286_bQ = this.field_110286_bQ + field_110269_bA[k];
            this.field_110280_bR[1] = field_110291_bB[l];
            this.field_110286_bQ = this.field_110286_bQ + field_110292_bC[l];
        }
        else
        {
            this.field_110280_bR[0] = "";
            this.field_110286_bQ = this.field_110286_bQ + "_" + i + "_";
        }

        k = this.func_110241_cb();
        this.field_110280_bR[2] = field_110270_bw[k];
        this.field_110286_bQ = this.field_110286_bQ + field_110273_bx[k];
    }

    @SideOnly(Side.CLIENT)
    public String func_110264_co()
    {
        if (this.field_110286_bQ == null)
        {
            this.func_110247_cG();
        }

        return this.field_110286_bQ;
    }

    @SideOnly(Side.CLIENT)
    public String[] func_110212_cp()
    {
        if (this.field_110286_bQ == null)
        {
            this.func_110247_cG();
        }

        return this.field_110280_bR;
    }

    public void func_110199_f(EntityPlayer p_110199_1_)
    {
        if (!this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n == p_110199_1_) && this.func_110248_bS())
        {
            this.field_110296_bG.func_110133_a(this.func_70023_ak());
            p_110199_1_.func_110298_a(this, this.field_110296_bG);
        }
    }

    public boolean func_70085_c(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.field_71071_by.func_70448_g();

        if (itemstack != null && itemstack.field_77993_c == Item.field_77815_bC.field_77779_bT)
        {
            return super.func_70085_c(p_70085_1_);
        }
        else if (!this.func_110248_bS() && this.func_110256_cu())
        {
            return false;
        }
        else if (this.func_110248_bS() && this.func_110228_bR() && p_70085_1_.func_70093_af())
        {
            this.func_110199_f(p_70085_1_);
            return true;
        }
        else if (this.func_110253_bW() && this.field_70153_n != null)
        {
            return super.func_70085_c(p_70085_1_);
        }
        else
        {
            if (itemstack != null)
            {
                boolean flag = false;

                if (this.func_110259_cr())
                {
                    byte b0 = -1;

                    if (itemstack.field_77993_c == Item.field_111215_ce.field_77779_bT)
                    {
                        b0 = 1;
                    }
                    else if (itemstack.field_77993_c == Item.field_111216_cf.field_77779_bT)
                    {
                        b0 = 2;
                    }
                    else if (itemstack.field_77993_c == Item.field_111213_cg.field_77779_bT)
                    {
                        b0 = 3;
                    }

                    if (b0 >= 0)
                    {
                        if (!this.func_110248_bS())
                        {
                            this.func_110231_cz();
                            return true;
                        }

                        this.func_110199_f(p_70085_1_);
                        return true;
                    }
                }

                if (!flag && !this.func_110256_cu())
                {
                    float f = 0.0F;
                    short short1 = 0;
                    byte b1 = 0;

                    if (itemstack.field_77993_c == Item.field_77685_T.field_77779_bT)
                    {
                        f = 2.0F;
                        short1 = 60;
                        b1 = 3;
                    }
                    else if (itemstack.field_77993_c == Item.field_77747_aY.field_77779_bT)
                    {
                        f = 1.0F;
                        short1 = 30;
                        b1 = 3;
                    }
                    else if (itemstack.field_77993_c == Item.field_77684_U.field_77779_bT)
                    {
                        f = 7.0F;
                        short1 = 180;
                        b1 = 3;
                    }
                    else if (itemstack.field_77993_c == Block.field_111038_cB.field_71990_ca)
                    {
                        f = 20.0F;
                        short1 = 180;
                    }
                    else if (itemstack.field_77993_c == Item.field_77706_j.field_77779_bT)
                    {
                        f = 3.0F;
                        short1 = 60;
                        b1 = 3;
                    }
                    else if (itemstack.field_77993_c == Item.field_82798_bP.field_77779_bT)
                    {
                        f = 4.0F;
                        short1 = 60;
                        b1 = 5;

                        if (this.func_110248_bS() && this.func_70874_b() == 0)
                        {
                            flag = true;
                            this.func_110196_bT();
                        }
                    }
                    else if (itemstack.field_77993_c == Item.field_77778_at.field_77779_bT)
                    {
                        f = 10.0F;
                        short1 = 240;
                        b1 = 10;

                        if (this.func_110248_bS() && this.func_70874_b() == 0)
                        {
                            flag = true;
                            this.func_110196_bT();
                        }
                    }

                    if (this.func_110143_aJ() < this.func_110138_aP() && f > 0.0F)
                    {
                        this.func_70691_i(f);
                        flag = true;
                    }

                    if (!this.func_110228_bR() && short1 > 0)
                    {
                        this.func_110195_a(short1);
                        flag = true;
                    }

                    if (b1 > 0 && (flag || !this.func_110248_bS()) && b1 < this.func_110218_cm())
                    {
                        flag = true;
                        this.func_110198_t(b1);
                    }

                    if (flag)
                    {
                        this.func_110266_cB();
                    }
                }

                if (!this.func_110248_bS() && !flag)
                {
                    if (itemstack != null && itemstack.func_111282_a(p_70085_1_, this))
                    {
                        return true;
                    }

                    this.func_110231_cz();
                    return true;
                }

                if (!flag && this.func_110229_cs() && !this.func_110261_ca() && itemstack.field_77993_c == Block.field_72077_au.field_71990_ca)
                {
                    this.func_110207_m(true);
                    this.func_85030_a("mob.chickenplop", 1.0F, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
                    flag = true;
                    this.func_110226_cD();
                }

                if (!flag && this.func_110253_bW() && !this.func_110257_ck() && itemstack.field_77993_c == Item.field_77765_aA.field_77779_bT)
                {
                    this.func_110199_f(p_70085_1_);
                    return true;
                }

                if (flag)
                {
                    if (!p_70085_1_.field_71075_bZ.field_75098_d && --itemstack.field_77994_a == 0)
                    {
                        p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, (ItemStack)null);
                    }

                    return true;
                }
            }

            if (this.func_110253_bW() && this.field_70153_n == null)
            {
                if (itemstack != null && itemstack.func_111282_a(p_70085_1_, this))
                {
                    return true;
                }
                else
                {
                    this.func_110237_h(p_70085_1_);
                    return true;
                }
            }
            else
            {
                return super.func_70085_c(p_70085_1_);
            }
        }
    }

    private void func_110237_h(EntityPlayer p_110237_1_)
    {
        p_110237_1_.field_70177_z = this.field_70177_z;
        p_110237_1_.field_70125_A = this.field_70125_A;
        this.func_110227_p(false);
        this.func_110219_q(false);

        if (!this.field_70170_p.field_72995_K)
        {
            p_110237_1_.func_70078_a(this);
        }
    }

    public boolean func_110259_cr()
    {
        return this.func_110265_bP() == 0;
    }

    public boolean func_110229_cs()
    {
        int i = this.func_110265_bP();
        return i == 2 || i == 1;
    }

    protected boolean func_70610_aX()
    {
        return this.field_70153_n != null && this.func_110257_ck() ? true : this.func_110204_cc() || this.func_110209_cd();
    }

    public boolean func_110256_cu()
    {
        int i = this.func_110265_bP();
        return i == 3 || i == 4;
    }

    public boolean func_110222_cv()
    {
        return this.func_110256_cu() || this.func_110265_bP() == 2;
    }

    public boolean func_70877_b(ItemStack p_70877_1_)
    {
        return false;
    }

    private void func_110210_cH()
    {
        this.field_110278_bp = 1;
    }

    public void func_70645_a(DamageSource p_70645_1_)
    {
        super.func_70645_a(p_70645_1_);

        if (!this.field_70170_p.field_72995_K)
        {
            this.func_110244_cA();
        }
    }

    public void func_70636_d()
    {
        if (this.field_70146_Z.nextInt(200) == 0)
        {
            this.func_110210_cH();
        }

        super.func_70636_d();

        if (!this.field_70170_p.field_72995_K)
        {
            if (this.field_70146_Z.nextInt(900) == 0 && this.field_70725_aQ == 0)
            {
                this.func_70691_i(1.0F);
            }

            if (!this.func_110204_cc() && this.field_70153_n == null && this.field_70146_Z.nextInt(300) == 0 && this.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u) - 1, MathHelper.func_76128_c(this.field_70161_v)) == Block.field_71980_u.field_71990_ca)
            {
                this.func_110227_p(true);
            }

            if (this.func_110204_cc() && ++this.field_110289_bD > 50)
            {
                this.field_110289_bD = 0;
                this.func_110227_p(false);
            }

            if (this.func_110205_ce() && !this.func_110228_bR() && !this.func_110204_cc())
            {
                EntityHorse entityhorse = this.func_110250_a(this, 16.0D);

                if (entityhorse != null && this.func_70068_e(entityhorse) > 4.0D)
                {
                    PathEntity pathentity = this.field_70170_p.func_72865_a(this, entityhorse, 16.0F, true, false, false, true);
                    this.func_70778_a(pathentity);
                }
            }
        }
    }

    public void func_70071_h_()
    {
        super.func_70071_h_();

        if (this.field_70170_p.field_72995_K && this.field_70180_af.func_75684_a())
        {
            this.field_70180_af.func_111144_e();
            this.func_110230_cF();
        }

        if (this.field_110290_bE > 0 && ++this.field_110290_bE > 30)
        {
            this.field_110290_bE = 0;
            this.func_110208_b(128, false);
        }

        if (!this.field_70170_p.field_72995_K && this.field_110295_bF > 0 && ++this.field_110295_bF > 20)
        {
            this.field_110295_bF = 0;
            this.func_110219_q(false);
        }

        if (this.field_110278_bp > 0 && ++this.field_110278_bp > 8)
        {
            this.field_110278_bp = 0;
        }

        if (this.field_110279_bq > 0)
        {
            ++this.field_110279_bq;

            if (this.field_110279_bq > 300)
            {
                this.field_110279_bq = 0;
            }
        }

        this.field_110284_bK = this.field_110283_bJ;

        if (this.func_110204_cc())
        {
            this.field_110283_bJ += (1.0F - this.field_110283_bJ) * 0.4F + 0.05F;

            if (this.field_110283_bJ > 1.0F)
            {
                this.field_110283_bJ = 1.0F;
            }
        }
        else
        {
            this.field_110283_bJ += (0.0F - this.field_110283_bJ) * 0.4F - 0.05F;

            if (this.field_110283_bJ < 0.0F)
            {
                this.field_110283_bJ = 0.0F;
            }
        }

        this.field_110282_bM = this.field_110281_bL;

        if (this.func_110209_cd())
        {
            this.field_110284_bK = this.field_110283_bJ = 0.0F;
            this.field_110281_bL += (1.0F - this.field_110281_bL) * 0.4F + 0.05F;

            if (this.field_110281_bL > 1.0F)
            {
                this.field_110281_bL = 1.0F;
            }
        }
        else
        {
            this.field_110294_bI = false;
            this.field_110281_bL += (0.8F * this.field_110281_bL * this.field_110281_bL * this.field_110281_bL - this.field_110281_bL) * 0.6F - 0.05F;

            if (this.field_110281_bL < 0.0F)
            {
                this.field_110281_bL = 0.0F;
            }
        }

        this.field_110288_bO = this.field_110287_bN;

        if (this.func_110233_w(128))
        {
            this.field_110287_bN += (1.0F - this.field_110287_bN) * 0.7F + 0.05F;

            if (this.field_110287_bN > 1.0F)
            {
                this.field_110287_bN = 1.0F;
            }
        }
        else
        {
            this.field_110287_bN += (0.0F - this.field_110287_bN) * 0.7F - 0.05F;

            if (this.field_110287_bN < 0.0F)
            {
                this.field_110287_bN = 0.0F;
            }
        }
    }

    private void func_110249_cI()
    {
        if (!this.field_70170_p.field_72995_K)
        {
            this.field_110290_bE = 1;
            this.func_110208_b(128, true);
        }
    }

    private boolean func_110200_cJ()
    {
        return this.field_70153_n == null && this.field_70154_o == null && this.func_110248_bS() && this.func_110228_bR() && !this.func_110222_cv() && this.func_110143_aJ() >= this.func_110138_aP();
    }

    public void func_70019_c(boolean p_70019_1_)
    {
        this.func_110208_b(32, p_70019_1_);
    }

    public void func_110227_p(boolean p_110227_1_)
    {
        this.func_70019_c(p_110227_1_);
    }

    public void func_110219_q(boolean p_110219_1_)
    {
        if (p_110219_1_)
        {
            this.func_110227_p(false);
        }

        this.func_110208_b(64, p_110219_1_);
    }

    private void func_110220_cK()
    {
        if (!this.field_70170_p.field_72995_K)
        {
            this.field_110295_bF = 1;
            this.func_110219_q(true);
        }
    }

    public void func_110231_cz()
    {
        this.func_110220_cK();
        String s = this.func_110217_cl();

        if (s != null)
        {
            this.func_85030_a(s, this.func_70599_aP(), this.func_70647_i());
        }
    }

    public void func_110244_cA()
    {
        this.func_110240_a(this, this.field_110296_bG);
        this.func_110224_ci();
    }

    private void func_110240_a(Entity p_110240_1_, AnimalChest p_110240_2_)
    {
        if (p_110240_2_ != null && !this.field_70170_p.field_72995_K)
        {
            for (int i = 0; i < p_110240_2_.func_70302_i_(); ++i)
            {
                ItemStack itemstack = p_110240_2_.func_70301_a(i);

                if (itemstack != null)
                {
                    this.func_70099_a(itemstack, 0.0F);
                }
            }
        }
    }

    public boolean func_110263_g(EntityPlayer p_110263_1_)
    {
        this.func_110213_b(p_110263_1_.func_70005_c_());
        this.func_110234_j(true);
        return true;
    }

    public void func_70612_e(float p_70612_1_, float p_70612_2_)
    {
        if (this.field_70153_n != null && this.func_110257_ck())
        {
            this.field_70126_B = this.field_70177_z = this.field_70153_n.field_70177_z;
            this.field_70125_A = this.field_70153_n.field_70125_A * 0.5F;
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
            this.field_70759_as = this.field_70761_aq = this.field_70177_z;
            p_70612_1_ = ((EntityLivingBase)this.field_70153_n).field_70702_br * 0.5F;
            p_70612_2_ = ((EntityLivingBase)this.field_70153_n).field_70701_bs;

            if (p_70612_2_ <= 0.0F)
            {
                p_70612_2_ *= 0.25F;
                this.field_110285_bP = 0;
            }

            if (this.field_70122_E && this.field_110277_bt == 0.0F && this.func_110209_cd() && !this.field_110294_bI)
            {
                p_70612_1_ = 0.0F;
                p_70612_2_ = 0.0F;
            }

            if (this.field_110277_bt > 0.0F && !this.func_110246_bZ() && this.field_70122_E)
            {
                this.field_70181_x = this.func_110215_cj() * (double)this.field_110277_bt;

                if (this.func_70644_a(Potion.field_76430_j))
                {
                    this.field_70181_x += (double)((float)(this.func_70660_b(Potion.field_76430_j).func_76458_c() + 1) * 0.1F);
                }

                this.func_110255_k(true);
                this.field_70160_al = true;

                if (p_70612_2_ > 0.0F)
                {
                    float f2 = MathHelper.func_76126_a(this.field_70177_z * (float)Math.PI / 180.0F);
                    float f3 = MathHelper.func_76134_b(this.field_70177_z * (float)Math.PI / 180.0F);
                    this.field_70159_w += (double)(-0.4F * f2 * this.field_110277_bt);
                    this.field_70179_y += (double)(0.4F * f3 * this.field_110277_bt);
                    this.func_85030_a("mob.horse.jump", 0.4F, 1.0F);
                }

                this.field_110277_bt = 0.0F;
            }

            this.field_70138_W = 1.0F;
            this.field_70747_aH = this.func_70689_ay() * 0.1F;

            if (!this.field_70170_p.field_72995_K)
            {
                this.func_70659_e((float)this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e());
                super.func_70612_e(p_70612_1_, p_70612_2_);
            }

            if (this.field_70122_E)
            {
                this.field_110277_bt = 0.0F;
                this.func_110255_k(false);
            }

            this.field_70722_aY = this.field_70721_aZ;
            double d0 = this.field_70165_t - this.field_70169_q;
            double d1 = this.field_70161_v - this.field_70166_s;
            float f4 = MathHelper.func_76133_a(d0 * d0 + d1 * d1) * 4.0F;

            if (f4 > 1.0F)
            {
                f4 = 1.0F;
            }

            this.field_70721_aZ += (f4 - this.field_70721_aZ) * 0.4F;
            this.field_70754_ba += this.field_70721_aZ;
        }
        else
        {
            this.field_70138_W = 0.5F;
            this.field_70747_aH = 0.02F;
            super.func_70612_e(p_70612_1_, p_70612_2_);
        }
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74757_a("EatingHaystack", this.func_110204_cc());
        p_70014_1_.func_74757_a("ChestedHorse", this.func_110261_ca());
        p_70014_1_.func_74757_a("HasReproduced", this.func_110243_cf());
        p_70014_1_.func_74757_a("Bred", this.func_110205_ce());
        p_70014_1_.func_74768_a("Type", this.func_110265_bP());
        p_70014_1_.func_74768_a("Variant", this.func_110202_bQ());
        p_70014_1_.func_74768_a("Temper", this.func_110252_cg());
        p_70014_1_.func_74757_a("Tame", this.func_110248_bS());
        p_70014_1_.func_74778_a("OwnerName", this.func_142019_cb());

        if (this.func_110261_ca())
        {
            NBTTagList nbttaglist = new NBTTagList();

            for (int i = 2; i < this.field_110296_bG.func_70302_i_(); ++i)
            {
                ItemStack itemstack = this.field_110296_bG.func_70301_a(i);

                if (itemstack != null)
                {
                    NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                    nbttagcompound1.func_74774_a("Slot", (byte)i);
                    itemstack.func_77955_b(nbttagcompound1);
                    nbttaglist.func_74742_a(nbttagcompound1);
                }
            }

            p_70014_1_.func_74782_a("Items", nbttaglist);
        }

        if (this.field_110296_bG.func_70301_a(1) != null)
        {
            p_70014_1_.func_74782_a("ArmorItem", this.field_110296_bG.func_70301_a(1).func_77955_b(new NBTTagCompound("ArmorItem")));
        }

        if (this.field_110296_bG.func_70301_a(0) != null)
        {
            p_70014_1_.func_74782_a("SaddleItem", this.field_110296_bG.func_70301_a(0).func_77955_b(new NBTTagCompound("SaddleItem")));
        }
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        super.func_70037_a(p_70037_1_);
        this.func_110227_p(p_70037_1_.func_74767_n("EatingHaystack"));
        this.func_110242_l(p_70037_1_.func_74767_n("Bred"));
        this.func_110207_m(p_70037_1_.func_74767_n("ChestedHorse"));
        this.func_110221_n(p_70037_1_.func_74767_n("HasReproduced"));
        this.func_110214_p(p_70037_1_.func_74762_e("Type"));
        this.func_110235_q(p_70037_1_.func_74762_e("Variant"));
        this.func_110238_s(p_70037_1_.func_74762_e("Temper"));
        this.func_110234_j(p_70037_1_.func_74767_n("Tame"));

        if (p_70037_1_.func_74764_b("OwnerName"))
        {
            this.func_110213_b(p_70037_1_.func_74779_i("OwnerName"));
        }

        AttributeInstance attributeinstance = this.func_110140_aT().func_111152_a("Speed");

        if (attributeinstance != null)
        {
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(attributeinstance.func_111125_b() * 0.25D);
        }

        if (this.func_110261_ca())
        {
            NBTTagList nbttaglist = p_70037_1_.func_74761_m("Items");
            this.func_110226_cD();

            for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
            {
                NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_74743_b(i);
                int j = nbttagcompound1.func_74771_c("Slot") & 255;

                if (j >= 2 && j < this.field_110296_bG.func_70302_i_())
                {
                    this.field_110296_bG.func_70299_a(j, ItemStack.func_77949_a(nbttagcompound1));
                }
            }
        }

        ItemStack itemstack;

        if (p_70037_1_.func_74764_b("ArmorItem"))
        {
            itemstack = ItemStack.func_77949_a(p_70037_1_.func_74775_l("ArmorItem"));

            if (itemstack != null && func_110211_v(itemstack.field_77993_c))
            {
                this.field_110296_bG.func_70299_a(1, itemstack);
            }
        }

        if (p_70037_1_.func_74764_b("SaddleItem"))
        {
            itemstack = ItemStack.func_77949_a(p_70037_1_.func_74775_l("SaddleItem"));

            if (itemstack != null && itemstack.field_77993_c == Item.field_77765_aA.field_77779_bT)
            {
                this.field_110296_bG.func_70299_a(0, itemstack);
            }
        }
        else if (p_70037_1_.func_74767_n("Saddle"))
        {
            this.field_110296_bG.func_70299_a(0, new ItemStack(Item.field_77765_aA));
        }

        this.func_110232_cE();
    }

    public boolean func_70878_b(EntityAnimal p_70878_1_)
    {
        if (p_70878_1_ == this)
        {
            return false;
        }
        else if (p_70878_1_.getClass() != this.getClass())
        {
            return false;
        }
        else
        {
            EntityHorse entityhorse = (EntityHorse)p_70878_1_;

            if (this.func_110200_cJ() && entityhorse.func_110200_cJ())
            {
                int i = this.func_110265_bP();
                int j = entityhorse.func_110265_bP();
                return i == j || i == 0 && j == 1 || i == 1 && j == 0;
            }
            else
            {
                return false;
            }
        }
    }

    public EntityAgeable func_90011_a(EntityAgeable p_90011_1_)
    {
        EntityHorse entityhorse = (EntityHorse)p_90011_1_;
        EntityHorse entityhorse1 = new EntityHorse(this.field_70170_p);
        int i = this.func_110265_bP();
        int j = entityhorse.func_110265_bP();
        int k = 0;

        if (i == j)
        {
            k = i;
        }
        else if (i == 0 && j == 1 || i == 1 && j == 0)
        {
            k = 2;
        }

        if (k == 0)
        {
            int l = this.field_70146_Z.nextInt(9);
            int i1;

            if (l < 4)
            {
                i1 = this.func_110202_bQ() & 255;
            }
            else if (l < 8)
            {
                i1 = entityhorse.func_110202_bQ() & 255;
            }
            else
            {
                i1 = this.field_70146_Z.nextInt(7);
            }

            int j1 = this.field_70146_Z.nextInt(5);

            if (j1 < 4)
            {
                i1 |= this.func_110202_bQ() & 65280;
            }
            else if (j1 < 8)
            {
                i1 |= entityhorse.func_110202_bQ() & 65280;
            }
            else
            {
                i1 |= this.field_70146_Z.nextInt(5) << 8 & 65280;
            }

            entityhorse1.func_110235_q(i1);
        }

        entityhorse1.func_110214_p(k);
        double d0 = this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() + p_90011_1_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() + (double)this.func_110267_cL();
        entityhorse1.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(d0 / 3.0D);
        double d1 = this.func_110148_a(field_110271_bv).func_111125_b() + p_90011_1_.func_110148_a(field_110271_bv).func_111125_b() + this.func_110245_cM();
        entityhorse1.func_110148_a(field_110271_bv).func_111128_a(d1 / 3.0D);
        double d2 = this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b() + p_90011_1_.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b() + this.func_110203_cN();
        entityhorse1.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(d2 / 3.0D);
        return entityhorse1;
    }

    public EntityLivingData func_110161_a(EntityLivingData p_110161_1_)
    {
        Object p_110161_1_1 = super.func_110161_a(p_110161_1_);
        boolean flag = false;
        int i = 0;
        int j;

        if (p_110161_1_1 instanceof EntityHorseGroupData)
        {
            j = ((EntityHorseGroupData)p_110161_1_1).field_111107_a;
            i = ((EntityHorseGroupData)p_110161_1_1).field_111106_b & 255 | this.field_70146_Z.nextInt(5) << 8;
        }
        else
        {
            if (this.field_70146_Z.nextInt(10) == 0)
            {
                j = 1;
            }
            else
            {
                int k = this.field_70146_Z.nextInt(7);
                int l = this.field_70146_Z.nextInt(5);
                j = 0;
                i = k | l << 8;
            }

            p_110161_1_1 = new EntityHorseGroupData(j, i);
        }

        this.func_110214_p(j);
        this.func_110235_q(i);

        if (this.field_70146_Z.nextInt(5) == 0)
        {
            this.func_70873_a(-24000);
        }

        if (j != 4 && j != 3)
        {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.func_110267_cL());

            if (j == 0)
            {
                this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.func_110203_cN());
            }
            else
            {
                this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.17499999701976776D);
            }
        }
        else
        {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15.0D);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000000298023224D);
        }

        if (j != 2 && j != 1)
        {
            this.func_110148_a(field_110271_bv).func_111128_a(this.func_110245_cM());
        }
        else
        {
            this.func_110148_a(field_110271_bv).func_111128_a(0.5D);
        }

        this.func_70606_j(this.func_110138_aP());
        return (EntityLivingData)p_110161_1_1;
    }

    @SideOnly(Side.CLIENT)
    public float func_110258_o(float p_110258_1_)
    {
        return this.field_110284_bK + (this.field_110283_bJ - this.field_110284_bK) * p_110258_1_;
    }

    @SideOnly(Side.CLIENT)
    public float func_110223_p(float p_110223_1_)
    {
        return this.field_110282_bM + (this.field_110281_bL - this.field_110282_bM) * p_110223_1_;
    }

    @SideOnly(Side.CLIENT)
    public float func_110201_q(float p_110201_1_)
    {
        return this.field_110288_bO + (this.field_110287_bN - this.field_110288_bO) * p_110201_1_;
    }

    protected boolean func_70650_aV()
    {
        return true;
    }

    public void func_110206_u(int p_110206_1_)
    {
        if (this.func_110257_ck())
        {
            if (p_110206_1_ < 0)
            {
                p_110206_1_ = 0;
            }
            else
            {
                this.field_110294_bI = true;
                this.func_110220_cK();
            }

            if (p_110206_1_ >= 90)
            {
                this.field_110277_bt = 1.0F;
            }
            else
            {
                this.field_110277_bt = 0.4F + 0.4F * (float)p_110206_1_ / 90.0F;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    protected void func_110216_r(boolean p_110216_1_)
    {
        String s = p_110216_1_ ? "heart" : "smoke";

        for (int i = 0; i < 7; ++i)
        {
            double d0 = this.field_70146_Z.nextGaussian() * 0.02D;
            double d1 = this.field_70146_Z.nextGaussian() * 0.02D;
            double d2 = this.field_70146_Z.nextGaussian() * 0.02D;
            this.field_70170_p.func_72869_a(s, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, this.field_70163_u + 0.5D + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, d0, d1, d2);
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_70103_a(byte p_70103_1_)
    {
        if (p_70103_1_ == 7)
        {
            this.func_110216_r(true);
        }
        else if (p_70103_1_ == 6)
        {
            this.func_110216_r(false);
        }
        else
        {
            super.func_70103_a(p_70103_1_);
        }
    }

    public void func_70043_V()
    {
        super.func_70043_V();

        if (this.field_110282_bM > 0.0F)
        {
            float f = MathHelper.func_76126_a(this.field_70761_aq * (float)Math.PI / 180.0F);
            float f1 = MathHelper.func_76134_b(this.field_70761_aq * (float)Math.PI / 180.0F);
            float f2 = 0.7F * this.field_110282_bM;
            float f3 = 0.15F * this.field_110282_bM;
            this.field_70153_n.func_70107_b(this.field_70165_t + (double)(f2 * f), this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W() + (double)f3, this.field_70161_v - (double)(f2 * f1));

            if (this.field_70153_n instanceof EntityLivingBase)
            {
                ((EntityLivingBase)this.field_70153_n).field_70761_aq = this.field_70761_aq;
            }
        }
    }

    private float func_110267_cL()
    {
        return 15.0F + (float)this.field_70146_Z.nextInt(8) + (float)this.field_70146_Z.nextInt(9);
    }

    private double func_110245_cM()
    {
        return 0.4000000059604645D + this.field_70146_Z.nextDouble() * 0.2D + this.field_70146_Z.nextDouble() * 0.2D + this.field_70146_Z.nextDouble() * 0.2D;
    }

    private double func_110203_cN()
    {
        return (0.44999998807907104D + this.field_70146_Z.nextDouble() * 0.3D + this.field_70146_Z.nextDouble() * 0.3D + this.field_70146_Z.nextDouble() * 0.3D) * 0.25D;
    }

    public static boolean func_110211_v(int p_110211_0_)
    {
        return p_110211_0_ == Item.field_111215_ce.field_77779_bT || p_110211_0_ == Item.field_111216_cf.field_77779_bT || p_110211_0_ == Item.field_111213_cg.field_77779_bT;
    }

    public boolean func_70617_f_()
    {
        return false;
    }
}