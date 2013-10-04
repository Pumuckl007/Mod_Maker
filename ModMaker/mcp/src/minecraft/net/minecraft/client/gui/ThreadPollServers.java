package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.EnumChatFormatting;

@SideOnly(Side.CLIENT)
class ThreadPollServers extends Thread
{
    final ServerData field_78318_a;

    final GuiSlotServer field_78317_b;

    ThreadPollServers(GuiSlotServer p_i1038_1_, ServerData p_i1038_2_)
    {
        this.field_78317_b = p_i1038_1_;
        this.field_78318_a = p_i1038_2_;
    }

    public void run()
    {
        boolean flag = false;
        label183:
        {
            label184:
            {
                label185:
                {
                    label186:
                    {
                        label187:
                        {
                            try
                            {
                                flag = true;
                                this.field_78318_a.field_78843_d = EnumChatFormatting.DARK_GRAY + "Polling..";
                                long i = System.nanoTime();
                                GuiMultiplayer.func_82291_a(this.field_78318_a);
                                long j = System.nanoTime();
                                this.field_78318_a.field_78844_e = (j - i) / 1000000L;
                                flag = false;
                                break label183;
                            }
                            catch (UnknownHostException unknownhostexception)
                            {
                                this.field_78318_a.field_78844_e = -1L;
                                this.field_78318_a.field_78843_d = EnumChatFormatting.DARK_RED + "Can\'t resolve hostname";
                                flag = false;
                            }
                            catch (SocketTimeoutException sockettimeoutexception)
                            {
                                this.field_78318_a.field_78844_e = -1L;
                                this.field_78318_a.field_78843_d = EnumChatFormatting.DARK_RED + "Can\'t reach server";
                                flag = false;
                                break label187;
                            }
                            catch (ConnectException connectexception)
                            {
                                this.field_78318_a.field_78844_e = -1L;
                                this.field_78318_a.field_78843_d = EnumChatFormatting.DARK_RED + "Can\'t reach server";
                                flag = false;
                                break label186;
                            }
                            catch (IOException ioexception)
                            {
                                this.field_78318_a.field_78844_e = -1L;
                                this.field_78318_a.field_78843_d = EnumChatFormatting.DARK_RED + "Communication error";
                                flag = false;
                                break label185;
                            }
                            catch (Exception exception)
                            {
                                this.field_78318_a.field_78844_e = -1L;
                                this.field_78318_a.field_78843_d = "ERROR: " + exception.getClass();
                                flag = false;
                                break label184;
                            }
                            finally
                            {
                                if (flag)
                                {
                                    synchronized (GuiMultiplayer.func_74011_h())
                                    {
                                        GuiMultiplayer.func_74018_k();
                                    }
                                }
                            }

                            synchronized (GuiMultiplayer.func_74011_h())
                            {
                                GuiMultiplayer.func_74018_k();
                                return;
                            }
                        }

                        synchronized (GuiMultiplayer.func_74011_h())
                        {
                            GuiMultiplayer.func_74018_k();
                            return;
                        }
                    }

                    synchronized (GuiMultiplayer.func_74011_h())
                    {
                        GuiMultiplayer.func_74018_k();
                        return;
                    }
                }

                synchronized (GuiMultiplayer.func_74011_h())
                {
                    GuiMultiplayer.func_74018_k();
                    return;
                }
            }

            synchronized (GuiMultiplayer.func_74011_h())
            {
                GuiMultiplayer.func_74018_k();
                return;
            }
        }

        synchronized (GuiMultiplayer.func_74011_h())
        {
            GuiMultiplayer.func_74018_k();
        }
    }
}
