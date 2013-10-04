package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.logging.ILogAgent;
import net.minecraft.server.MinecraftServer;

public class HttpUtil
{
    public static String func_76179_a(Map p_76179_0_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = p_76179_0_.entrySet().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();

            if (stringbuilder.length() > 0)
            {
                stringbuilder.append('&');
            }

            try
            {
                stringbuilder.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                unsupportedencodingexception.printStackTrace();
            }

            if (entry.getValue() != null)
            {
                stringbuilder.append('=');

                try
                {
                    stringbuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
                }
                catch (UnsupportedEncodingException unsupportedencodingexception1)
                {
                    unsupportedencodingexception1.printStackTrace();
                }
            }
        }

        return stringbuilder.toString();
    }

    public static String func_76183_a(ILogAgent p_76183_0_, URL p_76183_1_, Map p_76183_2_, boolean p_76183_3_)
    {
        return func_76180_a(p_76183_0_, p_76183_1_, func_76179_a(p_76183_2_), p_76183_3_);
    }

    private static String func_76180_a(ILogAgent p_76180_0_, URL p_76180_1_, String p_76180_2_, boolean p_76180_3_)
    {
        try
        {
            Proxy proxy = MinecraftServer.func_71276_C() == null ? null : MinecraftServer.func_71276_C().func_110454_ao();

            if (proxy == null)
            {
                proxy = Proxy.NO_PROXY;
            }

            HttpURLConnection httpurlconnection = (HttpURLConnection)p_76180_1_.openConnection(proxy);
            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpurlconnection.setRequestProperty("Content-Length", "" + p_76180_2_.getBytes().length);
            httpurlconnection.setRequestProperty("Content-Language", "en-US");
            httpurlconnection.setUseCaches(false);
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(true);
            DataOutputStream dataoutputstream = new DataOutputStream(httpurlconnection.getOutputStream());
            dataoutputstream.writeBytes(p_76180_2_);
            dataoutputstream.flush();
            dataoutputstream.close();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
            StringBuffer stringbuffer = new StringBuffer();
            String s1;

            while ((s1 = bufferedreader.readLine()) != null)
            {
                stringbuffer.append(s1);
                stringbuffer.append('\r');
            }

            bufferedreader.close();
            return stringbuffer.toString();
        }
        catch (Exception exception)
        {
            if (!p_76180_3_)
            {
                if (p_76180_0_ != null)
                {
                    p_76180_0_.func_98234_c("Could not post to " + p_76180_1_, exception);
                }
                else
                {
                    Logger.getAnonymousLogger().log(Level.SEVERE, "Could not post to " + p_76180_1_, exception);
                }
            }

            return "";
        }
    }

    @SideOnly(Side.CLIENT)
    public static int func_76181_a() throws IOException
    {
        ServerSocket serversocket = null;
        boolean flag = true;
        int i;

        try
        {
            serversocket = new ServerSocket(0);
            i = serversocket.getLocalPort();
        }
        finally
        {
            try
            {
                if (serversocket != null)
                {
                    serversocket.close();
                }
            }
            catch (IOException ioexception)
            {
                ;
            }
        }

        return i;
    }
}
