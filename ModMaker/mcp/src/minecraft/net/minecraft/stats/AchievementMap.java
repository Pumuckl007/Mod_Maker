package net.minecraft.stats;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AchievementMap
{
    public static AchievementMap field_75964_a = new AchievementMap();
    private Map field_75963_b = new HashMap();

    private AchievementMap()
    {
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(AchievementMap.class.getResourceAsStream("/achievement/map.txt")));
            String s;

            while ((s = bufferedreader.readLine()) != null)
            {
                String[] astring = s.split(",");
                int i = Integer.parseInt(astring[0]);
                this.field_75963_b.put(Integer.valueOf(i), astring[1]);
            }

            bufferedreader.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static String func_75962_a(int p_75962_0_)
    {
        return (String)field_75964_a.field_75963_b.get(Integer.valueOf(p_75962_0_));
    }
}
