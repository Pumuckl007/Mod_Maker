package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagDouble extends NBTBase
{
    public double field_74755_a;

    public NBTTagDouble(String p_i1376_1_)
    {
        super(p_i1376_1_);
    }

    public NBTTagDouble(String p_i1377_1_, double p_i1377_2_)
    {
        super(p_i1377_1_);
        this.field_74755_a = p_i1377_2_;
    }

    void func_74734_a(DataOutput p_74734_1_) throws IOException
    {
        p_74734_1_.writeDouble(this.field_74755_a);
    }

    void func_74735_a(DataInput p_74735_1_, int p_74735_2_) throws IOException
    {
        this.field_74755_a = p_74735_1_.readDouble();
    }

    public byte func_74732_a()
    {
        return (byte)6;
    }

    public String toString()
    {
        return "" + this.field_74755_a;
    }

    public NBTBase func_74737_b()
    {
        return new NBTTagDouble(this.func_74740_e(), this.field_74755_a);
    }

    public boolean equals(Object p_equals_1_)
    {
        if (super.equals(p_equals_1_))
        {
            NBTTagDouble nbttagdouble = (NBTTagDouble)p_equals_1_;
            return this.field_74755_a == nbttagdouble.field_74755_a;
        }
        else
        {
            return false;
        }
    }

    public int hashCode()
    {
        long i = Double.doubleToLongBits(this.field_74755_a);
        return super.hashCode() ^ (int)(i ^ i >>> 32);
    }
}
