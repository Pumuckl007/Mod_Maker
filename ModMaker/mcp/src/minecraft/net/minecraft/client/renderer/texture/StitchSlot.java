package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SideOnly(Side.CLIENT)
public class StitchSlot
{
    private final int field_94192_a;
    private final int field_94190_b;
    private final int field_94191_c;
    private final int field_94188_d;
    private List field_94189_e;
    private StitchHolder field_94187_f;

    public StitchSlot(int p_i1277_1_, int p_i1277_2_, int p_i1277_3_, int p_i1277_4_)
    {
        this.field_94192_a = p_i1277_1_;
        this.field_94190_b = p_i1277_2_;
        this.field_94191_c = p_i1277_3_;
        this.field_94188_d = p_i1277_4_;
    }

    public StitchHolder func_94183_a()
    {
        return this.field_94187_f;
    }

    public int func_94186_b()
    {
        return this.field_94192_a;
    }

    public int func_94185_c()
    {
        return this.field_94190_b;
    }

    public boolean func_94182_a(StitchHolder p_94182_1_)
    {
        if (this.field_94187_f != null)
        {
            return false;
        }
        else
        {
            int i = p_94182_1_.func_94197_a();
            int j = p_94182_1_.func_94199_b();

            if (i <= this.field_94191_c && j <= this.field_94188_d)
            {
                if (i == this.field_94191_c && j == this.field_94188_d)
                {
                    this.field_94187_f = p_94182_1_;
                    return true;
                }
                else
                {
                    if (this.field_94189_e == null)
                    {
                        this.field_94189_e = new ArrayList(1);
                        this.field_94189_e.add(new StitchSlot(this.field_94192_a, this.field_94190_b, i, j));
                        int k = this.field_94191_c - i;
                        int l = this.field_94188_d - j;

                        if (l > 0 && k > 0)
                        {
                            int i1 = Math.max(this.field_94188_d, k);
                            int j1 = Math.max(this.field_94191_c, l);

                            if (i1 >= j1)
                            {
                                this.field_94189_e.add(new StitchSlot(this.field_94192_a, this.field_94190_b + j, i, l));
                                this.field_94189_e.add(new StitchSlot(this.field_94192_a + i, this.field_94190_b, k, this.field_94188_d));
                            }
                            else
                            {
                                this.field_94189_e.add(new StitchSlot(this.field_94192_a + i, this.field_94190_b, k, j));
                                this.field_94189_e.add(new StitchSlot(this.field_94192_a, this.field_94190_b + j, this.field_94191_c, l));
                            }
                        }
                        else if (k == 0)
                        {
                            this.field_94189_e.add(new StitchSlot(this.field_94192_a, this.field_94190_b + j, i, l));
                        }
                        else if (l == 0)
                        {
                            this.field_94189_e.add(new StitchSlot(this.field_94192_a + i, this.field_94190_b, k, j));
                        }
                    }

                    Iterator iterator = this.field_94189_e.iterator();
                    StitchSlot stitchslot;

                    do
                    {
                        if (!iterator.hasNext())
                        {
                            return false;
                        }

                        stitchslot = (StitchSlot)iterator.next();
                    }
                    while (!stitchslot.func_94182_a(p_94182_1_));

                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }

    public void func_94184_a(List p_94184_1_)
    {
        if (this.field_94187_f != null)
        {
            p_94184_1_.add(this);
        }
        else if (this.field_94189_e != null)
        {
            Iterator iterator = this.field_94189_e.iterator();

            while (iterator.hasNext())
            {
                StitchSlot stitchslot = (StitchSlot)iterator.next();
                stitchslot.func_94184_a(p_94184_1_);
            }
        }
    }

    public String toString()
    {
        return "Slot{originX=" + this.field_94192_a + ", originY=" + this.field_94190_b + ", width=" + this.field_94191_c + ", height=" + this.field_94188_d + ", texture=" + this.field_94187_f + ", subSlots=" + this.field_94189_e + '}';
    }
}
