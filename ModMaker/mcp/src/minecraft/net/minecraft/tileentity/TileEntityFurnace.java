package net.minecraft.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityFurnace extends TileEntity implements ISidedInventory
{
    private static final int[] field_102010_d = new int[] {0};
    private static final int[] field_102011_e = new int[] {2, 1};
    private static final int[] field_102009_f = new int[] {1};
    private ItemStack[] field_70404_d = new ItemStack[3];
    public int field_70407_a;
    public int field_70405_b;
    public int field_70406_c;
    private String field_94130_e;

    public int func_70302_i_()
    {
        return this.field_70404_d.length;
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        return this.field_70404_d[p_70301_1_];
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        if (this.field_70404_d[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.field_70404_d[p_70298_1_].field_77994_a <= p_70298_2_)
            {
                itemstack = this.field_70404_d[p_70298_1_];
                this.field_70404_d[p_70298_1_] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.field_70404_d[p_70298_1_].func_77979_a(p_70298_2_);

                if (this.field_70404_d[p_70298_1_].field_77994_a == 0)
                {
                    this.field_70404_d[p_70298_1_] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    public ItemStack func_70304_b(int p_70304_1_)
    {
        if (this.field_70404_d[p_70304_1_] != null)
        {
            ItemStack itemstack = this.field_70404_d[p_70304_1_];
            this.field_70404_d[p_70304_1_] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        this.field_70404_d[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.field_77994_a > this.func_70297_j_())
        {
            p_70299_2_.field_77994_a = this.func_70297_j_();
        }
    }

    public String func_70303_b()
    {
        return this.func_94042_c() ? this.field_94130_e : "container.furnace";
    }

    public boolean func_94042_c()
    {
        return this.field_94130_e != null && this.field_94130_e.length() > 0;
    }

    public void func_94129_a(String p_94129_1_)
    {
        this.field_94130_e = p_94129_1_;
    }

    public void func_70307_a(NBTTagCompound p_70307_1_)
    {
        super.func_70307_a(p_70307_1_);
        NBTTagList nbttaglist = p_70307_1_.func_74761_m("Items");
        this.field_70404_d = new ItemStack[this.func_70302_i_()];

        for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_74743_b(i);
            byte b0 = nbttagcompound1.func_74771_c("Slot");

            if (b0 >= 0 && b0 < this.field_70404_d.length)
            {
                this.field_70404_d[b0] = ItemStack.func_77949_a(nbttagcompound1);
            }
        }

        this.field_70407_a = p_70307_1_.func_74765_d("BurnTime");
        this.field_70406_c = p_70307_1_.func_74765_d("CookTime");
        this.field_70405_b = func_70398_a(this.field_70404_d[1]);

        if (p_70307_1_.func_74764_b("CustomName"))
        {
            this.field_94130_e = p_70307_1_.func_74779_i("CustomName");
        }
    }

    public void func_70310_b(NBTTagCompound p_70310_1_)
    {
        super.func_70310_b(p_70310_1_);
        p_70310_1_.func_74777_a("BurnTime", (short)this.field_70407_a);
        p_70310_1_.func_74777_a("CookTime", (short)this.field_70406_c);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.field_70404_d.length; ++i)
        {
            if (this.field_70404_d[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.func_74774_a("Slot", (byte)i);
                this.field_70404_d[i].func_77955_b(nbttagcompound1);
                nbttaglist.func_74742_a(nbttagcompound1);
            }
        }

        p_70310_1_.func_74782_a("Items", nbttaglist);

        if (this.func_94042_c())
        {
            p_70310_1_.func_74778_a("CustomName", this.field_94130_e);
        }
    }

    public int func_70297_j_()
    {
        return 64;
    }

    @SideOnly(Side.CLIENT)
    public int func_70397_c(int p_70397_1_)
    {
        return this.field_70406_c * p_70397_1_ / 200;
    }

    @SideOnly(Side.CLIENT)
    public int func_70403_d(int p_70403_1_)
    {
        if (this.field_70405_b == 0)
        {
            this.field_70405_b = 200;
        }

        return this.field_70407_a * p_70403_1_ / this.field_70405_b;
    }

    public boolean func_70400_i()
    {
        return this.field_70407_a > 0;
    }

    public void func_70316_g()
    {
        boolean flag = this.field_70407_a > 0;
        boolean flag1 = false;

        if (this.field_70407_a > 0)
        {
            --this.field_70407_a;
        }

        if (!this.field_70331_k.field_72995_K)
        {
            if (this.field_70407_a == 0 && this.func_70402_r())
            {
                this.field_70405_b = this.field_70407_a = func_70398_a(this.field_70404_d[1]);

                if (this.field_70407_a > 0)
                {
                    flag1 = true;

                    if (this.field_70404_d[1] != null)
                    {
                        --this.field_70404_d[1].field_77994_a;

                        if (this.field_70404_d[1].field_77994_a == 0)
                        {
                            Item item = this.field_70404_d[1].func_77973_b().func_77668_q();
                            this.field_70404_d[1] = item != null ? new ItemStack(item) : null;
                        }
                    }
                }
            }

            if (this.func_70400_i() && this.func_70402_r())
            {
                ++this.field_70406_c;

                if (this.field_70406_c == 200)
                {
                    this.field_70406_c = 0;
                    this.func_70399_k();
                    flag1 = true;
                }
            }
            else
            {
                this.field_70406_c = 0;
            }

            if (flag != this.field_70407_a > 0)
            {
                flag1 = true;
                BlockFurnace.func_72286_a(this.field_70407_a > 0, this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n);
            }
        }

        if (flag1)
        {
            this.func_70296_d();
        }
    }

    private boolean func_70402_r()
    {
        if (this.field_70404_d[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.func_77602_a().func_77603_b(this.field_70404_d[0].func_77973_b().field_77779_bT);
            return itemstack == null ? false : (this.field_70404_d[2] == null ? true : (!this.field_70404_d[2].func_77969_a(itemstack) ? false : (this.field_70404_d[2].field_77994_a < this.func_70297_j_() && this.field_70404_d[2].field_77994_a < this.field_70404_d[2].func_77976_d() ? true : this.field_70404_d[2].field_77994_a < itemstack.func_77976_d())));
        }
    }

    public void func_70399_k()
    {
        if (this.func_70402_r())
        {
            ItemStack itemstack = FurnaceRecipes.func_77602_a().func_77603_b(this.field_70404_d[0].func_77973_b().field_77779_bT);

            if (this.field_70404_d[2] == null)
            {
                this.field_70404_d[2] = itemstack.func_77946_l();
            }
            else if (this.field_70404_d[2].field_77993_c == itemstack.field_77993_c)
            {
                ++this.field_70404_d[2].field_77994_a;
            }

            --this.field_70404_d[0].field_77994_a;

            if (this.field_70404_d[0].field_77994_a <= 0)
            {
                this.field_70404_d[0] = null;
            }
        }
    }

    public static int func_70398_a(ItemStack p_70398_0_)
    {
        if (p_70398_0_ == null)
        {
            return 0;
        }
        else
        {
            int i = p_70398_0_.func_77973_b().field_77779_bT;
            Item item = p_70398_0_.func_77973_b();

            if (i < 256 && Block.field_71973_m[i] != null)
            {
                Block block = Block.field_71973_m[i];

                if (block == Block.field_72092_bO)
                {
                    return 150;
                }

                if (block.field_72018_cp == Material.field_76245_d)
                {
                    return 300;
                }

                if (block == Block.field_111034_cE)
                {
                    return 16000;
                }
            }

            return item instanceof ItemTool && ((ItemTool)item).func_77861_e().equals("WOOD") ? 200 : (item instanceof ItemSword && ((ItemSword)item).func_77825_f().equals("WOOD") ? 200 : (item instanceof ItemHoe && ((ItemHoe)item).func_77842_f().equals("WOOD") ? 200 : (i == Item.field_77669_D.field_77779_bT ? 100 : (i == Item.field_77705_m.field_77779_bT ? 1600 : (i == Item.field_77775_ay.field_77779_bT ? 20000 : (i == Block.field_71987_y.field_71990_ca ? 100 : (i == Item.field_77731_bo.field_77779_bT ? 2400 : 0)))))));
        }
    }

    public static boolean func_70401_b(ItemStack p_70401_0_)
    {
        return func_70398_a(p_70401_0_) > 0;
    }

    public boolean func_70300_a(EntityPlayer p_70300_1_)
    {
        return this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this ? false : p_70300_1_.func_70092_e((double)this.field_70329_l + 0.5D, (double)this.field_70330_m + 0.5D, (double)this.field_70327_n + 0.5D) <= 64.0D;
    }

    public void func_70295_k_() {}

    public void func_70305_f() {}

    public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_)
    {
        return p_94041_1_ == 2 ? false : (p_94041_1_ == 1 ? func_70401_b(p_94041_2_) : true);
    }

    public int[] func_94128_d(int p_94128_1_)
    {
        return p_94128_1_ == 0 ? field_102011_e : (p_94128_1_ == 1 ? field_102010_d : field_102009_f);
    }

    public boolean func_102007_a(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_)
    {
        return this.func_94041_b(p_102007_1_, p_102007_2_);
    }

    public boolean func_102008_b(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_)
    {
        return p_102008_3_ != 0 || p_102008_1_ != 1 || p_102008_2_.field_77993_c == Item.field_77788_aw.field_77779_bT;
    }
}