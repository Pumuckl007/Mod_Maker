package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemDye extends Item
{
    public static final String[] field_77860_a = new String[] {"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"};
    public static final String[] field_94595_b = new String[] {"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white"};
    public static final int[] field_77859_b = new int[] {1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};
    @SideOnly(Side.CLIENT)
    private Icon[] field_94594_d;

    public ItemDye(int p_i1856_1_)
    {
        super(p_i1856_1_);
        this.func_77627_a(true);
        this.func_77656_e(0);
        this.func_77637_a(CreativeTabs.field_78035_l);
    }

    @SideOnly(Side.CLIENT)
    public Icon func_77617_a(int p_77617_1_)
    {
        int j = MathHelper.func_76125_a(p_77617_1_, 0, 15);
        return this.field_94594_d[j];
    }

    public String func_77667_c(ItemStack p_77667_1_)
    {
        int i = MathHelper.func_76125_a(p_77667_1_.func_77960_j(), 0, 15);
        return super.func_77658_a() + "." + field_77860_a[i];
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
        {
            return false;
        }
        else
        {
            if (p_77648_1_.func_77960_j() == 15)
            {
                if (func_96604_a(p_77648_1_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_))
                {
                    if (!p_77648_3_.field_72995_K)
                    {
                        p_77648_3_.func_72926_e(2005, p_77648_4_, p_77648_5_, p_77648_6_, 0);
                    }

                    return true;
                }
            }
            else if (p_77648_1_.func_77960_j() == 3)
            {
                int i1 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
                int j1 = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);

                if (i1 == Block.field_71951_J.field_71990_ca && BlockLog.func_72141_e(j1) == 3)
                {
                    if (p_77648_7_ == 0)
                    {
                        return false;
                    }

                    if (p_77648_7_ == 1)
                    {
                        return false;
                    }

                    if (p_77648_7_ == 2)
                    {
                        --p_77648_6_;
                    }

                    if (p_77648_7_ == 3)
                    {
                        ++p_77648_6_;
                    }

                    if (p_77648_7_ == 4)
                    {
                        --p_77648_4_;
                    }

                    if (p_77648_7_ == 5)
                    {
                        ++p_77648_4_;
                    }

                    if (p_77648_3_.func_72799_c(p_77648_4_, p_77648_5_, p_77648_6_))
                    {
                        int k1 = Block.field_71973_m[Block.field_72086_bP.field_71990_ca].func_85104_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0);
                        p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, Block.field_72086_bP.field_71990_ca, k1, 2);

                        if (!p_77648_2_.field_71075_bZ.field_75098_d)
                        {
                            --p_77648_1_.field_77994_a;
                        }
                    }

                    return true;
                }
            }

            return false;
        }
    }

    public static boolean func_96604_a(ItemStack p_96604_0_, World p_96604_1_, int p_96604_2_, int p_96604_3_, int p_96604_4_)
    {
        int l = p_96604_1_.func_72798_a(p_96604_2_, p_96604_3_, p_96604_4_);

        if (l == Block.field_71987_y.field_71990_ca)
        {
            if (!p_96604_1_.field_72995_K)
            {
                if ((double)p_96604_1_.field_73012_v.nextFloat() < 0.45D)
                {
                    ((BlockSapling)Block.field_71987_y).func_96477_c(p_96604_1_, p_96604_2_, p_96604_3_, p_96604_4_, p_96604_1_.field_73012_v);
                }

                --p_96604_0_.field_77994_a;
            }

            return true;
        }
        else if (l != Block.field_72109_af.field_71990_ca && l != Block.field_72103_ag.field_71990_ca)
        {
            if (l != Block.field_71999_bt.field_71990_ca && l != Block.field_71996_bs.field_71990_ca)
            {
                if (l > 0 && Block.field_71973_m[l] instanceof BlockCrops)
                {
                    if (p_96604_1_.func_72805_g(p_96604_2_, p_96604_3_, p_96604_4_) == 7)
                    {
                        return false;
                    }
                    else
                    {
                        if (!p_96604_1_.field_72995_K)
                        {
                            ((BlockCrops)Block.field_71973_m[l]).func_72272_c_(p_96604_1_, p_96604_2_, p_96604_3_, p_96604_4_);
                            --p_96604_0_.field_77994_a;
                        }

                        return true;
                    }
                }
                else
                {
                    int i1;
                    int j1;
                    int k1;

                    if (l == Block.field_72086_bP.field_71990_ca)
                    {
                        i1 = p_96604_1_.func_72805_g(p_96604_2_, p_96604_3_, p_96604_4_);
                        j1 = BlockDirectional.func_72217_d(i1);
                        k1 = BlockCocoa.func_72219_c(i1);

                        if (k1 >= 2)
                        {
                            return false;
                        }
                        else
                        {
                            if (!p_96604_1_.field_72995_K)
                            {
                                ++k1;
                                p_96604_1_.func_72921_c(p_96604_2_, p_96604_3_, p_96604_4_, k1 << 2 | j1, 2);
                                --p_96604_0_.field_77994_a;
                            }

                            return true;
                        }
                    }
                    else if (l != Block.field_71980_u.field_71990_ca)
                    {
                        return false;
                    }
                    else
                    {
                        if (!p_96604_1_.field_72995_K)
                        {
                            --p_96604_0_.field_77994_a;
                            label102:

                            for (i1 = 0; i1 < 128; ++i1)
                            {
                                j1 = p_96604_2_;
                                k1 = p_96604_3_ + 1;
                                int l1 = p_96604_4_;

                                for (int i2 = 0; i2 < i1 / 16; ++i2)
                                {
                                    j1 += field_77697_d.nextInt(3) - 1;
                                    k1 += (field_77697_d.nextInt(3) - 1) * field_77697_d.nextInt(3) / 2;
                                    l1 += field_77697_d.nextInt(3) - 1;

                                    if (p_96604_1_.func_72798_a(j1, k1 - 1, l1) != Block.field_71980_u.field_71990_ca || p_96604_1_.func_72809_s(j1, k1, l1))
                                    {
                                        continue label102;
                                    }
                                }

                                if (p_96604_1_.func_72798_a(j1, k1, l1) == 0)
                                {
                                    if (field_77697_d.nextInt(10) != 0)
                                    {
                                        if (Block.field_71962_X.func_71854_d(p_96604_1_, j1, k1, l1))
                                        {
                                            p_96604_1_.func_72832_d(j1, k1, l1, Block.field_71962_X.field_71990_ca, 1, 3);
                                        }
                                    }
                                    else if (field_77697_d.nextInt(3) != 0)
                                    {
                                        if (Block.field_72097_ad.func_71854_d(p_96604_1_, j1, k1, l1))
                                        {
                                            p_96604_1_.func_94575_c(j1, k1, l1, Block.field_72097_ad.field_71990_ca);
                                        }
                                    }
                                    else if (Block.field_72107_ae.func_71854_d(p_96604_1_, j1, k1, l1))
                                    {
                                        p_96604_1_.func_94575_c(j1, k1, l1, Block.field_72107_ae.field_71990_ca);
                                    }
                                }
                            }
                        }

                        return true;
                    }
                }
            }
            else if (p_96604_1_.func_72805_g(p_96604_2_, p_96604_3_, p_96604_4_) == 7)
            {
                return false;
            }
            else
            {
                if (!p_96604_1_.field_72995_K)
                {
                    ((BlockStem)Block.field_71973_m[l]).func_72264_l(p_96604_1_, p_96604_2_, p_96604_3_, p_96604_4_);
                    --p_96604_0_.field_77994_a;
                }

                return true;
            }
        }
        else
        {
            if (!p_96604_1_.field_72995_K)
            {
                if ((double)p_96604_1_.field_73012_v.nextFloat() < 0.4D)
                {
                    ((BlockMushroom)Block.field_71973_m[l]).func_72271_c(p_96604_1_, p_96604_2_, p_96604_3_, p_96604_4_, p_96604_1_.field_73012_v);
                }

                --p_96604_0_.field_77994_a;
            }

            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    public static void func_96603_a(World p_96603_0_, int p_96603_1_, int p_96603_2_, int p_96603_3_, int p_96603_4_)
    {
        int i1 = p_96603_0_.func_72798_a(p_96603_1_, p_96603_2_, p_96603_3_);

        if (p_96603_4_ == 0)
        {
            p_96603_4_ = 15;
        }

        Block block = i1 > 0 && i1 < Block.field_71973_m.length ? Block.field_71973_m[i1] : null;

        if (block != null)
        {
            block.func_71902_a(p_96603_0_, p_96603_1_, p_96603_2_, p_96603_3_);

            for (int j1 = 0; j1 < p_96603_4_; ++j1)
            {
                double d0 = field_77697_d.nextGaussian() * 0.02D;
                double d1 = field_77697_d.nextGaussian() * 0.02D;
                double d2 = field_77697_d.nextGaussian() * 0.02D;
                p_96603_0_.func_72869_a("happyVillager", (double)((float)p_96603_1_ + field_77697_d.nextFloat()), (double)p_96603_2_ + (double)field_77697_d.nextFloat() * block.func_83010_y(), (double)((float)p_96603_3_ + field_77697_d.nextFloat()), d0, d1, d2);
            }
        }
    }

    public boolean func_111207_a(ItemStack p_111207_1_, EntityPlayer p_111207_2_, EntityLivingBase p_111207_3_)
    {
        if (p_111207_3_ instanceof EntitySheep)
        {
            EntitySheep entitysheep = (EntitySheep)p_111207_3_;
            int i = BlockColored.func_72238_e_(p_111207_1_.func_77960_j());

            if (!entitysheep.func_70892_o() && entitysheep.func_70896_n() != i)
            {
                entitysheep.func_70891_b(i);
                --p_111207_1_.field_77994_a;
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_77633_a(int p_77633_1_, CreativeTabs p_77633_2_, List p_77633_3_)
    {
        for (int j = 0; j < 16; ++j)
        {
            p_77633_3_.add(new ItemStack(p_77633_1_, 1, j));
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_94581_a(IconRegister p_94581_1_)
    {
        this.field_94594_d = new Icon[field_94595_b.length];

        for (int i = 0; i < field_94595_b.length; ++i)
        {
            this.field_94594_d[i] = p_94581_1_.func_94245_a(this.func_111208_A() + "_" + field_94595_b[i]);
        }
    }
}
