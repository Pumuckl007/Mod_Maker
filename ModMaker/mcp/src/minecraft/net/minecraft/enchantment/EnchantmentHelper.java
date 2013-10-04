package net.minecraft.enchantment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.WeightedRandom;

public class EnchantmentHelper
{
    private static final Random field_77522_a = new Random();
    private static final EnchantmentModifierDamage field_77520_b = new EnchantmentModifierDamage((Empty3)null);
    private static final EnchantmentModifierLiving field_77521_c = new EnchantmentModifierLiving((Empty3)null);

    public static int func_77506_a(int p_77506_0_, ItemStack p_77506_1_)
    {
        if (p_77506_1_ == null)
        {
            return 0;
        }
        else
        {
            NBTTagList nbttaglist = p_77506_1_.func_77986_q();

            if (nbttaglist == null)
            {
                return 0;
            }
            else
            {
                for (int j = 0; j < nbttaglist.func_74745_c(); ++j)
                {
                    short short1 = ((NBTTagCompound)nbttaglist.func_74743_b(j)).func_74765_d("id");
                    short short2 = ((NBTTagCompound)nbttaglist.func_74743_b(j)).func_74765_d("lvl");

                    if (short1 == p_77506_0_)
                    {
                        return short2;
                    }
                }

                return 0;
            }
        }
    }

    public static Map func_82781_a(ItemStack p_82781_0_)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        NBTTagList nbttaglist = p_82781_0_.field_77993_c == Item.field_92105_bW.field_77779_bT ? Item.field_92105_bW.func_92110_g(p_82781_0_) : p_82781_0_.func_77986_q();

        if (nbttaglist != null)
        {
            for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
            {
                short short1 = ((NBTTagCompound)nbttaglist.func_74743_b(i)).func_74765_d("id");
                short short2 = ((NBTTagCompound)nbttaglist.func_74743_b(i)).func_74765_d("lvl");
                linkedhashmap.put(Integer.valueOf(short1), Integer.valueOf(short2));
            }
        }

