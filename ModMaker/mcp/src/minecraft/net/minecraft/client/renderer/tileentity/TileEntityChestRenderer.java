package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityChestRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation field_110635_a = new ResourceLocation("textures/entity/chest/trapped_double.png");
    private static final ResourceLocation field_110634_c = new ResourceLocation("textures/entity/chest/christmas_double.png");
    private static final ResourceLocation field_110632_d = new ResourceLocation("textures/entity/chest/normal_double.png");
    private static final ResourceLocation field_110633_e = new ResourceLocation("textures/entity/chest/trapped.png");
    private static final ResourceLocation field_110630_f = new ResourceLocation("textures/entity/chest/christmas.png");
    private static final ResourceLocation field_110631_g = new ResourceLocation("textures/entity/chest/normal.png");
    private ModelChest field_76913_a = new ModelChest();
    private ModelChest field_76912_c = new ModelLargeChest();
    private boolean field_92061_d;

    public TileEntityChestRenderer()
    {
        Calendar calendar = Calendar.getInstance();

        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26)
        {
            this.field_92061_d = true;
        }
    }

    public void func_76911_a(TileEntityChest p_76911_1_, double p_76911_2_, double p_76911_4_, double p_76911_6_, float p_76911_8_)
    {
        int i;

        if (!p_76911_1_.func_70309_m())
        {
            i = 0;
        }
        else
        {
            Block block = p_76911_1_.func_70311_o();
            i = p_76911_1_.func_70322_n();

            if (block instanceof BlockChest && i == 0)
            {
                ((BlockChest)block).func_72290_b_(p_76911_1_.func_70314_l(), p_76911_1_.field_70329_l, p_76911_1_.field_70330_m, p_76911_1_.field_70327_n);
                i = p_76911_1_.func_70322_n();
            }

            p_76911_1_.func_70418_i();
        }

        if (p_76911_1_.field_70423_b == null && p_76911_1_.field_70421_d == null)
        {
            ModelChest modelchest;

            if (p_76911_1_.field_70424_c == null && p_76911_1_.field_70422_e == null)
            {
                modelchest = this.field_76913_a;

                if (p_76911_1_.func_98041_l() == 1)
                {
                    this.func_110628_a(field_110633_e);
                }
                else if (this.field_92061_d)
                {
                    this.func_110628_a(field_110630_f);
                }
                else
                {
                    this.func_110628_a(field_110631_g);
                }
            }
            else
            {
                modelchest = this.field_76912_c;

                if (p_76911_1_.func_98041_l() == 1)
                {
                    this.func_110628_a(field_110635_a);
                }
                else if (this.field_92061_d)
                {
                    this.func_110628_a(field_110634_c);
                }
                else
                {
                    this.func_110628_a(field_110632_d);
                }
            }

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float)p_76911_2_, (float)p_76911_4_ + 1.0F, (float)p_76911_6_ + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short short1 = 0;

            if (i == 2)
            {
                short1 = 180;
            }

            if (i == 3)
            {
                short1 = 0;
            }

            if (i == 4)
            {
                short1 = 90;
            }

            if (i == 5)
            {
                short1 = -90;
            }

            if (i == 2 && p_76911_1_.field_70424_c != null)
            {
                GL11.glTranslatef(1.0F, 0.0F, 0.0F);
            }

            if (i == 5 && p_76911_1_.field_70422_e != null)
            {
                GL11.glTranslatef(0.0F, 0.0F, -1.0F);
            }

            GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f1 = p_76911_1_.field_70420_g + (p_76911_1_.field_70419_f - p_76911_1_.field_70420_g) * p_76911_8_;
            float f2;

            if (p_76911_1_.field_70423_b != null)
            {
                f2 = p_76911_1_.field_70423_b.field_70420_g + (p_76911_1_.field_70423_b.field_70419_f - p_76911_1_.field_70423_b.field_70420_g) * p_76911_8_;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            if (p_76911_1_.field_70421_d != null)
            {
                f2 = p_76911_1_.field_70421_d.field_70420_g + (p_76911_1_.field_70421_d.field_70419_f - p_76911_1_.field_70421_d.field_70420_g) * p_76911_8_;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            f1 = 1.0F - f1;
            f1 = 1.0F - f1 * f1 * f1;
            modelchest.field_78234_a.field_78795_f = -(f1 * (float)Math.PI / 2.0F);
            modelchest.func_78231_a();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_)
    {
        this.func_76911_a((TileEntityChest)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
