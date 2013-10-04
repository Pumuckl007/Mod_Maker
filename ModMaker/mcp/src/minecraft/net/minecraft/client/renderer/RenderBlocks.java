package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockComparator;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRedstoneLogic;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStem;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderBlocks
{
    public IBlockAccess field_78669_a;
    public Icon field_78664_d;
    public boolean field_78666_e;
    public boolean field_78661_f;
    public static boolean field_78667_b = true;
    public boolean field_78668_c = true;
    public double field_83021_g;
    public double field_83026_h;
    public double field_83027_i;
    public double field_83024_j;
    public double field_83025_k;
    public double field_83022_l;
    public boolean field_83023_m;
    public boolean field_98189_n;
    public final Minecraft field_94177_n;
    public int field_78662_g;
    public int field_78683_h;
    public int field_78685_i;
    public int field_78679_j;
    public int field_78681_k;
    public int field_78675_l;
    public boolean field_78677_m;
    public float field_78691_u;
    public float field_78689_v;
    public float field_78687_w;
    public float field_78712_x;
    public float field_78710_y;
    public float field_78708_z;
    public float field_78628_A;
    public float field_78629_B;
    public float field_78630_C;
    public float field_78624_D;
    public float field_78625_E;
    public float field_78626_F;
    public float field_78627_G;
    public float field_78634_H;
    public float field_78635_I;
    public float field_78636_J;
    public float field_78637_K;
    public float field_78631_L;
    public float field_78632_M;
    public float field_78633_N;
    public int field_78649_S;
    public int field_78641_T;
    public int field_78639_U;
    public int field_78645_V;
    public int field_78643_W;
    public int field_78657_X;
    public int field_78655_Y;
    public int field_78660_Z;
    public int field_78704_aa;
    public int field_78705_ab;
    public int field_78702_ac;
    public int field_78703_ad;
    public int field_78709_ae;
    public int field_78711_af;
    public int field_78706_ag;
    public int field_78707_ah;
    public int field_78690_ai;
    public int field_78692_aj;
    public int field_78686_ak;
    public int field_78688_al;
    public int field_78700_an;
    public int field_78694_ao;
    public int field_78696_ap;
    public int field_78676_aq;
    public float field_78674_ar;
    public float field_78672_as;
    public float field_78670_at;
    public float field_78684_au;
    public float field_78682_av;
    public float field_78680_aw;
    public float field_78678_ax;
    public float field_78665_ay;
    public float field_78663_az;
    public float field_78650_aA;
    public float field_78651_aB;
    public float field_78652_aC;

    public RenderBlocks(IBlockAccess p_i1251_1_)
    {
        this.field_78669_a = p_i1251_1_;
        this.field_94177_n = Minecraft.func_71410_x();
    }

    public RenderBlocks()
    {
        this.field_94177_n = Minecraft.func_71410_x();
    }

    public void func_82774_a(Icon p_82774_1_)
    {
        this.field_78664_d = p_82774_1_;
    }

    public void func_78595_a()
    {
        this.field_78664_d = null;
    }

    public boolean func_94167_b()
    {
        return this.field_78664_d != null;
    }

    public void func_83020_a(double p_83020_1_, double p_83020_3_, double p_83020_5_, double p_83020_7_, double p_83020_9_, double p_83020_11_)
    {
        if (!this.field_83023_m)
        {
            this.field_83021_g = p_83020_1_;
            this.field_83026_h = p_83020_7_;
            this.field_83027_i = p_83020_3_;
            this.field_83024_j = p_83020_9_;
            this.field_83025_k = p_83020_5_;
            this.field_83022_l = p_83020_11_;
            this.field_98189_n = this.field_94177_n.field_71474_y.field_74348_k >= 2 && (this.field_83021_g > 0.0D || this.field_83026_h < 1.0D || this.field_83027_i > 0.0D || this.field_83024_j < 1.0D || this.field_83025_k > 0.0D || this.field_83022_l < 1.0D);
        }
    }

    public void func_83018_a(Block p_83018_1_)
    {
        if (!this.field_83023_m)
        {
            this.field_83021_g = p_83018_1_.func_83009_v();
            this.field_83026_h = p_83018_1_.func_83007_w();
            this.field_83027_i = p_83018_1_.func_83008_x();
            this.field_83024_j = p_83018_1_.func_83010_y();
            this.field_83025_k = p_83018_1_.func_83005_z();
            this.field_83022_l = p_83018_1_.func_83006_A();
            this.field_98189_n = this.field_94177_n.field_71474_y.field_74348_k >= 2 && (this.field_83021_g > 0.0D || this.field_83026_h < 1.0D || this.field_83027_i > 0.0D || this.field_83024_j < 1.0D || this.field_83025_k > 0.0D || this.field_83022_l < 1.0D);
        }
    }

    public void func_83019_b(double p_83019_1_, double p_83019_3_, double p_83019_5_, double p_83019_7_, double p_83019_9_, double p_83019_11_)
    {
        this.field_83021_g = p_83019_1_;
        this.field_83026_h = p_83019_7_;
        this.field_83027_i = p_83019_3_;
        this.field_83024_j = p_83019_9_;
        this.field_83025_k = p_83019_5_;
        this.field_83022_l = p_83019_11_;
        this.field_83023_m = true;
        this.field_98189_n = this.field_94177_n.field_71474_y.field_74348_k >= 2 && (this.field_83021_g > 0.0D || this.field_83026_h < 1.0D || this.field_83027_i > 0.0D || this.field_83024_j < 1.0D || this.field_83025_k > 0.0D || this.field_83022_l < 1.0D);
    }

    public void func_83017_b()
    {
        this.field_83023_m = false;
    }

    public void func_78604_a(Block p_78604_1_, int p_78604_2_, int p_78604_3_, int p_78604_4_, Icon p_78604_5_)
    {
        this.func_82774_a(p_78604_5_);
        this.func_78612_b(p_78604_1_, p_78604_2_, p_78604_3_, p_78604_4_);
        this.func_78595_a();
    }

    public void func_78583_a(Block p_78583_1_, int p_78583_2_, int p_78583_3_, int p_78583_4_)
    {
        this.field_78661_f = true;
        this.func_78612_b(p_78583_1_, p_78583_2_, p_78583_3_, p_78583_4_);
        this.field_78661_f = false;
    }

    public boolean func_78612_b(Block p_78612_1_, int p_78612_2_, int p_78612_3_, int p_78612_4_)
    {
        int l = p_78612_1_.func_71857_b();

        if (l == -1)
        {
            return false;
        }
        else
        {
            p_78612_1_.func_71902_a(this.field_78669_a, p_78612_2_, p_78612_3_, p_78612_4_);
            this.func_83018_a(p_78612_1_);
            return l == 0 ? this.func_78570_q(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 4 ? this.func_78621_p(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 31 ? this.func_78581_r(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 1 ? this.func_78620_l(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 2 ? this.func_78572_c(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 20 ? this.func_78598_k(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 11 ? this.func_78582_a((BlockFence)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 39 ? this.func_96445_r(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 5 ? this.func_78589_i(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 13 ? this.func_78584_s(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 9 ? this.func_78586_a((BlockRailBase)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 19 ? this.func_78603_m(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 23 ? this.func_78566_o(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 6 ? this.func_78614_n(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 3 ? this.func_78590_h((BlockFire)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 8 ? this.func_78576_j(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 7 ? this.func_78601_u(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 10 ? this.func_78565_t((BlockStairs)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 27 ? this.func_78618_a((BlockDragonEgg)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 32 ? this.func_82779_a((BlockWall)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 12 ? this.func_78594_e(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 29 ? this.func_78577_f(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 30 ? this.func_78619_g(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 14 ? this.func_78574_w(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 15 ? this.func_78610_x((BlockRedstoneRepeater)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 36 ? this.func_94176_a((BlockRedstoneLogic)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 37 ? this.func_94171_a((BlockComparator)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 16 ? this.func_78593_b(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_, false) : (l == 17 ? this.func_78608_c(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_, true) : (l == 18 ? this.func_78592_a((BlockPane)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 21 ? this.func_78580_a((BlockFenceGate)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 24 ? this.func_78615_a((BlockCauldron)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 33 ? this.func_82780_a((BlockFlowerPot)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 35 ? this.func_82775_a((BlockAnvil)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 25 ? this.func_78585_a((BlockBrewingStand)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 26 ? this.func_78567_v((BlockEndPortalFrame)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 28 ? this.func_78616_a((BlockCocoa)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 34 ? this.func_82778_a((BlockBeacon)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : (l == 38 ? this.func_94172_a((BlockHopper)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_) : false))))))))))))))))))))))))))))))))))))));
        }
    }

    public boolean func_78567_v(BlockEndPortalFrame p_78567_1_, int p_78567_2_, int p_78567_3_, int p_78567_4_)
    {
        int l = this.field_78669_a.func_72805_g(p_78567_2_, p_78567_3_, p_78567_4_);
        int i1 = l & 3;

        if (i1 == 0)
        {
            this.field_78681_k = 3;
        }
        else if (i1 == 3)
        {
            this.field_78681_k = 1;
        }
        else if (i1 == 1)
        {
            this.field_78681_k = 2;
        }

        if (!BlockEndPortalFrame.func_72165_e(l))
        {
            this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);
            this.func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
            this.field_78681_k = 0;
            return true;
        }
        else
        {
            this.field_78661_f = true;
            this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);
            this.func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
            this.func_82774_a(p_78567_1_.func_94398_p());
            this.func_83020_a(0.25D, 0.8125D, 0.25D, 0.75D, 1.0D, 0.75D);
            this.func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
            this.field_78661_f = false;
            this.func_78595_a();
            this.field_78681_k = 0;
            return true;
        }
    }

    public boolean func_78574_w(Block p_78574_1_, int p_78574_2_, int p_78574_3_, int p_78574_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int l = this.field_78669_a.func_72805_g(p_78574_2_, p_78574_3_, p_78574_4_);
        int i1 = BlockBed.func_72217_d(l);
        boolean flag = BlockBed.func_72229_a_(l);
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        int j1 = p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_);
        tessellator.func_78380_c(j1);
        tessellator.func_78386_a(f, f, f);
        Icon icon = this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 0);
        double d0 = (double)icon.func_94209_e();
        double d1 = (double)icon.func_94212_f();
        double d2 = (double)icon.func_94206_g();
        double d3 = (double)icon.func_94210_h();
        double d4 = (double)p_78574_2_ + this.field_83021_g;
        double d5 = (double)p_78574_2_ + this.field_83026_h;
        double d6 = (double)p_78574_3_ + this.field_83027_i + 0.1875D;
        double d7 = (double)p_78574_4_ + this.field_83025_k;
        double d8 = (double)p_78574_4_ + this.field_83022_l;
        tessellator.func_78374_a(d4, d6, d8, d0, d3);
        tessellator.func_78374_a(d4, d6, d7, d0, d2);
        tessellator.func_78374_a(d5, d6, d7, d1, d2);
        tessellator.func_78374_a(d5, d6, d8, d1, d3);
        tessellator.func_78380_c(p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_ + 1, p_78574_4_));
        tessellator.func_78386_a(f1, f1, f1);
        icon = this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 1);
        d0 = (double)icon.func_94209_e();
        d1 = (double)icon.func_94212_f();
        d2 = (double)icon.func_94206_g();
        d3 = (double)icon.func_94210_h();
        d4 = d0;
        d5 = d1;
        d6 = d2;
        d7 = d2;
        d8 = d0;
        double d9 = d1;
        double d10 = d3;
        double d11 = d3;

        if (i1 == 0)
        {
            d5 = d0;
            d6 = d3;
            d8 = d1;
            d11 = d2;
        }
        else if (i1 == 2)
        {
            d4 = d1;
            d7 = d3;
            d9 = d0;
            d10 = d2;
        }
        else if (i1 == 3)
        {
            d4 = d1;
            d7 = d3;
            d9 = d0;
            d10 = d2;
            d5 = d0;
            d6 = d3;
            d8 = d1;
            d11 = d2;
        }

        double d12 = (double)p_78574_2_ + this.field_83021_g;
        double d13 = (double)p_78574_2_ + this.field_83026_h;
        double d14 = (double)p_78574_3_ + this.field_83024_j;
        double d15 = (double)p_78574_4_ + this.field_83025_k;
        double d16 = (double)p_78574_4_ + this.field_83022_l;
        tessellator.func_78374_a(d13, d14, d16, d8, d10);
        tessellator.func_78374_a(d13, d14, d15, d4, d6);
        tessellator.func_78374_a(d12, d14, d15, d5, d7);
        tessellator.func_78374_a(d12, d14, d16, d9, d11);
        int k1 = Direction.field_71582_c[i1];

        if (flag)
        {
            k1 = Direction.field_71582_c[Direction.field_71580_e[i1]];
        }

        byte b0 = 4;

        switch (i1)
        {
            case 0:
                b0 = 5;
                break;
            case 1:
                b0 = 3;
            case 2:
            default:
                break;
            case 3:
                b0 = 2;
        }

        if (k1 != 2 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ - 1, 2)))
        {
            tessellator.func_78380_c(this.field_83025_k > 0.0D ? j1 : p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ - 1));
            tessellator.func_78386_a(f2, f2, f2);
            this.field_78666_e = b0 == 2;
            this.func_78611_c(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 2));
        }

        if (k1 != 3 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ + 1, 3)))
        {
            tessellator.func_78380_c(this.field_83022_l < 1.0D ? j1 : p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ + 1));
            tessellator.func_78386_a(f2, f2, f2);
            this.field_78666_e = b0 == 3;
            this.func_78622_d(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 3));
        }

        if (k1 != 4 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_ - 1, p_78574_3_, p_78574_4_, 4)))
        {
            tessellator.func_78380_c(this.field_83025_k > 0.0D ? j1 : p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_ - 1, p_78574_3_, p_78574_4_));
            tessellator.func_78386_a(f3, f3, f3);
            this.field_78666_e = b0 == 4;
            this.func_78573_e(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 4));
        }

        if (k1 != 5 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_ + 1, p_78574_3_, p_78574_4_, 5)))
        {
            tessellator.func_78380_c(this.field_83022_l < 1.0D ? j1 : p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_ + 1, p_78574_3_, p_78574_4_));
            tessellator.func_78386_a(f3, f3, f3);
            this.field_78666_e = b0 == 5;
            this.func_78605_f(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 5));
        }

        this.field_78666_e = false;
        return true;
    }

    public boolean func_78585_a(BlockBrewingStand p_78585_1_, int p_78585_2_, int p_78585_3_, int p_78585_4_)
    {
        this.func_83020_a(0.4375D, 0.0D, 0.4375D, 0.5625D, 0.875D, 0.5625D);
        this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
        this.func_82774_a(p_78585_1_.func_94448_e());
        this.field_78661_f = true;
        this.func_83020_a(0.5625D, 0.0D, 0.3125D, 0.9375D, 0.125D, 0.6875D);
        this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
        this.func_83020_a(0.125D, 0.0D, 0.0625D, 0.5D, 0.125D, 0.4375D);
        this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
        this.func_83020_a(0.125D, 0.0D, 0.5625D, 0.5D, 0.125D, 0.9375D);
        this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
        this.field_78661_f = false;
        this.func_78595_a();
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78585_1_.func_71874_e(this.field_78669_a, p_78585_2_, p_78585_3_, p_78585_4_));
        float f = 1.0F;
        int l = p_78585_1_.func_71920_b(this.field_78669_a, p_78585_2_, p_78585_3_, p_78585_4_);
        float f1 = (float)(l >> 16 & 255) / 255.0F;
        float f2 = (float)(l >> 8 & 255) / 255.0F;
        float f3 = (float)(l & 255) / 255.0F;

        if (EntityRenderer.field_78517_a)
        {
            float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }

        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        Icon icon = this.func_94165_a(p_78585_1_, 0, 0);

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        double d0 = (double)icon.func_94206_g();
        double d1 = (double)icon.func_94210_h();
        int i1 = this.field_78669_a.func_72805_g(p_78585_2_, p_78585_3_, p_78585_4_);

        for (int j1 = 0; j1 < 3; ++j1)
        {
            double d2 = (double)j1 * Math.PI * 2.0D / 3.0D + (Math.PI / 2D);
            double d3 = (double)icon.func_94214_a(8.0D);
            double d4 = (double)icon.func_94212_f();

            if ((i1 & 1 << j1) != 0)
            {
                d4 = (double)icon.func_94209_e();
            }

            double d5 = (double)p_78585_2_ + 0.5D;
            double d6 = (double)p_78585_2_ + 0.5D + Math.sin(d2) * 8.0D / 16.0D;
            double d7 = (double)p_78585_4_ + 0.5D;
            double d8 = (double)p_78585_4_ + 0.5D + Math.cos(d2) * 8.0D / 16.0D;
            tessellator.func_78374_a(d5, (double)(p_78585_3_ + 1), d7, d3, d0);
            tessellator.func_78374_a(d5, (double)(p_78585_3_ + 0), d7, d3, d1);
            tessellator.func_78374_a(d6, (double)(p_78585_3_ + 0), d8, d4, d1);
            tessellator.func_78374_a(d6, (double)(p_78585_3_ + 1), d8, d4, d0);
            tessellator.func_78374_a(d6, (double)(p_78585_3_ + 1), d8, d4, d0);
            tessellator.func_78374_a(d6, (double)(p_78585_3_ + 0), d8, d4, d1);
            tessellator.func_78374_a(d5, (double)(p_78585_3_ + 0), d7, d3, d1);
            tessellator.func_78374_a(d5, (double)(p_78585_3_ + 1), d7, d3, d0);
        }

        p_78585_1_.func_71919_f();
        return true;
    }

    public boolean func_78615_a(BlockCauldron p_78615_1_, int p_78615_2_, int p_78615_3_, int p_78615_4_)
    {
        this.func_78570_q(p_78615_1_, p_78615_2_, p_78615_3_, p_78615_4_);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78615_1_.func_71874_e(this.field_78669_a, p_78615_2_, p_78615_3_, p_78615_4_));
        float f = 1.0F;
        int l = p_78615_1_.func_71920_b(this.field_78669_a, p_78615_2_, p_78615_3_, p_78615_4_);
        float f1 = (float)(l >> 16 & 255) / 255.0F;
        float f2 = (float)(l >> 8 & 255) / 255.0F;
        float f3 = (float)(l & 255) / 255.0F;
        float f4;

        if (EntityRenderer.field_78517_a)
        {
            float f5 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            f4 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f5;
            f2 = f4;
            f3 = f6;
        }

        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        Icon icon = p_78615_1_.func_71851_a(2);
        f4 = 0.125F;
        this.func_78605_f(p_78615_1_, (double)((float)p_78615_2_ - 1.0F + f4), (double)p_78615_3_, (double)p_78615_4_, icon);
        this.func_78573_e(p_78615_1_, (double)((float)p_78615_2_ + 1.0F - f4), (double)p_78615_3_, (double)p_78615_4_, icon);
        this.func_78622_d(p_78615_1_, (double)p_78615_2_, (double)p_78615_3_, (double)((float)p_78615_4_ - 1.0F + f4), icon);
        this.func_78611_c(p_78615_1_, (double)p_78615_2_, (double)p_78615_3_, (double)((float)p_78615_4_ + 1.0F - f4), icon);
        Icon icon1 = BlockCauldron.func_94375_b("inner");
        this.func_78617_b(p_78615_1_, (double)p_78615_2_, (double)((float)p_78615_3_ - 1.0F + 0.25F), (double)p_78615_4_, icon1);
        this.func_78613_a(p_78615_1_, (double)p_78615_2_, (double)((float)p_78615_3_ + 1.0F - 0.75F), (double)p_78615_4_, icon1);
        int i1 = this.field_78669_a.func_72805_g(p_78615_2_, p_78615_3_, p_78615_4_);

        if (i1 > 0)
        {
            Icon icon2 = BlockFluid.func_94424_b("water_still");

            if (i1 > 3)
            {
                i1 = 3;
            }

            this.func_78617_b(p_78615_1_, (double)p_78615_2_, (double)((float)p_78615_3_ - 1.0F + (6.0F + (float)i1 * 3.0F) / 16.0F), (double)p_78615_4_, icon2);
        }

        return true;
    }

    public boolean func_82780_a(BlockFlowerPot p_82780_1_, int p_82780_2_, int p_82780_3_, int p_82780_4_)
    {
        this.func_78570_q(p_82780_1_, p_82780_2_, p_82780_3_, p_82780_4_);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_82780_1_.func_71874_e(this.field_78669_a, p_82780_2_, p_82780_3_, p_82780_4_));
        float f = 1.0F;
        int l = p_82780_1_.func_71920_b(this.field_78669_a, p_82780_2_, p_82780_3_, p_82780_4_);
        Icon icon = this.func_94173_a(p_82780_1_, 0);
        float f1 = (float)(l >> 16 & 255) / 255.0F;
        float f2 = (float)(l >> 8 & 255) / 255.0F;
        float f3 = (float)(l & 255) / 255.0F;
        float f4;
        float f5;

        if (EntityRenderer.field_78517_a)
        {
            f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            float f6 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            f5 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f4;
            f2 = f6;
            f3 = f5;
        }

        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        f4 = 0.1865F;
        this.func_78605_f(p_82780_1_, (double)((float)p_82780_2_ - 0.5F + f4), (double)p_82780_3_, (double)p_82780_4_, icon);
        this.func_78573_e(p_82780_1_, (double)((float)p_82780_2_ + 0.5F - f4), (double)p_82780_3_, (double)p_82780_4_, icon);
        this.func_78622_d(p_82780_1_, (double)p_82780_2_, (double)p_82780_3_, (double)((float)p_82780_4_ - 0.5F + f4), icon);
        this.func_78611_c(p_82780_1_, (double)p_82780_2_, (double)p_82780_3_, (double)((float)p_82780_4_ + 0.5F - f4), icon);
        this.func_78617_b(p_82780_1_, (double)p_82780_2_, (double)((float)p_82780_3_ - 0.5F + f4 + 0.1875F), (double)p_82780_4_, this.func_94175_b(Block.field_71979_v));
        int i1 = this.field_78669_a.func_72805_g(p_82780_2_, p_82780_3_, p_82780_4_);

        if (i1 != 0)
        {
            f5 = 0.0F;
            float f7 = 4.0F;
            float f8 = 0.0F;
            BlockFlower blockflower = null;

            switch (i1)
            {
                case 1:
                    blockflower = Block.field_72107_ae;
                    break;
                case 2:
                    blockflower = Block.field_72097_ad;
                case 3:
                case 4:
                case 5:
                case 6:
                default:
                    break;
                case 7:
                    blockflower = Block.field_72103_ag;
                    break;
                case 8:
                    blockflower = Block.field_72109_af;
            }

            tessellator.func_78372_c(f5 / 16.0F, f7 / 16.0F, f8 / 16.0F);

            if (blockflower != null)
            {
                this.func_78612_b(blockflower, p_82780_2_, p_82780_3_, p_82780_4_);
            }
            else if (i1 == 9)
            {
                this.field_78661_f = true;
                float f9 = 0.125F;
                this.func_83020_a((double)(0.5F - f9), 0.0D, (double)(0.5F - f9), (double)(0.5F + f9), 0.25D, (double)(0.5F + f9));
                this.func_78570_q(Block.field_72038_aV, p_82780_2_, p_82780_3_, p_82780_4_);
                this.func_83020_a((double)(0.5F - f9), 0.25D, (double)(0.5F - f9), (double)(0.5F + f9), 0.5D, (double)(0.5F + f9));
                this.func_78570_q(Block.field_72038_aV, p_82780_2_, p_82780_3_, p_82780_4_);
                this.func_83020_a((double)(0.5F - f9), 0.5D, (double)(0.5F - f9), (double)(0.5F + f9), 0.75D, (double)(0.5F + f9));
                this.func_78570_q(Block.field_72038_aV, p_82780_2_, p_82780_3_, p_82780_4_);
                this.field_78661_f = false;
                this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            }
            else if (i1 == 3)
            {
                this.func_78599_a(Block.field_71987_y, 0, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
            }
            else if (i1 == 5)
            {
                this.func_78599_a(Block.field_71987_y, 2, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
            }
            else if (i1 == 4)
            {
                this.func_78599_a(Block.field_71987_y, 1, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
            }
            else if (i1 == 6)
            {
                this.func_78599_a(Block.field_71987_y, 3, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
            }
            else if (i1 == 11)
            {
                l = Block.field_71962_X.func_71920_b(this.field_78669_a, p_82780_2_, p_82780_3_, p_82780_4_);
                f1 = (float)(l >> 16 & 255) / 255.0F;
                f2 = (float)(l >> 8 & 255) / 255.0F;
                f3 = (float)(l & 255) / 255.0F;
                tessellator.func_78386_a(f * f1, f * f2, f * f3);
                this.func_78599_a(Block.field_71962_X, 2, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
            }
            else if (i1 == 10)
            {
                this.func_78599_a(Block.field_71961_Y, 2, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
            }

            tessellator.func_78372_c(-f5 / 16.0F, -f7 / 16.0F, -f8 / 16.0F);
        }

        return true;
    }

    public boolean func_82775_a(BlockAnvil p_82775_1_, int p_82775_2_, int p_82775_3_, int p_82775_4_)
    {
        return this.func_85096_a(p_82775_1_, p_82775_2_, p_82775_3_, p_82775_4_, this.field_78669_a.func_72805_g(p_82775_2_, p_82775_3_, p_82775_4_));
    }

    public boolean func_85096_a(BlockAnvil p_85096_1_, int p_85096_2_, int p_85096_3_, int p_85096_4_, int p_85096_5_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_85096_1_.func_71874_e(this.field_78669_a, p_85096_2_, p_85096_3_, p_85096_4_));
        float f = 1.0F;
        int i1 = p_85096_1_.func_71920_b(this.field_78669_a, p_85096_2_, p_85096_3_, p_85096_4_);
        float f1 = (float)(i1 >> 16 & 255) / 255.0F;
        float f2 = (float)(i1 >> 8 & 255) / 255.0F;
        float f3 = (float)(i1 & 255) / 255.0F;

        if (EntityRenderer.field_78517_a)
        {
            float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }

        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        return this.func_82776_a(p_85096_1_, p_85096_2_, p_85096_3_, p_85096_4_, p_85096_5_, false);
    }

    public boolean func_82776_a(BlockAnvil p_82776_1_, int p_82776_2_, int p_82776_3_, int p_82776_4_, int p_82776_5_, boolean p_82776_6_)
    {
        int i1 = p_82776_6_ ? 0 : p_82776_5_ & 3;
        boolean flag1 = false;
        float f = 0.0F;

        switch (i1)
        {
            case 0:
                this.field_78685_i = 2;
                this.field_78679_j = 1;
                this.field_78681_k = 3;
                this.field_78675_l = 3;
                break;
            case 1:
                this.field_78662_g = 1;
                this.field_78683_h = 2;
                this.field_78681_k = 2;
                this.field_78675_l = 1;
                flag1 = true;
                break;
            case 2:
                this.field_78685_i = 1;
                this.field_78679_j = 2;
                break;
            case 3:
                this.field_78662_g = 2;
                this.field_78683_h = 1;
                this.field_78681_k = 1;
                this.field_78675_l = 2;
                flag1 = true;
        }

        f = this.func_82777_a(p_82776_1_, p_82776_2_, p_82776_3_, p_82776_4_, 0, f, 0.75F, 0.25F, 0.75F, flag1, p_82776_6_, p_82776_5_);
        f = this.func_82777_a(p_82776_1_, p_82776_2_, p_82776_3_, p_82776_4_, 1, f, 0.5F, 0.0625F, 0.625F, flag1, p_82776_6_, p_82776_5_);
        f = this.func_82777_a(p_82776_1_, p_82776_2_, p_82776_3_, p_82776_4_, 2, f, 0.25F, 0.3125F, 0.5F, flag1, p_82776_6_, p_82776_5_);
        this.func_82777_a(p_82776_1_, p_82776_2_, p_82776_3_, p_82776_4_, 3, f, 0.625F, 0.375F, 1.0F, flag1, p_82776_6_, p_82776_5_);
        this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        this.field_78662_g = 0;
        this.field_78683_h = 0;
        this.field_78685_i = 0;
        this.field_78679_j = 0;
        this.field_78681_k = 0;
        this.field_78675_l = 0;
        return true;
    }

    public float func_82777_a(BlockAnvil p_82777_1_, int p_82777_2_, int p_82777_3_, int p_82777_4_, int p_82777_5_, float p_82777_6_, float p_82777_7_, float p_82777_8_, float p_82777_9_, boolean p_82777_10_, boolean p_82777_11_, int p_82777_12_)
    {
        if (p_82777_10_)
        {
            float f4 = p_82777_7_;
            p_82777_7_ = p_82777_9_;
            p_82777_9_ = f4;
        }

        p_82777_7_ /= 2.0F;
        p_82777_9_ /= 2.0F;
        p_82777_1_.field_82521_b = p_82777_5_;
        this.func_83020_a((double)(0.5F - p_82777_7_), (double)p_82777_6_, (double)(0.5F - p_82777_9_), (double)(0.5F + p_82777_7_), (double)(p_82777_6_ + p_82777_8_), (double)(0.5F + p_82777_9_));

        if (p_82777_11_)
        {
            Tessellator tessellator = Tessellator.field_78398_a;
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78613_a(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 0, p_82777_12_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
            this.func_78617_b(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 1, p_82777_12_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
            this.func_78611_c(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 2, p_82777_12_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
            this.func_78622_d(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 3, p_82777_12_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
            this.func_78573_e(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 4, p_82777_12_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
            this.func_78605_f(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 5, p_82777_12_));
            tessellator.func_78381_a();
        }
        else
        {
            this.func_78570_q(p_82777_1_, p_82777_2_, p_82777_3_, p_82777_4_);
        }

        return p_82777_6_ + p_82777_8_;
    }

    public boolean func_78572_c(Block p_78572_1_, int p_78572_2_, int p_78572_3_, int p_78572_4_)
    {
        int l = this.field_78669_a.func_72805_g(p_78572_2_, p_78572_3_, p_78572_4_);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78572_1_.func_71874_e(this.field_78669_a, p_78572_2_, p_78572_3_, p_78572_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        double d0 = 0.4000000059604645D;
        double d1 = 0.5D - d0;
        double d2 = 0.20000000298023224D;

        if (l == 1)
        {
            this.func_78623_a(p_78572_1_, (double)p_78572_2_ - d1, (double)p_78572_3_ + d2, (double)p_78572_4_, -d0, 0.0D, 0);
        }
        else if (l == 2)
        {
            this.func_78623_a(p_78572_1_, (double)p_78572_2_ + d1, (double)p_78572_3_ + d2, (double)p_78572_4_, d0, 0.0D, 0);
        }
        else if (l == 3)
        {
            this.func_78623_a(p_78572_1_, (double)p_78572_2_, (double)p_78572_3_ + d2, (double)p_78572_4_ - d1, 0.0D, -d0, 0);
        }
        else if (l == 4)
        {
            this.func_78623_a(p_78572_1_, (double)p_78572_2_, (double)p_78572_3_ + d2, (double)p_78572_4_ + d1, 0.0D, d0, 0);
        }
        else
        {
            this.func_78623_a(p_78572_1_, (double)p_78572_2_, (double)p_78572_3_, (double)p_78572_4_, 0.0D, 0.0D, 0);
        }

        return true;
    }

    public boolean func_78610_x(BlockRedstoneRepeater p_78610_1_, int p_78610_2_, int p_78610_3_, int p_78610_4_)
    {
        int l = this.field_78669_a.func_72805_g(p_78610_2_, p_78610_3_, p_78610_4_);
        int i1 = l & 3;
        int j1 = (l & 12) >> 2;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78610_1_.func_71874_e(this.field_78669_a, p_78610_2_, p_78610_3_, p_78610_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        double d0 = -0.1875D;
        boolean flag = p_78610_1_.func_94476_e(this.field_78669_a, p_78610_2_, p_78610_3_, p_78610_4_, l);
        double d1 = 0.0D;
        double d2 = 0.0D;
        double d3 = 0.0D;
        double d4 = 0.0D;

        switch (i1)
        {
            case 0:
                d4 = -0.3125D;
                d2 = BlockRedstoneRepeater.field_72223_a[j1];
                break;
            case 1:
                d3 = 0.3125D;
                d1 = -BlockRedstoneRepeater.field_72223_a[j1];
                break;
            case 2:
                d4 = 0.3125D;
                d2 = -BlockRedstoneRepeater.field_72223_a[j1];
                break;
            case 3:
                d3 = -0.3125D;
                d1 = BlockRedstoneRepeater.field_72223_a[j1];
        }

        if (!flag)
        {
            this.func_78623_a(p_78610_1_, (double)p_78610_2_ + d1, (double)p_78610_3_ + d0, (double)p_78610_4_ + d2, 0.0D, 0.0D, 0);
        }
        else
        {
            Icon icon = this.func_94175_b(Block.field_71986_z);
            this.func_82774_a(icon);
            float f = 2.0F;
            float f1 = 14.0F;
            float f2 = 7.0F;
            float f3 = 9.0F;

            switch (i1)
            {
                case 1:
                case 3:
                    f = 7.0F;
                    f1 = 9.0F;
                    f2 = 2.0F;
                    f3 = 14.0F;
                case 0:
                case 2:
                default:
                    this.func_83020_a((double)(f / 16.0F + (float)d1), 0.125D, (double)(f2 / 16.0F + (float)d2), (double)(f1 / 16.0F + (float)d1), 0.25D, (double)(f3 / 16.0F + (float)d2));
                    double d5 = (double)icon.func_94214_a((double)f);
                    double d6 = (double)icon.func_94207_b((double)f2);
                    double d7 = (double)icon.func_94214_a((double)f1);
                    double d8 = (double)icon.func_94207_b((double)f3);
                    tessellator.func_78374_a((double)((float)p_78610_2_ + f / 16.0F) + d1, (double)((float)p_78610_3_ + 0.25F), (double)((float)p_78610_4_ + f2 / 16.0F) + d2, d5, d6);
                    tessellator.func_78374_a((double)((float)p_78610_2_ + f / 16.0F) + d1, (double)((float)p_78610_3_ + 0.25F), (double)((float)p_78610_4_ + f3 / 16.0F) + d2, d5, d8);
                    tessellator.func_78374_a((double)((float)p_78610_2_ + f1 / 16.0F) + d1, (double)((float)p_78610_3_ + 0.25F), (double)((float)p_78610_4_ + f3 / 16.0F) + d2, d7, d8);
                    tessellator.func_78374_a((double)((float)p_78610_2_ + f1 / 16.0F) + d1, (double)((float)p_78610_3_ + 0.25F), (double)((float)p_78610_4_ + f2 / 16.0F) + d2, d7, d6);
                    this.func_78570_q(p_78610_1_, p_78610_2_, p_78610_3_, p_78610_4_);
                    this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);
                    this.func_78595_a();
            }
        }

        tessellator.func_78380_c(p_78610_1_.func_71874_e(this.field_78669_a, p_78610_2_, p_78610_3_, p_78610_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        this.func_78623_a(p_78610_1_, (double)p_78610_2_ + d3, (double)p_78610_3_ + d0, (double)p_78610_4_ + d4, 0.0D, 0.0D, 0);
        this.func_94176_a(p_78610_1_, p_78610_2_, p_78610_3_, p_78610_4_);
        return true;
    }

    public boolean func_94171_a(BlockComparator p_94171_1_, int p_94171_2_, int p_94171_3_, int p_94171_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_94171_1_.func_71874_e(this.field_78669_a, p_94171_2_, p_94171_3_, p_94171_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        int l = this.field_78669_a.func_72805_g(p_94171_2_, p_94171_3_, p_94171_4_);
        int i1 = l & 3;
        double d0 = 0.0D;
        double d1 = -0.1875D;
        double d2 = 0.0D;
        double d3 = 0.0D;
        double d4 = 0.0D;
        Icon icon;

        if (p_94171_1_.func_94490_c(l))
        {
            icon = Block.field_72035_aQ.func_71851_a(0);
        }
        else
        {
            d1 -= 0.1875D;
            icon = Block.field_72049_aP.func_71851_a(0);
        }

        switch (i1)
        {
            case 0:
                d2 = -0.3125D;
                d4 = 1.0D;
                break;
            case 1:
                d0 = 0.3125D;
                d3 = -1.0D;
                break;
            case 2:
                d2 = 0.3125D;
                d4 = -1.0D;
                break;
            case 3:
                d0 = -0.3125D;
                d3 = 1.0D;
        }

        this.func_78623_a(p_94171_1_, (double)p_94171_2_ + 0.25D * d3 + 0.1875D * d4, (double)((float)p_94171_3_ - 0.1875F), (double)p_94171_4_ + 0.25D * d4 + 0.1875D * d3, 0.0D, 0.0D, l);
        this.func_78623_a(p_94171_1_, (double)p_94171_2_ + 0.25D * d3 + -0.1875D * d4, (double)((float)p_94171_3_ - 0.1875F), (double)p_94171_4_ + 0.25D * d4 + -0.1875D * d3, 0.0D, 0.0D, l);
        this.func_82774_a(icon);
        this.func_78623_a(p_94171_1_, (double)p_94171_2_ + d0, (double)p_94171_3_ + d1, (double)p_94171_4_ + d2, 0.0D, 0.0D, l);
        this.func_78595_a();
        this.func_94174_a(p_94171_1_, p_94171_2_, p_94171_3_, p_94171_4_, i1);
        return true;
    }

    public boolean func_94176_a(BlockRedstoneLogic p_94176_1_, int p_94176_2_, int p_94176_3_, int p_94176_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        this.func_94174_a(p_94176_1_, p_94176_2_, p_94176_3_, p_94176_4_, this.field_78669_a.func_72805_g(p_94176_2_, p_94176_3_, p_94176_4_) & 3);
        return true;
    }

    public void func_94174_a(BlockRedstoneLogic p_94174_1_, int p_94174_2_, int p_94174_3_, int p_94174_4_, int p_94174_5_)
    {
        this.func_78570_q(p_94174_1_, p_94174_2_, p_94174_3_, p_94174_4_);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_94174_1_.func_71874_e(this.field_78669_a, p_94174_2_, p_94174_3_, p_94174_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        int i1 = this.field_78669_a.func_72805_g(p_94174_2_, p_94174_3_, p_94174_4_);
        Icon icon = this.func_94165_a(p_94174_1_, 1, i1);
        double d0 = (double)icon.func_94209_e();
        double d1 = (double)icon.func_94212_f();
        double d2 = (double)icon.func_94206_g();
        double d3 = (double)icon.func_94210_h();
        double d4 = 0.125D;
        double d5 = (double)(p_94174_2_ + 1);
        double d6 = (double)(p_94174_2_ + 1);
        double d7 = (double)(p_94174_2_ + 0);
        double d8 = (double)(p_94174_2_ + 0);
        double d9 = (double)(p_94174_4_ + 0);
        double d10 = (double)(p_94174_4_ + 1);
        double d11 = (double)(p_94174_4_ + 1);
        double d12 = (double)(p_94174_4_ + 0);
        double d13 = (double)p_94174_3_ + d4;

        if (p_94174_5_ == 2)
        {
            d5 = d6 = (double)(p_94174_2_ + 0);
            d7 = d8 = (double)(p_94174_2_ + 1);
            d9 = d12 = (double)(p_94174_4_ + 1);
            d10 = d11 = (double)(p_94174_4_ + 0);
        }
        else if (p_94174_5_ == 3)
        {
            d5 = d8 = (double)(p_94174_2_ + 0);
            d6 = d7 = (double)(p_94174_2_ + 1);
            d9 = d10 = (double)(p_94174_4_ + 0);
            d11 = d12 = (double)(p_94174_4_ + 1);
        }
        else if (p_94174_5_ == 1)
        {
            d5 = d8 = (double)(p_94174_2_ + 1);
            d6 = d7 = (double)(p_94174_2_ + 0);
            d9 = d10 = (double)(p_94174_4_ + 1);
            d11 = d12 = (double)(p_94174_4_ + 0);
        }

        tessellator.func_78374_a(d8, d13, d12, d0, d2);
        tessellator.func_78374_a(d7, d13, d11, d0, d3);
        tessellator.func_78374_a(d6, d13, d10, d1, d3);
        tessellator.func_78374_a(d5, d13, d9, d1, d2);
    }

    public void func_78568_d(Block p_78568_1_, int p_78568_2_, int p_78568_3_, int p_78568_4_)
    {
        this.field_78661_f = true;
        this.func_78593_b(p_78568_1_, p_78568_2_, p_78568_3_, p_78568_4_, true);
        this.field_78661_f = false;
    }

    public boolean func_78593_b(Block p_78593_1_, int p_78593_2_, int p_78593_3_, int p_78593_4_, boolean p_78593_5_)
    {
        int l = this.field_78669_a.func_72805_g(p_78593_2_, p_78593_3_, p_78593_4_);
        boolean flag1 = p_78593_5_ || (l & 8) != 0;
        int i1 = BlockPistonBase.func_72117_e(l);
        float f = 0.25F;

        if (flag1)
        {
            switch (i1)
            {
                case 0:
                    this.field_78662_g = 3;
                    this.field_78683_h = 3;
                    this.field_78685_i = 3;
                    this.field_78679_j = 3;
                    this.func_83020_a(0.0D, 0.25D, 0.0D, 1.0D, 1.0D, 1.0D);
                    break;
                case 1:
                    this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
                    break;
                case 2:
                    this.field_78685_i = 1;
                    this.field_78679_j = 2;
                    this.func_83020_a(0.0D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D);
                    break;
                case 3:
                    this.field_78685_i = 2;
                    this.field_78679_j = 1;
                    this.field_78681_k = 3;
                    this.field_78675_l = 3;
                    this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D);
                    break;
                case 4:
                    this.field_78662_g = 1;
                    this.field_78683_h = 2;
                    this.field_78681_k = 2;
                    this.field_78675_l = 1;
                    this.func_83020_a(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
                    break;
                case 5:
                    this.field_78662_g = 2;
                    this.field_78683_h = 1;
                    this.field_78681_k = 1;
                    this.field_78675_l = 2;
                    this.func_83020_a(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 1.0D);
            }

            ((BlockPistonBase)p_78593_1_).func_96479_b((float)this.field_83021_g, (float)this.field_83027_i, (float)this.field_83025_k, (float)this.field_83026_h, (float)this.field_83024_j, (float)this.field_83022_l);
            this.func_78570_q(p_78593_1_, p_78593_2_, p_78593_3_, p_78593_4_);
            this.field_78662_g = 0;
            this.field_78683_h = 0;
            this.field_78685_i = 0;
            this.field_78679_j = 0;
            this.field_78681_k = 0;
            this.field_78675_l = 0;
            this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            ((BlockPistonBase)p_78593_1_).func_96479_b((float)this.field_83021_g, (float)this.field_83027_i, (float)this.field_83025_k, (float)this.field_83026_h, (float)this.field_83024_j, (float)this.field_83022_l);
        }
        else
        {
            switch (i1)
            {
                case 0:
                    this.field_78662_g = 3;
                    this.field_78683_h = 3;
                    this.field_78685_i = 3;
                    this.field_78679_j = 3;
                case 1:
                default:
                    break;
                case 2:
                    this.field_78685_i = 1;
                    this.field_78679_j = 2;
                    break;
                case 3:
                    this.field_78685_i = 2;
                    this.field_78679_j = 1;
                    this.field_78681_k = 3;
                    this.field_78675_l = 3;
                    break;
                case 4:
                    this.field_78662_g = 1;
                    this.field_78683_h = 2;
                    this.field_78681_k = 2;
                    this.field_78675_l = 1;
                    break;
                case 5:
                    this.field_78662_g = 2;
                    this.field_78683_h = 1;
                    this.field_78681_k = 1;
                    this.field_78675_l = 2;
            }

            this.func_78570_q(p_78593_1_, p_78593_2_, p_78593_3_, p_78593_4_);
            this.field_78662_g = 0;
            this.field_78683_h = 0;
            this.field_78685_i = 0;
            this.field_78679_j = 0;
            this.field_78681_k = 0;
            this.field_78675_l = 0;
        }

        return true;
    }

    public void func_78591_a(double p_78591_1_, double p_78591_3_, double p_78591_5_, double p_78591_7_, double p_78591_9_, double p_78591_11_, float p_78591_13_, double p_78591_14_)
    {
        Icon icon = BlockPistonBase.func_94496_b("piston_side");

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        Tessellator tessellator = Tessellator.field_78398_a;
        double d7 = (double)icon.func_94209_e();
        double d8 = (double)icon.func_94206_g();
        double d9 = (double)icon.func_94214_a(p_78591_14_);
        double d10 = (double)icon.func_94207_b(4.0D);
        tessellator.func_78386_a(p_78591_13_, p_78591_13_, p_78591_13_);
        tessellator.func_78374_a(p_78591_1_, p_78591_7_, p_78591_9_, d9, d8);
        tessellator.func_78374_a(p_78591_1_, p_78591_5_, p_78591_9_, d7, d8);
        tessellator.func_78374_a(p_78591_3_, p_78591_5_, p_78591_11_, d7, d10);
        tessellator.func_78374_a(p_78591_3_, p_78591_7_, p_78591_11_, d9, d10);
    }

    public void func_78607_b(double p_78607_1_, double p_78607_3_, double p_78607_5_, double p_78607_7_, double p_78607_9_, double p_78607_11_, float p_78607_13_, double p_78607_14_)
    {
        Icon icon = BlockPistonBase.func_94496_b("piston_side");

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        Tessellator tessellator = Tessellator.field_78398_a;
        double d7 = (double)icon.func_94209_e();
        double d8 = (double)icon.func_94206_g();
        double d9 = (double)icon.func_94214_a(p_78607_14_);
        double d10 = (double)icon.func_94207_b(4.0D);
        tessellator.func_78386_a(p_78607_13_, p_78607_13_, p_78607_13_);
        tessellator.func_78374_a(p_78607_1_, p_78607_5_, p_78607_11_, d9, d8);
        tessellator.func_78374_a(p_78607_1_, p_78607_5_, p_78607_9_, d7, d8);
        tessellator.func_78374_a(p_78607_3_, p_78607_7_, p_78607_9_, d7, d10);
        tessellator.func_78374_a(p_78607_3_, p_78607_7_, p_78607_11_, d9, d10);
    }

    public void func_78571_c(double p_78571_1_, double p_78571_3_, double p_78571_5_, double p_78571_7_, double p_78571_9_, double p_78571_11_, float p_78571_13_, double p_78571_14_)
    {
        Icon icon = BlockPistonBase.func_94496_b("piston_side");

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        Tessellator tessellator = Tessellator.field_78398_a;
        double d7 = (double)icon.func_94209_e();
        double d8 = (double)icon.func_94206_g();
        double d9 = (double)icon.func_94214_a(p_78571_14_);
        double d10 = (double)icon.func_94207_b(4.0D);
        tessellator.func_78386_a(p_78571_13_, p_78571_13_, p_78571_13_);
        tessellator.func_78374_a(p_78571_3_, p_78571_5_, p_78571_9_, d9, d8);
        tessellator.func_78374_a(p_78571_1_, p_78571_5_, p_78571_9_, d7, d8);
        tessellator.func_78374_a(p_78571_1_, p_78571_7_, p_78571_11_, d7, d10);
        tessellator.func_78374_a(p_78571_3_, p_78571_7_, p_78571_11_, d9, d10);
    }

    public void func_78587_a(Block p_78587_1_, int p_78587_2_, int p_78587_3_, int p_78587_4_, boolean p_78587_5_)
    {
        this.field_78661_f = true;
        this.func_78608_c(p_78587_1_, p_78587_2_, p_78587_3_, p_78587_4_, p_78587_5_);
        this.field_78661_f = false;
    }

    public boolean func_78608_c(Block p_78608_1_, int p_78608_2_, int p_78608_3_, int p_78608_4_, boolean p_78608_5_)
    {
        int l = this.field_78669_a.func_72805_g(p_78608_2_, p_78608_3_, p_78608_4_);
        int i1 = BlockPistonExtension.func_72121_f(l);
        float f = 0.25F;
        float f1 = 0.375F;
        float f2 = 0.625F;
        float f3 = p_78608_1_.func_71870_f(this.field_78669_a, p_78608_2_, p_78608_3_, p_78608_4_);
        float f4 = p_78608_5_ ? 1.0F : 0.5F;
        double d0 = p_78608_5_ ? 16.0D : 8.0D;

        switch (i1)
        {
            case 0:
                this.field_78662_g = 3;
                this.field_78683_h = 3;
                this.field_78685_i = 3;
                this.field_78679_j = 3;
                this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);
                this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
                this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + f4), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), f3 * 0.8F, d0);
                this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + f4), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), f3 * 0.8F, d0);
                this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + f4), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), f3 * 0.6F, d0);
                this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + f4), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), f3 * 0.6F, d0);
                break;
            case 1:
                this.func_83020_a(0.0D, 0.75D, 0.0D, 1.0D, 1.0D, 1.0D);
                this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
                this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ - 0.25F + 1.0F - f4), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), f3 * 0.8F, d0);
                this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ - 0.25F + 1.0F - f4), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), f3 * 0.8F, d0);
                this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ - 0.25F + 1.0F - f4), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), f3 * 0.6F, d0);
                this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ - 0.25F + 1.0F - f4), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), f3 * 0.6F, d0);
                break;
            case 2:
                this.field_78685_i = 1;
                this.field_78679_j = 2;
                this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.25D);
                this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
                this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + f4), f3 * 0.6F, d0);
                this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + f4), f3 * 0.6F, d0);
                this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + f4), f3 * 0.5F, d0);
                this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + f4), f3, d0);
                break;
            case 3:
                this.field_78685_i = 2;
                this.field_78679_j = 1;
                this.field_78681_k = 3;
                this.field_78675_l = 3;
                this.func_83020_a(0.0D, 0.0D, 0.75D, 1.0D, 1.0D, 1.0D);
                this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
                this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ - 0.25F + 1.0F - f4), (double)((float)p_78608_4_ - 0.25F + 1.0F), f3 * 0.6F, d0);
                this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ - 0.25F + 1.0F - f4), (double)((float)p_78608_4_ - 0.25F + 1.0F), f3 * 0.6F, d0);
                this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ - 0.25F + 1.0F - f4), (double)((float)p_78608_4_ - 0.25F + 1.0F), f3 * 0.5F, d0);
                this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ - 0.25F + 1.0F - f4), (double)((float)p_78608_4_ - 0.25F + 1.0F), f3, d0);
                break;
            case 4:
                this.field_78662_g = 1;
                this.field_78683_h = 2;
                this.field_78681_k = 2;
                this.field_78675_l = 1;
                this.func_83020_a(0.0D, 0.0D, 0.0D, 0.25D, 1.0D, 1.0D);
                this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
                this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + f4), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), f3 * 0.5F, d0);
                this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + f4), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), f3, d0);
                this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + f4), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), f3 * 0.6F, d0);
                this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + f4), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), f3 * 0.6F, d0);
                break;
            case 5:
                this.field_78662_g = 2;
                this.field_78683_h = 1;
                this.field_78681_k = 1;
                this.field_78675_l = 2;
                this.func_83020_a(0.75D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
                this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
                this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - f4), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), f3 * 0.5F, d0);
                this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - f4), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), f3, d0);
                this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - f4), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), f3 * 0.6F, d0);
                this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - f4), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), f3 * 0.6F, d0);
        }

        this.field_78662_g = 0;
        this.field_78683_h = 0;
        this.field_78685_i = 0;
        this.field_78679_j = 0;
        this.field_78681_k = 0;
        this.field_78675_l = 0;
        this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        return true;
    }

    public boolean func_78594_e(Block p_78594_1_, int p_78594_2_, int p_78594_3_, int p_78594_4_)
    {
        int l = this.field_78669_a.func_72805_g(p_78594_2_, p_78594_3_, p_78594_4_);
        int i1 = l & 7;
        boolean flag = (l & 8) > 0;
        Tessellator tessellator = Tessellator.field_78398_a;
        boolean flag1 = this.func_94167_b();

        if (!flag1)
        {
            this.func_82774_a(this.func_94175_b(Block.field_71978_w));
        }

        float f = 0.25F;
        float f1 = 0.1875F;
        float f2 = 0.1875F;

        if (i1 == 5)
        {
            this.func_83020_a((double)(0.5F - f1), 0.0D, (double)(0.5F - f), (double)(0.5F + f1), (double)f2, (double)(0.5F + f));
        }
        else if (i1 == 6)
        {
            this.func_83020_a((double)(0.5F - f), 0.0D, (double)(0.5F - f1), (double)(0.5F + f), (double)f2, (double)(0.5F + f1));
        }
        else if (i1 == 4)
        {
            this.func_83020_a((double)(0.5F - f1), (double)(0.5F - f), (double)(1.0F - f2), (double)(0.5F + f1), (double)(0.5F + f), 1.0D);
        }
        else if (i1 == 3)
        {
            this.func_83020_a((double)(0.5F - f1), (double)(0.5F - f), 0.0D, (double)(0.5F + f1), (double)(0.5F + f), (double)f2);
        }
        else if (i1 == 2)
        {
            this.func_83020_a((double)(1.0F - f2), (double)(0.5F - f), (double)(0.5F - f1), 1.0D, (double)(0.5F + f), (double)(0.5F + f1));
        }
        else if (i1 == 1)
        {
            this.func_83020_a(0.0D, (double)(0.5F - f), (double)(0.5F - f1), (double)f2, (double)(0.5F + f), (double)(0.5F + f1));
        }
        else if (i1 == 0)
        {
            this.func_83020_a((double)(0.5F - f), (double)(1.0F - f2), (double)(0.5F - f1), (double)(0.5F + f), 1.0D, (double)(0.5F + f1));
        }
        else if (i1 == 7)
        {
            this.func_83020_a((double)(0.5F - f1), (double)(1.0F - f2), (double)(0.5F - f), (double)(0.5F + f1), 1.0D, (double)(0.5F + f));
        }

        this.func_78570_q(p_78594_1_, p_78594_2_, p_78594_3_, p_78594_4_);

        if (!flag1)
        {
            this.func_78595_a();
        }

        tessellator.func_78380_c(p_78594_1_.func_71874_e(this.field_78669_a, p_78594_2_, p_78594_3_, p_78594_4_));
        float f3 = 1.0F;

        if (Block.field_71984_q[p_78594_1_.field_71990_ca] > 0)
        {
            f3 = 1.0F;
        }

        tessellator.func_78386_a(f3, f3, f3);
        Icon icon = this.func_94173_a(p_78594_1_, 0);

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        double d0 = (double)icon.func_94209_e();
        double d1 = (double)icon.func_94206_g();
        double d2 = (double)icon.func_94212_f();
        double d3 = (double)icon.func_94210_h();
        Vec3[] avec3 = new Vec3[8];
        float f4 = 0.0625F;
        float f5 = 0.0625F;
        float f6 = 0.625F;
        avec3[0] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f4), 0.0D, (double)(-f5));
        avec3[1] = this.field_78669_a.func_82732_R().func_72345_a((double)f4, 0.0D, (double)(-f5));
        avec3[2] = this.field_78669_a.func_82732_R().func_72345_a((double)f4, 0.0D, (double)f5);
        avec3[3] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f4), 0.0D, (double)f5);
        avec3[4] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f4), (double)f6, (double)(-f5));
        avec3[5] = this.field_78669_a.func_82732_R().func_72345_a((double)f4, (double)f6, (double)(-f5));
        avec3[6] = this.field_78669_a.func_82732_R().func_72345_a((double)f4, (double)f6, (double)f5);
        avec3[7] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f4), (double)f6, (double)f5);

        for (int j1 = 0; j1 < 8; ++j1)
        {
            if (flag)
            {
                avec3[j1].field_72449_c -= 0.0625D;
                avec3[j1].func_72440_a(((float)Math.PI * 2F / 9F));
            }
            else
            {
                avec3[j1].field_72449_c += 0.0625D;
                avec3[j1].func_72440_a(-((float)Math.PI * 2F / 9F));
            }

            if (i1 == 0 || i1 == 7)
            {
                avec3[j1].func_72446_c((float)Math.PI);
            }

            if (i1 == 6 || i1 == 0)
            {
                avec3[j1].func_72442_b(((float)Math.PI / 2F));
            }

            if (i1 > 0 && i1 < 5)
            {
                avec3[j1].field_72448_b -= 0.375D;
                avec3[j1].func_72440_a(((float)Math.PI / 2F));

                if (i1 == 4)
                {
                    avec3[j1].func_72442_b(0.0F);
                }

                if (i1 == 3)
                {
                    avec3[j1].func_72442_b((float)Math.PI);
                }

                if (i1 == 2)
                {
                    avec3[j1].func_72442_b(((float)Math.PI / 2F));
                }

                if (i1 == 1)
                {
                    avec3[j1].func_72442_b(-((float)Math.PI / 2F));
                }

                avec3[j1].field_72450_a += (double)p_78594_2_ + 0.5D;
                avec3[j1].field_72448_b += (double)((float)p_78594_3_ + 0.5F);
                avec3[j1].field_72449_c += (double)p_78594_4_ + 0.5D;
            }
            else if (i1 != 0 && i1 != 7)
            {
                avec3[j1].field_72450_a += (double)p_78594_2_ + 0.5D;
                avec3[j1].field_72448_b += (double)((float)p_78594_3_ + 0.125F);
                avec3[j1].field_72449_c += (double)p_78594_4_ + 0.5D;
            }
            else
            {
                avec3[j1].field_72450_a += (double)p_78594_2_ + 0.5D;
                avec3[j1].field_72448_b += (double)((float)p_78594_3_ + 0.875F);
                avec3[j1].field_72449_c += (double)p_78594_4_ + 0.5D;
            }
        }

        Vec3 vec3 = null;
        Vec3 vec31 = null;
        Vec3 vec32 = null;
        Vec3 vec33 = null;

        for (int k1 = 0; k1 < 6; ++k1)
        {
            if (k1 == 0)
            {
                d0 = (double)icon.func_94214_a(7.0D);
                d1 = (double)icon.func_94207_b(6.0D);
                d2 = (double)icon.func_94214_a(9.0D);
                d3 = (double)icon.func_94207_b(8.0D);
            }
            else if (k1 == 2)
            {
                d0 = (double)icon.func_94214_a(7.0D);
                d1 = (double)icon.func_94207_b(6.0D);
                d2 = (double)icon.func_94214_a(9.0D);
                d3 = (double)icon.func_94210_h();
            }

            if (k1 == 0)
            {
                vec3 = avec3[0];
                vec31 = avec3[1];
                vec32 = avec3[2];
                vec33 = avec3[3];
            }
            else if (k1 == 1)
            {
                vec3 = avec3[7];
                vec31 = avec3[6];
                vec32 = avec3[5];
                vec33 = avec3[4];
            }
            else if (k1 == 2)
            {
                vec3 = avec3[1];
                vec31 = avec3[0];
                vec32 = avec3[4];
                vec33 = avec3[5];
            }
            else if (k1 == 3)
            {
                vec3 = avec3[2];
                vec31 = avec3[1];
                vec32 = avec3[5];
                vec33 = avec3[6];
            }
            else if (k1 == 4)
            {
                vec3 = avec3[3];
                vec31 = avec3[2];
                vec32 = avec3[6];
                vec33 = avec3[7];
            }
            else if (k1 == 5)
            {
                vec3 = avec3[0];
                vec31 = avec3[3];
                vec32 = avec3[7];
                vec33 = avec3[4];
            }

            tessellator.func_78374_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, d0, d3);
            tessellator.func_78374_a(vec31.field_72450_a, vec31.field_72448_b, vec31.field_72449_c, d2, d3);
            tessellator.func_78374_a(vec32.field_72450_a, vec32.field_72448_b, vec32.field_72449_c, d2, d1);
            tessellator.func_78374_a(vec33.field_72450_a, vec33.field_72448_b, vec33.field_72449_c, d0, d1);
        }

        return true;
    }

    public boolean func_78577_f(Block p_78577_1_, int p_78577_2_, int p_78577_3_, int p_78577_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int l = this.field_78669_a.func_72805_g(p_78577_2_, p_78577_3_, p_78577_4_);
        int i1 = l & 3;
        boolean flag = (l & 4) == 4;
        boolean flag1 = (l & 8) == 8;
        boolean flag2 = !this.field_78669_a.func_72797_t(p_78577_2_, p_78577_3_ - 1, p_78577_4_);
        boolean flag3 = this.func_94167_b();

        if (!flag3)
        {
            this.func_82774_a(this.func_94175_b(Block.field_71988_x));
        }

        float f = 0.25F;
        float f1 = 0.125F;
        float f2 = 0.125F;
        float f3 = 0.3F - f;
        float f4 = 0.3F + f;

        if (i1 == 2)
        {
            this.func_83020_a((double)(0.5F - f1), (double)f3, (double)(1.0F - f2), (double)(0.5F + f1), (double)f4, 1.0D);
        }
        else if (i1 == 0)
        {
            this.func_83020_a((double)(0.5F - f1), (double)f3, 0.0D, (double)(0.5F + f1), (double)f4, (double)f2);
        }
        else if (i1 == 1)
        {
            this.func_83020_a((double)(1.0F - f2), (double)f3, (double)(0.5F - f1), 1.0D, (double)f4, (double)(0.5F + f1));
        }
        else if (i1 == 3)
        {
            this.func_83020_a(0.0D, (double)f3, (double)(0.5F - f1), (double)f2, (double)f4, (double)(0.5F + f1));
        }

        this.func_78570_q(p_78577_1_, p_78577_2_, p_78577_3_, p_78577_4_);

        if (!flag3)
        {
            this.func_78595_a();
        }

        tessellator.func_78380_c(p_78577_1_.func_71874_e(this.field_78669_a, p_78577_2_, p_78577_3_, p_78577_4_));
        float f5 = 1.0F;

        if (Block.field_71984_q[p_78577_1_.field_71990_ca] > 0)
        {
            f5 = 1.0F;
        }

        tessellator.func_78386_a(f5, f5, f5);
        Icon icon = this.func_94173_a(p_78577_1_, 0);

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        double d0 = (double)icon.func_94209_e();
        double d1 = (double)icon.func_94206_g();
        double d2 = (double)icon.func_94212_f();
        double d3 = (double)icon.func_94210_h();
        Vec3[] avec3 = new Vec3[8];
        float f6 = 0.046875F;
        float f7 = 0.046875F;
        float f8 = 0.3125F;
        avec3[0] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f6), 0.0D, (double)(-f7));
        avec3[1] = this.field_78669_a.func_82732_R().func_72345_a((double)f6, 0.0D, (double)(-f7));
        avec3[2] = this.field_78669_a.func_82732_R().func_72345_a((double)f6, 0.0D, (double)f7);
        avec3[3] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f6), 0.0D, (double)f7);
        avec3[4] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f6), (double)f8, (double)(-f7));
        avec3[5] = this.field_78669_a.func_82732_R().func_72345_a((double)f6, (double)f8, (double)(-f7));
        avec3[6] = this.field_78669_a.func_82732_R().func_72345_a((double)f6, (double)f8, (double)f7);
        avec3[7] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f6), (double)f8, (double)f7);

        for (int j1 = 0; j1 < 8; ++j1)
        {
            avec3[j1].field_72449_c += 0.0625D;

            if (flag1)
            {
                avec3[j1].func_72440_a(0.5235988F);
                avec3[j1].field_72448_b -= 0.4375D;
            }
            else if (flag)
            {
                avec3[j1].func_72440_a(0.08726647F);
                avec3[j1].field_72448_b -= 0.4375D;
            }
            else
            {
                avec3[j1].func_72440_a(-((float)Math.PI * 2F / 9F));
                avec3[j1].field_72448_b -= 0.375D;
            }

            avec3[j1].func_72440_a(((float)Math.PI / 2F));

            if (i1 == 2)
            {
                avec3[j1].func_72442_b(0.0F);
            }

            if (i1 == 0)
            {
                avec3[j1].func_72442_b((float)Math.PI);
            }

            if (i1 == 1)
            {
                avec3[j1].func_72442_b(((float)Math.PI / 2F));
            }

            if (i1 == 3)
            {
                avec3[j1].func_72442_b(-((float)Math.PI / 2F));
            }

            avec3[j1].field_72450_a += (double)p_78577_2_ + 0.5D;
            avec3[j1].field_72448_b += (double)((float)p_78577_3_ + 0.3125F);
            avec3[j1].field_72449_c += (double)p_78577_4_ + 0.5D;
        }

        Vec3 vec3 = null;
        Vec3 vec31 = null;
        Vec3 vec32 = null;
        Vec3 vec33 = null;
        byte b0 = 7;
        byte b1 = 9;
        byte b2 = 9;
        byte b3 = 16;

        for (int k1 = 0; k1 < 6; ++k1)
        {
            if (k1 == 0)
            {
                vec3 = avec3[0];
                vec31 = avec3[1];
                vec32 = avec3[2];
                vec33 = avec3[3];
                d0 = (double)icon.func_94214_a((double)b0);
                d1 = (double)icon.func_94207_b((double)b2);
                d2 = (double)icon.func_94214_a((double)b1);
                d3 = (double)icon.func_94207_b((double)(b2 + 2));
            }
            else if (k1 == 1)
            {
                vec3 = avec3[7];
                vec31 = avec3[6];
                vec32 = avec3[5];
                vec33 = avec3[4];
            }
            else if (k1 == 2)
            {
                vec3 = avec3[1];
                vec31 = avec3[0];
                vec32 = avec3[4];
                vec33 = avec3[5];
                d0 = (double)icon.func_94214_a((double)b0);
                d1 = (double)icon.func_94207_b((double)b2);
                d2 = (double)icon.func_94214_a((double)b1);
                d3 = (double)icon.func_94207_b((double)b3);
            }
            else if (k1 == 3)
            {
                vec3 = avec3[2];
                vec31 = avec3[1];
                vec32 = avec3[5];
                vec33 = avec3[6];
            }
            else if (k1 == 4)
            {
                vec3 = avec3[3];
                vec31 = avec3[2];
                vec32 = avec3[6];
                vec33 = avec3[7];
            }
            else if (k1 == 5)
            {
                vec3 = avec3[0];
                vec31 = avec3[3];
                vec32 = avec3[7];
                vec33 = avec3[4];
            }

            tessellator.func_78374_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, d0, d3);
            tessellator.func_78374_a(vec31.field_72450_a, vec31.field_72448_b, vec31.field_72449_c, d2, d3);
            tessellator.func_78374_a(vec32.field_72450_a, vec32.field_72448_b, vec32.field_72449_c, d2, d1);
            tessellator.func_78374_a(vec33.field_72450_a, vec33.field_72448_b, vec33.field_72449_c, d0, d1);
        }

        float f9 = 0.09375F;
        float f10 = 0.09375F;
        float f11 = 0.03125F;
        avec3[0] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f9), 0.0D, (double)(-f10));
        avec3[1] = this.field_78669_a.func_82732_R().func_72345_a((double)f9, 0.0D, (double)(-f10));
        avec3[2] = this.field_78669_a.func_82732_R().func_72345_a((double)f9, 0.0D, (double)f10);
        avec3[3] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f9), 0.0D, (double)f10);
        avec3[4] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f9), (double)f11, (double)(-f10));
        avec3[5] = this.field_78669_a.func_82732_R().func_72345_a((double)f9, (double)f11, (double)(-f10));
        avec3[6] = this.field_78669_a.func_82732_R().func_72345_a((double)f9, (double)f11, (double)f10);
        avec3[7] = this.field_78669_a.func_82732_R().func_72345_a((double)(-f9), (double)f11, (double)f10);

        for (int l1 = 0; l1 < 8; ++l1)
        {
            avec3[l1].field_72449_c += 0.21875D;

            if (flag1)
            {
                avec3[l1].field_72448_b -= 0.09375D;
                avec3[l1].field_72449_c -= 0.1625D;
                avec3[l1].func_72440_a(0.0F);
            }
            else if (flag)
            {
                avec3[l1].field_72448_b += 0.015625D;
                avec3[l1].field_72449_c -= 0.171875D;
                avec3[l1].func_72440_a(0.17453294F);
            }
            else
            {
                avec3[l1].func_72440_a(0.87266463F);
            }

            if (i1 == 2)
            {
                avec3[l1].func_72442_b(0.0F);
            }

            if (i1 == 0)
            {
                avec3[l1].func_72442_b((float)Math.PI);
            }

            if (i1 == 1)
            {
                avec3[l1].func_72442_b(((float)Math.PI / 2F));
            }

            if (i1 == 3)
            {
                avec3[l1].func_72442_b(-((float)Math.PI / 2F));
            }

            avec3[l1].field_72450_a += (double)p_78577_2_ + 0.5D;
            avec3[l1].field_72448_b += (double)((float)p_78577_3_ + 0.3125F);
            avec3[l1].field_72449_c += (double)p_78577_4_ + 0.5D;
        }

        byte b4 = 5;
        byte b5 = 11;
        byte b6 = 3;
        byte b7 = 9;

        for (int i2 = 0; i2 < 6; ++i2)
        {
            if (i2 == 0)
            {
                vec3 = avec3[0];
                vec31 = avec3[1];
                vec32 = avec3[2];
                vec33 = avec3[3];
                d0 = (double)icon.func_94214_a((double)b4);
                d1 = (double)icon.func_94207_b((double)b6);
                d2 = (double)icon.func_94214_a((double)b5);
                d3 = (double)icon.func_94207_b((double)b7);
            }
            else if (i2 == 1)
            {
                vec3 = avec3[7];
                vec31 = avec3[6];
                vec32 = avec3[5];
                vec33 = avec3[4];
            }
            else if (i2 == 2)
            {
                vec3 = avec3[1];
                vec31 = avec3[0];
                vec32 = avec3[4];
                vec33 = avec3[5];
                d0 = (double)icon.func_94214_a((double)b4);
                d1 = (double)icon.func_94207_b((double)b6);
                d2 = (double)icon.func_94214_a((double)b5);
                d3 = (double)icon.func_94207_b((double)(b6 + 2));
            }
            else if (i2 == 3)
            {
                vec3 = avec3[2];
                vec31 = avec3[1];
                vec32 = avec3[5];
                vec33 = avec3[6];
            }
            else if (i2 == 4)
            {
                vec3 = avec3[3];
                vec31 = avec3[2];
                vec32 = avec3[6];
                vec33 = avec3[7];
            }
            else if (i2 == 5)
            {
                vec3 = avec3[0];
                vec31 = avec3[3];
                vec32 = avec3[7];
                vec33 = avec3[4];
            }

            tessellator.func_78374_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, d0, d3);
            tessellator.func_78374_a(vec31.field_72450_a, vec31.field_72448_b, vec31.field_72449_c, d2, d3);
            tessellator.func_78374_a(vec32.field_72450_a, vec32.field_72448_b, vec32.field_72449_c, d2, d1);
            tessellator.func_78374_a(vec33.field_72450_a, vec33.field_72448_b, vec33.field_72449_c, d0, d1);
        }

        if (flag)
        {
            double d4 = avec3[0].field_72448_b;
            float f12 = 0.03125F;
            float f13 = 0.5F - f12 / 2.0F;
            float f14 = f13 + f12;
            Icon icon1 = this.func_94175_b(Block.field_72062_bU);
            double d5 = (double)icon.func_94209_e();
            double d6 = (double)icon.func_94207_b(flag ? 2.0D : 0.0D);
            double d7 = (double)icon.func_94212_f();
            double d8 = (double)icon.func_94207_b(flag ? 4.0D : 2.0D);
            double d9 = (double)(flag2 ? 3.5F : 1.5F) / 16.0D;
            f5 = p_78577_1_.func_71870_f(this.field_78669_a, p_78577_2_, p_78577_3_, p_78577_4_) * 0.75F;
            tessellator.func_78386_a(f5, f5, f5);

            if (i1 == 2)
            {
                tessellator.func_78374_a((double)((float)p_78577_2_ + f13), (double)p_78577_3_ + d9, (double)p_78577_4_ + 0.25D, d5, d6);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f14), (double)p_78577_3_ + d9, (double)p_78577_4_ + 0.25D, d5, d8);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f14), (double)p_78577_3_ + d9, (double)p_78577_4_, d7, d8);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f13), (double)p_78577_3_ + d9, (double)p_78577_4_, d7, d6);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f13), d4, (double)p_78577_4_ + 0.5D, d5, d6);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f14), d4, (double)p_78577_4_ + 0.5D, d5, d8);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f14), (double)p_78577_3_ + d9, (double)p_78577_4_ + 0.25D, d7, d8);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f13), (double)p_78577_3_ + d9, (double)p_78577_4_ + 0.25D, d7, d6);
            }
            else if (i1 == 0)
            {
                tessellator.func_78374_a((double)((float)p_78577_2_ + f13), (double)p_78577_3_ + d9, (double)p_78577_4_ + 0.75D, d5, d6);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f14), (double)p_78577_3_ + d9, (double)p_78577_4_ + 0.75D, d5, d8);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f14), d4, (double)p_78577_4_ + 0.5D, d7, d8);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f13), d4, (double)p_78577_4_ + 0.5D, d7, d6);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f13), (double)p_78577_3_ + d9, (double)(p_78577_4_ + 1), d5, d6);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f14), (double)p_78577_3_ + d9, (double)(p_78577_4_ + 1), d5, d8);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f14), (double)p_78577_3_ + d9, (double)p_78577_4_ + 0.75D, d7, d8);
                tessellator.func_78374_a((double)((float)p_78577_2_ + f13), (double)p_78577_3_ + d9, (double)p_78577_4_ + 0.75D, d7, d6);
            }
            else if (i1 == 1)
            {
                tessellator.func_78374_a((double)p_78577_2_, (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f14), d5, d8);
                tessellator.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f14), d7, d8);
                tessellator.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f13), d7, d6);
                tessellator.func_78374_a((double)p_78577_2_, (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f13), d5, d6);
                tessellator.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f14), d5, d8);
                tessellator.func_78374_a((double)p_78577_2_ + 0.5D, d4, (double)((float)p_78577_4_ + f14), d7, d8);
                tessellator.func_78374_a((double)p_78577_2_ + 0.5D, d4, (double)((float)p_78577_4_ + f13), d7, d6);
                tessellator.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f13), d5, d6);
            }
            else
            {
                tessellator.func_78374_a((double)p_78577_2_ + 0.5D, d4, (double)((float)p_78577_4_ + f14), d5, d8);
                tessellator.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f14), d7, d8);
                tessellator.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f13), d7, d6);
                tessellator.func_78374_a((double)p_78577_2_ + 0.5D, d4, (double)((float)p_78577_4_ + f13), d5, d6);
                tessellator.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f14), d5, d8);
                tessellator.func_78374_a((double)(p_78577_2_ + 1), (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f14), d7, d8);
                tessellator.func_78374_a((double)(p_78577_2_ + 1), (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f13), d7, d6);
                tessellator.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + d9, (double)((float)p_78577_4_ + f13), d5, d6);
            }
        }

        return true;
    }

    public boolean func_78619_g(Block p_78619_1_, int p_78619_2_, int p_78619_3_, int p_78619_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        Icon icon = this.func_94173_a(p_78619_1_, 0);
        int l = this.field_78669_a.func_72805_g(p_78619_2_, p_78619_3_, p_78619_4_);
        boolean flag = (l & 4) == 4;
        boolean flag1 = (l & 2) == 2;

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        tessellator.func_78380_c(p_78619_1_.func_71874_e(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_));
        float f = p_78619_1_.func_71870_f(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_) * 0.75F;
        tessellator.func_78386_a(f, f, f);
        double d0 = (double)icon.func_94209_e();
        double d1 = (double)icon.func_94207_b(flag ? 2.0D : 0.0D);
        double d2 = (double)icon.func_94212_f();
        double d3 = (double)icon.func_94207_b(flag ? 4.0D : 2.0D);
        double d4 = (double)(flag1 ? 3.5F : 1.5F) / 16.0D;
        boolean flag2 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, l, 1);
        boolean flag3 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, l, 3);
        boolean flag4 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, l, 2);
        boolean flag5 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, l, 0);
        float f1 = 0.03125F;
        float f2 = 0.5F - f1 / 2.0F;
        float f3 = f2 + f1;

        if (!flag4 && !flag3 && !flag5 && !flag2)
        {
            flag4 = true;
            flag5 = true;
        }

        if (flag4)
        {
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d0, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d0, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_, d2, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_, d2, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_, d2, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_, d2, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d0, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d0, d1);
        }

        if (flag4 || flag5 && !flag3 && !flag2)
        {
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d0, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d0, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d2, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d2, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d2, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.25D, d2, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d0, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d0, d1);
        }

        if (flag5 || flag4 && !flag3 && !flag2)
        {
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d0, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d0, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d2, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d2, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d2, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.5D, d2, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d0, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d0, d1);
        }

        if (flag5)
        {
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)(p_78619_4_ + 1), d0, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)(p_78619_4_ + 1), d0, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d2, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d2, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d2, d1);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)p_78619_4_ + 0.75D, d2, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f3), (double)p_78619_3_ + d4, (double)(p_78619_4_ + 1), d0, d3);
            tessellator.func_78374_a((double)((float)p_78619_2_ + f2), (double)p_78619_3_ + d4, (double)(p_78619_4_ + 1), d0, d1);
        }

        if (flag2)
        {
            tessellator.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d0, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d2, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d2, d1);
            tessellator.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d0, d1);
            tessellator.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d0, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d2, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d2, d3);
            tessellator.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d0, d3);
        }

        if (flag2 || flag3 && !flag4 && !flag5)
        {
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d0, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d2, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d2, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d0, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d0, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d2, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d2, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d0, d3);
        }

        if (flag3 || flag2 && !flag4 && !flag5)
        {
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d0, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d2, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d2, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d0, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d0, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d2, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d2, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d0, d3);
        }

        if (flag3)
        {
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d0, d3);
            tessellator.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d2, d3);
            tessellator.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d2, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d0, d1);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d0, d1);
            tessellator.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f2), d2, d1);
            tessellator.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d2, d3);
            tessellator.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + d4, (double)((float)p_78619_4_ + f3), d0, d3);
        }

        return true;
    }

    public boolean func_78590_h(BlockFire p_78590_1_, int p_78590_2_, int p_78590_3_, int p_78590_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        Icon icon = p_78590_1_.func_94438_c(0);
        Icon icon1 = p_78590_1_.func_94438_c(1);
        Icon icon2 = icon;

        if (this.func_94167_b())
        {
            icon2 = this.field_78664_d;
        }

        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        tessellator.func_78380_c(p_78590_1_.func_71874_e(this.field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_));
        double d0 = (double)icon2.func_94209_e();
        double d1 = (double)icon2.func_94206_g();
        double d2 = (double)icon2.func_94212_f();
        double d3 = (double)icon2.func_94210_h();
        float f = 1.4F;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;

        if (!this.field_78669_a.func_72797_t(p_78590_2_, p_78590_3_ - 1, p_78590_4_) && !Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_ - 1, p_78590_4_))
        {
            float f1 = 0.2F;
            float f2 = 0.0625F;

            if ((p_78590_2_ + p_78590_3_ + p_78590_4_ & 1) == 1)
            {
                d0 = (double)icon1.func_94209_e();
                d1 = (double)icon1.func_94206_g();
                d2 = (double)icon1.func_94212_f();
                d3 = (double)icon1.func_94210_h();
            }

            if ((p_78590_2_ / 2 + p_78590_3_ / 2 + p_78590_4_ / 2 & 1) == 1)
            {
                d5 = d2;
                d2 = d0;
                d0 = d5;
            }

            if (Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_ - 1, p_78590_3_, p_78590_4_))
            {
                tessellator.func_78374_a((double)((float)p_78590_2_ + f1), (double)((float)p_78590_3_ + f + f2), (double)(p_78590_4_ + 1), d2, d1);
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 1), d2, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 0), d0, d3);
                tessellator.func_78374_a((double)((float)p_78590_2_ + f1), (double)((float)p_78590_3_ + f + f2), (double)(p_78590_4_ + 0), d0, d1);
                tessellator.func_78374_a((double)((float)p_78590_2_ + f1), (double)((float)p_78590_3_ + f + f2), (double)(p_78590_4_ + 0), d0, d1);
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 0), d0, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 1), d2, d3);
                tessellator.func_78374_a((double)((float)p_78590_2_ + f1), (double)((float)p_78590_3_ + f + f2), (double)(p_78590_4_ + 1), d2, d1);
            }

            if (Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_ + 1, p_78590_3_, p_78590_4_))
            {
                tessellator.func_78374_a((double)((float)(p_78590_2_ + 1) - f1), (double)((float)p_78590_3_ + f + f2), (double)(p_78590_4_ + 0), d0, d1);
                tessellator.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 0), d0, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 1), d2, d3);
                tessellator.func_78374_a((double)((float)(p_78590_2_ + 1) - f1), (double)((float)p_78590_3_ + f + f2), (double)(p_78590_4_ + 1), d2, d1);
                tessellator.func_78374_a((double)((float)(p_78590_2_ + 1) - f1), (double)((float)p_78590_3_ + f + f2), (double)(p_78590_4_ + 1), d2, d1);
                tessellator.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 1), d2, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 0), d0, d3);
                tessellator.func_78374_a((double)((float)(p_78590_2_ + 1) - f1), (double)((float)p_78590_3_ + f + f2), (double)(p_78590_4_ + 0), d0, d1);
            }

            if (Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_ - 1))
            {
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + f + f2), (double)((float)p_78590_4_ + f1), d2, d1);
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 0), d2, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 0), d0, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + f + f2), (double)((float)p_78590_4_ + f1), d0, d1);
                tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + f + f2), (double)((float)p_78590_4_ + f1), d0, d1);
                tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 0), d0, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 0), d2, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + f + f2), (double)((float)p_78590_4_ + f1), d2, d1);
            }

            if (Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_ + 1))
            {
                tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + f + f2), (double)((float)(p_78590_4_ + 1) - f1), d0, d1);
                tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 1 - 0), d0, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 1 - 0), d2, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + f + f2), (double)((float)(p_78590_4_ + 1) - f1), d2, d1);
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + f + f2), (double)((float)(p_78590_4_ + 1) - f1), d2, d1);
                tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 1 - 0), d2, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + f2), (double)(p_78590_4_ + 1 - 0), d0, d3);
                tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + f + f2), (double)((float)(p_78590_4_ + 1) - f1), d0, d1);
            }

            if (Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_ + 1, p_78590_4_))
            {
                d5 = (double)p_78590_2_ + 0.5D + 0.5D;
                d6 = (double)p_78590_2_ + 0.5D - 0.5D;
                d7 = (double)p_78590_4_ + 0.5D + 0.5D;
                d8 = (double)p_78590_4_ + 0.5D - 0.5D;
                d9 = (double)p_78590_2_ + 0.5D - 0.5D;
                d10 = (double)p_78590_2_ + 0.5D + 0.5D;
                d4 = (double)p_78590_4_ + 0.5D - 0.5D;
                double d11 = (double)p_78590_4_ + 0.5D + 0.5D;
                d0 = (double)icon.func_94209_e();
                d1 = (double)icon.func_94206_g();
                d2 = (double)icon.func_94212_f();
                d3 = (double)icon.func_94210_h();
                ++p_78590_3_;
                f = -0.2F;

                if ((p_78590_2_ + p_78590_3_ + p_78590_4_ & 1) == 0)
                {
                    tessellator.func_78374_a(d9, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 0), d2, d1);
                    tessellator.func_78374_a(d5, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), d2, d3);
                    tessellator.func_78374_a(d5, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), d0, d3);
                    tessellator.func_78374_a(d9, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 1), d0, d1);
                    d0 = (double)icon1.func_94209_e();
                    d1 = (double)icon1.func_94206_g();
                    d2 = (double)icon1.func_94212_f();
                    d3 = (double)icon1.func_94210_h();
                    tessellator.func_78374_a(d10, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 1), d2, d1);
                    tessellator.func_78374_a(d6, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), d2, d3);
                    tessellator.func_78374_a(d6, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), d0, d3);
                    tessellator.func_78374_a(d10, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 0), d0, d1);
                }
                else
                {
                    tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + f), d11, d2, d1);
                    tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), d8, d2, d3);
                    tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), d8, d0, d3);
                    tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + f), d11, d0, d1);
                    d0 = (double)icon1.func_94209_e();
                    d1 = (double)icon1.func_94206_g();
                    d2 = (double)icon1.func_94212_f();
                    d3 = (double)icon1.func_94210_h();
                    tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + f), d4, d2, d1);
                    tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), d7, d2, d3);
                    tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), d7, d0, d3);
                    tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + f), d4, d0, d1);
                }
            }
        }
        else
        {
            double d12 = (double)p_78590_2_ + 0.5D + 0.2D;
            d5 = (double)p_78590_2_ + 0.5D - 0.2D;
            d6 = (double)p_78590_4_ + 0.5D + 0.2D;
            d7 = (double)p_78590_4_ + 0.5D - 0.2D;
            d8 = (double)p_78590_2_ + 0.5D - 0.3D;
            d9 = (double)p_78590_2_ + 0.5D + 0.3D;
            d10 = (double)p_78590_4_ + 0.5D - 0.3D;
            d4 = (double)p_78590_4_ + 0.5D + 0.3D;
            tessellator.func_78374_a(d8, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 1), d2, d1);
            tessellator.func_78374_a(d12, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), d2, d3);
            tessellator.func_78374_a(d12, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), d0, d3);
            tessellator.func_78374_a(d8, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 0), d0, d1);
            tessellator.func_78374_a(d9, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 0), d2, d1);
            tessellator.func_78374_a(d5, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), d2, d3);
            tessellator.func_78374_a(d5, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), d0, d3);
            tessellator.func_78374_a(d9, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 1), d0, d1);
            d0 = (double)icon1.func_94209_e();
            d1 = (double)icon1.func_94206_g();
            d2 = (double)icon1.func_94212_f();
            d3 = (double)icon1.func_94210_h();
            tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + f), d4, d2, d1);
            tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), d7, d2, d3);
            tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), d7, d0, d3);
            tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + f), d4, d0, d1);
            tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + f), d10, d2, d1);
            tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), d6, d2, d3);
            tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), d6, d0, d3);
            tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + f), d10, d0, d1);
            d12 = (double)p_78590_2_ + 0.5D - 0.5D;
            d5 = (double)p_78590_2_ + 0.5D + 0.5D;
            d6 = (double)p_78590_4_ + 0.5D - 0.5D;
            d7 = (double)p_78590_4_ + 0.5D + 0.5D;
            d8 = (double)p_78590_2_ + 0.5D - 0.4D;
            d9 = (double)p_78590_2_ + 0.5D + 0.4D;
            d10 = (double)p_78590_4_ + 0.5D - 0.4D;
            d4 = (double)p_78590_4_ + 0.5D + 0.4D;
            tessellator.func_78374_a(d8, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 0), d0, d1);
            tessellator.func_78374_a(d12, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), d0, d3);
            tessellator.func_78374_a(d12, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), d2, d3);
            tessellator.func_78374_a(d8, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 1), d2, d1);
            tessellator.func_78374_a(d9, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 1), d0, d1);
            tessellator.func_78374_a(d5, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), d0, d3);
            tessellator.func_78374_a(d5, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), d2, d3);
            tessellator.func_78374_a(d9, (double)((float)p_78590_3_ + f), (double)(p_78590_4_ + 0), d2, d1);
            d0 = (double)icon.func_94209_e();
            d1 = (double)icon.func_94206_g();
            d2 = (double)icon.func_94212_f();
            d3 = (double)icon.func_94210_h();
            tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + f), d4, d0, d1);
            tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), d7, d0, d3);
            tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), d7, d2, d3);
            tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + f), d4, d2, d1);
            tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + f), d10, d0, d1);
            tessellator.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), d6, d0, d3);
            tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), d6, d2, d3);
            tessellator.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + f), d10, d2, d1);
        }

        return true;
    }

    public boolean func_78589_i(Block p_78589_1_, int p_78589_2_, int p_78589_3_, int p_78589_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int l = this.field_78669_a.func_72805_g(p_78589_2_, p_78589_3_, p_78589_4_);
        Icon icon = BlockRedstoneWire.func_94409_b("cross");
        Icon icon1 = BlockRedstoneWire.func_94409_b("line");
        Icon icon2 = BlockRedstoneWire.func_94409_b("cross_overlay");
        Icon icon3 = BlockRedstoneWire.func_94409_b("line_overlay");
        tessellator.func_78380_c(p_78589_1_.func_71874_e(this.field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_));
        float f = 1.0F;
        float f1 = (float)l / 15.0F;
        float f2 = f1 * 0.6F + 0.4F;

        if (l == 0)
        {
            f2 = 0.3F;
        }

        float f3 = f1 * f1 * 0.7F - 0.5F;
        float f4 = f1 * f1 * 0.6F - 0.7F;

        if (f3 < 0.0F)
        {
            f3 = 0.0F;
        }

        if (f4 < 0.0F)
        {
            f4 = 0.0F;
        }

        tessellator.func_78386_a(f2, f3, f4);
        double d0 = 0.015625D;
        double d1 = 0.015625D;
        boolean flag = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ - 1, p_78589_3_, p_78589_4_, 1) || !this.field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ - 1, p_78589_3_ - 1, p_78589_4_, -1);
        boolean flag1 = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ + 1, p_78589_3_, p_78589_4_, 3) || !this.field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ + 1, p_78589_3_ - 1, p_78589_4_, -1);
        boolean flag2 = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_ - 1, 2) || !this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ - 1, p_78589_4_ - 1, -1);
        boolean flag3 = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_ + 1, 0) || !this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ - 1, p_78589_4_ + 1, -1);

        if (!this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_ + 1, p_78589_4_))
        {
            if (this.field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ - 1, p_78589_3_ + 1, p_78589_4_, -1))
            {
                flag = true;
            }

            if (this.field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ + 1, p_78589_3_ + 1, p_78589_4_, -1))
            {
                flag1 = true;
            }

            if (this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ + 1, p_78589_4_ - 1, -1))
            {
                flag2 = true;
            }

            if (this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ + 1, p_78589_4_ + 1, -1))
            {
                flag3 = true;
            }
        }

        float f5 = (float)(p_78589_2_ + 0);
        float f6 = (float)(p_78589_2_ + 1);
        float f7 = (float)(p_78589_4_ + 0);
        float f8 = (float)(p_78589_4_ + 1);
        int i1 = 0;

        if ((flag || flag1) && !flag2 && !flag3)
        {
            i1 = 1;
        }

        if ((flag2 || flag3) && !flag1 && !flag)
        {
            i1 = 2;
        }

        if (i1 == 0)
        {
            int j1 = 0;
            int k1 = 0;
            int l1 = 16;
            int i2 = 16;
            boolean flag4 = true;

            if (!flag)
            {
                f5 += 0.3125F;
            }

            if (!flag)
            {
                j1 += 5;
            }

            if (!flag1)
            {
                f6 -= 0.3125F;
            }

            if (!flag1)
            {
                l1 -= 5;
            }

            if (!flag2)
            {
                f7 += 0.3125F;
            }

            if (!flag2)
            {
                k1 += 5;
            }

            if (!flag3)
            {
                f8 -= 0.3125F;
            }

            if (!flag3)
            {
                i2 -= 5;
            }

            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon.func_94214_a((double)l1), (double)icon.func_94207_b((double)i2));
            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon.func_94214_a((double)l1), (double)icon.func_94207_b((double)k1));
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon.func_94214_a((double)j1), (double)icon.func_94207_b((double)k1));
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon.func_94214_a((double)j1), (double)icon.func_94207_b((double)i2));
            tessellator.func_78386_a(f, f, f);
            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon2.func_94214_a((double)l1), (double)icon2.func_94207_b((double)i2));
            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon2.func_94214_a((double)l1), (double)icon2.func_94207_b((double)k1));
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon2.func_94214_a((double)j1), (double)icon2.func_94207_b((double)k1));
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon2.func_94214_a((double)j1), (double)icon2.func_94207_b((double)i2));
        }
        else if (i1 == 1)
        {
            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon1.func_94212_f(), (double)icon1.func_94210_h());
            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon1.func_94212_f(), (double)icon1.func_94206_g());
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon1.func_94209_e(), (double)icon1.func_94206_g());
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon1.func_94209_e(), (double)icon1.func_94210_h());
            tessellator.func_78386_a(f, f, f);
            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon3.func_94212_f(), (double)icon3.func_94210_h());
            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon3.func_94212_f(), (double)icon3.func_94206_g());
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon3.func_94209_e(), (double)icon3.func_94206_g());
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon3.func_94209_e(), (double)icon3.func_94210_h());
        }
        else
        {
            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon1.func_94212_f(), (double)icon1.func_94210_h());
            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon1.func_94209_e(), (double)icon1.func_94210_h());
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon1.func_94209_e(), (double)icon1.func_94206_g());
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon1.func_94212_f(), (double)icon1.func_94206_g());
            tessellator.func_78386_a(f, f, f);
            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon3.func_94212_f(), (double)icon3.func_94210_h());
            tessellator.func_78374_a((double)f6, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon3.func_94209_e(), (double)icon3.func_94210_h());
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f7, (double)icon3.func_94209_e(), (double)icon3.func_94206_g());
            tessellator.func_78374_a((double)f5, (double)p_78589_3_ + 0.015625D, (double)f8, (double)icon3.func_94212_f(), (double)icon3.func_94206_g());
        }

        if (!this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_ + 1, p_78589_4_))
        {
            float f9 = 0.021875F;

            if (this.field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && this.field_78669_a.func_72798_a(p_78589_2_ - 1, p_78589_3_ + 1, p_78589_4_) == Block.field_72075_av.field_71990_ca)
            {
                tessellator.func_78386_a(f * f2, f * f3, f * f4);
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), (double)icon1.func_94212_f(), (double)icon1.func_94206_g());
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), (double)icon1.func_94209_e(), (double)icon1.func_94206_g());
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), (double)icon1.func_94209_e(), (double)icon1.func_94210_h());
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), (double)icon1.func_94212_f(), (double)icon1.func_94210_h());
                tessellator.func_78386_a(f, f, f);
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), (double)icon3.func_94212_f(), (double)icon3.func_94206_g());
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), (double)icon3.func_94209_e(), (double)icon3.func_94206_g());
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), (double)icon3.func_94209_e(), (double)icon3.func_94210_h());
                tessellator.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), (double)icon3.func_94212_f(), (double)icon3.func_94210_h());
            }

            if (this.field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && this.field_78669_a.func_72798_a(p_78589_2_ + 1, p_78589_3_ + 1, p_78589_4_) == Block.field_72075_av.field_71990_ca)
            {
                tessellator.func_78386_a(f * f2, f * f3, f * f4);
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), (double)icon1.func_94209_e(), (double)icon1.func_94210_h());
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), (double)icon1.func_94212_f(), (double)icon1.func_94210_h());
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), (double)icon1.func_94212_f(), (double)icon1.func_94206_g());
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), (double)icon1.func_94209_e(), (double)icon1.func_94206_g());
                tessellator.func_78386_a(f, f, f);
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), (double)icon3.func_94209_e(), (double)icon3.func_94210_h());
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), (double)icon3.func_94212_f(), (double)icon3.func_94210_h());
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), (double)icon3.func_94212_f(), (double)icon3.func_94206_g());
                tessellator.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), (double)icon3.func_94209_e(), (double)icon3.func_94206_g());
            }

            if (this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && this.field_78669_a.func_72798_a(p_78589_2_, p_78589_3_ + 1, p_78589_4_ - 1) == Block.field_72075_av.field_71990_ca)
            {
                tessellator.func_78386_a(f * f2, f * f3, f * f4);
                tessellator.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, (double)icon1.func_94209_e(), (double)icon1.func_94210_h());
                tessellator.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, (double)icon1.func_94212_f(), (double)icon1.func_94210_h());
                tessellator.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, (double)icon1.func_94212_f(), (double)icon1.func_94206_g());
                tessellator.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, (double)icon1.func_94209_e(), (double)icon1.func_94206_g());
                tessellator.func_78386_a(f, f, f);
                tessellator.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, (double)icon3.func_94209_e(), (double)icon3.func_94210_h());
                tessellator.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, (double)icon3.func_94212_f(), (double)icon3.func_94210_h());
                tessellator.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, (double)icon3.func_94212_f(), (double)icon3.func_94206_g());
                tessellator.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, (double)icon3.func_94209_e(), (double)icon3.func_94206_g());
            }

            if (this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && this.field_78669_a.func_72798_a(p_78589_2_, p_78589_3_ + 1, p_78589_4_ + 1) == Block.field_72075_av.field_71990_ca)
            {
                tessellator.func_78386_a(f * f2, f * f3, f * f4);
                tessellator.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, (double)icon1.func_94212_f(), (double)icon1.func_94206_g());
                tessellator.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, (double)icon1.func_94209_e(), (double)icon1.func_94206_g());
                tessellator.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, (double)icon1.func_94209_e(), (double)icon1.func_94210_h());
                tessellator.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, (double)icon1.func_94212_f(), (double)icon1.func_94210_h());
                tessellator.func_78386_a(f, f, f);
                tessellator.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, (double)icon3.func_94212_f(), (double)icon3.func_94206_g());
                tessellator.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, (double)icon3.func_94209_e(), (double)icon3.func_94206_g());
                tessellator.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, (double)icon3.func_94209_e(), (double)icon3.func_94210_h());
                tessellator.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, (double)icon3.func_94212_f(), (double)icon3.func_94210_h());
            }
        }

        return true;
    }

    public boolean func_78586_a(BlockRailBase p_78586_1_, int p_78586_2_, int p_78586_3_, int p_78586_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int l = this.field_78669_a.func_72805_g(p_78586_2_, p_78586_3_, p_78586_4_);
        Icon icon = this.func_94165_a(p_78586_1_, 0, l);

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        if (p_78586_1_.func_72183_n())
        {
            l &= 7;
        }

        tessellator.func_78380_c(p_78586_1_.func_71874_e(this.field_78669_a, p_78586_2_, p_78586_3_, p_78586_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        double d0 = (double)icon.func_94209_e();
        double d1 = (double)icon.func_94206_g();
        double d2 = (double)icon.func_94212_f();
        double d3 = (double)icon.func_94210_h();
        double d4 = 0.0625D;
        double d5 = (double)(p_78586_2_ + 1);
        double d6 = (double)(p_78586_2_ + 1);
        double d7 = (double)(p_78586_2_ + 0);
        double d8 = (double)(p_78586_2_ + 0);
        double d9 = (double)(p_78586_4_ + 0);
        double d10 = (double)(p_78586_4_ + 1);
        double d11 = (double)(p_78586_4_ + 1);
        double d12 = (double)(p_78586_4_ + 0);
        double d13 = (double)p_78586_3_ + d4;
        double d14 = (double)p_78586_3_ + d4;
        double d15 = (double)p_78586_3_ + d4;
        double d16 = (double)p_78586_3_ + d4;

        if (l != 1 && l != 2 && l != 3 && l != 7)
        {
            if (l == 8)
            {
                d5 = d6 = (double)(p_78586_2_ + 0);
                d7 = d8 = (double)(p_78586_2_ + 1);
                d9 = d12 = (double)(p_78586_4_ + 1);
                d10 = d11 = (double)(p_78586_4_ + 0);
            }
            else if (l == 9)
            {
                d5 = d8 = (double)(p_78586_2_ + 0);
                d6 = d7 = (double)(p_78586_2_ + 1);
                d9 = d10 = (double)(p_78586_4_ + 0);
                d11 = d12 = (double)(p_78586_4_ + 1);
            }
        }
        else
        {
            d5 = d8 = (double)(p_78586_2_ + 1);
            d6 = d7 = (double)(p_78586_2_ + 0);
            d9 = d10 = (double)(p_78586_4_ + 1);
            d11 = d12 = (double)(p_78586_4_ + 0);
        }

        if (l != 2 && l != 4)
        {
            if (l == 3 || l == 5)
            {
                ++d14;
                ++d15;
            }
        }
        else
        {
            ++d13;
            ++d16;
        }

        tessellator.func_78374_a(d5, d13, d9, d2, d1);
        tessellator.func_78374_a(d6, d14, d10, d2, d3);
        tessellator.func_78374_a(d7, d15, d11, d0, d3);
        tessellator.func_78374_a(d8, d16, d12, d0, d1);
        tessellator.func_78374_a(d8, d16, d12, d0, d1);
        tessellator.func_78374_a(d7, d15, d11, d0, d3);
        tessellator.func_78374_a(d6, d14, d10, d2, d3);
        tessellator.func_78374_a(d5, d13, d9, d2, d1);
        return true;
    }

    public boolean func_78576_j(Block p_78576_1_, int p_78576_2_, int p_78576_3_, int p_78576_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        Icon icon = this.func_94173_a(p_78576_1_, 0);

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        tessellator.func_78380_c(p_78576_1_.func_71874_e(this.field_78669_a, p_78576_2_, p_78576_3_, p_78576_4_));
        float f = 1.0F;
        tessellator.func_78386_a(f, f, f);
        double d0 = (double)icon.func_94209_e();
        double d1 = (double)icon.func_94206_g();
        double d2 = (double)icon.func_94212_f();
        double d3 = (double)icon.func_94210_h();
        int l = this.field_78669_a.func_72805_g(p_78576_2_, p_78576_3_, p_78576_4_);
        double d4 = 0.0D;
        double d5 = 0.05000000074505806D;

        if (l == 5)
        {
            tessellator.func_78374_a((double)p_78576_2_ + d5, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 1) + d4, d0, d1);
            tessellator.func_78374_a((double)p_78576_2_ + d5, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 1) + d4, d0, d3);
            tessellator.func_78374_a((double)p_78576_2_ + d5, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 0) - d4, d2, d3);
            tessellator.func_78374_a((double)p_78576_2_ + d5, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 0) - d4, d2, d1);
        }

        if (l == 4)
        {
            tessellator.func_78374_a((double)(p_78576_2_ + 1) - d5, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 1) + d4, d2, d3);
            tessellator.func_78374_a((double)(p_78576_2_ + 1) - d5, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 1) + d4, d2, d1);
            tessellator.func_78374_a((double)(p_78576_2_ + 1) - d5, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 0) - d4, d0, d1);
            tessellator.func_78374_a((double)(p_78576_2_ + 1) - d5, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 0) - d4, d0, d3);
        }

        if (l == 3)
        {
            tessellator.func_78374_a((double)(p_78576_2_ + 1) + d4, (double)(p_78576_3_ + 0) - d4, (double)p_78576_4_ + d5, d2, d3);
            tessellator.func_78374_a((double)(p_78576_2_ + 1) + d4, (double)(p_78576_3_ + 1) + d4, (double)p_78576_4_ + d5, d2, d1);
            tessellator.func_78374_a((double)(p_78576_2_ + 0) - d4, (double)(p_78576_3_ + 1) + d4, (double)p_78576_4_ + d5, d0, d1);
            tessellator.func_78374_a((double)(p_78576_2_ + 0) - d4, (double)(p_78576_3_ + 0) - d4, (double)p_78576_4_ + d5, d0, d3);
        }

        if (l == 2)
        {
            tessellator.func_78374_a((double)(p_78576_2_ + 1) + d4, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 1) - d5, d0, d1);
            tessellator.func_78374_a((double)(p_78576_2_ + 1) + d4, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 1) - d5, d0, d3);
            tessellator.func_78374_a((double)(p_78576_2_ + 0) - d4, (double)(p_78576_3_ + 0) - d4, (double)(p_78576_4_ + 1) - d5, d2, d3);
            tessellator.func_78374_a((double)(p_78576_2_ + 0) - d4, (double)(p_78576_3_ + 1) + d4, (double)(p_78576_4_ + 1) - d5, d2, d1);
        }

        return true;
    }

    public boolean func_78598_k(Block p_78598_1_, int p_78598_2_, int p_78598_3_, int p_78598_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        Icon icon = this.func_94173_a(p_78598_1_, 0);

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        float f = 1.0F;
        tessellator.func_78380_c(p_78598_1_.func_71874_e(this.field_78669_a, p_78598_2_, p_78598_3_, p_78598_4_));
        int l = p_78598_1_.func_71920_b(this.field_78669_a, p_78598_2_, p_78598_3_, p_78598_4_);
        float f1 = (float)(l >> 16 & 255) / 255.0F;
        float f2 = (float)(l >> 8 & 255) / 255.0F;
        float f3 = (float)(l & 255) / 255.0F;
        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        double d0 = (double)icon.func_94209_e();
        double d1 = (double)icon.func_94206_g();
        double d2 = (double)icon.func_94212_f();
        double d3 = (double)icon.func_94210_h();
        double d4 = 0.05000000074505806D;
        int i1 = this.field_78669_a.func_72805_g(p_78598_2_, p_78598_3_, p_78598_4_);

        if ((i1 & 2) != 0)
        {
            tessellator.func_78374_a((double)p_78598_2_ + d4, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), d0, d1);
            tessellator.func_78374_a((double)p_78598_2_ + d4, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), d0, d3);
            tessellator.func_78374_a((double)p_78598_2_ + d4, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), d2, d3);
            tessellator.func_78374_a((double)p_78598_2_ + d4, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), d2, d1);
            tessellator.func_78374_a((double)p_78598_2_ + d4, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), d2, d1);
            tessellator.func_78374_a((double)p_78598_2_ + d4, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), d2, d3);
            tessellator.func_78374_a((double)p_78598_2_ + d4, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), d0, d3);
            tessellator.func_78374_a((double)p_78598_2_ + d4, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), d0, d1);
        }

        if ((i1 & 8) != 0)
        {
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), d2, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), d2, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), d0, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), d0, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), d0, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), d0, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), d2, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 1) - d4, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), d2, d3);
        }

        if ((i1 & 4) != 0)
        {
            tessellator.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)p_78598_4_ + d4, d2, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)p_78598_4_ + d4, d2, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)p_78598_4_ + d4, d0, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)p_78598_4_ + d4, d0, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)p_78598_4_ + d4, d0, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)p_78598_4_ + d4, d0, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)p_78598_4_ + d4, d2, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)p_78598_4_ + d4, d2, d3);
        }

        if ((i1 & 1) != 0)
        {
            tessellator.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - d4, d0, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - d4, d0, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - d4, d2, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - d4, d2, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - d4, d2, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - d4, d2, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - d4, d0, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - d4, d0, d1);
        }

        if (this.field_78669_a.func_72809_s(p_78598_2_, p_78598_3_ + 1, p_78598_4_))
        {
            tessellator.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1) - d4, (double)(p_78598_4_ + 0), d0, d1);
            tessellator.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1) - d4, (double)(p_78598_4_ + 1), d0, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1) - d4, (double)(p_78598_4_ + 1), d2, d3);
            tessellator.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1) - d4, (double)(p_78598_4_ + 0), d2, d1);
        }

        return true;
    }

    public boolean func_78592_a(BlockPane p_78592_1_, int p_78592_2_, int p_78592_3_, int p_78592_4_)
    {
        int l = this.field_78669_a.func_72800_K();
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78592_1_.func_71874_e(this.field_78669_a, p_78592_2_, p_78592_3_, p_78592_4_));
        float f = 1.0F;
        int i1 = p_78592_1_.func_71920_b(this.field_78669_a, p_78592_2_, p_78592_3_, p_78592_4_);
        float f1 = (float)(i1 >> 16 & 255) / 255.0F;
        float f2 = (float)(i1 >> 8 & 255) / 255.0F;
        float f3 = (float)(i1 & 255) / 255.0F;

        if (EntityRenderer.field_78517_a)
        {
            float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }

        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        Icon icon;
        Icon icon1;

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
            icon1 = this.field_78664_d;
        }
        else
        {
            int j1 = this.field_78669_a.func_72805_g(p_78592_2_, p_78592_3_, p_78592_4_);
            icon = this.func_94165_a(p_78592_1_, 0, j1);
            icon1 = p_78592_1_.func_72162_n();
        }

        double d0 = (double)icon.func_94209_e();
        double d1 = (double)icon.func_94214_a(8.0D);
        double d2 = (double)icon.func_94212_f();
        double d3 = (double)icon.func_94206_g();
        double d4 = (double)icon.func_94210_h();
        double d5 = (double)icon1.func_94214_a(7.0D);
        double d6 = (double)icon1.func_94214_a(9.0D);
        double d7 = (double)icon1.func_94206_g();
        double d8 = (double)icon1.func_94207_b(8.0D);
        double d9 = (double)icon1.func_94210_h();
        double d10 = (double)p_78592_2_;
        double d11 = (double)p_78592_2_ + 0.5D;
        double d12 = (double)(p_78592_2_ + 1);
        double d13 = (double)p_78592_4_;
        double d14 = (double)p_78592_4_ + 0.5D;
        double d15 = (double)(p_78592_4_ + 1);
        double d16 = (double)p_78592_2_ + 0.5D - 0.0625D;
        double d17 = (double)p_78592_2_ + 0.5D + 0.0625D;
        double d18 = (double)p_78592_4_ + 0.5D - 0.0625D;
        double d19 = (double)p_78592_4_ + 0.5D + 0.0625D;
        boolean flag = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_, p_78592_3_, p_78592_4_ - 1));
        boolean flag1 = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_, p_78592_3_, p_78592_4_ + 1));
        boolean flag2 = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_ - 1, p_78592_3_, p_78592_4_));
        boolean flag3 = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_ + 1, p_78592_3_, p_78592_4_));
        boolean flag4 = p_78592_1_.func_71877_c(this.field_78669_a, p_78592_2_, p_78592_3_ + 1, p_78592_4_, 1);
        boolean flag5 = p_78592_1_.func_71877_c(this.field_78669_a, p_78592_2_, p_78592_3_ - 1, p_78592_4_, 0);
        double d20 = 0.01D;
        double d21 = 0.005D;

        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1))
        {
            if (flag2 && !flag3)
            {
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1), d14, d0, d3);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 0), d14, d0, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d14, d1, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d14, d1, d3);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d14, d0, d3);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d14, d0, d4);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 0), d14, d1, d4);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1), d14, d1, d3);

                if (!flag1 && !flag)
                {
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d19, d5, d7);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d19, d5, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d18, d6, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d18, d6, d7);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d18, d5, d7);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d18, d5, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d19, d6, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d19, d6, d7);
                }

                if (flag4 || p_78592_3_ < l - 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ + 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                }

                if (flag5 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ - 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                }
            }
            else if (!flag2 && flag3)
            {
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d14, d1, d3);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d14, d1, d4);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 0), d14, d2, d4);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1), d14, d2, d3);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1), d14, d1, d3);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 0), d14, d1, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d14, d2, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d14, d2, d3);

                if (!flag1 && !flag)
                {
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d18, d5, d7);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d18, d5, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d19, d6, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d19, d6, d7);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d19, d5, d7);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d19, d5, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d18, d6, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d18, d6, d7);
                }

                if (flag4 || p_78592_3_ < l - 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ + 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
                }

                if (flag5 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ - 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d7);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d7);
                }
            }
        }
        else
        {
            tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1), d14, d0, d3);
            tessellator.func_78374_a(d10, (double)(p_78592_3_ + 0), d14, d0, d4);
            tessellator.func_78374_a(d12, (double)(p_78592_3_ + 0), d14, d2, d4);
            tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1), d14, d2, d3);
            tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1), d14, d0, d3);
            tessellator.func_78374_a(d12, (double)(p_78592_3_ + 0), d14, d0, d4);
            tessellator.func_78374_a(d10, (double)(p_78592_3_ + 0), d14, d2, d4);
            tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1), d14, d2, d3);

            if (flag4)
            {
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
                tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
            }
            else
            {
                if (p_78592_3_ < l - 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ + 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d10, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                }

                if (p_78592_3_ < l - 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ + 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d12, (double)(p_78592_3_ + 1) + 0.01D, d18, d5, d7);
                }
            }

            if (flag5)
            {
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d7);
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d9);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d7);
                tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d9);
            }
            else
            {
                if (p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ - 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d19, d6, d9);
                    tessellator.func_78374_a(d10, (double)p_78592_3_ - 0.01D, d18, d5, d9);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                }

                if (p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ - 1, p_78592_4_))
                {
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d7);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d19, d6, d7);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_78374_a(d11, (double)p_78592_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_78374_a(d12, (double)p_78592_3_ - 0.01D, d18, d5, d7);
                }
            }
        }

        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1))
        {
            if (flag && !flag1)
            {
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d13, d0, d3);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d13, d0, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d14, d1, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d14, d1, d3);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d14, d0, d3);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d14, d0, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d13, d1, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d13, d1, d3);

                if (!flag3 && !flag2)
                {
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1), d14, d5, d7);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 0), d14, d5, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 0), d14, d6, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1), d14, d6, d7);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1), d14, d5, d7);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 0), d14, d5, d9);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 0), d14, d6, d9);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1), d14, d6, d7);
                }

                if (flag4 || p_78592_3_ < l - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ - 1))
                {
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d13, d6, d7);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d14, d6, d8);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d14, d5, d8);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d13, d5, d7);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d14, d6, d7);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d13, d6, d8);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d13, d5, d8);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d14, d5, d7);
                }

                if (flag5 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ - 1))
                {
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d13, d6, d7);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d14, d6, d8);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d14, d5, d8);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d13, d5, d7);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d14, d6, d7);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d13, d6, d8);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d13, d5, d8);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d14, d5, d7);
                }
            }
            else if (!flag && flag1)
            {
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d14, d1, d3);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d14, d1, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d15, d2, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d15, d2, d3);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d15, d1, d3);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d15, d1, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d14, d2, d4);
                tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d14, d2, d3);

                if (!flag3 && !flag2)
                {
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1), d14, d5, d7);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 0), d14, d5, d9);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 0), d14, d6, d9);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1), d14, d6, d7);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1), d14, d5, d7);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 0), d14, d5, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 0), d14, d6, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1), d14, d6, d7);
                }

                if (flag4 || p_78592_3_ < l - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ + 1))
                {
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d14, d5, d8);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d15, d5, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d15, d6, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d14, d6, d8);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d15, d5, d8);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d14, d5, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d14, d6, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d15, d6, d8);
                }

                if (flag5 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ + 1))
                {
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d14, d5, d8);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d15, d5, d9);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d15, d6, d9);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d14, d6, d8);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d15, d5, d8);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d14, d5, d9);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d14, d6, d9);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d15, d6, d8);
                }
            }
        }
        else
        {
            tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d15, d0, d3);
            tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d15, d0, d4);
            tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d13, d2, d4);
            tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d13, d2, d3);
            tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d13, d0, d3);
            tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d13, d0, d4);
            tessellator.func_78374_a(d11, (double)(p_78592_3_ + 0), d15, d2, d4);
            tessellator.func_78374_a(d11, (double)(p_78592_3_ + 1), d15, d2, d3);

            if (flag4)
            {
                tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d15, d6, d9);
                tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d13, d6, d7);
                tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d13, d5, d7);
                tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d15, d5, d9);
                tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d13, d6, d9);
                tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d15, d6, d7);
                tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d15, d5, d7);
                tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d13, d5, d9);
            }
            else
            {
                if (p_78592_3_ < l - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ - 1))
                {
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d13, d6, d7);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d14, d6, d8);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d14, d5, d8);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d13, d5, d7);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d14, d6, d7);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d13, d6, d8);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d13, d5, d8);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d14, d5, d7);
                }

                if (p_78592_3_ < l - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ + 1))
                {
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d14, d5, d8);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d15, d5, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d15, d6, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d14, d6, d8);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d15, d5, d8);
                    tessellator.func_78374_a(d16, (double)(p_78592_3_ + 1) + 0.005D, d14, d5, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d14, d6, d9);
                    tessellator.func_78374_a(d17, (double)(p_78592_3_ + 1) + 0.005D, d15, d6, d8);
                }
            }

            if (flag5)
            {
                tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d15, d6, d9);
                tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d13, d6, d7);
                tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d13, d5, d7);
                tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d15, d5, d9);
                tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d13, d6, d9);
                tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d15, d6, d7);
                tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d15, d5, d7);
                tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d13, d5, d9);
            }
            else
            {
                if (p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ - 1))
                {
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d13, d6, d7);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d14, d6, d8);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d14, d5, d8);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d13, d5, d7);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d14, d6, d7);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d13, d6, d8);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d13, d5, d8);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d14, d5, d7);
                }

                if (p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ + 1))
                {
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d14, d5, d8);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d15, d5, d9);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d15, d6, d9);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d14, d6, d8);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d15, d5, d8);
                    tessellator.func_78374_a(d16, (double)p_78592_3_ - 0.005D, d14, d5, d9);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d14, d6, d9);
                    tessellator.func_78374_a(d17, (double)p_78592_3_ - 0.005D, d15, d6, d8);
                }
            }
        }

        return true;
    }

    public boolean func_78620_l(Block p_78620_1_, int p_78620_2_, int p_78620_3_, int p_78620_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78620_1_.func_71874_e(this.field_78669_a, p_78620_2_, p_78620_3_, p_78620_4_));
        float f = 1.0F;
        int l = p_78620_1_.func_71920_b(this.field_78669_a, p_78620_2_, p_78620_3_, p_78620_4_);
        float f1 = (float)(l >> 16 & 255) / 255.0F;
        float f2 = (float)(l >> 8 & 255) / 255.0F;
        float f3 = (float)(l & 255) / 255.0F;

        if (EntityRenderer.field_78517_a)
        {
            float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }

        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        double d0 = (double)p_78620_2_;
        double d1 = (double)p_78620_3_;
        double d2 = (double)p_78620_4_;

        if (p_78620_1_ == Block.field_71962_X)
        {
            long i1 = (long)(p_78620_2_ * 3129871) ^ (long)p_78620_4_ * 116129781L ^ (long)p_78620_3_;
            i1 = i1 * i1 * 42317861L + i1 * 11L;
            d0 += ((double)((float)(i1 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
            d1 += ((double)((float)(i1 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
            d2 += ((double)((float)(i1 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
        }

        this.func_78599_a(p_78620_1_, this.field_78669_a.func_72805_g(p_78620_2_, p_78620_3_, p_78620_4_), d0, d1, d2, 1.0F);
        return true;
    }

    public boolean func_78603_m(Block p_78603_1_, int p_78603_2_, int p_78603_3_, int p_78603_4_)
    {
        BlockStem blockstem = (BlockStem)p_78603_1_;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(blockstem.func_71874_e(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_));
        float f = 1.0F;
        int l = blockstem.func_71920_b(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);
        float f1 = (float)(l >> 16 & 255) / 255.0F;
        float f2 = (float)(l >> 8 & 255) / 255.0F;
        float f3 = (float)(l & 255) / 255.0F;

        if (EntityRenderer.field_78517_a)
        {
            float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }

        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        blockstem.func_71902_a(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);
        int i1 = blockstem.func_72265_d(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);

        if (i1 < 0)
        {
            this.func_78575_a(blockstem, this.field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), this.field_83024_j, (double)p_78603_2_, (double)((float)p_78603_3_ - 0.0625F), (double)p_78603_4_);
        }
        else
        {
            this.func_78575_a(blockstem, this.field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), 0.5D, (double)p_78603_2_, (double)((float)p_78603_3_ - 0.0625F), (double)p_78603_4_);
            this.func_78606_a(blockstem, this.field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), i1, this.field_83024_j, (double)p_78603_2_, (double)((float)p_78603_3_ - 0.0625F), (double)p_78603_4_);
        }

        return true;
    }

    public boolean func_78614_n(Block p_78614_1_, int p_78614_2_, int p_78614_3_, int p_78614_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78614_1_.func_71874_e(this.field_78669_a, p_78614_2_, p_78614_3_, p_78614_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        this.func_78579_b(p_78614_1_, this.field_78669_a.func_72805_g(p_78614_2_, p_78614_3_, p_78614_4_), (double)p_78614_2_, (double)((float)p_78614_3_ - 0.0625F), (double)p_78614_4_);
        return true;
    }

    public void func_78623_a(Block p_78623_1_, double p_78623_2_, double p_78623_4_, double p_78623_6_, double p_78623_8_, double p_78623_10_, int p_78623_12_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        Icon icon = this.func_94165_a(p_78623_1_, 0, p_78623_12_);

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        double d5 = (double)icon.func_94209_e();
        double d6 = (double)icon.func_94206_g();
        double d7 = (double)icon.func_94212_f();
        double d8 = (double)icon.func_94210_h();
        double d9 = (double)icon.func_94214_a(7.0D);
        double d10 = (double)icon.func_94207_b(6.0D);
        double d11 = (double)icon.func_94214_a(9.0D);
        double d12 = (double)icon.func_94207_b(8.0D);
        double d13 = (double)icon.func_94214_a(7.0D);
        double d14 = (double)icon.func_94207_b(13.0D);
        double d15 = (double)icon.func_94214_a(9.0D);
        double d16 = (double)icon.func_94207_b(15.0D);
        p_78623_2_ += 0.5D;
        p_78623_6_ += 0.5D;
        double d17 = p_78623_2_ - 0.5D;
        double d18 = p_78623_2_ + 0.5D;
        double d19 = p_78623_6_ - 0.5D;
        double d20 = p_78623_6_ + 0.5D;
        double d21 = 0.0625D;
        double d22 = 0.625D;
        tessellator.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - d22) - d21, p_78623_4_ + d22, p_78623_6_ + p_78623_10_ * (1.0D - d22) - d21, d9, d10);
        tessellator.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - d22) - d21, p_78623_4_ + d22, p_78623_6_ + p_78623_10_ * (1.0D - d22) + d21, d9, d12);
        tessellator.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - d22) + d21, p_78623_4_ + d22, p_78623_6_ + p_78623_10_ * (1.0D - d22) + d21, d11, d12);
        tessellator.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - d22) + d21, p_78623_4_ + d22, p_78623_6_ + p_78623_10_ * (1.0D - d22) - d21, d11, d10);
        tessellator.func_78374_a(p_78623_2_ + d21 + p_78623_8_, p_78623_4_, p_78623_6_ - d21 + p_78623_10_, d15, d14);
        tessellator.func_78374_a(p_78623_2_ + d21 + p_78623_8_, p_78623_4_, p_78623_6_ + d21 + p_78623_10_, d15, d16);
        tessellator.func_78374_a(p_78623_2_ - d21 + p_78623_8_, p_78623_4_, p_78623_6_ + d21 + p_78623_10_, d13, d16);
        tessellator.func_78374_a(p_78623_2_ - d21 + p_78623_8_, p_78623_4_, p_78623_6_ - d21 + p_78623_10_, d13, d14);
        tessellator.func_78374_a(p_78623_2_ - d21, p_78623_4_ + 1.0D, d19, d5, d6);
        tessellator.func_78374_a(p_78623_2_ - d21 + p_78623_8_, p_78623_4_ + 0.0D, d19 + p_78623_10_, d5, d8);
        tessellator.func_78374_a(p_78623_2_ - d21 + p_78623_8_, p_78623_4_ + 0.0D, d20 + p_78623_10_, d7, d8);
        tessellator.func_78374_a(p_78623_2_ - d21, p_78623_4_ + 1.0D, d20, d7, d6);
        tessellator.func_78374_a(p_78623_2_ + d21, p_78623_4_ + 1.0D, d20, d5, d6);
        tessellator.func_78374_a(p_78623_2_ + p_78623_8_ + d21, p_78623_4_ + 0.0D, d20 + p_78623_10_, d5, d8);
        tessellator.func_78374_a(p_78623_2_ + p_78623_8_ + d21, p_78623_4_ + 0.0D, d19 + p_78623_10_, d7, d8);
        tessellator.func_78374_a(p_78623_2_ + d21, p_78623_4_ + 1.0D, d19, d7, d6);
        tessellator.func_78374_a(d17, p_78623_4_ + 1.0D, p_78623_6_ + d21, d5, d6);
        tessellator.func_78374_a(d17 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ + d21 + p_78623_10_, d5, d8);
        tessellator.func_78374_a(d18 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ + d21 + p_78623_10_, d7, d8);
        tessellator.func_78374_a(d18, p_78623_4_ + 1.0D, p_78623_6_ + d21, d7, d6);
        tessellator.func_78374_a(d18, p_78623_4_ + 1.0D, p_78623_6_ - d21, d5, d6);
        tessellator.func_78374_a(d18 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ - d21 + p_78623_10_, d5, d8);
        tessellator.func_78374_a(d17 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ - d21 + p_78623_10_, d7, d8);
        tessellator.func_78374_a(d17, p_78623_4_ + 1.0D, p_78623_6_ - d21, d7, d6);
    }

    public void func_78599_a(Block p_78599_1_, int p_78599_2_, double p_78599_3_, double p_78599_5_, double p_78599_7_, float p_78599_9_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        Icon icon = this.func_94165_a(p_78599_1_, 0, p_78599_2_);

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        double d3 = (double)icon.func_94209_e();
        double d4 = (double)icon.func_94206_g();
        double d5 = (double)icon.func_94212_f();
        double d6 = (double)icon.func_94210_h();
        double d7 = 0.45D * (double)p_78599_9_;
        double d8 = p_78599_3_ + 0.5D - d7;
        double d9 = p_78599_3_ + 0.5D + d7;
        double d10 = p_78599_7_ + 0.5D - d7;
        double d11 = p_78599_7_ + 0.5D + d7;
        tessellator.func_78374_a(d8, p_78599_5_ + (double)p_78599_9_, d10, d3, d4);
        tessellator.func_78374_a(d8, p_78599_5_ + 0.0D, d10, d3, d6);
        tessellator.func_78374_a(d9, p_78599_5_ + 0.0D, d11, d5, d6);
        tessellator.func_78374_a(d9, p_78599_5_ + (double)p_78599_9_, d11, d5, d4);
        tessellator.func_78374_a(d9, p_78599_5_ + (double)p_78599_9_, d11, d3, d4);
        tessellator.func_78374_a(d9, p_78599_5_ + 0.0D, d11, d3, d6);
        tessellator.func_78374_a(d8, p_78599_5_ + 0.0D, d10, d5, d6);
        tessellator.func_78374_a(d8, p_78599_5_ + (double)p_78599_9_, d10, d5, d4);
        tessellator.func_78374_a(d8, p_78599_5_ + (double)p_78599_9_, d11, d3, d4);
        tessellator.func_78374_a(d8, p_78599_5_ + 0.0D, d11, d3, d6);
        tessellator.func_78374_a(d9, p_78599_5_ + 0.0D, d10, d5, d6);
        tessellator.func_78374_a(d9, p_78599_5_ + (double)p_78599_9_, d10, d5, d4);
        tessellator.func_78374_a(d9, p_78599_5_ + (double)p_78599_9_, d10, d3, d4);
        tessellator.func_78374_a(d9, p_78599_5_ + 0.0D, d10, d3, d6);
        tessellator.func_78374_a(d8, p_78599_5_ + 0.0D, d11, d5, d6);
        tessellator.func_78374_a(d8, p_78599_5_ + (double)p_78599_9_, d11, d5, d4);
    }

    public void func_78575_a(Block p_78575_1_, int p_78575_2_, double p_78575_3_, double p_78575_5_, double p_78575_7_, double p_78575_9_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        Icon icon = this.func_94165_a(p_78575_1_, 0, p_78575_2_);

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        double d4 = (double)icon.func_94209_e();
        double d5 = (double)icon.func_94206_g();
        double d6 = (double)icon.func_94212_f();
        double d7 = (double)icon.func_94207_b(p_78575_3_ * 16.0D);
        double d8 = p_78575_5_ + 0.5D - 0.44999998807907104D;
        double d9 = p_78575_5_ + 0.5D + 0.44999998807907104D;
        double d10 = p_78575_9_ + 0.5D - 0.44999998807907104D;
        double d11 = p_78575_9_ + 0.5D + 0.44999998807907104D;
        tessellator.func_78374_a(d8, p_78575_7_ + p_78575_3_, d10, d4, d5);
        tessellator.func_78374_a(d8, p_78575_7_ + 0.0D, d10, d4, d7);
        tessellator.func_78374_a(d9, p_78575_7_ + 0.0D, d11, d6, d7);
        tessellator.func_78374_a(d9, p_78575_7_ + p_78575_3_, d11, d6, d5);
        tessellator.func_78374_a(d9, p_78575_7_ + p_78575_3_, d11, d4, d5);
        tessellator.func_78374_a(d9, p_78575_7_ + 0.0D, d11, d4, d7);
        tessellator.func_78374_a(d8, p_78575_7_ + 0.0D, d10, d6, d7);
        tessellator.func_78374_a(d8, p_78575_7_ + p_78575_3_, d10, d6, d5);
        tessellator.func_78374_a(d8, p_78575_7_ + p_78575_3_, d11, d4, d5);
        tessellator.func_78374_a(d8, p_78575_7_ + 0.0D, d11, d4, d7);
        tessellator.func_78374_a(d9, p_78575_7_ + 0.0D, d10, d6, d7);
        tessellator.func_78374_a(d9, p_78575_7_ + p_78575_3_, d10, d6, d5);
        tessellator.func_78374_a(d9, p_78575_7_ + p_78575_3_, d10, d4, d5);
        tessellator.func_78374_a(d9, p_78575_7_ + 0.0D, d10, d4, d7);
        tessellator.func_78374_a(d8, p_78575_7_ + 0.0D, d11, d6, d7);
        tessellator.func_78374_a(d8, p_78575_7_ + p_78575_3_, d11, d6, d5);
    }

    public boolean func_78566_o(Block p_78566_1_, int p_78566_2_, int p_78566_3_, int p_78566_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        Icon icon = this.func_94173_a(p_78566_1_, 1);

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        float f = 0.015625F;
        double d0 = (double)icon.func_94209_e();
        double d1 = (double)icon.func_94206_g();
        double d2 = (double)icon.func_94212_f();
        double d3 = (double)icon.func_94210_h();
        long l = (long)(p_78566_2_ * 3129871) ^ (long)p_78566_4_ * 116129781L ^ (long)p_78566_3_;
        l = l * l * 42317861L + l * 11L;
        int i1 = (int)(l >> 16 & 3L);
        tessellator.func_78380_c(p_78566_1_.func_71874_e(this.field_78669_a, p_78566_2_, p_78566_3_, p_78566_4_));
        float f1 = (float)p_78566_2_ + 0.5F;
        float f2 = (float)p_78566_4_ + 0.5F;
        float f3 = (float)(i1 & 1) * 0.5F * (float)(1 - i1 / 2 % 2 * 2);
        float f4 = (float)(i1 + 1 & 1) * 0.5F * (float)(1 - (i1 + 1) / 2 % 2 * 2);
        tessellator.func_78378_d(p_78566_1_.func_71933_m());
        tessellator.func_78374_a((double)(f1 + f3 - f4), (double)((float)p_78566_3_ + f), (double)(f2 + f3 + f4), d0, d1);
        tessellator.func_78374_a((double)(f1 + f3 + f4), (double)((float)p_78566_3_ + f), (double)(f2 - f3 + f4), d2, d1);
        tessellator.func_78374_a((double)(f1 - f3 + f4), (double)((float)p_78566_3_ + f), (double)(f2 - f3 - f4), d2, d3);
        tessellator.func_78374_a((double)(f1 - f3 - f4), (double)((float)p_78566_3_ + f), (double)(f2 + f3 - f4), d0, d3);
        tessellator.func_78378_d((p_78566_1_.func_71933_m() & 16711422) >> 1);
        tessellator.func_78374_a((double)(f1 - f3 - f4), (double)((float)p_78566_3_ + f), (double)(f2 + f3 - f4), d0, d3);
        tessellator.func_78374_a((double)(f1 - f3 + f4), (double)((float)p_78566_3_ + f), (double)(f2 - f3 - f4), d2, d3);
        tessellator.func_78374_a((double)(f1 + f3 + f4), (double)((float)p_78566_3_ + f), (double)(f2 - f3 + f4), d2, d1);
        tessellator.func_78374_a((double)(f1 + f3 - f4), (double)((float)p_78566_3_ + f), (double)(f2 + f3 + f4), d0, d1);
        return true;
    }

    public void func_78606_a(BlockStem p_78606_1_, int p_78606_2_, int p_78606_3_, double p_78606_4_, double p_78606_6_, double p_78606_8_, double p_78606_10_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        Icon icon = p_78606_1_.func_94368_p();

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        double d4 = (double)icon.func_94209_e();
        double d5 = (double)icon.func_94206_g();
        double d6 = (double)icon.func_94212_f();
        double d7 = (double)icon.func_94210_h();
        double d8 = p_78606_6_ + 0.5D - 0.5D;
        double d9 = p_78606_6_ + 0.5D + 0.5D;
        double d10 = p_78606_10_ + 0.5D - 0.5D;
        double d11 = p_78606_10_ + 0.5D + 0.5D;
        double d12 = p_78606_6_ + 0.5D;
        double d13 = p_78606_10_ + 0.5D;

        if ((p_78606_3_ + 1) / 2 % 2 == 1)
        {
            double d14 = d6;
            d6 = d4;
            d4 = d14;
        }

        if (p_78606_3_ < 2)
        {
            tessellator.func_78374_a(d8, p_78606_8_ + p_78606_4_, d13, d4, d5);
            tessellator.func_78374_a(d8, p_78606_8_ + 0.0D, d13, d4, d7);
            tessellator.func_78374_a(d9, p_78606_8_ + 0.0D, d13, d6, d7);
            tessellator.func_78374_a(d9, p_78606_8_ + p_78606_4_, d13, d6, d5);
            tessellator.func_78374_a(d9, p_78606_8_ + p_78606_4_, d13, d6, d5);
            tessellator.func_78374_a(d9, p_78606_8_ + 0.0D, d13, d6, d7);
            tessellator.func_78374_a(d8, p_78606_8_ + 0.0D, d13, d4, d7);
            tessellator.func_78374_a(d8, p_78606_8_ + p_78606_4_, d13, d4, d5);
        }
        else
        {
            tessellator.func_78374_a(d12, p_78606_8_ + p_78606_4_, d11, d4, d5);
            tessellator.func_78374_a(d12, p_78606_8_ + 0.0D, d11, d4, d7);
            tessellator.func_78374_a(d12, p_78606_8_ + 0.0D, d10, d6, d7);
            tessellator.func_78374_a(d12, p_78606_8_ + p_78606_4_, d10, d6, d5);
            tessellator.func_78374_a(d12, p_78606_8_ + p_78606_4_, d10, d6, d5);
            tessellator.func_78374_a(d12, p_78606_8_ + 0.0D, d10, d6, d7);
            tessellator.func_78374_a(d12, p_78606_8_ + 0.0D, d11, d4, d7);
            tessellator.func_78374_a(d12, p_78606_8_ + p_78606_4_, d11, d4, d5);
        }
    }

    public void func_78579_b(Block p_78579_1_, int p_78579_2_, double p_78579_3_, double p_78579_5_, double p_78579_7_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        Icon icon = this.func_94165_a(p_78579_1_, 0, p_78579_2_);

        if (this.func_94167_b())
        {
            icon = this.field_78664_d;
        }

        double d3 = (double)icon.func_94209_e();
        double d4 = (double)icon.func_94206_g();
        double d5 = (double)icon.func_94212_f();
        double d6 = (double)icon.func_94210_h();
        double d7 = p_78579_3_ + 0.5D - 0.25D;
        double d8 = p_78579_3_ + 0.5D + 0.25D;
        double d9 = p_78579_7_ + 0.5D - 0.5D;
        double d10 = p_78579_7_ + 0.5D + 0.5D;
        tessellator.func_78374_a(d7, p_78579_5_ + 1.0D, d9, d3, d4);
        tessellator.func_78374_a(d7, p_78579_5_ + 0.0D, d9, d3, d6);
        tessellator.func_78374_a(d7, p_78579_5_ + 0.0D, d10, d5, d6);
        tessellator.func_78374_a(d7, p_78579_5_ + 1.0D, d10, d5, d4);
        tessellator.func_78374_a(d7, p_78579_5_ + 1.0D, d10, d3, d4);
        tessellator.func_78374_a(d7, p_78579_5_ + 0.0D, d10, d3, d6);
        tessellator.func_78374_a(d7, p_78579_5_ + 0.0D, d9, d5, d6);
        tessellator.func_78374_a(d7, p_78579_5_ + 1.0D, d9, d5, d4);
        tessellator.func_78374_a(d8, p_78579_5_ + 1.0D, d10, d3, d4);
        tessellator.func_78374_a(d8, p_78579_5_ + 0.0D, d10, d3, d6);
        tessellator.func_78374_a(d8, p_78579_5_ + 0.0D, d9, d5, d6);
        tessellator.func_78374_a(d8, p_78579_5_ + 1.0D, d9, d5, d4);
        tessellator.func_78374_a(d8, p_78579_5_ + 1.0D, d9, d3, d4);
        tessellator.func_78374_a(d8, p_78579_5_ + 0.0D, d9, d3, d6);
        tessellator.func_78374_a(d8, p_78579_5_ + 0.0D, d10, d5, d6);
        tessellator.func_78374_a(d8, p_78579_5_ + 1.0D, d10, d5, d4);
        d7 = p_78579_3_ + 0.5D - 0.5D;
        d8 = p_78579_3_ + 0.5D + 0.5D;
        d9 = p_78579_7_ + 0.5D - 0.25D;
        d10 = p_78579_7_ + 0.5D + 0.25D;
        tessellator.func_78374_a(d7, p_78579_5_ + 1.0D, d9, d3, d4);
        tessellator.func_78374_a(d7, p_78579_5_ + 0.0D, d9, d3, d6);
        tessellator.func_78374_a(d8, p_78579_5_ + 0.0D, d9, d5, d6);
        tessellator.func_78374_a(d8, p_78579_5_ + 1.0D, d9, d5, d4);
        tessellator.func_78374_a(d8, p_78579_5_ + 1.0D, d9, d3, d4);
        tessellator.func_78374_a(d8, p_78579_5_ + 0.0D, d9, d3, d6);
        tessellator.func_78374_a(d7, p_78579_5_ + 0.0D, d9, d5, d6);
        tessellator.func_78374_a(d7, p_78579_5_ + 1.0D, d9, d5, d4);
        tessellator.func_78374_a(d8, p_78579_5_ + 1.0D, d10, d3, d4);
        tessellator.func_78374_a(d8, p_78579_5_ + 0.0D, d10, d3, d6);
        tessellator.func_78374_a(d7, p_78579_5_ + 0.0D, d10, d5, d6);
        tessellator.func_78374_a(d7, p_78579_5_ + 1.0D, d10, d5, d4);
        tessellator.func_78374_a(d7, p_78579_5_ + 1.0D, d10, d3, d4);
        tessellator.func_78374_a(d7, p_78579_5_ + 0.0D, d10, d3, d6);
        tessellator.func_78374_a(d8, p_78579_5_ + 0.0D, d10, d5, d6);
        tessellator.func_78374_a(d8, p_78579_5_ + 1.0D, d10, d5, d4);
    }

    public boolean func_78621_p(Block p_78621_1_, int p_78621_2_, int p_78621_3_, int p_78621_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int l = p_78621_1_.func_71920_b(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_);
        float f = (float)(l >> 16 & 255) / 255.0F;
        float f1 = (float)(l >> 8 & 255) / 255.0F;
        float f2 = (float)(l & 255) / 255.0F;
        boolean flag = p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_ + 1, p_78621_4_, 1);
        boolean flag1 = p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_ - 1, p_78621_4_, 0);
        boolean[] aboolean = new boolean[] {p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_ - 1, 2), p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_ + 1, 3), p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_ - 1, p_78621_3_, p_78621_4_, 4), p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_ + 1, p_78621_3_, p_78621_4_, 5)};

        if (!flag && !flag1 && !aboolean[0] && !aboolean[1] && !aboolean[2] && !aboolean[3])
        {
            return false;
        }
        else
        {
            boolean flag2 = false;
            float f3 = 0.5F;
            float f4 = 1.0F;
            float f5 = 0.8F;
            float f6 = 0.6F;
            double d0 = 0.0D;
            double d1 = 1.0D;
            Material material = p_78621_1_.field_72018_cp;
            int i1 = this.field_78669_a.func_72805_g(p_78621_2_, p_78621_3_, p_78621_4_);
            double d2 = (double)this.func_78596_a(p_78621_2_, p_78621_3_, p_78621_4_, material);
            double d3 = (double)this.func_78596_a(p_78621_2_, p_78621_3_, p_78621_4_ + 1, material);
            double d4 = (double)this.func_78596_a(p_78621_2_ + 1, p_78621_3_, p_78621_4_ + 1, material);
            double d5 = (double)this.func_78596_a(p_78621_2_ + 1, p_78621_3_, p_78621_4_, material);
            double d6 = 0.0010000000474974513D;
            float f7;
            float f8;
            float f9;

            if (this.field_78661_f || flag)
            {
                flag2 = true;
                Icon icon = this.func_94165_a(p_78621_1_, 1, i1);
                float f10 = (float)BlockFluid.func_72204_a(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_, material);

                if (f10 > -999.0F)
                {
                    icon = this.func_94165_a(p_78621_1_, 2, i1);
                }

                d2 -= d6;
                d3 -= d6;
                d4 -= d6;
                d5 -= d6;
                double d7;
                double d8;
                double d9;
                double d10;
                double d11;
                double d12;
                double d13;
                double d14;

                if (f10 < -999.0F)
                {
                    d8 = (double)icon.func_94214_a(0.0D);
                    d12 = (double)icon.func_94207_b(0.0D);
                    d7 = d8;
                    d11 = (double)icon.func_94207_b(16.0D);
                    d10 = (double)icon.func_94214_a(16.0D);
                    d14 = d11;
                    d9 = d10;
                    d13 = d12;
                }
                else
                {
                    f9 = MathHelper.func_76126_a(f10) * 0.25F;
                    f8 = MathHelper.func_76134_b(f10) * 0.25F;
                    f7 = 8.0F;
                    d8 = (double)icon.func_94214_a((double)(8.0F + (-f8 - f9) * 16.0F));
                    d12 = (double)icon.func_94207_b((double)(8.0F + (-f8 + f9) * 16.0F));
                    d7 = (double)icon.func_94214_a((double)(8.0F + (-f8 + f9) * 16.0F));
                    d11 = (double)icon.func_94207_b((double)(8.0F + (f8 + f9) * 16.0F));
                    d10 = (double)icon.func_94214_a((double)(8.0F + (f8 + f9) * 16.0F));
                    d14 = (double)icon.func_94207_b((double)(8.0F + (f8 - f9) * 16.0F));
                    d9 = (double)icon.func_94214_a((double)(8.0F + (f8 - f9) * 16.0F));
                    d13 = (double)icon.func_94207_b((double)(8.0F + (-f8 - f9) * 16.0F));
                }

                tessellator.func_78380_c(p_78621_1_.func_71874_e(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_));
                f9 = 1.0F;
                tessellator.func_78386_a(f4 * f9 * f, f4 * f9 * f1, f4 * f9 * f2);
                tessellator.func_78374_a((double)(p_78621_2_ + 0), (double)p_78621_3_ + d2, (double)(p_78621_4_ + 0), d8, d12);
                tessellator.func_78374_a((double)(p_78621_2_ + 0), (double)p_78621_3_ + d3, (double)(p_78621_4_ + 1), d7, d11);
                tessellator.func_78374_a((double)(p_78621_2_ + 1), (double)p_78621_3_ + d4, (double)(p_78621_4_ + 1), d10, d14);
                tessellator.func_78374_a((double)(p_78621_2_ + 1), (double)p_78621_3_ + d5, (double)(p_78621_4_ + 0), d9, d13);
            }

            if (this.field_78661_f || flag1)
            {
                tessellator.func_78380_c(p_78621_1_.func_71874_e(this.field_78669_a, p_78621_2_, p_78621_3_ - 1, p_78621_4_));
                float f11 = 1.0F;
                tessellator.func_78386_a(f3 * f11, f3 * f11, f3 * f11);
                this.func_78613_a(p_78621_1_, (double)p_78621_2_, (double)p_78621_3_ + d6, (double)p_78621_4_, this.func_94173_a(p_78621_1_, 0));
                flag2 = true;
            }

            for (int j1 = 0; j1 < 4; ++j1)
            {
                int k1 = p_78621_2_;
                int l1 = p_78621_4_;

                if (j1 == 0)
                {
                    l1 = p_78621_4_ - 1;
                }

                if (j1 == 1)
                {
                    ++l1;
                }

                if (j1 == 2)
                {
                    k1 = p_78621_2_ - 1;
                }

                if (j1 == 3)
                {
                    ++k1;
                }

                Icon icon1 = this.func_94165_a(p_78621_1_, j1 + 2, i1);

                if (this.field_78661_f || aboolean[j1])
                {
                    double d15;
                    double d16;
                    double d17;
                    double d18;
                    double d19;
                    double d20;

                    if (j1 == 0)
                    {
                        d15 = d2;
                        d17 = d5;
                        d16 = (double)p_78621_2_;
                        d18 = (double)(p_78621_2_ + 1);
                        d19 = (double)p_78621_4_ + d6;
                        d20 = (double)p_78621_4_ + d6;
                    }
                    else if (j1 == 1)
                    {
                        d15 = d4;
                        d17 = d3;
                        d16 = (double)(p_78621_2_ + 1);
                        d18 = (double)p_78621_2_;
                        d19 = (double)(p_78621_4_ + 1) - d6;
                        d20 = (double)(p_78621_4_ + 1) - d6;
                    }
                    else if (j1 == 2)
                    {
                        d15 = d3;
                        d17 = d2;
                        d16 = (double)p_78621_2_ + d6;
                        d18 = (double)p_78621_2_ + d6;
                        d19 = (double)(p_78621_4_ + 1);
                        d20 = (double)p_78621_4_;
                    }
                    else
                    {
                        d15 = d5;
                        d17 = d4;
                        d16 = (double)(p_78621_2_ + 1) - d6;
                        d18 = (double)(p_78621_2_ + 1) - d6;
                        d19 = (double)p_78621_4_;
                        d20 = (double)(p_78621_4_ + 1);
                    }

                    flag2 = true;
                    float f12 = icon1.func_94214_a(0.0D);
                    f9 = icon1.func_94214_a(8.0D);
                    f8 = icon1.func_94207_b((1.0D - d15) * 16.0D * 0.5D);
                    f7 = icon1.func_94207_b((1.0D - d17) * 16.0D * 0.5D);
                    float f13 = icon1.func_94207_b(8.0D);
                    tessellator.func_78380_c(p_78621_1_.func_71874_e(this.field_78669_a, k1, p_78621_3_, l1));
                    float f14 = 1.0F;

                    if (j1 < 2)
                    {
                        f14 *= f5;
                    }
                    else
                    {
                        f14 *= f6;
                    }

                    tessellator.func_78386_a(f4 * f14 * f, f4 * f14 * f1, f4 * f14 * f2);
                    tessellator.func_78374_a(d16, (double)p_78621_3_ + d15, d19, (double)f12, (double)f8);
                    tessellator.func_78374_a(d18, (double)p_78621_3_ + d17, d20, (double)f9, (double)f7);
                    tessellator.func_78374_a(d18, (double)(p_78621_3_ + 0), d20, (double)f9, (double)f13);
                    tessellator.func_78374_a(d16, (double)(p_78621_3_ + 0), d19, (double)f12, (double)f13);
                }
            }

            this.field_83027_i = d0;
            this.field_83024_j = d1;
            return flag2;
        }
    }

    public float func_78596_a(int p_78596_1_, int p_78596_2_, int p_78596_3_, Material p_78596_4_)
    {
        int l = 0;
        float f = 0.0F;

        for (int i1 = 0; i1 < 4; ++i1)
        {
            int j1 = p_78596_1_ - (i1 & 1);
            int k1 = p_78596_3_ - (i1 >> 1 & 1);

            if (this.field_78669_a.func_72803_f(j1, p_78596_2_ + 1, k1) == p_78596_4_)
            {
                return 1.0F;
            }

            Material material1 = this.field_78669_a.func_72803_f(j1, p_78596_2_, k1);

            if (material1 == p_78596_4_)
            {
                int l1 = this.field_78669_a.func_72805_g(j1, p_78596_2_, k1);

                if (l1 >= 8 || l1 == 0)
                {
                    f += BlockFluid.func_72199_d(l1) * 10.0F;
                    l += 10;
                }

                f += BlockFluid.func_72199_d(l1);
                ++l;
            }
            else if (!material1.func_76220_a())
            {
                ++f;
                ++l;
            }
        }

        return 1.0F - f / (float)l;
    }

    public void func_78588_a(Block p_78588_1_, World p_78588_2_, int p_78588_3_, int p_78588_4_, int p_78588_5_, int p_78588_6_)
    {
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78380_c(p_78588_1_.func_71874_e(p_78588_2_, p_78588_3_, p_78588_4_, p_78588_5_));
        float f4 = 1.0F;
        float f5 = 1.0F;

        if (f5 < f4)
        {
            f5 = f4;
        }

        tessellator.func_78386_a(f * f5, f * f5, f * f5);
        this.func_78613_a(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 0, p_78588_6_));
        f5 = 1.0F;

        if (f5 < f4)
        {
            f5 = f4;
        }

        tessellator.func_78386_a(f1 * f5, f1 * f5, f1 * f5);
        this.func_78617_b(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 1, p_78588_6_));
        f5 = 1.0F;

        if (f5 < f4)
        {
            f5 = f4;
        }

        tessellator.func_78386_a(f2 * f5, f2 * f5, f2 * f5);
        this.func_78611_c(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 2, p_78588_6_));
        f5 = 1.0F;

        if (f5 < f4)
        {
            f5 = f4;
        }

        tessellator.func_78386_a(f2 * f5, f2 * f5, f2 * f5);
        this.func_78622_d(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 3, p_78588_6_));
        f5 = 1.0F;

        if (f5 < f4)
        {
            f5 = f4;
        }

        tessellator.func_78386_a(f3 * f5, f3 * f5, f3 * f5);
        this.func_78573_e(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 4, p_78588_6_));
        f5 = 1.0F;

        if (f5 < f4)
        {
            f5 = f4;
        }

        tessellator.func_78386_a(f3 * f5, f3 * f5, f3 * f5);
        this.func_78605_f(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 5, p_78588_6_));
        tessellator.func_78381_a();
    }

    public boolean func_78570_q(Block p_78570_1_, int p_78570_2_, int p_78570_3_, int p_78570_4_)
    {
        int l = p_78570_1_.func_71920_b(this.field_78669_a, p_78570_2_, p_78570_3_, p_78570_4_);
        float f = (float)(l >> 16 & 255) / 255.0F;
        float f1 = (float)(l >> 8 & 255) / 255.0F;
        float f2 = (float)(l & 255) / 255.0F;

        if (EntityRenderer.field_78517_a)
        {
            float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
            float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
            float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }

        return Minecraft.func_71379_u() && Block.field_71984_q[p_78570_1_.field_71990_ca] == 0 ? (this.field_98189_n ? this.func_102027_b(p_78570_1_, p_78570_2_, p_78570_3_, p_78570_4_, f, f1, f2) : this.func_78578_a(p_78570_1_, p_78570_2_, p_78570_3_, p_78570_4_, f, f1, f2)) : this.func_78609_c(p_78570_1_, p_78570_2_, p_78570_3_, p_78570_4_, f, f1, f2);
    }

    public boolean func_78581_r(Block p_78581_1_, int p_78581_2_, int p_78581_3_, int p_78581_4_)
    {
        int l = this.field_78669_a.func_72805_g(p_78581_2_, p_78581_3_, p_78581_4_);
        int i1 = l & 12;

        if (i1 == 4)
        {
            this.field_78662_g = 1;
            this.field_78683_h = 1;
            this.field_78681_k = 1;
            this.field_78675_l = 1;
        }
        else if (i1 == 8)
        {
            this.field_78685_i = 1;
            this.field_78679_j = 1;
        }

        boolean flag = this.func_78570_q(p_78581_1_, p_78581_2_, p_78581_3_, p_78581_4_);
        this.field_78685_i = 0;
        this.field_78662_g = 0;
        this.field_78683_h = 0;
        this.field_78679_j = 0;
        this.field_78681_k = 0;
        this.field_78675_l = 0;
        return flag;
    }

    public boolean func_96445_r(Block p_96445_1_, int p_96445_2_, int p_96445_3_, int p_96445_4_)
    {
        int l = this.field_78669_a.func_72805_g(p_96445_2_, p_96445_3_, p_96445_4_);

        if (l == 3)
        {
            this.field_78662_g = 1;
            this.field_78683_h = 1;
            this.field_78681_k = 1;
            this.field_78675_l = 1;
        }
        else if (l == 4)
        {
            this.field_78685_i = 1;
            this.field_78679_j = 1;
        }

        boolean flag = this.func_78570_q(p_96445_1_, p_96445_2_, p_96445_3_, p_96445_4_);
        this.field_78685_i = 0;
        this.field_78662_g = 0;
        this.field_78683_h = 0;
        this.field_78679_j = 0;
        this.field_78681_k = 0;
        this.field_78675_l = 0;
        return flag;
    }

    public boolean func_78578_a(Block p_78578_1_, int p_78578_2_, int p_78578_3_, int p_78578_4_, float p_78578_5_, float p_78578_6_, float p_78578_7_)
    {
        this.field_78677_m = true;
        boolean flag = false;
        float f3 = 0.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        float f6 = 0.0F;
        boolean flag1 = true;
        int l = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(983055);

        if (this.func_94175_b(p_78578_1_).func_94215_i().equals("grass_top"))
        {
            flag1 = false;
        }
        else if (this.func_94167_b())
        {
            flag1 = false;
        }

        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        float f7;
        int i1;

        if (this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_, 0))
        {
            if (this.field_83027_i <= 0.0D)
            {
                --p_78578_3_;
            }

            this.field_78641_T = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78645_V = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78643_W = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78655_Y = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78689_v = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78712_x = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78710_y = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78628_A = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1)];

            if (!flag4 && !flag2)
            {
                this.field_78691_u = this.field_78689_v;
                this.field_78649_S = this.field_78641_T;
            }
            else
            {
                this.field_78691_u = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
                this.field_78649_S = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
            }

            if (!flag5 && !flag2)
            {
                this.field_78687_w = this.field_78689_v;
                this.field_78639_U = this.field_78641_T;
            }
            else
            {
                this.field_78687_w = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
                this.field_78639_U = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
            }

            if (!flag4 && !flag3)
            {
                this.field_78708_z = this.field_78628_A;
                this.field_78657_X = this.field_78655_Y;
            }
            else
            {
                this.field_78708_z = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
                this.field_78657_X = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
            }

            if (!flag5 && !flag3)
            {
                this.field_78629_B = this.field_78628_A;
                this.field_78660_Z = this.field_78655_Y;
            }
            else
            {
                this.field_78629_B = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
                this.field_78660_Z = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
            }

            if (this.field_83027_i <= 0.0D)
            {
                ++p_78578_3_;
            }

            i1 = l;

            if (this.field_83027_i <= 0.0D || !this.field_78669_a.func_72804_r(p_78578_2_, p_78578_3_ - 1, p_78578_4_))
            {
                i1 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            }

            f7 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            f3 = (this.field_78687_w + this.field_78689_v + this.field_78710_y + f7) / 4.0F;
            f6 = (this.field_78710_y + f7 + this.field_78629_B + this.field_78628_A) / 4.0F;
            f5 = (f7 + this.field_78712_x + this.field_78628_A + this.field_78708_z) / 4.0F;
            f4 = (this.field_78689_v + this.field_78691_u + f7 + this.field_78712_x) / 4.0F;
            this.field_78700_an = this.func_78602_a(this.field_78639_U, this.field_78641_T, this.field_78643_W, i1);
            this.field_78676_aq = this.func_78602_a(this.field_78643_W, this.field_78660_Z, this.field_78655_Y, i1);
            this.field_78696_ap = this.func_78602_a(this.field_78645_V, this.field_78655_Y, this.field_78657_X, i1);
            this.field_78694_ao = this.func_78602_a(this.field_78641_T, this.field_78649_S, this.field_78645_V, i1);

            if (flag1)
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_ * 0.5F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_ * 0.5F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_ * 0.5F;
            }
            else
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.5F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.5F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.5F;
            }

            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            this.func_78613_a(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 0));
            flag = true;
        }

        if (this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_, 1))
        {
            if (this.field_83024_j >= 1.0D)
            {
                ++p_78578_3_;
            }

            this.field_78705_ab = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78711_af = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78703_ad = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78706_ag = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78624_D = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78634_H = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78626_F = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78635_I = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1)];

            if (!flag4 && !flag2)
            {
                this.field_78630_C = this.field_78624_D;
                this.field_78704_aa = this.field_78705_ab;
            }
            else
            {
                this.field_78630_C = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
                this.field_78704_aa = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
            }

            if (!flag4 && !flag3)
            {
                this.field_78627_G = this.field_78634_H;
                this.field_78709_ae = this.field_78711_af;
            }
            else
            {
                this.field_78627_G = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
                this.field_78709_ae = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
            }

            if (!flag5 && !flag2)
            {
                this.field_78625_E = this.field_78624_D;
                this.field_78702_ac = this.field_78705_ab;
            }
            else
            {
                this.field_78625_E = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
                this.field_78702_ac = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
            }

            if (!flag5 && !flag3)
            {
                this.field_78636_J = this.field_78634_H;
                this.field_78707_ah = this.field_78711_af;
            }
            else
            {
                this.field_78636_J = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
                this.field_78707_ah = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
            }

            if (this.field_83024_j >= 1.0D)
            {
                --p_78578_3_;
            }

            i1 = l;

            if (this.field_83024_j >= 1.0D || !this.field_78669_a.func_72804_r(p_78578_2_, p_78578_3_ + 1, p_78578_4_))
            {
                i1 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            }

            f7 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            f6 = (this.field_78625_E + this.field_78624_D + this.field_78635_I + f7) / 4.0F;
            f3 = (this.field_78635_I + f7 + this.field_78636_J + this.field_78634_H) / 4.0F;
            f4 = (f7 + this.field_78626_F + this.field_78634_H + this.field_78627_G) / 4.0F;
            f5 = (this.field_78624_D + this.field_78630_C + f7 + this.field_78626_F) / 4.0F;
            this.field_78676_aq = this.func_78602_a(this.field_78702_ac, this.field_78705_ab, this.field_78706_ag, i1);
            this.field_78700_an = this.func_78602_a(this.field_78706_ag, this.field_78707_ah, this.field_78711_af, i1);
            this.field_78694_ao = this.func_78602_a(this.field_78703_ad, this.field_78711_af, this.field_78709_ae, i1);
            this.field_78696_ap = this.func_78602_a(this.field_78705_ab, this.field_78704_aa, this.field_78703_ad, i1);
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_;
            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            this.func_78617_b(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 1));
            flag = true;
        }

        Icon icon;

        if (this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1, 2))
        {
            if (this.field_83025_k <= 0.0D)
            {
                --p_78578_4_;
            }

            this.field_78637_K = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78712_x = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78626_F = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            this.field_78631_L = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78690_ai = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78645_V = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78703_ad = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            this.field_78692_aj = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1)];

            if (!flag2 && !flag4)
            {
                this.field_78691_u = this.field_78637_K;
                this.field_78649_S = this.field_78690_ai;
            }
            else
            {
                this.field_78691_u = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
                this.field_78649_S = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
            }

            if (!flag2 && !flag5)
            {
                this.field_78630_C = this.field_78637_K;
                this.field_78704_aa = this.field_78690_ai;
            }
            else
            {
                this.field_78630_C = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
                this.field_78704_aa = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
            }

            if (!flag3 && !flag4)
            {
                this.field_78708_z = this.field_78631_L;
                this.field_78657_X = this.field_78692_aj;
            }
            else
            {
                this.field_78708_z = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
                this.field_78657_X = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
            }

            if (!flag3 && !flag5)
            {
                this.field_78627_G = this.field_78631_L;
                this.field_78709_ae = this.field_78692_aj;
            }
            else
            {
                this.field_78627_G = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
                this.field_78709_ae = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
            }

            if (this.field_83025_k <= 0.0D)
            {
                ++p_78578_4_;
            }

            i1 = l;

            if (this.field_83025_k <= 0.0D || !this.field_78669_a.func_72804_r(p_78578_2_, p_78578_3_, p_78578_4_ - 1))
            {
                i1 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            }

            f7 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            f3 = (this.field_78637_K + this.field_78630_C + f7 + this.field_78626_F) / 4.0F;
            f4 = (f7 + this.field_78626_F + this.field_78631_L + this.field_78627_G) / 4.0F;
            f5 = (this.field_78712_x + f7 + this.field_78708_z + this.field_78631_L) / 4.0F;
            f6 = (this.field_78691_u + this.field_78637_K + this.field_78712_x + f7) / 4.0F;
            this.field_78700_an = this.func_78602_a(this.field_78690_ai, this.field_78704_aa, this.field_78703_ad, i1);
            this.field_78694_ao = this.func_78602_a(this.field_78703_ad, this.field_78692_aj, this.field_78709_ae, i1);
            this.field_78696_ap = this.func_78602_a(this.field_78645_V, this.field_78657_X, this.field_78692_aj, i1);
            this.field_78676_aq = this.func_78602_a(this.field_78649_S, this.field_78690_ai, this.field_78645_V, i1);

            if (flag1)
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_ * 0.8F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_ * 0.8F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_ * 0.8F;
            }
            else
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.8F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.8F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.8F;
            }

            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            icon = this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 2);
            this.func_78611_c(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, icon);

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                this.field_78674_ar *= p_78578_5_;
                this.field_78672_as *= p_78578_5_;
                this.field_78670_at *= p_78578_5_;
                this.field_78684_au *= p_78578_5_;
                this.field_78682_av *= p_78578_6_;
                this.field_78680_aw *= p_78578_6_;
                this.field_78678_ax *= p_78578_6_;
                this.field_78665_ay *= p_78578_6_;
                this.field_78663_az *= p_78578_7_;
                this.field_78650_aA *= p_78578_7_;
                this.field_78651_aB *= p_78578_7_;
                this.field_78652_aC *= p_78578_7_;
                this.func_78611_c(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        if (this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1, 3))
        {
            if (this.field_83022_l >= 1.0D)
            {
                ++p_78578_4_;
            }

            this.field_78632_M = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78633_N = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78710_y = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78635_I = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            this.field_78686_ak = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78688_al = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78643_W = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78706_ag = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1)];

            if (!flag2 && !flag4)
            {
                this.field_78687_w = this.field_78632_M;
                this.field_78639_U = this.field_78686_ak;
            }
            else
            {
                this.field_78687_w = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
                this.field_78639_U = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
            }

            if (!flag2 && !flag5)
            {
                this.field_78625_E = this.field_78632_M;
                this.field_78702_ac = this.field_78686_ak;
            }
            else
            {
                this.field_78625_E = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
                this.field_78702_ac = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
            }

            if (!flag3 && !flag4)
            {
                this.field_78629_B = this.field_78633_N;
                this.field_78660_Z = this.field_78688_al;
            }
            else
            {
                this.field_78629_B = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
                this.field_78660_Z = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
            }

            if (!flag3 && !flag5)
            {
                this.field_78636_J = this.field_78633_N;
                this.field_78707_ah = this.field_78688_al;
            }
            else
            {
                this.field_78636_J = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
                this.field_78707_ah = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
            }

            if (this.field_83022_l >= 1.0D)
            {
                --p_78578_4_;
            }

            i1 = l;

            if (this.field_83022_l >= 1.0D || !this.field_78669_a.func_72804_r(p_78578_2_, p_78578_3_, p_78578_4_ + 1))
            {
                i1 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            }

            f7 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            f3 = (this.field_78632_M + this.field_78625_E + f7 + this.field_78635_I) / 4.0F;
            f6 = (f7 + this.field_78635_I + this.field_78633_N + this.field_78636_J) / 4.0F;
            f5 = (this.field_78710_y + f7 + this.field_78629_B + this.field_78633_N) / 4.0F;
            f4 = (this.field_78687_w + this.field_78632_M + this.field_78710_y + f7) / 4.0F;
            this.field_78700_an = this.func_78602_a(this.field_78686_ak, this.field_78702_ac, this.field_78706_ag, i1);
            this.field_78676_aq = this.func_78602_a(this.field_78706_ag, this.field_78688_al, this.field_78707_ah, i1);
            this.field_78696_ap = this.func_78602_a(this.field_78643_W, this.field_78660_Z, this.field_78688_al, i1);
            this.field_78694_ao = this.func_78602_a(this.field_78639_U, this.field_78686_ak, this.field_78643_W, i1);

            if (flag1)
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_ * 0.8F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_ * 0.8F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_ * 0.8F;
            }
            else
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.8F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.8F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.8F;
            }

            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            icon = this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 3);
            this.func_78622_d(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 3));

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                this.field_78674_ar *= p_78578_5_;
                this.field_78672_as *= p_78578_5_;
                this.field_78670_at *= p_78578_5_;
                this.field_78684_au *= p_78578_5_;
                this.field_78682_av *= p_78578_6_;
                this.field_78680_aw *= p_78578_6_;
                this.field_78678_ax *= p_78578_6_;
                this.field_78665_ay *= p_78578_6_;
                this.field_78663_az *= p_78578_7_;
                this.field_78650_aA *= p_78578_7_;
                this.field_78651_aB *= p_78578_7_;
                this.field_78652_aC *= p_78578_7_;
                this.func_78622_d(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        if (this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_, 4))
        {
            if (this.field_83021_g <= 0.0D)
            {
                --p_78578_2_;
            }

            this.field_78689_v = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78637_K = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78632_M = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78624_D = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            this.field_78641_T = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78690_ai = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78686_ak = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78705_ab = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1)];

            if (!flag5 && !flag2)
            {
                this.field_78691_u = this.field_78637_K;
                this.field_78649_S = this.field_78690_ai;
            }
            else
            {
                this.field_78691_u = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
                this.field_78649_S = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
            }

            if (!flag4 && !flag2)
            {
                this.field_78687_w = this.field_78632_M;
                this.field_78639_U = this.field_78686_ak;
            }
            else
            {
                this.field_78687_w = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
                this.field_78639_U = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
            }

            if (!flag5 && !flag3)
            {
                this.field_78630_C = this.field_78637_K;
                this.field_78704_aa = this.field_78690_ai;
            }
            else
            {
                this.field_78630_C = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
                this.field_78704_aa = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
            }

            if (!flag4 && !flag3)
            {
                this.field_78625_E = this.field_78632_M;
                this.field_78702_ac = this.field_78686_ak;
            }
            else
            {
                this.field_78625_E = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
                this.field_78702_ac = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
            }

            if (this.field_83021_g <= 0.0D)
            {
                ++p_78578_2_;
            }

            i1 = l;

            if (this.field_83021_g <= 0.0D || !this.field_78669_a.func_72804_r(p_78578_2_ - 1, p_78578_3_, p_78578_4_))
            {
                i1 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            }

            f7 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            f6 = (this.field_78689_v + this.field_78687_w + f7 + this.field_78632_M) / 4.0F;
            f3 = (f7 + this.field_78632_M + this.field_78624_D + this.field_78625_E) / 4.0F;
            f4 = (this.field_78637_K + f7 + this.field_78630_C + this.field_78624_D) / 4.0F;
            f5 = (this.field_78691_u + this.field_78689_v + this.field_78637_K + f7) / 4.0F;
            this.field_78676_aq = this.func_78602_a(this.field_78641_T, this.field_78639_U, this.field_78686_ak, i1);
            this.field_78700_an = this.func_78602_a(this.field_78686_ak, this.field_78705_ab, this.field_78702_ac, i1);
            this.field_78694_ao = this.func_78602_a(this.field_78690_ai, this.field_78704_aa, this.field_78705_ab, i1);
            this.field_78696_ap = this.func_78602_a(this.field_78649_S, this.field_78641_T, this.field_78690_ai, i1);

            if (flag1)
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_ * 0.6F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_ * 0.6F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_ * 0.6F;
            }
            else
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.6F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.6F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.6F;
            }

            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            icon = this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 4);
            this.func_78573_e(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, icon);

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                this.field_78674_ar *= p_78578_5_;
                this.field_78672_as *= p_78578_5_;
                this.field_78670_at *= p_78578_5_;
                this.field_78684_au *= p_78578_5_;
                this.field_78682_av *= p_78578_6_;
                this.field_78680_aw *= p_78578_6_;
                this.field_78678_ax *= p_78578_6_;
                this.field_78665_ay *= p_78578_6_;
                this.field_78663_az *= p_78578_7_;
                this.field_78650_aA *= p_78578_7_;
                this.field_78651_aB *= p_78578_7_;
                this.field_78652_aC *= p_78578_7_;
                this.func_78573_e(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        if (this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_, 5))
        {
            if (this.field_83026_h >= 1.0D)
            {
                ++p_78578_2_;
            }

            this.field_78628_A = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78631_L = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78633_N = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78634_H = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            this.field_78655_Y = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78692_aj = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78688_al = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78711_af = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1)];

            if (!flag2 && !flag4)
            {
                this.field_78708_z = this.field_78631_L;
                this.field_78657_X = this.field_78692_aj;
            }
            else
            {
                this.field_78708_z = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
                this.field_78657_X = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
            }

            if (!flag2 && !flag5)
            {
                this.field_78629_B = this.field_78633_N;
                this.field_78660_Z = this.field_78688_al;
            }
            else
            {
                this.field_78629_B = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
                this.field_78660_Z = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
            }

            if (!flag3 && !flag4)
            {
                this.field_78627_G = this.field_78631_L;
                this.field_78709_ae = this.field_78692_aj;
            }
            else
            {
                this.field_78627_G = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
                this.field_78709_ae = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
            }

            if (!flag3 && !flag5)
            {
                this.field_78636_J = this.field_78633_N;
                this.field_78707_ah = this.field_78688_al;
            }
            else
            {
                this.field_78636_J = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
                this.field_78707_ah = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
            }

            if (this.field_83026_h >= 1.0D)
            {
                --p_78578_2_;
            }

            i1 = l;

            if (this.field_83026_h >= 1.0D || !this.field_78669_a.func_72804_r(p_78578_2_ + 1, p_78578_3_, p_78578_4_))
            {
                i1 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            }

            f7 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            f3 = (this.field_78628_A + this.field_78629_B + f7 + this.field_78633_N) / 4.0F;
            f4 = (this.field_78708_z + this.field_78628_A + this.field_78631_L + f7) / 4.0F;
            f5 = (this.field_78631_L + f7 + this.field_78627_G + this.field_78634_H) / 4.0F;
            f6 = (f7 + this.field_78633_N + this.field_78634_H + this.field_78636_J) / 4.0F;
            this.field_78700_an = this.func_78602_a(this.field_78655_Y, this.field_78660_Z, this.field_78688_al, i1);
            this.field_78676_aq = this.func_78602_a(this.field_78688_al, this.field_78711_af, this.field_78707_ah, i1);
            this.field_78696_ap = this.func_78602_a(this.field_78692_aj, this.field_78709_ae, this.field_78711_af, i1);
            this.field_78694_ao = this.func_78602_a(this.field_78657_X, this.field_78655_Y, this.field_78692_aj, i1);

            if (flag1)
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_ * 0.6F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_ * 0.6F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_ * 0.6F;
            }
            else
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.6F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.6F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.6F;
            }

            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            icon = this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 5);
            this.func_78605_f(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, icon);

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                this.field_78674_ar *= p_78578_5_;
                this.field_78672_as *= p_78578_5_;
                this.field_78670_at *= p_78578_5_;
                this.field_78684_au *= p_78578_5_;
                this.field_78682_av *= p_78578_6_;
                this.field_78680_aw *= p_78578_6_;
                this.field_78678_ax *= p_78578_6_;
                this.field_78665_ay *= p_78578_6_;
                this.field_78663_az *= p_78578_7_;
                this.field_78650_aA *= p_78578_7_;
                this.field_78651_aB *= p_78578_7_;
                this.field_78652_aC *= p_78578_7_;
                this.func_78605_f(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        this.field_78677_m = false;
        return flag;
    }

    public boolean func_102027_b(Block p_102027_1_, int p_102027_2_, int p_102027_3_, int p_102027_4_, float p_102027_5_, float p_102027_6_, float p_102027_7_)
    {
        this.field_78677_m = true;
        boolean flag = false;
        float f3 = 0.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        float f6 = 0.0F;
        boolean flag1 = true;
        int l = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(983055);

        if (this.func_94175_b(p_102027_1_).func_94215_i().equals("grass_top"))
        {
            flag1 = false;
        }
        else if (this.func_94167_b())
        {
            flag1 = false;
        }

        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        float f7;
        int i1;

        if (this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_, 0))
        {
            if (this.field_83027_i <= 0.0D)
            {
                --p_102027_3_;
            }

            this.field_78641_T = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
            this.field_78645_V = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
            this.field_78643_W = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
            this.field_78655_Y = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
            this.field_78689_v = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
            this.field_78712_x = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
            this.field_78710_y = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
            this.field_78628_A = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1)];

            if (!flag4 && !flag2)
            {
                this.field_78691_u = this.field_78689_v;
                this.field_78649_S = this.field_78641_T;
            }
            else
            {
                this.field_78691_u = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1);
                this.field_78649_S = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1);
            }

            if (!flag5 && !flag2)
            {
                this.field_78687_w = this.field_78689_v;
                this.field_78639_U = this.field_78641_T;
            }
            else
            {
                this.field_78687_w = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1);
                this.field_78639_U = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1);
            }

            if (!flag4 && !flag3)
            {
                this.field_78708_z = this.field_78628_A;
                this.field_78657_X = this.field_78655_Y;
            }
            else
            {
                this.field_78708_z = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1);
                this.field_78657_X = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1);
            }

            if (!flag5 && !flag3)
            {
                this.field_78629_B = this.field_78628_A;
                this.field_78660_Z = this.field_78655_Y;
            }
            else
            {
                this.field_78629_B = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1);
                this.field_78660_Z = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1);
            }

            if (this.field_83027_i <= 0.0D)
            {
                ++p_102027_3_;
            }

            i1 = l;

            if (this.field_83027_i <= 0.0D || !this.field_78669_a.func_72804_r(p_102027_2_, p_102027_3_ - 1, p_102027_4_))
            {
                i1 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
            }

            f7 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
            f3 = (this.field_78687_w + this.field_78689_v + this.field_78710_y + f7) / 4.0F;
            f6 = (this.field_78710_y + f7 + this.field_78629_B + this.field_78628_A) / 4.0F;
            f5 = (f7 + this.field_78712_x + this.field_78628_A + this.field_78708_z) / 4.0F;
            f4 = (this.field_78689_v + this.field_78691_u + f7 + this.field_78712_x) / 4.0F;
            this.field_78700_an = this.func_78602_a(this.field_78639_U, this.field_78641_T, this.field_78643_W, i1);
            this.field_78676_aq = this.func_78602_a(this.field_78643_W, this.field_78660_Z, this.field_78655_Y, i1);
            this.field_78696_ap = this.func_78602_a(this.field_78645_V, this.field_78655_Y, this.field_78657_X, i1);
            this.field_78694_ao = this.func_78602_a(this.field_78641_T, this.field_78649_S, this.field_78645_V, i1);

            if (flag1)
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_ * 0.5F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_ * 0.5F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_ * 0.5F;
            }
            else
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.5F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.5F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.5F;
            }

            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            this.func_78613_a(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 0));
            flag = true;
        }

        if (this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_, 1))
        {
            if (this.field_83024_j >= 1.0D)
            {
                ++p_102027_3_;
            }

            this.field_78705_ab = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
            this.field_78711_af = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
            this.field_78703_ad = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
            this.field_78706_ag = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
            this.field_78624_D = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
            this.field_78634_H = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
            this.field_78626_F = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
            this.field_78635_I = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1)];

            if (!flag4 && !flag2)
            {
                this.field_78630_C = this.field_78624_D;
                this.field_78704_aa = this.field_78705_ab;
            }
            else
            {
                this.field_78630_C = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1);
                this.field_78704_aa = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1);
            }

            if (!flag4 && !flag3)
            {
                this.field_78627_G = this.field_78634_H;
                this.field_78709_ae = this.field_78711_af;
            }
            else
            {
                this.field_78627_G = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1);
                this.field_78709_ae = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1);
            }

            if (!flag5 && !flag2)
            {
                this.field_78625_E = this.field_78624_D;
                this.field_78702_ac = this.field_78705_ab;
            }
            else
            {
                this.field_78625_E = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1);
                this.field_78702_ac = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1);
            }

            if (!flag5 && !flag3)
            {
                this.field_78636_J = this.field_78634_H;
                this.field_78707_ah = this.field_78711_af;
            }
            else
            {
                this.field_78636_J = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1);
                this.field_78707_ah = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1);
            }

            if (this.field_83024_j >= 1.0D)
            {
                --p_102027_3_;
            }

            i1 = l;

            if (this.field_83024_j >= 1.0D || !this.field_78669_a.func_72804_r(p_102027_2_, p_102027_3_ + 1, p_102027_4_))
            {
                i1 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
            }

            f7 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
            f6 = (this.field_78625_E + this.field_78624_D + this.field_78635_I + f7) / 4.0F;
            f3 = (this.field_78635_I + f7 + this.field_78636_J + this.field_78634_H) / 4.0F;
            f4 = (f7 + this.field_78626_F + this.field_78634_H + this.field_78627_G) / 4.0F;
            f5 = (this.field_78624_D + this.field_78630_C + f7 + this.field_78626_F) / 4.0F;
            this.field_78676_aq = this.func_78602_a(this.field_78702_ac, this.field_78705_ab, this.field_78706_ag, i1);
            this.field_78700_an = this.func_78602_a(this.field_78706_ag, this.field_78707_ah, this.field_78711_af, i1);
            this.field_78694_ao = this.func_78602_a(this.field_78703_ad, this.field_78711_af, this.field_78709_ae, i1);
            this.field_78696_ap = this.func_78602_a(this.field_78705_ab, this.field_78704_aa, this.field_78703_ad, i1);
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_;
            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            this.func_78617_b(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 1));
            flag = true;
        }

        float f8;
        float f9;
        float f10;
        float f11;
        int j1;
        int k1;
        int l1;
        int i2;
        Icon icon;

        if (this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1, 2))
        {
            if (this.field_83025_k <= 0.0D)
            {
                --p_102027_4_;
            }

            this.field_78637_K = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
            this.field_78712_x = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
            this.field_78626_F = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
            this.field_78631_L = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
            this.field_78690_ai = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
            this.field_78645_V = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
            this.field_78703_ad = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
            this.field_78692_aj = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1)];

            if (!flag2 && !flag4)
            {
                this.field_78691_u = this.field_78637_K;
                this.field_78649_S = this.field_78690_ai;
            }
            else
            {
                this.field_78691_u = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_);
                this.field_78649_S = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_);
            }

            if (!flag2 && !flag5)
            {
                this.field_78630_C = this.field_78637_K;
                this.field_78704_aa = this.field_78690_ai;
            }
            else
            {
                this.field_78630_C = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_);
                this.field_78704_aa = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_);
            }

            if (!flag3 && !flag4)
            {
                this.field_78708_z = this.field_78631_L;
                this.field_78657_X = this.field_78692_aj;
            }
            else
            {
                this.field_78708_z = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_);
                this.field_78657_X = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_);
            }

            if (!flag3 && !flag5)
            {
                this.field_78627_G = this.field_78631_L;
                this.field_78709_ae = this.field_78692_aj;
            }
            else
            {
                this.field_78627_G = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_);
                this.field_78709_ae = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_);
            }

            if (this.field_83025_k <= 0.0D)
            {
                ++p_102027_4_;
            }

            i1 = l;

            if (this.field_83025_k <= 0.0D || !this.field_78669_a.func_72804_r(p_102027_2_, p_102027_3_, p_102027_4_ - 1))
            {
                i1 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
            }

            f7 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
            f9 = (this.field_78637_K + this.field_78630_C + f7 + this.field_78626_F) / 4.0F;
            f8 = (f7 + this.field_78626_F + this.field_78631_L + this.field_78627_G) / 4.0F;
            f11 = (this.field_78712_x + f7 + this.field_78708_z + this.field_78631_L) / 4.0F;
            f10 = (this.field_78691_u + this.field_78637_K + this.field_78712_x + f7) / 4.0F;
            f3 = (float)((double)f9 * this.field_83024_j * (1.0D - this.field_83021_g) + (double)f8 * this.field_83027_i * this.field_83021_g + (double)f11 * (1.0D - this.field_83024_j) * this.field_83021_g + (double)f10 * (1.0D - this.field_83024_j) * (1.0D - this.field_83021_g));
            f4 = (float)((double)f9 * this.field_83024_j * (1.0D - this.field_83026_h) + (double)f8 * this.field_83024_j * this.field_83026_h + (double)f11 * (1.0D - this.field_83024_j) * this.field_83026_h + (double)f10 * (1.0D - this.field_83024_j) * (1.0D - this.field_83026_h));
            f5 = (float)((double)f9 * this.field_83027_i * (1.0D - this.field_83026_h) + (double)f8 * this.field_83027_i * this.field_83026_h + (double)f11 * (1.0D - this.field_83027_i) * this.field_83026_h + (double)f10 * (1.0D - this.field_83027_i) * (1.0D - this.field_83026_h));
            f6 = (float)((double)f9 * this.field_83027_i * (1.0D - this.field_83021_g) + (double)f8 * this.field_83027_i * this.field_83021_g + (double)f11 * (1.0D - this.field_83027_i) * this.field_83021_g + (double)f10 * (1.0D - this.field_83027_i) * (1.0D - this.field_83021_g));
            k1 = this.func_78602_a(this.field_78690_ai, this.field_78704_aa, this.field_78703_ad, i1);
            j1 = this.func_78602_a(this.field_78703_ad, this.field_78692_aj, this.field_78709_ae, i1);
            i2 = this.func_78602_a(this.field_78645_V, this.field_78657_X, this.field_78692_aj, i1);
            l1 = this.func_78602_a(this.field_78649_S, this.field_78690_ai, this.field_78645_V, i1);
            this.field_78700_an = this.func_96444_a(k1, j1, i2, l1, this.field_83024_j * (1.0D - this.field_83021_g), this.field_83024_j * this.field_83021_g, (1.0D - this.field_83024_j) * this.field_83021_g, (1.0D - this.field_83024_j) * (1.0D - this.field_83021_g));
            this.field_78694_ao = this.func_96444_a(k1, j1, i2, l1, this.field_83024_j * (1.0D - this.field_83026_h), this.field_83024_j * this.field_83026_h, (1.0D - this.field_83024_j) * this.field_83026_h, (1.0D - this.field_83024_j) * (1.0D - this.field_83026_h));
            this.field_78696_ap = this.func_96444_a(k1, j1, i2, l1, this.field_83027_i * (1.0D - this.field_83026_h), this.field_83027_i * this.field_83026_h, (1.0D - this.field_83027_i) * this.field_83026_h, (1.0D - this.field_83027_i) * (1.0D - this.field_83026_h));
            this.field_78676_aq = this.func_96444_a(k1, j1, i2, l1, this.field_83027_i * (1.0D - this.field_83021_g), this.field_83027_i * this.field_83021_g, (1.0D - this.field_83027_i) * this.field_83021_g, (1.0D - this.field_83027_i) * (1.0D - this.field_83021_g));

            if (flag1)
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_ * 0.8F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_ * 0.8F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_ * 0.8F;
            }
            else
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.8F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.8F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.8F;
            }

            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            icon = this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 2);
            this.func_78611_c(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, icon);

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                this.field_78674_ar *= p_102027_5_;
                this.field_78672_as *= p_102027_5_;
                this.field_78670_at *= p_102027_5_;
                this.field_78684_au *= p_102027_5_;
                this.field_78682_av *= p_102027_6_;
                this.field_78680_aw *= p_102027_6_;
                this.field_78678_ax *= p_102027_6_;
                this.field_78665_ay *= p_102027_6_;
                this.field_78663_az *= p_102027_7_;
                this.field_78650_aA *= p_102027_7_;
                this.field_78651_aB *= p_102027_7_;
                this.field_78652_aC *= p_102027_7_;
                this.func_78611_c(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        if (this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1, 3))
        {
            if (this.field_83022_l >= 1.0D)
            {
                ++p_102027_4_;
            }

            this.field_78632_M = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
            this.field_78633_N = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
            this.field_78710_y = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
            this.field_78635_I = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
            this.field_78686_ak = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
            this.field_78688_al = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
            this.field_78643_W = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
            this.field_78706_ag = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1)];

            if (!flag2 && !flag4)
            {
                this.field_78687_w = this.field_78632_M;
                this.field_78639_U = this.field_78686_ak;
            }
            else
            {
                this.field_78687_w = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_);
                this.field_78639_U = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_);
            }

            if (!flag2 && !flag5)
            {
                this.field_78625_E = this.field_78632_M;
                this.field_78702_ac = this.field_78686_ak;
            }
            else
            {
                this.field_78625_E = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_);
                this.field_78702_ac = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_);
            }

            if (!flag3 && !flag4)
            {
                this.field_78629_B = this.field_78633_N;
                this.field_78660_Z = this.field_78688_al;
            }
            else
            {
                this.field_78629_B = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_);
                this.field_78660_Z = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_);
            }

            if (!flag3 && !flag5)
            {
                this.field_78636_J = this.field_78633_N;
                this.field_78707_ah = this.field_78688_al;
            }
            else
            {
                this.field_78636_J = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_);
                this.field_78707_ah = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_);
            }

            if (this.field_83022_l >= 1.0D)
            {
                --p_102027_4_;
            }

            i1 = l;

            if (this.field_83022_l >= 1.0D || !this.field_78669_a.func_72804_r(p_102027_2_, p_102027_3_, p_102027_4_ + 1))
            {
                i1 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
            }

            f7 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
            f9 = (this.field_78632_M + this.field_78625_E + f7 + this.field_78635_I) / 4.0F;
            f8 = (f7 + this.field_78635_I + this.field_78633_N + this.field_78636_J) / 4.0F;
            f11 = (this.field_78710_y + f7 + this.field_78629_B + this.field_78633_N) / 4.0F;
            f10 = (this.field_78687_w + this.field_78632_M + this.field_78710_y + f7) / 4.0F;
            f3 = (float)((double)f9 * this.field_83024_j * (1.0D - this.field_83021_g) + (double)f8 * this.field_83024_j * this.field_83021_g + (double)f11 * (1.0D - this.field_83024_j) * this.field_83021_g + (double)f10 * (1.0D - this.field_83024_j) * (1.0D - this.field_83021_g));
            f4 = (float)((double)f9 * this.field_83027_i * (1.0D - this.field_83021_g) + (double)f8 * this.field_83027_i * this.field_83021_g + (double)f11 * (1.0D - this.field_83027_i) * this.field_83021_g + (double)f10 * (1.0D - this.field_83027_i) * (1.0D - this.field_83021_g));
            f5 = (float)((double)f9 * this.field_83027_i * (1.0D - this.field_83026_h) + (double)f8 * this.field_83027_i * this.field_83026_h + (double)f11 * (1.0D - this.field_83027_i) * this.field_83026_h + (double)f10 * (1.0D - this.field_83027_i) * (1.0D - this.field_83026_h));
            f6 = (float)((double)f9 * this.field_83024_j * (1.0D - this.field_83026_h) + (double)f8 * this.field_83024_j * this.field_83026_h + (double)f11 * (1.0D - this.field_83024_j) * this.field_83026_h + (double)f10 * (1.0D - this.field_83024_j) * (1.0D - this.field_83026_h));
            k1 = this.func_78602_a(this.field_78686_ak, this.field_78702_ac, this.field_78706_ag, i1);
            j1 = this.func_78602_a(this.field_78706_ag, this.field_78688_al, this.field_78707_ah, i1);
            i2 = this.func_78602_a(this.field_78643_W, this.field_78660_Z, this.field_78688_al, i1);
            l1 = this.func_78602_a(this.field_78639_U, this.field_78686_ak, this.field_78643_W, i1);
            this.field_78700_an = this.func_96444_a(k1, l1, i2, j1, this.field_83024_j * (1.0D - this.field_83021_g), (1.0D - this.field_83024_j) * (1.0D - this.field_83021_g), (1.0D - this.field_83024_j) * this.field_83021_g, this.field_83024_j * this.field_83021_g);
            this.field_78694_ao = this.func_96444_a(k1, l1, i2, j1, this.field_83027_i * (1.0D - this.field_83021_g), (1.0D - this.field_83027_i) * (1.0D - this.field_83021_g), (1.0D - this.field_83027_i) * this.field_83021_g, this.field_83027_i * this.field_83021_g);
            this.field_78696_ap = this.func_96444_a(k1, l1, i2, j1, this.field_83027_i * (1.0D - this.field_83026_h), (1.0D - this.field_83027_i) * (1.0D - this.field_83026_h), (1.0D - this.field_83027_i) * this.field_83026_h, this.field_83027_i * this.field_83026_h);
            this.field_78676_aq = this.func_96444_a(k1, l1, i2, j1, this.field_83024_j * (1.0D - this.field_83026_h), (1.0D - this.field_83024_j) * (1.0D - this.field_83026_h), (1.0D - this.field_83024_j) * this.field_83026_h, this.field_83024_j * this.field_83026_h);

            if (flag1)
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_ * 0.8F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_ * 0.8F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_ * 0.8F;
            }
            else
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.8F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.8F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.8F;
            }

            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            icon = this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 3);
            this.func_78622_d(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 3));

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                this.field_78674_ar *= p_102027_5_;
                this.field_78672_as *= p_102027_5_;
                this.field_78670_at *= p_102027_5_;
                this.field_78684_au *= p_102027_5_;
                this.field_78682_av *= p_102027_6_;
                this.field_78680_aw *= p_102027_6_;
                this.field_78678_ax *= p_102027_6_;
                this.field_78665_ay *= p_102027_6_;
                this.field_78663_az *= p_102027_7_;
                this.field_78650_aA *= p_102027_7_;
                this.field_78651_aB *= p_102027_7_;
                this.field_78652_aC *= p_102027_7_;
                this.func_78622_d(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        if (this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_, 4))
        {
            if (this.field_83021_g <= 0.0D)
            {
                --p_102027_2_;
            }

            this.field_78689_v = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
            this.field_78637_K = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
            this.field_78632_M = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
            this.field_78624_D = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
            this.field_78641_T = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
            this.field_78690_ai = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
            this.field_78686_ak = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
            this.field_78705_ab = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1)];

            if (!flag5 && !flag2)
            {
                this.field_78691_u = this.field_78637_K;
                this.field_78649_S = this.field_78690_ai;
            }
            else
            {
                this.field_78691_u = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1);
                this.field_78649_S = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1);
            }

            if (!flag4 && !flag2)
            {
                this.field_78687_w = this.field_78632_M;
                this.field_78639_U = this.field_78686_ak;
            }
            else
            {
                this.field_78687_w = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1);
                this.field_78639_U = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1);
            }

            if (!flag5 && !flag3)
            {
                this.field_78630_C = this.field_78637_K;
                this.field_78704_aa = this.field_78690_ai;
            }
            else
            {
                this.field_78630_C = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1);
                this.field_78704_aa = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1);
            }

            if (!flag4 && !flag3)
            {
                this.field_78625_E = this.field_78632_M;
                this.field_78702_ac = this.field_78686_ak;
            }
            else
            {
                this.field_78625_E = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1);
                this.field_78702_ac = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1);
            }

            if (this.field_83021_g <= 0.0D)
            {
                ++p_102027_2_;
            }

            i1 = l;

            if (this.field_83021_g <= 0.0D || !this.field_78669_a.func_72804_r(p_102027_2_ - 1, p_102027_3_, p_102027_4_))
            {
                i1 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
            }

            f7 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
            f9 = (this.field_78689_v + this.field_78687_w + f7 + this.field_78632_M) / 4.0F;
            f8 = (f7 + this.field_78632_M + this.field_78624_D + this.field_78625_E) / 4.0F;
            f11 = (this.field_78637_K + f7 + this.field_78630_C + this.field_78624_D) / 4.0F;
            f10 = (this.field_78691_u + this.field_78689_v + this.field_78637_K + f7) / 4.0F;
            f3 = (float)((double)f8 * this.field_83024_j * this.field_83022_l + (double)f11 * this.field_83024_j * (1.0D - this.field_83022_l) + (double)f10 * (1.0D - this.field_83024_j) * (1.0D - this.field_83022_l) + (double)f9 * (1.0D - this.field_83024_j) * this.field_83022_l);
            f4 = (float)((double)f8 * this.field_83024_j * this.field_83025_k + (double)f11 * this.field_83024_j * (1.0D - this.field_83025_k) + (double)f10 * (1.0D - this.field_83024_j) * (1.0D - this.field_83025_k) + (double)f9 * (1.0D - this.field_83024_j) * this.field_83025_k);
            f5 = (float)((double)f8 * this.field_83027_i * this.field_83025_k + (double)f11 * this.field_83027_i * (1.0D - this.field_83025_k) + (double)f10 * (1.0D - this.field_83027_i) * (1.0D - this.field_83025_k) + (double)f9 * (1.0D - this.field_83027_i) * this.field_83025_k);
            f6 = (float)((double)f8 * this.field_83027_i * this.field_83022_l + (double)f11 * this.field_83027_i * (1.0D - this.field_83022_l) + (double)f10 * (1.0D - this.field_83027_i) * (1.0D - this.field_83022_l) + (double)f9 * (1.0D - this.field_83027_i) * this.field_83022_l);
            k1 = this.func_78602_a(this.field_78641_T, this.field_78639_U, this.field_78686_ak, i1);
            j1 = this.func_78602_a(this.field_78686_ak, this.field_78705_ab, this.field_78702_ac, i1);
            i2 = this.func_78602_a(this.field_78690_ai, this.field_78704_aa, this.field_78705_ab, i1);
            l1 = this.func_78602_a(this.field_78649_S, this.field_78641_T, this.field_78690_ai, i1);
            this.field_78700_an = this.func_96444_a(j1, i2, l1, k1, this.field_83024_j * this.field_83022_l, this.field_83024_j * (1.0D - this.field_83022_l), (1.0D - this.field_83024_j) * (1.0D - this.field_83022_l), (1.0D - this.field_83024_j) * this.field_83022_l);
            this.field_78694_ao = this.func_96444_a(j1, i2, l1, k1, this.field_83024_j * this.field_83025_k, this.field_83024_j * (1.0D - this.field_83025_k), (1.0D - this.field_83024_j) * (1.0D - this.field_83025_k), (1.0D - this.field_83024_j) * this.field_83025_k);
            this.field_78696_ap = this.func_96444_a(j1, i2, l1, k1, this.field_83027_i * this.field_83025_k, this.field_83027_i * (1.0D - this.field_83025_k), (1.0D - this.field_83027_i) * (1.0D - this.field_83025_k), (1.0D - this.field_83027_i) * this.field_83025_k);
            this.field_78676_aq = this.func_96444_a(j1, i2, l1, k1, this.field_83027_i * this.field_83022_l, this.field_83027_i * (1.0D - this.field_83022_l), (1.0D - this.field_83027_i) * (1.0D - this.field_83022_l), (1.0D - this.field_83027_i) * this.field_83022_l);

            if (flag1)
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_ * 0.6F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_ * 0.6F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_ * 0.6F;
            }
            else
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.6F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.6F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.6F;
            }

            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            icon = this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 4);
            this.func_78573_e(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, icon);

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                this.field_78674_ar *= p_102027_5_;
                this.field_78672_as *= p_102027_5_;
                this.field_78670_at *= p_102027_5_;
                this.field_78684_au *= p_102027_5_;
                this.field_78682_av *= p_102027_6_;
                this.field_78680_aw *= p_102027_6_;
                this.field_78678_ax *= p_102027_6_;
                this.field_78665_ay *= p_102027_6_;
                this.field_78663_az *= p_102027_7_;
                this.field_78650_aA *= p_102027_7_;
                this.field_78651_aB *= p_102027_7_;
                this.field_78652_aC *= p_102027_7_;
                this.func_78573_e(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        if (this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_, 5))
        {
            if (this.field_83026_h >= 1.0D)
            {
                ++p_102027_2_;
            }

            this.field_78628_A = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
            this.field_78631_L = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
            this.field_78633_N = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
            this.field_78634_H = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
            this.field_78655_Y = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
            this.field_78692_aj = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
            this.field_78688_al = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
            this.field_78711_af = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
            flag3 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_)];
            flag2 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_)];
            flag5 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1)];
            flag4 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1)];

            if (!flag2 && !flag4)
            {
                this.field_78708_z = this.field_78631_L;
                this.field_78657_X = this.field_78692_aj;
            }
            else
            {
                this.field_78708_z = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1);
                this.field_78657_X = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1);
            }

            if (!flag2 && !flag5)
            {
                this.field_78629_B = this.field_78633_N;
                this.field_78660_Z = this.field_78688_al;
            }
            else
            {
                this.field_78629_B = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1);
                this.field_78660_Z = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1);
            }

            if (!flag3 && !flag4)
            {
                this.field_78627_G = this.field_78631_L;
                this.field_78709_ae = this.field_78692_aj;
            }
            else
            {
                this.field_78627_G = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1);
                this.field_78709_ae = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1);
            }

            if (!flag3 && !flag5)
            {
                this.field_78636_J = this.field_78633_N;
                this.field_78707_ah = this.field_78688_al;
            }
            else
            {
                this.field_78636_J = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1);
                this.field_78707_ah = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1);
            }

            if (this.field_83026_h >= 1.0D)
            {
                --p_102027_2_;
            }

            i1 = l;

            if (this.field_83026_h >= 1.0D || !this.field_78669_a.func_72804_r(p_102027_2_ + 1, p_102027_3_, p_102027_4_))
            {
                i1 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
            }

            f7 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
            f9 = (this.field_78628_A + this.field_78629_B + f7 + this.field_78633_N) / 4.0F;
            f8 = (this.field_78708_z + this.field_78628_A + this.field_78631_L + f7) / 4.0F;
            f11 = (this.field_78631_L + f7 + this.field_78627_G + this.field_78634_H) / 4.0F;
            f10 = (f7 + this.field_78633_N + this.field_78634_H + this.field_78636_J) / 4.0F;
            f3 = (float)((double)f9 * (1.0D - this.field_83027_i) * this.field_83022_l + (double)f8 * (1.0D - this.field_83027_i) * (1.0D - this.field_83022_l) + (double)f11 * this.field_83027_i * (1.0D - this.field_83022_l) + (double)f10 * this.field_83027_i * this.field_83022_l);
            f4 = (float)((double)f9 * (1.0D - this.field_83027_i) * this.field_83025_k + (double)f8 * (1.0D - this.field_83027_i) * (1.0D - this.field_83025_k) + (double)f11 * this.field_83027_i * (1.0D - this.field_83025_k) + (double)f10 * this.field_83027_i * this.field_83025_k);
            f5 = (float)((double)f9 * (1.0D - this.field_83024_j) * this.field_83025_k + (double)f8 * (1.0D - this.field_83024_j) * (1.0D - this.field_83025_k) + (double)f11 * this.field_83024_j * (1.0D - this.field_83025_k) + (double)f10 * this.field_83024_j * this.field_83025_k);
            f6 = (float)((double)f9 * (1.0D - this.field_83024_j) * this.field_83022_l + (double)f8 * (1.0D - this.field_83024_j) * (1.0D - this.field_83022_l) + (double)f11 * this.field_83024_j * (1.0D - this.field_83022_l) + (double)f10 * this.field_83024_j * this.field_83022_l);
            k1 = this.func_78602_a(this.field_78655_Y, this.field_78660_Z, this.field_78688_al, i1);
            j1 = this.func_78602_a(this.field_78688_al, this.field_78711_af, this.field_78707_ah, i1);
            i2 = this.func_78602_a(this.field_78692_aj, this.field_78709_ae, this.field_78711_af, i1);
            l1 = this.func_78602_a(this.field_78657_X, this.field_78655_Y, this.field_78692_aj, i1);
            this.field_78700_an = this.func_96444_a(k1, l1, i2, j1, (1.0D - this.field_83027_i) * this.field_83022_l, (1.0D - this.field_83027_i) * (1.0D - this.field_83022_l), this.field_83027_i * (1.0D - this.field_83022_l), this.field_83027_i * this.field_83022_l);
            this.field_78694_ao = this.func_96444_a(k1, l1, i2, j1, (1.0D - this.field_83027_i) * this.field_83025_k, (1.0D - this.field_83027_i) * (1.0D - this.field_83025_k), this.field_83027_i * (1.0D - this.field_83025_k), this.field_83027_i * this.field_83025_k);
            this.field_78696_ap = this.func_96444_a(k1, l1, i2, j1, (1.0D - this.field_83024_j) * this.field_83025_k, (1.0D - this.field_83024_j) * (1.0D - this.field_83025_k), this.field_83024_j * (1.0D - this.field_83025_k), this.field_83024_j * this.field_83025_k);
            this.field_78676_aq = this.func_96444_a(k1, l1, i2, j1, (1.0D - this.field_83024_j) * this.field_83022_l, (1.0D - this.field_83024_j) * (1.0D - this.field_83022_l), this.field_83024_j * (1.0D - this.field_83022_l), this.field_83024_j * this.field_83022_l);

            if (flag1)
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_ * 0.6F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_ * 0.6F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_ * 0.6F;
            }
            else
            {
                this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.6F;
                this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.6F;
                this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.6F;
            }

            this.field_78674_ar *= f3;
            this.field_78682_av *= f3;
            this.field_78663_az *= f3;
            this.field_78672_as *= f4;
            this.field_78680_aw *= f4;
            this.field_78650_aA *= f4;
            this.field_78670_at *= f5;
            this.field_78678_ax *= f5;
            this.field_78651_aB *= f5;
            this.field_78684_au *= f6;
            this.field_78665_ay *= f6;
            this.field_78652_aC *= f6;
            icon = this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 5);
            this.func_78605_f(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, icon);

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                this.field_78674_ar *= p_102027_5_;
                this.field_78672_as *= p_102027_5_;
                this.field_78670_at *= p_102027_5_;
                this.field_78684_au *= p_102027_5_;
                this.field_78682_av *= p_102027_6_;
                this.field_78680_aw *= p_102027_6_;
                this.field_78678_ax *= p_102027_6_;
                this.field_78665_ay *= p_102027_6_;
                this.field_78663_az *= p_102027_7_;
                this.field_78650_aA *= p_102027_7_;
                this.field_78651_aB *= p_102027_7_;
                this.field_78652_aC *= p_102027_7_;
                this.func_78605_f(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        this.field_78677_m = false;
        return flag;
    }

    public int func_78602_a(int p_78602_1_, int p_78602_2_, int p_78602_3_, int p_78602_4_)
    {
        if (p_78602_1_ == 0)
        {
            p_78602_1_ = p_78602_4_;
        }

        if (p_78602_2_ == 0)
        {
            p_78602_2_ = p_78602_4_;
        }

        if (p_78602_3_ == 0)
        {
            p_78602_3_ = p_78602_4_;
        }

        return p_78602_1_ + p_78602_2_ + p_78602_3_ + p_78602_4_ >> 2 & 16711935;
    }

    public int func_96444_a(int p_96444_1_, int p_96444_2_, int p_96444_3_, int p_96444_4_, double p_96444_5_, double p_96444_7_, double p_96444_9_, double p_96444_11_)
    {
        int i1 = (int)((double)(p_96444_1_ >> 16 & 255) * p_96444_5_ + (double)(p_96444_2_ >> 16 & 255) * p_96444_7_ + (double)(p_96444_3_ >> 16 & 255) * p_96444_9_ + (double)(p_96444_4_ >> 16 & 255) * p_96444_11_) & 255;
        int j1 = (int)((double)(p_96444_1_ & 255) * p_96444_5_ + (double)(p_96444_2_ & 255) * p_96444_7_ + (double)(p_96444_3_ & 255) * p_96444_9_ + (double)(p_96444_4_ & 255) * p_96444_11_) & 255;
        return i1 << 16 | j1;
    }

    public boolean func_78609_c(Block p_78609_1_, int p_78609_2_, int p_78609_3_, int p_78609_4_, float p_78609_5_, float p_78609_6_, float p_78609_7_)
    {
        this.field_78677_m = false;
        Tessellator tessellator = Tessellator.field_78398_a;
        boolean flag = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        float f7 = f4 * p_78609_5_;
        float f8 = f4 * p_78609_6_;
        float f9 = f4 * p_78609_7_;
        float f10 = f3;
        float f11 = f5;
        float f12 = f6;
        float f13 = f3;
        float f14 = f5;
        float f15 = f6;
        float f16 = f3;
        float f17 = f5;
        float f18 = f6;

        if (p_78609_1_ != Block.field_71980_u)
        {
            f10 = f3 * p_78609_5_;
            f11 = f5 * p_78609_5_;
            f12 = f6 * p_78609_5_;
            f13 = f3 * p_78609_6_;
            f14 = f5 * p_78609_6_;
            f15 = f6 * p_78609_6_;
            f16 = f3 * p_78609_7_;
            f17 = f5 * p_78609_7_;
            f18 = f6 * p_78609_7_;
        }

        int l = p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_);

        if (this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_ - 1, p_78609_4_, 0))
        {
            tessellator.func_78380_c(this.field_83027_i > 0.0D ? l : p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_ - 1, p_78609_4_));
            tessellator.func_78386_a(f10, f13, f16);
            this.func_78613_a(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 0));
            flag = true;
        }

        if (this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_ + 1, p_78609_4_, 1))
        {
            tessellator.func_78380_c(this.field_83024_j < 1.0D ? l : p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_ + 1, p_78609_4_));
            tessellator.func_78386_a(f7, f8, f9);
            this.func_78617_b(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 1));
            flag = true;
        }

        Icon icon;

        if (this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ - 1, 2))
        {
            tessellator.func_78380_c(this.field_83025_k > 0.0D ? l : p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ - 1));
            tessellator.func_78386_a(f11, f14, f17);
            icon = this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 2);
            this.func_78611_c(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, icon);

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                tessellator.func_78386_a(f11 * p_78609_5_, f14 * p_78609_6_, f17 * p_78609_7_);
                this.func_78611_c(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        if (this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ + 1, 3))
        {
            tessellator.func_78380_c(this.field_83022_l < 1.0D ? l : p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ + 1));
            tessellator.func_78386_a(f11, f14, f17);
            icon = this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 3);
            this.func_78622_d(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, icon);

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                tessellator.func_78386_a(f11 * p_78609_5_, f14 * p_78609_6_, f17 * p_78609_7_);
                this.func_78622_d(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        if (this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_ - 1, p_78609_3_, p_78609_4_, 4))
        {
            tessellator.func_78380_c(this.field_83021_g > 0.0D ? l : p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_ - 1, p_78609_3_, p_78609_4_));
            tessellator.func_78386_a(f12, f15, f18);
            icon = this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 4);
            this.func_78573_e(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, icon);

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                tessellator.func_78386_a(f12 * p_78609_5_, f15 * p_78609_6_, f18 * p_78609_7_);
                this.func_78573_e(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        if (this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_ + 1, p_78609_3_, p_78609_4_, 5))
        {
            tessellator.func_78380_c(this.field_83026_h < 1.0D ? l : p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_ + 1, p_78609_3_, p_78609_4_));
            tessellator.func_78386_a(f12, f15, f18);
            icon = this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 5);
            this.func_78605_f(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, icon);

            if (field_78667_b && icon.func_94215_i().equals("grass_side") && !this.func_94167_b())
            {
                tessellator.func_78386_a(f12 * p_78609_5_, f15 * p_78609_6_, f18 * p_78609_7_);
                this.func_78605_f(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, BlockGrass.func_94434_o());
            }

            flag = true;
        }

        return flag;
    }

    public boolean func_78616_a(BlockCocoa p_78616_1_, int p_78616_2_, int p_78616_3_, int p_78616_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_78616_1_.func_71874_e(this.field_78669_a, p_78616_2_, p_78616_3_, p_78616_4_));
        tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
        int l = this.field_78669_a.func_72805_g(p_78616_2_, p_78616_3_, p_78616_4_);
        int i1 = BlockDirectional.func_72217_d(l);
        int j1 = BlockCocoa.func_72219_c(l);
        Icon icon = p_78616_1_.func_94468_i_(j1);
        int k1 = 4 + j1 * 2;
        int l1 = 5 + j1 * 2;
        double d0 = 15.0D - (double)k1;
        double d1 = 15.0D;
        double d2 = 4.0D;
        double d3 = 4.0D + (double)l1;
        double d4 = (double)icon.func_94214_a(d0);
        double d5 = (double)icon.func_94214_a(d1);
        double d6 = (double)icon.func_94207_b(d2);
        double d7 = (double)icon.func_94207_b(d3);
        double d8 = 0.0D;
        double d9 = 0.0D;

        switch (i1)
        {
            case 0:
                d8 = 8.0D - (double)(k1 / 2);
                d9 = 15.0D - (double)k1;
                break;
            case 1:
                d8 = 1.0D;
                d9 = 8.0D - (double)(k1 / 2);
                break;
            case 2:
                d8 = 8.0D - (double)(k1 / 2);
                d9 = 1.0D;
                break;
            case 3:
                d8 = 15.0D - (double)k1;
                d9 = 8.0D - (double)(k1 / 2);
        }

        double d10 = (double)p_78616_2_ + d8 / 16.0D;
        double d11 = (double)p_78616_2_ + (d8 + (double)k1) / 16.0D;
        double d12 = (double)p_78616_3_ + (12.0D - (double)l1) / 16.0D;
        double d13 = (double)p_78616_3_ + 0.75D;
        double d14 = (double)p_78616_4_ + d9 / 16.0D;
        double d15 = (double)p_78616_4_ + (d9 + (double)k1) / 16.0D;
        tessellator.func_78374_a(d10, d12, d14, d4, d7);
        tessellator.func_78374_a(d10, d12, d15, d5, d7);
        tessellator.func_78374_a(d10, d13, d15, d5, d6);
        tessellator.func_78374_a(d10, d13, d14, d4, d6);
        tessellator.func_78374_a(d11, d12, d15, d4, d7);
        tessellator.func_78374_a(d11, d12, d14, d5, d7);
        tessellator.func_78374_a(d11, d13, d14, d5, d6);
        tessellator.func_78374_a(d11, d13, d15, d4, d6);
        tessellator.func_78374_a(d11, d12, d14, d4, d7);
        tessellator.func_78374_a(d10, d12, d14, d5, d7);
        tessellator.func_78374_a(d10, d13, d14, d5, d6);
        tessellator.func_78374_a(d11, d13, d14, d4, d6);
        tessellator.func_78374_a(d10, d12, d15, d4, d7);
        tessellator.func_78374_a(d11, d12, d15, d5, d7);
        tessellator.func_78374_a(d11, d13, d15, d5, d6);
        tessellator.func_78374_a(d10, d13, d15, d4, d6);
        int i2 = k1;

        if (j1 >= 2)
        {
            i2 = k1 - 1;
        }

        d4 = (double)icon.func_94209_e();
        d5 = (double)icon.func_94214_a((double)i2);
        d6 = (double)icon.func_94206_g();
        d7 = (double)icon.func_94207_b((double)i2);
        tessellator.func_78374_a(d10, d13, d15, d4, d7);
        tessellator.func_78374_a(d11, d13, d15, d5, d7);
        tessellator.func_78374_a(d11, d13, d14, d5, d6);
        tessellator.func_78374_a(d10, d13, d14, d4, d6);
        tessellator.func_78374_a(d10, d12, d14, d4, d6);
        tessellator.func_78374_a(d11, d12, d14, d5, d6);
        tessellator.func_78374_a(d11, d12, d15, d5, d7);
        tessellator.func_78374_a(d10, d12, d15, d4, d7);
        d4 = (double)icon.func_94214_a(12.0D);
        d5 = (double)icon.func_94212_f();
        d6 = (double)icon.func_94206_g();
        d7 = (double)icon.func_94207_b(4.0D);
        d8 = 8.0D;
        d9 = 0.0D;
        double d16;

        switch (i1)
        {
            case 0:
                d8 = 8.0D;
                d9 = 12.0D;
                d16 = d4;
                d4 = d5;
                d5 = d16;
                break;
            case 1:
                d8 = 0.0D;
                d9 = 8.0D;
                break;
            case 2:
                d8 = 8.0D;
                d9 = 0.0D;
                break;
            case 3:
                d8 = 12.0D;
                d9 = 8.0D;
                d16 = d4;
                d4 = d5;
                d5 = d16;
        }

        d10 = (double)p_78616_2_ + d8 / 16.0D;
        d11 = (double)p_78616_2_ + (d8 + 4.0D) / 16.0D;
        d12 = (double)p_78616_3_ + 0.75D;
        d13 = (double)p_78616_3_ + 1.0D;
        d14 = (double)p_78616_4_ + d9 / 16.0D;
        d15 = (double)p_78616_4_ + (d9 + 4.0D) / 16.0D;

        if (i1 != 2 && i1 != 0)
        {
            if (i1 == 1 || i1 == 3)
            {
                tessellator.func_78374_a(d11, d12, d14, d4, d7);
                tessellator.func_78374_a(d10, d12, d14, d5, d7);
                tessellator.func_78374_a(d10, d13, d14, d5, d6);
                tessellator.func_78374_a(d11, d13, d14, d4, d6);
                tessellator.func_78374_a(d10, d12, d14, d5, d7);
                tessellator.func_78374_a(d11, d12, d14, d4, d7);
                tessellator.func_78374_a(d11, d13, d14, d4, d6);
                tessellator.func_78374_a(d10, d13, d14, d5, d6);
            }
        }
        else
        {
            tessellator.func_78374_a(d10, d12, d14, d5, d7);
            tessellator.func_78374_a(d10, d12, d15, d4, d7);
            tessellator.func_78374_a(d10, d13, d15, d4, d6);
            tessellator.func_78374_a(d10, d13, d14, d5, d6);
            tessellator.func_78374_a(d10, d12, d15, d4, d7);
            tessellator.func_78374_a(d10, d12, d14, d5, d7);
            tessellator.func_78374_a(d10, d13, d14, d5, d6);
            tessellator.func_78374_a(d10, d13, d15, d4, d6);
        }

        return true;
    }

    public boolean func_82778_a(BlockBeacon p_82778_1_, int p_82778_2_, int p_82778_3_, int p_82778_4_)
    {
        float f = 0.1875F;
        this.func_82774_a(this.func_94175_b(Block.field_71946_M));
        this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        this.func_78570_q(p_82778_1_, p_82778_2_, p_82778_3_, p_82778_4_);
        this.field_78661_f = true;
        this.func_82774_a(this.func_94175_b(Block.field_72089_ap));
        this.func_83020_a(0.125D, 0.0062500000931322575D, 0.125D, 0.875D, (double)f, 0.875D);
        this.func_78570_q(p_82778_1_, p_82778_2_, p_82778_3_, p_82778_4_);
        this.func_82774_a(this.func_94175_b(Block.field_82518_cd));
        this.func_83020_a(0.1875D, (double)f, 0.1875D, 0.8125D, 0.875D, 0.8125D);
        this.func_78570_q(p_82778_1_, p_82778_2_, p_82778_3_, p_82778_4_);
        this.field_78661_f = false;
        this.func_78595_a();
        return true;
    }

    public boolean func_78584_s(Block p_78584_1_, int p_78584_2_, int p_78584_3_, int p_78584_4_)
    {
        int l = p_78584_1_.func_71920_b(this.field_78669_a, p_78584_2_, p_78584_3_, p_78584_4_);
        float f = (float)(l >> 16 & 255) / 255.0F;
        float f1 = (float)(l >> 8 & 255) / 255.0F;
        float f2 = (float)(l & 255) / 255.0F;

        if (EntityRenderer.field_78517_a)
        {
            float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
            float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
            float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }

        return this.func_78569_d(p_78584_1_, p_78584_2_, p_78584_3_, p_78584_4_, f, f1, f2);
    }

    public boolean func_78569_d(Block p_78569_1_, int p_78569_2_, int p_78569_3_, int p_78569_4_, float p_78569_5_, float p_78569_6_, float p_78569_7_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        boolean flag = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        float f7 = f3 * p_78569_5_;
        float f8 = f4 * p_78569_5_;
        float f9 = f5 * p_78569_5_;
        float f10 = f6 * p_78569_5_;
        float f11 = f3 * p_78569_6_;
        float f12 = f4 * p_78569_6_;
        float f13 = f5 * p_78569_6_;
        float f14 = f6 * p_78569_6_;
        float f15 = f3 * p_78569_7_;
        float f16 = f4 * p_78569_7_;
        float f17 = f5 * p_78569_7_;
        float f18 = f6 * p_78569_7_;
        float f19 = 0.0625F;
        int l = p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_);

        if (this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_, p_78569_3_ - 1, p_78569_4_, 0))
        {
            tessellator.func_78380_c(this.field_83027_i > 0.0D ? l : p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_ - 1, p_78569_4_));
            tessellator.func_78386_a(f7, f11, f15);
            this.func_78613_a(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 0));
        }

        if (this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_, p_78569_3_ + 1, p_78569_4_, 1))
        {
            tessellator.func_78380_c(this.field_83024_j < 1.0D ? l : p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_ + 1, p_78569_4_));
            tessellator.func_78386_a(f8, f12, f16);
            this.func_78617_b(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 1));
        }

        tessellator.func_78380_c(l);
        tessellator.func_78386_a(f9, f13, f17);
        tessellator.func_78372_c(0.0F, 0.0F, f19);
        this.func_78611_c(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 2));
        tessellator.func_78372_c(0.0F, 0.0F, -f19);
        tessellator.func_78372_c(0.0F, 0.0F, -f19);
        this.func_78622_d(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 3));
        tessellator.func_78372_c(0.0F, 0.0F, f19);
        tessellator.func_78386_a(f10, f14, f18);
        tessellator.func_78372_c(f19, 0.0F, 0.0F);
        this.func_78573_e(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 4));
        tessellator.func_78372_c(-f19, 0.0F, 0.0F);
        tessellator.func_78372_c(-f19, 0.0F, 0.0F);
        this.func_78605_f(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 5));
        tessellator.func_78372_c(f19, 0.0F, 0.0F);
        return true;
    }

    public boolean func_78582_a(BlockFence p_78582_1_, int p_78582_2_, int p_78582_3_, int p_78582_4_)
    {
        boolean flag = false;
        float f = 0.375F;
        float f1 = 0.625F;
        this.func_83020_a((double)f, 0.0D, (double)f, (double)f1, 1.0D, (double)f1);
        this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
        flag = true;
        boolean flag1 = false;
        boolean flag2 = false;

        if (p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ - 1, p_78582_3_, p_78582_4_) || p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ + 1, p_78582_3_, p_78582_4_))
        {
            flag1 = true;
        }

        if (p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ - 1) || p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ + 1))
        {
            flag2 = true;
        }

        boolean flag3 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ - 1, p_78582_3_, p_78582_4_);
        boolean flag4 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ + 1, p_78582_3_, p_78582_4_);
        boolean flag5 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ - 1);
        boolean flag6 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ + 1);

        if (!flag1 && !flag2)
        {
            flag1 = true;
        }

        f = 0.4375F;
        f1 = 0.5625F;
        float f2 = 0.75F;
        float f3 = 0.9375F;
        float f4 = flag3 ? 0.0F : f;
        float f5 = flag4 ? 1.0F : f1;
        float f6 = flag5 ? 0.0F : f;
        float f7 = flag6 ? 1.0F : f1;

        if (flag1)
        {
            this.func_83020_a((double)f4, (double)f2, (double)f, (double)f5, (double)f3, (double)f1);
            this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
            flag = true;
        }

        if (flag2)
        {
            this.func_83020_a((double)f, (double)f2, (double)f6, (double)f1, (double)f3, (double)f7);
            this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
            flag = true;
        }

        f2 = 0.375F;
        f3 = 0.5625F;

        if (flag1)
        {
            this.func_83020_a((double)f4, (double)f2, (double)f, (double)f5, (double)f3, (double)f1);
            this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
            flag = true;
        }

        if (flag2)
        {
            this.func_83020_a((double)f, (double)f2, (double)f6, (double)f1, (double)f3, (double)f7);
            this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
            flag = true;
        }

        p_78582_1_.func_71902_a(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_);
        return flag;
    }

    public boolean func_82779_a(BlockWall p_82779_1_, int p_82779_2_, int p_82779_3_, int p_82779_4_)
    {
        boolean flag = p_82779_1_.func_82538_d(this.field_78669_a, p_82779_2_ - 1, p_82779_3_, p_82779_4_);
        boolean flag1 = p_82779_1_.func_82538_d(this.field_78669_a, p_82779_2_ + 1, p_82779_3_, p_82779_4_);
        boolean flag2 = p_82779_1_.func_82538_d(this.field_78669_a, p_82779_2_, p_82779_3_, p_82779_4_ - 1);
        boolean flag3 = p_82779_1_.func_82538_d(this.field_78669_a, p_82779_2_, p_82779_3_, p_82779_4_ + 1);
        boolean flag4 = flag2 && flag3 && !flag && !flag1;
        boolean flag5 = !flag2 && !flag3 && flag && flag1;
        boolean flag6 = this.field_78669_a.func_72799_c(p_82779_2_, p_82779_3_ + 1, p_82779_4_);

        if ((flag4 || flag5) && flag6)
        {
            if (flag4)
            {
                this.func_83020_a(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 1.0D);
                this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
            }
            else
            {
                this.func_83020_a(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
                this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
            }
        }
        else
        {
            this.func_83020_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
            this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);

            if (flag)
            {
                this.func_83020_a(0.0D, 0.0D, 0.3125D, 0.25D, 0.8125D, 0.6875D);
                this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
            }

            if (flag1)
            {
                this.func_83020_a(0.75D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
                this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
            }

            if (flag2)
            {
                this.func_83020_a(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 0.25D);
                this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
            }

            if (flag3)
            {
                this.func_83020_a(0.3125D, 0.0D, 0.75D, 0.6875D, 0.8125D, 1.0D);
                this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
            }
        }

        p_82779_1_.func_71902_a(this.field_78669_a, p_82779_2_, p_82779_3_, p_82779_4_);
        return true;
    }

    public boolean func_78618_a(BlockDragonEgg p_78618_1_, int p_78618_2_, int p_78618_3_, int p_78618_4_)
    {
        boolean flag = false;
        int l = 0;

        for (int i1 = 0; i1 < 8; ++i1)
        {
            byte b0 = 0;
            byte b1 = 1;

            if (i1 == 0)
            {
                b0 = 2;
            }

            if (i1 == 1)
            {
                b0 = 3;
            }

            if (i1 == 2)
            {
                b0 = 4;
            }

            if (i1 == 3)
            {
                b0 = 5;
                b1 = 2;
            }

            if (i1 == 4)
            {
                b0 = 6;
                b1 = 3;
            }

            if (i1 == 5)
            {
                b0 = 7;
                b1 = 5;
            }

            if (i1 == 6)
            {
                b0 = 6;
                b1 = 2;
            }

            if (i1 == 7)
            {
                b0 = 3;
            }

            float f = (float)b0 / 16.0F;
            float f1 = 1.0F - (float)l / 16.0F;
            float f2 = 1.0F - (float)(l + b1) / 16.0F;
            l += b1;
            this.func_83020_a((double)(0.5F - f), (double)f2, (double)(0.5F - f), (double)(0.5F + f), (double)f1, (double)(0.5F + f));
            this.func_78570_q(p_78618_1_, p_78618_2_, p_78618_3_, p_78618_4_);
        }

        flag = true;
        this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        return flag;
    }

    public boolean func_78580_a(BlockFenceGate p_78580_1_, int p_78580_2_, int p_78580_3_, int p_78580_4_)
    {
        boolean flag = true;
        int l = this.field_78669_a.func_72805_g(p_78580_2_, p_78580_3_, p_78580_4_);
        boolean flag1 = BlockFenceGate.func_72224_c(l);
        int i1 = BlockDirectional.func_72217_d(l);
        float f = 0.375F;
        float f1 = 0.5625F;
        float f2 = 0.75F;
        float f3 = 0.9375F;
        float f4 = 0.3125F;
        float f5 = 1.0F;

        if ((i1 == 2 || i1 == 0) && this.field_78669_a.func_72798_a(p_78580_2_ - 1, p_78580_3_, p_78580_4_) == Block.field_82515_ce.field_71990_ca && this.field_78669_a.func_72798_a(p_78580_2_ + 1, p_78580_3_, p_78580_4_) == Block.field_82515_ce.field_71990_ca || (i1 == 3 || i1 == 1) && this.field_78669_a.func_72798_a(p_78580_2_, p_78580_3_, p_78580_4_ - 1) == Block.field_82515_ce.field_71990_ca && this.field_78669_a.func_72798_a(p_78580_2_, p_78580_3_, p_78580_4_ + 1) == Block.field_82515_ce.field_71990_ca)
        {
            f -= 0.1875F;
            f1 -= 0.1875F;
            f2 -= 0.1875F;
            f3 -= 0.1875F;
            f4 -= 0.1875F;
            f5 -= 0.1875F;
        }

        this.field_78661_f = true;
        float f6;
        float f7;
        float f8;
        float f9;

        if (i1 != 3 && i1 != 1)
        {
            f6 = 0.0F;
            f8 = 0.125F;
            f7 = 0.4375F;
            f9 = 0.5625F;
            this.func_83020_a((double)f6, (double)f4, (double)f7, (double)f8, (double)f5, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f6 = 0.875F;
            f8 = 1.0F;
            this.func_83020_a((double)f6, (double)f4, (double)f7, (double)f8, (double)f5, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
        }
        else
        {
            this.field_78681_k = 1;
            f6 = 0.4375F;
            f8 = 0.5625F;
            f7 = 0.0F;
            f9 = 0.125F;
            this.func_83020_a((double)f6, (double)f4, (double)f7, (double)f8, (double)f5, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f7 = 0.875F;
            f9 = 1.0F;
            this.func_83020_a((double)f6, (double)f4, (double)f7, (double)f8, (double)f5, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.field_78681_k = 0;
        }

        if (flag1)
        {
            if (i1 == 2 || i1 == 0)
            {
                this.field_78681_k = 1;
            }

            float f10;
            float f11;
            float f12;

            if (i1 == 3)
            {
                f6 = 0.0F;
                f8 = 0.125F;
                f7 = 0.875F;
                f9 = 1.0F;
                f10 = 0.5625F;
                f12 = 0.8125F;
                f11 = 0.9375F;
                this.func_83020_a(0.8125D, (double)f, 0.0D, 0.9375D, (double)f3, 0.125D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.8125D, (double)f, 0.875D, 0.9375D, (double)f3, 1.0D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.5625D, (double)f, 0.0D, 0.8125D, (double)f1, 0.125D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.5625D, (double)f, 0.875D, 0.8125D, (double)f1, 1.0D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.5625D, (double)f2, 0.0D, 0.8125D, (double)f3, 0.125D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.5625D, (double)f2, 0.875D, 0.8125D, (double)f3, 1.0D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            }
            else if (i1 == 1)
            {
                f6 = 0.0F;
                f8 = 0.125F;
                f7 = 0.875F;
                f9 = 1.0F;
                f10 = 0.0625F;
                f12 = 0.1875F;
                f11 = 0.4375F;
                this.func_83020_a(0.0625D, (double)f, 0.0D, 0.1875D, (double)f3, 0.125D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.0625D, (double)f, 0.875D, 0.1875D, (double)f3, 1.0D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.1875D, (double)f, 0.0D, 0.4375D, (double)f1, 0.125D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.1875D, (double)f, 0.875D, 0.4375D, (double)f1, 1.0D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.1875D, (double)f2, 0.0D, 0.4375D, (double)f3, 0.125D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.1875D, (double)f2, 0.875D, 0.4375D, (double)f3, 1.0D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            }
            else if (i1 == 0)
            {
                f6 = 0.0F;
                f8 = 0.125F;
                f7 = 0.875F;
                f9 = 1.0F;
                f10 = 0.5625F;
                f12 = 0.8125F;
                f11 = 0.9375F;
                this.func_83020_a(0.0D, (double)f, 0.8125D, 0.125D, (double)f3, 0.9375D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.875D, (double)f, 0.8125D, 1.0D, (double)f3, 0.9375D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.0D, (double)f, 0.5625D, 0.125D, (double)f1, 0.8125D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.875D, (double)f, 0.5625D, 1.0D, (double)f1, 0.8125D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.0D, (double)f2, 0.5625D, 0.125D, (double)f3, 0.8125D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.875D, (double)f2, 0.5625D, 1.0D, (double)f3, 0.8125D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            }
            else if (i1 == 2)
            {
                f6 = 0.0F;
                f8 = 0.125F;
                f7 = 0.875F;
                f9 = 1.0F;
                f10 = 0.0625F;
                f12 = 0.1875F;
                f11 = 0.4375F;
                this.func_83020_a(0.0D, (double)f, 0.0625D, 0.125D, (double)f3, 0.1875D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.875D, (double)f, 0.0625D, 1.0D, (double)f3, 0.1875D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.0D, (double)f, 0.1875D, 0.125D, (double)f1, 0.4375D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.875D, (double)f, 0.1875D, 1.0D, (double)f1, 0.4375D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.0D, (double)f2, 0.1875D, 0.125D, (double)f3, 0.4375D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
                this.func_83020_a(0.875D, (double)f2, 0.1875D, 1.0D, (double)f3, 0.4375D);
                this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            }
        }
        else if (i1 != 3 && i1 != 1)
        {
            f6 = 0.375F;
            f8 = 0.5F;
            f7 = 0.4375F;
            f9 = 0.5625F;
            this.func_83020_a((double)f6, (double)f, (double)f7, (double)f8, (double)f3, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f6 = 0.5F;
            f8 = 0.625F;
            this.func_83020_a((double)f6, (double)f, (double)f7, (double)f8, (double)f3, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f6 = 0.625F;
            f8 = 0.875F;
            this.func_83020_a((double)f6, (double)f, (double)f7, (double)f8, (double)f1, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a((double)f6, (double)f2, (double)f7, (double)f8, (double)f3, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f6 = 0.125F;
            f8 = 0.375F;
            this.func_83020_a((double)f6, (double)f, (double)f7, (double)f8, (double)f1, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a((double)f6, (double)f2, (double)f7, (double)f8, (double)f3, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
        }
        else
        {
            this.field_78681_k = 1;
            f6 = 0.4375F;
            f8 = 0.5625F;
            f7 = 0.375F;
            f9 = 0.5F;
            this.func_83020_a((double)f6, (double)f, (double)f7, (double)f8, (double)f3, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f7 = 0.5F;
            f9 = 0.625F;
            this.func_83020_a((double)f6, (double)f, (double)f7, (double)f8, (double)f3, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f7 = 0.625F;
            f9 = 0.875F;
            this.func_83020_a((double)f6, (double)f, (double)f7, (double)f8, (double)f1, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a((double)f6, (double)f2, (double)f7, (double)f8, (double)f3, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            f7 = 0.125F;
            f9 = 0.375F;
            this.func_83020_a((double)f6, (double)f, (double)f7, (double)f8, (double)f1, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a((double)f6, (double)f2, (double)f7, (double)f8, (double)f3, (double)f9);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
        }

        this.field_78661_f = false;
        this.field_78681_k = 0;
        this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        return flag;
    }

    public boolean func_94172_a(BlockHopper p_94172_1_, int p_94172_2_, int p_94172_3_, int p_94172_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78380_c(p_94172_1_.func_71874_e(this.field_78669_a, p_94172_2_, p_94172_3_, p_94172_4_));
        float f = 1.0F;
        int l = p_94172_1_.func_71920_b(this.field_78669_a, p_94172_2_, p_94172_3_, p_94172_4_);
        float f1 = (float)(l >> 16 & 255) / 255.0F;
        float f2 = (float)(l >> 8 & 255) / 255.0F;
        float f3 = (float)(l & 255) / 255.0F;

        if (EntityRenderer.field_78517_a)
        {
            float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }

        tessellator.func_78386_a(f * f1, f * f2, f * f3);
        return this.func_96447_a(p_94172_1_, p_94172_2_, p_94172_3_, p_94172_4_, this.field_78669_a.func_72805_g(p_94172_2_, p_94172_3_, p_94172_4_), false);
    }

    public boolean func_96447_a(BlockHopper p_96447_1_, int p_96447_2_, int p_96447_3_, int p_96447_4_, int p_96447_5_, boolean p_96447_6_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int i1 = BlockHopper.func_94451_c(p_96447_5_);
        double d0 = 0.625D;
        this.func_83020_a(0.0D, d0, 0.0D, 1.0D, 1.0D, 1.0D);

        if (p_96447_6_)
        {
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78613_a(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 0, p_96447_5_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
            this.func_78617_b(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 1, p_96447_5_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
            this.func_78611_c(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 2, p_96447_5_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
            this.func_78622_d(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 3, p_96447_5_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
            this.func_78573_e(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 4, p_96447_5_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
            this.func_78605_f(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 5, p_96447_5_));
            tessellator.func_78381_a();
        }
        else
        {
            this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
        }

        float f;

        if (!p_96447_6_)
        {
            tessellator.func_78380_c(p_96447_1_.func_71874_e(this.field_78669_a, p_96447_2_, p_96447_3_, p_96447_4_));
            float f1 = 1.0F;
            int j1 = p_96447_1_.func_71920_b(this.field_78669_a, p_96447_2_, p_96447_3_, p_96447_4_);
            f = (float)(j1 >> 16 & 255) / 255.0F;
            float f2 = (float)(j1 >> 8 & 255) / 255.0F;
            float f3 = (float)(j1 & 255) / 255.0F;

            if (EntityRenderer.field_78517_a)
            {
                float f4 = (f * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
                float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
                float f6 = (f * 30.0F + f3 * 70.0F) / 100.0F;
                f = f4;
                f2 = f5;
                f3 = f6;
            }

            tessellator.func_78386_a(f1 * f, f1 * f2, f1 * f3);
        }

        Icon icon = BlockHopper.func_94453_b("hopper_outside");
        Icon icon1 = BlockHopper.func_94453_b("hopper_inside");
        f = 0.125F;

        if (p_96447_6_)
        {
            tessellator.func_78382_b();
            tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
            this.func_78605_f(p_96447_1_, (double)(-1.0F + f), 0.0D, 0.0D, icon);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
            this.func_78573_e(p_96447_1_, (double)(1.0F - f), 0.0D, 0.0D, icon);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
            this.func_78622_d(p_96447_1_, 0.0D, 0.0D, (double)(-1.0F + f), icon);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
            this.func_78611_c(p_96447_1_, 0.0D, 0.0D, (double)(1.0F - f), icon);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
            this.func_78617_b(p_96447_1_, 0.0D, -1.0D + d0, 0.0D, icon1);
            tessellator.func_78381_a();
        }
        else
        {
            this.func_78605_f(p_96447_1_, (double)((float)p_96447_2_ - 1.0F + f), (double)p_96447_3_, (double)p_96447_4_, icon);
            this.func_78573_e(p_96447_1_, (double)((float)p_96447_2_ + 1.0F - f), (double)p_96447_3_, (double)p_96447_4_, icon);
            this.func_78622_d(p_96447_1_, (double)p_96447_2_, (double)p_96447_3_, (double)((float)p_96447_4_ - 1.0F + f), icon);
            this.func_78611_c(p_96447_1_, (double)p_96447_2_, (double)p_96447_3_, (double)((float)p_96447_4_ + 1.0F - f), icon);
            this.func_78617_b(p_96447_1_, (double)p_96447_2_, (double)((float)p_96447_3_ - 1.0F) + d0, (double)p_96447_4_, icon1);
        }

        this.func_82774_a(icon);
        double d1 = 0.25D;
        double d2 = 0.25D;
        this.func_83020_a(d1, d2, d1, 1.0D - d1, d0 - 0.002D, 1.0D - d1);

        if (p_96447_6_)
        {
            tessellator.func_78382_b();
            tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
            this.func_78605_f(p_96447_1_, 0.0D, 0.0D, 0.0D, icon);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
            this.func_78573_e(p_96447_1_, 0.0D, 0.0D, 0.0D, icon);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
            this.func_78622_d(p_96447_1_, 0.0D, 0.0D, 0.0D, icon);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
            this.func_78611_c(p_96447_1_, 0.0D, 0.0D, 0.0D, icon);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
            this.func_78617_b(p_96447_1_, 0.0D, 0.0D, 0.0D, icon);
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78613_a(p_96447_1_, 0.0D, 0.0D, 0.0D, icon);
            tessellator.func_78381_a();
        }
        else
        {
            this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
        }

        if (!p_96447_6_)
        {
            double d3 = 0.375D;
            double d4 = 0.25D;
            this.func_82774_a(icon);

            if (i1 == 0)
            {
                this.func_83020_a(d3, 0.0D, d3, 1.0D - d3, 0.25D, 1.0D - d3);
                this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
            }

            if (i1 == 2)
            {
                this.func_83020_a(d3, d2, 0.0D, 1.0D - d3, d2 + d4, d1);
                this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
            }

            if (i1 == 3)
            {
                this.func_83020_a(d3, d2, 1.0D - d1, 1.0D - d3, d2 + d4, 1.0D);
                this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
            }

            if (i1 == 4)
            {
                this.func_83020_a(0.0D, d2, d3, d1, d2 + d4, 1.0D - d3);
                this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
            }

            if (i1 == 5)
            {
                this.func_83020_a(1.0D - d1, d2, d3, 1.0D, d2 + d4, 1.0D - d3);
                this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
            }
        }

        this.func_78595_a();
        return true;
    }

    public boolean func_78565_t(BlockStairs p_78565_1_, int p_78565_2_, int p_78565_3_, int p_78565_4_)
    {
        p_78565_1_.func_82541_d(this.field_78669_a, p_78565_2_, p_78565_3_, p_78565_4_);
        this.func_83018_a(p_78565_1_);
        this.func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
        boolean flag = p_78565_1_.func_82542_g(this.field_78669_a, p_78565_2_, p_78565_3_, p_78565_4_);
        this.func_83018_a(p_78565_1_);
        this.func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);

        if (flag && p_78565_1_.func_82544_h(this.field_78669_a, p_78565_2_, p_78565_3_, p_78565_4_))
        {
            this.func_83018_a(p_78565_1_);
            this.func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
        }

        return true;
    }

    public boolean func_78601_u(Block p_78601_1_, int p_78601_2_, int p_78601_3_, int p_78601_4_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        int l = this.field_78669_a.func_72805_g(p_78601_2_, p_78601_3_, p_78601_4_);

        if ((l & 8) != 0)
        {
            if (this.field_78669_a.func_72798_a(p_78601_2_, p_78601_3_ - 1, p_78601_4_) != p_78601_1_.field_71990_ca)
            {
                return false;
            }
        }
        else if (this.field_78669_a.func_72798_a(p_78601_2_, p_78601_3_ + 1, p_78601_4_) != p_78601_1_.field_71990_ca)
        {
            return false;
        }

        boolean flag = false;
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        int i1 = p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_);
        tessellator.func_78380_c(this.field_83027_i > 0.0D ? i1 : p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_ - 1, p_78601_4_));
        tessellator.func_78386_a(f, f, f);
        this.func_78613_a(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 0));
        flag = true;
        tessellator.func_78380_c(this.field_83024_j < 1.0D ? i1 : p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_ + 1, p_78601_4_));
        tessellator.func_78386_a(f1, f1, f1);
        this.func_78617_b(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 1));
        flag = true;
        tessellator.func_78380_c(this.field_83025_k > 0.0D ? i1 : p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_ - 1));
        tessellator.func_78386_a(f2, f2, f2);
        Icon icon = this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 2);
        this.func_78611_c(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, icon);
        flag = true;
        this.field_78666_e = false;
        tessellator.func_78380_c(this.field_83022_l < 1.0D ? i1 : p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_ + 1));
        tessellator.func_78386_a(f2, f2, f2);
        icon = this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 3);
        this.func_78622_d(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, icon);
        flag = true;
        this.field_78666_e = false;
        tessellator.func_78380_c(this.field_83021_g > 0.0D ? i1 : p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_ - 1, p_78601_3_, p_78601_4_));
        tessellator.func_78386_a(f3, f3, f3);
        icon = this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 4);
        this.func_78573_e(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, icon);
        flag = true;
        this.field_78666_e = false;
        tessellator.func_78380_c(this.field_83026_h < 1.0D ? i1 : p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_ + 1, p_78601_3_, p_78601_4_));
        tessellator.func_78386_a(f3, f3, f3);
        icon = this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 5);
        this.func_78605_f(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, icon);
        flag = true;
        this.field_78666_e = false;
        return flag;
    }

    public void func_78613_a(Block p_78613_1_, double p_78613_2_, double p_78613_4_, double p_78613_6_, Icon p_78613_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;

        if (this.func_94167_b())
        {
            p_78613_8_ = this.field_78664_d;
        }

        double d3 = (double)p_78613_8_.func_94214_a(this.field_83021_g * 16.0D);
        double d4 = (double)p_78613_8_.func_94214_a(this.field_83026_h * 16.0D);
        double d5 = (double)p_78613_8_.func_94207_b(this.field_83025_k * 16.0D);
        double d6 = (double)p_78613_8_.func_94207_b(this.field_83022_l * 16.0D);

        if (this.field_83021_g < 0.0D || this.field_83026_h > 1.0D)
        {
            d3 = (double)p_78613_8_.func_94209_e();
            d4 = (double)p_78613_8_.func_94212_f();
        }

        if (this.field_83025_k < 0.0D || this.field_83022_l > 1.0D)
        {
            d5 = (double)p_78613_8_.func_94206_g();
            d6 = (double)p_78613_8_.func_94210_h();
        }

        double d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (this.field_78675_l == 2)
        {
            d3 = (double)p_78613_8_.func_94214_a(this.field_83025_k * 16.0D);
            d5 = (double)p_78613_8_.func_94207_b(16.0D - this.field_83026_h * 16.0D);
            d4 = (double)p_78613_8_.func_94214_a(this.field_83022_l * 16.0D);
            d6 = (double)p_78613_8_.func_94207_b(16.0D - this.field_83021_g * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (this.field_78675_l == 1)
        {
            d3 = (double)p_78613_8_.func_94214_a(16.0D - this.field_83022_l * 16.0D);
            d5 = (double)p_78613_8_.func_94207_b(this.field_83021_g * 16.0D);
            d4 = (double)p_78613_8_.func_94214_a(16.0D - this.field_83025_k * 16.0D);
            d6 = (double)p_78613_8_.func_94207_b(this.field_83026_h * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (this.field_78675_l == 3)
        {
            d3 = (double)p_78613_8_.func_94214_a(16.0D - this.field_83021_g * 16.0D);
            d4 = (double)p_78613_8_.func_94214_a(16.0D - this.field_83026_h * 16.0D);
            d5 = (double)p_78613_8_.func_94207_b(16.0D - this.field_83025_k * 16.0D);
            d6 = (double)p_78613_8_.func_94207_b(16.0D - this.field_83022_l * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = p_78613_2_ + this.field_83021_g;
        double d12 = p_78613_2_ + this.field_83026_h;
        double d13 = p_78613_4_ + this.field_83027_i;
        double d14 = p_78613_6_ + this.field_83025_k;
        double d15 = p_78613_6_ + this.field_83022_l;

        if (this.field_78677_m)
        {
            tessellator.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
            tessellator.func_78380_c(this.field_78700_an);
            tessellator.func_78374_a(d11, d13, d15, d8, d10);
            tessellator.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
            tessellator.func_78380_c(this.field_78694_ao);
            tessellator.func_78374_a(d11, d13, d14, d3, d5);
            tessellator.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
            tessellator.func_78380_c(this.field_78696_ap);
            tessellator.func_78374_a(d12, d13, d14, d7, d9);
            tessellator.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
            tessellator.func_78380_c(this.field_78676_aq);
            tessellator.func_78374_a(d12, d13, d15, d4, d6);
        }
        else
        {
            tessellator.func_78374_a(d11, d13, d15, d8, d10);
            tessellator.func_78374_a(d11, d13, d14, d3, d5);
            tessellator.func_78374_a(d12, d13, d14, d7, d9);
            tessellator.func_78374_a(d12, d13, d15, d4, d6);
        }
    }

    public void func_78617_b(Block p_78617_1_, double p_78617_2_, double p_78617_4_, double p_78617_6_, Icon p_78617_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;

        if (this.func_94167_b())
        {
            p_78617_8_ = this.field_78664_d;
        }

        double d3 = (double)p_78617_8_.func_94214_a(this.field_83021_g * 16.0D);
        double d4 = (double)p_78617_8_.func_94214_a(this.field_83026_h * 16.0D);
        double d5 = (double)p_78617_8_.func_94207_b(this.field_83025_k * 16.0D);
        double d6 = (double)p_78617_8_.func_94207_b(this.field_83022_l * 16.0D);

        if (this.field_83021_g < 0.0D || this.field_83026_h > 1.0D)
        {
            d3 = (double)p_78617_8_.func_94209_e();
            d4 = (double)p_78617_8_.func_94212_f();
        }

        if (this.field_83025_k < 0.0D || this.field_83022_l > 1.0D)
        {
            d5 = (double)p_78617_8_.func_94206_g();
            d6 = (double)p_78617_8_.func_94210_h();
        }

        double d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (this.field_78681_k == 1)
        {
            d3 = (double)p_78617_8_.func_94214_a(this.field_83025_k * 16.0D);
            d5 = (double)p_78617_8_.func_94207_b(16.0D - this.field_83026_h * 16.0D);
            d4 = (double)p_78617_8_.func_94214_a(this.field_83022_l * 16.0D);
            d6 = (double)p_78617_8_.func_94207_b(16.0D - this.field_83021_g * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (this.field_78681_k == 2)
        {
            d3 = (double)p_78617_8_.func_94214_a(16.0D - this.field_83022_l * 16.0D);
            d5 = (double)p_78617_8_.func_94207_b(this.field_83021_g * 16.0D);
            d4 = (double)p_78617_8_.func_94214_a(16.0D - this.field_83025_k * 16.0D);
            d6 = (double)p_78617_8_.func_94207_b(this.field_83026_h * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (this.field_78681_k == 3)
        {
            d3 = (double)p_78617_8_.func_94214_a(16.0D - this.field_83021_g * 16.0D);
            d4 = (double)p_78617_8_.func_94214_a(16.0D - this.field_83026_h * 16.0D);
            d5 = (double)p_78617_8_.func_94207_b(16.0D - this.field_83025_k * 16.0D);
            d6 = (double)p_78617_8_.func_94207_b(16.0D - this.field_83022_l * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = p_78617_2_ + this.field_83021_g;
        double d12 = p_78617_2_ + this.field_83026_h;
        double d13 = p_78617_4_ + this.field_83024_j;
        double d14 = p_78617_6_ + this.field_83025_k;
        double d15 = p_78617_6_ + this.field_83022_l;

        if (this.field_78677_m)
        {
            tessellator.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
            tessellator.func_78380_c(this.field_78700_an);
            tessellator.func_78374_a(d12, d13, d15, d4, d6);
            tessellator.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
            tessellator.func_78380_c(this.field_78694_ao);
            tessellator.func_78374_a(d12, d13, d14, d7, d9);
            tessellator.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
            tessellator.func_78380_c(this.field_78696_ap);
            tessellator.func_78374_a(d11, d13, d14, d3, d5);
            tessellator.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
            tessellator.func_78380_c(this.field_78676_aq);
            tessellator.func_78374_a(d11, d13, d15, d8, d10);
        }
        else
        {
            tessellator.func_78374_a(d12, d13, d15, d4, d6);
            tessellator.func_78374_a(d12, d13, d14, d7, d9);
            tessellator.func_78374_a(d11, d13, d14, d3, d5);
            tessellator.func_78374_a(d11, d13, d15, d8, d10);
        }
    }

    public void func_78611_c(Block p_78611_1_, double p_78611_2_, double p_78611_4_, double p_78611_6_, Icon p_78611_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;

        if (this.func_94167_b())
        {
            p_78611_8_ = this.field_78664_d;
        }

        double d3 = (double)p_78611_8_.func_94214_a(this.field_83021_g * 16.0D);
        double d4 = (double)p_78611_8_.func_94214_a(this.field_83026_h * 16.0D);
        double d5 = (double)p_78611_8_.func_94207_b(16.0D - this.field_83024_j * 16.0D);
        double d6 = (double)p_78611_8_.func_94207_b(16.0D - this.field_83027_i * 16.0D);
        double d7;

        if (this.field_78666_e)
        {
            d7 = d3;
            d3 = d4;
            d4 = d7;
        }

        if (this.field_83021_g < 0.0D || this.field_83026_h > 1.0D)
        {
            d3 = (double)p_78611_8_.func_94209_e();
            d4 = (double)p_78611_8_.func_94212_f();
        }

        if (this.field_83027_i < 0.0D || this.field_83024_j > 1.0D)
        {
            d5 = (double)p_78611_8_.func_94206_g();
            d6 = (double)p_78611_8_.func_94210_h();
        }

        d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (this.field_78662_g == 2)
        {
            d3 = (double)p_78611_8_.func_94214_a(this.field_83027_i * 16.0D);
            d5 = (double)p_78611_8_.func_94207_b(16.0D - this.field_83021_g * 16.0D);
            d4 = (double)p_78611_8_.func_94214_a(this.field_83024_j * 16.0D);
            d6 = (double)p_78611_8_.func_94207_b(16.0D - this.field_83026_h * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (this.field_78662_g == 1)
        {
            d3 = (double)p_78611_8_.func_94214_a(16.0D - this.field_83024_j * 16.0D);
            d5 = (double)p_78611_8_.func_94207_b(this.field_83026_h * 16.0D);
            d4 = (double)p_78611_8_.func_94214_a(16.0D - this.field_83027_i * 16.0D);
            d6 = (double)p_78611_8_.func_94207_b(this.field_83021_g * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (this.field_78662_g == 3)
        {
            d3 = (double)p_78611_8_.func_94214_a(16.0D - this.field_83021_g * 16.0D);
            d4 = (double)p_78611_8_.func_94214_a(16.0D - this.field_83026_h * 16.0D);
            d5 = (double)p_78611_8_.func_94207_b(this.field_83024_j * 16.0D);
            d6 = (double)p_78611_8_.func_94207_b(this.field_83027_i * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = p_78611_2_ + this.field_83021_g;
        double d12 = p_78611_2_ + this.field_83026_h;
        double d13 = p_78611_4_ + this.field_83027_i;
        double d14 = p_78611_4_ + this.field_83024_j;
        double d15 = p_78611_6_ + this.field_83025_k;

        if (this.field_78677_m)
        {
            tessellator.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
            tessellator.func_78380_c(this.field_78700_an);
            tessellator.func_78374_a(d11, d14, d15, d7, d9);
            tessellator.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
            tessellator.func_78380_c(this.field_78694_ao);
            tessellator.func_78374_a(d12, d14, d15, d3, d5);
            tessellator.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
            tessellator.func_78380_c(this.field_78696_ap);
            tessellator.func_78374_a(d12, d13, d15, d8, d10);
            tessellator.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
            tessellator.func_78380_c(this.field_78676_aq);
            tessellator.func_78374_a(d11, d13, d15, d4, d6);
        }
        else
        {
            tessellator.func_78374_a(d11, d14, d15, d7, d9);
            tessellator.func_78374_a(d12, d14, d15, d3, d5);
            tessellator.func_78374_a(d12, d13, d15, d8, d10);
            tessellator.func_78374_a(d11, d13, d15, d4, d6);
        }
    }

    public void func_78622_d(Block p_78622_1_, double p_78622_2_, double p_78622_4_, double p_78622_6_, Icon p_78622_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;

        if (this.func_94167_b())
        {
            p_78622_8_ = this.field_78664_d;
        }

        double d3 = (double)p_78622_8_.func_94214_a(this.field_83021_g * 16.0D);
        double d4 = (double)p_78622_8_.func_94214_a(this.field_83026_h * 16.0D);
        double d5 = (double)p_78622_8_.func_94207_b(16.0D - this.field_83024_j * 16.0D);
        double d6 = (double)p_78622_8_.func_94207_b(16.0D - this.field_83027_i * 16.0D);
        double d7;

        if (this.field_78666_e)
        {
            d7 = d3;
            d3 = d4;
            d4 = d7;
        }

        if (this.field_83021_g < 0.0D || this.field_83026_h > 1.0D)
        {
            d3 = (double)p_78622_8_.func_94209_e();
            d4 = (double)p_78622_8_.func_94212_f();
        }

        if (this.field_83027_i < 0.0D || this.field_83024_j > 1.0D)
        {
            d5 = (double)p_78622_8_.func_94206_g();
            d6 = (double)p_78622_8_.func_94210_h();
        }

        d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (this.field_78683_h == 1)
        {
            d3 = (double)p_78622_8_.func_94214_a(this.field_83027_i * 16.0D);
            d6 = (double)p_78622_8_.func_94207_b(16.0D - this.field_83021_g * 16.0D);
            d4 = (double)p_78622_8_.func_94214_a(this.field_83024_j * 16.0D);
            d5 = (double)p_78622_8_.func_94207_b(16.0D - this.field_83026_h * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (this.field_78683_h == 2)
        {
            d3 = (double)p_78622_8_.func_94214_a(16.0D - this.field_83024_j * 16.0D);
            d5 = (double)p_78622_8_.func_94207_b(this.field_83021_g * 16.0D);
            d4 = (double)p_78622_8_.func_94214_a(16.0D - this.field_83027_i * 16.0D);
            d6 = (double)p_78622_8_.func_94207_b(this.field_83026_h * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (this.field_78683_h == 3)
        {
            d3 = (double)p_78622_8_.func_94214_a(16.0D - this.field_83021_g * 16.0D);
            d4 = (double)p_78622_8_.func_94214_a(16.0D - this.field_83026_h * 16.0D);
            d5 = (double)p_78622_8_.func_94207_b(this.field_83024_j * 16.0D);
            d6 = (double)p_78622_8_.func_94207_b(this.field_83027_i * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = p_78622_2_ + this.field_83021_g;
        double d12 = p_78622_2_ + this.field_83026_h;
        double d13 = p_78622_4_ + this.field_83027_i;
        double d14 = p_78622_4_ + this.field_83024_j;
        double d15 = p_78622_6_ + this.field_83022_l;

        if (this.field_78677_m)
        {
            tessellator.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
            tessellator.func_78380_c(this.field_78700_an);
            tessellator.func_78374_a(d11, d14, d15, d3, d5);
            tessellator.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
            tessellator.func_78380_c(this.field_78694_ao);
            tessellator.func_78374_a(d11, d13, d15, d8, d10);
            tessellator.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
            tessellator.func_78380_c(this.field_78696_ap);
            tessellator.func_78374_a(d12, d13, d15, d4, d6);
            tessellator.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
            tessellator.func_78380_c(this.field_78676_aq);
            tessellator.func_78374_a(d12, d14, d15, d7, d9);
        }
        else
        {
            tessellator.func_78374_a(d11, d14, d15, d3, d5);
            tessellator.func_78374_a(d11, d13, d15, d8, d10);
            tessellator.func_78374_a(d12, d13, d15, d4, d6);
            tessellator.func_78374_a(d12, d14, d15, d7, d9);
        }
    }

    public void func_78573_e(Block p_78573_1_, double p_78573_2_, double p_78573_4_, double p_78573_6_, Icon p_78573_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;

        if (this.func_94167_b())
        {
            p_78573_8_ = this.field_78664_d;
        }

        double d3 = (double)p_78573_8_.func_94214_a(this.field_83025_k * 16.0D);
        double d4 = (double)p_78573_8_.func_94214_a(this.field_83022_l * 16.0D);
        double d5 = (double)p_78573_8_.func_94207_b(16.0D - this.field_83024_j * 16.0D);
        double d6 = (double)p_78573_8_.func_94207_b(16.0D - this.field_83027_i * 16.0D);
        double d7;

        if (this.field_78666_e)
        {
            d7 = d3;
            d3 = d4;
            d4 = d7;
        }

        if (this.field_83025_k < 0.0D || this.field_83022_l > 1.0D)
        {
            d3 = (double)p_78573_8_.func_94209_e();
            d4 = (double)p_78573_8_.func_94212_f();
        }

        if (this.field_83027_i < 0.0D || this.field_83024_j > 1.0D)
        {
            d5 = (double)p_78573_8_.func_94206_g();
            d6 = (double)p_78573_8_.func_94210_h();
        }

        d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (this.field_78679_j == 1)
        {
            d3 = (double)p_78573_8_.func_94214_a(this.field_83027_i * 16.0D);
            d5 = (double)p_78573_8_.func_94207_b(16.0D - this.field_83022_l * 16.0D);
            d4 = (double)p_78573_8_.func_94214_a(this.field_83024_j * 16.0D);
            d6 = (double)p_78573_8_.func_94207_b(16.0D - this.field_83025_k * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (this.field_78679_j == 2)
        {
            d3 = (double)p_78573_8_.func_94214_a(16.0D - this.field_83024_j * 16.0D);
            d5 = (double)p_78573_8_.func_94207_b(this.field_83025_k * 16.0D);
            d4 = (double)p_78573_8_.func_94214_a(16.0D - this.field_83027_i * 16.0D);
            d6 = (double)p_78573_8_.func_94207_b(this.field_83022_l * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (this.field_78679_j == 3)
        {
            d3 = (double)p_78573_8_.func_94214_a(16.0D - this.field_83025_k * 16.0D);
            d4 = (double)p_78573_8_.func_94214_a(16.0D - this.field_83022_l * 16.0D);
            d5 = (double)p_78573_8_.func_94207_b(this.field_83024_j * 16.0D);
            d6 = (double)p_78573_8_.func_94207_b(this.field_83027_i * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = p_78573_2_ + this.field_83021_g;
        double d12 = p_78573_4_ + this.field_83027_i;
        double d13 = p_78573_4_ + this.field_83024_j;
        double d14 = p_78573_6_ + this.field_83025_k;
        double d15 = p_78573_6_ + this.field_83022_l;

        if (this.field_78677_m)
        {
            tessellator.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
            tessellator.func_78380_c(this.field_78700_an);
            tessellator.func_78374_a(d11, d13, d15, d7, d9);
            tessellator.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
            tessellator.func_78380_c(this.field_78694_ao);
            tessellator.func_78374_a(d11, d13, d14, d3, d5);
            tessellator.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
            tessellator.func_78380_c(this.field_78696_ap);
            tessellator.func_78374_a(d11, d12, d14, d8, d10);
            tessellator.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
            tessellator.func_78380_c(this.field_78676_aq);
            tessellator.func_78374_a(d11, d12, d15, d4, d6);
        }
        else
        {
            tessellator.func_78374_a(d11, d13, d15, d7, d9);
            tessellator.func_78374_a(d11, d13, d14, d3, d5);
            tessellator.func_78374_a(d11, d12, d14, d8, d10);
            tessellator.func_78374_a(d11, d12, d15, d4, d6);
        }
    }

    public void func_78605_f(Block p_78605_1_, double p_78605_2_, double p_78605_4_, double p_78605_6_, Icon p_78605_8_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;

        if (this.func_94167_b())
        {
            p_78605_8_ = this.field_78664_d;
        }

        double d3 = (double)p_78605_8_.func_94214_a(this.field_83025_k * 16.0D);
        double d4 = (double)p_78605_8_.func_94214_a(this.field_83022_l * 16.0D);
        double d5 = (double)p_78605_8_.func_94207_b(16.0D - this.field_83024_j * 16.0D);
        double d6 = (double)p_78605_8_.func_94207_b(16.0D - this.field_83027_i * 16.0D);
        double d7;

        if (this.field_78666_e)
        {
            d7 = d3;
            d3 = d4;
            d4 = d7;
        }

        if (this.field_83025_k < 0.0D || this.field_83022_l > 1.0D)
        {
            d3 = (double)p_78605_8_.func_94209_e();
            d4 = (double)p_78605_8_.func_94212_f();
        }

        if (this.field_83027_i < 0.0D || this.field_83024_j > 1.0D)
        {
            d5 = (double)p_78605_8_.func_94206_g();
            d6 = (double)p_78605_8_.func_94210_h();
        }

        d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;

        if (this.field_78685_i == 2)
        {
            d3 = (double)p_78605_8_.func_94214_a(this.field_83027_i * 16.0D);
            d5 = (double)p_78605_8_.func_94207_b(16.0D - this.field_83025_k * 16.0D);
            d4 = (double)p_78605_8_.func_94214_a(this.field_83024_j * 16.0D);
            d6 = (double)p_78605_8_.func_94207_b(16.0D - this.field_83022_l * 16.0D);
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        }
        else if (this.field_78685_i == 1)
        {
            d3 = (double)p_78605_8_.func_94214_a(16.0D - this.field_83024_j * 16.0D);
            d5 = (double)p_78605_8_.func_94207_b(this.field_83022_l * 16.0D);
            d4 = (double)p_78605_8_.func_94214_a(16.0D - this.field_83027_i * 16.0D);
            d6 = (double)p_78605_8_.func_94207_b(this.field_83025_k * 16.0D);
            d7 = d4;
            d8 = d3;
            d3 = d4;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        }
        else if (this.field_78685_i == 3)
        {
            d3 = (double)p_78605_8_.func_94214_a(16.0D - this.field_83025_k * 16.0D);
            d4 = (double)p_78605_8_.func_94214_a(16.0D - this.field_83022_l * 16.0D);
            d5 = (double)p_78605_8_.func_94207_b(this.field_83024_j * 16.0D);
            d6 = (double)p_78605_8_.func_94207_b(this.field_83027_i * 16.0D);
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }

        double d11 = p_78605_2_ + this.field_83026_h;
        double d12 = p_78605_4_ + this.field_83027_i;
        double d13 = p_78605_4_ + this.field_83024_j;
        double d14 = p_78605_6_ + this.field_83025_k;
        double d15 = p_78605_6_ + this.field_83022_l;

        if (this.field_78677_m)
        {
            tessellator.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
            tessellator.func_78380_c(this.field_78700_an);
            tessellator.func_78374_a(d11, d12, d15, d8, d10);
            tessellator.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
            tessellator.func_78380_c(this.field_78694_ao);
            tessellator.func_78374_a(d11, d12, d14, d4, d6);
            tessellator.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
            tessellator.func_78380_c(this.field_78696_ap);
            tessellator.func_78374_a(d11, d13, d14, d7, d9);
            tessellator.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
            tessellator.func_78380_c(this.field_78676_aq);
            tessellator.func_78374_a(d11, d13, d15, d3, d5);
        }
        else
        {
            tessellator.func_78374_a(d11, d12, d15, d8, d10);
            tessellator.func_78374_a(d11, d12, d14, d4, d6);
            tessellator.func_78374_a(d11, d13, d14, d7, d9);
            tessellator.func_78374_a(d11, d13, d15, d3, d5);
        }
    }

    public void func_78600_a(Block p_78600_1_, int p_78600_2_, float p_78600_3_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        boolean flag = p_78600_1_.field_71990_ca == Block.field_71980_u.field_71990_ca;

        if (p_78600_1_ == Block.field_71958_P || p_78600_1_ == Block.field_96469_cy || p_78600_1_ == Block.field_72051_aB)
        {
            p_78600_2_ = 3;
        }

        int j;
        float f1;
        float f2;
        float f3;

        if (this.field_78668_c)
        {
            j = p_78600_1_.func_71889_f_(p_78600_2_);

            if (flag)
            {
                j = 16777215;
            }

            f1 = (float)(j >> 16 & 255) / 255.0F;
            f2 = (float)(j >> 8 & 255) / 255.0F;
            f3 = (float)(j & 255) / 255.0F;
            GL11.glColor4f(f1 * p_78600_3_, f2 * p_78600_3_, f3 * p_78600_3_, 1.0F);
        }

        j = p_78600_1_.func_71857_b();
        this.func_83018_a(p_78600_1_);
        int k;

        if (j != 0 && j != 31 && j != 39 && j != 16 && j != 26)
        {
            if (j == 1)
            {
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                this.func_78599_a(p_78600_1_, p_78600_2_, -0.5D, -0.5D, -0.5D, 1.0F);
                tessellator.func_78381_a();
            }
            else if (j == 19)
            {
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                p_78600_1_.func_71919_f();
                this.func_78575_a(p_78600_1_, p_78600_2_, this.field_83024_j, -0.5D, -0.5D, -0.5D);
                tessellator.func_78381_a();
            }
            else if (j == 23)
            {
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                p_78600_1_.func_71919_f();
                tessellator.func_78381_a();
            }
            else if (j == 13)
            {
                p_78600_1_.func_71919_f();
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                f1 = 0.0625F;
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 0));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 1));
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
                tessellator.func_78372_c(0.0F, 0.0F, f1);
                this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 2));
                tessellator.func_78372_c(0.0F, 0.0F, -f1);
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                tessellator.func_78372_c(0.0F, 0.0F, -f1);
                this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 3));
                tessellator.func_78372_c(0.0F, 0.0F, f1);
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
                tessellator.func_78372_c(f1, 0.0F, 0.0F);
                this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 4));
                tessellator.func_78372_c(-f1, 0.0F, 0.0F);
                tessellator.func_78381_a();
                tessellator.func_78382_b();
                tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                tessellator.func_78372_c(-f1, 0.0F, 0.0F);
                this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 5));
                tessellator.func_78372_c(f1, 0.0F, 0.0F);
                tessellator.func_78381_a();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }
            else if (j == 22)
            {
                GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                ChestItemRenderHelper.field_78545_a.func_78542_a(p_78600_1_, p_78600_2_, p_78600_3_);
                GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            }
            else if (j == 6)
            {
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                this.func_78579_b(p_78600_1_, p_78600_2_, -0.5D, -0.5D, -0.5D);
                tessellator.func_78381_a();
            }
            else if (j == 2)
            {
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                this.func_78623_a(p_78600_1_, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D, 0);
                tessellator.func_78381_a();
            }
            else if (j == 10)
            {
                for (k = 0; k < 2; ++k)
                {
                    if (k == 0)
                    {
                        this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.5D);
                    }

                    if (k == 1)
                    {
                        this.func_83020_a(0.0D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);
                    }

                    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                    this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 0));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                    this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 1));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
                    this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 2));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                    this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 3));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
                    this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 4));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                    this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 5));
                    tessellator.func_78381_a();
                    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
                }
            }
            else if (j == 27)
            {
                k = 0;
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                tessellator.func_78382_b();

                for (int l = 0; l < 8; ++l)
                {
                    byte b0 = 0;
                    byte b1 = 1;

                    if (l == 0)
                    {
                        b0 = 2;
                    }

                    if (l == 1)
                    {
                        b0 = 3;
                    }

                    if (l == 2)
                    {
                        b0 = 4;
                    }

                    if (l == 3)
                    {
                        b0 = 5;
                        b1 = 2;
                    }

                    if (l == 4)
                    {
                        b0 = 6;
                        b1 = 3;
                    }

                    if (l == 5)
                    {
                        b0 = 7;
                        b1 = 5;
                    }

                    if (l == 6)
                    {
                        b0 = 6;
                        b1 = 2;
                    }

                    if (l == 7)
                    {
                        b0 = 3;
                    }

                    float f4 = (float)b0 / 16.0F;
                    float f5 = 1.0F - (float)k / 16.0F;
                    float f6 = 1.0F - (float)(k + b1) / 16.0F;
                    k += b1;
                    this.func_83020_a((double)(0.5F - f4), (double)f6, (double)(0.5F - f4), (double)(0.5F + f4), (double)f5, (double)(0.5F + f4));
                    tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                    this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 0));
                    tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                    this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 1));
                    tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
                    this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 2));
                    tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                    this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 3));
                    tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
                    this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 4));
                    tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                    this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 5));
                }

                tessellator.func_78381_a();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
                this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            }
            else if (j == 11)
            {
                for (k = 0; k < 4; ++k)
                {
                    f2 = 0.125F;

                    if (k == 0)
                    {
                        this.func_83020_a((double)(0.5F - f2), 0.0D, 0.0D, (double)(0.5F + f2), 1.0D, (double)(f2 * 2.0F));
                    }

                    if (k == 1)
                    {
                        this.func_83020_a((double)(0.5F - f2), 0.0D, (double)(1.0F - f2 * 2.0F), (double)(0.5F + f2), 1.0D, 1.0D);
                    }

                    f2 = 0.0625F;

                    if (k == 2)
                    {
                        this.func_83020_a((double)(0.5F - f2), (double)(1.0F - f2 * 3.0F), (double)(-f2 * 2.0F), (double)(0.5F + f2), (double)(1.0F - f2), (double)(1.0F + f2 * 2.0F));
                    }

                    if (k == 3)
                    {
                        this.func_83020_a((double)(0.5F - f2), (double)(0.5F - f2 * 3.0F), (double)(-f2 * 2.0F), (double)(0.5F + f2), (double)(0.5F - f2), (double)(1.0F + f2 * 2.0F));
                    }

                    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                    this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 0));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                    this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 1));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
                    this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 2));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                    this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 3));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
                    this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 4));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                    this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 5));
                    tessellator.func_78381_a();
                    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
                }

                this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            }
            else if (j == 21)
            {
                for (k = 0; k < 3; ++k)
                {
                    f2 = 0.0625F;

                    if (k == 0)
                    {
                        this.func_83020_a((double)(0.5F - f2), 0.30000001192092896D, 0.0D, (double)(0.5F + f2), 1.0D, (double)(f2 * 2.0F));
                    }

                    if (k == 1)
                    {
                        this.func_83020_a((double)(0.5F - f2), 0.30000001192092896D, (double)(1.0F - f2 * 2.0F), (double)(0.5F + f2), 1.0D, 1.0D);
                    }

                    f2 = 0.0625F;

                    if (k == 2)
                    {
                        this.func_83020_a((double)(0.5F - f2), 0.5D, 0.0D, (double)(0.5F + f2), (double)(1.0F - f2), 1.0D);
                    }

                    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                    this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 0));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                    this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 1));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
                    this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 2));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                    this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 3));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
                    this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 4));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                    this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 5));
                    tessellator.func_78381_a();
                    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
                }
            }
            else if (j == 32)
            {
                for (k = 0; k < 2; ++k)
                {
                    if (k == 0)
                    {
                        this.func_83020_a(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
                    }

                    if (k == 1)
                    {
                        this.func_83020_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
                    }

                    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                    this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 0, p_78600_2_));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                    this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 1, p_78600_2_));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
                    this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 2, p_78600_2_));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                    this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 3, p_78600_2_));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
                    this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 4, p_78600_2_));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                    this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 5, p_78600_2_));
                    tessellator.func_78381_a();
                    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
                }

                this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            }
            else if (j == 35)
            {
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                this.func_82776_a((BlockAnvil)p_78600_1_, 0, 0, 0, p_78600_2_ << 2, true);
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }
            else if (j == 34)
            {
                for (k = 0; k < 3; ++k)
                {
                    if (k == 0)
                    {
                        this.func_83020_a(0.125D, 0.0D, 0.125D, 0.875D, 0.1875D, 0.875D);
                        this.func_82774_a(this.func_94175_b(Block.field_72089_ap));
                    }
                    else if (k == 1)
                    {
                        this.func_83020_a(0.1875D, 0.1875D, 0.1875D, 0.8125D, 0.875D, 0.8125D);
                        this.func_82774_a(this.func_94175_b(Block.field_82518_cd));
                    }
                    else if (k == 2)
                    {
                        this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
                        this.func_82774_a(this.func_94175_b(Block.field_71946_M));
                    }

                    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
                    this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 0, p_78600_2_));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                    this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 1, p_78600_2_));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
                    this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 2, p_78600_2_));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                    this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 3, p_78600_2_));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
                    this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 4, p_78600_2_));
                    tessellator.func_78381_a();
                    tessellator.func_78382_b();
                    tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                    this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 5, p_78600_2_));
                    tessellator.func_78381_a();
                    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
                }

                this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
                this.func_78595_a();
            }
            else if (j == 38)
            {
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                this.func_96447_a((BlockHopper)p_78600_1_, 0, 0, 0, 0, true);
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }
        }
        else
        {
            if (j == 16)
            {
                p_78600_2_ = 1;
            }

            p_78600_1_.func_71919_f();
            this.func_83018_a(p_78600_1_);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 0, p_78600_2_));
            tessellator.func_78381_a();

            if (flag && this.field_78668_c)
            {
                k = p_78600_1_.func_71889_f_(p_78600_2_);
                f2 = (float)(k >> 16 & 255) / 255.0F;
                f3 = (float)(k >> 8 & 255) / 255.0F;
                float f7 = (float)(k & 255) / 255.0F;
                GL11.glColor4f(f2 * p_78600_3_, f3 * p_78600_3_, f7 * p_78600_3_, 1.0F);
            }

            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
            this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 1, p_78600_2_));
            tessellator.func_78381_a();

            if (flag && this.field_78668_c)
            {
                GL11.glColor4f(p_78600_3_, p_78600_3_, p_78600_3_, 1.0F);
            }

            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
            this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 2, p_78600_2_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
            this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 3, p_78600_2_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
            this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 4, p_78600_2_));
            tessellator.func_78381_a();
            tessellator.func_78382_b();
            tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
            this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 5, p_78600_2_));
            tessellator.func_78381_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        }
    }

    public static boolean func_78597_b(int p_78597_0_)
    {
        return p_78597_0_ == 0 ? true : (p_78597_0_ == 31 ? true : (p_78597_0_ == 39 ? true : (p_78597_0_ == 13 ? true : (p_78597_0_ == 10 ? true : (p_78597_0_ == 11 ? true : (p_78597_0_ == 27 ? true : (p_78597_0_ == 22 ? true : (p_78597_0_ == 21 ? true : (p_78597_0_ == 16 ? true : (p_78597_0_ == 26 ? true : (p_78597_0_ == 32 ? true : (p_78597_0_ == 34 ? true : p_78597_0_ == 35))))))))))));
    }

    public Icon func_94170_a(Block p_94170_1_, IBlockAccess p_94170_2_, int p_94170_3_, int p_94170_4_, int p_94170_5_, int p_94170_6_)
    {
        return this.func_96446_b(p_94170_1_.func_71895_b(p_94170_2_, p_94170_3_, p_94170_4_, p_94170_5_, p_94170_6_));
    }

    public Icon func_94165_a(Block p_94165_1_, int p_94165_2_, int p_94165_3_)
    {
        return this.func_96446_b(p_94165_1_.func_71858_a(p_94165_2_, p_94165_3_));
    }

    public Icon func_94173_a(Block p_94173_1_, int p_94173_2_)
    {
        return this.func_96446_b(p_94173_1_.func_71851_a(p_94173_2_));
    }

    public Icon func_94175_b(Block p_94175_1_)
    {
        return this.func_96446_b(p_94175_1_.func_71851_a(1));
    }

    public Icon func_96446_b(Icon p_96446_1_)
    {
        if (p_96446_1_ == null)
        {
            p_96446_1_ = ((TextureMap)Minecraft.func_71410_x().func_110434_K().func_110581_b(TextureMap.field_110575_b)).func_110572_b("missingno");
        }

        return (Icon)p_96446_1_;
    }
}
