package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiRepair extends GuiContainer implements ICrafting
{
    private static final ResourceLocation field_110429_t = new ResourceLocation("textures/gui/container/anvil.png");
    private ContainerRepair field_82327_o;
    private GuiTextField field_82326_p;
    private InventoryPlayer field_82325_q;

    public GuiRepair(InventoryPlayer p_i1073_1_, World p_i1073_2_, int p_i1073_3_, int p_i1073_4_, int p_i1073_5_)
    {
        super(new ContainerRepair(p_i1073_1_, p_i1073_2_, p_i1073_3_, p_i1073_4_, p_i1073_5_, Minecraft.func_71410_x().field_71439_g));
        this.field_82325_q = p_i1073_1_;
        this.field_82327_o = (ContainerRepair)this.field_74193_d;
    }

    public void func_73866_w_()
    {
        super.func_73866_w_();
        Keyboard.enableRepeatEvents(true);
        int i = (this.field_73880_f - this.field_74194_b) / 2;
        int j = (this.field_73881_g - this.field_74195_c) / 2;
        this.field_82326_p = new GuiTextField(this.field_73886_k, i + 62, j + 24, 103, 12);
        this.field_82326_p.func_73794_g(-1);
        this.field_82326_p.func_82266_h(-1);
        this.field_82326_p.func_73786_a(false);
        this.field_82326_p.func_73804_f(40);
        this.field_74193_d.func_82847_b(this);
        this.field_74193_d.func_75132_a(this);
    }

    public void func_73874_b()
    {
        super.func_73874_b();
        Keyboard.enableRepeatEvents(false);
        this.field_74193_d.func_82847_b(this);
    }

    protected void func_74189_g(int p_74189_1_, int p_74189_2_)
    {
        GL11.glDisable(GL11.GL_LIGHTING);
        this.field_73886_k.func_78276_b(I18n.func_135053_a("container.repair"), 60, 6, 4210752);

        if (this.field_82327_o.field_82854_e > 0)
        {
            int k = 8453920;
            boolean flag = true;
            String s = I18n.func_135052_a("container.repair.cost", new Object[] {Integer.valueOf(this.field_82327_o.field_82854_e)});

            if (this.field_82327_o.field_82854_e >= 40 && !this.field_73882_e.field_71439_g.field_71075_bZ.field_75098_d)
            {
                s = I18n.func_135053_a("container.repair.expensive");
                k = 16736352;
            }
            else if (!this.field_82327_o.func_75139_a(2).func_75216_d())
            {
                flag = false;
            }
            else if (!this.field_82327_o.func_75139_a(2).func_82869_a(this.field_82325_q.field_70458_d))
            {
                k = 16736352;
            }

            if (flag)
            {
                int l = -16777216 | (k & 16579836) >> 2 | k & -16777216;
                int i1 = this.field_74194_b - 8 - this.field_73886_k.func_78256_a(s);
                byte b0 = 67;

                if (this.field_73886_k.func_82883_a())
                {
                    func_73734_a(i1 - 3, b0 - 2, this.field_74194_b - 7, b0 + 10, -16777216);
                    func_73734_a(i1 - 2, b0 - 1, this.field_74194_b - 8, b0 + 9, -12895429);
                }
                else
                {
                    this.field_73886_k.func_78276_b(s, i1, b0 + 1, l);
                    this.field_73886_k.func_78276_b(s, i1 + 1, b0, l);
                    this.field_73886_k.func_78276_b(s, i1 + 1, b0 + 1, l);
                }

                this.field_73886_k.func_78276_b(s, i1, b0, k);
            }
        }

        GL11.glEnable(GL11.GL_LIGHTING);
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if (this.field_82326_p.func_73802_a(p_73869_1_, p_73869_2_))
        {
            this.func_135015_g();
        }
        else
        {
            super.func_73869_a(p_73869_1_, p_73869_2_);
        }
    }

    private void func_135015_g()
    {
        String s = this.field_82326_p.func_73781_b();
        Slot slot = this.field_82327_o.func_75139_a(0);

        if (slot != null && slot.func_75216_d() && !slot.func_75211_c().func_82837_s() && s.equals(slot.func_75211_c().func_82833_r()))
        {
            s = "";
        }

        this.field_82327_o.func_82850_a(s);
        this.field_73882_e.field_71439_g.field_71174_a.func_72552_c(new Packet250CustomPayload("MC|ItemName", s.getBytes()));
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        this.field_82326_p.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        GL11.glDisable(GL11.GL_LIGHTING);
        this.field_82326_p.func_73795_f();
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110429_t);
        int k = (this.field_73880_f - this.field_74194_b) / 2;
        int l = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(k, l, 0, 0, this.field_74194_b, this.field_74195_c);
        this.func_73729_b(k + 59, l + 20, 0, this.field_74195_c + (this.field_82327_o.func_75139_a(0).func_75216_d() ? 0 : 16), 110, 16);

        if ((this.field_82327_o.func_75139_a(0).func_75216_d() || this.field_82327_o.func_75139_a(1).func_75216_d()) && !this.field_82327_o.func_75139_a(2).func_75216_d())
        {
            this.func_73729_b(k + 99, l + 45, this.field_74194_b, 0, 28, 21);
        }
    }

    public void func_71110_a(Container p_71110_1_, List p_71110_2_)
    {
        this.func_71111_a(p_71110_1_, 0, p_71110_1_.func_75139_a(0).func_75211_c());
    }

    public void func_71111_a(Container p_71111_1_, int p_71111_2_, ItemStack p_71111_3_)
    {
        if (p_71111_2_ == 0)
        {
            this.field_82326_p.func_73782_a(p_71111_3_ == null ? "" : p_71111_3_.func_82833_r());
            this.field_82326_p.func_82265_c(p_71111_3_ != null);

            if (p_71111_3_ != null)
            {
                this.func_135015_g();
            }
        }
    }

    public void func_71112_a(Container p_71112_1_, int p_71112_2_, int p_71112_3_) {}
}
