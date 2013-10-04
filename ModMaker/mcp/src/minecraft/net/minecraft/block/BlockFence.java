package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemLeash;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFence extends Block
{
    private final String field_94464_a;

    public BlockFence(int p_i2200_1_, String p_i2200_2_, Material p_i2200_3_)
    {
        super(p_i2200_1_, p_i2200_3_);
        this.field_94464_a = p_i2200_2_;
        this.func_71849_a(CreativeTabs.field_78031_c);
    }

    public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_)
    {
        boolean flag = this.func_72250_d(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_ - 1);
        boolean flag1 = this.func_72250_d(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_ + 1);
        boolean flag2 = this.func_72250_d(p_71871_1_, p_71871_2_ - 1, p_71871_3_, p_71871_4_);
        boolean flag3 = this.func_72250_d(p_71871_1_, p_71871_2_ + 1, p_71871_3_, p_71871_4_);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag || flag1)
        {
            this.func_71905_a(f, 0.0F, f2, f1, 1.5F, f3);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        }

        f2 = 0.375F;
        f3 = 0.625F;

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        if (flag2 || flag3 || !flag && !flag1)
        {
            this.func_71905_a(f, 0.0F, f2, f1, 1.5F, f3);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        }

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        this.func_71905_a(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        boolean flag = this.func_72250_d(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_ - 1);
        boolean flag1 = this.func_72250_d(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_ + 1);
        boolean flag2 = this.func_72250_d(p_71902_1_, p_71902_2_ - 1, p_71902_3_, p_71902_4_);
        boolean flag3 = this.func_72250_d(p_71902_1_, p_71902_2_ + 1, p_71902_3_, p_71902_4_);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        this.func_71905_a(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_)
    {
        return false;
    }

    public int func_71857_b()
    {
        return 11;
    }

    public boolean func_72250_d(IBlockAccess p_72250_1_, int p_72250_2_, int p_72250_3_, int p_72250_4_)
    {
        int l = p_72250_1_.func_72798_a(p_72250_2_, p_72250_3_, p_72250_4_);

        if (l != this.field_71990_ca && l != Block.field_71993_bv.field_71990_ca)
        {
            Block block = Block.field_71973_m[l];
            return block != null && block.field_72018_cp.func_76218_k() && block.func_71886_c() ? block.field_72018_cp != Material.field_76266_z : false;
        }
        else
        {
            return true;
        }
    }

    public static boolean func_72249_c(int p_72249_0_)
    {
        return p_72249_0_ == Block.field_72031_aZ.field_71990_ca || p_72249_0_ == Block.field_72098_bB.field_71990_ca;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        this.field_94336_cN = p_94332_1_.func_94245_a(this.field_94464_a);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_)
    {
        return p_71903_1_.field_72995_K ? true : ItemLeash.func_135066_a(p_71903_5_, p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_);
    }
}
