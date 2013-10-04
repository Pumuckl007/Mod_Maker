package net.minecraft.client.gui.achievement;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class GuiAchievements extends GuiScreen
{
    private static final int field_74122_s = AchievementList.field_76010_a * 24 - 112;
    private static final int field_74121_t = AchievementList.field_76008_b * 24 - 112;
    private static final int field_74120_u = AchievementList.field_76009_c * 24 - 77;
    private static final int field_74119_v = AchievementList.field_76006_d * 24 - 77;
    private static final ResourceLocation field_110406_y = new ResourceLocation("textures/gui/achievement/achievement_background.png");
    protected int field_74114_a = 256;
    protected int field_74112_b = 202;
    protected int field_74113_c;
    protected int field_74111_d;
    protected double field_74117_m;
    protected double field_74115_n;
    protected double field_74116_o;
    protected double field_74125_p;
    protected double field_74124_q;
    protected double field_74123_r;
    private int field_74118_w;
    private StatFileWriter field_74126_x;

    public GuiAchievements(StatFileWriter p_i1064_1_)
    {
        this.field_74126_x = p_i1064_1_;
        short short1 = 141;
        short short2 = 141;
        this.field_74117_m = this.field_74116_o = this.field_74124_q = (double)(AchievementList.field_76004_f.field_75993_a * 24 - short1 / 2 - 12);
        this.field_74115_n = this.field_74125_p = this.field_74123_r = (double)(AchievementList.field_76004_f.field_75991_b * 24 - short2 / 2);
    }

    public void func_73866_w_()
    {
        this.field_73887_h.clear();
        this.field_73887_h.add(new GuiSmallButton(1, this.field_73880_f / 2 + 24, this.field_73881_g / 2 + 74, 80, 20, I18n.func_135053_a("gui.done")));
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73741_f == 1)
        {
            this.field_73882_e.func_71373_a((GuiScreen)null);
            this.field_73882_e.func_71381_h();
        }

        super.func_73875_a(p_73875_1_);
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if (p_73869_2_ == this.field_73882_e.field_71474_y.field_74315_B.field_74512_d)
        {
            this.field_73882_e.func_71373_a((GuiScreen)null);
            this.field_73882_e.func_71381_h();
        }
        else
        {
            super.func_73869_a(p_73869_1_, p_73869_2_);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        if (Mouse.isButtonDown(0))
        {
            int k = (this.field_73880_f - this.field_74114_a) / 2;
            int l = (this.field_73881_g - this.field_74112_b) / 2;
            int i1 = k + 8;
            int j1 = l + 17;

            if ((this.field_74118_w == 0 || this.field_74118_w == 1) && p_73863_1_ >= i1 && p_73863_1_ < i1 + 224 && p_73863_2_ >= j1 && p_73863_2_ < j1 + 155)
            {
                if (this.field_74118_w == 0)
                {
                    this.field_74118_w = 1;
                }
                else
                {
                    this.field_74116_o -= (double)(p_73863_1_ - this.field_74113_c);
                    this.field_74125_p -= (double)(p_73863_2_ - this.field_74111_d);
                    this.field_74124_q = this.field_74117_m = this.field_74116_o;
                    this.field_74123_r = this.field_74115_n = this.field_74125_p;
                }

                this.field_74113_c = p_73863_1_;
                this.field_74111_d = p_73863_2_;
            }

            if (this.field_74124_q < (double)field_74122_s)
            {
                this.field_74124_q = (double)field_74122_s;
            }

            if (this.field_74123_r < (double)field_74121_t)
            {
                this.field_74123_r = (double)field_74121_t;
            }

            if (this.field_74124_q >= (double)field_74120_u)
            {
                this.field_74124_q = (double)(field_74120_u - 1);
            }

            if (this.field_74123_r >= (double)field_74119_v)
            {
                this.field_74123_r = (double)(field_74119_v - 1);
            }
        }
        else
        {
            this.field_74118_w = 0;
        }

        this.func_73873_v_();
        this.func_74110_b(p_73863_1_, p_73863_2_, p_73863_3_);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        this.func_74109_g();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    public void func_73876_c()
    {
        this.field_74117_m = this.field_74116_o;
        this.field_74115_n = this.field_74125_p;
        double d0 = this.field_74124_q - this.field_74116_o;
        double d1 = this.field_74123_r - this.field_74125_p;

        if (d0 * d0 + d1 * d1 < 4.0D)
        {
            this.field_74116_o += d0;
            this.field_74125_p += d1;
        }
        else
        {
            this.field_74116_o += d0 * 0.85D;
            this.field_74125_p += d1 * 0.85D;
        }
    }

    protected void func_74109_g()
    {
        int i = (this.field_73880_f - this.field_74114_a) / 2;
        int j = (this.field_73881_g - this.field_74112_b) / 2;
        this.field_73886_k.func_78276_b("Achievements", i + 15, j + 5, 4210752);
    }

    protected void func_74110_b(int p_74110_1_, int p_74110_2_, float p_74110_3_)
    {
        int k = MathHelper.func_76128_c(this.field_74117_m + (this.field_74116_o - this.field_74117_m) * (double)p_74110_3_);
        int l = MathHelper.func_76128_c(this.field_74115_n + (this.field_74125_p - this.field_74115_n) * (double)p_74110_3_);

        if (k < field_74122_s)
        {
            k = field_74122_s;
        }

        if (l < field_74121_t)
        {
            l = field_74121_t;
        }

        if (k >= field_74120_u)
        {
            k = field_74120_u - 1;
        }

        if (l >= field_74119_v)
        {
            l = field_74119_v - 1;
        }

        int i1 = (this.field_73880_f - this.field_74114_a) / 2;
        int j1 = (this.field_73881_g - this.field_74112_b) / 2;
        int k1 = i1 + 16;
        int l1 = j1 + 17;
        this.field_73735_i = 0.0F;
        GL11.glDepthFunc(GL11.GL_GEQUAL);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -200.0F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        int i2 = k + 288 >> 4;
        int j2 = l + 288 >> 4;
        int k2 = (k + 288) % 16;
        int l2 = (l + 288) % 16;
        boolean flag = true;
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        Random random = new Random();
        int i3;
        int j3;
        int k3;

        for (i3 = 0; i3 * 16 - l2 < 155; ++i3)
        {
            float f1 = 0.6F - (float)(j2 + i3) / 25.0F * 0.3F;
            GL11.glColor4f(f1, f1, f1, 1.0F);

            for (k3 = 0; k3 * 16 - k2 < 224; ++k3)
            {
                random.setSeed((long)(1234 + i2 + k3));
                random.nextInt();
                j3 = random.nextInt(1 + j2 + i3) + (j2 + i3) / 2;
                Icon icon = Block.field_71939_E.func_71858_a(0, 0);

                if (j3 <= 37 && j2 + i3 != 35)
                {
                    if (j3 == 22)
                    {
                        if (random.nextInt(2) == 0)
                        {
                            icon = Block.field_72073_aw.func_71858_a(0, 0);
                        }
                        else
                        {
                            icon = Block.field_72047_aN.func_71858_a(0, 0);
                        }
                    }
                    else if (j3 == 10)
                    {
                        icon = Block.field_71949_H.func_71858_a(0, 0);
                    }
                    else if (j3 == 8)
                    {
                        icon = Block.field_71950_I.func_71858_a(0, 0);
                    }
                    else if (j3 > 4)
                    {
                        icon = Block.field_71981_t.func_71858_a(0, 0);
                    }
                    else if (j3 > 0)
                    {
                        icon = Block.field_71979_v.func_71858_a(0, 0);
                    }
                }
                else
                {
                    icon = Block.field_71986_z.func_71858_a(0, 0);
                }

                this.field_73882_e.func_110434_K().func_110577_a(TextureMap.field_110575_b);
                this.func_94065_a(k1 + k3 * 16 - k2, l1 + i3 * 16 - l2, icon, 16, 16);
            }
        }

        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        int l3;
        int i4;
        int j4;

        for (i3 = 0; i3 < AchievementList.field_76007_e.size(); ++i3)
        {
            Achievement achievement = (Achievement)AchievementList.field_76007_e.get(i3);

            if (achievement.field_75992_c != null)
            {
                k3 = achievement.field_75993_a * 24 - k + 11 + k1;
                j3 = achievement.field_75991_b * 24 - l + 11 + l1;
                j4 = achievement.field_75992_c.field_75993_a * 24 - k + 11 + k1;
                l3 = achievement.field_75992_c.field_75991_b * 24 - l + 11 + l1;
                boolean flag5 = this.field_74126_x.func_77443_a(achievement);
                boolean flag6 = this.field_74126_x.func_77442_b(achievement);
                i4 = Math.sin((double)(Minecraft.func_71386_F() % 600L) / 600.0D * Math.PI * 2.0D) > 0.6D ? 255 : 130;
                int k4 = -16777216;

                if (flag5)
                {
                    k4 = -9408400;
                }
                else if (flag6)
                {
                    k4 = 65280 + (i4 << 24);
                }

                this.func_73730_a(k3, j4, j3, k4);
                this.func_73728_b(j4, j3, l3, k4);
            }
        }

        Achievement achievement1 = null;
        RenderItem renderitem = new RenderItem();
        RenderHelper.func_74520_c();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        int l4;
        int i5;

        for (k3 = 0; k3 < AchievementList.field_76007_e.size(); ++k3)
        {
            Achievement achievement2 = (Achievement)AchievementList.field_76007_e.get(k3);
            j4 = achievement2.field_75993_a * 24 - k;
            l3 = achievement2.field_75991_b * 24 - l;

            if (j4 >= -24 && l3 >= -24 && j4 <= 224 && l3 <= 155)
            {
                float f2;

                if (this.field_74126_x.func_77443_a(achievement2))
                {
                    f2 = 1.0F;
                    GL11.glColor4f(f2, f2, f2, 1.0F);
                }
                else if (this.field_74126_x.func_77442_b(achievement2))
                {
                    f2 = Math.sin((double)(Minecraft.func_71386_F() % 600L) / 600.0D * Math.PI * 2.0D) < 0.6D ? 0.6F : 0.8F;
                    GL11.glColor4f(f2, f2, f2, 1.0F);
                }
                else
                {
                    f2 = 0.3F;
                    GL11.glColor4f(f2, f2, f2, 1.0F);
                }

                this.field_73882_e.func_110434_K().func_110577_a(field_110406_y);
                i5 = k1 + j4;
                l4 = l1 + l3;

                if (achievement2.func_75984_f())
                {
                    this.func_73729_b(i5 - 2, l4 - 2, 26, 202, 26, 26);
                }
                else
                {
                    this.func_73729_b(i5 - 2, l4 - 2, 0, 202, 26, 26);
                }

                if (!this.field_74126_x.func_77442_b(achievement2))
                {
                    float f3 = 0.1F;
                    GL11.glColor4f(f3, f3, f3, 1.0F);
                    renderitem.field_77024_a = false;
                }

                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glEnable(GL11.GL_CULL_FACE);
                renderitem.func_82406_b(this.field_73882_e.field_71466_p, this.field_73882_e.func_110434_K(), achievement2.field_75990_d, i5 + 3, l4 + 3);
                GL11.glDisable(GL11.GL_LIGHTING);

                if (!this.field_74126_x.func_77442_b(achievement2))
                {
                    renderitem.field_77024_a = true;
                }

                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                if (p_74110_1_ >= k1 && p_74110_2_ >= l1 && p_74110_1_ < k1 + 224 && p_74110_2_ < l1 + 155 && p_74110_1_ >= i5 && p_74110_1_ <= i5 + 22 && p_74110_2_ >= l4 && p_74110_2_ <= l4 + 22)
                {
                    achievement1 = achievement2;
                }
            }
        }

        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110406_y);
        this.func_73729_b(i1, j1, 0, 0, this.field_74114_a, this.field_74112_b);
        GL11.glPopMatrix();
        this.field_73735_i = 0.0F;
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        super.func_73863_a(p_74110_1_, p_74110_2_, p_74110_3_);

        if (achievement1 != null)
        {
            String s = I18n.func_135053_a(achievement1.func_75970_i());
            String s1 = achievement1.func_75989_e();
            j4 = p_74110_1_ + 12;
            l3 = p_74110_2_ - 4;

            if (this.field_74126_x.func_77442_b(achievement1))
            {
                i5 = Math.max(this.field_73886_k.func_78256_a(s), 120);
                l4 = this.field_73886_k.func_78267_b(s1, i5);

                if (this.field_74126_x.func_77443_a(achievement1))
                {
                    l4 += 12;
                }

                this.func_73733_a(j4 - 3, l3 - 3, j4 + i5 + 3, l3 + l4 + 3 + 12, -1073741824, -1073741824);
                this.field_73886_k.func_78279_b(s1, j4, l3 + 12, i5, -6250336);

                if (this.field_74126_x.func_77443_a(achievement1))
                {
                    this.field_73886_k.func_78261_a(I18n.func_135053_a("achievement.taken"), j4, l3 + l4 + 4, -7302913);
                }
            }
            else
            {
                i5 = Math.max(this.field_73886_k.func_78256_a(s), 120);
                String s2 = I18n.func_135052_a("achievement.requires", new Object[] {I18n.func_135053_a(achievement1.field_75992_c.func_75970_i())});
                i4 = this.field_73886_k.func_78267_b(s2, i5);
                this.func_73733_a(j4 - 3, l3 - 3, j4 + i5 + 3, l3 + i4 + 12 + 3, -1073741824, -1073741824);
                this.field_73886_k.func_78279_b(s2, j4, l3 + 12, i5, -9416624);
            }

            this.field_73886_k.func_78261_a(s, j4, l3, this.field_74126_x.func_77442_b(achievement1) ? (achievement1.func_75984_f() ? -128 : -1) : (achievement1.func_75984_f() ? -8355776 : -8355712));
        }

        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_LIGHTING);
        RenderHelper.func_74518_a();
    }

    public boolean func_73868_f()
    {
        return true;
    }
}
