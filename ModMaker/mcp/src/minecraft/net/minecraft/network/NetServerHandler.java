package net.minecraft.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet103SetSlot;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet107CreativeSetSlot;
import net.minecraft.network.packet.Packet108EnchantItem;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet13PlayerLookMove;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet19EntityAction;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet203AutoComplete;
import net.minecraft.network.packet.Packet204ClientInfo;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet27PlayerInput;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet53BlockChange;
import net.minecraft.network.packet.Packet7UseEntity;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.BanEntry;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.ReportedException;
import net.minecraft.world.WorldServer;
import org.apache.commons.lang3.StringUtils;

public class NetServerHandler extends NetHandler
{
    public final INetworkManager field_72575_b;
    private final MinecraftServer field_72573_d;
    public boolean field_72576_c;
    public EntityPlayerMP field_72574_e;
    private int field_72571_f;
    public int field_72572_g;
    private boolean field_72584_h;
    private int field_72585_i;
    private long field_72582_j;
    private static Random field_72583_k = new Random();
    private long field_72580_l;
    private int field_72581_m;
    private int field_72578_n;
    private double field_72579_o;
    private double field_72589_p;
    private double field_72588_q;
    private boolean field_72587_r = true;
    private IntHashMap field_72586_s = new IntHashMap();

    public NetServerHandler(MinecraftServer p_i1530_1_, INetworkManager p_i1530_2_, EntityPlayerMP p_i1530_3_)
    {
        this.field_72573_d = p_i1530_1_;
        this.field_72575_b = p_i1530_2_;
        p_i1530_2_.func_74425_a(this);
        this.field_72574_e = p_i1530_3_;
        p_i1530_3_.field_71135_a = this;
    }

    public void func_72570_d()
    {
        this.field_72584_h = false;
        ++this.field_72571_f;
        this.field_72573_d.field_71304_b.func_76320_a("packetflow");
        this.field_72575_b.func_74428_b();
        this.field_72573_d.field_71304_b.func_76318_c("keepAlive");

        if ((long)this.field_72571_f - this.field_72580_l > 20L)
        {
            this.field_72580_l = (long)this.field_72571_f;
            this.field_72582_j = System.nanoTime() / 1000000L;
            this.field_72585_i = field_72583_k.nextInt();
            this.func_72567_b(new Packet0KeepAlive(this.field_72585_i));
        }

        if (this.field_72581_m > 0)
        {
            --this.field_72581_m;
        }

        if (this.field_72578_n > 0)
        {
            --this.field_72578_n;
        }

        this.field_72573_d.field_71304_b.func_76318_c("playerTick");
        this.field_72573_d.field_71304_b.func_76319_b();
    }

    public void func_72565_c(String p_72565_1_)
    {
        if (!this.field_72576_c)
        {
            this.field_72574_e.func_71123_m();
            this.func_72567_b(new Packet255KickDisconnect(p_72565_1_));
            this.field_72575_b.func_74423_d();
            this.field_72573_d.func_71203_ab().func_92062_k(ChatMessageComponent.func_111082_b("multiplayer.player.left", new Object[] {this.field_72574_e.func_96090_ax()}).func_111059_a(EnumChatFormatting.YELLOW));
            this.field_72573_d.func_71203_ab().func_72367_e(this.field_72574_e);
            this.field_72576_c = true;
        }
    }

    public void func_110774_a(Packet27PlayerInput p_110774_1_)
    {
        this.field_72574_e.func_110430_a(p_110774_1_.func_111010_d(), p_110774_1_.func_111012_f(), p_110774_1_.func_111013_g(), p_110774_1_.func_111011_h());
    }

