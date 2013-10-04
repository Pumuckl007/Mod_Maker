package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.AchievementList;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class GuiInventory extends InventoryEffectRenderer
{
    private float field_74225_o;
    private float field_74224_p;

    public GuiInventory(EntityPlayer p_i1094_1_)
    {
        super(p_i1094_1_.field_71069_bz);
        this.field_73885_j = true;
        p_i1094_1_.func_71064_a(AchievementList.field_76004_f, 1);
    }

    public void func_73876_c()
    {
        if (this.field_73882_e.field_71442_b.func_78758_h())
        {
            this.field_73882_e.func_71373_a(new GuiContainerCreative(this.field_73882_e.field_71439_g));
        }
    }

    public void func_73866_w_()
    {
        this.field_73887_h.clear();

        if (this.field_73882_e.field_71442_b.func_78758_h())
        {
            this.field_73882_e.func_71373_a(new GuiContainerCreative(this.field_73882_e.field_71439_g));
        }
        else
        {
            super.func_73866_w_();
        }
    }

    protected void func_74189_g(int p_74189_1_, int p_74189_2_)
    {
        this.field_73886_k.func_78276_b(I18n.func_135053_a("container.crafting"), 86, 16, 4210752);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        this.field_74225_o = (float)p_73863_1_;
        this.field_74224_p = (float)p_73863_2_;
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110408_a);
        int k = this.field_74198_m;
        int l = this.field_74197_n;
        this.func_73729_b(k, l, 0, 0, this.field_74194_b, this.field_74195_c);
        func_110423_a(k + 51, l + 75, 30, (float)(k + 51) - this.field_74225_o, (float)(l + 75 - 50) - this.field_74224_p, this.field_73882_e.field_71439_g);
    }

    public static void func_110423_a(int p_110423_0_, int p_110423_1_, int p_110423_2_, float p_110423_3_, float p_110423_4_, EntityLivingBase p_110423_5_)
    {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_110423_0_, (float)p_110423_1_, 50.0F);
        GL11.glScalef((float)(-p_110423_2_), (float)p_110423_2_, (float)p_110423_2_);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float f2 = p_110423_5_.field_70761_aq;
        float f3 = p_110423_5_.field_70177_z;
        float f4 = p_110423_5_.field_70125_A;
        float f5 = p_110423_5_.field_70758_at;
        float f6 = p_110423_5_.field_70759_as;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.func_74519_b();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(p_110423_4_ / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        p_110423_5_.field_70761_aq = (float)Math.atan((double)(p_110423_3_ / 40.0F)) * 20.0F;
        p_110423_5_.field_70177_z = (float)Math.atan((double)(p_110423_3_ / 40.0F)) * 40.0F;
        p_110423_5_.field_70125_A = -((float)Math.atan((double)(p_110423_4_ / 40.0F))) * 20.0F;
        p_110423_5_.field_70759_as = p_110423_5_.field_70177_z;
        p_110423_5_.field_70758_at = p_110423_5_.field_70177_z;
        GL11.glTranslatef(0.0F, p_110423_5_.field_70129_M, 0.0F);
        RenderManager.field_78727_a.field_78735_i = 180.0F;
        RenderManager.field_78727_a.func_78719_a(p_110423_5_, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        p_110423_5_.field_70761_aq = f2;
        p_110423_5_.field_70177_z = f3;
        p_110423_5_.field_70125_A = f4;
        p_110423_5_.field_70758_at = f5;
        p_110423_5_.field_70759_as = f6;
        GL11.glPopMatrix();
        RenderHelper.func_74518_a();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73741_f == 0)
        {
            this.field_73882_e.func_71373_a(new GuiAchievements(this.field_73882_e.field_71413_E));
        }

        if (p_73875_1_.field_73741_f == 1)
        {
            this.field_73882_e.func_71373_a(new GuiStats(this, this.field_73882_e.field_71413_E));
        }
    }
}
