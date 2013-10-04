package net.minecraft.nbt;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NBTTagList extends NBTBase
{
    private List field_74747_a = new ArrayList();
    private byte field_74746_b;

    public NBTTagList()
    {
        super("");
    }

    public NBTTagList(String p_i1384_1_)
    {
        super(p_i1384_1_);
    }

    void func_74734_a(DataOutput p_74734_1_) throws IOException
    {
        if (!this.field_74747_a.isEmpty())
        {
            this.field_74746_b = ((NBTBase)this.field_74747_a.get(0)).func_74732_a();
        }
        else
        {
            this.field_74746_b = 1;
        }

        p_74734_1_.writeByte(this.field_74746_b);
        p_74734_1_.writeInt(this.field_74747_a.size());

        for (int i = 0; i < this.field_74747_a.size(); ++i)
        {
            ((NBTBase)this.field_74747_a.get(i)).func_74734_a(p_74734_1_);
        }
    }

    void func_74735_a(DataInput p_74735_1_, int p_74735_2_) throws IOException
    {
        if (p_74735_2_ > 512)
        {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        else
        {
            this.field_74746_b = p_74735_1_.readByte();
            int j = p_74735_1_.readInt();
            this.field_74747_a = new ArrayList();

            for (int k = 0; k < j; ++k)
            {
                NBTBase nbtbase = NBTBase.func_74733_a(this.field_74746_b, (String)null);
                nbtbase.func_74735_a(p_74735_1_, p_74735_2_ + 1);
                this.field_74747_a.add(nbtbase);
            }
        }
    }

    public byte func_74732_a()
    {
        return (byte)9;
    }

    public String toString()
    {
        return "" + this.field_74747_a.size() + " entries of type " + NBTBase.func_74736_a(this.field_74746_b);
    }

    public void func_74742_a(NBTBase p_74742_1_)
    {
        this.field_74746_b = p_74742_1_.func_74732_a();
        this.field_74747_a.add(p_74742_1_);
    }

    @SideOnly(Side.CLIENT)
    public NBTBase func_74744_a(int p_74744_1_)
    {
        return (NBTBase)this.field_74747_a.remove(p_74744_1_);
    }

    public NBTBase func_74743_b(int p_74743_1_)
    {
        return (NBTBase)this.field_74747_a.get(p_74743_1_);
    }

    public int func_74745_c()
    {
        return this.field_74747_a.size();
    }

    public NBTBase func_74737_b()
    {
        NBTTagList nbttaglist = new NBTTagList(this.func_74740_e());
        nbttaglist.field_74746_b = this.field_74746_b;
        Iterator iterator = this.field_74747_a.iterator();

        while (iterator.hasNext())
        {
            NBTBase nbtbase = (NBTBase)iterator.next();
            NBTBase nbtbase1 = nbtbase.func_74737_b();
            nbttaglist.field_74747_a.add(nbtbase1);
        }

        return nbttaglist;
    }

    public boolean equals(Object p_equals_1_)
    {
        if (super.equals(p_equals_1_))
        {
            NBTTagList nbttaglist = (NBTTagList)p_equals_1_;

            if (this.field_74746_b == nbttaglist.field_74746_b)
            {
                return this.field_74747_a.equals(nbttaglist.field_74747_a);
            }
        }

        return false;
    }

    public int hashCode()
    {
        return super.hashCode() ^ this.field_74747_a.hashCode();
    }
}
