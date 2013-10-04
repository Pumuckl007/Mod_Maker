package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.AttributeModifier;

public class Packet44UpdateAttributes extends Packet
{
    private int field_111005_a;
    private final List field_111004_b = new ArrayList();

    public Packet44UpdateAttributes() {}

    public Packet44UpdateAttributes(int p_i1486_1_, Collection p_i1486_2_)
    {
        this.field_111005_a = p_i1486_1_;
        Iterator iterator = p_i1486_2_.iterator();

        while (iterator.hasNext())
        {
            AttributeInstance attributeinstance = (AttributeInstance)iterator.next();
            this.field_111004_b.add(new Packet44UpdateAttributesSnapshot(this, attributeinstance.func_111123_a().func_111108_a(), attributeinstance.func_111125_b(), attributeinstance.func_111122_c()));
        }
    }

    public void func_73267_a(DataInput p_73267_1_) throws IOException
    {
        this.field_111005_a = p_73267_1_.readInt();
        int i = p_73267_1_.readInt();

        for (int j = 0; j < i; ++j)
        {
            String s = func_73282_a(p_73267_1_, 64);
            double d0 = p_73267_1_.readDouble();
            ArrayList arraylist = new ArrayList();
            short short1 = p_73267_1_.readShort();

            for (int k = 0; k < short1; ++k)
            {
                UUID uuid = new UUID(p_73267_1_.readLong(), p_73267_1_.readLong());
                arraylist.add(new AttributeModifier(uuid, "Unknown synced attribute modifier", p_73267_1_.readDouble(), p_73267_1_.readByte()));
            }

            this.field_111004_b.add(new Packet44UpdateAttributesSnapshot(this, s, d0, arraylist));
        }
    }

    public void func_73273_a(DataOutput p_73273_1_) throws IOException
    {
        p_73273_1_.writeInt(this.field_111005_a);
        p_73273_1_.writeInt(this.field_111004_b.size());
        Iterator iterator = this.field_111004_b.iterator();

        while (iterator.hasNext())
        {
            Packet44UpdateAttributesSnapshot packet44updateattributessnapshot = (Packet44UpdateAttributesSnapshot)iterator.next();
            func_73271_a(packet44updateattributessnapshot.func_142040_a(), p_73273_1_);
            p_73273_1_.writeDouble(packet44updateattributessnapshot.func_142041_b());
            p_73273_1_.writeShort(packet44updateattributessnapshot.func_142039_c().size());
            Iterator iterator1 = packet44updateattributessnapshot.func_142039_c().iterator();

            while (iterator1.hasNext())
            {
                AttributeModifier attributemodifier = (AttributeModifier)iterator1.next();
                p_73273_1_.writeLong(attributemodifier.func_111167_a().getMostSignificantBits());
                p_73273_1_.writeLong(attributemodifier.func_111167_a().getLeastSignificantBits());
                p_73273_1_.writeDouble(attributemodifier.func_111164_d());
                p_73273_1_.writeByte(attributemodifier.func_111169_c());
            }
        }
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_110773_a(this);
    }

    public int func_73284_a()
    {
        return 8 + this.field_111004_b.size() * 24;
    }

    @SideOnly(Side.CLIENT)
    public int func_111002_d()
    {
        return this.field_111005_a;
    }

    @SideOnly(Side.CLIENT)
    public List func_111003_f()
    {
        return this.field_111004_b;
    }
}
