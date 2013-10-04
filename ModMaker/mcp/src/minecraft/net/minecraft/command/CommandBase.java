package net.minecraft.command;

import com.google.common.primitives.Doubles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public abstract class CommandBase implements ICommand
{
    private static IAdminCommand field_71533_a;

    public int func_82362_a()
    {
        return 4;
    }

    public List func_71514_a()
    {
        return null;
    }

    public boolean func_71519_b(ICommandSender p_71519_1_)
    {
        return p_71519_1_.func_70003_b(this.func_82362_a(), this.func_71517_b());
    }

    public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        return null;
    }

    public static int func_71526_a(ICommandSender p_71526_0_, String p_71526_1_)
    {
        try
        {
            return Integer.parseInt(p_71526_1_);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] {p_71526_1_});
        }
    }

    public static int func_71528_a(ICommandSender p_71528_0_, String p_71528_1_, int p_71528_2_)
    {
        return func_71532_a(p_71528_0_, p_71528_1_, p_71528_2_, Integer.MAX_VALUE);
    }

    public static int func_71532_a(ICommandSender p_71532_0_, String p_71532_1_, int p_71532_2_, int p_71532_3_)
    {
        int k = func_71526_a(p_71532_0_, p_71532_1_);

        if (k < p_71532_2_)
        {
            throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] {Integer.valueOf(k), Integer.valueOf(p_71532_2_)});
        }
        else if (k > p_71532_3_)
        {
            throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] {Integer.valueOf(k), Integer.valueOf(p_71532_3_)});
        }
        else
        {
            return k;
        }
    }

    public static double func_82363_b(ICommandSender p_82363_0_, String p_82363_1_)
    {
        try
        {
            double d0 = Double.parseDouble(p_82363_1_);

            if (!Doubles.isFinite(d0))
            {
                throw new NumberInvalidException("commands.generic.double.invalid", new Object[] {p_82363_1_});
            }
            else
            {
                return d0;
            }
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new NumberInvalidException("commands.generic.double.invalid", new Object[] {p_82363_1_});
        }
    }

    public static double func_110664_a(ICommandSender p_110664_0_, String p_110664_1_, double p_110664_2_)
    {
        return func_110661_a(p_110664_0_, p_110664_1_, p_110664_2_, Double.MAX_VALUE);
    }

    public static double func_110661_a(ICommandSender p_110661_0_, String p_110661_1_, double p_110661_2_, double p_110661_4_)
    {
        double d2 = func_82363_b(p_110661_0_, p_110661_1_);

        if (d2 < p_110661_2_)
        {
            throw new NumberInvalidException("commands.generic.double.tooSmall", new Object[] {Double.valueOf(d2), Double.valueOf(p_110661_2_)});
        }
        else if (d2 > p_110661_4_)
        {
            throw new NumberInvalidException("commands.generic.double.tooBig", new Object[] {Double.valueOf(d2), Double.valueOf(p_110661_4_)});
        }
        else
        {
            return d2;
        }
    }

    public static boolean func_110662_c(ICommandSender p_110662_0_, String p_110662_1_)
    {
        if (!p_110662_1_.equals("true") && !p_110662_1_.equals("1"))
        {
            if (!p_110662_1_.equals("false") && !p_110662_1_.equals("0"))
            {
                throw new CommandException("commands.generic.boolean.invalid", new Object[] {p_110662_1_});
            }
            else
            {
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    public static EntityPlayerMP func_71521_c(ICommandSender p_71521_0_)
    {
        if (p_71521_0_ instanceof EntityPlayerMP)
        {
            return (EntityPlayerMP)p_71521_0_;
        }
        else
        {
            throw new PlayerNotFoundException("You must specify which player you wish to perform this action on.", new Object[0]);
        }
    }

    public static EntityPlayerMP func_82359_c(ICommandSender p_82359_0_, String p_82359_1_)
    {
        EntityPlayerMP entityplayermp = PlayerSelector.func_82386_a(p_82359_0_, p_82359_1_);

        if (entityplayermp != null)
        {
            return entityplayermp;
        }
        else
        {
            entityplayermp = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_82359_1_);

            if (entityplayermp == null)
            {
                throw new PlayerNotFoundException();
            }
            else
            {
                return entityplayermp;
            }
        }
    }

    public static String func_96332_d(ICommandSender p_96332_0_, String p_96332_1_)
    {
        EntityPlayerMP entityplayermp = PlayerSelector.func_82386_a(p_96332_0_, p_96332_1_);

        if (entityplayermp != null)
        {
            return entityplayermp.func_70023_ak();
        }
        else if (PlayerSelector.func_82378_b(p_96332_1_))
        {
            throw new PlayerNotFoundException();
        }
        else
        {
            return p_96332_1_;
        }
    }

    public static String func_82360_a(ICommandSender p_82360_0_, String[] p_82360_1_, int p_82360_2_)
    {
        return func_82361_a(p_82360_0_, p_82360_1_, p_82360_2_, false);
    }

    public static String func_82361_a(ICommandSender p_82361_0_, String[] p_82361_1_, int p_82361_2_, boolean p_82361_3_)
    {
        StringBuilder stringbuilder = new StringBuilder();

        for (int j = p_82361_2_; j < p_82361_1_.length; ++j)
        {
            if (j > p_82361_2_)
            {
                stringbuilder.append(" ");
            }

            String s = p_82361_1_[j];

            if (p_82361_3_)
            {
                String s1 = PlayerSelector.func_82385_b(p_82361_0_, s);

                if (s1 != null)
                {
                    s = s1;
                }
                else if (PlayerSelector.func_82378_b(s))
                {
                    throw new PlayerNotFoundException();
                }
            }

            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    public static double func_110666_a(ICommandSender p_110666_0_, double p_110666_1_, String p_110666_3_)
    {
        return func_110665_a(p_110666_0_, p_110666_1_, p_110666_3_, -30000000, 30000000);
    }

    public static double func_110665_a(ICommandSender p_110665_0_, double p_110665_1_, String p_110665_3_, int p_110665_4_, int p_110665_5_)
    {
        boolean flag = p_110665_3_.startsWith("~");

        if (flag && Double.isNaN(p_110665_1_))
        {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] {Double.valueOf(p_110665_1_)});
        }
        else
        {
            double d1 = flag ? p_110665_1_ : 0.0D;

            if (!flag || p_110665_3_.length() > 1)
            {
                boolean flag1 = p_110665_3_.contains(".");

                if (flag)
                {
                    p_110665_3_ = p_110665_3_.substring(1);
                }

                d1 += func_82363_b(p_110665_0_, p_110665_3_);

                if (!flag1 && !flag)
                {
                    d1 += 0.5D;
                }
            }

            if (p_110665_4_ != 0 || p_110665_5_ != 0)
            {
                if (d1 < (double)p_110665_4_)
                {
                    throw new NumberInvalidException("commands.generic.double.tooSmall", new Object[] {Double.valueOf(d1), Integer.valueOf(p_110665_4_)});
                }

                if (d1 > (double)p_110665_5_)
                {
                    throw new NumberInvalidException("commands.generic.double.tooBig", new Object[] {Double.valueOf(d1), Integer.valueOf(p_110665_5_)});
                }
            }

            return d1;
        }
    }

    public static String func_71527_a(Object[] p_71527_0_)
    {
        StringBuilder stringbuilder = new StringBuilder();

        for (int i = 0; i < p_71527_0_.length; ++i)
        {
            String s = p_71527_0_[i].toString();

            if (i > 0)
            {
                if (i == p_71527_0_.length - 1)
                {
                    stringbuilder.append(" and ");
                }
                else
                {
                    stringbuilder.append(", ");
                }
            }

            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    public static String func_96333_a(Collection p_96333_0_)
    {
        return func_71527_a(p_96333_0_.toArray(new String[p_96333_0_.size()]));
    }

    public static String func_110663_b(Collection p_110663_0_)
    {
        String[] astring = new String[p_110663_0_.size()];
        int i = 0;
        EntityLivingBase entitylivingbase;

        for (Iterator iterator = p_110663_0_.iterator(); iterator.hasNext(); astring[i++] = entitylivingbase.func_96090_ax())
        {
            entitylivingbase = (EntityLivingBase)iterator.next();
        }

        return func_71527_a(astring);
    }

    public static boolean func_71523_a(String p_71523_0_, String p_71523_1_)
    {
        return p_71523_1_.regionMatches(true, 0, p_71523_0_, 0, p_71523_0_.length());
    }

    public static List func_71530_a(String[] p_71530_0_, String ... p_71530_1_)
    {
        String s1 = p_71530_0_[p_71530_0_.length - 1];
        ArrayList arraylist = new ArrayList();
        String[] astring1 = p_71530_1_;
        int i = p_71530_1_.length;

        for (int j = 0; j < i; ++j)
        {
            String s2 = astring1[j];

            if (func_71523_a(s1, s2))
            {
                arraylist.add(s2);
            }
        }

        return arraylist;
    }

    public static List func_71531_a(String[] p_71531_0_, Iterable p_71531_1_)
    {
        String s = p_71531_0_[p_71531_0_.length - 1];
        ArrayList arraylist = new ArrayList();
        Iterator iterator = p_71531_1_.iterator();

        while (iterator.hasNext())
        {
            String s1 = (String)iterator.next();

            if (func_71523_a(s, s1))
            {
                arraylist.add(s1);
            }
        }

        return arraylist;
    }

    public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_)
    {
        return false;
    }

    public static void func_71522_a(ICommandSender p_71522_0_, String p_71522_1_, Object ... p_71522_2_)
    {
        func_71524_a(p_71522_0_, 0, p_71522_1_, p_71522_2_);
    }

    public static void func_71524_a(ICommandSender p_71524_0_, int p_71524_1_, String p_71524_2_, Object ... p_71524_3_)
    {
        if (field_71533_a != null)
        {
            field_71533_a.func_71563_a(p_71524_0_, p_71524_1_, p_71524_2_, p_71524_3_);
        }
    }

    public static void func_71529_a(IAdminCommand p_71529_0_)
    {
        field_71533_a = p_71529_0_;
    }

    public int func_71525_a(ICommand p_71525_1_)
    {
        return this.func_71517_b().compareTo(p_71525_1_.func_71517_b());
    }

    public int compareTo(Object p_compareTo_1_)
    {
        return this.func_71525_a((ICommand)p_compareTo_1_);
    }
}
