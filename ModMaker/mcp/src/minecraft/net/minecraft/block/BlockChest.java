package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChest extends BlockContainer
{
    private final Random field_72293_a = new Random();
    public final int field_94443_a;

    protected BlockChest(int p_i2179_1_, int p_i2179_2_)
    {
        super(p_i2179_1_, Material.field_76245_d);
        this.field_94443_a = p_i2179_2_;
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

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        if (p_71902_1_.func_72798_a(p_71902_2_, p_71902_3_, p_71902_4_ - 1) == this.field_71990_ca)
        {
            this.func_71905_a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
        }
        else if (p_71902_1_.func_72798_a(p_71902_2_, p_71902_3_, p_71902_4_ + 1) == this.field_71990_ca)
        {
            this.func_71905_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
        }
        else if (p_71902_1_.func_72798_a(p_71902_2_ - 1, p_71902_3_, p_71902_4_) == this.field_71990_ca)
        {
            this.func_71905_a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        }
        else if (p_71902_1_.func_72798_a(p_71902_2_ + 1, p_71902_3_, p_71902_4_) == this.field_71990_ca)
        {
            this.func_71905_a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
        }
        else
        {
            this.func_71905_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        }
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        this.func_72290_b_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
        int l = p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_, p_71861_4_ - 1);
        int i1 = p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_, p_71861_4_ + 1);
        int j1 = p_71861_1_.func_72798_a(p_71861_2_ - 1, p_71861_3_, p_71861_4_);
        int k1 = p_71861_1_.func_72798_a(p_71861_2_ + 1, p_71861_3_, p_71861_4_);

        if (l == this.field_71990_ca)
        {
            this.func_72290_b_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_ - 1);
        }

        if (i1 == this.field_71990_ca)
        {
            this.func_72290_b_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_ + 1);
        }

        if (j1 == this.field_71990_ca)
        {
            this.func_72290_b_(p_71861_1_, p_71861_2_ - 1, p_71861_3_, p_71861_4_);
        }

        if (k1 == this.field_71990_ca)
        {
            this.func_72290_b_(p_71861_1_, p_71861_2_ + 1, p_71861_3_, p_71861_4_);
        }
    }

    public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLivingBase p_71860_5_, ItemStack p_71860_6_)
    {
        int l = p_71860_1_.func_72798_a(p_71860_2_, p_71860_3_, p_71860_4_ - 1);
        int i1 = p_71860_1_.func_72798_a(p_71860_2_, p_71860_3_, p_71860_4_ + 1);
        int j1 = p_71860_1_.func_72798_a(p_71860_2_ - 1, p_71860_3_, p_71860_4_);
        int k1 = p_71860_1_.func_72798_a(p_71860_2_ + 1, p_71860_3_, p_71860_4_);
        byte b0 = 0;
        int l1 = MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;

        if (l1 == 0)
        {
            b0 = 2;
        }

        if (l1 == 1)
        {
            b0 = 5;
        }

        if (l1 == 2)
        {
            b0 = 3;
        }

        if (l1 == 3)
        {
            b0 = 4;
        }

        if (l != this.field_71990_ca && i1 != this.field_71990_ca && j1 != this.field_71990_ca && k1 != this.field_71990_ca)
        {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, b0, 3);
        }
        else
        {
            if ((l == this.field_71990_ca || i1 == this.field_71990_ca) && (b0 == 4 || b0 == 5))
            {
                if (l == this.field_71990_ca)
                {
                    p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_ - 1, b0, 3);
                }
                else
                {
                    p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_ + 1, b0, 3);
                }

                p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, b0, 3);
            }

            if ((j1 == this.field_71990_ca || k1 == this.field_71990_ca) && (b0 == 2 || b0 == 3))
            {
                if (j1 == this.field_71990_ca)
                {
                    p_71860_1_.func_72921_c(p_71860_2_ - 1, p_71860_3_, p_71860_4_, b0, 3);
                }
                else
                {
                    p_71860_1_.func_72921_c(p_71860_2_ + 1, p_71860_3_, p_71860_4_, b0, 3);
                }

                p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, b0, 3);
            }
        }

        if (p_71860_6_.func_82837_s())
        {
            ((TileEntityChest)p_71860_1_.func_72796_p(p_71860_2_, p_71860_3_, p_71860_4_)).func_94043_a(p_71860_6_.func_82833_r());
        }
    }

    public void func_72290_b_(World p_72290_1_, int p_72290_2_, int p_72290_3_, int p_72290_4_)
    {
        if (!p_72290_1_.field_72995_K)
        {
            int l = p_72290_1_.func_72798_a(p_72290_2_, p_72290_3_, p_72290_4_ - 1);
            int i1 = p_72290_1_.func_72798_a(p_72290_2_, p_72290_3_, p_72290_4_ + 1);
            int j1 = p_72290_1_.func_72798_a(p_72290_2_ - 1, p_72290_3_, p_72290_4_);
            int k1 = p_72290_1_.func_72798_a(p_72290_2_ + 1, p_72290_3_, p_72290_4_);
            boolean flag = true;
            int l1;
            int i2;
            boolean flag1;
            byte b0;
            int j2;

            if (l != this.field_71990_ca && i1 != this.field_71990_ca)
            {
                if (j1 != this.field_71990_ca && k1 != this.field_71990_ca)
                {
                    b0 = 3;

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
                }
                else
                {
                    l1 = p_72290_1_.func_72798_a(j1 == this.field_71990_ca ? p_72290_2_ - 1 : p_72290_2_ + 1, p_72290_3_, p_72290_4_ - 1);
                    i2 = p_72290_1_.func_72798_a(j1 == this.field_71990_ca ? p_72290_2_ - 1 : p_72290_2_ + 1, p_72290_3_, p_72290_4_ + 1);
                    b0 = 3;
                    flag1 = true;

                    if (j1 == this.field_71990_ca)
                    {
                        j2 = p_72290_1_.func_72805_g(p_72290_2_ - 1, p_72290_3_, p_72290_4_);
                    }
                    else
                    {
                        j2 = p_72290_1_.func_72805_g(p_72290_2_ + 1, p_72290_3_, p_72290_4_);
                    }

                    if (j2 == 2)
                    {
                        b0 = 2;
                    }

                    if ((Block.field_71970_n[l] || Block.field_71970_n[l1]) && !Block.field_71970_n[i1] && !Block.field_71970_n[i2])
                    {
                        b0 = 3;
                    }

                    if ((Block.field_71970_n[i1] || Block.field_71970_n[i2]) && !Block.field_71970_n[l] && !Block.field_71970_n[l1])
                    {
                        b0 = 2;
                    }
                }
            }
            else
            {
                l1 = p_72290_1_.func_72798_a(p_72290_2_ - 1, p_72290_3_, l == this.field_71990_ca ? p_72290_4_ - 1 : p_72290_4_ + 1);
                i2 = p_72290_1_.func_72798_a(p_72290_2_ + 1, p_72290_3_, l == this.field_71990_ca ? p_72290_4_ - 1 : p_72290_4_ + 1);
                b0 = 5;
                flag1 = true;

                if (l == this.field_71990_ca)
                {
                    j2 = p_72290_1_.func_72805_g(p_72290_2_, p_72290_3_, p_72290_4_ - 1);
                }
                else
                {
                    j2 = p_72290_1_.func_72805_g(p_72290_2_, p_72290_3_, p_72290_4_ + 1);
                }

                if (j2 == 4)
                {
                    b0 = 4;
                }

                if ((Block.field_71970_n[j1] || Block.field_71970_n[l1]) && !Block.field_71970_n[k1] && !Block.field_71970_n[i2])
                {
                    b0 = 5;
                }

                if ((Block.field_71970_n[k1] || Block.field_71970_n[i2]) && !Block.field_71970_n[j1] && !Block.field_71970_n[l1])
                {
                    b0 = 4;
                }
            }

            p_72290_1_.func_72921_c(p_72290_2_, p_72290_3_, p_72290_4_, b0, 3);
        }
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        int l = 0;

        if (p_71930_1_.func_72798_a(p_71930_2_ - 1, p_71930_3_, p_71930_4_) == this.field_71990_ca)
        {
            ++l;
        }

        if (p_71930_1_.func_72798_a(p_71930_2_ + 1, p_71930_3_, p_71930_4_) == this.field_71990_ca)
        {
            ++l;
        }

        if (p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_, p_71930_4_ - 1) == this.field_71990_ca)
        {
            ++l;
        }

        if (p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_, p_71930_4_ + 1) == this.field_71990_ca)
        {
            ++l;
        }

        return l > 1 ? false : (this.func_72291_l(p_71930_1_, p_71930_2_ - 1, p_71930_3_, p_71930_4_) ? false : (this.func_72291_l(p_71930_1_, p_71930_2_ + 1, p_71930_3_, p_71930_4_) ? false : (this.func_72291_l(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_ - 1) ? false : !this.func_72291_l(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_ + 1))));
    }

    private boolean func_72291_l(World p_72291_1_, int p_72291_2_, int p_72291_3_, int p_72291_4_)
    {
        return p_72291_1_.func_72798_a(p_72291_2_, p_72291_3_, p_72291_4_) != this.field_71990_ca ? false : (p_72291_1_.func_72798_a(p_72291_2_ - 1, p_72291_3_, p_72291_4_) == this.field_71990_ca ? true : (p_72291_1_.func_72798_a(p_72291_2_ + 1, p_72291_3_, p_72291_4_) == this.field_71990_ca ? true : (p_72291_1_.func_72798_a(p_72291_2_, p_72291_3_, p_72291_4_ - 1) == this.field_71990_ca ? true : p_72291_1_.func_72798_a(p_72291_2_, p_72291_3_, p_72291_4_ + 1) == this.field_71990_ca)));
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
        TileEntityChest tileentitychest = (TileEntityChest)p_71863_1_.func_72796_p(p_71863_2_, p_71863_3_, p_71863_4_);

        if (tileentitychest != null)
        {
            tileentitychest.func_70321_h();
        }
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        TileEntityChest tileentitychest = (TileEntityChest)p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);

        if (tileentitychest != null)
        {
            for (int j1 = 0; j1 < tileentitychest.func_70302_i_(); ++j1)
            {
                ItemStack itemstack = tileentitychest.func_70301_a(j1);

                if (itemstack != null)
                {
                    float f = this.field_72293_a.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.field_72293_a.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = this.field_72293_a.nextFloat() * 0.8F + 0.1F; itemstack.field_77994_a > 0; p_71852_1_.func_72838_d(entityitem))
                    {
                        int k1 = this.field_72293_a.nextInt(21) + 10;

                        if (k1 > itemstack.field_77994_a)
                        {
                            k1 = itemstack.field_77994_a;
                        }

                        itemstack.field_77994_a -= k1;
                        entityitem = new EntityItem(p_71852_1_, (double)((float)p_71852_2_ + f), (double)((float)p_71852_3_ + f1), (double)((float)p_71852_4_ + f2), new ItemStack(itemstack.field_77993_c, k1, itemstack.func_77960_j()));
                        float f3 = 0.05F;
                        entityitem.field_70159_w = (double)((float)this.field_72293_a.nextGaussian() * f3);
                        entityitem.field_70181_x = (double)((float)this.field_72293_a.nextGaussian() * f3 + 0.2F);
                        entityitem.field_70179_y = (double)((float)this.field_72293_a.nextGaussian() * f3);

                        if (itemstack.func_77942_o())
                        {
                            entityitem.func_92059_d().func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
                        }
                    }
                }
            }

            p_71852_1_.func_96440_m(p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_);
        }

        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_)
    {
        if (p_71903_1_.field_72995_K)
        {
            return true;
        }
        else
        {
            IInventory iinventory = this.func_94442_h_(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_);

            if (iinventory != null)
            {
                p_71903_5_.func_71007_a(iinventory);
            }

            return true;
        }
    }

    public IInventory func_94442_h_(World p_94442_1_, int p_94442_2_, int p_94442_3_, int p_94442_4_)
    {
        Object object = (TileEntityChest)p_94442_1_.func_72796_p(p_94442_2_, p_94442_3_, p_94442_4_);

        if (object == null)
        {
            return null;
        }
        else if (p_94442_1_.func_72809_s(p_94442_2_, p_94442_3_ + 1, p_94442_4_))
        {
            return null;
        }
        else if (func_72292_n(p_94442_1_, p_94442_2_, p_94442_3_, p_94442_4_))
        {
            return null;
        }
        else if (p_94442_1_.func_72798_a(p_94442_2_ - 1, p_94442_3_, p_94442_4_) == this.field_71990_ca && (p_94442_1_.func_72809_s(p_94442_2_ - 1, p_94442_3_ + 1, p_94442_4_) || func_72292_n(p_94442_1_, p_94442_2_ - 1, p_94442_3_, p_94442_4_)))
        {
            return null;
        }
        else if (p_94442_1_.func_72798_a(p_94442_2_ + 1, p_94442_3_, p_94442_4_) == this.field_71990_ca && (p_94442_1_.func_72809_s(p_94442_2_ + 1, p_94442_3_ + 1, p_94442_4_) || func_72292_n(p_94442_1_, p_94442_2_ + 1, p_94442_3_, p_94442_4_)))
        {
            return null;
        }
        else if (p_94442_1_.func_72798_a(p_94442_2_, p_94442_3_, p_94442_4_ - 1) == this.field_71990_ca && (p_94442_1_.func_72809_s(p_94442_2_, p_94442_3_ + 1, p_94442_4_ - 1) || func_72292_n(p_94442_1_, p_94442_2_, p_94442_3_, p_94442_4_ - 1)))
        {
            return null;
        }
        else if (p_94442_1_.func_72798_a(p_94442_2_, p_94442_3_, p_94442_4_ + 1) == this.field_71990_ca && (p_94442_1_.func_72809_s(p_94442_2_, p_94442_3_ + 1, p_94442_4_ + 1) || func_72292_n(p_94442_1_, p_94442_2_, p_94442_3_, p_94442_4_ + 1)))
        {
            return null;
        }
        else
        {
            if (p_94442_1_.func_72798_a(p_94442_2_ - 1, p_94442_3_, p_94442_4_) == this.field_71990_ca)
            {
                object = new InventoryLargeChest("container.chestDouble", (TileEntityChest)p_94442_1_.func_72796_p(p_94442_2_ - 1, p_94442_3_, p_94442_4_), (IInventory)object);
            }

            if (p_94442_1_.func_72798_a(p_94442_2_ + 1, p_94442_3_, p_94442_4_) == this.field_71990_ca)
            {
                object = new InventoryLargeChest("container.chestDouble", (IInventory)object, (TileEntityChest)p_94442_1_.func_72796_p(p_94442_2_ + 1, p_94442_3_, p_94442_4_));
            }

            if (p_94442_1_.func_72798_a(p_94442_2_, p_94442_3_, p_94442_4_ - 1) == this.field_71990_ca)
            {
                object = new InventoryLargeChest("container.chestDouble", (TileEntityChest)p_94442_1_.func_72796_p(p_94442_2_, p_94442_3_, p_94442_4_ - 1), (IInventory)object);
            }

            if (p_94442_1_.func_72798_a(p_94442_2_, p_94442_3_, p_94442_4_ + 1) == this.field_71990_ca)
            {
                object = new InventoryLargeChest("container.chestDouble", (IInventory)object, (TileEntityChest)p_94442_1_.func_72796_p(p_94442_2_, p_94442_3_, p_94442_4_ + 1));
            }

            return (IInventory)object;
        }
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        TileEntityChest tileentitychest = new TileEntityChest();
        return tileentitychest;
    }

    public boolean func_71853_i()
    {
        return this.field_94443_a == 1;
    }

    public int func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_)
    {
        if (!this.func_71853_i())
        {
            return 0;
        }
        else
        {
            int i1 = ((TileEntityChest)p_71865_1_.func_72796_p(p_71865_2_, p_71865_3_, p_71865_4_)).field_70427_h;
            return MathHelper.func_76125_a(i1, 0, 15);
        }
    }

    public int func_71855_c(IBlockAccess p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_)
    {
        return p_71855_5_ == 1 ? this.func_71865_a(p_71855_1_, p_71855_2_, p_71855_3_, p_71855_4_, p_71855_5_) : 0;
    }

    public static boolean func_72292_n(World p_72292_0_, int p_72292_1_, int p_72292_2_, int p_72292_3_)
    {
        Iterator iterator = p_72292_0_.func_72872_a(EntityOcelot.class, AxisAlignedBB.func_72332_a().func_72299_a((double)p_72292_1_, (double)(p_72292_2_ + 1), (double)p_72292_3_, (double)(p_72292_1_ + 1), (double)(p_72292_2_ + 2), (double)(p_72292_3_ + 1))).iterator();
        EntityOcelot entityocelot;

        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }

            EntityOcelot entityocelot1 = (EntityOcelot)iterator.next();
            entityocelot = (EntityOcelot)entityocelot1;
        }
        while (!entityocelot.func_70906_o());

        return true;
    }

    public boolean func_96468_q_()
    {
        return true;
    }

    public int func_94328_b_(World p_94328_1_, int p_94328_2_, int p_94328_3_, int p_94328_4_, int p_94328_5_)
    {
        return Container.func_94526_b(this.func_94442_h_(p_94328_1_, p_94328_2_, p_94328_3_, p_94328_4_));
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        this.field_94336_cN = p_94332_1_.func_94245_a("planks_oak");
    }
}
