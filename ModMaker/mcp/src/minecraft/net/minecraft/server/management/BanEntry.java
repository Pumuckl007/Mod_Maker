package net.minecraft.server.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import net.minecraft.server.MinecraftServer;

public class BanEntry
{
    public static final SimpleDateFormat field_73698_a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    private final String field_73697_c;
    private Date field_73694_d = new Date();
    private String field_73695_e = "(Unknown)";
    private Date field_73692_f;
    private String field_73693_g = "Banned by an operator.";

    public BanEntry(String p_i1489_1_)
    {
        this.field_73697_c = p_i1489_1_;
    }

    public String func_73684_a()
    {
        return this.field_73697_c;
    }

    public Date func_73683_b()
    {
        return this.field_73694_d;
    }

    public void func_73681_a(Date p_73681_1_)
    {
        this.field_73694_d = p_73681_1_ != null ? p_73681_1_ : new Date();
    }

    public String func_73690_c()
    {
        return this.field_73695_e;
    }

    public void func_73687_a(String p_73687_1_)
    {
        this.field_73695_e = p_73687_1_;
    }

    public Date func_73680_d()
    {
        return this.field_73692_f;
    }

    public void func_73691_b(Date p_73691_1_)
    {
        this.field_73692_f = p_73691_1_;
    }

    public boolean func_73682_e()
    {
        return this.field_73692_f == null ? false : this.field_73692_f.before(new Date());
    }

    public String func_73686_f()
    {
        return this.field_73693_g;
    }

    public void func_73689_b(String p_73689_1_)
    {
        this.field_73693_g = p_73689_1_;
    }

    public String func_73685_g()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(this.func_73684_a());
        stringbuilder.append("|");
        stringbuilder.append(field_73698_a.format(this.func_73683_b()));
        stringbuilder.append("|");
        stringbuilder.append(this.func_73690_c());
        stringbuilder.append("|");
        stringbuilder.append(this.func_73680_d() == null ? "Forever" : field_73698_a.format(this.func_73680_d()));
        stringbuilder.append("|");
        stringbuilder.append(this.func_73686_f());
        return stringbuilder.toString();
    }

    public static BanEntry func_73688_c(String p_73688_0_)
    {
        if (p_73688_0_.trim().length() < 2)
        {
            return null;
        }
        else
        {
            String[] astring = p_73688_0_.trim().split(Pattern.quote("|"), 5);
            BanEntry banentry = new BanEntry(astring[0].trim());
            byte b0 = 0;
            int i = astring.length;
            int j = b0 + 1;

            if (i <= j)
            {
                return banentry;
            }
            else
            {
                try
                {
                    banentry.func_73681_a(field_73698_a.parse(astring[j].trim()));
                }
                catch (ParseException parseexception)
                {
                    MinecraftServer.func_71276_C().func_98033_al().func_98235_b("Could not read creation date format for ban entry \'" + banentry.func_73684_a() + "\' (was: \'" + astring[j] + "\')", parseexception);
                }

                i = astring.length;
                ++j;

                if (i <= j)
                {
                    return banentry;
                }
                else
                {
                    banentry.func_73687_a(astring[j].trim());
                    i = astring.length;
                    ++j;

                    if (i <= j)
                    {
                        return banentry;
                    }
                    else
                    {
                        try
                        {
                            String s1 = astring[j].trim();

                            if (!s1.equalsIgnoreCase("Forever") && s1.length() > 0)
                            {
                                banentry.func_73691_b(field_73698_a.parse(s1));
                            }
                        }
                        catch (ParseException parseexception1)
                        {
                            MinecraftServer.func_71276_C().func_98033_al().func_98235_b("Could not read expiry date format for ban entry \'" + banentry.func_73684_a() + "\' (was: \'" + astring[j] + "\')", parseexception1);
                        }

                        i = astring.length;
                        ++j;

                        if (i <= j)
                        {
                            return banentry;
                        }
                        else
                        {
                            banentry.func_73689_b(astring[j].trim());
                            return banentry;
                        }
                    }
                }
            }
        }
    }
}
