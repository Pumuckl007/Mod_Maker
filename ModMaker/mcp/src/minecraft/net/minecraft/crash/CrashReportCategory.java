package net.minecraft.crash;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.util.MathHelper;

public class CrashReportCategory
{
    private final CrashReport field_85078_a;
    private final String field_85076_b;
    private final List field_85077_c = new ArrayList();
    private StackTraceElement[] field_85075_d = new StackTraceElement[0];

    public CrashReportCategory(CrashReport p_i1353_1_, String p_i1353_2_)
    {
        this.field_85078_a = p_i1353_1_;
        this.field_85076_b = p_i1353_2_;
    }

    @SideOnly(Side.CLIENT)
    public static String func_85074_a(double p_85074_0_, double p_85074_2_, double p_85074_4_)
    {
        return String.format("%.2f,%.2f,%.2f - %s", new Object[] {Double.valueOf(p_85074_0_), Double.valueOf(p_85074_2_), Double.valueOf(p_85074_4_), func_85071_a(MathHelper.func_76128_c(p_85074_0_), MathHelper.func_76128_c(p_85074_2_), MathHelper.func_76128_c(p_85074_4_))});
    }

    public static String func_85071_a(int p_85071_0_, int p_85071_1_, int p_85071_2_)
    {
        StringBuilder stringbuilder = new StringBuilder();

        try
        {
            stringbuilder.append(String.format("World: (%d,%d,%d)", new Object[] {Integer.valueOf(p_85071_0_), Integer.valueOf(p_85071_1_), Integer.valueOf(p_85071_2_)}));
        }
        catch (Throwable throwable)
        {
            stringbuilder.append("(Error finding world loc)");
        }

        stringbuilder.append(", ");
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;

        try
        {
            l = p_85071_0_ >> 4;
            i1 = p_85071_2_ >> 4;
            j1 = p_85071_0_ & 15;
            k1 = p_85071_1_ >> 4;
            l1 = p_85071_2_ & 15;
            i2 = l << 4;
            j2 = i1 << 4;
            k2 = (l + 1 << 4) - 1;
            l2 = (i1 + 1 << 4) - 1;
            stringbuilder.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", new Object[] {Integer.valueOf(j1), Integer.valueOf(k1), Integer.valueOf(l1), Integer.valueOf(l), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j2), Integer.valueOf(k2), Integer.valueOf(l2)}));
        }
        catch (Throwable throwable1)
        {
            stringbuilder.append("(Error finding chunk loc)");
        }

        stringbuilder.append(", ");

        try
        {
            l = p_85071_0_ >> 9;
            i1 = p_85071_2_ >> 9;
            j1 = l << 5;
            k1 = i1 << 5;
            l1 = (l + 1 << 5) - 1;
            i2 = (i1 + 1 << 5) - 1;
            j2 = l << 9;
            k2 = i1 << 9;
            l2 = (l + 1 << 9) - 1;
            int i3 = (i1 + 1 << 9) - 1;
            stringbuilder.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", new Object[] {Integer.valueOf(l), Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(k1), Integer.valueOf(l1), Integer.valueOf(i2), Integer.valueOf(j2), Integer.valueOf(k2), Integer.valueOf(l2), Integer.valueOf(i3)}));
        }
        catch (Throwable throwable2)
        {
            stringbuilder.append("(Error finding world loc)");
        }

        return stringbuilder.toString();
    }

    public void func_71500_a(String p_71500_1_, Callable p_71500_2_)
    {
        try
        {
            this.func_71507_a(p_71500_1_, p_71500_2_.call());
        }
        catch (Throwable throwable)
        {
            this.func_71499_a(p_71500_1_, throwable);
        }
    }

    public void func_71507_a(String p_71507_1_, Object p_71507_2_)
    {
        this.field_85077_c.add(new CrashReportCategoryEntry(p_71507_1_, p_71507_2_));
    }

    public void func_71499_a(String p_71499_1_, Throwable p_71499_2_)
    {
        this.func_71507_a(p_71499_1_, p_71499_2_);
    }

    public int func_85073_a(int p_85073_1_)
    {
        StackTraceElement[] astacktraceelement = Thread.currentThread().getStackTrace();
        this.field_85075_d = new StackTraceElement[astacktraceelement.length - 3 - p_85073_1_];
        System.arraycopy(astacktraceelement, 3 + p_85073_1_, this.field_85075_d, 0, this.field_85075_d.length);
        return this.field_85075_d.length;
    }

    public boolean func_85069_a(StackTraceElement p_85069_1_, StackTraceElement p_85069_2_)
    {
        if (this.field_85075_d.length != 0 && p_85069_1_ != null)
        {
            StackTraceElement stacktraceelement2 = this.field_85075_d[0];

            if (stacktraceelement2.isNativeMethod() == p_85069_1_.isNativeMethod() && stacktraceelement2.getClassName().equals(p_85069_1_.getClassName()) && stacktraceelement2.getFileName().equals(p_85069_1_.getFileName()) && stacktraceelement2.getMethodName().equals(p_85069_1_.getMethodName()))
            {
                if (p_85069_2_ != null != this.field_85075_d.length > 1)
                {
                    return false;
                }
                else if (p_85069_2_ != null && !this.field_85075_d[1].equals(p_85069_2_))
                {
                    return false;
                }
                else
                {
                    this.field_85075_d[0] = p_85069_1_;
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public void func_85070_b(int p_85070_1_)
    {
        StackTraceElement[] astacktraceelement = new StackTraceElement[this.field_85075_d.length - p_85070_1_];
        System.arraycopy(this.field_85075_d, 0, astacktraceelement, 0, astacktraceelement.length);
        this.field_85075_d = astacktraceelement;
    }

    public void func_85072_a(StringBuilder p_85072_1_)
    {
        p_85072_1_.append("-- ").append(this.field_85076_b).append(" --\n");
        p_85072_1_.append("Details:");
        Iterator iterator = this.field_85077_c.iterator();

        while (iterator.hasNext())
        {
            CrashReportCategoryEntry crashreportcategoryentry = (CrashReportCategoryEntry)iterator.next();
            p_85072_1_.append("\n\t");
            p_85072_1_.append(crashreportcategoryentry.func_85089_a());
            p_85072_1_.append(": ");
            p_85072_1_.append(crashreportcategoryentry.func_85090_b());
        }

        if (this.field_85075_d != null && this.field_85075_d.length > 0)
        {
            p_85072_1_.append("\nStacktrace:");
            StackTraceElement[] astacktraceelement = this.field_85075_d;
            int i = astacktraceelement.length;

            for (int j = 0; j < i; ++j)
            {
                StackTraceElement stacktraceelement = astacktraceelement[j];
                p_85072_1_.append("\n\tat ");
                p_85072_1_.append(stacktraceelement.toString());
            }
        }
    }

    public static void func_85068_a(CrashReportCategory p_85068_0_, int p_85068_1_, int p_85068_2_, int p_85068_3_, int p_85068_4_, int p_85068_5_)
    {
        p_85068_0_.func_71500_a("Block type", new CallableBlockType(p_85068_4_));
        p_85068_0_.func_71500_a("Block data value", new CallableBlockDataValue(p_85068_5_));
        p_85068_0_.func_71500_a("Block location", new CallableBlockLocation(p_85068_1_, p_85068_2_, p_85068_3_));
    }
}
