package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLeaves extends BlockLeavesBase
{
    public static final String[] field_72136_a = new String[] {"oak", "spruce", "birch", "jungle"};
    public static final String[][] field_94396_b = new String[][] {{"leaves_oak", "leaves_spruce", "leaves_birch", "leaves_jungle"}, {"leaves_oak_opaque", "leaves_spruce_opaque", "leaves_birch_opaque", "leaves_jungle_opaque"}};
    @SideOnly(Side.CLIENT)
    private int field_94394_cP;
    private Icon[][] field_94395_cQ = new Icon[2][];
    int[] field_72135_b;

    protected BlockLeaves(int p_i2218_1_)
    {
        super(p_i2218_1_, Material.field_76257_i, false);
        this.func_71907_b(true);
        this.func_71849_a(CreativeTabs.field_78031_c);
    }

    @SideOnly(Side.CLIENT)
    public int func_71933_m()
    {
        double d0 = 0.5D;
        double d1 = 1.0D;
        return ColorizerFoliage.func_77470_a(d0, d1);
    }

    @SideOnly(Side.CLIENT)
    public int func_71889_f_(int p_71889_1_)
    {
        return (p_71889_1_ & 3) == 1 ? ColorizerFoliage.func_77466_a() : ((p_71889_1_ & 3) == 2 ? ColorizerFoliage.func_77469_b() : ColorizerFoliage.func_77468_c());
    }

    @SideOnly(Side.CLIENT)
    public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_)
    {
        int l = p_71920_1_.func_72805_g(p_71920_2_, p_71920_3_, p_71920_4_);

        if ((l & 3) == 1)
        {
            return ColorizerFoliage.func_77466_a();
        }
        else if ((l & 3) == 2)
        {
            return ColorizerFoliage.func_77469_b();
        }
        else
        {
            int i1 = 0;
            int j1 = 0;
            int k1 = 0;

            for (int l1 = -1; l1 <= 1; ++l1)
            {
                for (int i2 = -1; i2 <= 1; ++i2)
                {
                    int j2 = p_71920_1_.func_72807_a(p_71920_2_ + i2, p_71920_4_ + l1).func_76726_l();
                    i1 += (j2 & 16711680) >> 16;
                    j1 += (j2 & 65280) >> 8;
                    k1 += j2 & 255;
                }
            }

            return (i1 / 9 & 255) << 16 | (j1 / 9 & 255) << 8 | k1 / 9 & 255;
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        byte b0 = 1;
        int j1 = b0 + 1;

        if (p_71852_1_.func_72904_c(p_71852_2_ - j1, p_71852_3_ - j1, p_71852_4_ - j1, p_71852_2_ + j1, p_71852_3_ + j1, p_71852_4_ + j1))
        {
            for (int k1 = -b0; k1 <= b0; ++k1)
            {
                for (int l1 = -b0; l1 <= b0; ++l1)
                {
                    for (int i2 = -b0; i2 <= b0; ++i2)
                    {
                        int j2 = p_71852_1_.func_72798_a(p_71852_2_ + k1, p_71852_3_ + l1, p_71852_4_ + i2);

                        if (j2 == Block.field_71952_K.field_71990_ca)
                        {
                            int k2 = p_71852_1_.func_72805_g(p_71852_2_ + k1, p_71852_3_ + l1, p_71852_4_ + i2);
                            p_71852_1_.func_72921_c(p_71852_2_ + k1, p_71852_3_ + l1, p_71852_4_ + i2, k2 | 8, 4);
                        }
                    }
                }
            }
        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if (!p_71847_1_.field_72995_K)
        {
            int l = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);

            if ((l & 8) != 0 && (l & 4) == 0)
            {
                byte b0 = 4;
                int i1 = b0 + 1;
                byte b1 = 32;
                int j1 = b1 * b1;
                int k1 = b1 / 2;

                if (this.field_72135_b == null)
                {
                    this.field_72135_b = new int[b1 * b1 * b1];
                }

                int l1;

                if (p_71847_1_.func_72904_c(p_71847_2_ - i1, p_71847_3_ - i1, p_71847_4_ - i1, p_71847_2_ + i1, p_71847_3_ + i1, p_71847_4_ + i1))
                {
                    int i2;
                    int j2;
                    int k2;

                    for (l1 = -b0; l1 <= b0; ++l1)
                    {
                        for (i2 = -b0; i2 <= b0; ++i2)
                        {
                            for (j2 = -b0; j2 <= b0; ++j2)
                            {
                                k2 = p_71847_1_.func_72798_a(p_71847_2_ + l1, p_71847_3_ + i2, p_71847_4_ + j2);

                                if (k2 == Block.field_71951_J.field_71990_ca)
                                {
                                    this.field_72135_b[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
                                }
                                else if (k2 == Block.field_71952_K.field_71990_ca)
                                {
                                    this.field_72135_b[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -2;
                                }
                                else
                                {
                                    this.field_72135_b[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -1;
                                }
                            }
                        }
                    }

                    for (l1 = 1; l1 <= 4; ++l1)
                    {
                        for (i2 = -b0; i2 <= b0; ++i2)
                        {
                            for (j2 = -b0; j2 <= b0; ++j2)
                            {
                                for (k2 = -b0; k2 <= b0; ++k2)
                                {
                                    if (this.field_72135_b[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1)
                                    {
                                        if (this.field_72135_b[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
                                        {
                                            this.field_72135_b[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
                                        }

                                        if (this.field_72135_b[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
                                        {
                                            this.field_72135_b[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
                                        }

                                        if (this.field_72135_b[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == -2)
                                        {
                                            this.field_72135_b[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
                                        }

                                        if (this.field_72135_b[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == -2)
                                        {
                                            this.field_72135_b[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
                                        }

                                        if (this.field_72135_b[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == -2)
                                        {
                                            this.field_72135_b[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
                                        }

                                        if (this.field_72135_b[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == -2)
                                        {
                                            this.field_72135_b[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                l1 = this.field_72135_b[k1 * j1 + k1 * b1 + k1];

                if (l1 >= 0)
                {
                    p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, l & -9, 4);
                }
                else
                {
                    this.func_72132_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        if (p_71862_1_.func_72951_B(p_71862_2_, p_71862_3_ + 1, p_71862_4_) && !p_71862_1_.func_72797_t(p_71862_2_, p_71862_3_ - 1, p_71862_4_) && p_71862_5_.nextInt(15) == 1)
        {
            double d0 = (double)((float)p_71862_2_ + p_71862_5_.nextFloat());
            double d1 = (double)p_71862_3_ - 0.05D;
            double d2 = (double)((float)p_71862_4_ + p_71862_5_.nextFloat());
            p_71862_1_.func_72869_a("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }

    private void func_72132_l(World p_72132_1_, int p_72132_2_, int p_72132_3_, int p_72132_4_)
    {
        this.func_71897_c(p_72132_1_, p_72132_2_, p_72132_3_, p_72132_4_, p_72132_1_.func_72805_g(p_72132_2_, p_72132_3_, p_72132_4_), 0);
        p_72132_1_.func_94571_i(p_72132_2_, p_72132_3_, p_72132_4_);
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return p_71925_1_.nextInt(20) == 0 ? 1 : 0;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_71987_y.field_71990_ca;
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        if (!p_71914_1_.field_72995_K)
        {
            int j1 = 20;

            if ((p_71914_5_ & 3) == 3)
            {
                j1 = 40;
            }

            if (p_71914_7_ > 0)
            {
                j1 -= 2 << p_71914_7_;

                if (j1 < 10)
                {
                    j1 = 10;
                }
            }

            if (p_71914_1_.field_73012_v.nextInt(j1) == 0)
            {
                int k1 = this.func_71885_a(p_71914_5_, p_71914_1_.field_73012_v, p_71914_7_);
                this.func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(k1, 1, this.func_71899_b(p_71914_5_)));
            }

            j1 = 200;

            if (p_71914_7_ > 0)
            {
                j1 -= 10 << p_71914_7_;

                if (j1 < 40)
                {
                    j1 = 40;
                }
            }

            if ((p_71914_5_ & 3) == 0 && p_71914_1_.field_73012_v.nextInt(j1) == 0)
            {
                this.func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(Item.field_77706_j, 1, 0));
            }
        }
    }

    public void func_71893_a(World p_71893_1_, EntityPlayer p_71893_2_, int p_71893_3_, int p_71893_4_, int p_71893_5_, int p_71893_6_)
    {
        if (!p_71893_1_.field_72995_K && p_71893_2_.func_71045_bC() != null && p_71893_2_.func_71045_bC().field_77993_c == Item.field_77745_be.field_77779_bT)
        {
            p_71893_2_.func_71064_a(StatList.field_75934_C[this.field_71990_ca], 1);
            this.func_71929_a(p_71893_1_, p_71893_3_, p_71893_4_, p_71893_5_, new ItemStack(Block.field_71952_K.field_71990_ca, 1, p_71893_6_ & 3));
        }
        else
        {
            super.func_71893_a(p_71893_1_, p_71893_2_, p_71893_3_, p_71893_4_, p_71893_5_, p_71893_6_);
        }
    }

    public int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_ & 3;
    }

    public boolean func_71926_d()
    {
        return !this.field_72131_c;
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return (p_71858_2_ & 3) == 1 ? this.field_94395_cQ[this.field_94394_cP][1] : ((p_71858_2_ & 3) == 3 ? this.field_94395_cQ[this.field_94394_cP][3] : ((p_71858_2_ & 3) == 2 ? this.field_94395_cQ[this.field_94394_cP][2] : this.field_94395_cQ[this.field_94394_cP][0]));
    }

    @SideOnly(Side.CLIENT)
    public void func_72133_a(boolean p_72133_1_)
    {
        this.field_72131_c = p_72133_1_;
        this.field_94394_cP = p_72133_1_ ? 0 : 1;
    }

    @SideOnly(Side.CLIENT)
    public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_)
    {
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 0));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 1));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 2));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 3));
    }

    protected ItemStack func_71880_c_(int p_71880_1_)
    {
        return new ItemStack(this.field_71990_ca, 1, p_71880_1_ & 3);
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        for (int i = 0; i < field_94396_b.length; ++i)
        {
            this.field_94395_cQ[i] = new Icon[field_94396_b[i].length];

            for (int j = 0; j < field_94396_b[i].length; ++j)
            {
                this.field_94395_cQ[i][j] = p_94332_1_.func_94245_a(field_94396_b[i][j]);
            }
        }
    }
}
