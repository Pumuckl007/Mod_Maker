package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MinecraftError;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class LoadingScreenRenderer implements IProgressUpdate
{
    private String field_73727_a = "";
    private Minecraft field_73725_b;
    private String field_73726_c = "";
    private long field_73723_d = Minecraft.func_71386_F();
    private boolean field_73724_e;

    public LoadingScreenRenderer(Minecraft p_i1017_1_)
    {
        this.field_73725_b = p_i1017_1_;
    }

    public void func_73721_b(String p_73721_1_)
    {
        this.field_73724_e = false;
        this.func_73722_d(p_73721_1_);
    }

    public void func_73720_a(String p_73720_1_)
    {
        this.field_73724_e = true;
        this.func_73722_d(p_73720_1_);
    }

    public void func_73722_d(String p_73722_1_)
    {
        this.field_73726_c = p_73722_1_;

        if (!this.field_73725_b.field_71425_J)
        {
            if (!this.field_73724_e)
            {
                throw new MinecraftError();
            }
        }
        else
        {
            ScaledResolution scaledresolution = new ScaledResolution(this.field_73725_b.field_71474_y, this.field_73725_b.field_71443_c, this.field_73725_b.field_71440_d);
            GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, scaledresolution.func_78327_c(), scaledresolution.func_78324_d(), 0.0D, 100.0D, 300.0D);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, 0.0F, -200.0F);
        }
    }

    public void func_73719_c(String p_73719_1_)
    {
        if (!this.field_73725_b.field_71425_J)
        {
            if (!this.field_73724_e)
            {
                throw new MinecraftError();
            }
        }
        else
        {
            this.field_73723_d = 0L;
            this.field_73727_a = p_73719_1_;
            this.func_73718_a(-1);
            this.field_73723_d = 0L;
        }
    }

    public void func_73718_a(int p_73718_1_)
    {
        if (!this.field_73725_b.field_71425_J)
        {
            if (!this.field_73724_e)
            {
                throw new MinecraftError();
            }
        }
        else
        {
            long j = Minecraft.func_71386_F();

            if (j - this.field_73723_d >= 100L)
            {
                this.field_73723_d = j;
                ScaledResolution scaledresolution = new ScaledResolution(this.field_73725_b.field_71474_y, this.field_73725_b.field_71443_c, this.field_73725_b.field_71440_d);
                int k = scaledresolution.func_78326_a();
                int l = scaledresolution.func_78328_b();
                GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
                GL11.glMatrixMode(GL11.GL_PROJECTION);
                GL11.glLoadIdentity();
                GL11.glOrtho(0.0D, scaledresolution.func_78327_c(), scaledresolution.func_78324_d(), 0.0D, 100.0D, 300.0D);
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glLoadIdentity();
                GL11.glTranslatef(0.0F, 0.0F, -200.0F);
                GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
                Tessellator tessellator = Tessellator.field_78398_a;
                this.field_73725_b.func_110434_K().func_110577_a(Gui.field_110325_k);
                float f = 32.0F;
                tessellator.func_78382_b();
                tessellator.func_78378_d(4210752);
                tessellator.func_78374_a(0.0D, (double)l, 0.0D, 0.0D, (double)((float)l / f));
                tessellator.func_78374_a((double)k, (double)l, 0.0D, (double)((float)k / f), (double)((float)l / f));
                tessellator.func_78374_a((double)k, 0.0D, 0.0D, (double)((float)k / f), 0.0D);
                tessellator.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
                tessellator.func_78381_a();

                if (p_73718_1_ >= 0)
                {
                    byte b0 = 100;
                    byte b1 = 2;
                    int i1 = k / 2 - b0 / 2;
                    int j1 = l / 2 + 16;
                    GL11.glDisable(GL11.GL_TEXTURE_2D);
                    tessellator.func_78382_b();
                    tessellator.func_78378_d(8421504);
                    tessellator.func_78377_a((double)i1, (double)j1, 0.0D);
                    tessellator.func_78377_a((double)i1, (double)(j1 + b1), 0.0D);
                    tessellator.func_78377_a((double)(i1 + b0), (double)(j1 + b1), 0.0D);
                    tessellator.func_78377_a((double)(i1 + b0), (double)j1, 0.0D);
                    tessellator.func_78378_d(8454016);
                    tessellator.func_78377_a((double)i1, (double)j1, 0.0D);
                    tessellator.func_78377_a((double)i1, (double)(j1 + b1), 0.0D);
                    tessellator.func_78377_a((double)(i1 + p_73718_1_), (double)(j1 + b1), 0.0D);
                    tessellator.func_78377_a((double)(i1 + p_73718_1_), (double)j1, 0.0D);
                    tessellator.func_78381_a();
                    GL11.glEnable(GL11.GL_TEXTURE_2D);
                }

                this.field_73725_b.field_71466_p.func_78261_a(this.field_73726_c, (k - this.field_73725_b.field_71466_p.func_78256_a(this.field_73726_c)) / 2, l / 2 - 4 - 16, 16777215);
                this.field_73725_b.field_71466_p.func_78261_a(this.field_73727_a, (k - this.field_73725_b.field_71466_p.func_78256_a(this.field_73727_a)) / 2, l / 2 - 4 + 8, 16777215);
                Display.update();

                try
                {
                    Thread.yield();
                }
                catch (Exception exception)
                {
                    ;
                }
            }
        }
    }
}
