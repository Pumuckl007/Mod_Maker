package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityComparator;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockComparator extends BlockRedstoneLogic implements ITileEntityProvider
{
    public BlockComparator(int p_i2184_1_, boolean p_i2184_2_)
    {
        super(p_i2184_1_, p_i2184_2_);
        this.field_72025_cg = true;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_94585_bY.field_77779_bT;
    }

    @SideOnly(Side.CLIENT)
    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return Item.field_94585_bY.field_77779_bT;
    }

    protected int func_94481_j_(int p_94481_1_)
    {
        return 2;
    }

    protected BlockRedstoneLogic func_94485_e()
    {
        return Block.field_94343_co;
    }

    protected BlockRedstoneLogic func_94484_i()
    {
        return Block.field_94346_cn;
    }

    public int func_71857_b()
    {
        return 37;
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        boolean flag = this.field_72222_c || (p_71858_2_ & 8) != 0;
        return p_71858_1_ == 0 ? (flag ? Block.field_72035_aQ.func_71851_a(p_71858_1_) : Block.field_72049_aP.func_71851_a(p_71858_1_)) : (p_71858_1_ == 1 ? (flag ? Block.field_94343_co.field_94336_cN : this.field_94336_cN) : Block.field_72085_aj.func_71851_a(1));
    }

    protected boolean func_96470_c(int p_96470_1_)
    {
        return this.field_72222_c || (p_96470_1_ & 8) != 0;
    }

    protected int func_94480_d(IBlockAccess p_94480_1_, int p_94480_2_, int p_94480_3_, int p_94480_4_, int p_94480_5_)
    {
        return this.func_96475_a_(p_94480_1_, p_94480_2_, p_94480_3_, p_94480_4_).func_96100_a();
    }

    private int func_94491_m(World p_94491_1_, int p_94491_2_, int p_94491_3_, int p_94491_4_, int p_94491_5_)
    {
        return !this.func_94490_c(p_94491_5_) ? this.func_72220_e(p_94491_1_, p_94491_2_, p_94491_3_, p_94491_4_, p_94491_5_) : Math.max(this.func_72220_e(p_94491_1_, p_94491_2_, p_94491_3_, p_94491_4_, p_94491_5_) - this.func_94482_f(p_94491_1_, p_94491_2_, p_94491_3_, p_94491_4_, p_94491_5_), 0);
    }

    public boolean func_94490_c(int p_94490_1_)
    {
        return (p_94490_1_ & 4) == 4;
    }

    protected boolean func_94478_d(World p_94478_1_, int p_94478_2_, int p_94478_3_, int p_94478_4_, int p_94478_5_)
    {
        int i1 = this.func_72220_e(p_94478_1_, p_94478_2_, p_94478_3_, p_94478_4_, p_94478_5_);

        if (i1 >= 15)
        {
            return true;
        }
        else if (i1 == 0)
        {
            return false;
        }
        else
        {
            int j1 = this.func_94482_f(p_94478_1_, p_94478_2_, p_94478_3_, p_94478_4_, p_94478_5_);
            return j1 == 0 ? true : i1 >= j1;
        }
    }

    protected int func_72220_e(World p_72220_1_, int p_72220_2_, int p_72220_3_, int p_72220_4_, int p_72220_5_)
    {
        int i1 = super.func_72220_e(p_72220_1_, p_72220_2_, p_72220_3_, p_72220_4_, p_72220_5_);
        int j1 = func_72217_d(p_72220_5_);
        int k1 = p_72220_2_ + Direction.field_71583_a[j1];
        int l1 = p_72220_4_ + Direction.field_71581_b[j1];
        int i2 = p_72220_1_.func_72798_a(k1, p_72220_3_, l1);

        if (i2 > 0)
        {
            if (Block.field_71973_m[i2].func_96468_q_())
            {
                i1 = Block.field_71973_m[i2].func_94328_b_(p_72220_1_, k1, p_72220_3_, l1, Direction.field_71580_e[j1]);
            }
            else if (i1 < 15 && Block.func_71932_i(i2))
            {
                k1 += Direction.field_71583_a[j1];
                l1 += Direction.field_71581_b[j1];
                i2 = p_72220_1_.func_72798_a(k1, p_72220_3_, l1);

                if (i2 > 0 && Block.field_71973_m[i2].func_96468_q_())
                {
                    i1 = Block.field_71973_m[i2].func_94328_b_(p_72220_1_, k1, p_72220_3_, l1, Direction.field_71580_e[j1]);
                }
            }
        }

        return i1;
    }

    public TileEntityComparator func_96475_a_(IBlockAccess p_96475_1_, int p_96475_2_, int p_96475_3_, int p_96475_4_)
    {
        return (TileEntityComparator)p_96475_1_.func_72796_p(p_96475_2_, p_96475_3_, p_96475_4_);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_)
    {
        int i1 = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
        boolean flag = this.field_72222_c | (i1 & 8) != 0;
        boolean flag1 = !this.func_94490_c(i1);
        int j1 = flag1 ? 4 : 0;
        j1 |= flag ? 8 : 0;
        p_71903_1_.func_72908_a((double)p_71903_2_ + 0.5D, (double)p_71903_3_ + 0.5D, (double)p_71903_4_ + 0.5D, "random.click", 0.3F, flag1 ? 0.55F : 0.5F);
        p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, j1 | i1 & 3, 2);
        this.func_96476_c(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, p_71903_1_.field_73012_v);
        return true;
    }

    protected void func_94479_f(World p_94479_1_, int p_94479_2_, int p_94479_3_, int p_94479_4_, int p_94479_5_)
    {
        if (!p_94479_1_.func_94573_a(p_94479_2_, p_94479_3_, p_94479_4_, this.field_71990_ca))
        {
            int i1 = p_94479_1_.func_72805_g(p_94479_2_, p_94479_3_, p_94479_4_);
            int j1 = this.func_94491_m(p_94479_1_, p_94479_2_, p_94479_3_, p_94479_4_, i1);
            int k1 = this.func_96475_a_(p_94479_1_, p_94479_2_, p_94479_3_, p_94479_4_).func_96100_a();

            if (j1 != k1 || this.func_96470_c(i1) != this.func_94478_d(p_94479_1_, p_94479_2_, p_94479_3_, p_94479_4_, i1))
            {
                if (this.func_83011_d(p_94479_1_, p_94479_2_, p_94479_3_, p_94479_4_, i1))
                {
                    p_94479_1_.func_82740_a(p_94479_2_, p_94479_3_, p_94479_4_, this.field_71990_ca, this.func_94481_j_(0), -1);
                }
                else
                {
                    p_94479_1_.func_82740_a(p_94479_2_, p_94479_3_, p_94479_4_, this.field_71990_ca, this.func_94481_j_(0), 0);
                }
            }
        }
    }

    private void func_96476_c(World p_96476_1_, int p_96476_2_, int p_96476_3_, int p_96476_4_, Random p_96476_5_)
    {
        int l = p_96476_1_.func_72805_g(p_96476_2_, p_96476_3_, p_96476_4_);
        int i1 = this.func_94491_m(p_96476_1_, p_96476_2_, p_96476_3_, p_96476_4_, l);
        int j1 = this.func_96475_a_(p_96476_1_, p_96476_2_, p_96476_3_, p_96476_4_).func_96100_a();
        this.func_96475_a_(p_96476_1_, p_96476_2_, p_96476_3_, p_96476_4_).func_96099_a(i1);

        if (j1 != i1 || !this.func_94490_c(l))
        {
            boolean flag = this.func_94478_d(p_96476_1_, p_96476_2_, p_96476_3_, p_96476_4_, l);
            boolean flag1 = this.field_72222_c || (l & 8) != 0;

            if (flag1 && !flag)
            {
                p_96476_1_.func_72921_c(p_96476_2_, p_96476_3_, p_96476_4_, l & -9, 2);
            }
            else if (!flag1 && flag)
            {
                p_96476_1_.func_72921_c(p_96476_2_, p_96476_3_, p_96476_4_, l | 8, 2);
            }

            this.func_94483_i_(p_96476_1_, p_96476_2_, p_96476_3_, p_96476_4_);
        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if (this.field_72222_c)
        {
            int l = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
            p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, this.func_94484_i().field_71990_ca, l | 8, 4);
        }

        this.func_96476_c(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        p_71861_1_.func_72837_a(p_71861_2_, p_71861_3_, p_71861_4_, this.func_72274_a(p_71861_1_));
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
        p_71852_1_.func_72932_q(p_71852_2_, p_71852_3_, p_71852_4_);
        this.func_94483_i_(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_);
    }

    public boolean func_71883_b(World p_71883_1_, int p_71883_2_, int p_71883_3_, int p_71883_4_, int p_71883_5_, int p_71883_6_)
    {
        super.func_71883_b(p_71883_1_, p_71883_2_, p_71883_3_, p_71883_4_, p_71883_5_, p_71883_6_);
        TileEntity tileentity = p_71883_1_.func_72796_p(p_71883_2_, p_71883_3_, p_71883_4_);
        return tileentity != null ? tileentity.func_70315_b(p_71883_5_, p_71883_6_) : false;
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityComparator();
    }
}
