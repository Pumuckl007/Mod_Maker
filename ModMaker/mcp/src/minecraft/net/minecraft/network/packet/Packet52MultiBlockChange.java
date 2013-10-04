package net.minecraft.network.packet;

import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class Packet52MultiBlockChange extends Packet
{
    public int field_73452_a;
    public int field_73450_b;
    public byte[] field_73451_c;
    public int field_73448_d;
    private static byte[] field_73449_e = new byte[0];

    public Packet52MultiBlockChange()
    {
        this.field_73287_r = true;
    }

    public Packet52MultiBlockChange(int p_i1414_1_, int p_i1414_2_, short[] p_i1414_3_, int p_i1414_4_, World p_i1414_5_)
    {
        this.field_73287_r = true;
        this.field_73452_a = p_i1414_1_;
        this.field_73450_b = p_i1414_2_;
        this.field_73448_d = p_i1414_4_;
        int l = 4 * p_i1414_4_;
        Chunk chunk = p_i1414_5_.func_72964_e(p_i1414_1_, p_i1414_2_);

        try
        {
            if (p_i1414_4_ >= 64)
            {
                this.field_98193_m.func_98233_a("ChunkTilesUpdatePacket compress " + p_i1414_4_);

                if (field_73449_e.length < l)
                {
                    field_73449_e = new byte[l];
                }
            }
            else
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(l);
                DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);

                for (int i1 = 0; i1 < p_i1414_4_; ++i1)
                {
                    int j1 = p_i1414_3_[i1] >> 12 & 15;
                    int k1 = p_i1414_3_[i1] >> 8 & 15;
                    int l1 = p_i1414_3_[i1] & 255;
                    dataoutputstream.writeShort(p_i1414_3_[i1]);
                    dataoutputstream.writeShort((short)((chunk.func_76610_a(j1, l1, k1) & 4095) << 4 | chunk.func_76628_c(j1, l1, k1) & 15));
                }

                this.field_73451_c = bytearrayoutputstream.toByteArray();

                if (this.field_73451_c.length != l)
                {
                    throw new RuntimeException("Expected length " + l + " doesn\'t match received length " + this.field_73451_c.length);
                }
            }
        }
        catch (IOException ioexception)
        {
            this.field_98193_m.func_98234_c("Couldn\'t create chunk packet", ioexception);
            this.field_73451_c = null;
        }
    }

    public void func_73267_a(DataInput p_73267_1_) throws IOException
    {
        this.field_73452_a = p_73267_1_.readInt();
        this.field_73450_b = p_73267_1_.readInt();
        this.field_73448_d = p_73267_1_.readShort() & 65535;
        int i = p_73267_1_.readInt();

        if (i > 0)
        {
            this.field_73451_c = new byte[i];
            p_73267_1_.readFully(this.field_73451_c);
        }
    }

    public void func_73273_a(DataOutput p_73273_1_) throws IOException
    {
        p_73273_1_.writeInt(this.field_73452_a);
        p_73273_1_.writeInt(this.field_73450_b);
        p_73273_1_.writeShort((short)this.field_73448_d);

        if (this.field_73451_c != null)
        {
            p_73273_1_.writeInt(this.field_73451_c.length);
            p_73273_1_.write(this.field_73451_c);
        }
        else
        {
            p_73273_1_.writeInt(0);
        }
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72496_a(this);
    }

    public int func_73284_a()
    {
        return 10 + this.field_73448_d * 4;
    }
}