    public void func_72498_a(Packet10Flying p_72498_1_)
    {
        WorldServer worldserver = this.field_72573_d.func_71218_a(this.field_72574_e.field_71093_bK);
        this.field_72584_h = true;

        if (!this.field_72574_e.field_71136_j)
        {
            double d0;

            if (!this.field_72587_r)
            {
                d0 = p_72498_1_.field_73543_b - this.field_72589_p;

                if (p_72498_1_.field_73545_a == this.field_72579_o && d0 * d0 < 0.01D && p_72498_1_.field_73544_c == this.field_72588_q)
                {
                    this.field_72587_r = true;
                }
            }

            if (this.field_72587_r)
            {
                double d1;
                double d2;
                double d3;

                if (this.field_72574_e.field_70154_o != null)
                {
                    float f = this.field_72574_e.field_70177_z;
                    float f1 = this.field_72574_e.field_70125_A;
                    this.field_72574_e.field_70154_o.func_70043_V();
                    d1 = this.field_72574_e.field_70165_t;
                    d2 = this.field_72574_e.field_70163_u;
                    d3 = this.field_72574_e.field_70161_v;

                    if (p_72498_1_.field_73547_i)
                    {
                        f = p_72498_1_.field_73542_e;
                        f1 = p_72498_1_.field_73539_f;
                    }

                    this.field_72574_e.field_70122_E = p_72498_1_.field_73540_g;
                    this.field_72574_e.func_71127_g();
                    this.field_72574_e.field_70139_V = 0.0F;
                    this.field_72574_e.func_70080_a(d1, d2, d3, f, f1);

                    if (this.field_72574_e.field_70154_o != null)
                    {
                        this.field_72574_e.field_70154_o.func_70043_V();
                    }

                    this.field_72573_d.func_71203_ab().func_72358_d(this.field_72574_e);

                    if (this.field_72587_r)
                    {
                        this.field_72579_o = this.field_72574_e.field_70165_t;
                        this.field_72589_p = this.field_72574_e.field_70163_u;
                        this.field_72588_q = this.field_72574_e.field_70161_v;
                    }

                    worldserver.func_72870_g(this.field_72574_e);
                    return;
                }

                if (this.field_72574_e.func_70608_bn())
                {
                    this.field_72574_e.func_71127_g();
                    this.field_72574_e.func_70080_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, this.field_72574_e.field_70177_z, this.field_72574_e.field_70125_A);
                    worldserver.func_72870_g(this.field_72574_e);
                    return;
                }

                d0 = this.field_72574_e.field_70163_u;
                this.field_72579_o = this.field_72574_e.field_70165_t;
                this.field_72589_p = this.field_72574_e.field_70163_u;
                this.field_72588_q = this.field_72574_e.field_70161_v;
                d1 = this.field_72574_e.field_70165_t;
                d2 = this.field_72574_e.field_70163_u;
                d3 = this.field_72574_e.field_70161_v;
                float f2 = this.field_72574_e.field_70177_z;
                float f3 = this.field_72574_e.field_70125_A;

                if (p_72498_1_.field_73546_h && p_72498_1_.field_73543_b == -999.0D && p_72498_1_.field_73541_d == -999.0D)
                {
                    p_72498_1_.field_73546_h = false;
                }

                double d4;

                if (p_72498_1_.field_73546_h)
                {
                    d1 = p_72498_1_.field_73545_a;
                    d2 = p_72498_1_.field_73543_b;
                    d3 = p_72498_1_.field_73544_c;
                    d4 = p_72498_1_.field_73541_d - p_72498_1_.field_73543_b;

                    if (!this.field_72574_e.func_70608_bn() && (d4 > 1.65D || d4 < 0.1D))
                    {
                        this.func_72565_c("Illegal stance");
                        this.field_72573_d.func_98033_al().func_98236_b(this.field_72574_e.func_70005_c_() + " had an illegal stance: " + d4);
                        return;
                    }

                    if (Math.abs(p_72498_1_.field_73545_a) > 3.2E7D || Math.abs(p_72498_1_.field_73544_c) > 3.2E7D)
                    {
                        this.func_72565_c("Illegal position");
                        return;
                    }
                }

                if (p_72498_1_.field_73547_i)
                {
                    f2 = p_72498_1_.field_73542_e;
                    f3 = p_72498_1_.field_73539_f;
                }

                this.field_72574_e.func_71127_g();
                this.field_72574_e.field_70139_V = 0.0F;
                this.field_72574_e.func_70080_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, f2, f3);

                if (!this.field_72587_r)
                {
                    return;
                }

                d4 = d1 - this.field_72574_e.field_70165_t;
                double d5 = d2 - this.field_72574_e.field_70163_u;
                double d6 = d3 - this.field_72574_e.field_70161_v;
                double d7 = Math.min(Math.abs(d4), Math.abs(this.field_72574_e.field_70159_w));
                double d8 = Math.min(Math.abs(d5), Math.abs(this.field_72574_e.field_70181_x));
                double d9 = Math.min(Math.abs(d6), Math.abs(this.field_72574_e.field_70179_y));
                double d10 = d7 * d7 + d8 * d8 + d9 * d9;

                if (d10 > 100.0D && (!this.field_72573_d.func_71264_H() || !this.field_72573_d.func_71214_G().equals(this.field_72574_e.func_70005_c_())))
                {
                    this.field_72573_d.func_98033_al().func_98236_b(this.field_72574_e.func_70005_c_() + " moved too quickly! " + d4 + "," + d5 + "," + d6 + " (" + d7 + ", " + d8 + ", " + d9 + ")");
                    this.func_72569_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, this.field_72574_e.field_70177_z, this.field_72574_e.field_70125_A);
                    return;
                }

                float f4 = 0.0625F;
                boolean flag = worldserver.func_72945_a(this.field_72574_e, this.field_72574_e.field_70121_D.func_72329_c().func_72331_e((double)f4, (double)f4, (double)f4)).isEmpty();

                if (this.field_72574_e.field_70122_E && !p_72498_1_.field_73540_g && d5 > 0.0D)
                {
                    this.field_72574_e.func_71020_j(0.2F);
                }

                this.field_72574_e.func_70091_d(d4, d5, d6);
                this.field_72574_e.field_70122_E = p_72498_1_.field_73540_g;
                this.field_72574_e.func_71000_j(d4, d5, d6);
                double d11 = d5;
                d4 = d1 - this.field_72574_e.field_70165_t;
                d5 = d2 - this.field_72574_e.field_70163_u;

                if (d5 > -0.5D || d5 < 0.5D)
                {
                    d5 = 0.0D;
                }

                d6 = d3 - this.field_72574_e.field_70161_v;
                d10 = d4 * d4 + d5 * d5 + d6 * d6;
                boolean flag1 = false;

                if (d10 > 0.0625D && !this.field_72574_e.func_70608_bn() && !this.field_72574_e.field_71134_c.func_73083_d())
                {
                    flag1 = true;
                    this.field_72573_d.func_98033_al().func_98236_b(this.field_72574_e.func_70005_c_() + " moved wrongly!");
                }

