package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class NBTTagIntArray extends NBTBase
{
    public int[] field_74749_a;

    public NBTTagIntArray(String p_i1380_1_)
    {
        super(p_i1380_1_);
    }

    public NBTTagIntArray(String p_i1381_1_, int[] p_i1381_2_)
    {
        super(p_i1381_1_);
        this.field_74749_a = p_i1381_2_;
    }

    void func_74734_a(DataOutput p_74734_1_) throws IOException
    {
        p_74734_1_.writeInt(this.field_74749_a.length);

        for (int i = 0; i < this.field_74749_a.length; ++i)
        {
            p_74734_1_.writeInt(this.field_74749_a[i]);
        }
    }

    void func_74735_a(DataInput p_74735_1_, int p_74735_2_) throws IOException
    {
        int j = p_74735_1_.readInt();
        this.field_74749_a = new int[j];

        for (int k = 0; k < j; ++k)
        {
            this.field_74749_a[k] = p_74735_1_.readInt();
        }
    }

    public byte func_74732_a()
    {
        return (byte)11;
    }

    public String toString()
    {
        return "[" + this.field_74749_a.length + " bytes]";
    }

    public NBTBase func_74737_b()
    {
        int[] aint = new int[this.field_74749_a.length];
        System.arraycopy(this.field_74749_a, 0, aint, 0, this.field_74749_a.length);
        return new NBTTagIntArray(this.func_74740_e(), aint);
    }

    public boolean equals(Object p_equals_1_)
    {
        if (!super.equals(p_equals_1_))
        {
            return false;
        }
        else
        {
            NBTTagIntArray nbttagintarray = (NBTTagIntArray)p_equals_1_;
            return this.field_74749_a == null && nbttagintarray.field_74749_a == null || this.field_74749_a != null && Arrays.equals(this.field_74749_a, nbttagintarray.field_74749_a);
        }
    }

    public int hashCode()
    {
        return super.hashCode() ^ Arrays.hashCode(this.field_74749_a);
    }
}