        return linkedhashmap;
    }

    public static void func_82782_a(Map p_82782_0_, ItemStack p_82782_1_)
    {
        NBTTagList nbttaglist = new NBTTagList();
        Iterator iterator = p_82782_0_.keySet().iterator();

        while (iterator.hasNext())
        {
            int i = ((Integer)iterator.next()).intValue();
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.func_74777_a("id", (short)i);
            nbttagcompound.func_74777_a("lvl", (short)((Integer)p_82782_0_.get(Integer.valueOf(i))).intValue());
            nbttaglist.func_74742_a(nbttagcompound);

            if (p_82782_1_.field_77993_c == Item.field_92105_bW.field_77779_bT)
            {
                Item.field_92105_bW.func_92115_a(p_82782_1_, new EnchantmentData(i, ((Integer)p_82782_0_.get(Integer.valueOf(i))).intValue()));
            }
        }

        if (nbttaglist.func_74745_c() > 0)
        {
            if (p_82782_1_.field_77993_c != Item.field_92105_bW.field_77779_bT)
            {
                p_82782_1_.func_77983_a("ench", nbttaglist);
            }
        }
        else if (p_82782_1_.func_77942_o())
        {
            p_82782_1_.func_77978_p().func_82580_o("ench");
        }
    }

    public static int func_77511_a(int p_77511_0_, ItemStack[] p_77511_1_)
    {
        if (p_77511_1_ == null)
        {
            return 0;
        }
        else
        {
            int j = 0;
            ItemStack[] aitemstack1 = p_77511_1_;
            int k = p_77511_1_.length;

            for (int l = 0; l < k; ++l)
            {
                ItemStack itemstack = aitemstack1[l];
                int i1 = func_77506_a(p_77511_0_, itemstack);

                if (i1 > j)
                {
                    j = i1;
                }
            }

            return j;
        }
    }

    private static void func_77518_a(IEnchantmentModifier p_77518_0_, ItemStack p_77518_1_)
    {
        if (p_77518_1_ != null)
        {
            NBTTagList nbttaglist = p_77518_1_.func_77986_q();

            if (nbttaglist != null)
            {
                for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
                {
                    short short1 = ((NBTTagCompound)nbttaglist.func_74743_b(i)).func_74765_d("id");
                    short short2 = ((NBTTagCompound)nbttaglist.func_74743_b(i)).func_74765_d("lvl");

                    if (Enchantment.field_77331_b[short1] != null)
                    {
                        p_77518_0_.func_77493_a(Enchantment.field_77331_b[short1], short2);
                    }
                }
            }
        }
    }

    private static void func_77516_a(IEnchantmentModifier p_77516_0_, ItemStack[] p_77516_1_)
    {
        ItemStack[] aitemstack1 = p_77516_1_;
        int i = p_77516_1_.length;

        for (int j = 0; j < i; ++j)
        {
            ItemStack itemstack = aitemstack1[j];
            func_77518_a(p_77516_0_, itemstack);
        }
    }

    public static int func_77508_a(ItemStack[] p_77508_0_, DamageSource p_77508_1_)
    {
        field_77520_b.field_77497_a = 0;
        field_77520_b.field_77496_b = p_77508_1_;
        func_77516_a(field_77520_b, p_77508_0_);

        if (field_77520_b.field_77497_a > 25)
        {
            field_77520_b.field_77497_a = 25;
        }

        return (field_77520_b.field_77497_a + 1 >> 1) + field_77522_a.nextInt((field_77520_b.field_77497_a >> 1) + 1);
    }

    public static float func_77512_a(EntityLivingBase p_77512_0_, EntityLivingBase p_77512_1_)
    {
        field_77521_c.field_77495_a = 0.0F;
        field_77521_c.field_77494_b = p_77512_1_;
        func_77518_a(field_77521_c, p_77512_0_.func_70694_bm());
        return field_77521_c.field_77495_a;
    }

    public static int func_77507_b(EntityLivingBase p_77507_0_, EntityLivingBase p_77507_1_)
    {
        return func_77506_a(Enchantment.field_77337_m.field_77352_x, p_77507_0_.func_70694_bm());
    }

    public static int func_90036_a(EntityLivingBase p_90036_0_)
    {
        return func_77506_a(Enchantment.field_77334_n.field_77352_x, p_90036_0_.func_70694_bm());
    }

    public static int func_77501_a(EntityLivingBase p_77501_0_)
    {
        return func_77511_a(Enchantment.field_77340_h.field_77352_x, p_77501_0_.func_70035_c());
    }

    public static int func_77509_b(EntityLivingBase p_77509_0_)
    {
        return func_77506_a(Enchantment.field_77349_p.field_77352_x, p_77509_0_.func_70694_bm());
    }

    public static boolean func_77502_d(EntityLivingBase p_77502_0_)
    {
        return func_77506_a(Enchantment.field_77348_q.field_77352_x, p_77502_0_.func_70694_bm()) > 0;
    }

    public static int func_77517_e(EntityLivingBase p_77517_0_)
    {
        return func_77506_a(Enchantment.field_77346_s.field_77352_x, p_77517_0_.func_70694_bm());
    }

    public static int func_77519_f(EntityLivingBase p_77519_0_)
    {
        return func_77506_a(Enchantment.field_77335_o.field_77352_x, p_77519_0_.func_70694_bm());
    }

    public static boolean func_77510_g(EntityLivingBase p_77510_0_)
    {
        return func_77511_a(Enchantment.field_77341_i.field_77352_x, p_77510_0_.func_70035_c()) > 0;
    }

    public static int func_92098_i(EntityLivingBase p_92098_0_)
    {
        return func_77511_a(Enchantment.field_92091_k.field_77352_x, p_92098_0_.func_70035_c());
    }

    public static ItemStack func_92099_a(Enchantment p_92099_0_, EntityLivingBase p_92099_1_)
    {
        ItemStack[] aitemstack = p_92099_1_.func_70035_c();
        int i = aitemstack.length;

        for (int j = 0; j < i; ++j)
        {
            ItemStack itemstack = aitemstack[j];

            if (itemstack != null && func_77506_a(p_92099_0_.field_77352_x, itemstack) > 0)
            {
                return itemstack;
            }
        }

        return null;
    }

    public static int func_77514_a(Random p_77514_0_, int p_77514_1_, int p_77514_2_, ItemStack p_77514_3_)
    {
        Item item = p_77514_3_.func_77973_b();
        int k = item.func_77619_b();

        if (k <= 0)
        {
            return 0;
        }
        else
        {
            if (p_77514_2_ > 15)
            {
                p_77514_2_ = 15;
            }

            int l = p_77514_0_.nextInt(8) + 1 + (p_77514_2_ >> 1) + p_77514_0_.nextInt(p_77514_2_ + 1);
            return p_77514_1_ == 0 ? Math.max(l / 3, 1) : (p_77514_1_ == 1 ? l * 2 / 3 + 1 : Math.max(l, p_77514_2_ * 2));
        }
    }

    public static ItemStack func_77504_a(Random p_77504_0_, ItemStack p_77504_1_, int p_77504_2_)
    {
        List list = func_77513_b(p_77504_0_, p_77504_1_, p_77504_2_);
        boolean flag = p_77504_1_.field_77993_c == Item.field_77760_aL.field_77779_bT;

        if (flag)
        {
            p_77504_1_.field_77993_c = Item.field_92105_bW.field_77779_bT;
        }

        if (list != null)
        {
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                EnchantmentData enchantmentdata = (EnchantmentData)iterator.next();

                if (flag)
                {
                    Item.field_92105_bW.func_92115_a(p_77504_1_, enchantmentdata);
                }
                else
                {
                    p_77504_1_.func_77966_a(enchantmentdata.field_76302_b, enchantmentdata.field_76303_c);
                }
            }
        }

        return p_77504_1_;
    }

    public static List func_77513_b(Random p_77513_0_, ItemStack p_77513_1_, int p_77513_2_)
    {
        Item item = p_77513_1_.func_77973_b();
        int j = item.func_77619_b();

        if (j <= 0)
        {
            return null;
        }
        else
        {
            j /= 2;
            j = 1 + p_77513_0_.nextInt((j >> 1) + 1) + p_77513_0_.nextInt((j >> 1) + 1);
            int k = j + p_77513_2_;
            float f = (p_77513_0_.nextFloat() + p_77513_0_.nextFloat() - 1.0F) * 0.15F;
            int l = (int)((float)k * (1.0F + f) + 0.5F);

            if (l < 1)
            {
                l = 1;
            }

            ArrayList arraylist = null;
            Map map = func_77505_b(l, p_77513_1_);

            if (map != null && !map.isEmpty())
            {
                EnchantmentData enchantmentdata = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, map.values());

                if (enchantmentdata != null)
                {
                    arraylist = new ArrayList();
                    arraylist.add(enchantmentdata);

                    for (int i1 = l; p_77513_0_.nextInt(50) <= i1; i1 >>= 1)
                    {
                        Iterator iterator = map.keySet().iterator();

                        while (iterator.hasNext())
                        {
                            Integer integer = (Integer)iterator.next();
                            boolean flag = true;
                            Iterator iterator1 = arraylist.iterator();

                            while (true)
                            {
                                if (iterator1.hasNext())
                                {
                                    EnchantmentData enchantmentdata1 = (EnchantmentData)iterator1.next();

                                    if (enchantmentdata1.field_76302_b.func_77326_a(Enchantment.field_77331_b[integer.intValue()]))
                                    {
                                        continue;
                                    }

                                    flag = false;
                                }

                                if (!flag)
                                {
                                    iterator.remove();
                                }

                                break;
                            }
                        }

                        if (!map.isEmpty())
                        {
                            EnchantmentData enchantmentdata2 = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, map.values());
                            arraylist.add(enchantmentdata2);
                        }
                    }
                }
            }

            return arraylist;
        }
    }

    public static Map func_77505_b(int p_77505_0_, ItemStack p_77505_1_)
    {
        Item item = p_77505_1_.func_77973_b();
        HashMap hashmap = null;
        boolean flag = p_77505_1_.field_77993_c == Item.field_77760_aL.field_77779_bT;
        Enchantment[] aenchantment = Enchantment.field_77331_b;
        int j = aenchantment.length;

        for (int k = 0; k < j; ++k)
        {
            Enchantment enchantment = aenchantment[k];

            if (enchantment != null && (enchantment.field_77351_y.func_77557_a(item) || flag))
            {
                for (int l = enchantment.func_77319_d(); l <= enchantment.func_77325_b(); ++l)
                {
                    if (p_77505_0_ >= enchantment.func_77321_a(l) && p_77505_0_ <= enchantment.func_77317_b(l))
                    {
                        if (hashmap == null)
                        {
                            hashmap = new HashMap();
                        }

                        hashmap.put(Integer.valueOf(enchantment.field_77352_x), new EnchantmentData(enchantment, l));
                    }
                }
            }
        }

        return hashmap;
    }
}
