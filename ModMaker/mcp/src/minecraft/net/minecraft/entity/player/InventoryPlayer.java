package net.minecraft.entity.player;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ReportedException;

public class InventoryPlayer implements IInventory
{
    public ItemStack[] field_70462_a = new ItemStack[36];
    public ItemStack[] field_70460_b = new ItemStack[4];
    public int field_70461_c;
    @SideOnly(Side.CLIENT)
    private ItemStack field_70456_f;
    public EntityPlayer field_70458_d;
    private ItemStack field_70457_g;
    public boolean field_70459_e;

    public InventoryPlayer(EntityPlayer p_i1750_1_)
    {
        this.field_70458_d = p_i1750_1_;
    }

    public ItemStack func_70448_g()
    {
        return this.field_70461_c < 9 && this.field_70461_c >= 0 ? this.field_70462_a[this.field_70461_c] : null;
    }

    public static int func_70451_h()
    {
        return 9;
    }

    private int func_70446_h(int p_70446_1_)
    {
        for (int j = 0; j < this.field_70462_a.length; ++j)
        {
            if (this.field_70462_a[j] != null && this.field_70462_a[j].field_77993_c == p_70446_1_)
            {
                return j;
            }
        }

        return -1;
    }

    @SideOnly(Side.CLIENT)
    private int func_70434_c(int p_70434_1_, int p_70434_2_)
    {
        for (int k = 0; k < this.field_70462_a.length; ++k)
        {
            if (this.field_70462_a[k] != null && this.field_70462_a[k].field_77993_c == p_70434_1_ && this.field_70462_a[k].func_77960_j() == p_70434_2_)
            {
                return k;
            }
        }

        return -1;
    }

    private int func_70432_d(ItemStack p_70432_1_)
    {
        for (int i = 0; i < this.field_70462_a.length; ++i)
        {
            if (this.field_70462_a[i] != null && this.field_70462_a[i].field_77993_c == p_70432_1_.field_77993_c && this.field_70462_a[i].func_77985_e() && this.field_70462_a[i].field_77994_a < this.field_70462_a[i].func_77976_d() && this.field_70462_a[i].field_77994_a < this.func_70297_j_() && (!this.field_70462_a[i].func_77981_g() || this.field_70462_a[i].func_77960_j() == p_70432_1_.func_77960_j()) && ItemStack.func_77970_a(this.field_70462_a[i], p_70432_1_))
            {
                return i;
            }
        }

        return -1;
    }

    public int func_70447_i()
    {
        for (int i = 0; i < this.field_70462_a.length; ++i)
        {
            if (this.field_70462_a[i] == null)
            {
                return i;
            }
        }

        return -1;
    }

