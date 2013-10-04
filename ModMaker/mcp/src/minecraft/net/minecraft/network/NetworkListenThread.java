package net.minecraft.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ReportedException;

public abstract class NetworkListenThread
{
    private final MinecraftServer field_71750_c;
    private final List field_71748_d = Collections.synchronizedList(new ArrayList());
    public volatile boolean field_71749_b;

    public NetworkListenThread(MinecraftServer p_i1532_1_) throws IOException
    {
        this.field_71750_c = p_i1532_1_;
        this.field_71749_b = true;
    }

    public void func_71745_a(NetServerHandler p_71745_1_)
    {
        this.field_71748_d.add(p_71745_1_);
    }

    public void func_71744_a()
    {
        this.field_71749_b = false;
    }

    public void func_71747_b()
    {
        for (int i = 0; i < this.field_71748_d.size(); ++i)
        {
            NetServerHandler netserverhandler = (NetServerHandler)this.field_71748_d.get(i);

            try
            {
                netserverhandler.func_72570_d();
            }
            catch (Exception exception)
            {
                if (netserverhandler.field_72575_b instanceof MemoryConnection)
                {
                    CrashReport crashreport = CrashReport.func_85055_a(exception, "Ticking memory connection");
                    CrashReportCategory crashreportcategory = crashreport.func_85058_a("Ticking connection");
                    crashreportcategory.func_71500_a("Connection", new CallableConnectionName(this, netserverhandler));
                    throw new ReportedException(crashreport);
                }

                this.field_71750_c.func_98033_al().func_98235_b("Failed to handle packet for " + netserverhandler.field_72574_e.func_70023_ak() + "/" + netserverhandler.field_72574_e.func_71114_r() + ": " + exception, exception);
                netserverhandler.func_72565_c("Internal server error");
            }

            if (netserverhandler.field_72576_c)
            {
                this.field_71748_d.remove(i--);
            }

            netserverhandler.field_72575_b.func_74427_a();
        }
    }

    public MinecraftServer func_71746_d()
    {
        return this.field_71750_c;
    }
}
