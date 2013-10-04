package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;

public class ItemFireworkCharge extends Item
{
    @SideOnly(Side.CLIENT)
    private Icon field_94596_a;

    public ItemFireworkCharge(int p_i1864_1_)
    {
        super(p_i1864_1_);
    }

    @SideOnly(Side.CLIENT)
    public Icon func_77618_c(int p_77618_1_, int p_77618_2_)
    {
        return p_77618_2_ > 0 ? this.field_94596_a : super.func_77618_c(p_77618_1_, p_77618_2_);
    }

    @SideOnly(Side.CLIENT)
    public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_)
    {
        if (p_82790_2_ != 1)
        {
            return super.func_82790_a(p_82790_1_, p_82790_2_);
        }
        else
        {
            NBTBase nbtbase = func_92108_a(p_82790_1_, "Colors");

            if (nbtbase == null)
            {
                return 9079434;
            }
            else
            {
                NBTTagIntArray nbttagintarray = (NBTTagIntArray)nbtbase;

                if (nbttagintarray.field_74749_a.length == 1)
                {
                    return nbttagintarray.field_74749_a[0];
                }
                else
                {
                    int j = 0;
                    int k = 0;
                    int l = 0;
                    int[] aint = nbttagintarray.field_74749_a;
                    int i1 = aint.length;

                    for (int j1 = 0; j1 < i1; ++j1)
                    {
                        int k1 = aint[j1];
                        j += (k1 & 16711680) >> 16;
                        k += (k1 & 65280) >> 8;
                        l += (k1 & 255) >> 0;
                    }

                    j /= nbttagintarray.field_74749_a.length;
                    k /= nbttagintarray.field_74749_a.length;
                    l /= nbttagintarray.field_74749_a.length;
                    return j << 16 | k << 8 | l;
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean func_77623_v()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public static NBTBase func_92108_a(ItemStack p_92108_0_, String p_92108_1_)
    {
        if (p_92108_0_.func_77942_o())
        {
            NBTTagCompound nbttagcompound = p_92108_0_.func_77978_p().func_74775_l("Explosion");

            if (nbttagcompound != null)
            {
                return nbttagcompound.func_74781_a(p_92108_1_);
            }
        }

        return null;
    }

    @SideOnly(Side.CLIENT)
    public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
    {
        if (p_77624_1_.func_77942_o())
        {
            NBTTagCompound nbttagcompound = p_77624_1_.func_77978_p().func_74775_l("Explosion");

            if (nbttagcompound != null)
            {
                func_92107_a(nbttagcompound, p_77624_3_);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static void func_92107_a(NBTTagCompound p_92107_0_, List p_92107_1_)
    {
        byte b0 = p_92107_0_.func_74771_c("Type");

        if (b0 >= 0 && b0 <= 4)
        {
            p_92107_1_.add(StatCollector.func_74838_a("item.fireworksCharge.type." + b0).trim());
        }
        else
        {
            p_92107_1_.add(StatCollector.func_74838_a("item.fireworksCharge.type").trim());
        }

        int[] aint = p_92107_0_.func_74759_k("Colors");
        int i;
        int j;

        if (aint.length > 0)
        {
            boolean flag = true;
            String s = "";
            int[] aint1 = aint;
            int k = aint.length;

            for (i = 0; i < k; ++i)
            {
                j = aint1[i];

                if (!flag)
                {
                    s = s + ", ";
                }

                flag = false;
                boolean flag1 = false;

                for (int l = 0; l < 16; ++l)
                {
                    if (j == ItemDye.field_77859_b[l])
                    {
                        flag1 = true;
                        s = s + StatCollector.func_74838_a("item.fireworksCharge." + ItemDye.field_77860_a[l]);
                        break;
                    }
                }

                if (!flag1)
                {
                    s = s + StatCollector.func_74838_a("item.fireworksCharge.customColor");
                }
            }

            p_92107_1_.add(s);
        }

        int[] aint2 = p_92107_0_.func_74759_k("FadeColors");
        boolean flag2;

        if (aint2.length > 0)
        {
            flag2 = true;
            String s1 = StatCollector.func_74838_a("item.fireworksCharge.fadeTo") + " ";
            int[] aint3 = aint2;
            i = aint2.length;

            for (j = 0; j < i; ++j)
            {
                int i1 = aint3[j];

                if (!flag2)
                {
                    s1 = s1 + ", ";
                }

                flag2 = false;
                boolean flag3 = false;

                for (int j1 = 0; j1 < 16; ++j1)
                {
                    if (i1 == ItemDye.field_77859_b[j1])
                    {
                        flag3 = true;
                        s1 = s1 + StatCollector.func_74838_a("item.fireworksCharge." + ItemDye.field_77860_a[j1]);
                        break;
                    }
                }

                if (!flag3)
                {
                    s1 = s1 + StatCollector.func_74838_a("item.fireworksCharge.customColor");
                }
            }

            p_92107_1_.add(s1);
        }

        flag2 = p_92107_0_.func_74767_n("Trail");

        if (flag2)
        {
            p_92107_1_.add(StatCollector.func_74838_a("item.fireworksCharge.trail"));
        }

        boolean flag4 = p_92107_0_.func_74767_n("Flicker");

        if (flag4)
        {
            p_92107_1_.add(StatCollector.func_74838_a("item.fireworksCharge.flicker"));
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_94581_a(IconRegister p_94581_1_)
    {
        super.func_94581_a(p_94581_1_);
        this.field_94596_a = p_94581_1_.func_94245_a(this.func_111208_A() + "_overlay");
    }
}
