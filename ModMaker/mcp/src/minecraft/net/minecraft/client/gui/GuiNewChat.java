package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiNewChat extends Gui
{
    private final Minecraft field_73772_a;
    private final List field_73770_b = new ArrayList();
    private final List field_73771_c = new ArrayList();
    private final List field_96134_d = new ArrayList();
    private int field_73768_d;
    private boolean field_73769_e;

    public GuiNewChat(Minecraft p_i1022_1_)
    {
        this.field_73772_a = p_i1022_1_;
    }

    public void func_73762_a(int p_73762_1_)
    {
        if (this.field_73772_a.field_71474_y.field_74343_n != 2)
        {
            int j = this.func_96127_i();
            boolean flag = false;
            int k = 0;
            int l = this.field_96134_d.size();
            float f = this.field_73772_a.field_71474_y.field_74357_r * 0.9F + 0.1F;

            if (l > 0)
            {
                if (this.func_73760_d())
                {
                    flag = true;
                }

                float f1 = this.func_96131_h();
                int i1 = MathHelper.func_76123_f((float)this.func_96126_f() / f1);
                GL11.glPushMatrix();
                GL11.glTranslatef(2.0F, 20.0F, 0.0F);
                GL11.glScalef(f1, f1, 1.0F);
                int j1;
                int k1;
                int l1;

                for (j1 = 0; j1 + this.field_73768_d < this.field_96134_d.size() && j1 < j; ++j1)
                {
                    ChatLine chatline = (ChatLine)this.field_96134_d.get(j1 + this.field_73768_d);

                    if (chatline != null)
                    {
                        k1 = p_73762_1_ - chatline.func_74540_b();

                        if (k1 < 200 || flag)
                        {
                            double d0 = (double)k1 / 200.0D;
                            d0 = 1.0D - d0;
                            d0 *= 10.0D;

                            if (d0 < 0.0D)
                            {
                                d0 = 0.0D;
                            }

                            if (d0 > 1.0D)
                            {
                                d0 = 1.0D;
                            }

                            d0 *= d0;
                            l1 = (int)(255.0D * d0);

                            if (flag)
                            {
                                l1 = 255;
                            }

                            l1 = (int)((float)l1 * f);
                            ++k;

                            if (l1 > 3)
                            {
                                byte b0 = 0;
                                int i2 = -j1 * 9;
                                func_73734_a(b0, i2 - 9, b0 + i1 + 4, i2, l1 / 2 << 24);
                                GL11.glEnable(GL11.GL_BLEND);
                                String s = chatline.func_74538_a();

                                if (!this.field_73772_a.field_71474_y.field_74344_o)
                                {
                                    s = StringUtils.func_76338_a(s);
                                }

                                this.field_73772_a.field_71466_p.func_78261_a(s, b0, i2 - 8, 16777215 + (l1 << 24));
                            }
                        }
                    }
                }

                if (flag)
                {
                    j1 = this.field_73772_a.field_71466_p.field_78288_b;
                    GL11.glTranslatef(-3.0F, 0.0F, 0.0F);
                    int j2 = l * j1 + l;
                    k1 = k * j1 + k;
                    int k2 = this.field_73768_d * k1 / l;
                    int l2 = k1 * k1 / j2;

                    if (j2 != k1)
                    {
                        l1 = k2 > 0 ? 170 : 96;
                        int i3 = this.field_73769_e ? 13382451 : 3355562;
                        func_73734_a(0, -k2, 2, -k2 - l2, i3 + (l1 << 24));
                        func_73734_a(2, -k2, 1, -k2 - l2, 13421772 + (l1 << 24));
                    }
                }

                GL11.glPopMatrix();
            }
        }
    }

    public void func_73761_a()
    {
        this.field_96134_d.clear();
        this.field_73771_c.clear();
        this.field_73770_b.clear();
    }

    public void func_73765_a(String p_73765_1_)
    {
        this.func_73763_a(p_73765_1_, 0);
    }

    public void func_73763_a(String p_73763_1_, int p_73763_2_)
    {
        this.func_96129_a(p_73763_1_, p_73763_2_, this.field_73772_a.field_71456_v.func_73834_c(), false);
        this.field_73772_a.func_98033_al().func_98233_a("[CHAT] " + EnumChatFormatting.func_110646_a(p_73763_1_));
    }

    private void func_96129_a(String p_96129_1_, int p_96129_2_, int p_96129_3_, boolean p_96129_4_)
    {
        boolean flag1 = this.func_73760_d();
        boolean flag2 = true;

        if (p_96129_2_ != 0)
        {
            this.func_73759_c(p_96129_2_);
        }

        Iterator iterator = this.field_73772_a.field_71466_p.func_78271_c(p_96129_1_, MathHelper.func_76141_d((float)this.func_96126_f() / this.func_96131_h())).iterator();

        while (iterator.hasNext())
        {
            String s1 = (String)iterator.next();

            if (flag1 && this.field_73768_d > 0)
            {
                this.field_73769_e = true;
                this.func_73758_b(1);
            }

            if (!flag2)
            {
                s1 = " " + s1;
            }

            flag2 = false;
            this.field_96134_d.add(0, new ChatLine(p_96129_3_, s1, p_96129_2_));
        }

        while (this.field_96134_d.size() > 100)
        {
            this.field_96134_d.remove(this.field_96134_d.size() - 1);
        }

        if (!p_96129_4_)
        {
            this.field_73771_c.add(0, new ChatLine(p_96129_3_, p_96129_1_.trim(), p_96129_2_));

            while (this.field_73771_c.size() > 100)
            {
                this.field_73771_c.remove(this.field_73771_c.size() - 1);
            }
        }
    }

    public void func_96132_b()
    {
        this.field_96134_d.clear();
        this.func_73764_c();

        for (int i = this.field_73771_c.size() - 1; i >= 0; --i)
        {
            ChatLine chatline = (ChatLine)this.field_73771_c.get(i);
            this.func_96129_a(chatline.func_74538_a(), chatline.func_74539_c(), chatline.func_74540_b(), true);
        }
    }

    public List func_73756_b()
    {
        return this.field_73770_b;
    }

    public void func_73767_b(String p_73767_1_)
    {
        if (this.field_73770_b.isEmpty() || !((String)this.field_73770_b.get(this.field_73770_b.size() - 1)).equals(p_73767_1_))
        {
            this.field_73770_b.add(p_73767_1_);
        }
    }

    public void func_73764_c()
    {
        this.field_73768_d = 0;
        this.field_73769_e = false;
    }

    public void func_73758_b(int p_73758_1_)
    {
        this.field_73768_d += p_73758_1_;
        int j = this.field_96134_d.size();

        if (this.field_73768_d > j - this.func_96127_i())
        {
            this.field_73768_d = j - this.func_96127_i();
        }

        if (this.field_73768_d <= 0)
        {
            this.field_73768_d = 0;
            this.field_73769_e = false;
        }
    }

    public ChatClickData func_73766_a(int p_73766_1_, int p_73766_2_)
    {
        if (!this.func_73760_d())
        {
            return null;
        }
        else
        {
            ScaledResolution scaledresolution = new ScaledResolution(this.field_73772_a.field_71474_y, this.field_73772_a.field_71443_c, this.field_73772_a.field_71440_d);
            int k = scaledresolution.func_78325_e();
            float f = this.func_96131_h();
            int l = p_73766_1_ / k - 3;
            int i1 = p_73766_2_ / k - 25;
            l = MathHelper.func_76141_d((float)l / f);
            i1 = MathHelper.func_76141_d((float)i1 / f);

            if (l >= 0 && i1 >= 0)
            {
                int j1 = Math.min(this.func_96127_i(), this.field_96134_d.size());

                if (l <= MathHelper.func_76141_d((float)this.func_96126_f() / this.func_96131_h()) && i1 < this.field_73772_a.field_71466_p.field_78288_b * j1 + j1)
                {
                    int k1 = i1 / (this.field_73772_a.field_71466_p.field_78288_b + 1) + this.field_73768_d;
                    return new ChatClickData(this.field_73772_a.field_71466_p, (ChatLine)this.field_96134_d.get(k1), l, i1 - (k1 - this.field_73768_d) * this.field_73772_a.field_71466_p.field_78288_b + k1);
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }
    }

    public void func_73757_a(String p_73757_1_, Object ... p_73757_2_)
    {
        this.func_73765_a(I18n.func_135052_a(p_73757_1_, p_73757_2_));
    }

    public boolean func_73760_d()
    {
        return this.field_73772_a.field_71462_r instanceof GuiChat;
    }

    public void func_73759_c(int p_73759_1_)
    {
        Iterator iterator = this.field_96134_d.iterator();
        ChatLine chatline;

        do
        {
            if (!iterator.hasNext())
            {
                iterator = this.field_73771_c.iterator();

                do
                {
                    if (!iterator.hasNext())
                    {
                        return;
                    }

                    chatline = (ChatLine)iterator.next();
                }
                while (chatline.func_74539_c() != p_73759_1_);

                iterator.remove();
                return;
            }

            chatline = (ChatLine)iterator.next();
        }
        while (chatline.func_74539_c() != p_73759_1_);

        iterator.remove();
    }

    public int func_96126_f()
    {
        return func_96128_a(this.field_73772_a.field_71474_y.field_96692_F);
    }

    public int func_96133_g()
    {
        return func_96130_b(this.func_73760_d() ? this.field_73772_a.field_71474_y.field_96694_H : this.field_73772_a.field_71474_y.field_96693_G);
    }

    public float func_96131_h()
    {
        return this.field_73772_a.field_71474_y.field_96691_E;
    }

    public static final int func_96128_a(float p_96128_0_)
    {
        short short1 = 320;
        byte b0 = 40;
        return MathHelper.func_76141_d(p_96128_0_ * (float)(short1 - b0) + (float)b0);
    }

    public static final int func_96130_b(float p_96130_0_)
    {
        short short1 = 180;
        byte b0 = 20;
        return MathHelper.func_76141_d(p_96130_0_ * (float)(short1 - b0) + (float)b0);
    }

    public int func_96127_i()
    {
        return this.func_96133_g() / 9;
    }
}
