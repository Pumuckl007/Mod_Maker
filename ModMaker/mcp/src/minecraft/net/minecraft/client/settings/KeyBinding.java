package net.minecraft.client.settings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.IntHashMap;

@SideOnly(Side.CLIENT)
public class KeyBinding
{
    public static List field_74516_a = new ArrayList();
    public static IntHashMap field_74514_b = new IntHashMap();
    public String field_74515_c;
    public int field_74512_d;
    public boolean field_74513_e;
    public int field_74511_f;

    public static void func_74507_a(int p_74507_0_)
    {
        KeyBinding keybinding = (KeyBinding)field_74514_b.func_76041_a(p_74507_0_);

        if (keybinding != null)
        {
            ++keybinding.field_74511_f;
        }
    }

    public static void func_74510_a(int p_74510_0_, boolean p_74510_1_)
    {
        KeyBinding keybinding = (KeyBinding)field_74514_b.func_76041_a(p_74510_0_);

        if (keybinding != null)
        {
            keybinding.field_74513_e = p_74510_1_;
        }
    }

    public static void func_74506_a()
    {
        Iterator iterator = field_74516_a.iterator();

        while (iterator.hasNext())
        {
            KeyBinding keybinding = (KeyBinding)iterator.next();
            keybinding.func_74505_d();
        }
    }

    public static void func_74508_b()
    {
        field_74514_b.func_76046_c();
        Iterator iterator = field_74516_a.iterator();

        while (iterator.hasNext())
        {
            KeyBinding keybinding = (KeyBinding)iterator.next();
            field_74514_b.func_76038_a(keybinding.field_74512_d, keybinding);
        }
    }

    public KeyBinding(String p_i1001_1_, int p_i1001_2_)
    {
        this.field_74515_c = p_i1001_1_;
        this.field_74512_d = p_i1001_2_;
        field_74516_a.add(this);
        field_74514_b.func_76038_a(p_i1001_2_, this);
    }

    public boolean func_74509_c()
    {
        if (this.field_74511_f == 0)
        {
            return false;
        }
        else
        {
            --this.field_74511_f;
            return true;
        }
    }

    private void func_74505_d()
    {
        this.field_74511_f = 0;
        this.field_74513_e = false;
    }
}
