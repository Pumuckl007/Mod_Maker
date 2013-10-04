package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFurnace extends BlockContainer
{
    private final Random field_72289_a = new Random();
    private final boolean field_72287_b;
    private static boolean field_72288_c;
    @SideOnly(Side.CLIENT)
    private Icon field_94458_cO;
    @SideOnly(Side.CLIENT)
    private Icon field_94459_cP;

    protected BlockFurnace(int p_i2203_1_, boolean p_i2203_2_)
    {
        super(p_i2203_1_, Material.field_76246_e);
        this.field_72287_b = p_i2203_2_;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_72051_aB.field_71990_ca;
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        this.func_72285_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
    }

    private void func_72285_l(World p_72285_1_, int p_72285_2_, int p_72285_3_, int p_72285_4_)
    {
        if (!p_72285_1_.field_72995_K)
        {
            int l = p_72285_1_.func_72798_a(p_72285_2_, p_72285_3_, p_72285_4_ - 1);
            int i1 = p_72285_1_.func_72798_a(p_72285_2_, p_72285_3_, p_72285_4_ + 1);
            int j1 = p_72285_1_.func_72798_a(p_72285_2_ - 1, p_72285_3_, p_72285_4_);
            int k1 = p_72285_1_.func_72798_a(p_72285_2_ + 1, p_72285_3_, p_72285_4_);
            byte b0 = 3;

            if (Block.field_71970_n[l] && !Block.field_71970_n[i1])
            {
                b0 = 3;
            }

            if (Block.field_71970_n[i1] && !Block.field_71970_n[l])
            {
                b0 = 2;
            }

            if (Block.field_71970_n[j1] && !Block.field_71970_n[k1])
            {
                b0 = 5;
            }

            if (Block.field_71970_n[k1] && !Block.field_71970_n[j1])
            {
                b0 = 4;
            }

            p_72285_1_.func_72921_c(p_72285_2_, p_72285_3_, p_72285_4_, b0, 2);
        }
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return p_71858_1_ == 1 ? this.field_94458_cO : (p_71858_1_ == 0 ? this.field_94458_cO : (p_71858_1_ != p_71858_2_ ? this.field_94336_cN : this.field_94459_cP));
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        this.field_94336_cN = p_94332_1_.func_94245_a("furnace_side");
        this.field_94459_cP = p_94332_1_.func_94245_a(this.field_72287_b ? "furnace_front_on" : "furnace_front_off");
        this.field_94458_cO = p_94332_1_.func_94245_a("furnace_top");
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_)
    {
        if (p_71903_1_.field_72995_K)
        {
            return true;
        }
        else
        {
            TileEntityFurnace tileentityfurnace = (TileEntityFurnace)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);

            if (tileentityfurnace != null)
            {
                p_71903_5_.func_71042_a(tileentityfurnace);
            }

            return true;
        }
    }

    public static void func_72286_a(boolean p_72286_0_, World p_72286_1_, int p_72286_2_, int p_72286_3_, int p_72286_4_)
    {
        int l = p_72286_1_.func_72805_g(p_72286_2_, p_72286_3_, p_72286_4_);
        TileEntity tileentity = p_72286_1_.func_72796_p(p_72286_2_, p_72286_3_, p_72286_4_);
        field_72288_c = true;

        if (p_72286_0_)
        {
            p_72286_1_.func_94575_c(p_72286_2_, p_72286_3_, p_72286_4_, Block.field_72052_aC.field_71990_ca);
        }
        else
        {
            p_72286_1_.func_94575_c(p_72286_2_, p_72286_3_, p_72286_4_, Block.field_72051_aB.field_71990_ca);
        }

        field_72288_c = false;
        p_72286_1_.func_72921_c(p_72286_2_, p_72286_3_, p_72286_4_, l, 2);

        if (tileentity != null)
        {
            tileentity.func_70312_q();
            p_72286_1_.func_72837_a(p_72286_2_, p_72286_3_, p_72286_4_, tileentity);
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        if (this.field_72287_b)
        {
            int l = p_71862_1_.func_72805_g(p_71862_2_, p_71862_3_, p_71862_4_);
            float f = (float)p_71862_2_ + 0.5F;
            float f1 = (float)p_71862_3_ + 0.0F + p_71862_5_.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)p_71862_4_ + 0.5F;
            float f3 = 0.52F;
            float f4 = p_71862_5_.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {
                p_71862_1_.func_72869_a("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                p_71862_1_.func_72869_a("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 5)
            {
                p_71862_1_.func_72869_a("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                p_71862_1_.func_72869_a("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2)
            {
                p_71862_1_.func_72869_a("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                p_71862_1_.func_72869_a("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3)
            {
                p_71862_1_.func_72869_a("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                p_71862_1_.func_72869_a("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityFurnace();
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLivingBase p_71860_5_, ItemStack p_71860_6_)
    {
        int l = MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 2, 2);
        }

        if (l == 1)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 5, 2);
        }

        if (l == 2)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 3, 2);
        }

        if (l == 3)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 4, 2);
        }

        if (p_71860_6_.func_82837_s())
        {
            ((TileEntityFurnace)p_71860_1_.func_72796_p(p_71860_2_, p_71860_3_, p_71860_4_)).func_94129_a(p_71860_6_.func_82833_r());
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        if (!field_72288_c)
        {
            TileEntityFurnace tileentityfurnace = (TileEntityFurnace)p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);

            if (tileentityfurnace != null)
            {
                for (int j1 = 0; j1 < tileentityfurnace.func_70302_i_(); ++j1)
                {
                    ItemStack itemstack = tileentityfurnace.func_70301_a(j1);

                    if (itemstack != null)
                    {
                        float f = this.field_72289_a.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.field_72289_a.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.field_72289_a.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.field_77994_a > 0)
                        {
                            int k1 = this.field_72289_a.nextInt(21) + 10;

                            if (k1 > itemstack.field_77994_a)
                            {
                                k1 = itemstack.field_77994_a;
                            }

                            itemstack.field_77994_a -= k1;
                            EntityItem entityitem = new EntityItem(p_71852_1_, (double)((float)p_71852_2_ + f), (double)((float)p_71852_3_ + f1), (double)((float)p_71852_4_ + f2), new ItemStack(itemstack.field_77993_c, k1, itemstack.func_77960_j()));

                            if (itemstack.func_77942_o())
                            {
                                entityitem.func_92059_d().func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
                            }

                            float f3 = 0.05F;
                            entityitem.field_70159_w = (double)((float)this.field_72289_a.nextGaussian() * f3);
                            entityitem.field_70181_x = (double)((float)this.field_72289_a.nextGaussian() * f3 + 0.2F);
                            entityitem.field_70179_y = (double)((float)this.field_72289_a.nextGaussian() * f3);
                            p_71852_1_.func_72838_d(entityitem);
                        }
                    }
                }

                p_71852_1_.func_96440_m(p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_);
            }
        }

        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

    public boolean func_96468_q_()
    {
        return true;
    }

    public int func_94328_b_(World p_94328_1_, int p_94328_2_, int p_94328_3_, int p_94328_4_, int p_94328_5_)
    {
        return Container.func_94526_b((IInventory)p_94328_1_.func_72796_p(p_94328_2_, p_94328_3_, p_94328_4_));
    }

    @SideOnly(Side.CLIENT)
    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return Block.field_72051_aB.field_71990_ca;
    }
}
