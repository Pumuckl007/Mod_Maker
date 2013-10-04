package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.util.StringUtils;

@SideOnly(Side.CLIENT)
public class ChatClickData
{
    public static final Pattern field_78316_a = Pattern.compile("^(?:(https?)://)?([-\\w_\\.]{2,}\\.[a-z]{2,4})(/\\S*)?$");
    private final FontRenderer field_78314_b;
    private final ChatLine field_78315_c;
    private final int field_78312_d;
    private final int field_78313_e;
    private final String field_78310_f;
    private final String field_78311_g;

    public ChatClickData(FontRenderer p_i1037_1_, ChatLine p_i1037_2_, int p_i1037_3_, int p_i1037_4_)
    {
        this.field_78314_b = p_i1037_1_;
        this.field_78315_c = p_i1037_2_;
        this.field_78312_d = p_i1037_3_;
        this.field_78313_e = p_i1037_4_;
        this.field_78310_f = p_i1037_1_.func_78269_a(p_i1037_2_.func_74538_a(), p_i1037_3_);
        this.field_78311_g = this.func_78307_h();
    }

    public String func_78309_f()
    {
        return this.field_78311_g;
    }

    public URI func_78308_g()
    {
        String s = this.func_78309_f();

        if (s == null)
        {
            return null;
        }
        else
        {
            Matcher matcher = field_78316_a.matcher(s);

            if (matcher.matches())
            {
                try
                {
                    String s1 = matcher.group(0);

                    if (matcher.group(1) == null)
                    {
                        s1 = "http://" + s1;
                    }

                    return new URI(s1);
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    Minecraft.func_71410_x().func_98033_al().func_98234_c("Couldn\'t create URI from chat", urisyntaxexception);
                }
            }

            return null;
        }
    }

    private String func_78307_h()
    {
        int i = this.field_78310_f.lastIndexOf(" ", this.field_78310_f.length()) + 1;

        if (i < 0)
        {
            i = 0;
        }

        int j = this.field_78315_c.func_74538_a().indexOf(" ", i);

        if (j < 0)
        {
            j = this.field_78315_c.func_74538_a().length();
        }

        return StringUtils.func_76338_a(this.field_78315_c.func_74538_a().substring(i, j));
    }
}
