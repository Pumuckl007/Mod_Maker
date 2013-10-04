package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockEnderChest extends BlockContainer
{
    protected BlockEnderChest(int p_i2197_1_)
    {
        super(p_i2197_1_, Material.field_76246_e);
        this.func_71849_a(CreativeTabs.field_78031_c);
        this.func_71905_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71857_b()
    {
        return 22;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_72089_ap.field_71990_ca;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 8;
    }

    protected boolean func_71906_q_()
    {
        return true;
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLivingBase p_71860_5_, ItemStack p_71860_6_)
    {
        byte b0 = 0;
        int l = MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            b0 = 2;
        }

        if (l == 1)
        {
            b0 = 5;
        }

        if (l == 2)
        {
            b0 = 3;
        }

        if (l == 3)
        {
            b0 = 4;
        }

        p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, b0, 2);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_)
    {
        InventoryEnderChest inventoryenderchest = p_71903_5_.func_71005_bN();
        TileEntityEnderChest tileentityenderchest = (TileEntityEnderChest)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);

        if (inventoryenderchest != null && tileentityenderchest != null)
        {
            if (p_71903_1_.func_72809_s(p_71903_2_, p_71903_3_ + 1, p_71903_4_))
            {
                return true;
            }
            else if (p_71903_1_.field_72995_K)
            {
                return true;
            }
            else
            {
                inventoryenderchest.func_70485_a(tileentityenderchest);
                p_71903_5_.func_71007_a(inventoryenderchest);
                return true;
            }
        }
        else
        {
            return true;
        }
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityEnderChest();
    }

    @SideOnly(Side.CLIENT)
    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        for (int l = 0; l < 3; ++l)
        {
            double d0 = (double)((float)p_71862_2_ + p_71862_5_.nextFloat());
            double d1 = (double)((float)p_71862_3_ + p_71862_5_.nextFloat());
            d0 = (double)((float)p_71862_4_ + p_71862_5_.nextFloat());
            double d2 = 0.0D;
            double d3 = 0.0D;
            double d4 = 0.0D;
            int i1 = p_71862_5_.nextInt(2) * 2 - 1;
            int j1 = p_71862_5_.nextInt(2) * 2 - 1;
            d2 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.125D;
            d3 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.125D;
            d4 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.125D;
            double d5 = (double)p_71862_4_ + 0.5D + 0.25D * (double)j1;
            d4 = (double)(p_71862_5_.nextFloat() * 1.0F * (float)j1);
            double d6 = (double)p_71862_2_ + 0.5D + 0.25D * (double)i1;
            d2 = (double)(p_71862_5_.nextFloat() * 1.0F * (float)i1);
            p_71862_1_.func_72869_a("portal", d6, d1, d5, d2, d3, d4);
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        this.field_94336_cN = p_94332_1_.func_94245_a("obsidian");
    }
}
