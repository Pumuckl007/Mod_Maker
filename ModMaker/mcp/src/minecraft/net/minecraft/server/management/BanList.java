package net.minecraft.server.management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.server.MinecraftServer;

public class BanList
{
    private final LowerStringMap field_73715_a = new LowerStringMap();
    private final File field_73713_b;
    private boolean field_73714_c = true;

    public BanList(File p_i1490_1_)
    {
        this.field_73713_b = p_i1490_1_;
    }

    public boolean func_73710_b()
    {
        return this.field_73714_c;
    }

    public void func_73708_a(boolean p_73708_1_)
    {
        this.field_73714_c = p_73708_1_;
    }

    public Map func_73712_c()
    {
        this.func_73705_d();
        return this.field_73715_a;
    }

    public boolean func_73704_a(String p_73704_1_)
    {
        if (!this.func_73710_b())
        {
            return false;
        }
        else
        {
            this.func_73705_d();
            return this.field_73715_a.containsKey(p_73704_1_);
        }
    }

    public void func_73706_a(BanEntry p_73706_1_)
    {
        this.field_73715_a.func_76116_a(p_73706_1_.func_73684_a(), p_73706_1_);
        this.func_73711_f();
    }

    public void func_73709_b(String p_73709_1_)
    {
        this.field_73715_a.remove(p_73709_1_);
        this.func_73711_f();
    }

    public void func_73705_d()
    {
        Iterator iterator = this.field_73715_a.values().iterator();

        while (iterator.hasNext())
        {
            BanEntry banentry = (BanEntry)iterator.next();

            if (banentry.func_73682_e())
            {
                iterator.remove();
            }
        }
    }

    public void func_73707_e()
    {
        if (this.field_73713_b.isFile())
        {
            BufferedReader bufferedreader;

            try
            {
                bufferedreader = new BufferedReader(new FileReader(this.field_73713_b));
            }
            catch (FileNotFoundException filenotfoundexception)
            {
                throw new Error();
            }

            String s;

            try
            {
                while ((s = bufferedreader.readLine()) != null)
                {
                    if (!s.startsWith("#"))
                    {
                        BanEntry banentry = BanEntry.func_73688_c(s);

                        if (banentry != null)
                        {
                            this.field_73715_a.func_76116_a(banentry.func_73684_a(), banentry);
                        }
                    }
                }
            }
            catch (IOException ioexception)
            {
                MinecraftServer.func_71276_C().func_98033_al().func_98234_c("Could not load ban list", ioexception);
            }
        }
    }

    public void func_73711_f()
    {
        this.func_73703_b(true);
    }

    public void func_73703_b(boolean p_73703_1_)
    {
        this.func_73705_d();

        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(this.field_73713_b, false));

            if (p_73703_1_)
            {
                printwriter.println("# Updated " + (new SimpleDateFormat()).format(new Date()) + " by Minecraft " + "1.6.4");
                printwriter.println("# victim name | ban date | banned by | banned until | reason");
                printwriter.println();
            }

            Iterator iterator = this.field_73715_a.values().iterator();

            while (iterator.hasNext())
            {
                BanEntry banentry = (BanEntry)iterator.next();
                printwriter.println(banentry.func_73685_g());
            }

            printwriter.close();
        }
        catch (IOException ioexception)
        {
            MinecraftServer.func_71276_C().func_98033_al().func_98234_c("Could not save ban list", ioexception);
        }
    }
}
