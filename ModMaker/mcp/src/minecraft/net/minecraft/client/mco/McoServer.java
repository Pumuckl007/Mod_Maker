package net.minecraft.client.mco;

import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.saj.InvalidSyntaxException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@SideOnly(Side.CLIENT)
public class McoServer
{
    public long field_96408_a;
    public String field_96406_b;
    public String field_96407_c;
    public String field_96404_d;
    public String field_96405_e;
    public List field_96402_f;
    public String field_96403_g;
    public boolean field_98166_h;
    public int field_110729_i;
    public int field_110728_j;
    public int field_104063_i;
    public int field_96415_h;
    public String field_96414_k = "";
    public boolean field_96411_l;
    public boolean field_102022_m;
    public long field_96412_m;
    private String field_96409_n;
    private String field_96410_o;

    public String func_96397_a()
    {
        if (this.field_96409_n == null)
        {
            try
            {
                this.field_96409_n = URLDecoder.decode(this.field_96407_c, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                this.field_96409_n = this.field_96407_c;
            }
        }

        return this.field_96409_n;
    }

    public String func_96398_b()
    {
        if (this.field_96410_o == null)
        {
            try
            {
                this.field_96410_o = URLDecoder.decode(this.field_96406_b, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                this.field_96410_o = this.field_96406_b;
            }
        }

        return this.field_96410_o;
    }

    public void func_96399_a(String p_96399_1_)
    {
        this.field_96406_b = p_96399_1_;
        this.field_96410_o = null;
    }

    public void func_96400_b(String p_96400_1_)
    {
        this.field_96407_c = p_96400_1_;
        this.field_96409_n = null;
    }

    public void func_96401_a(McoServer p_96401_1_)
    {
        this.field_96414_k = p_96401_1_.field_96414_k;
        this.field_96412_m = p_96401_1_.field_96412_m;
        this.field_96411_l = p_96401_1_.field_96411_l;
        this.field_96415_h = p_96401_1_.field_96415_h;
        this.field_102022_m = true;
    }

    public static McoServer func_98163_a(JsonNode p_98163_0_)
    {
        McoServer mcoserver = new McoServer();

        try
        {
            mcoserver.field_96408_a = Long.parseLong(p_98163_0_.getNumberValue(new Object[] {"id"}));
            mcoserver.field_96406_b = p_98163_0_.getStringValue(new Object[] {"name"});
            mcoserver.field_96407_c = p_98163_0_.getStringValue(new Object[] {"motd"});
            mcoserver.field_96404_d = p_98163_0_.getStringValue(new Object[] {"state"});
            mcoserver.field_96405_e = p_98163_0_.getStringValue(new Object[] {"owner"});

            if (p_98163_0_.isArrayNode(new Object[] {"invited"}))
            {
                mcoserver.field_96402_f = func_98164_a(p_98163_0_.getArrayNode(new Object[] {"invited"}));
            }
            else
            {
                mcoserver.field_96402_f = new ArrayList();
            }

            mcoserver.field_104063_i = Integer.parseInt(p_98163_0_.getNumberValue(new Object[] {"daysLeft"}));
            mcoserver.field_96403_g = p_98163_0_.getStringValue(new Object[] {"ip"});
            mcoserver.field_98166_h = p_98163_0_.getBooleanValue(new Object[] {"expired"}).booleanValue();
            mcoserver.field_110729_i = Integer.parseInt(p_98163_0_.getNumberValue(new Object[] {"difficulty"}));
            mcoserver.field_110728_j = Integer.parseInt(p_98163_0_.getNumberValue(new Object[] {"gameMode"}));
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            ;
        }

        return mcoserver;
    }

    private static List func_98164_a(List p_98164_0_)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = p_98164_0_.iterator();

        while (iterator.hasNext())
        {
            JsonNode jsonnode = (JsonNode)iterator.next();
            arraylist.add(jsonnode.getStringValue(new Object[0]));
        }

        return arraylist;
    }

    public static McoServer func_98165_c(String p_98165_0_)
    {
        McoServer mcoserver = new McoServer();

        try
        {
            mcoserver = func_98163_a((new JdomParser()).parse(p_98165_0_));
        }
        catch (InvalidSyntaxException invalidsyntaxexception)
        {
            ;
        }

        return mcoserver;
    }

    public int hashCode()
    {
        return (new HashCodeBuilder(17, 37)).append(this.field_96408_a).append(this.field_96406_b).append(this.field_96407_c).append(this.field_96404_d).append(this.field_96405_e).append(this.field_98166_h).toHashCode();
    }

    public boolean equals(Object p_equals_1_)
    {
        if (p_equals_1_ == null)
        {
            return false;
        }
        else if (p_equals_1_ == this)
        {
            return true;
        }
        else if (p_equals_1_.getClass() != this.getClass())
        {
            return false;
        }
        else
        {
            McoServer mcoserver = (McoServer)p_equals_1_;
            return (new EqualsBuilder()).append(this.field_96408_a, mcoserver.field_96408_a).append(this.field_96406_b, mcoserver.field_96406_b).append(this.field_96407_c, mcoserver.field_96407_c).append(this.field_96404_d, mcoserver.field_96404_d).append(this.field_96405_e, mcoserver.field_96405_e).append(this.field_98166_h, mcoserver.field_98166_h).isEquals();
        }
    }
}
