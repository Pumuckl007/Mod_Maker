package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Iterator;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiBeacon extends GuiContainer
{
    private static final ResourceLocation field_110428_t = new ResourceLocation("textures/gui/container/beacon.png");
    private TileEntityBeacon field_82323_o;
    private GuiBeaconButtonConfirm field_82322_p;
    private boolean field_82321_q;

    public GuiBeacon(InventoryPlayer p_i1078_1_, TileEntityBeacon p_i1078_2_)
    {
        super(new ContainerBeacon(p_i1078_1_, p_i1078_2_));
        this.field_82323_o = p_i1078_2_;
        this.field_74194_b = 230;
        this.field_74195_c = 219;
    }

    public void func_73866_w_()
    {
        super.func_73866_w_();
        this.field_73887_h.add(this.field_82322_p = new GuiBeaconButtonConfirm(this, -1, this.field_74198_m + 164, this.field_74197_n + 107));
        this.field_73887_h.add(new GuiBeaconButtonCancel(this, -2, this.field_74198_m + 190, this.field_74197_n + 107));
        this.field_82321_q = true;
        this.field_82322_p.field_73742_g = false;
    }

    public void func_73876_c()
    {
        super.func_73876_c();

        if (this.field_82321_q && this.field_82323_o.func_82130_k() >= 0)
        {
            this.field_82321_q = false;
            int i;
            int j;
            int k;
            int l;
            GuiBeaconButtonPower guibeaconbuttonpower;

            for (int i1 = 0; i1 <= 2; ++i1)
            {
                i = TileEntityBeacon.field_82139_a[i1].length;
                j = i * 22 + (i - 1) * 2;

                for (k = 0; k < i; ++k)
                {
                    l = TileEntityBeacon.field_82139_a[i1][k].field_76415_H;
                    guibeaconbuttonpower = new GuiBeaconButtonPower(this, i1 << 8 | l, this.field_74198_m + 76 + k * 24 - j / 2, this.field_74197_n + 22 + i1 * 25, l, i1);
                    this.field_73887_h.add(guibeaconbuttonpower);

                    if (i1 >= this.field_82323_o.func_82130_k())
                    {
                        guibeaconbuttonpower.field_73742_g = false;
                    }
                    else if (l == this.field_82323_o.func_82126_i())
                    {
                        guibeaconbuttonpower.func_82254_b(true);
                    }
                }
            }

            byte b0 = 3;
            i = TileEntityBeacon.field_82139_a[b0].length + 1;
            j = i * 22 + (i - 1) * 2;

            for (k = 0; k < i - 1; ++k)
            {
                l = TileEntityBeacon.field_82139_a[b0][k].field_76415_H;
                guibeaconbuttonpower = new GuiBeaconButtonPower(this, b0 << 8 | l, this.field_74198_m + 167 + k * 24 - j / 2, this.field_74197_n + 47, l, b0);
                this.field_73887_h.add(guibeaconbuttonpower);

                if (b0 >= this.field_82323_o.func_82130_k())
                {
                    guibeaconbuttonpower.field_73742_g = false;
                }
                else if (l == this.field_82323_o.func_82132_j())
                {
                    guibeaconbuttonpower.func_82254_b(true);
                }
            }

            if (this.field_82323_o.func_82126_i() > 0)
            {
                GuiBeaconButtonPower guibeaconbuttonpower1 = new GuiBeaconButtonPower(this, b0 << 8 | this.field_82323_o.func_82126_i(), this.field_74198_m + 167 + (i - 1) * 24 - j / 2, this.field_74197_n + 47, this.field_82323_o.func_82126_i(), b0);
                this.field_73887_h.add(guibeaconbuttonpower1);

                if (b0 >= this.field_82323_o.func_82130_k())
                {
                    guibeaconbuttonpower1.field_73742_g = false;
                }
                else if (this.field_82323_o.func_82126_i() == this.field_82323_o.func_82132_j())
                {
                    guibeaconbuttonpower1.func_82254_b(true);
                }
            }
        }

        this.field_82322_p.field_73742_g = this.field_82323_o.func_70301_a(0) != null && this.field_82323_o.func_82126_i() > 0;
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73741_f == -2)
        {
            this.field_73882_e.func_71373_a((GuiScreen)null);
        }
        else if (p_73875_1_.field_73741_f == -1)
        {
            String s = "MC|Beacon";
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);

            try
            {
                dataoutputstream.writeInt(this.field_82323_o.func_82126_i());
                dataoutputstream.writeInt(this.field_82323_o.func_82132_j());
                this.field_73882_e.func_71391_r().func_72552_c(new Packet250CustomPayload(s, bytearrayoutputstream.toByteArray()));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }

            this.field_73882_e.func_71373_a((GuiScreen)null);
        }
        else if (p_73875_1_ instanceof GuiBeaconButtonPower)
        {
            if (((GuiBeaconButtonPower)p_73875_1_).func_82255_b())
            {
                return;
            }

            int i = p_73875_1_.field_73741_f;
            int j = i & 255;
            int k = i >> 8;

            if (k < 3)
            {
                this.field_82323_o.func_82128_d(j);
            }
            else
            {
                this.field_82323_o.func_82127_e(j);
            }

            this.field_73887_h.clear();
            this.func_73866_w_();
            this.func_73876_c();
        }
    }

    protected void func_74189_g(int p_74189_1_, int p_74189_2_)
    {
        RenderHelper.func_74518_a();
        this.func_73732_a(this.field_73886_k, I18n.func_135053_a("tile.beacon.primary"), 62, 10, 14737632);
        this.func_73732_a(this.field_73886_k, I18n.func_135053_a("tile.beacon.secondary"), 169, 10, 14737632);
        Iterator iterator = this.field_73887_h.iterator();

        while (iterator.hasNext())
        {
            GuiButton guibutton = (GuiButton)iterator.next();

            if (guibutton.func_82252_a())
            {
                guibutton.func_82251_b(p_74189_1_ - this.field_74198_m, p_74189_2_ - this.field_74197_n);
                break;
            }
        }

        RenderHelper.func_74520_c();
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110428_t);
        int k = (this.field_73880_f - this.field_74194_b) / 2;
        int l = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(k, l, 0, 0, this.field_74194_b, this.field_74195_c);
        field_74196_a.field_77023_b = 100.0F;
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.func_110434_K(), new ItemStack(Item.field_77817_bH), k + 42, l + 109);
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.func_110434_K(), new ItemStack(Item.field_77702_n), k + 42 + 22, l + 109);
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.func_110434_K(), new ItemStack(Item.field_77717_p), k + 42 + 44, l + 109);
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.func_110434_K(), new ItemStack(Item.field_77703_o), k + 42 + 66, l + 109);
        field_74196_a.field_77023_b = 0.0F;
    }

    static ResourceLocation func_110427_g()
    {
        return field_110428_t;
    }
}
