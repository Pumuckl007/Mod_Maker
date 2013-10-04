package net.minecraft.server.dedicated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DedicatedServerCommandThread extends Thread
{
    final DedicatedServer field_72428_a;

    DedicatedServerCommandThread(DedicatedServer p_i1505_1_)
    {
        this.field_72428_a = p_i1505_1_;
    }

    public void run()
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        String s;

        try
        {
            while (!this.field_72428_a.func_71241_aa() && this.field_72428_a.func_71278_l() && (s = bufferedreader.readLine()) != null)
            {
                this.field_72428_a.func_71331_a(s, this.field_72428_a);
            }
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }
}
