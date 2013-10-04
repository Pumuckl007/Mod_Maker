package net.minecraft.network.packet;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import net.minecraft.item.ItemStack;

public class Packet104WindowItems extends Packet
{
    public int field_73427_a;
    public ItemStack[] field_73426_b;

    public Packet104WindowItems() {}

    public Packet104WindowItems(int p_i1425_1_, List p_i1425_2_)
    {
        this.field_73427_a = p_i1425_1_;
        this.field_73426_b = new ItemStack[p_i1425_2_.size()];

        for (int j = 0; j < this.field_73426_b.length; ++j)
        {
            ItemStack itemstack = (ItemStack)p_i1425_2_.get(j);
            this.field_73426_b[j] = itemstack == null ? null : itemstack.func_77946_l();
        }
    }

    public void func_73267_a(DataInput p_73267_1_) throws IOException
    {
        this.field_73427_a = p_73267_1_.readByte();
        short short1 = p_73267_1_.readShort();
        this.field_73426_b = new ItemStack[short1];

        for (int i = 0; i < short1; ++i)
        {
            this.field_73426_b[i] = func_73276_c(p_73267_1_);
        }
    }

    public void func_73273_a(DataOutput p_73273_1_) throws IOException
    {
        p_73273_1_.writeByte(this.field_73427_a);
        p_73273_1_.writeShort(this.field_73426_b.length);

        for (int i = 0; i < this.field_73426_b.length; ++i)
        {
            func_73270_a(this.field_73426_b[i], p_73273_1_);
        }
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72486_a(this);
    }

    public int func_73284_a()
    {
        return 3 + this.field_73426_b.length * 5;
    }
}