                this.field_72574_e.func_70080_a(d1, d2, d3, f2, f3);
                boolean flag2 = worldserver.func_72945_a(this.field_72574_e, this.field_72574_e.field_70121_D.func_72329_c().func_72331_e((double)f4, (double)f4, (double)f4)).isEmpty();

                if (flag && (flag1 || !flag2) && !this.field_72574_e.func_70608_bn())
                {
                    this.func_72569_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, f2, f3);
                    return;
                }

                AxisAlignedBB axisalignedbb = this.field_72574_e.field_70121_D.func_72329_c().func_72314_b((double)f4, (double)f4, (double)f4).func_72321_a(0.0D, -0.55D, 0.0D);

                if (!this.field_72573_d.func_71231_X() && !this.field_72574_e.field_71134_c.func_73083_d() && !worldserver.func_72829_c(axisalignedbb))
                {
                    if (d11 >= -0.03125D)
                    {
                        ++this.field_72572_g;

                        if (this.field_72572_g > 80)
                        {
                            this.field_72573_d.func_98033_al().func_98236_b(this.field_72574_e.func_70005_c_() + " was kicked for floating too long!");
                            this.func_72565_c("Flying is not enabled on this server");
                            return;
                        }
                    }
                }
                else
                {
                    this.field_72572_g = 0;
                }

                this.field_72574_e.field_70122_E = p_72498_1_.field_73540_g;
                this.field_72573_d.func_71203_ab().func_72358_d(this.field_72574_e);
                this.field_72574_e.func_71122_b(this.field_72574_e.field_70163_u - d0, p_72498_1_.field_73540_g);
            }
            else if (this.field_72571_f % 20 == 0)
            {
                this.func_72569_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, this.field_72574_e.field_70177_z, this.field_72574_e.field_70125_A);
            }
        }
    }

    public void func_72569_a(double p_72569_1_, double p_72569_3_, double p_72569_5_, float p_72569_7_, float p_72569_8_)
    {
        this.field_72587_r = false;
        this.field_72579_o = p_72569_1_;
        this.field_72589_p = p_72569_3_;
        this.field_72588_q = p_72569_5_;
        this.field_72574_e.func_70080_a(p_72569_1_, p_72569_3_, p_72569_5_, p_72569_7_, p_72569_8_);
        this.field_72574_e.field_71135_a.func_72567_b(new Packet13PlayerLookMove(p_72569_1_, p_72569_3_ + 1.6200000047683716D, p_72569_3_, p_72569_5_, p_72569_7_, p_72569_8_, false));
    }

    public void func_72510_a(Packet14BlockDig p_72510_1_)
    {
        WorldServer worldserver = this.field_72573_d.func_71218_a(this.field_72574_e.field_71093_bK);
        this.field_72574_e.func_143004_u();

        if (p_72510_1_.field_73342_e == 4)
        {
            this.field_72574_e.func_71040_bB(false);
        }
        else if (p_72510_1_.field_73342_e == 3)
        {
            this.field_72574_e.func_71040_bB(true);
        }
        else if (p_72510_1_.field_73342_e == 5)
        {
            this.field_72574_e.func_71034_by();
        }
        else
        {
            boolean flag = false;

            if (p_72510_1_.field_73342_e == 0)
            {
                flag = true;
            }

            if (p_72510_1_.field_73342_e == 1)
            {
                flag = true;
            }

            if (p_72510_1_.field_73342_e == 2)
            {
                flag = true;
            }

            int i = p_72510_1_.field_73345_a;
            int j = p_72510_1_.field_73343_b;
            int k = p_72510_1_.field_73344_c;

            if (flag)
            {
                double d0 = this.field_72574_e.field_70165_t - ((double)i + 0.5D);
                double d1 = this.field_72574_e.field_70163_u - ((double)j + 0.5D) + 1.5D;
                double d2 = this.field_72574_e.field_70161_v - ((double)k + 0.5D);
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;

                if (d3 > 36.0D)
                {
                    return;
                }

                if (j >= this.field_72573_d.func_71207_Z())
                {
                    return;
                }
            }

            if (p_72510_1_.field_73342_e == 0)
            {
                if (!this.field_72573_d.func_96290_a(worldserver, i, j, k, this.field_72574_e))
                {
                    this.field_72574_e.field_71134_c.func_73074_a(i, j, k, p_72510_1_.field_73341_d);
                }
                else
                {
                    this.field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(i, j, k, worldserver));
                }
            }
            else if (p_72510_1_.field_73342_e == 2)
            {
                this.field_72574_e.field_71134_c.func_73082_a(i, j, k);

                if (worldserver.func_72798_a(i, j, k) != 0)
                {
                    this.field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(i, j, k, worldserver));
                }
            }
            else if (p_72510_1_.field_73342_e == 1)
            {
                this.field_72574_e.field_71134_c.func_73073_c(i, j, k);

                if (worldserver.func_72798_a(i, j, k) != 0)
                {
                    this.field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(i, j, k, worldserver));
                }
            }
        }
    }

    public void func_72472_a(Packet15Place p_72472_1_)
    {
        WorldServer worldserver = this.field_72573_d.func_71218_a(this.field_72574_e.field_71093_bK);
        ItemStack itemstack = this.field_72574_e.field_71071_by.func_70448_g();
        boolean flag = false;
        int i = p_72472_1_.func_73403_d();
        int j = p_72472_1_.func_73402_f();
        int k = p_72472_1_.func_73407_g();
        int l = p_72472_1_.func_73401_h();
        this.field_72574_e.func_143004_u();

        if (p_72472_1_.func_73401_h() == 255)
        {
            if (itemstack == null)
            {
                return;
            }

            this.field_72574_e.field_71134_c.func_73085_a(this.field_72574_e, worldserver, itemstack);
        }
        else if (p_72472_1_.func_73402_f() >= this.field_72573_d.func_71207_Z() - 1 && (p_72472_1_.func_73401_h() == 1 || p_72472_1_.func_73402_f() >= this.field_72573_d.func_71207_Z()))
        {
            this.field_72574_e.field_71135_a.func_72567_b(new Packet3Chat(ChatMessageComponent.func_111082_b("build.tooHigh", new Object[] {Integer.valueOf(this.field_72573_d.func_71207_Z())}).func_111059_a(EnumChatFormatting.RED)));
            flag = true;
        }
        else
        {
            if (this.field_72587_r && this.field_72574_e.func_70092_e((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D) < 64.0D && !this.field_72573_d.func_96290_a(worldserver, i, j, k, this.field_72574_e))
            {
                this.field_72574_e.field_71134_c.func_73078_a(this.field_72574_e, worldserver, itemstack, i, j, k, l, p_72472_1_.func_73406_j(), p_72472_1_.func_73404_l(), p_72472_1_.func_73408_m());
            }

            flag = true;
        }

        if (flag)
        {
            this.field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(i, j, k, worldserver));

            if (l == 0)
            {
                --j;
            }

            if (l == 1)
            {
                ++j;
            }

            if (l == 2)
            {
                --k;
            }

            if (l == 3)
            {
                ++k;
            }

            if (l == 4)
            {
                --i;
            }

            if (l == 5)
            {
                ++i;
            }

            this.field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(i, j, k, worldserver));
        }

        itemstack = this.field_72574_e.field_71071_by.func_70448_g();

        if (itemstack != null && itemstack.field_77994_a == 0)
        {
            this.field_72574_e.field_71071_by.field_70462_a[this.field_72574_e.field_71071_by.field_70461_c] = null;
            itemstack = null;
        }

        if (itemstack == null || itemstack.func_77988_m() == 0)
        {
            this.field_72574_e.field_71137_h = true;
            this.field_72574_e.field_71071_by.field_70462_a[this.field_72574_e.field_71071_by.field_70461_c] = ItemStack.func_77944_b(this.field_72574_e.field_71071_by.field_70462_a[this.field_72574_e.field_71071_by.field_70461_c]);
            Slot slot = this.field_72574_e.field_71070_bA.func_75147_a(this.field_72574_e.field_71071_by, this.field_72574_e.field_71071_by.field_70461_c);
            this.field_72574_e.field_71070_bA.func_75142_b();
            this.field_72574_e.field_71137_h = false;

            if (!ItemStack.func_77989_b(this.field_72574_e.field_71071_by.func_70448_g(), p_72472_1_.func_73405_i()))
            {
                this.func_72567_b(new Packet103SetSlot(this.field_72574_e.field_71070_bA.field_75152_c, slot.field_75222_d, this.field_72574_e.field_71071_by.func_70448_g()));
            }
        }
    }

    public void func_72515_a(String p_72515_1_, Object[] p_72515_2_)
    {
        this.field_72573_d.func_98033_al().func_98233_a(this.field_72574_e.func_70005_c_() + " lost connection: " + p_72515_1_);
        this.field_72573_d.func_71203_ab().func_92062_k(ChatMessageComponent.func_111082_b("multiplayer.player.left", new Object[] {this.field_72574_e.func_96090_ax()}).func_111059_a(EnumChatFormatting.YELLOW));
        this.field_72573_d.func_71203_ab().func_72367_e(this.field_72574_e);
        this.field_72576_c = true;

        if (this.field_72573_d.func_71264_H() && this.field_72574_e.func_70005_c_().equals(this.field_72573_d.func_71214_G()))
        {
            this.field_72573_d.func_98033_al().func_98233_a("Stopping singleplayer server as player logged out");
            this.field_72573_d.func_71263_m();
        }
    }

    public void func_72509_a(Packet p_72509_1_)
    {
        this.field_72573_d.func_98033_al().func_98236_b(this.getClass() + " wasn\'t prepared to deal with a " + p_72509_1_.getClass());
        this.func_72565_c("Protocol error, unexpected packet");
    }

    public void func_72567_b(Packet p_72567_1_)
    {
        if (p_72567_1_ instanceof Packet3Chat)
        {
            Packet3Chat packet3chat = (Packet3Chat)p_72567_1_;
            int i = this.field_72574_e.func_71126_v();

            if (i == 2)
            {
                return;
            }

            if (i == 1 && !packet3chat.func_73475_d())
            {
                return;
            }
        }

        try
        {
            this.field_72575_b.func_74429_a(p_72567_1_);
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.func_85055_a(throwable, "Sending packet");
            CrashReportCategory crashreportcategory = crashreport.func_85058_a("Packet being sent");
            crashreportcategory.func_71500_a("Packet ID", new CallablePacketID(this, p_72567_1_));
            crashreportcategory.func_71500_a("Packet class", new CallablePacketClass(this, p_72567_1_));
            throw new ReportedException(crashreport);
        }
    }

    public void func_72502_a(Packet16BlockItemSwitch p_72502_1_)
    {
        if (p_72502_1_.field_73386_a >= 0 && p_72502_1_.field_73386_a < InventoryPlayer.func_70451_h())
        {
            this.field_72574_e.field_71071_by.field_70461_c = p_72502_1_.field_73386_a;
            this.field_72574_e.func_143004_u();
        }
        else
        {
            this.field_72573_d.func_98033_al().func_98236_b(this.field_72574_e.func_70005_c_() + " tried to set an invalid carried item");
        }
    }

    public void func_72481_a(Packet3Chat p_72481_1_)
    {
        if (this.field_72574_e.func_71126_v() == 2)
        {
            this.func_72567_b(new Packet3Chat(ChatMessageComponent.func_111077_e("chat.cannotSend").func_111059_a(EnumChatFormatting.RED)));
        }
        else
        {
            this.field_72574_e.func_143004_u();
            String s = p_72481_1_.field_73476_b;

            if (s.length() > 100)
            {
                this.func_72565_c("Chat message too long");
            }
            else
            {
                s = StringUtils.normalizeSpace(s);

                for (int i = 0; i < s.length(); ++i)
                {
                    if (!ChatAllowedCharacters.func_71566_a(s.charAt(i)))
                    {
                        this.func_72565_c("Illegal characters in chat");
                        return;
                    }
                }

                if (s.startsWith("/"))
                {
                    this.func_72566_d(s);
                }
                else
                {
                    if (this.field_72574_e.func_71126_v() == 1)
                    {
                        this.func_72567_b(new Packet3Chat(ChatMessageComponent.func_111077_e("chat.cannotSend").func_111059_a(EnumChatFormatting.RED)));
                        return;
                    }

                    ChatMessageComponent chatmessagecomponent = ChatMessageComponent.func_111082_b("chat.type.text", new Object[] {this.field_72574_e.func_96090_ax(), s});
                    this.field_72573_d.func_71203_ab().func_110459_a(chatmessagecomponent, false);
                }

                this.field_72581_m += 20;

                if (this.field_72581_m > 200 && !this.field_72573_d.func_71203_ab().func_72353_e(this.field_72574_e.func_70005_c_()))
                {
                    this.func_72565_c("disconnect.spam");
                }
            }
        }
    }

    private void func_72566_d(String p_72566_1_)
    {
        this.field_72573_d.func_71187_D().func_71556_a(this.field_72574_e, p_72566_1_);
    }

    public void func_72524_a(Packet18Animation p_72524_1_)
    {
        this.field_72574_e.func_143004_u();

        if (p_72524_1_.field_73469_b == 1)
        {
            this.field_72574_e.func_71038_i();
        }
    }

    public void func_72473_a(Packet19EntityAction p_72473_1_)
    {
        this.field_72574_e.func_143004_u();

        if (p_72473_1_.field_73366_b == 1)
        {
            this.field_72574_e.func_70095_a(true);
        }
        else if (p_72473_1_.field_73366_b == 2)
        {
            this.field_72574_e.func_70095_a(false);
        }
        else if (p_72473_1_.field_73366_b == 4)
        {
            this.field_72574_e.func_70031_b(true);
        }
        else if (p_72473_1_.field_73366_b == 5)
        {
            this.field_72574_e.func_70031_b(false);
        }
        else if (p_72473_1_.field_73366_b == 3)
        {
            this.field_72574_e.func_70999_a(false, true, true);
            this.field_72587_r = false;
        }
        else if (p_72473_1_.field_73366_b == 6)
        {
            if (this.field_72574_e.field_70154_o != null && this.field_72574_e.field_70154_o instanceof EntityHorse)
            {
                ((EntityHorse)this.field_72574_e.field_70154_o).func_110206_u(p_72473_1_.field_111009_c);
            }
        }
        else if (p_72473_1_.field_73366_b == 7 && this.field_72574_e.field_70154_o != null && this.field_72574_e.field_70154_o instanceof EntityHorse)
        {
            ((EntityHorse)this.field_72574_e.field_70154_o).func_110199_f(this.field_72574_e);
        }
    }

    public void func_72492_a(Packet255KickDisconnect p_72492_1_)
    {
        this.field_72575_b.func_74424_a("disconnect.quitting", new Object[0]);
    }

    public int func_72568_e()
    {
        return this.field_72575_b.func_74426_e();
    }

    public void func_72507_a(Packet7UseEntity p_72507_1_)
    {
        WorldServer worldserver = this.field_72573_d.func_71218_a(this.field_72574_e.field_71093_bK);
        Entity entity = worldserver.func_73045_a(p_72507_1_.field_73604_b);
        this.field_72574_e.func_143004_u();

        if (entity != null)
        {
            boolean flag = this.field_72574_e.func_70685_l(entity);
            double d0 = 36.0D;

            if (!flag)
            {
                d0 = 9.0D;
            }

            if (this.field_72574_e.func_70068_e(entity) < d0)
            {
                if (p_72507_1_.field_73605_c == 0)
                {
                    this.field_72574_e.func_70998_m(entity);
                }
                else if (p_72507_1_.field_73605_c == 1)
                {
                    if (entity instanceof EntityItem || entity instanceof EntityXPOrb || entity instanceof EntityArrow || entity == this.field_72574_e)
                    {
                        this.func_72565_c("Attempting to attack an invalid entity");
                        this.field_72573_d.func_71236_h("Player " + this.field_72574_e.func_70005_c_() + " tried to attack an invalid entity");
                        return;
                    }

                    this.field_72574_e.func_71059_n(entity);
                }
            }
        }
    }

    public void func_72458_a(Packet205ClientCommand p_72458_1_)
    {
        this.field_72574_e.func_143004_u();

        if (p_72458_1_.field_73447_a == 1)
        {
            if (this.field_72574_e.field_71136_j)
            {
                this.field_72574_e = this.field_72573_d.func_71203_ab().func_72368_a(this.field_72574_e, 0, true);
            }
            else if (this.field_72574_e.func_71121_q().func_72912_H().func_76093_s())
            {
                if (this.field_72573_d.func_71264_H() && this.field_72574_e.func_70005_c_().equals(this.field_72573_d.func_71214_G()))
                {
                    this.field_72574_e.field_71135_a.func_72565_c("You have died. Game over, man, it\'s game over!");
                    this.field_72573_d.func_71272_O();
                }
                else
                {
                    BanEntry banentry = new BanEntry(this.field_72574_e.func_70005_c_());
                    banentry.func_73689_b("Death in Hardcore");
                    this.field_72573_d.func_71203_ab().func_72390_e().func_73706_a(banentry);
                    this.field_72574_e.field_71135_a.func_72565_c("You have died. Game over, man, it\'s game over!");
                }
            }
            else
            {
                if (this.field_72574_e.func_110143_aJ() > 0.0F)
                {
                    return;
                }

                this.field_72574_e = this.field_72573_d.func_71203_ab().func_72368_a(this.field_72574_e, 0, false);
            }
        }
    }

    public boolean func_72469_b()
    {
        return true;
    }

    public void func_72483_a(Packet9Respawn p_72483_1_) {}

    public void func_72474_a(Packet101CloseWindow p_72474_1_)
    {
        this.field_72574_e.func_71128_l();
    }

    public void func_72523_a(Packet102WindowClick p_72523_1_)
    {
        this.field_72574_e.func_143004_u();

        if (this.field_72574_e.field_71070_bA.field_75152_c == p_72523_1_.field_73444_a && this.field_72574_e.field_71070_bA.func_75129_b(this.field_72574_e))
        {
            ItemStack itemstack = this.field_72574_e.field_71070_bA.func_75144_a(p_72523_1_.field_73442_b, p_72523_1_.field_73443_c, p_72523_1_.field_73439_f, this.field_72574_e);

            if (ItemStack.func_77989_b(p_72523_1_.field_73441_e, itemstack))
            {
                this.field_72574_e.field_71135_a.func_72567_b(new Packet106Transaction(p_72523_1_.field_73444_a, p_72523_1_.field_73440_d, true));
                this.field_72574_e.field_71137_h = true;
                this.field_72574_e.field_71070_bA.func_75142_b();
                this.field_72574_e.func_71113_k();
                this.field_72574_e.field_71137_h = false;
            }
            else
            {
                this.field_72586_s.func_76038_a(this.field_72574_e.field_71070_bA.field_75152_c, Short.valueOf(p_72523_1_.field_73440_d));
                this.field_72574_e.field_71135_a.func_72567_b(new Packet106Transaction(p_72523_1_.field_73444_a, p_72523_1_.field_73440_d, false));
                this.field_72574_e.field_71070_bA.func_75128_a(this.field_72574_e, false);
                ArrayList arraylist = new ArrayList();

                for (int i = 0; i < this.field_72574_e.field_71070_bA.field_75151_b.size(); ++i)
                {
                    arraylist.add(((Slot)this.field_72574_e.field_71070_bA.field_75151_b.get(i)).func_75211_c());
                }

                this.field_72574_e.func_71110_a(this.field_72574_e.field_71070_bA, arraylist);
            }
        }
    }

    public void func_72479_a(Packet108EnchantItem p_72479_1_)
    {
        this.field_72574_e.func_143004_u();

        if (this.field_72574_e.field_71070_bA.field_75152_c == p_72479_1_.field_73446_a && this.field_72574_e.field_71070_bA.func_75129_b(this.field_72574_e))
        {
            this.field_72574_e.field_71070_bA.func_75140_a(this.field_72574_e, p_72479_1_.field_73445_b);
            this.field_72574_e.field_71070_bA.func_75142_b();
        }
    }

    public void func_72464_a(Packet107CreativeSetSlot p_72464_1_)
    {
        if (this.field_72574_e.field_71134_c.func_73083_d())
        {
            boolean flag = p_72464_1_.field_73385_a < 0;
            ItemStack itemstack = p_72464_1_.field_73384_b;
            boolean flag1 = p_72464_1_.field_73385_a >= 1 && p_72464_1_.field_73385_a < 36 + InventoryPlayer.func_70451_h();
            boolean flag2 = itemstack == null || itemstack.field_77993_c < Item.field_77698_e.length && itemstack.field_77993_c >= 0 && Item.field_77698_e[itemstack.field_77993_c] != null;
            boolean flag3 = itemstack == null || itemstack.func_77960_j() >= 0 && itemstack.func_77960_j() >= 0 && itemstack.field_77994_a <= 64 && itemstack.field_77994_a > 0;

            if (flag1 && flag2 && flag3)
            {
                if (itemstack == null)
                {
                    this.field_72574_e.field_71069_bz.func_75141_a(p_72464_1_.field_73385_a, (ItemStack)null);
                }
                else
                {
                    this.field_72574_e.field_71069_bz.func_75141_a(p_72464_1_.field_73385_a, itemstack);
                }

                this.field_72574_e.field_71069_bz.func_75128_a(this.field_72574_e, true);
            }
            else if (flag && flag2 && flag3 && this.field_72578_n < 200)
            {
                this.field_72578_n += 20;
                EntityItem entityitem = this.field_72574_e.func_71021_b(itemstack);

                if (entityitem != null)
                {
                    entityitem.func_70288_d();
                }
            }
        }
    }

    public void func_72476_a(Packet106Transaction p_72476_1_)
    {
        Short oshort = (Short)this.field_72586_s.func_76041_a(this.field_72574_e.field_71070_bA.field_75152_c);

        if (oshort != null && p_72476_1_.field_73433_b == oshort.shortValue() && this.field_72574_e.field_71070_bA.field_75152_c == p_72476_1_.field_73435_a && !this.field_72574_e.field_71070_bA.func_75129_b(this.field_72574_e))
        {
            this.field_72574_e.field_71070_bA.func_75128_a(this.field_72574_e, true);
        }
    }

    public void func_72487_a(Packet130UpdateSign p_72487_1_)
    {
        this.field_72574_e.func_143004_u();
        WorldServer worldserver = this.field_72573_d.func_71218_a(this.field_72574_e.field_71093_bK);

        if (worldserver.func_72899_e(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c))
        {
            TileEntity tileentity = worldserver.func_72796_p(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c);

            if (tileentity instanceof TileEntitySign)
            {
                TileEntitySign tileentitysign = (TileEntitySign)tileentity;

                if (!tileentitysign.func_70409_a() || tileentitysign.func_142009_b() != this.field_72574_e)
                {
                    this.field_72573_d.func_71236_h("Player " + this.field_72574_e.func_70005_c_() + " just tried to change non-editable sign");
                    return;
                }
            }

            int i;
            int j;

            for (j = 0; j < 4; ++j)
            {
                boolean flag = true;

                if (p_72487_1_.field_73308_d[j].length() > 15)
                {
                    flag = false;
                }
                else
                {
                    for (i = 0; i < p_72487_1_.field_73308_d[j].length(); ++i)
                    {
                        if (ChatAllowedCharacters.field_71568_a.indexOf(p_72487_1_.field_73308_d[j].charAt(i)) < 0)
                        {
                            flag = false;
                        }
                    }
                }

                if (!flag)
                {
                    p_72487_1_.field_73308_d[j] = "!?";
                }
            }

            if (tileentity instanceof TileEntitySign)
            {
                j = p_72487_1_.field_73311_a;
                int k = p_72487_1_.field_73309_b;
                i = p_72487_1_.field_73310_c;
                TileEntitySign tileentitysign1 = (TileEntitySign)tileentity;
                System.arraycopy(p_72487_1_.field_73308_d, 0, tileentitysign1.field_70412_a, 0, 4);
                tileentitysign1.func_70296_d();
                worldserver.func_72845_h(j, k, i);
            }
        }
    }

    public void func_72477_a(Packet0KeepAlive p_72477_1_)
    {
        if (p_72477_1_.field_73592_a == this.field_72585_i)
        {
            int i = (int)(System.nanoTime() / 1000000L - this.field_72582_j);
            this.field_72574_e.field_71138_i = (this.field_72574_e.field_71138_i * 3 + i) / 4;
        }
    }

    public boolean func_72489_a()
    {
        return true;
    }

    public void func_72471_a(Packet202PlayerAbilities p_72471_1_)
    {
        this.field_72574_e.field_71075_bZ.field_75100_b = p_72471_1_.func_73350_f() && this.field_72574_e.field_71075_bZ.field_75101_c;
    }

    public void func_72461_a(Packet203AutoComplete p_72461_1_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;

        for (Iterator iterator = this.field_72573_d.func_71248_a(this.field_72574_e, p_72461_1_.func_73473_d()).iterator(); iterator.hasNext(); stringbuilder.append(s))
        {
            s = (String)iterator.next();

            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("\u0000");
            }
        }

        this.field_72574_e.field_71135_a.func_72567_b(new Packet203AutoComplete(stringbuilder.toString()));
    }

    public void func_72504_a(Packet204ClientInfo p_72504_1_)
    {
        this.field_72574_e.func_71125_a(p_72504_1_);
    }

    public void func_72501_a(Packet250CustomPayload p_72501_1_)
    {
        DataInputStream datainputstream;
        ItemStack itemstack;
        ItemStack itemstack1;

        if ("MC|BEdit".equals(p_72501_1_.field_73630_a))
        {
            try
            {
                datainputstream = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
                itemstack = Packet.func_73276_c(datainputstream);

                if (!ItemWritableBook.func_77829_a(itemstack.func_77978_p()))
                {
                    throw new IOException("Invalid book tag!");
                }

                itemstack1 = this.field_72574_e.field_71071_by.func_70448_g();

                if (itemstack != null && itemstack.field_77993_c == Item.field_77821_bF.field_77779_bT && itemstack.field_77993_c == itemstack1.field_77993_c)
                {
                    itemstack1.func_77983_a("pages", itemstack.func_77978_p().func_74761_m("pages"));
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        else if ("MC|BSign".equals(p_72501_1_.field_73630_a))
        {
            try
            {
                datainputstream = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
                itemstack = Packet.func_73276_c(datainputstream);

                if (!ItemEditableBook.func_77828_a(itemstack.func_77978_p()))
                {
                    throw new IOException("Invalid book tag!");
                }

                itemstack1 = this.field_72574_e.field_71071_by.func_70448_g();

                if (itemstack != null && itemstack.field_77993_c == Item.field_77823_bG.field_77779_bT && itemstack1.field_77993_c == Item.field_77821_bF.field_77779_bT)
                {
                    itemstack1.func_77983_a("author", new NBTTagString("author", this.field_72574_e.func_70005_c_()));
                    itemstack1.func_77983_a("title", new NBTTagString("title", itemstack.func_77978_p().func_74779_i("title")));
                    itemstack1.func_77983_a("pages", itemstack.func_77978_p().func_74761_m("pages"));
                    itemstack1.field_77993_c = Item.field_77823_bG.field_77779_bT;
                }
            }
            catch (Exception exception1)
            {
                exception1.printStackTrace();
            }
        }
        else
        {
            int i;

            if ("MC|TrSel".equals(p_72501_1_.field_73630_a))
            {
                try
                {
                    datainputstream = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
                    i = datainputstream.readInt();
                    Container container = this.field_72574_e.field_71070_bA;

                    if (container instanceof ContainerMerchant)
                    {
                        ((ContainerMerchant)container).func_75175_c(i);
                    }
                }
                catch (Exception exception2)
                {
                    exception2.printStackTrace();
                }
            }
            else
            {
                int j;

                if ("MC|AdvCdm".equals(p_72501_1_.field_73630_a))
                {
                    if (!this.field_72573_d.func_82356_Z())
                    {
                        this.field_72574_e.func_70006_a(ChatMessageComponent.func_111077_e("advMode.notEnabled"));
                    }
                    else if (this.field_72574_e.func_70003_b(2, "") && this.field_72574_e.field_71075_bZ.field_75098_d)
                    {
                        try
                        {
                            datainputstream = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
                            i = datainputstream.readInt();
                            j = datainputstream.readInt();
                            int k = datainputstream.readInt();
                            String s = Packet.func_73282_a(datainputstream, 256);
                            TileEntity tileentity = this.field_72574_e.field_70170_p.func_72796_p(i, j, k);

                            if (tileentity != null && tileentity instanceof TileEntityCommandBlock)
                            {
                                ((TileEntityCommandBlock)tileentity).func_82352_b(s);
                                this.field_72574_e.field_70170_p.func_72845_h(i, j, k);
                                this.field_72574_e.func_70006_a(ChatMessageComponent.func_111082_b("advMode.setCommand.success", new Object[] {s}));
                            }
                        }
                        catch (Exception exception3)
                        {
                            exception3.printStackTrace();
                        }
                    }
                    else
                    {
                        this.field_72574_e.func_70006_a(ChatMessageComponent.func_111077_e("advMode.notAllowed"));
                    }
                }
                else if ("MC|Beacon".equals(p_72501_1_.field_73630_a))
                {
                    if (this.field_72574_e.field_71070_bA instanceof ContainerBeacon)
                    {
                        try
                        {
                            datainputstream = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
                            i = datainputstream.readInt();
                            j = datainputstream.readInt();
                            ContainerBeacon containerbeacon = (ContainerBeacon)this.field_72574_e.field_71070_bA;
                            Slot slot = containerbeacon.func_75139_a(0);

                            if (slot.func_75216_d())
                            {
                                slot.func_75209_a(1);
                                TileEntityBeacon tileentitybeacon = containerbeacon.func_82863_d();
                                tileentitybeacon.func_82128_d(i);
                                tileentitybeacon.func_82127_e(j);
                                tileentitybeacon.func_70296_d();
                            }
                        }
                        catch (Exception exception4)
                        {
                            exception4.printStackTrace();
                        }
                    }
                }
                else if ("MC|ItemName".equals(p_72501_1_.field_73630_a) && this.field_72574_e.field_71070_bA instanceof ContainerRepair)
                {
                    ContainerRepair containerrepair = (ContainerRepair)this.field_72574_e.field_71070_bA;

                    if (p_72501_1_.field_73629_c != null && p_72501_1_.field_73629_c.length >= 1)
                    {
                        String s1 = ChatAllowedCharacters.func_71565_a(new String(p_72501_1_.field_73629_c));

                        if (s1.length() <= 30)
                        {
                            containerrepair.func_82850_a(s1);
                        }
                    }
                    else
                    {
                        containerrepair.func_82850_a("");
                    }
                }
            }
        }
    }

    public boolean func_142032_c()
    {
        return this.field_72576_c;
    }
}
