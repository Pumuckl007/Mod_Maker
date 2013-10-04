package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDaylightDetector;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDaylightDetector extends BlockContainer
{
    private Icon[] field_94445_a = new Icon[2];

    public BlockDaylightDetector(int p_i2186_1_)
    {
        super(p_i2186_1_, Material.field_76245_d);
        this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
        this.func_71849_a(CreativeTabs.field_78028_d);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
    }

    public int func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_)
    {
        return p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {}

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {}

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {}

    public void func_94444_j_(World p_94444_1_, int p_94444_2_, int p_94444_3_, int p_94444_4_)
    {
        if (!p_94444_1_.field_73011_w.field_76576_e)
        {
            int l = p_94444_1_.func_72805_g(p_94444_2_, p_94444_3_, p_94444_4_);
            int i1 = p_94444_1_.func_72972_b(EnumSkyBlock.Sky, p_94444_2_, p_94444_3_, p_94444_4_) - p_94444_1_.field_73008_k;
            float f = p_94444_1_.func_72929_e(1.0F);

            if (f < (float)Math.PI)
            {
                f += (0.0F - f) * 0.2F;
            }
            else
            {
                f += (((float)Math.PI * 2F) - f) * 0.2F;
            }

            i1 = Math.round((float)i1 * MathHelper.func_76134_b(f));

            if (i1 < 0)
            {
                i1 = 0;
            }

            if (i1 > 15)
            {
                i1 = 15;
            }

            if (l != i1)
            {
                p_94444_1_.func_72921_c(p_94444_2_, p_94444_3_, p_94444_4_, i1, 3);
            }
        }
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71853_i()
    {
        return true;
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityDaylightDetector();
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return p_71858_1_ == 1 ? this.field_94445_a[0] : this.field_94445_a[1];
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        this.field_94445_a[0] = p_94332_1_.func_94245_a(this.func_111023_E() + "_top");
        this.field_94445_a[1] = p_94332_1_.func_94245_a(this.func_111023_E() + "_side");
    }
}
