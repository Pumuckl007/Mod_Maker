package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import net.minecraft.util.Session;

@SideOnly(Side.CLIENT)
public class StatsSyncher
{
    private volatile boolean field_77432_a;
    private volatile Map field_77430_b;
    private volatile Map field_77431_c;
    private StatFileWriter field_77428_d;
    private File field_77429_e;
    private File field_77426_f;
    private File field_77427_g;
    private File field_77437_h;
    private File field_77438_i;
    private File field_77435_j;
    private Session field_77436_k;
    private int field_77433_l;
    private int field_77434_m;

    public StatsSyncher(Session p_i1335_1_, StatFileWriter p_i1335_2_, File p_i1335_3_)
    {
        String s = p_i1335_1_.func_111285_a();
        String s1 = s.toLowerCase();
        this.field_77429_e = new File(p_i1335_3_, "stats_" + s1 + "_unsent.dat");
        this.field_77426_f = new File(p_i1335_3_, "stats_" + s1 + ".dat");
        this.field_77438_i = new File(p_i1335_3_, "stats_" + s1 + "_unsent.old");
        this.field_77435_j = new File(p_i1335_3_, "stats_" + s1 + ".old");
        this.field_77427_g = new File(p_i1335_3_, "stats_" + s1 + "_unsent.tmp");
        this.field_77437_h = new File(p_i1335_3_, "stats_" + s1 + ".tmp");

        if (!s1.equals(s))
        {
            this.func_77412_a(p_i1335_3_, "stats_" + s + "_unsent.dat", this.field_77429_e);
            this.func_77412_a(p_i1335_3_, "stats_" + s + ".dat", this.field_77426_f);
            this.func_77412_a(p_i1335_3_, "stats_" + s + "_unsent.old", this.field_77438_i);
            this.func_77412_a(p_i1335_3_, "stats_" + s + ".old", this.field_77435_j);
            this.func_77412_a(p_i1335_3_, "stats_" + s + "_unsent.tmp", this.field_77427_g);
            this.func_77412_a(p_i1335_3_, "stats_" + s + ".tmp", this.field_77437_h);
        }

        this.field_77428_d = p_i1335_2_;
        this.field_77436_k = p_i1335_1_;

        if (this.field_77429_e.exists())
        {
            p_i1335_2_.func_77447_a(this.func_77417_a(this.field_77429_e, this.field_77427_g, this.field_77438_i));
        }

        this.func_77423_b();
    }

    private void func_77412_a(File p_77412_1_, String p_77412_2_, File p_77412_3_)
    {
        File file3 = new File(p_77412_1_, p_77412_2_);

        if (file3.exists() && !file3.isDirectory() && !p_77412_3_.exists())
        {
            file3.renameTo(p_77412_3_);
        }
    }

    private Map func_77417_a(File p_77417_1_, File p_77417_2_, File p_77417_3_)
    {
        return p_77417_1_.exists() ? this.func_77413_a(p_77417_1_) : (p_77417_3_.exists() ? this.func_77413_a(p_77417_3_) : (p_77417_2_.exists() ? this.func_77413_a(p_77417_2_) : null));
    }

    private Map func_77413_a(File p_77413_1_)
    {
        BufferedReader bufferedreader = null;

        try
        {
            bufferedreader = new BufferedReader(new FileReader(p_77413_1_));
            String s = "";
            StringBuilder stringbuilder = new StringBuilder();

            while ((s = bufferedreader.readLine()) != null)
            {
                stringbuilder.append(s);
            }

            Map map = StatFileWriter.func_77453_b(stringbuilder.toString());
            return map;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            if (bufferedreader != null)
            {
                try
                {
                    bufferedreader.close();
                }
                catch (Exception exception1)
                {
                    exception1.printStackTrace();
                }
            }
        }

        return null;
    }

