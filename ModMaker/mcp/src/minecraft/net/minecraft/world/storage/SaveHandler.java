package net.minecraft.world.storage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;

public class SaveHandler implements ISaveHandler, IPlayerFileData
{
    private final File field_75770_b;
    private final File field_75771_c;
    private final File field_75768_d;
    private final long field_75769_e = MinecraftServer.func_130071_aq();
    private final String field_75767_f;

    public SaveHandler(File p_i2146_1_, String p_i2146_2_, boolean p_i2146_3_)
    {
        this.field_75770_b = new File(p_i2146_1_, p_i2146_2_);
        this.field_75770_b.mkdirs();
        this.field_75771_c = new File(this.field_75770_b, "players");
        this.field_75768_d = new File(this.field_75770_b, "data");
        this.field_75768_d.mkdirs();
        this.field_75767_f = p_i2146_2_;

        if (p_i2146_3_)
        {
            this.field_75771_c.mkdirs();
        }

        this.func_75766_h();
    }

    private void func_75766_h()
    {
        try
        {
            File file1 = new File(this.field_75770_b, "session.lock");
            DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file1));

            try
            {
                dataoutputstream.writeLong(this.field_75769_e);
            }
            finally
            {
                dataoutputstream.close();
            }
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
    }

    public File func_75765_b()
    {
        return this.field_75770_b;
    }

    public void func_75762_c() throws MinecraftException
    {
        try
        {
            File file1 = new File(this.field_75770_b, "session.lock");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file1));

            try
            {
                if (datainputstream.readLong() != this.field_75769_e)
                {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            }
            finally
            {
                datainputstream.close();
            }
        }
        catch (IOException ioexception)
        {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }

    public IChunkLoader func_75763_a(WorldProvider p_75763_1_)
    {
        throw new RuntimeException("Old Chunk Storage is no longer supported.");
    }

    public WorldInfo func_75757_d()
    {
        File file1 = new File(this.field_75770_b, "level.dat");
        NBTTagCompound nbttagcompound;
        NBTTagCompound nbttagcompound1;

        if (file1.exists())
        {
            try
            {
                nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file1));
                nbttagcompound1 = nbttagcompound.func_74775_l("Data");
                return new WorldInfo(nbttagcompound1);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        file1 = new File(this.field_75770_b, "level.dat_old");

        if (file1.exists())
        {
            try
            {
                nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file1));
                nbttagcompound1 = nbttagcompound.func_74775_l("Data");
                return new WorldInfo(nbttagcompound1);
            }
            catch (Exception exception1)
            {
                exception1.printStackTrace();
            }
        }

        return null;
    }

    public void func_75755_a(WorldInfo p_75755_1_, NBTTagCompound p_75755_2_)
    {
        NBTTagCompound nbttagcompound1 = p_75755_1_.func_76082_a(p_75755_2_);
        NBTTagCompound nbttagcompound2 = new NBTTagCompound();
        nbttagcompound2.func_74782_a("Data", nbttagcompound1);

        try
        {
            File file1 = new File(this.field_75770_b, "level.dat_new");
            File file2 = new File(this.field_75770_b, "level.dat_old");
            File file3 = new File(this.field_75770_b, "level.dat");
            CompressedStreamTools.func_74799_a(nbttagcompound2, new FileOutputStream(file1));

            if (file2.exists())
            {
                file2.delete();
            }

            file3.renameTo(file2);

            if (file3.exists())
            {
                file3.delete();
            }

            file1.renameTo(file3);

            if (file1.exists())
            {
                file1.delete();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void func_75761_a(WorldInfo p_75761_1_)
    {
        NBTTagCompound nbttagcompound = p_75761_1_.func_76066_a();
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.func_74782_a("Data", nbttagcompound);

        try
        {
            File file1 = new File(this.field_75770_b, "level.dat_new");
            File file2 = new File(this.field_75770_b, "level.dat_old");
            File file3 = new File(this.field_75770_b, "level.dat");
            CompressedStreamTools.func_74799_a(nbttagcompound1, new FileOutputStream(file1));

            if (file2.exists())
            {
                file2.delete();
            }

            file3.renameTo(file2);

            if (file3.exists())
            {
                file3.delete();
            }

            file1.renameTo(file3);

            if (file1.exists())
            {
                file1.delete();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void func_75753_a(EntityPlayer p_75753_1_)
    {
        try
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            p_75753_1_.func_70109_d(nbttagcompound);
            File file1 = new File(this.field_75771_c, p_75753_1_.func_70005_c_() + ".dat.tmp");
            File file2 = new File(this.field_75771_c, p_75753_1_.func_70005_c_() + ".dat");
            CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file1));

            if (file2.exists())
            {
                file2.delete();
            }

            file1.renameTo(file2);
        }
        catch (Exception exception)
        {
            MinecraftServer.func_71276_C().func_98033_al().func_98236_b("Failed to save player data for " + p_75753_1_.func_70005_c_());
        }
    }

    public NBTTagCompound func_75752_b(EntityPlayer p_75752_1_)
    {
        NBTTagCompound nbttagcompound = this.func_75764_a(p_75752_1_.func_70005_c_());

        if (nbttagcompound != null)
        {
            p_75752_1_.func_70020_e(nbttagcompound);
        }

        return nbttagcompound;
    }

    public NBTTagCompound func_75764_a(String p_75764_1_)
    {
        try
        {
            File file1 = new File(this.field_75771_c, p_75764_1_ + ".dat");

            if (file1.exists())
            {
                return CompressedStreamTools.func_74796_a(new FileInputStream(file1));
            }
        }
        catch (Exception exception)
        {
            MinecraftServer.func_71276_C().func_98033_al().func_98236_b("Failed to load player data for " + p_75764_1_);
        }

        return null;
    }

    public IPlayerFileData func_75756_e()
    {
        return this;
    }

    public String[] func_75754_f()
    {
        String[] astring = this.field_75771_c.list();

        for (int i = 0; i < astring.length; ++i)
        {
            if (astring[i].endsWith(".dat"))
            {
                astring[i] = astring[i].substring(0, astring[i].length() - 4);
            }
        }

        return astring;
    }

    public void func_75759_a() {}

    public File func_75758_b(String p_75758_1_)
    {
        return new File(this.field_75768_d, p_75758_1_ + ".dat");
    }

    public String func_75760_g()
    {
        return this.field_75767_f;
    }
}