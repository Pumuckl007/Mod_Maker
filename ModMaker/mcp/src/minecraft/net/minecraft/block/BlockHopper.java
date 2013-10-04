package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHopper extends BlockContainer
{
    private final Random field_94457_a = new Random();
    @SideOnly(Side.CLIENT)
    private Icon field_94455_b;
    @SideOnly(Side.CLIENT)
    private Icon field_94456_c;
    @SideOnly(Side.CLIENT)
    private Icon field_94454_cO;

    public BlockHopper(int p_i2213_1_)
    {
        super(p_i2213_1_, Material.field_76243_f);
        this.func_71849_a(CreativeTabs.field_78028_d);
        this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_)
    {
        this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
        super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        float f = 0.125F;
        this.func_71905_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        this.func_71905_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        this.func_71905_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public int func_85104_a(World p_85104_1_, int p_85104_2_, int p_85104_3_, int p_85104_4_, int p_85104_5_, float p_85104_6_, float p_85104_7_, float p_85104_8_, int p_85104_9_)
    {
        int j1 = Facing.field_71588_a[p_85104_5_];

        if (j1 == 1)
        {
            j1 = 0;
        }

        return j1;
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityHopper();
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLivingBase p_71860_5_, ItemStack p_71860_6_)
    {
        super.func_71860_a(p_71860_1_, p_71860_2_, p_71860_3_, p_71860_4_, p_71860_5_, p_71860_6_);

        if (p_71860_6_.func_82837_s())
        {
            TileEntityHopper tileentityhopper = func_98213_d(p_71860_1_, p_71860_2_, p_71860_3_, p_71860_4_);
            tileentityhopper.func_96115_a(p_71860_6_.func_82833_r());
        }
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        this.func_96471_k(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_)
    {
        if (p_71903_1_.field_72995_K)
        {
            return true;
        }
        else
        {
            TileEntityHopper tileentityhopper = func_98213_d(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_);

            if (tileentityhopper != null)
            {
                p_71903_5_.func_94064_a(tileentityhopper);
            }

            return true;
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        this.func_96471_k(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
    }

    private void func_96471_k(World p_96471_1_, int p_96471_2_, int p_96471_3_, int p_96471_4_)
    {
        int l = p_96471_1_.func_72805_g(p_96471_2_, p_96471_3_, p_96471_4_);
        int i1 = func_94451_c(l);
        boolean flag = !p_96471_1_.func_72864_z(p_96471_2_, p_96471_3_, p_96471_4_);
        boolean flag1 = func_94452_d(l);

        if (flag != flag1)
        {
            p_96471_1_.func_72921_c(p_96471_2_, p_96471_3_, p_96471_4_, i1 | (flag ? 0 : 8), 4);
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        TileEntityHopper tileentityhopper = (TileEntityHopper)p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);

        if (tileentityhopper != null)
        {
            for (int j1 = 0; j1 < tileentityhopper.func_70302_i_(); ++j1)
            {
                ItemStack itemstack = tileentityhopper.func_70301_a(j1);

                if (itemstack != null)
                {
                    float f = this.field_94457_a.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.field_94457_a.nextFloat() * 0.8F + 0.1F;
                    float f2 = this.field_94457_a.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.field_77994_a > 0)
                    {
                        int k1 = this.field_94457_a.nextInt(21) + 10;

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
                        entityitem.field_70159_w = (double)((float)this.field_94457_a.nextGaussian() * f3);
                        entityitem.field_70181_x = (double)((float)this.field_94457_a.nextGaussian() * f3 + 0.2F);
                        entityitem.field_70179_y = (double)((float)this.field_94457_a.nextGaussian() * f3);
                        p_71852_1_.func_72838_d(entityitem);
                    }
                }
            }

            p_71852_1_.func_96440_m(p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_);
        }

        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

    public int func_71857_b()
    {
        return 38;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public static int func_94451_c(int p_94451_0_)
    {
        return p_94451_0_ & 7;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return p_71858_1_ == 1 ? this.field_94456_c : this.field_94455_b;
    }

    public static boolean func_94452_d(int p_94452_0_)
    {
        return (p_94452_0_ & 8) != 8;
    }

    public boolean func_96468_q_()
    {
        return true;
    }

    public int func_94328_b_(World p_94328_1_, int p_94328_2_, int p_94328_3_, int p_94328_4_, int p_94328_5_)
    {
        return Container.func_94526_b(func_98213_d(p_94328_1_, p_94328_2_, p_94328_3_, p_94328_4_));
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        this.field_94455_b = p_94332_1_.func_94245_a("hopper_outside");
        this.field_94456_c = p_94332_1_.func_94245_a("hopper_top");
        this.field_94454_cO = p_94332_1_.func_94245_a("hopper_inside");
    }

    @SideOnly(Side.CLIENT)
    public static Icon func_94453_b(String p_94453_0_)
    {
        return p_94453_0_.equals("hopper_outside") ? Block.field_94340_cs.field_94455_b : (p_94453_0_.equals("hopper_inside") ? Block.field_94340_cs.field_94454_cO : null);
    }

    @SideOnly(Side.CLIENT)
    public String func_94327_t_()
    {
        return "hopper";
    }

    public static TileEntityHopper func_98213_d(IBlockAccess p_98213_0_, int p_98213_1_, int p_98213_2_, int p_98213_3_)
    {
        return (TileEntityHopper)p_98213_0_.func_72796_p(p_98213_1_, p_98213_2_, p_98213_3_);
    }
}