    private void func_77421_a(Map p_77421_1_, File p_77421_2_, File p_77421_3_, File p_77421_4_) throws IOException
    {
        PrintWriter printwriter = new PrintWriter(new FileWriter(p_77421_3_, false));

        try
        {
            printwriter.print(StatFileWriter.func_77441_a(this.field_77436_k.func_111285_a(), "local", p_77421_1_));
        }
        finally
        {
            printwriter.close();
        }

        if (p_77421_4_.exists())
        {
            p_77421_4_.delete();
        }

        if (p_77421_2_.exists())
        {
            p_77421_2_.renameTo(p_77421_4_);
        }

        p_77421_3_.renameTo(p_77421_2_);
    }

    public void func_77423_b()
    {
        if (this.field_77432_a)
        {
            throw new IllegalStateException("Can\'t get stats from server while StatsSyncher is busy!");
        }
        else
        {
            this.field_77433_l = 100;
            this.field_77432_a = true;
            (new ThreadStatSyncherReceive(this)).start();
        }
    }

    public void func_77418_a(Map p_77418_1_)
    {
        if (this.field_77432_a)
        {
            throw new IllegalStateException("Can\'t save stats while StatsSyncher is busy!");
        }
        else
        {
            this.field_77433_l = 100;
            this.field_77432_a = true;
            (new ThreadStatSyncherSend(this, p_77418_1_)).start();
        }
    }

    public void func_77420_c(Map p_77420_1_)
    {
        int i = 30;

        while (this.field_77432_a)
        {
            --i;

            if (i <= 0)
            {
                break;
            }

            try
            {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }

        this.field_77432_a = true;

        try
        {
            this.func_77421_a(p_77420_1_, this.field_77429_e, this.field_77427_g, this.field_77438_i);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            this.field_77432_a = false;
        }
    }

    public boolean func_77425_c()
    {
        return this.field_77433_l <= 0 && !this.field_77432_a && this.field_77431_c == null;
    }

    public void func_77422_e()
    {
        if (this.field_77433_l > 0)
        {
            --this.field_77433_l;
        }

        if (this.field_77434_m > 0)
        {
            --this.field_77434_m;
        }

        if (this.field_77431_c != null)
        {
            this.field_77428_d.func_77448_c(this.field_77431_c);
            this.field_77431_c = null;
        }

        if (this.field_77430_b != null)
        {
            this.field_77428_d.func_77452_b(this.field_77430_b);
            this.field_77430_b = null;
        }
    }

    static Map func_77419_a(StatsSyncher p_77419_0_)
    {
        return p_77419_0_.field_77430_b;
    }

    static File func_77408_b(StatsSyncher p_77408_0_)
    {
        return p_77408_0_.field_77426_f;
    }

    static File func_77407_c(StatsSyncher p_77407_0_)
    {
        return p_77407_0_.field_77437_h;
    }

    static File func_77411_d(StatsSyncher p_77411_0_)
    {
        return p_77411_0_.field_77435_j;
    }

    static void func_77414_a(StatsSyncher p_77414_0_, Map p_77414_1_, File p_77414_2_, File p_77414_3_, File p_77414_4_) throws IOException
    {
        p_77414_0_.func_77421_a(p_77414_1_, p_77414_2_, p_77414_3_, p_77414_4_);
    }

    static Map func_77416_a(StatsSyncher p_77416_0_, Map p_77416_1_)
    {
        return p_77416_0_.field_77430_b = p_77416_1_;
    }

    static Map func_77410_a(StatsSyncher p_77410_0_, File p_77410_1_, File p_77410_2_, File p_77410_3_)
    {
        return p_77410_0_.func_77417_a(p_77410_1_, p_77410_2_, p_77410_3_);
    }

    static boolean func_77406_a(StatsSyncher p_77406_0_, boolean p_77406_1_)
    {
        return p_77406_0_.field_77432_a = p_77406_1_;
    }

    static File func_77409_e(StatsSyncher p_77409_0_)
    {
        return p_77409_0_.field_77429_e;
    }

    static File func_77415_f(StatsSyncher p_77415_0_)
    {
        return p_77415_0_.field_77427_g;
    }

    static File func_77424_g(StatsSyncher p_77424_0_)
    {
        return p_77424_0_.field_77438_i;
    }
}