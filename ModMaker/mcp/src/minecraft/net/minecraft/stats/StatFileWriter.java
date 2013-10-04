package net.minecraft.stats;

import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import argo.saj.InvalidSyntaxException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.stats.StatPlaceholder;
import net.minecraft.util.MD5String;
import net.minecraft.util.Session;

@SideOnly(Side.CLIENT)
public class StatFileWriter
{
    private Map field_77457_a = new HashMap();
    private Map field_77455_b = new HashMap();
    private boolean field_77456_c;
    private StatsSyncher field_77454_d;

    public StatFileWriter(Session p_i1332_1_, File p_i1332_2_)
    {
        File file2 = new File(p_i1332_2_, "stats");

        if (!file2.exists())
        {
            file2.mkdir();
        }

        File[] afile = p_i1332_2_.listFiles();
        int i = afile.length;

        for (int j = 0; j < i; ++j)
        {
            File file3 = afile[j];

            if (file3.getName().startsWith("stats_") && file3.getName().endsWith(".dat"))
            {
                File file4 = new File(file2, file3.getName());

                if (!file4.exists())
                {
                    System.out.println("Relocating " + file3.getName());
                    file3.renameTo(file4);
                }
            }
        }

        this.field_77454_d = new StatsSyncher(p_i1332_1_, this, file2);
    }

    public void func_77450_a(StatBase p_77450_1_, int p_77450_2_)
    {
        this.func_77451_a(this.field_77455_b, p_77450_1_, p_77450_2_);
        this.func_77451_a(this.field_77457_a, p_77450_1_, p_77450_2_);
        this.field_77456_c = true;
    }

    private void func_77451_a(Map p_77451_1_, StatBase p_77451_2_, int p_77451_3_)
    {
        Integer integer = (Integer)p_77451_1_.get(p_77451_2_);
        int j = integer == null ? 0 : integer.intValue();
        p_77451_1_.put(p_77451_2_, Integer.valueOf(j + p_77451_3_));
    }

    public Map func_77445_b()
    {
        return new HashMap(this.field_77455_b);
    }

    public void func_77447_a(Map p_77447_1_)
    {
        if (p_77447_1_ != null)
        {
            this.field_77456_c = true;
            Iterator iterator = p_77447_1_.keySet().iterator();

            while (iterator.hasNext())
            {
                StatBase statbase = (StatBase)iterator.next();
                this.func_77451_a(this.field_77455_b, statbase, ((Integer)p_77447_1_.get(statbase)).intValue());
                this.func_77451_a(this.field_77457_a, statbase, ((Integer)p_77447_1_.get(statbase)).intValue());
            }
        }
    }

    public void func_77452_b(Map p_77452_1_)
    {
        if (p_77452_1_ != null)
        {
            Iterator iterator = p_77452_1_.keySet().iterator();

            while (iterator.hasNext())
            {
                StatBase statbase = (StatBase)iterator.next();
                Integer integer = (Integer)this.field_77455_b.get(statbase);
                int i = integer == null ? 0 : integer.intValue();
                this.field_77457_a.put(statbase, Integer.valueOf(((Integer)p_77452_1_.get(statbase)).intValue() + i));
            }
        }
    }

    public void func_77448_c(Map p_77448_1_)
    {
        if (p_77448_1_ != null)
        {
            this.field_77456_c = true;
            Iterator iterator = p_77448_1_.keySet().iterator();

            while (iterator.hasNext())
            {
                StatBase statbase = (StatBase)iterator.next();
                this.func_77451_a(this.field_77455_b, statbase, ((Integer)p_77448_1_.get(statbase)).intValue());
            }
        }
    }

    public static Map func_77453_b(String p_77453_0_)
    {
        HashMap hashmap = new HashMap();

        try
        {
            String s1 = "local";
            StringBuilder stringbuilder = new StringBuilder();
            JsonRootNode jsonrootnode = (new JdomParser()).parse(p_77453_0_);
            List list = jsonrootnode.getArrayNode(new Object[] {"stats-change"});
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                JsonNode jsonnode = (JsonNode)iterator.next();
                Map map = jsonnode.getFields();
                Entry entry = (Entry)map.entrySet().iterator().next();
                int i = Integer.parseInt(((JsonStringNode)entry.getKey()).getText());
                int j = Integer.parseInt(((JsonNode)entry.getValue()).getText());
                boolean flag = true;
                StatBase statbase = StatList.func_75923_a(i);

                if (statbase == null)
                {
                    flag = false;
                    statbase = (new StatPlaceholder(i)).func_75971_g();
                }

                stringbuilder.append(StatList.func_75923_a(i).field_75973_g).append(",");
                stringbuilder.append(j).append(",");

                if (flag)
                {
                    hashmap.put(statbase, Integer.valueOf(j));
                }
            }

            MD5String md5string = new MD5String(s1);
            String s2 = md5string.func_75899_a(stringbuilder.toString());

            if (!s2.equals(jsonrootnode.getStringValue(new Object[] {"checksum"})))
            {
                System.out.println("CHECKSUM MISMATCH");
                return null;
            }
        }
        catch (InvalidSyntaxException invalidsyntaxexception)
        {
            invalidsyntaxexception.printStackTrace();
        }

        return hashmap;
    }

    public static String func_77441_a(String p_77441_0_, String p_77441_1_, Map p_77441_2_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringBuilder stringbuilder1 = new StringBuilder();
        boolean flag = true;
        stringbuilder.append("{\r\n");

        if (p_77441_0_ != null && p_77441_1_ != null)
        {
            stringbuilder.append("  \"user\":{\r\n");
            stringbuilder.append("    \"name\":\"").append(p_77441_0_).append("\",\r\n");
            stringbuilder.append("    \"sessionid\":\"").append(p_77441_1_).append("\"\r\n");
            stringbuilder.append("  },\r\n");
        }

        stringbuilder.append("  \"stats-change\":[");
        Iterator iterator = p_77441_2_.keySet().iterator();

        while (iterator.hasNext())
        {
            StatBase statbase = (StatBase)iterator.next();

            if (flag)
            {
                flag = false;
            }
            else
            {
                stringbuilder.append("},");
            }

            stringbuilder.append("\r\n    {\"").append(statbase.field_75975_e).append("\":").append(p_77441_2_.get(statbase));
            stringbuilder1.append(statbase.field_75973_g).append(",");
            stringbuilder1.append(p_77441_2_.get(statbase)).append(",");
        }

        if (!flag)
        {
            stringbuilder.append("}");
        }

        MD5String md5string = new MD5String(p_77441_1_);
        stringbuilder.append("\r\n  ],\r\n");
        stringbuilder.append("  \"checksum\":\"").append(md5string.func_75899_a(stringbuilder1.toString())).append("\"\r\n");
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public boolean func_77443_a(Achievement p_77443_1_)
    {
        return this.field_77457_a.containsKey(p_77443_1_);
    }

    public boolean func_77442_b(Achievement p_77442_1_)
    {
        return p_77442_1_.field_75992_c == null || this.func_77443_a(p_77442_1_.field_75992_c);
    }

    public int func_77444_a(StatBase p_77444_1_)
    {
        Integer integer = (Integer)this.field_77457_a.get(p_77444_1_);
        return integer == null ? 0 : integer.intValue();
    }

    public void func_77446_d()
    {
        this.field_77454_d.func_77420_c(this.func_77445_b());
    }

    public void func_77449_e()
    {
        if (this.field_77456_c && this.field_77454_d.func_77425_c())
        {
            this.field_77454_d.func_77418_a(this.func_77445_b());
        }

        this.field_77454_d.func_77422_e();
    }
}
