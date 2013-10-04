package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public abstract class Request
{
    protected HttpURLConnection field_96367_a;
    private boolean field_96366_c;
    protected String field_96365_b;

    public Request(String p_i1144_1_, int p_i1144_2_, int p_i1144_3_)
    {
        try
        {
            this.field_96365_b = p_i1144_1_;
            this.field_96367_a = (HttpURLConnection)(new URL(p_i1144_1_)).openConnection(Minecraft.func_71410_x().func_110437_J());
            this.field_96367_a.setConnectTimeout(p_i1144_2_);
            this.field_96367_a.setReadTimeout(p_i1144_3_);
        }
        catch (Exception exception)
        {
            throw new ExceptionMcoHttp("Failed URL: " + p_i1144_1_, exception);
        }
    }

    public void func_100006_a(String p_100006_1_, String p_100006_2_)
    {
        String s2 = this.field_96367_a.getRequestProperty("Cookie");

        if (s2 == null)
        {
            this.field_96367_a.setRequestProperty("Cookie", p_100006_1_ + "=" + p_100006_2_);
        }
        else
        {
            this.field_96367_a.setRequestProperty("Cookie", s2 + ";" + p_100006_1_ + "=" + p_100006_2_);
        }
    }

    public int func_96362_a()
    {
        try
        {
            this.func_96354_d();
            return this.field_96367_a.getResponseCode();
        }
        catch (Exception exception)
        {
            throw new ExceptionMcoHttp("Failed URL: " + this.field_96365_b, exception);
        }
    }

    public int func_111221_b()
    {
        String s = this.field_96367_a.getHeaderField("Retry-After");

        try
        {
            return Integer.valueOf(s).intValue();
        }
        catch (Exception exception)
        {
            return 5;
        }
    }

    public String func_96364_c()
    {
        try
        {
            this.func_96354_d();
            String s = this.func_96362_a() >= 400 ? this.func_96352_a(this.field_96367_a.getErrorStream()) : this.func_96352_a(this.field_96367_a.getInputStream());
            this.func_96360_f();
            return s;
        }
        catch (IOException ioexception)
        {
            throw new ExceptionMcoHttp("Failed URL: " + this.field_96365_b, ioexception);
        }
    }

    private String func_96352_a(InputStream p_96352_1_) throws IOException
    {
        if (p_96352_1_ == null)
        {
            throw new IOException("No response (null)");
        }
        else
        {
            StringBuilder stringbuilder = new StringBuilder();

            for (int i = p_96352_1_.read(); i != -1; i = p_96352_1_.read())
            {
                stringbuilder.append((char)i);
            }

            return stringbuilder.toString();
        }
    }

    private void func_96360_f()
    {
        byte[] abyte = new byte[1024];
        InputStream inputstream;

        try
        {
            boolean flag = false;
            inputstream = this.field_96367_a.getInputStream();

            while (true)
            {
                if (inputstream.read(abyte) <= 0)
                {
                    inputstream.close();
                    break;
                }
            }
        }
        catch (Exception exception)
        {
            try
            {
                inputstream = this.field_96367_a.getErrorStream();
                boolean flag1 = false;

                while (true)
                {
                    if (inputstream.read(abyte) <= 0)
                    {
                        inputstream.close();
                        break;
                    }
                }
            }
            catch (IOException ioexception)
            {
                ;
            }
        }
    }

    protected Request func_96354_d()
    {
        if (!this.field_96366_c)
        {
            Request request = this.func_96359_e();
            this.field_96366_c = true;
            return request;
        }
        else
        {
            return this;
        }
    }

    protected abstract Request func_96359_e();

    public static Request func_96358_a(String p_96358_0_)
    {
        return new RequestGet(p_96358_0_, 5000, 10000);
    }

    public static Request func_96361_b(String p_96361_0_, String p_96361_1_)
    {
        return new RequestPost(p_96361_0_, p_96361_1_.getBytes(), 5000, 10000);
    }

    public static Request func_104064_a(String p_104064_0_, String p_104064_1_, int p_104064_2_, int p_104064_3_)
    {
        return new RequestPost(p_104064_0_, p_104064_1_.getBytes(), p_104064_2_, p_104064_3_);
    }

    public static Request func_96355_b(String p_96355_0_)
    {
        return new RequestDelete(p_96355_0_, 5000, 10000);
    }

    public static Request func_96363_c(String p_96363_0_, String p_96363_1_)
    {
        return new RequestPut(p_96363_0_, p_96363_1_.getBytes(), 5000, 10000);
    }

    public static Request func_96353_a(String p_96353_0_, String p_96353_1_, int p_96353_2_, int p_96353_3_)
    {
        return new RequestPut(p_96353_0_, p_96353_1_.getBytes(), p_96353_2_, p_96353_3_);
    }

    public int func_130110_g()
    {
        String s = this.field_96367_a.getHeaderField("Error-Code");

        try
        {
            return Integer.valueOf(s).intValue();
        }
        catch (Exception exception)
        {
            return -1;
        }
    }
}
