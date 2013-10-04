package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDispenser;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemArmor extends Item
{
    private static final int[] field_77882_bY = new int[] {11, 16, 15, 13};
    private static final String[] field_94606_cu = new String[] {"leather_helmet_overlay", "leather_chestplate_overlay", "leather_leggings_overlay", "leather_boots_overlay"};
    public static final String[] field_94603_a = new String[] {"empty_armor_slot_helmet", "empty_armor_slot_chestplate", "empty_armor_slot_leggings", "empty_armor_slot_boots"};
    private static final IBehaviorDispenseItem field_96605_cw = new BehaviorDispenseArmor();
    public final int field_77881_a;
    public final int field_77879_b;
    public final int field_77880_c;
    private final EnumArmorMaterial field_77878_bZ;
    @SideOnly(Side.CLIENT)
    private Icon field_94605_cw;
    @SideOnly(Side.CLIENT)
    private Icon field_94604_cx;

    public ItemArmor(int p_i1828_1_, EnumArmorMaterial p_i1828_2_, int p_i1828_3_, int p_i1828_4_)
    {
        super(p_i1828_1_);
        this.field_77878_bZ = p_i1828_2_;
        this.field_77881_a = p_i1828_4_;
        this.field_77880_c = p_i1828_3_;
        this.field_77879_b = p_i1828_2_.func_78044_b(p_i1828_4_);
        this.func_77656_e(p_i1828_2_.func_78046_a(p_i1828_4_));
        this.field_77777_bU = 1;
        this.func_77637_a(CreativeTabs.field_78037_j);
        BlockDispenser.field_82527_a.func_82595_a(this, field_96605_cw);
    }

    @SideOnly(Side.CLIENT)
    public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_)
    {
        if (p_82790_2_ > 0)
        {
            return 16777215;
        }
        else
        {
            int j = this.func_82814_b(p_82790_1_);

            if (j < 0)
            {
                j = 16777215;
            }

            return j;
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean func_77623_v()
    {
        return this.field_77878_bZ == EnumArmorMaterial.CLOTH;
    }

    public int func_77619_b()
    {
        return this.field_77878_bZ.func_78045_a();
    }

    public EnumArmorMaterial func_82812_d()
    {
        return this.field_77878_bZ;
    }

    public boolean func_82816_b_(ItemStack p_82816_1_)
    {
        return this.field_77878_bZ != EnumArmorMaterial.CLOTH ? false : (!p_82816_1_.func_77942_o() ? false : (!p_82816_1_.func_77978_p().func_74764_b("display") ? false : p_82816_1_.func_77978_p().func_74775_l("display").func_74764_b("color")));
    }

    public int func_82814_b(ItemStack p_82814_1_)
    {
        if (this.field_77878_bZ != EnumArmorMaterial.CLOTH)
        {
            return -1;
        }
        else
        {
            NBTTagCompound nbttagcompound = p_82814_1_.func_77978_p();

            if (nbttagcompound == null)
            {
                return 10511680;
            }
            else
            {
                NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l("display");
                return nbttagcompound1 == null ? 10511680 : (nbttagcompound1.func_74764_b("color") ? nbttagcompound1.func_74762_e("color") : 10511680);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public Icon func_77618_c(int p_77618_1_, int p_77618_2_)
    {
        return p_77618_2_ == 1 ? this.field_94605_cw : super.func_77618_c(p_77618_1_, p_77618_2_);
    }

    public void func_82815_c(ItemStack p_82815_1_)
    {
        if (this.field_77878_bZ == EnumArmorMaterial.CLOTH)
        {
            NBTTagCompound nbttagcompound = p_82815_1_.func_77978_p();

            if (nbttagcompound != null)
            {
                NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l("display");

                if (nbttagcompound1.func_74764_b("color"))
                {
                    nbttagcompound1.func_82580_o("color");
                }
            }
        }
    }

    public void func_82813_b(ItemStack p_82813_1_, int p_82813_2_)
    {
        if (this.field_77878_bZ != EnumArmorMaterial.CLOTH)
        {
            throw new UnsupportedOperationException("Can\'t dye non-leather!");
        }
        else
        {
            NBTTagCompound nbttagcompound = p_82813_1_.func_77978_p();

            if (nbttagcompound == null)
            {
                nbttagcompound = new NBTTagCompound();
                p_82813_1_.func_77982_d(nbttagcompound);
            }

            NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l("display");

            if (!nbttagcompound.func_74764_b("display"))
            {
                nbttagcompound.func_74766_a("display", nbttagcompound1);
            }

            nbttagcompound1.func_74768_a("color", p_82813_2_);
        }
    }

    public boolean func_82789_a(ItemStack p_82789_1_, ItemStack p_82789_2_)
    {
        return this.field_77878_bZ.func_82845_b() == p_82789_2_.field_77993_c ? true : super.func_82789_a(p_82789_1_, p_82789_2_);
    }

    @SideOnly(Side.CLIENT)
    public void func_94581_a(IconRegister p_94581_1_)
    {
        super.func_94581_a(p_94581_1_);

        if (this.field_77878_bZ == EnumArmorMaterial.CLOTH)
        {
            this.field_94605_cw = p_94581_1_.func_94245_a(field_94606_cu[this.field_77881_a]);
        }

        this.field_94604_cx = p_94581_1_.func_94245_a(field_94603_a[this.field_77881_a]);
    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        int i = EntityLiving.func_82159_b(p_77659_1_) - 1;
        ItemStack itemstack1 = p_77659_3_.func_82169_q(i);

        if (itemstack1 == null)
        {
            p_77659_3_.func_70062_b(i, p_77659_1_.func_77946_l());
            p_77659_1_.field_77994_a = 0;
        }

        return p_77659_1_;
    }

    @SideOnly(Side.CLIENT)
    public static Icon func_94602_b(int p_94602_0_)
    {
        switch (p_94602_0_)
        {
            case 0:
                return Item.field_77820_ah.field_94604_cx;
            case 1:
                return Item.field_77798_ai.field_94604_cx;
            case 2:
                return Item.field_77800_aj.field_94604_cx;
            case 3:
                return Item.field_77794_ak.field_94604_cx;
            default:
                return null;
        }
    }

    static int[] func_77877_c()
    {
        return field_77882_bY;
    }
}
