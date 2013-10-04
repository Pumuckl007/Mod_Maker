package net.minecraft.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLEncoder;
import net.minecraft.util.CryptManager;

class ThreadLoginVerifier extends Thread
{
    final NetLoginHandler field_72590_a;

    ThreadLoginVerifier(NetLoginHandler p_i1526_1_)
    {
        this.field_72590_a = p_i1526_1_;
    }

    public void run()
    {
        try
        {
            String s = (new BigInteger(CryptManager.func_75895_a(NetLoginHandler.func_72526_a(this.field_72590_a), NetLoginHandler.func_72530_b(this.field_72590_a).func_71250_E().getPublic(), NetLoginHandler.func_72525_c(this.field_72590_a)))).toString(16);
            URL url = new URL("http://session.minecraft.net/game/checkserver.jsp?user=" + URLEncoder.encode(NetLoginHandler.func_72533_d(this.field_72590_a), "UTF-8") + "&serverId=" + URLEncoder.encode(s, "UTF-8"));
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openConnection(NetLoginHandler.func_72530_b(this.field_72590_a).func_110454_ao()).getInputStream()));
            String s1 = bufferedreader.readLine();
            bufferedreader.close();

            if (!"YES".equals(s1))
            {
                this.field_72590_a.func_72527_a("Failed to verify username!");
                return;
            }

            NetLoginHandler.func_72531_a(this.field_72590_a, true);
        }
        catch (Exception exception)
        {
            this.field_72590_a.func_72527_a("Failed to verify username! [internal error " + exception + "]");
            exception.printStackTrace();
        }
    }
}
