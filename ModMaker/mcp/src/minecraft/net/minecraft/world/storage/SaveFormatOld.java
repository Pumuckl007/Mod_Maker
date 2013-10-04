package net.minecraft.world.storage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IProgressUpdate;

public class SaveFormatOld implements ISaveFormat
{
    protected final File field_75808_a;

    public SaveFormatOld(File p_i2147_1_)
    {
        if (!p_i2147_1_.exists())
        {
            p_i2147_1_.mkdirs();
        }

        this.field_75808_a = p_i2147_1_;
    }

    @SideOnly(Side.CLIENT)
    public List func_75799_b() throws AnvilConverterException
    {
        ArrayList arraylist = new ArrayList();

        for (int i = 0; i < 5; ++i)
        {
            String s = "World" + (i + 1);
            WorldInfo worldinfo = this.func_75803_c(s);

            if (worldinfo != null)
            {
                arraylist.add(new SaveFormatComparator(s, "", worldinfo.func_76057_l(), worldinfo.func_76092_g(), worldinfo.func_76077_q(), false, worldinfo.func_76093_s(), worldinfo.func_76086_u()));
            }
        }

        return arraylist;
    }

    public void func_75800_d() {}

    public WorldInfo func_75803_c(String p_75803_1_)
    {
        File file1 = new File(this.field_75808_a, p_75803_1_);

        if (!file1.exists())
        {
            return null;
        }
        else
        {
            File file2 = new File(file1, "level.dat");
            NBTTagCompound nbttagcompound;
            NBTTagCompound nbttagcompound1;

            if (file2.exists())
            {
                try
                {
                    nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file2));
                    nbttagcompound1 = nbttagcompound.func_74775_l("Data");
                    return new WorldInfo(nbttagcompound1);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }

            file2 = new File(file1, "level.dat_old");

            if (file2.exists())
            {
                try
                {
                    nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file2));
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
    }

    @SideOnly(Side.CLIENT)
    public void func_75806_a(String p_75806_1_, String p_75806_2_)
    {
        File file1 = new File(this.field_75808_a, p_75806_1_);

        if (file1.exists())
        {
            File file2 = new File(file1, "level.dat");

            if (file2.exists())
            {
                try
                {
                    NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file2));
                    NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l("Data");
                    nbttagcompound1.func_74778_a("LevelName", p_75806_2_);
                    CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file2));
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }
    }

    public boolean func_75802_e(String p_75802_1_)
    {
        File file1 = new File(this.field_75808_a, p_75802_1_);

        if (!file1.exists())
        {
            return true;
        }
        else
        {
            System.out.println("Deleting level " + p_75802_1_);

            for (int i = 1; i <= 5; ++i)
            {
                System.out.println("Attempt " + i + "...");

                if (func_75807_a(file1.listFiles()))
                {
                    break;
                }

                System.out.println("Unsuccessful in deleting contents.");

                if (i < 5)
                {
                    try
                    {
                        Thread.sleep(500L);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        ;
                    }
                }
            }

            return file1.delete();
        }
    }

    protected static boolean func_75807_a(File[] p_75807_0_)
    {
        for (int i = 0; i < p_75807_0_.length; ++i)
        {
            File file1 = p_75807_0_[i];
            System.out.println("Deleting " + file1);

            if (file1.isDirectory() && !func_75807_a(file1.listFiles()))
            {
                System.out.println("Couldn\'t delete directory " + file1);
                return false;
            }

            if (!file1.delete())
            {
                System.out.println("Couldn\'t delete file " + file1);
                return false;
            }
        }

        return true;
    }

    public ISaveHandler func_75804_a(String p_75804_1_, boolean p_75804_2_)
    {
        return new SaveHandler(this.field_75808_a, p_75804_1_, p_75804_2_);
    }

    public boolean func_75801_b(String p_75801_1_)
    {
        return false;
    }

    public boolean func_75805_a(String p_75805_1_, IProgressUpdate p_75805_2_)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_90033_f(String p_90033_1_)
    {
        File file1 = new File(this.field_75808_a, p_90033_1_);
        return file1.isDirectory();
    }
}
