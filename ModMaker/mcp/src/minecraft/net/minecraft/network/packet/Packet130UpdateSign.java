package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Packet130UpdateSign extends Packet
{
    public int field_73311_a;
    public int field_73309_b;
    public int field_73310_c;
    public String[] field_73308_d;

    public Packet130UpdateSign()
    {
        this.field_73287_r = true;
    }

    public Packet130UpdateSign(int p_i1478_1_, int p_i1478_2_, int p_i1478_3_, String[] p_i1478_4_)
    {
        this.field_73287_r = true;
        this.field_73311_a = p_i1478_1_;
        this.field_73309_b = p_i1478_2_;
        this.field_73310_c = p_i1478_3_;
        this.field_73308_d = new String[] {p_i1478_4_[0], p_i1478_4_[1], p_i1478_4_[2], p_i1478_4_[3]};
    }

    public void func_73267_a(DataInput p_73267_1_) throws IOException
    {
        this.field_73311_a = p_73267_1_.readInt();
        this.field_73309_b = p_73267_1_.readShort();
        this.field_73310_c = p_73267_1_.readInt();
        this.field_73308_d = new String[4];

        for (int i = 0; i < 4; ++i)
        {
            this.field_73308_d[i] = func_73282_a(p_73267_1_, 15);
        }
    }

    public void func_73273_a(DataOutput p_73273_1_) throws IOException
    {
        p_73273_1_.writeInt(this.field_73311_a);
        p_73273_1_.writeShort(this.field_73309_b);
        p_73273_1_.writeInt(this.field_73310_c);

        for (int i = 0; i < 4; ++i)
        {
            func_73271_a(this.field_73308_d[i], p_73273_1_);
        }
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72487_a(this);
    }

    public int func_73284_a()
    {
        int i = 0;

        for (int j = 0; j < 4; ++j)
        {
            i += this.field_73308_d[j].length();
        }

        return i;
    }
}