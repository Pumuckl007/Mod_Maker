package net.minecraft.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatAllowedCharacters
{
    public static final String field_71568_a = func_71564_a();
    public static final char[] field_71567_b = new char[] {'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};

    private static String func_71564_a()
    {
        String s = "";

        try
        {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(ChatAllowedCharacters.class.getResourceAsStream("/font.txt"), "UTF-8"));
            String s1 = "";

            while ((s1 = bufferedreader.readLine()) != null)
            {
                if (!s1.startsWith("#"))
                {
                    s = s + s1;
                }
            }

            bufferedreader.close();
        }
        catch (Exception exception)
        {
            ;
        }

        return s;
    }

    public static final boolean func_71566_a(char p_71566_0_)
    {
        return p_71566_0_ != 167 && (field_71568_a.indexOf(p_71566_0_) >= 0 || p_71566_0_ > 32);
    }

    public static String func_71565_a(String p_71565_0_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        char[] achar = p_71565_0_.toCharArray();
        int i = achar.length;

        for (int j = 0; j < i; ++j)
        {
            char c0 = achar[j];

            if (func_71566_a(c0))
            {
                stringbuilder.append(c0);
            }
        }

        return stringbuilder.toString();
    }
}
