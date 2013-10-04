package net.minecraft.client.gui.achievement;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class GuiAchievement extends Gui
{
    private static final ResourceLocation field_110331_a = new ResourceLocation("textures/gui/achievement/achievement_background.png");
    private Minecraft field_73856_a;
    private int field_73854_b;
    private int field_73855_c;
    private String field_73852_d;
    private String field_73853_e;
    private Achievement field_73850_f;
    private long field_73851_g;
    private RenderItem field_73858_h;
    private boolean field_73857_j;

    public GuiAchievement(Minecraft p_i1063_1_)
    {
        this.field_73856_a = p_i1063_1_;
        this.field_73858_h = new RenderItem();
    }

    public void func_73846_a(Achievement p_73846_1_)
    {
        this.field_73852_d = I18n.func_135053_a("achievement.get");
        this.field_73853_e = I18n.func_135053_a(p_73846_1_.func_75970_i());
        this.field_73851_g = Minecraft.func_71386_F();
        this.field_73850_f = p_73846_1_;
        this.field_73857_j = false;
    }

    public void func_73848_b(Achievement p_73848_1_)
    {
        this.field_73852_d = I18n.func_135053_a(p_73848_1_.func_75970_i());
        this.field_73853_e = p_73848_1_.func_75989_e();
        this.field_73851_g = Minecraft.func_71386_F() - 2500L;
        this.field_73850_f = p_73848_1_;
        this.field_73857_j = true;
    }

    private void func_73849_b()
    {
        GL11.glViewport(0, 0, this.field_73856_a.field_71443_c, this.field_73856_a.field_71440_d);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        this.field_73854_b = this.field_73856_a.field_71443_c;
        this.field_73855_c = this.field_73856_a.field_71440_d;
        ScaledResolution scaledresolution = new ScaledResolution(this.field_73856_a.field_71474_y, this.field_73856_a.field_71443_c, this.field_73856_a.field_71440_d);
        this.field_73854_b = scaledresolution.func_78326_a();
        this.field_73855_c = scaledresolution.func_78328_b();
        GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, (double)this.field_73854_b, (double)this.field_73855_c, 0.0D, 1000.0D, 3000.0D);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
    }

    public void func_73847_a()
    {
        if (this.field_73850_f != null && this.field_73851_g != 0L)
        {
            double d0 = (double)(Minecraft.func_71386_F() - this.field_73851_g) / 3000.0D;

            if (!this.field_73857_j && (d0 < 0.0D || d0 > 1.0D))
            {
                this.field_73851_g = 0L;
            }
            else
            {
                this.func_73849_b();
                GL11.glDisable(GL11.GL_DEPTH_TEST);
                GL11.glDepthMask(false);
                double d1 = d0 * 2.0D;

                if (d1 > 1.0D)
                {
                    d1 = 2.0D - d1;
                }

                d1 *= 4.0D;
                d1 = 1.0D - d1;

                if (d1 < 0.0D)
                {
                    d1 = 0.0D;
                }

                d1 *= d1;
                d1 *= d1;
                int i = this.field_73854_b - 160;
                int j = 0 - (int)(d1 * 36.0D);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                this.field_73856_a.func_110434_K().func_110577_a(field_110331_a);
                GL11.glDisable(GL11.GL_LIGHTING);
                this.func_73729_b(i, j, 96, 202, 160, 32);

                if (this.field_73857_j)
                {
                    this.field_73856_a.field_71466_p.func_78279_b(this.field_73853_e, i + 30, j + 7, 120, -1);
                }
                else
                {
                    this.field_73856_a.field_71466_p.func_78276_b(this.field_73852_d, i + 30, j + 7, -256);
                    this.field_73856_a.field_71466_p.func_78276_b(this.field_73853_e, i + 30, j + 18, -1);
                }

                RenderHelper.func_74520_c();
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glEnable(GL12.GL_RESCALE_NORMAL);
                GL11.glEnable(GL11.GL_COLOR_MATERIAL);
                GL11.glEnable(GL11.GL_LIGHTING);
                this.field_73858_h.func_82406_b(this.field_73856_a.field_71466_p, this.field_73856_a.func_110434_K(), this.field_73850_f.field_75990_d, i + 8, j + 8);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glDepthMask(true);
                GL11.glEnable(GL11.GL_DEPTH_TEST);
            }
        }
    }
}
