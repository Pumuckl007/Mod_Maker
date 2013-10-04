package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockBrewingStand extends BlockContainer
{
    private Random field_72294_a = new Random();
    @SideOnly(Side.CLIENT)
    private Icon field_94449_b;

    public BlockBrewingStand(int p_i2171_1_)
    {
        super(p_i2171_1_, Material.field_76243_f);
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public int func_71857_b()
    {
        return 25;
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityBrewingStand();
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_)
    {
        this.func_71905_a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
        super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        this.func_71919_f();
        super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
    }

    public void func_71919_f()
    {
        this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_)
    {
        if (p_71903_1_.field_72995_K)
        {
            return true;
        }
        else
        {
            TileEntityBrewingStand tileentitybrewingstand = (TileEntityBrewingStand)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);

            if (tileentitybrewingstand != null)
            {
                p_71903_5_.func_71017_a(tileentitybrewingstand);
            }

            return true;
        }
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLivingBase p_71860_5_, ItemStack p_71860_6_)
    {
        if (p_71860_6_.func_82837_s())
        {
            ((TileEntityBrewingStand)p_71860_1_.func_72796_p(p_71860_2_, p_71860_3_, p_71860_4_)).func_94131_a(p_71860_6_.func_82833_r());
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        TileEntity tileentity = p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);

        if (tileentity instanceof TileEntityBrewingStand)
        {
            TileEntityBrewingStand tileentitybrewingstand = (TileEntityBrewingStand)tileentity;

            for (int j1 = 0; j1 < tileentitybrewingstand.func_70302_i_(); ++j1)
            {
                ItemStack itemstack = tileentitybrewingstand.func_70301_a(j1);

                if (itemstack != null)
                {
                    float f = this.field_72294_a.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.field_72294_a.nextFloat() * 0.8F + 0.1F;
                    float f2 = this.field_72294_a.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.field_77994_a > 0)
                    {
                        int k1 = this.field_72294_a.nextInt(21) + 10;

                        if (k1 > itemstack.field_77994_a)
                        {
                            k1 = itemstack.field_77994_a;
                        }

                        itemstack.field_77994_a -= k1;
                        EntityItem entityitem = new EntityItem(p_71852_1_, (double)((float)p_71852_2_ + f), (double)((float)p_71852_3_ + f1), (double)((float)p_71852_4_ + f2), new ItemStack(itemstack.field_77993_c, k1, itemstack.func_77960_j()));
                        float f3 = 0.05F;
                        entityitem.field_70159_w = (double)((float)this.field_72294_a.nextGaussian() * f3);
                        entityitem.field_70181_x = (double)((float)this.field_72294_a.nextGaussian() * f3 + 0.2F);
                        entityitem.field_70179_y = (double)((float)this.field_72294_a.nextGaussian() * f3);
                        p_71852_1_.func_72838_d(entityitem);
                    }
                }
            }
        }

        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77724_by.field_77779_bT;
    }

    @SideOnly(Side.CLIENT)
    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        double d0 = (double)((float)p_71862_2_ + 0.4F + p_71862_5_.nextFloat() * 0.2F);
        double d1 = (double)((float)p_71862_3_ + 0.7F + p_71862_5_.nextFloat() * 0.3F);
        double d2 = (double)((float)p_71862_4_ + 0.4F + p_71862_5_.nextFloat() * 0.2F);
        p_71862_1_.func_72869_a("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

    @SideOnly(Side.CLIENT)
    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return Item.field_77724_by.field_77779_bT;
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
    public void func_94332_a(IconRegister p_94332_1_)
    {
        super.func_94332_a(p_94332_1_);
        this.field_94449_b = p_94332_1_.func_94245_a(this.func_111023_E() + "_base");
    }

    @SideOnly(Side.CLIENT)
    public Icon func_94448_e()
    {
        return this.field_94449_b;
    }
}
