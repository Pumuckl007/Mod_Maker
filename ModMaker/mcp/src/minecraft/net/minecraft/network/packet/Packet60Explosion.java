package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;

public class Packet60Explosion extends Packet
{
    public double field_73616_a;
    public double field_73614_b;
    public double field_73615_c;
    public float field_73612_d;
    public List field_73613_e;
    private float field_73610_f;
    private float field_73611_g;
    private float field_73617_h;

    public Packet60Explosion() {}

    public Packet60Explosion(double p_i1432_1_, double p_i1432_3_, double p_i1432_5_, float p_i1432_7_, List p_i1432_8_, Vec3 p_i1432_9_)
    {
        this.field_73616_a = p_i1432_1_;
        this.field_73614_b = p_i1432_3_;
        this.field_73615_c = p_i1432_5_;
        this.field_73612_d = p_i1432_7_;
        this.field_73613_e = new ArrayList(p_i1432_8_);

        if (p_i1432_9_ != null)
        {
            this.field_73610_f = (float)p_i1432_9_.field_72450_a;
            this.field_73611_g = (float)p_i1432_9_.field_72448_b;
            this.field_73617_h = (float)p_i1432_9_.field_72449_c;
        }
    }

    public void func_73267_a(DataInput p_73267_1_) throws IOException
    {
        this.field_73616_a = p_73267_1_.readDouble();
        this.field_73614_b = p_73267_1_.readDouble();
        this.field_73615_c = p_73267_1_.readDouble();
        this.field_73612_d = p_73267_1_.readFloat();
        int i = p_73267_1_.readInt();
        this.field_73613_e = new ArrayList(i);
        int j = (int)this.field_73616_a;
        int k = (int)this.field_73614_b;
        int l = (int)this.field_73615_c;

        for (int i1 = 0; i1 < i; ++i1)
        {
            int j1 = p_73267_1_.readByte() + j;
            int k1 = p_73267_1_.readByte() + k;
            int l1 = p_73267_1_.readByte() + l;
            this.field_73613_e.add(new ChunkPosition(j1, k1, l1));
        }

        this.field_73610_f = p_73267_1_.readFloat();
        this.field_73611_g = p_73267_1_.readFloat();
        this.field_73617_h = p_73267_1_.readFloat();
    }

    public void func_73273_a(DataOutput p_73273_1_) throws IOException
    {
        p_73273_1_.writeDouble(this.field_73616_a);
        p_73273_1_.writeDouble(this.field_73614_b);
        p_73273_1_.writeDouble(this.field_73615_c);
        p_73273_1_.writeFloat(this.field_73612_d);
        p_73273_1_.writeInt(this.field_73613_e.size());
        int i = (int)this.field_73616_a;
        int j = (int)this.field_73614_b;
        int k = (int)this.field_73615_c;
        Iterator iterator = this.field_73613_e.iterator();

        while (iterator.hasNext())
        {
            ChunkPosition chunkposition = (ChunkPosition)iterator.next();
            int l = chunkposition.field_76930_a - i;
            int i1 = chunkposition.field_76928_b - j;
            int j1 = chunkposition.field_76929_c - k;
            p_73273_1_.writeByte(l);
            p_73273_1_.writeByte(i1);
            p_73273_1_.writeByte(j1);
        }

        p_73273_1_.writeFloat(this.field_73610_f);
        p_73273_1_.writeFloat(this.field_73611_g);
        p_73273_1_.writeFloat(this.field_73617_h);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72499_a(this);
    }

    public int func_73284_a()
    {
        return 32 + this.field_73613_e.size() * 3 + 3;
    }

    @SideOnly(Side.CLIENT)
    public float func_73607_d()
    {
        return this.field_73610_f;
    }

    @SideOnly(Side.CLIENT)
    public float func_73609_f()
    {
        return this.field_73611_g;
    }

    @SideOnly(Side.CLIENT)
    public float func_73608_g()
    {
        return this.field_73617_h;
    }
}
