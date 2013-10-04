package net.minecraft.server.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.DecimalFormat;
import javax.swing.JComponent;
import javax.swing.Timer;
import net.minecraft.network.TcpConnection;
import net.minecraft.server.MinecraftServer;

@SideOnly(Side.SERVER)
public class StatsComponent extends JComponent
{
    private static final DecimalFormat field_120040_a = new DecimalFormat("########0.000");
    private int[] field_120038_b = new int[256];
    private int field_120039_c;
    private String[] field_120036_d = new String[11];
    private final MinecraftServer field_120037_e;

    public StatsComponent(MinecraftServer p_i2367_1_)
    {
        this.field_120037_e = p_i2367_1_;
        this.setPreferredSize(new Dimension(456, 246));
        this.setMinimumSize(new Dimension(456, 246));
        this.setMaximumSize(new Dimension(456, 246));
        (new Timer(500, new StatsComponentINNER1(this))).start();
        this.setBackground(Color.BLACK);
    }

    private void func_120034_a()
    {
        long i = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.gc();
        this.field_120036_d[0] = "Memory use: " + i / 1024L / 1024L + " mb (" + Runtime.getRuntime().freeMemory() * 100L / Runtime.getRuntime().maxMemory() + "% free)";
        this.field_120036_d[1] = "Threads: " + TcpConnection.field_74471_a.get() + " + " + TcpConnection.field_74469_b.get();
        this.field_120036_d[2] = "Avg tick: " + field_120040_a.format(this.func_120035_a(this.field_120037_e.field_71311_j) * 1.0E-6D) + " ms";
        this.field_120036_d[3] = "Avg sent: " + (int)this.func_120035_a(this.field_120037_e.field_71300_f) + ", Avg size: " + (int)this.func_120035_a(this.field_120037_e.field_71301_g);
        this.field_120036_d[4] = "Avg rec: " + (int)this.func_120035_a(this.field_120037_e.field_71313_h) + ", Avg size: " + (int)this.func_120035_a(this.field_120037_e.field_71314_i);

        if (this.field_120037_e.field_71305_c != null)
        {
            for (int j = 0; j < this.field_120037_e.field_71305_c.length; ++j)
            {
                this.field_120036_d[5 + j] = "Lvl " + j + " tick: " + field_120040_a.format(this.func_120035_a(this.field_120037_e.field_71312_k[j]) * 1.0E-6D) + " ms";

                if (this.field_120037_e.field_71305_c[j] != null && this.field_120037_e.field_71305_c[j].field_73059_b != null)
                {
                    this.field_120036_d[5 + j] = this.field_120036_d[5 + j] + ", " + this.field_120037_e.field_71305_c[j].field_73059_b.func_73148_d();
                    this.field_120036_d[5 + j] = this.field_120036_d[5 + j] + ", Vec3: " + this.field_120037_e.field_71305_c[j].func_82732_R().func_82590_d() + " / " + this.field_120037_e.field_71305_c[j].func_82732_R().func_82591_c();
                }
            }
        }

        double d0 = 12500.0D;
        this.field_120038_b[this.field_120039_c++ & 255] = (int)(this.func_120035_a(this.field_120037_e.field_71301_g) * 100.0D / 12500.0D);
        this.repaint();
    }

    private double func_120035_a(long[] p_120035_1_)
    {
        long i = 0L;

        for (int j = 0; j < p_120035_1_.length; ++j)
        {
            i += p_120035_1_[j];
        }

        return (double)i / (double)p_120035_1_.length;
    }

    public void paint(Graphics p_paint_1_)
    {
        p_paint_1_.setColor(new Color(16777215));
        p_paint_1_.fillRect(0, 0, 456, 246);
        int i;

        for (i = 0; i < 256; ++i)
        {
            int j = this.field_120038_b[i + this.field_120039_c & 255];
            p_paint_1_.setColor(new Color(j + 28 << 16));
            p_paint_1_.fillRect(i, 100 - j, 1, j);
        }

        p_paint_1_.setColor(Color.BLACK);

        for (i = 0; i < this.field_120036_d.length; ++i)
        {
            String s = this.field_120036_d[i];

            if (s != null)
            {
                p_paint_1_.drawString(s, 32, 116 + i * 16);
            }
        }
    }

    static void func_120033_a(StatsComponent p_120033_0_)
    {
        p_120033_0_.func_120034_a();
    }
}
