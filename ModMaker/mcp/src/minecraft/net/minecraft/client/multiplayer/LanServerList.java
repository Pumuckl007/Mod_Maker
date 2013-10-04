package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SideOnly(Side.CLIENT)
public class LanServerList
{
    private ArrayList field_77555_b = new ArrayList();
    boolean field_77556_a;

    public synchronized boolean func_77553_a()
    {
        return this.field_77556_a;
    }

    public synchronized void func_77552_b()
    {
        this.field_77556_a = false;
    }

    public synchronized List func_77554_c()
    {
        return Collections.unmodifiableList(this.field_77555_b);
    }

    public synchronized void func_77551_a(String p_77551_1_, InetAddress p_77551_2_)
    {
        String s1 = ThreadLanServerPing.func_77524_a(p_77551_1_);
        String s2 = ThreadLanServerPing.func_77523_b(p_77551_1_);

        if (s2 != null)
        {
            s2 = p_77551_2_.getHostAddress() + ":" + s2;
            boolean flag = false;
            Iterator iterator = this.field_77555_b.iterator();

            while (iterator.hasNext())
            {
                LanServer lanserver = (LanServer)iterator.next();

                if (lanserver.func_77488_b().equals(s2))
                {
                    lanserver.func_77489_c();
                    flag = true;
                    break;
                }
            }

            if (!flag)
            {
                this.field_77555_b.add(new LanServer(s1, s2));
                this.field_77556_a = true;
            }
        }
    }
}
