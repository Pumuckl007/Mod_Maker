package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

@SideOnly(Side.CLIENT)
public class ServerList
{
    private final Minecraft field_78859_a;
    private final List field_78858_b = new ArrayList();

    public ServerList(Minecraft p_i1194_1_)
    {
        this.field_78859_a = p_i1194_1_;
        this.func_78853_a();
    }

    public void func_78853_a()
    {
        try
        {
            this.field_78858_b.clear();
            NBTTagCompound nbttagcompound = CompressedStreamTools.func_74797_a(new File(this.field_78859_a.field_71412_D, "servers.dat"));

            if (nbttagcompound == null)
            {
                return;
            }

            NBTTagList nbttaglist = nbttagcompound.func_74761_m("servers");

            for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
            {
                this.field_78858_b.add(ServerData.func_78837_a((NBTTagCompound)nbttaglist.func_74743_b(i)));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void func_78855_b()
    {
        try
        {
            NBTTagList nbttaglist = new NBTTagList();
            Iterator iterator = this.field_78858_b.iterator();

            while (iterator.hasNext())
            {
                ServerData serverdata = (ServerData)iterator.next();
                nbttaglist.func_74742_a(serverdata.func_78836_a());
            }

            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.func_74782_a("servers", nbttaglist);
            CompressedStreamTools.func_74793_a(nbttagcompound, new File(this.field_78859_a.field_71412_D, "servers.dat"));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public ServerData func_78850_a(int p_78850_1_)
    {
        return (ServerData)this.field_78858_b.get(p_78850_1_);
    }

    public void func_78851_b(int p_78851_1_)
    {
        this.field_78858_b.remove(p_78851_1_);
    }

    public void func_78849_a(ServerData p_78849_1_)
    {
        this.field_78858_b.add(p_78849_1_);
    }

    public int func_78856_c()
    {
        return this.field_78858_b.size();
    }

    public void func_78857_a(int p_78857_1_, int p_78857_2_)
    {
        ServerData serverdata = this.func_78850_a(p_78857_1_);
        this.field_78858_b.set(p_78857_1_, this.func_78850_a(p_78857_2_));
        this.field_78858_b.set(p_78857_2_, serverdata);
        this.func_78855_b();
    }
}
