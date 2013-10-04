package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiScreen extends Gui
{
    protected Minecraft field_73882_e;
    public int field_73880_f;
    public int field_73881_g;
    protected List field_73887_h = new ArrayList();
    public boolean field_73885_j;
    protected FontRenderer field_73886_k;
    private GuiButton field_73883_a;
    private int field_85042_b;
    private long field_85043_c;
    private int field_92018_d;

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        for (int k = 0; k < this.field_73887_h.size(); ++k)
        {
            GuiButton guibutton = (GuiButton)this.field_73887_h.get(k);
            guibutton.func_73737_a(this.field_73882_e, p_73863_1_, p_73863_2_);
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if (p_73869_2_ == 1)
        {
            this.field_73882_e.func_71373_a((GuiScreen)null);
            this.field_73882_e.func_71381_h();
        }
    }

    public static String func_73870_l()
    {
        try
        {
            Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents((Object)null);

            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor))
            {
                return (String)transferable.getTransferData(DataFlavor.stringFlavor);
            }
        }
        catch (Exception exception)
        {
            ;
        }

        return "";
    }

    public static void func_73865_d(String p_73865_0_)
    {
        try
        {
            StringSelection stringselection = new StringSelection(p_73865_0_);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, (ClipboardOwner)null);
        }
        catch (Exception exception)
        {
            ;
        }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        if (p_73864_3_ == 0)
        {
            for (int l = 0; l < this.field_73887_h.size(); ++l)
            {
                GuiButton guibutton = (GuiButton)this.field_73887_h.get(l);

                if (guibutton.func_73736_c(this.field_73882_e, p_73864_1_, p_73864_2_))
                {
                    this.field_73883_a = guibutton;
                    this.field_73882_e.field_71416_A.func_77366_a("random.click", 1.0F, 1.0F);
                    this.func_73875_a(guibutton);
                }
            }
        }
    }

    protected void func_73879_b(int p_73879_1_, int p_73879_2_, int p_73879_3_)
    {
        if (this.field_73883_a != null && p_73879_3_ == 0)
        {
            this.field_73883_a.func_73740_a(p_73879_1_, p_73879_2_);
            this.field_73883_a = null;
        }
    }

    protected void func_85041_a(int p_85041_1_, int p_85041_2_, int p_85041_3_, long p_85041_4_) {}

    protected void func_73875_a(GuiButton p_73875_1_) {}

    public void func_73872_a(Minecraft p_73872_1_, int p_73872_2_, int p_73872_3_)
    {
        this.field_73882_e = p_73872_1_;
        this.field_73886_k = p_73872_1_.field_71466_p;
        this.field_73880_f = p_73872_2_;
        this.field_73881_g = p_73872_3_;
        this.field_73887_h.clear();
        this.func_73866_w_();
    }

    public void func_73866_w_() {}

    public void func_73862_m()
    {
        while (Mouse.next())
        {
            this.func_73867_d();
        }

        while (Keyboard.next())
        {
            this.func_73860_n();
        }
    }

    public void func_73867_d()
    {
        int i = Mouse.getEventX() * this.field_73880_f / this.field_73882_e.field_71443_c;
        int j = this.field_73881_g - Mouse.getEventY() * this.field_73881_g / this.field_73882_e.field_71440_d - 1;
        int k = Mouse.getEventButton();

        if (Minecraft.field_142025_a && k == 0 && (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157)))
        {
            k = 1;
        }

        if (Mouse.getEventButtonState())
        {
            if (this.field_73882_e.field_71474_y.field_85185_A && this.field_92018_d++ > 0)
            {
                return;
            }

            this.field_85042_b = k;
            this.field_85043_c = Minecraft.func_71386_F();
            this.func_73864_a(i, j, this.field_85042_b);
        }
        else if (k != -1)
        {
            if (this.field_73882_e.field_71474_y.field_85185_A && --this.field_92018_d > 0)
            {
                return;
            }

            this.field_85042_b = -1;
            this.func_73879_b(i, j, k);
        }
        else if (this.field_85042_b != -1 && this.field_85043_c > 0L)
        {
            long l = Minecraft.func_71386_F() - this.field_85043_c;
            this.func_85041_a(i, j, this.field_85042_b, l);
        }
    }

    public void func_73860_n()
    {
        if (Keyboard.getEventKeyState())
        {
            int i = Keyboard.getEventKey();
            char c0 = Keyboard.getEventCharacter();

            if (i == 87)
            {
                this.field_73882_e.func_71352_k();
                return;
            }

            this.func_73869_a(c0, i);
        }
    }

    public void func_73876_c() {}

    public void func_73874_b() {}

    public void func_73873_v_()
    {
        this.func_73859_b(0);
    }

    public void func_73859_b(int p_73859_1_)
    {
        if (this.field_73882_e.field_71441_e != null)
        {
            this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, -1072689136, -804253680);
        }
        else
        {
            this.func_73871_c(p_73859_1_);
        }
    }

    public void func_73871_c(int p_73871_1_)
    {
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        Tessellator tessellator = Tessellator.field_78398_a;
        this.field_73882_e.func_110434_K().func_110577_a(field_110325_k);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32.0F;
        tessellator.func_78382_b();
        tessellator.func_78378_d(4210752);
        tessellator.func_78374_a(0.0D, (double)this.field_73881_g, 0.0D, 0.0D, (double)((float)this.field_73881_g / f + (float)p_73871_1_));
        tessellator.func_78374_a((double)this.field_73880_f, (double)this.field_73881_g, 0.0D, (double)((float)this.field_73880_f / f), (double)((float)this.field_73881_g / f + (float)p_73871_1_));
        tessellator.func_78374_a((double)this.field_73880_f, 0.0D, 0.0D, (double)((float)this.field_73880_f / f), (double)p_73871_1_);
        tessellator.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, (double)p_73871_1_);
        tessellator.func_78381_a();
    }

    public boolean func_73868_f()
    {
        return true;
    }

    public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {}

    public static boolean func_73861_o()
    {
        return Minecraft.field_142025_a ? Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220) : Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
    }

    public static boolean func_73877_p()
    {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }
}
