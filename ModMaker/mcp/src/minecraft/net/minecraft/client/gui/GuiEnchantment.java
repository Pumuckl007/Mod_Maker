package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnchantmentNameParts;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.util.glu.Project;

@SideOnly(Side.CLIENT)
public class GuiEnchantment extends GuiContainer
{
    private static final ResourceLocation field_110425_B = new ResourceLocation("textures/gui/container/enchanting_table.png");
    private static final ResourceLocation field_110426_C = new ResourceLocation("textures/entity/enchanting_table_book.png");
    private static final ModelBook field_74206_w = new ModelBook();
    private Random field_74216_x = new Random();
    private ContainerEnchantment field_74215_y;
    public int field_74214_o;
    public float field_74213_p;
    public float field_74212_q;
    public float field_74211_r;
    public float field_74210_s;
    public float field_74209_t;
    public float field_74208_u;
    ItemStack field_74207_v;
    private String field_94079_C;

    public GuiEnchantment(InventoryPlayer p_i1090_1_, World p_i1090_2_, int p_i1090_3_, int p_i1090_4_, int p_i1090_5_, String p_i1090_6_)
    {
        super(new ContainerEnchantment(p_i1090_1_, p_i1090_2_, p_i1090_3_, p_i1090_4_, p_i1090_5_));
        this.field_74215_y = (ContainerEnchantment)this.field_74193_d;
        this.field_94079_C = p_i1090_6_;
    }

