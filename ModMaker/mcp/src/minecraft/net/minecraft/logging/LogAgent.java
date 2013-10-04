package net.minecraft.logging;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogAgent implements ILogAgent
{
    private final Logger field_98242_a;
    private final String field_98240_b;
    private final String field_98241_c;
    private final String field_98239_d;

    public LogAgent(String p_i1550_1_, String p_i1550_2_, String p_i1550_3_)
    {
        this.field_98242_a = Logger.getLogger(p_i1550_1_);
        this.field_98241_c = p_i1550_1_;
        this.field_98239_d = p_i1550_2_;
        this.field_98240_b = p_i1550_3_;
        this.func_98238_b();
    }

    private void func_98238_b()
    {
        this.field_98242_a.setUseParentHandlers(false);
        Handler[] ahandler = this.field_98242_a.getHandlers();
        int i = ahandler.length;

        for (int j = 0; j < i; ++j)
        {
            Handler handler = ahandler[j];
            this.field_98242_a.removeHandler(handler);
        }

        LogFormatter logformatter = new LogFormatter(this, (LogAgentEmptyAnon)null);
        ConsoleHandler consolehandler = new ConsoleHandler();
        consolehandler.setFormatter(logformatter);
        this.field_98242_a.addHandler(consolehandler);

        try
        {
            FileHandler filehandler = new FileHandler(this.field_98240_b, true);
            filehandler.setFormatter(logformatter);
            this.field_98242_a.addHandler(filehandler);
        }
        catch (Exception exception)
        {
            this.field_98242_a.log(Level.WARNING, "Failed to log " + this.field_98241_c + " to " + this.field_98240_b, exception);
        }
    }

    public void func_98233_a(String p_98233_1_)
    {
        this.field_98242_a.log(Level.INFO, p_98233_1_);
    }

    @SideOnly(Side.SERVER)
    public Logger func_120013_a()
    {
        return this.field_98242_a;
    }

    public void func_98236_b(String p_98236_1_)
    {
        this.field_98242_a.log(Level.WARNING, p_98236_1_);
    }

    public void func_98231_b(String p_98231_1_, Object ... p_98231_2_)
    {
        this.field_98242_a.log(Level.WARNING, p_98231_1_, p_98231_2_);
    }

    public void func_98235_b(String p_98235_1_, Throwable p_98235_2_)
    {
        this.field_98242_a.log(Level.WARNING, p_98235_1_, p_98235_2_);
    }

    public void func_98232_c(String p_98232_1_)
    {
        this.field_98242_a.log(Level.SEVERE, p_98232_1_);
    }

    public void func_98234_c(String p_98234_1_, Throwable p_98234_2_)
    {
        this.field_98242_a.log(Level.SEVERE, p_98234_1_, p_98234_2_);
    }

    @SideOnly(Side.CLIENT)
    public void func_98230_d(String p_98230_1_)
    {
        this.field_98242_a.log(Level.FINE, p_98230_1_);
    }

    static String func_98237_a(LogAgent p_98237_0_)
    {
        return p_98237_0_.field_98239_d;
    }
}
