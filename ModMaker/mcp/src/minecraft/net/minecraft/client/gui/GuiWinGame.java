package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiWinGame extends GuiScreen
{
    private static final ResourceLocation field_110362_a = new ResourceLocation("textures/gui/title/minecraft.png");
    private static final ResourceLocation field_110361_b = new ResourceLocation("textures/misc/vignette.png");
    private int field_73990_a;
    private List field_73988_b;
    private int field_73989_c;
    private float field_73987_d = 0.5F;

    public void func_73876_c()
    {
        ++this.field_73990_a;
        float f = (float)(this.field_73989_c + this.field_73881_g + this.field_73881_g + 24) / this.field_73987_d;

        if ((float)this.field_73990_a > f)
        {
            this.func_73985_g();
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if (p_73869_2_ == 1)
        {
            this.func_73985_g();
        }
    }

    private void func_73985_g()
    {
        this.field_73882_e.field_71439_g.field_71174_a.func_72552_c(new Packet205ClientCommand(1));
        this.field_73882_e.func_71373_a((GuiScreen)null);
    }

    public boolean func_73868_f()
    {
        return true;
    }

    public void func_73866_w_()
    {
        if (this.field_73988_b == null)
        {
            this.field_73988_b = new ArrayList();

            try
            {
                String s = "";
                String s1 = "" + EnumChatFormatting.WHITE + EnumChatFormatting.OBFUSCATED + EnumChatFormatting.GREEN + EnumChatFormatting.AQUA;
                short short1 = 274;
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(this.field_73882_e.func_110442_L().func_110536_a(new ResourceLocation("texts/end.txt")).func_110527_b(), Charsets.UTF_8));
                Random random = new Random(8124371L);
                int i;

                while ((s = bufferedreader.readLine()) != null)
                {
                    String s2;
                    String s3;

                    for (s = s.replaceAll("PLAYERNAME", this.field_73882_e.func_110432_I().func_111285_a()); s.contains(s1); s = s2 + EnumChatFormatting.WHITE + EnumChatFormatting.OBFUSCATED + "XXXXXXXX".substring(0, random.nextInt(4) + 3) + s3)
                    {
                        i = s.indexOf(s1);
                        s2 = s.substring(0, i);
                        s3 = s.substring(i + s1.length());
                    }

                    this.field_73988_b.addAll(this.field_73882_e.field_71466_p.func_78271_c(s, short1));
                    this.field_73988_b.add("");
                }

                for (i = 0; i < 8; ++i)
                {
                    this.field_73988_b.add("");
                }

                bufferedreader = new BufferedReader(new InputStreamReader(this.field_73882_e.func_110442_L().func_110536_a(new ResourceLocation("texts/credits.txt")).func_110527_b(), Charsets.UTF_8));

                while ((s = bufferedreader.readLine()) != null)
                {
                    s = s.replaceAll("PLAYERNAME", this.field_73882_e.func_110432_I().func_111285_a());
                    s = s.replaceAll("\t", "    ");
                    this.field_73988_b.addAll(this.field_73882_e.field_71466_p.func_78271_c(s, short1));
                    this.field_73988_b.add("");
                }

                this.field_73989_c = this.field_73988_b.size() * 12;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    private void func_73986_b(int p_73986_1_, int p_73986_2_, float p_73986_3_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        this.field_73882_e.func_110434_K().func_110577_a(Gui.field_110325_k);
        tessellator.func_78382_b();
        tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
        int k = this.field_73880_f;
        float f1 = 0.0F - ((float)this.field_73990_a + p_73986_3_) * 0.5F * this.field_73987_d;
        float f2 = (float)this.field_73881_g - ((float)this.field_73990_a + p_73986_3_) * 0.5F * this.field_73987_d;
        float f3 = 0.015625F;
        float f4 = ((float)this.field_73990_a + p_73986_3_ - 0.0F) * 0.02F;
        float f5 = (float)(this.field_73989_c + this.field_73881_g + this.field_73881_g + 24) / this.field_73987_d;
        float f6 = (f5 - 20.0F - ((float)this.field_73990_a + p_73986_3_)) * 0.005F;

        if (f6 < f4)
        {
            f4 = f6;
        }

        if (f4 > 1.0F)
        {
            f4 = 1.0F;
        }

        f4 *= f4;
        f4 = f4 * 96.0F / 255.0F;
        tessellator.func_78386_a(f4, f4, f4);
        tessellator.func_78374_a(0.0D, (double)this.field_73881_g, (double)this.field_73735_i, 0.0D, (double)(f1 * f3));
        tessellator.func_78374_a((double)k, (double)this.field_73881_g, (double)this.field_73735_i, (double)((float)k * f3), (double)(f1 * f3));
        tessellator.func_78374_a((double)k, 0.0D, (double)this.field_73735_i, (double)((float)k * f3), (double)(f2 * f3));
        tessellator.func_78374_a(0.0D, 0.0D, (double)this.field_73735_i, 0.0D, (double)(f2 * f3));
        tessellator.func_78381_a();
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.func_73986_b(p_73863_1_, p_73863_2_, p_73863_3_);
        Tessellator tessellator = Tessellator.field_78398_a;
        short short1 = 274;
        int k = this.field_73880_f / 2 - short1 / 2;
        int l = this.field_73881_g + 50;
        float f1 = -((float)this.field_73990_a + p_73863_3_) * this.field_73987_d;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, f1, 0.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110362_a);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.func_73729_b(k, l, 0, 0, 155, 44);
        this.func_73729_b(k + 155, l, 0, 45, 155, 44);
        tessellator.func_78378_d(16777215);
        int i1 = l + 200;
        int j1;

        for (j1 = 0; j1 < this.field_73988_b.size(); ++j1)
        {
            if (j1 == this.field_73988_b.size() - 1)
            {
                float f2 = (float)i1 + f1 - (float)(this.field_73881_g / 2 - 6);

                if (f2 < 0.0F)
                {
                    GL11.glTranslatef(0.0F, -f2, 0.0F);
                }
            }

            if ((float)i1 + f1 + 12.0F + 8.0F > 0.0F && (float)i1 + f1 < (float)this.field_73881_g)
            {
                String s = (String)this.field_73988_b.get(j1);

                if (s.startsWith("[C]"))
                {
                    this.field_73886_k.func_78261_a(s.substring(3), k + (short1 - this.field_73886_k.func_78256_a(s.substring(3))) / 2, i1, 16777215);
                }
                else
                {
                    this.field_73886_k.field_78289_c.setSeed((long)j1 * 4238972211L + (long)(this.field_73990_a / 4));
                    this.field_73886_k.func_78261_a(s, k, i1, 16777215);
                }
            }

            i1 += 12;
        }

        GL11.glPopMatrix();
        this.field_73882_e.func_110434_K().func_110577_a(field_110361_b);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_ZERO, GL11.GL_ONE_MINUS_SRC_COLOR);
        tessellator.func_78382_b();
        tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
        j1 = this.field_73880_f;
        int k1 = this.field_73881_g;
        tessellator.func_78374_a(0.0D, (double)k1, (double)this.field_73735_i, 0.0D, 1.0D);
        tessellator.func_78374_a((double)j1, (double)k1, (double)this.field_73735_i, 1.0D, 1.0D);
        tessellator.func_78374_a((double)j1, 0.0D, (double)this.field_73735_i, 1.0D, 0.0D);
        tessellator.func_78374_a(0.0D, 0.0D, (double)this.field_73735_i, 0.0D, 0.0D);
        tessellator.func_78381_a();
        GL11.glDisable(GL11.GL_BLEND);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