    protected void func_74189_g(int p_74189_1_, int p_74189_2_)
    {
        this.field_73886_k.func_78276_b(this.field_94079_C == null ? I18n.func_135053_a("container.enchant") : this.field_94079_C, 12, 5, 4210752);
        this.field_73886_k.func_78276_b(I18n.func_135053_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        this.func_74205_h();
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        int l = (this.field_73880_f - this.field_74194_b) / 2;
        int i1 = (this.field_73881_g - this.field_74195_c) / 2;

        for (int j1 = 0; j1 < 3; ++j1)
        {
            int k1 = p_73864_1_ - (l + 60);
            int l1 = p_73864_2_ - (i1 + 14 + 19 * j1);

            if (k1 >= 0 && l1 >= 0 && k1 < 108 && l1 < 19 && this.field_74215_y.func_75140_a(this.field_73882_e.field_71439_g, j1))
            {
                this.field_73882_e.field_71442_b.func_78756_a(this.field_74215_y.field_75152_c, j1);
            }
        }
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110425_B);
        int k = (this.field_73880_f - this.field_74194_b) / 2;
        int l = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(k, l, 0, 0, this.field_74194_b, this.field_74195_c);
        GL11.glPushMatrix();
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        ScaledResolution scaledresolution = new ScaledResolution(this.field_73882_e.field_71474_y, this.field_73882_e.field_71443_c, this.field_73882_e.field_71440_d);
        GL11.glViewport((scaledresolution.func_78326_a() - 320) / 2 * scaledresolution.func_78325_e(), (scaledresolution.func_78328_b() - 240) / 2 * scaledresolution.func_78325_e(), 320 * scaledresolution.func_78325_e(), 240 * scaledresolution.func_78325_e());
        GL11.glTranslatef(-0.34F, 0.23F, 0.0F);
        Project.gluPerspective(90.0F, 1.3333334F, 9.0F, 80.0F);
        float f1 = 1.0F;
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        RenderHelper.func_74519_b();
        GL11.glTranslatef(0.0F, 3.3F, -16.0F);
        GL11.glScalef(f1, f1, f1);
        float f2 = 5.0F;
        GL11.glScalef(f2, f2, f2);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110426_C);
        GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
        float f3 = this.field_74208_u + (this.field_74209_t - this.field_74208_u) * p_74185_1_;
        GL11.glTranslatef((1.0F - f3) * 0.2F, (1.0F - f3) * 0.1F, (1.0F - f3) * 0.25F);
        GL11.glRotatef(-(1.0F - f3) * 90.0F - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
        float f4 = this.field_74212_q + (this.field_74213_p - this.field_74212_q) * p_74185_1_ + 0.25F;
        float f5 = this.field_74212_q + (this.field_74213_p - this.field_74212_q) * p_74185_1_ + 0.75F;
        f4 = (f4 - (float)MathHelper.func_76140_b((double)f4)) * 1.6F - 0.3F;
        f5 = (f5 - (float)MathHelper.func_76140_b((double)f5)) * 1.6F - 0.3F;

        if (f4 < 0.0F)
        {
            f4 = 0.0F;
        }

        if (f5 < 0.0F)
        {
            f5 = 0.0F;
        }

        if (f4 > 1.0F)
        {
            f4 = 1.0F;
        }

        if (f5 > 1.0F)
        {
            f5 = 1.0F;
        }

        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        field_74206_w.func_78088_a((Entity)null, 0.0F, f4, f5, f3, 0.0F, 0.0625F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.func_74518_a();
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glViewport(0, 0, this.field_73882_e.field_71443_c, this.field_73882_e.field_71440_d);
        GL11.glPopMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPopMatrix();
        RenderHelper.func_74518_a();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        EnchantmentNameParts.field_78061_a.func_78058_a(this.field_74215_y.field_75166_f);

        for (int i1 = 0; i1 < 3; ++i1)
        {
            String s = EnchantmentNameParts.field_78061_a.func_78057_a();
            this.field_73735_i = 0.0F;
            this.field_73882_e.func_110434_K().func_110577_a(field_110425_B);
            int j1 = this.field_74215_y.field_75167_g[i1];
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            if (j1 == 0)
            {
                this.func_73729_b(k + 60, l + 14 + 19 * i1, 0, 185, 108, 19);
            }
            else
            {
                String s1 = "" + j1;
                FontRenderer fontrenderer = this.field_73882_e.field_71464_q;
                int k1 = 6839882;

                if (this.field_73882_e.field_71439_g.field_71068_ca < j1 && !this.field_73882_e.field_71439_g.field_71075_bZ.field_75098_d)
                {
                    this.func_73729_b(k + 60, l + 14 + 19 * i1, 0, 185, 108, 19);
                    fontrenderer.func_78279_b(s, k + 62, l + 16 + 19 * i1, 104, (k1 & 16711422) >> 1);
                    fontrenderer = this.field_73882_e.field_71466_p;
                    k1 = 4226832;
                    fontrenderer.func_78261_a(s1, k + 62 + 104 - fontrenderer.func_78256_a(s1), l + 16 + 19 * i1 + 7, k1);
                }
                else
                {
                    int l1 = p_74185_2_ - (k + 60);
                    int i2 = p_74185_3_ - (l + 14 + 19 * i1);

                    if (l1 >= 0 && i2 >= 0 && l1 < 108 && i2 < 19)
                    {
                        this.func_73729_b(k + 60, l + 14 + 19 * i1, 0, 204, 108, 19);
                        k1 = 16777088;
                    }
                    else
                    {
                        this.func_73729_b(k + 60, l + 14 + 19 * i1, 0, 166, 108, 19);
                    }

                    fontrenderer.func_78279_b(s, k + 62, l + 16 + 19 * i1, 104, k1);
                    fontrenderer = this.field_73882_e.field_71466_p;
                    k1 = 8453920;
                    fontrenderer.func_78261_a(s1, k + 62 + 104 - fontrenderer.func_78256_a(s1), l + 16 + 19 * i1 + 7, k1);
                }
            }
        }
    }

    public void func_74205_h()
    {
        ItemStack itemstack = this.field_74193_d.func_75139_a(0).func_75211_c();

        if (!ItemStack.func_77989_b(itemstack, this.field_74207_v))
        {
            this.field_74207_v = itemstack;

            do
            {
                this.field_74211_r += (float)(this.field_74216_x.nextInt(4) - this.field_74216_x.nextInt(4));
            }
            while (this.field_74213_p <= this.field_74211_r + 1.0F && this.field_74213_p >= this.field_74211_r - 1.0F);
        }

        ++this.field_74214_o;
        this.field_74212_q = this.field_74213_p;
        this.field_74208_u = this.field_74209_t;
        boolean flag = false;

        for (int i = 0; i < 3; ++i)
        {
            if (this.field_74215_y.field_75167_g[i] != 0)
            {
                flag = true;
            }
        }

        if (flag)
        {
            this.field_74209_t += 0.2F;
        }
        else
        {
            this.field_74209_t -= 0.2F;
        }

        if (this.field_74209_t < 0.0F)
        {
            this.field_74209_t = 0.0F;
        }

        if (this.field_74209_t > 1.0F)
        {
            this.field_74209_t = 1.0F;
        }

        float f = (this.field_74211_r - this.field_74213_p) * 0.4F;
        float f1 = 0.2F;

        if (f < -f1)
        {
            f = -f1;
        }

        if (f > f1)
        {
            f = f1;
        }

        this.field_74210_s += (f - this.field_74210_s) * 0.9F;
        this.field_74213_p += this.field_74210_s;
    }
}
