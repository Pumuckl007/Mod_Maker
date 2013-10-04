package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;

public abstract class NBTBase
{
    public static final String[] field_82578_b = new String[] {"END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]"};
    private String field_74741_a;

    abstract void func_74734_a(DataOutput dataoutput) throws IOException;

    abstract void func_74735_a(DataInput datainput, int i) throws IOException;

    public abstract byte func_74732_a();

    protected NBTBase(String p_i1391_1_)
    {
        if (p_i1391_1_ == null)
        {
            this.field_74741_a = "";
        }
        else
        {
            this.field_74741_a = p_i1391_1_;
        }
    }

    public NBTBase func_74738_o(String p_74738_1_)
    {
        if (p_74738_1_ == null)
        {
            this.field_74741_a = "";
        }
        else
        {
            this.field_74741_a = p_74738_1_;
        }

        return this;
    }

    public String func_74740_e()
    {
        return this.field_74741_a == null ? "" : this.field_74741_a;
    }

    public static NBTBase func_74739_b(DataInput p_74739_0_) throws IOException
    {
        return func_130104_b(p_74739_0_, 0);
    }

    public static NBTBase func_130104_b(DataInput p_130104_0_, int p_130104_1_) throws IOException
    {
        byte b0 = p_130104_0_.readByte();

        if (b0 == 0)
        {
            return new NBTTagEnd();
        }
        else
        {
            String s = p_130104_0_.readUTF();
            NBTBase nbtbase = func_74733_a(b0, s);

            try
            {
                nbtbase.func_74735_a(p_130104_0_, p_130104_1_);
                return nbtbase;
            }
            catch (IOException ioexception)
            {
                CrashReport crashreport = CrashReport.func_85055_a(ioexception, "Loading NBT data");
                CrashReportCategory crashreportcategory = crashreport.func_85058_a("NBT Tag");
                crashreportcategory.func_71507_a("Tag name", s);
                crashreportcategory.func_71507_a("Tag type", Byte.valueOf(b0));
                throw new ReportedException(crashreport);
            }
        }
    }

    public static void func_74731_a(NBTBase p_74731_0_, DataOutput p_74731_1_) throws IOException
    {
        p_74731_1_.writeByte(p_74731_0_.func_74732_a());

        if (p_74731_0_.func_74732_a() != 0)
        {
            p_74731_1_.writeUTF(p_74731_0_.func_74740_e());
            p_74731_0_.func_74734_a(p_74731_1_);
        }
    }

    public static NBTBase func_74733_a(byte p_74733_0_, String p_74733_1_)
    {
        switch (p_74733_0_)
        {
            case 0:
                return new NBTTagEnd();
            case 1:
                return new NBTTagByte(p_74733_1_);
            case 2:
                return new NBTTagShort(p_74733_1_);
            case 3:
                return new NBTTagInt(p_74733_1_);
            case 4:
                return new NBTTagLong(p_74733_1_);
            case 5:
                return new NBTTagFloat(p_74733_1_);
            case 6:
                return new NBTTagDouble(p_74733_1_);
            case 7:
                return new NBTTagByteArray(p_74733_1_);
            case 8:
                return new NBTTagString(p_74733_1_);
            case 9:
                return new NBTTagList(p_74733_1_);
            case 10:
                return new NBTTagCompound(p_74733_1_);
            case 11:
                return new NBTTagIntArray(p_74733_1_);
            default:
                return null;
        }
    }

    public static String func_74736_a(byte p_74736_0_)
    {
        switch (p_74736_0_)
        {
            case 0:
                return "TAG_End";
            case 1:
                return "TAG_Byte";
            case 2:
                return "TAG_Short";
            case 3:
                return "TAG_Int";
            case 4:
                return "TAG_Long";
            case 5:
                return "TAG_Float";
            case 6:
                return "TAG_Double";
            case 7:
                return "TAG_Byte_Array";
            case 8:
                return "TAG_String";
            case 9:
                return "TAG_List";
            case 10:
                return "TAG_Compound";
            case 11:
                return "TAG_Int_Array";
            default:
                return "UNKNOWN";
        }
    }

    public abstract NBTBase func_74737_b();

    public boolean equals(Object p_equals_1_)
    {
        if (!(p_equals_1_ instanceof NBTBase))
        {
            return false;
        }
        else
        {
            NBTBase nbtbase = (NBTBase)p_equals_1_;
            return this.func_74732_a() != nbtbase.func_74732_a() ? false : ((this.field_74741_a != null || nbtbase.field_74741_a == null) && (this.field_74741_a == null || nbtbase.field_74741_a != null) ? this.field_74741_a == null || this.field_74741_a.equals(nbtbase.field_74741_a) : false);
        }
    }

    public int hashCode()
    {
        return this.field_74741_a.hashCode() ^ this.func_74732_a();
    }
}