    @SideOnly(Side.CLIENT)
    public void func_70433_a(int p_70433_1_, int p_70433_2_, boolean p_70433_3_, boolean p_70433_4_)
    {
        boolean flag2 = true;
        this.field_70456_f = this.func_70448_g();
        int k;

        if (p_70433_3_)
        {
            k = this.func_70434_c(p_70433_1_, p_70433_2_);
        }
        else
        {
            k = this.func_70446_h(p_70433_1_);
        }

        if (k >= 0 && k < 9)
        {
            this.field_70461_c = k;
        }
        else
        {
            if (p_70433_4_ && p_70433_1_ > 0)
            {
                int l = this.func_70447_i();

                if (l >= 0 && l < 9)
                {
                    this.field_70461_c = l;
                }

                this.func_70439_a(Item.field_77698_e[p_70433_1_], p_70433_2_);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_70453_c(int p_70453_1_)
    {
        if (p_70453_1_ > 0)
        {
            p_70453_1_ = 1;
        }

        if (p_70453_1_ < 0)
        {
            p_70453_1_ = -1;
        }

        for (this.field_70461_c -= p_70453_1_; this.field_70461_c < 0; this.field_70461_c += 9)
        {
            ;
        }

        while (this.field_70461_c >= 9)
        {
            this.field_70461_c -= 9;
        }
    }

    public int func_82347_b(int p_82347_1_, int p_82347_2_)
    {
        int k = 0;
        int l;
        ItemStack itemstack;

        for (l = 0; l < this.field_70462_a.length; ++l)
        {
            itemstack = this.field_70462_a[l];

            if (itemstack != null && (p_82347_1_ <= -1 || itemstack.field_77993_c == p_82347_1_) && (p_82347_2_ <= -1 || itemstack.func_77960_j() == p_82347_2_))
            {
                k += itemstack.field_77994_a;
                this.field_70462_a[l] = null;
            }
        }

        for (l = 0; l < this.field_70460_b.length; ++l)
        {
            itemstack = this.field_70460_b[l];

            if (itemstack != null && (p_82347_1_ <= -1 || itemstack.field_77993_c == p_82347_1_) && (p_82347_2_ <= -1 || itemstack.func_77960_j() == p_82347_2_))
            {
                k += itemstack.field_77994_a;
                this.field_70460_b[l] = null;
            }
        }

        if (this.field_70457_g != null)
        {
            if (p_82347_1_ > -1 && this.field_70457_g.field_77993_c != p_82347_1_)
            {
                return k;
            }

            if (p_82347_2_ > -1 && this.field_70457_g.func_77960_j() != p_82347_2_)
            {
                return k;
            }

            k += this.field_70457_g.field_77994_a;
            this.func_70437_b((ItemStack)null);
        }

        return k;
    }

    @SideOnly(Side.CLIENT)
    public void func_70439_a(Item p_70439_1_, int p_70439_2_)
    {
        if (p_70439_1_ != null)
        {
            if (this.field_70456_f != null && this.field_70456_f.func_77956_u() && this.func_70434_c(this.field_70456_f.field_77993_c, this.field_70456_f.func_77952_i()) == this.field_70461_c)
            {
                return;
            }

            int j = this.func_70434_c(p_70439_1_.field_77779_bT, p_70439_2_);

            if (j >= 0)
            {
                int k = this.field_70462_a[j].field_77994_a;
                this.field_70462_a[j] = this.field_70462_a[this.field_70461_c];
                this.field_70462_a[this.field_70461_c] = new ItemStack(Item.field_77698_e[p_70439_1_.field_77779_bT], k, p_70439_2_);
            }
            else
            {
                this.field_70462_a[this.field_70461_c] = new ItemStack(Item.field_77698_e[p_70439_1_.field_77779_bT], 1, p_70439_2_);
            }
        }
    }

    private int func_70452_e(ItemStack p_70452_1_)
    {
        int i = p_70452_1_.field_77993_c;
        int j = p_70452_1_.field_77994_a;
        int k;

        if (p_70452_1_.func_77976_d() == 1)
        {
            k = this.func_70447_i();

            if (k < 0)
            {
                return j;
            }
            else
            {
                if (this.field_70462_a[k] == null)
                {
                    this.field_70462_a[k] = ItemStack.func_77944_b(p_70452_1_);
                }

                return 0;
            }
        }
        else
        {
            k = this.func_70432_d(p_70452_1_);

            if (k < 0)
            {
                k = this.func_70447_i();
            }

            if (k < 0)
            {
                return j;
            }
            else
            {
                if (this.field_70462_a[k] == null)
                {
                    this.field_70462_a[k] = new ItemStack(i, 0, p_70452_1_.func_77960_j());

                    if (p_70452_1_.func_77942_o())
                    {
                        this.field_70462_a[k].func_77982_d((NBTTagCompound)p_70452_1_.func_77978_p().func_74737_b());
                    }
                }

                int l = j;

                if (j > this.field_70462_a[k].func_77976_d() - this.field_70462_a[k].field_77994_a)
                {
                    l = this.field_70462_a[k].func_77976_d() - this.field_70462_a[k].field_77994_a;
                }

                if (l > this.func_70297_j_() - this.field_70462_a[k].field_77994_a)
                {
                    l = this.func_70297_j_() - this.field_70462_a[k].field_77994_a;
                }

                if (l == 0)
                {
                    return j;
                }
                else
                {
                    j -= l;
                    this.field_70462_a[k].field_77994_a += l;
                    this.field_70462_a[k].field_77992_b = 5;
                    return j;
                }
            }
        }
    }

    public void func_70429_k()
    {
        for (int i = 0; i < this.field_70462_a.length; ++i)
        {
            if (this.field_70462_a[i] != null)
            {
                this.field_70462_a[i].func_77945_a(this.field_70458_d.field_70170_p, this.field_70458_d, i, this.field_70461_c == i);
            }
        }
    }

    public boolean func_70435_d(int p_70435_1_)
    {
        int j = this.func_70446_h(p_70435_1_);

        if (j < 0)
        {
            return false;
        }
        else
        {
            if (--this.field_70462_a[j].field_77994_a <= 0)
            {
                this.field_70462_a[j] = null;
            }

            return true;
        }
    }

    public boolean func_70450_e(int p_70450_1_)
    {
        int j = this.func_70446_h(p_70450_1_);
        return j >= 0;
    }

    public boolean func_70441_a(ItemStack p_70441_1_)
    {
        if (p_70441_1_ == null)
        {
            return false;
        }
        else if (p_70441_1_.field_77994_a == 0)
        {
            return false;
        }
        else
        {
            try
            {
                int i;

                if (p_70441_1_.func_77951_h())
                {
                    i = this.func_70447_i();

                    if (i >= 0)
                    {
                        this.field_70462_a[i] = ItemStack.func_77944_b(p_70441_1_);
                        this.field_70462_a[i].field_77992_b = 5;
                        p_70441_1_.field_77994_a = 0;
                        return true;
                    }
                    else if (this.field_70458_d.field_71075_bZ.field_75098_d)
                    {
                        p_70441_1_.field_77994_a = 0;
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    do
                    {
                        i = p_70441_1_.field_77994_a;
                        p_70441_1_.field_77994_a = this.func_70452_e(p_70441_1_);
                    }
                    while (p_70441_1_.field_77994_a > 0 && p_70441_1_.field_77994_a < i);

                    if (p_70441_1_.field_77994_a == i && this.field_70458_d.field_71075_bZ.field_75098_d)
                    {
                        p_70441_1_.field_77994_a = 0;
                        return true;
                    }
                    else
                    {
                        return p_70441_1_.field_77994_a < i;
                    }
                }
            }
            catch (Throwable throwable)
            {
                CrashReport crashreport = CrashReport.func_85055_a(throwable, "Adding item to inventory");
                CrashReportCategory crashreportcategory = crashreport.func_85058_a("Item being added");
                crashreportcategory.func_71507_a("Item ID", Integer.valueOf(p_70441_1_.field_77993_c));
                crashreportcategory.func_71507_a("Item data", Integer.valueOf(p_70441_1_.func_77960_j()));
                crashreportcategory.func_71500_a("Item name", new CallableItemName(this, p_70441_1_));
                throw new ReportedException(crashreport);
            }
        }
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        ItemStack[] aitemstack = this.field_70462_a;

        if (p_70298_1_ >= this.field_70462_a.length)
        {
            aitemstack = this.field_70460_b;
            p_70298_1_ -= this.field_70462_a.length;
        }

        if (aitemstack[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (aitemstack[p_70298_1_].field_77994_a <= p_70298_2_)
            {
                itemstack = aitemstack[p_70298_1_];
                aitemstack[p_70298_1_] = null;
                return itemstack;
            }
            else
            {
                itemstack = aitemstack[p_70298_1_].func_77979_a(p_70298_2_);

                if (aitemstack[p_70298_1_].field_77994_a == 0)
                {
                    aitemstack[p_70298_1_] = null;
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
        ItemStack[] aitemstack = this.field_70462_a;

        if (p_70304_1_ >= this.field_70462_a.length)
        {
            aitemstack = this.field_70460_b;
            p_70304_1_ -= this.field_70462_a.length;
        }

        if (aitemstack[p_70304_1_] != null)
        {
            ItemStack itemstack = aitemstack[p_70304_1_];
            aitemstack[p_70304_1_] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        ItemStack[] aitemstack = this.field_70462_a;

        if (p_70299_1_ >= aitemstack.length)
        {
            p_70299_1_ -= aitemstack.length;
            aitemstack = this.field_70460_b;
        }

        aitemstack[p_70299_1_] = p_70299_2_;
    }

    public float func_70438_a(Block p_70438_1_)
    {
        float f = 1.0F;

        if (this.field_70462_a[this.field_70461_c] != null)
        {
            f *= this.field_70462_a[this.field_70461_c].func_77967_a(p_70438_1_);
        }

        return f;
    }

    public NBTTagList func_70442_a(NBTTagList p_70442_1_)
    {
        int i;
        NBTTagCompound nbttagcompound;

        for (i = 0; i < this.field_70462_a.length; ++i)
        {
            if (this.field_70462_a[i] != null)
            {
                nbttagcompound = new NBTTagCompound();
                nbttagcompound.func_74774_a("Slot", (byte)i);
                this.field_70462_a[i].func_77955_b(nbttagcompound);
                p_70442_1_.func_74742_a(nbttagcompound);
            }
        }

        for (i = 0; i < this.field_70460_b.length; ++i)
        {
            if (this.field_70460_b[i] != null)
            {
                nbttagcompound = new NBTTagCompound();
                nbttagcompound.func_74774_a("Slot", (byte)(i + 100));
                this.field_70460_b[i].func_77955_b(nbttagcompound);
                p_70442_1_.func_74742_a(nbttagcompound);
            }
        }

        return p_70442_1_;
    }

    public void func_70443_b(NBTTagList p_70443_1_)
    {
        this.field_70462_a = new ItemStack[36];
        this.field_70460_b = new ItemStack[4];

        for (int i = 0; i < p_70443_1_.func_74745_c(); ++i)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)p_70443_1_.func_74743_b(i);
            int j = nbttagcompound.func_74771_c("Slot") & 255;
            ItemStack itemstack = ItemStack.func_77949_a(nbttagcompound);

            if (itemstack != null)
            {
                if (j >= 0 && j < this.field_70462_a.length)
                {
                    this.field_70462_a[j] = itemstack;
                }

                if (j >= 100 && j < this.field_70460_b.length + 100)
                {
                    this.field_70460_b[j - 100] = itemstack;
                }
            }
        }
    }

    public int func_70302_i_()
    {
        return this.field_70462_a.length + 4;
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        ItemStack[] aitemstack = this.field_70462_a;

        if (p_70301_1_ >= aitemstack.length)
        {
            p_70301_1_ -= aitemstack.length;
            aitemstack = this.field_70460_b;
        }

        return aitemstack[p_70301_1_];
    }

    public String func_70303_b()
    {
        return "container.inventory";
    }

    public boolean func_94042_c()
    {
        return false;
    }

    public int func_70297_j_()
    {
        return 64;
    }

    public boolean func_70454_b(Block p_70454_1_)
    {
        if (p_70454_1_.field_72018_cp.func_76229_l())
        {
            return true;
        }
        else
        {
            ItemStack itemstack = this.func_70301_a(this.field_70461_c);
            return itemstack != null ? itemstack.func_77987_b(p_70454_1_) : false;
        }
    }

    public ItemStack func_70440_f(int p_70440_1_)
    {
        return this.field_70460_b[p_70440_1_];
    }

    public int func_70430_l()
    {
        int i = 0;

        for (int j = 0; j < this.field_70460_b.length; ++j)
        {
            if (this.field_70460_b[j] != null && this.field_70460_b[j].func_77973_b() instanceof ItemArmor)
            {
                int k = ((ItemArmor)this.field_70460_b[j].func_77973_b()).field_77879_b;
                i += k;
            }
        }

        return i;
    }

    public void func_70449_g(float p_70449_1_)
    {
        p_70449_1_ /= 4.0F;

        if (p_70449_1_ < 1.0F)
        {
            p_70449_1_ = 1.0F;
        }

        for (int i = 0; i < this.field_70460_b.length; ++i)
        {
            if (this.field_70460_b[i] != null && this.field_70460_b[i].func_77973_b() instanceof ItemArmor)
            {
                this.field_70460_b[i].func_77972_a((int)p_70449_1_, this.field_70458_d);

                if (this.field_70460_b[i].field_77994_a == 0)
                {
                    this.field_70460_b[i] = null;
                }
            }
        }
    }

    public void func_70436_m()
    {
        int i;

        for (i = 0; i < this.field_70462_a.length; ++i)
        {
            if (this.field_70462_a[i] != null)
            {
                this.field_70458_d.func_71019_a(this.field_70462_a[i], true);
                this.field_70462_a[i] = null;
            }
        }

        for (i = 0; i < this.field_70460_b.length; ++i)
        {
            if (this.field_70460_b[i] != null)
            {
                this.field_70458_d.func_71019_a(this.field_70460_b[i], true);
                this.field_70460_b[i] = null;
            }
        }
    }

    public void func_70296_d()
    {
        this.field_70459_e = true;
    }

    public void func_70437_b(ItemStack p_70437_1_)
    {
        this.field_70457_g = p_70437_1_;
    }

    public ItemStack func_70445_o()
    {
        return this.field_70457_g;
    }

    public boolean func_70300_a(EntityPlayer p_70300_1_)
    {
        return this.field_70458_d.field_70128_L ? false : p_70300_1_.func_70068_e(this.field_70458_d) <= 64.0D;
    }

    public boolean func_70431_c(ItemStack p_70431_1_)
    {
        int i;

        for (i = 0; i < this.field_70460_b.length; ++i)
        {
            if (this.field_70460_b[i] != null && this.field_70460_b[i].func_77969_a(p_70431_1_))
            {
                return true;
            }
        }

        for (i = 0; i < this.field_70462_a.length; ++i)
        {
            if (this.field_70462_a[i] != null && this.field_70462_a[i].func_77969_a(p_70431_1_))
            {
                return true;
            }
        }

        return false;
    }

    public void func_70295_k_() {}

    public void func_70305_f() {}

    public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_)
    {
        return true;
    }

    public void func_70455_b(InventoryPlayer p_70455_1_)
    {
        int i;

        for (i = 0; i < this.field_70462_a.length; ++i)
        {
            this.field_70462_a[i] = ItemStack.func_77944_b(p_70455_1_.field_70462_a[i]);
        }

        for (i = 0; i < this.field_70460_b.length; ++i)
        {
            this.field_70460_b[i] = ItemStack.func_77944_b(p_70455_1_.field_70460_b[i]);
        }

        this.field_70461_c = p_70455_1_.field_70461_c;
    }
}
