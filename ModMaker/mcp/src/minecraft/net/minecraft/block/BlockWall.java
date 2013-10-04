package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWall extends Block
{
    public static final String[] field_82539_a = new String[] {"normal", "mossy"};

    public BlockWall(int p_i2283_1_, Block p_i2283_2_)
    {
        super(p_i2283_1_, p_i2283_2_.field_72018_cp);
        this.func_71848_c(p_i2283_2_.field_71989_cb);
        this.func_71894_b(p_i2283_2_.field_72029_cc / 3.0F);
        this.func_71884_a(p_i2283_2_.field_72020_cn);
        this.func_71849_a(CreativeTabs.field_78030_b);
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return p_71858_2_ == 1 ? Block.field_72087_ao.func_71851_a(p_71858_1_) : Block.field_71978_w.func_71851_a(p_71858_1_);
    }

    public int func_71857_b()
    {
        return 32;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_)
    {
        return false;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        boolean flag = this.func_82538_d(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_ - 1);
        boolean flag1 = this.func_82538_d(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_ + 1);
        boolean flag2 = this.func_82538_d(p_71902_1_, p_71902_2_ - 1, p_71902_3_, p_71902_4_);
        boolean flag3 = this.func_82538_d(p_71902_1_, p_71902_2_ + 1, p_71902_3_, p_71902_4_);
        float f = 0.25F;
        float f1 = 0.75F;
        float f2 = 0.25F;
        float f3 = 0.75F;
        float f4 = 1.0F;

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

        if (flag && flag1 && !flag2 && !flag3)
        {
            f4 = 0.8125F;
            f = 0.3125F;
            f1 = 0.6875F;
        }
        else if (!flag && !flag1 && flag2 && flag3)
        {
            f4 = 0.8125F;
            f2 = 0.3125F;
            f3 = 0.6875F;
        }

        this.func_71905_a(f, 0.0F, f2, f1, f4, f3);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        this.func_71902_a(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
        this.field_72022_cl = 1.5D;
        return super.func_71872_e(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
    }

    public boolean func_82538_d(IBlockAccess p_82538_1_, int p_82538_2_, int p_82538_3_, int p_82538_4_)
    {
        int l = p_82538_1_.func_72798_a(p_82538_2_, p_82538_3_, p_82538_4_);

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

    @SideOnly(Side.CLIENT)
    public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_)
    {
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 0));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 1));
    }

    public int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_)
    {
        return p_71877_5_ == 0 ? super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_) : true;
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_) {}
}
