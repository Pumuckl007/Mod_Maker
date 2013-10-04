package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockSapling extends BlockFlower
{
    public static final String[] field_72270_a = new String[] {"oak", "spruce", "birch", "jungle"};
    @SideOnly(Side.CLIENT)
    private Icon[] field_94371_c;

    protected BlockSapling(int p_i2252_1_)
    {
        super(p_i2252_1_);
        float f = 0.4F;
        this.func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.func_71849_a(CreativeTabs.field_78031_c);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if (!p_71847_1_.field_72995_K)
        {
            super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);

            if (p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) >= 9 && p_71847_5_.nextInt(7) == 0)
            {
                this.func_96477_c(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        p_71858_2_ &= 3;
        return this.field_94371_c[p_71858_2_];
    }

    public void func_96477_c(World p_96477_1_, int p_96477_2_, int p_96477_3_, int p_96477_4_, Random p_96477_5_)
    {
        int l = p_96477_1_.func_72805_g(p_96477_2_, p_96477_3_, p_96477_4_);

        if ((l & 8) == 0)
        {
            p_96477_1_.func_72921_c(p_96477_2_, p_96477_3_, p_96477_4_, l | 8, 4);
        }
        else
        {
            this.func_72269_c(p_96477_1_, p_96477_2_, p_96477_3_, p_96477_4_, p_96477_5_);
        }
    }

    public void func_72269_c(World p_72269_1_, int p_72269_2_, int p_72269_3_, int p_72269_4_, Random p_72269_5_)
    {
        int l = p_72269_1_.func_72805_g(p_72269_2_, p_72269_3_, p_72269_4_) & 3;
        Object object = null;
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        if (l == 1)
        {
            object = new WorldGenTaiga2(true);
        }
        else if (l == 2)
        {
            object = new WorldGenForest(true);
        }
        else if (l == 3)
        {
            for (i1 = 0; i1 >= -1; --i1)
            {
                for (j1 = 0; j1 >= -1; --j1)
                {
                    if (this.func_72268_e(p_72269_1_, p_72269_2_ + i1, p_72269_3_, p_72269_4_ + j1, 3) && this.func_72268_e(p_72269_1_, p_72269_2_ + i1 + 1, p_72269_3_, p_72269_4_ + j1, 3) && this.func_72268_e(p_72269_1_, p_72269_2_ + i1, p_72269_3_, p_72269_4_ + j1 + 1, 3) && this.func_72268_e(p_72269_1_, p_72269_2_ + i1 + 1, p_72269_3_, p_72269_4_ + j1 + 1, 3))
                    {
                        object = new WorldGenHugeTrees(true, 10 + p_72269_5_.nextInt(20), 3, 3);
                        flag = true;
                        break;
                    }
                }

                if (object != null)
                {
                    break;
                }
            }

            if (object == null)
            {
                j1 = 0;
                i1 = 0;
                object = new WorldGenTrees(true, 4 + p_72269_5_.nextInt(7), 3, 3, false);
            }
        }
        else
        {
            object = new WorldGenTrees(true);

            if (p_72269_5_.nextInt(10) == 0)
            {
                object = new WorldGenBigTree(true);
            }
        }

        if (flag)
        {
            p_72269_1_.func_72832_d(p_72269_2_ + i1, p_72269_3_, p_72269_4_ + j1, 0, 0, 4);
            p_72269_1_.func_72832_d(p_72269_2_ + i1 + 1, p_72269_3_, p_72269_4_ + j1, 0, 0, 4);
            p_72269_1_.func_72832_d(p_72269_2_ + i1, p_72269_3_, p_72269_4_ + j1 + 1, 0, 0, 4);
            p_72269_1_.func_72832_d(p_72269_2_ + i1 + 1, p_72269_3_, p_72269_4_ + j1 + 1, 0, 0, 4);
        }
        else
        {
            p_72269_1_.func_72832_d(p_72269_2_, p_72269_3_, p_72269_4_, 0, 0, 4);
        }

        if (!((WorldGenerator)object).func_76484_a(p_72269_1_, p_72269_5_, p_72269_2_ + i1, p_72269_3_, p_72269_4_ + j1))
        {
            if (flag)
            {
                p_72269_1_.func_72832_d(p_72269_2_ + i1, p_72269_3_, p_72269_4_ + j1, this.field_71990_ca, l, 4);
                p_72269_1_.func_72832_d(p_72269_2_ + i1 + 1, p_72269_3_, p_72269_4_ + j1, this.field_71990_ca, l, 4);
                p_72269_1_.func_72832_d(p_72269_2_ + i1, p_72269_3_, p_72269_4_ + j1 + 1, this.field_71990_ca, l, 4);
                p_72269_1_.func_72832_d(p_72269_2_ + i1 + 1, p_72269_3_, p_72269_4_ + j1 + 1, this.field_71990_ca, l, 4);
            }
            else
            {
                p_72269_1_.func_72832_d(p_72269_2_, p_72269_3_, p_72269_4_, this.field_71990_ca, l, 4);
            }
        }
    }

    public boolean func_72268_e(World p_72268_1_, int p_72268_2_, int p_72268_3_, int p_72268_4_, int p_72268_5_)
    {
        return p_72268_1_.func_72798_a(p_72268_2_, p_72268_3_, p_72268_4_) == this.field_71990_ca && (p_72268_1_.func_72805_g(p_72268_2_, p_72268_3_, p_72268_4_) & 3) == p_72268_5_;
    }

    public int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_ & 3;
    }

    @SideOnly(Side.CLIENT)
    public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_)
    {
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 0));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 1));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 2));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 3));
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        this.field_94371_c = new Icon[field_72270_a.length];

        for (int i = 0; i < this.field_94371_c.length; ++i)
        {
            this.field_94371_c[i] = p_94332_1_.func_94245_a(this.func_111023_E() + "_" + field_72270_a[i]);
        }
    }
}
