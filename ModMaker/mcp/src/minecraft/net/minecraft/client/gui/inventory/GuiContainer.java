package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public abstract class GuiContainer extends GuiScreen
{
    protected static final ResourceLocation field_110408_a = new ResourceLocation("textures/gui/container/inventory.png");
    protected static RenderItem field_74196_a = new RenderItem();
    protected int field_74194_b = 176;
    protected int field_74195_c = 166;
    public Container field_74193_d;
    protected int field_74198_m;
    protected int field_74197_n;
    private Slot field_82320_o;
    private Slot field_85051_p;
    private boolean field_90018_r;
    private ItemStack field_85050_q;
    private int field_85049_r;
    private int field_85048_s;
    private Slot field_85047_t;
    private long field_85046_u;
    private ItemStack field_85045_v;
    private Slot field_92033_y;
    private long field_92032_z;
    protected final Set field_94077_p = new HashSet();
    protected boolean field_94076_q;
    private int field_94071_C;
    private int field_94067_D;
    private boolean field_94068_E;
    private int field_94069_F;
    private long field_94070_G;
    private Slot field_94072_H;
    private int field_94073_I;
    private boolean field_94074_J;
    private ItemStack field_94075_K;

    public GuiContainer(Container p_i1072_1_)
    {
        this.field_74193_d = p_i1072_1_;
        this.field_94068_E = true;
    }

    public void func_73866_w_()
    {
        super.func_73866_w_();
        this.field_73882_e.field_71439_g.field_71070_bA = this.field_74193_d;
        this.field_74198_m = (this.field_73880_f - this.field_74194_b) / 2;
        this.field_74197_n = (this.field_73881_g - this.field_74195_c) / 2;
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.func_73873_v_();
        int k = this.field_74198_m;
        int l = this.field_74197_n;
        this.func_74185_a(p_73863_3_, p_73863_1_, p_73863_2_);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.func_74518_a();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        RenderHelper.func_74520_c();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)k, (float)l, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        this.field_82320_o = null;
        short short1 = 240;
        short short2 = 240;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)short1 / 1.0F, (float)short2 / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int i1;

        for (int j1 = 0; j1 < this.field_74193_d.field_75151_b.size(); ++j1)
        {
            Slot slot = (Slot)this.field_74193_d.field_75151_b.get(j1);
            this.func_74192_a(slot);

            if (this.func_74186_a(slot, p_73863_1_, p_73863_2_) && slot.func_111238_b())
            {
                this.field_82320_o = slot;
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_DEPTH_TEST);
                int k1 = slot.field_75223_e;
                i1 = slot.field_75221_f;
                this.func_73733_a(k1, i1, k1 + 16, i1 + 16, -2130706433, -2130706433);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glEnable(GL11.GL_DEPTH_TEST);
            }
        }

        this.func_74189_g(p_73863_1_, p_73863_2_);
        InventoryPlayer inventoryplayer = this.field_73882_e.field_71439_g.field_71071_by;
        ItemStack itemstack = this.field_85050_q == null ? inventoryplayer.func_70445_o() : this.field_85050_q;

        if (itemstack != null)
        {
            byte b0 = 8;
            i1 = this.field_85050_q == null ? 8 : 16;
            String s = null;

            if (this.field_85050_q != null && this.field_90018_r)
            {
                itemstack = itemstack.func_77946_l();
                itemstack.field_77994_a = MathHelper.func_76123_f((float)itemstack.field_77994_a / 2.0F);
            }
            else if (this.field_94076_q && this.field_94077_p.size() > 1)
            {
                itemstack = itemstack.func_77946_l();
                itemstack.field_77994_a = this.field_94069_F;

                if (itemstack.field_77994_a == 0)
                {
                    s = "" + EnumChatFormatting.YELLOW + "0";
                }
            }

            this.func_85044_b(itemstack, p_73863_1_ - k - b0, p_73863_2_ - l - i1, s);
        }

        if (this.field_85045_v != null)
        {
            float f1 = (float)(Minecraft.func_71386_F() - this.field_85046_u) / 100.0F;

            if (f1 >= 1.0F)
            {
                f1 = 1.0F;
                this.field_85045_v = null;
            }

            i1 = this.field_85047_t.field_75223_e - this.field_85049_r;
            int l1 = this.field_85047_t.field_75221_f - this.field_85048_s;
            int i2 = this.field_85049_r + (int)((float)i1 * f1);
            int j2 = this.field_85048_s + (int)((float)l1 * f1);
            this.func_85044_b(this.field_85045_v, i2, j2, (String)null);
        }

        GL11.glPopMatrix();

        if (inventoryplayer.func_70445_o() == null && this.field_82320_o != null && this.field_82320_o.func_75216_d())
        {
            ItemStack itemstack1 = this.field_82320_o.func_75211_c();
            this.func_74184_a(itemstack1, p_73863_1_, p_73863_2_);
        }

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.func_74519_b();
    }

    private void func_85044_b(ItemStack p_85044_1_, int p_85044_2_, int p_85044_3_, String p_85044_4_)
    {
        GL11.glTranslatef(0.0F, 0.0F, 32.0F);
        this.field_73735_i = 200.0F;
        field_74196_a.field_77023_b = 200.0F;
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.func_110434_K(), p_85044_1_, p_85044_2_, p_85044_3_);
        field_74196_a.func_94148_a(this.field_73886_k, this.field_73882_e.func_110434_K(), p_85044_1_, p_85044_2_, p_85044_3_ - (this.field_85050_q == null ? 0 : 8), p_85044_4_);
        this.field_73735_i = 0.0F;
        field_74196_a.field_77023_b = 0.0F;
    }

    protected void func_74184_a(ItemStack p_74184_1_, int p_74184_2_, int p_74184_3_)
    {
        List list = p_74184_1_.func_82840_a(this.field_73882_e.field_71439_g, this.field_73882_e.field_71474_y.field_82882_x);

        for (int k = 0; k < list.size(); ++k)
        {
            if (k == 0)
            {
                list.set(k, "\u00a7" + Integer.toHexString(p_74184_1_.func_77953_t().field_77937_e) + (String)list.get(k));
            }
            else
            {
                list.set(k, EnumChatFormatting.GRAY + (String)list.get(k));
            }
        }

        this.func_102021_a(list, p_74184_2_, p_74184_3_);
    }

    protected void func_74190_a(String p_74190_1_, int p_74190_2_, int p_74190_3_)
    {
        this.func_102021_a(Arrays.asList(new String[] {p_74190_1_}), p_74190_2_, p_74190_3_);
    }

    protected void func_102021_a(List p_102021_1_, int p_102021_2_, int p_102021_3_)
    {
        if (!p_102021_1_.isEmpty())
        {
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            RenderHelper.func_74518_a();
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            int k = 0;
            Iterator iterator = p_102021_1_.iterator();

            while (iterator.hasNext())
            {
                String s = (String)iterator.next();
                int l = this.field_73886_k.func_78256_a(s);

                if (l > k)
                {
                    k = l;
                }
            }

            int i1 = p_102021_2_ + 12;
            int j1 = p_102021_3_ - 12;
            int k1 = 8;

            if (p_102021_1_.size() > 1)
            {
                k1 += 2 + (p_102021_1_.size() - 1) * 10;
            }

            if (i1 + k > this.field_73880_f)
            {
                i1 -= 28 + k;
            }

            if (j1 + k1 + 6 > this.field_73881_g)
            {
                j1 = this.field_73881_g - k1 - 6;
            }

            this.field_73735_i = 300.0F;
            field_74196_a.field_77023_b = 300.0F;
            int l1 = -267386864;
            this.func_73733_a(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
            this.func_73733_a(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
            this.func_73733_a(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
            this.func_73733_a(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
            this.func_73733_a(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
            int i2 = 1347420415;
            int j2 = (i2 & 16711422) >> 1 | i2 & -16777216;
            this.func_73733_a(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
            this.func_73733_a(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
            this.func_73733_a(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
            this.func_73733_a(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);

            for (int k2 = 0; k2 < p_102021_1_.size(); ++k2)
            {
                String s1 = (String)p_102021_1_.get(k2);
                this.field_73886_k.func_78261_a(s1, i1, j1, -1);

                if (k2 == 0)
                {
                    j1 += 2;
                }

                j1 += 10;
            }

            this.field_73735_i = 0.0F;
            field_74196_a.field_77023_b = 0.0F;
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            RenderHelper.func_74519_b();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        }
    }

    protected void func_74189_g(int p_74189_1_, int p_74189_2_) {}

    protected abstract void func_74185_a(float f, int i, int j);

    protected void func_74192_a(Slot p_74192_1_)
    {
        int i = p_74192_1_.field_75223_e;
        int j = p_74192_1_.field_75221_f;
        ItemStack itemstack = p_74192_1_.func_75211_c();
        boolean flag = false;
        boolean flag1 = p_74192_1_ == this.field_85051_p && this.field_85050_q != null && !this.field_90018_r;
        ItemStack itemstack1 = this.field_73882_e.field_71439_g.field_71071_by.func_70445_o();
        String s = null;

        if (p_74192_1_ == this.field_85051_p && this.field_85050_q != null && this.field_90018_r && itemstack != null)
        {
            itemstack = itemstack.func_77946_l();
            itemstack.field_77994_a /= 2;
        }
        else if (this.field_94076_q && this.field_94077_p.contains(p_74192_1_) && itemstack1 != null)
        {
            if (this.field_94077_p.size() == 1)
            {
                return;
            }

            if (Container.func_94527_a(p_74192_1_, itemstack1, true) && this.field_74193_d.func_94531_b(p_74192_1_))
            {
                itemstack = itemstack1.func_77946_l();
                flag = true;
                Container.func_94525_a(this.field_94077_p, this.field_94071_C, itemstack, p_74192_1_.func_75211_c() == null ? 0 : p_74192_1_.func_75211_c().field_77994_a);

                if (itemstack.field_77994_a > itemstack.func_77976_d())
                {
                    s = EnumChatFormatting.YELLOW + "" + itemstack.func_77976_d();
                    itemstack.field_77994_a = itemstack.func_77976_d();
                }

                if (itemstack.field_77994_a > p_74192_1_.func_75219_a())
                {
                    s = EnumChatFormatting.YELLOW + "" + p_74192_1_.func_75219_a();
                    itemstack.field_77994_a = p_74192_1_.func_75219_a();
                }
            }
            else
            {
                this.field_94077_p.remove(p_74192_1_);
                this.func_94066_g();
            }
        }

        this.field_73735_i = 100.0F;
        field_74196_a.field_77023_b = 100.0F;

        if (itemstack == null)
        {
            Icon icon = p_74192_1_.func_75212_b();

            if (icon != null)
            {
                GL11.glDisable(GL11.GL_LIGHTING);
                this.field_73882_e.func_110434_K().func_110577_a(TextureMap.field_110576_c);
                this.func_94065_a(i, j, icon, 16, 16);
                GL11.glEnable(GL11.GL_LIGHTING);
                flag1 = true;
            }
        }

        if (!flag1)
        {
            if (flag)
            {
                func_73734_a(i, j, i + 16, j + 16, -2130706433);
            }

            GL11.glEnable(GL11.GL_DEPTH_TEST);
            field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.func_110434_K(), itemstack, i, j);
            field_74196_a.func_94148_a(this.field_73886_k, this.field_73882_e.func_110434_K(), itemstack, i, j, s);
        }

        field_74196_a.field_77023_b = 0.0F;
        this.field_73735_i = 0.0F;
    }

    private void func_94066_g()
    {
        ItemStack itemstack = this.field_73882_e.field_71439_g.field_71071_by.func_70445_o();

        if (itemstack != null && this.field_94076_q)
        {
            this.field_94069_F = itemstack.field_77994_a;
            ItemStack itemstack1;
            int i;

            for (Iterator iterator = this.field_94077_p.iterator(); iterator.hasNext(); this.field_94069_F -= itemstack1.field_77994_a - i)
            {
                Slot slot = (Slot)iterator.next();
                itemstack1 = itemstack.func_77946_l();
                i = slot.func_75211_c() == null ? 0 : slot.func_75211_c().field_77994_a;
                Container.func_94525_a(this.field_94077_p, this.field_94071_C, itemstack1, i);

                if (itemstack1.field_77994_a > itemstack1.func_77976_d())
                {
                    itemstack1.field_77994_a = itemstack1.func_77976_d();
                }

                if (itemstack1.field_77994_a > slot.func_75219_a())
                {
                    itemstack1.field_77994_a = slot.func_75219_a();
                }
            }
        }
    }

    private Slot func_74187_b(int p_74187_1_, int p_74187_2_)
    {
        for (int k = 0; k < this.field_74193_d.field_75151_b.size(); ++k)
        {
            Slot slot = (Slot)this.field_74193_d.field_75151_b.get(k);

            if (this.func_74186_a(slot, p_74187_1_, p_74187_2_))
            {
                return slot;
            }
        }

        return null;
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        boolean flag = p_73864_3_ == this.field_73882_e.field_71474_y.field_74322_I.field_74512_d + 100;
        Slot slot = this.func_74187_b(p_73864_1_, p_73864_2_);
        long l = Minecraft.func_71386_F();
        this.field_94074_J = this.field_94072_H == slot && l - this.field_94070_G < 250L && this.field_94073_I == p_73864_3_;
        this.field_94068_E = false;

        if (p_73864_3_ == 0 || p_73864_3_ == 1 || flag)
        {
            int i1 = this.field_74198_m;
            int j1 = this.field_74197_n;
            boolean flag1 = p_73864_1_ < i1 || p_73864_2_ < j1 || p_73864_1_ >= i1 + this.field_74194_b || p_73864_2_ >= j1 + this.field_74195_c;
            int k1 = -1;

            if (slot != null)
            {
                k1 = slot.field_75222_d;
            }

            if (flag1)
            {
                k1 = -999;
            }

            if (this.field_73882_e.field_71474_y.field_85185_A && flag1 && this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() == null)
            {
                this.field_73882_e.func_71373_a((GuiScreen)null);
                return;
            }

            if (k1 != -1)
            {
                if (this.field_73882_e.field_71474_y.field_85185_A)
                {
                    if (slot != null && slot.func_75216_d())
                    {
                        this.field_85051_p = slot;
                        this.field_85050_q = null;
                        this.field_90018_r = p_73864_3_ == 1;
                    }
                    else
                    {
                        this.field_85051_p = null;
                    }
                }
                else if (!this.field_94076_q)
                {
                    if (this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() == null)
                    {
                        if (p_73864_3_ == this.field_73882_e.field_71474_y.field_74322_I.field_74512_d + 100)
                        {
                            this.func_74191_a(slot, k1, p_73864_3_, 3);
                        }
                        else
                        {
                            boolean flag2 = k1 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                            byte b0 = 0;

                            if (flag2)
                            {
                                this.field_94075_K = slot != null && slot.func_75216_d() ? slot.func_75211_c() : null;
                                b0 = 1;
                            }
                            else if (k1 == -999)
                            {
                                b0 = 4;
                            }

                            this.func_74191_a(slot, k1, p_73864_3_, b0);
                        }

                        this.field_94068_E = true;
                    }
                    else
                    {
                        this.field_94076_q = true;
                        this.field_94067_D = p_73864_3_;
                        this.field_94077_p.clear();

                        if (p_73864_3_ == 0)
                        {
                            this.field_94071_C = 0;
                        }
                        else if (p_73864_3_ == 1)
                        {
                            this.field_94071_C = 1;
                        }
                    }
                }
            }
        }

        this.field_94072_H = slot;
        this.field_94070_G = l;
        this.field_94073_I = p_73864_3_;
    }

    protected void func_85041_a(int p_85041_1_, int p_85041_2_, int p_85041_3_, long p_85041_4_)
    {
        Slot slot = this.func_74187_b(p_85041_1_, p_85041_2_);
        ItemStack itemstack = this.field_73882_e.field_71439_g.field_71071_by.func_70445_o();

        if (this.field_85051_p != null && this.field_73882_e.field_71474_y.field_85185_A)
        {
            if (p_85041_3_ == 0 || p_85041_3_ == 1)
            {
                if (this.field_85050_q == null)
                {
                    if (slot != this.field_85051_p)
                    {
                        this.field_85050_q = this.field_85051_p.func_75211_c().func_77946_l();
                    }
                }
                else if (this.field_85050_q.field_77994_a > 1 && slot != null && Container.func_94527_a(slot, this.field_85050_q, false))
                {
                    long i1 = Minecraft.func_71386_F();

                    if (this.field_92033_y == slot)
                    {
                        if (i1 - this.field_92032_z > 500L)
                        {
                            this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, 0, 0);
                            this.func_74191_a(slot, slot.field_75222_d, 1, 0);
                            this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, 0, 0);
                            this.field_92032_z = i1 + 750L;
                            --this.field_85050_q.field_77994_a;
                        }
                    }
                    else
                    {
                        this.field_92033_y = slot;
                        this.field_92032_z = i1;
                    }
                }
            }
        }
        else if (this.field_94076_q && slot != null && itemstack != null && itemstack.field_77994_a > this.field_94077_p.size() && Container.func_94527_a(slot, itemstack, true) && slot.func_75214_a(itemstack) && this.field_74193_d.func_94531_b(slot))
        {
            this.field_94077_p.add(slot);
            this.func_94066_g();
        }
    }

    protected void func_73879_b(int p_73879_1_, int p_73879_2_, int p_73879_3_)
    {
        Slot slot = this.func_74187_b(p_73879_1_, p_73879_2_);
        int l = this.field_74198_m;
        int i1 = this.field_74197_n;
        boolean flag = p_73879_1_ < l || p_73879_2_ < i1 || p_73879_1_ >= l + this.field_74194_b || p_73879_2_ >= i1 + this.field_74195_c;
        int j1 = -1;

        if (slot != null)
        {
            j1 = slot.field_75222_d;
        }

        if (flag)
        {
            j1 = -999;
        }

        Slot slot1;
        Iterator iterator;

        if (this.field_94074_J && slot != null && p_73879_3_ == 0 && this.field_74193_d.func_94530_a((ItemStack)null, slot))
        {
            if (func_73877_p())
            {
                if (slot != null && slot.field_75224_c != null && this.field_94075_K != null)
                {
                    iterator = this.field_74193_d.field_75151_b.iterator();

                    while (iterator.hasNext())
                    {
                        slot1 = (Slot)iterator.next();

                        if (slot1 != null && slot1.func_82869_a(this.field_73882_e.field_71439_g) && slot1.func_75216_d() && slot1.field_75224_c == slot.field_75224_c && Container.func_94527_a(slot1, this.field_94075_K, true))
                        {
                            this.func_74191_a(slot1, slot1.field_75222_d, p_73879_3_, 1);
                        }
                    }
                }
            }
            else
            {
                this.func_74191_a(slot, j1, p_73879_3_, 6);
            }

            this.field_94074_J = false;
            this.field_94070_G = 0L;
        }
        else
        {
            if (this.field_94076_q && this.field_94067_D != p_73879_3_)
            {
                this.field_94076_q = false;
                this.field_94077_p.clear();
                this.field_94068_E = true;
                return;
            }

            if (this.field_94068_E)
            {
                this.field_94068_E = false;
                return;
            }

            boolean flag1;

            if (this.field_85051_p != null && this.field_73882_e.field_71474_y.field_85185_A)
            {
                if (p_73879_3_ == 0 || p_73879_3_ == 1)
                {
                    if (this.field_85050_q == null && slot != this.field_85051_p)
                    {
                        this.field_85050_q = this.field_85051_p.func_75211_c();
                    }

                    flag1 = Container.func_94527_a(slot, this.field_85050_q, false);

                    if (j1 != -1 && this.field_85050_q != null && flag1)
                    {
                        this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, p_73879_3_, 0);
                        this.func_74191_a(slot, j1, 0, 0);

                        if (this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() != null)
                        {
                            this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, p_73879_3_, 0);
                            this.field_85049_r = p_73879_1_ - l;
                            this.field_85048_s = p_73879_2_ - i1;
                            this.field_85047_t = this.field_85051_p;
                            this.field_85045_v = this.field_85050_q;
                            this.field_85046_u = Minecraft.func_71386_F();
                        }
                        else
                        {
                            this.field_85045_v = null;
                        }
                    }
                    else if (this.field_85050_q != null)
                    {
                        this.field_85049_r = p_73879_1_ - l;
                        this.field_85048_s = p_73879_2_ - i1;
                        this.field_85047_t = this.field_85051_p;
                        this.field_85045_v = this.field_85050_q;
                        this.field_85046_u = Minecraft.func_71386_F();
                    }

                    this.field_85050_q = null;
                    this.field_85051_p = null;
                }
            }
            else if (this.field_94076_q && !this.field_94077_p.isEmpty())
            {
                this.func_74191_a((Slot)null, -999, Container.func_94534_d(0, this.field_94071_C), 5);
                iterator = this.field_94077_p.iterator();

                while (iterator.hasNext())
                {
                    slot1 = (Slot)iterator.next();
                    this.func_74191_a(slot1, slot1.field_75222_d, Container.func_94534_d(1, this.field_94071_C), 5);
                }

                this.func_74191_a((Slot)null, -999, Container.func_94534_d(2, this.field_94071_C), 5);
            }
            else if (this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() != null)
            {
                if (p_73879_3_ == this.field_73882_e.field_71474_y.field_74322_I.field_74512_d + 100)
                {
                    this.func_74191_a(slot, j1, p_73879_3_, 3);
                }
                else
                {
                    flag1 = j1 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));

                    if (flag1)
                    {
                        this.field_94075_K = slot != null && slot.func_75216_d() ? slot.func_75211_c() : null;
                    }

                    this.func_74191_a(slot, j1, p_73879_3_, flag1 ? 1 : 0);
                }
            }
        }

        if (this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() == null)
        {
            this.field_94070_G = 0L;
        }

        this.field_94076_q = false;
    }

    private boolean func_74186_a(Slot p_74186_1_, int p_74186_2_, int p_74186_3_)
    {
        return this.func_74188_c(p_74186_1_.field_75223_e, p_74186_1_.field_75221_f, 16, 16, p_74186_2_, p_74186_3_);
    }

    protected boolean func_74188_c(int p_74188_1_, int p_74188_2_, int p_74188_3_, int p_74188_4_, int p_74188_5_, int p_74188_6_)
    {
        int k1 = this.field_74198_m;
        int l1 = this.field_74197_n;
        p_74188_5_ -= k1;
        p_74188_6_ -= l1;
        return p_74188_5_ >= p_74188_1_ - 1 && p_74188_5_ < p_74188_1_ + p_74188_3_ + 1 && p_74188_6_ >= p_74188_2_ - 1 && p_74188_6_ < p_74188_2_ + p_74188_4_ + 1;
    }

    protected void func_74191_a(Slot p_74191_1_, int p_74191_2_, int p_74191_3_, int p_74191_4_)
    {
        if (p_74191_1_ != null)
        {
            p_74191_2_ = p_74191_1_.field_75222_d;
        }

        this.field_73882_e.field_71442_b.func_78753_a(this.field_74193_d.field_75152_c, p_74191_2_, p_74191_3_, p_74191_4_, this.field_73882_e.field_71439_g);
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if (p_73869_2_ == 1 || p_73869_2_ == this.field_73882_e.field_71474_y.field_74315_B.field_74512_d)
        {
            this.field_73882_e.field_71439_g.func_71053_j();
        }

        this.func_82319_a(p_73869_2_);

        if (this.field_82320_o != null && this.field_82320_o.func_75216_d())
        {
            if (p_73869_2_ == this.field_73882_e.field_71474_y.field_74322_I.field_74512_d)
            {
                this.func_74191_a(this.field_82320_o, this.field_82320_o.field_75222_d, 0, 3);
            }
            else if (p_73869_2_ == this.field_73882_e.field_71474_y.field_74316_C.field_74512_d)
            {
                this.func_74191_a(this.field_82320_o, this.field_82320_o.field_75222_d, func_73861_o() ? 1 : 0, 4);
            }
        }
    }

    protected boolean func_82319_a(int p_82319_1_)
    {
        if (this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() == null && this.field_82320_o != null)
        {
            for (int j = 0; j < 9; ++j)
            {
                if (p_82319_1_ == 2 + j)
                {
                    this.func_74191_a(this.field_82320_o, this.field_82320_o.field_75222_d, j, 2);
                    return true;
                }
            }
        }

        return false;
    }

    public void func_73874_b()
    {
        if (this.field_73882_e.field_71439_g != null)
        {
            this.field_74193_d.func_75134_a(this.field_73882_e.field_71439_g);
        }
    }

    public boolean func_73868_f()
    {
        return false;
    }

    public void func_73876_c()
    {
        super.func_73876_c();

        if (!this.field_73882_e.field_71439_g.func_70089_S() || this.field_73882_e.field_71439_g.field_70128_L)
        {
            this.field_73882_e.field_71439_g.func_71053_j();
        }
    }
}
