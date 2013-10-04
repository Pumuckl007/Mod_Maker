package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartTNT;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderTntMinecart extends RenderMinecart
{
    protected void func_94146_a(EntityMinecartTNT p_94146_1_, float p_94146_2_, Block p_94146_3_, int p_94146_4_)
    {
        int j = p_94146_1_.func_94104_d();

        if (j > -1 && (float)j - p_94146_2_ + 1.0F < 10.0F)
        {
            float f1 = 1.0F - ((float)j - p_94146_2_ + 1.0F) / 10.0F;

            if (f1 < 0.0F)
            {
                f1 = 0.0F;
            }

            if (f1 > 1.0F)
            {
                f1 = 1.0F;
            }

            f1 *= f1;
            f1 *= f1;
            float f2 = 1.0F + f1 * 0.3F;
            GL11.glScalef(f2, f2, f2);
        }

        super.func_94144_a(p_94146_1_, p_94146_2_, p_94146_3_, p_94146_4_);

        if (j > -1 && j / 5 % 2 == 0)
        {
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_DST_ALPHA);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, (1.0F - ((float)j - p_94146_2_ + 1.0F) / 100.0F) * 0.8F);
            GL11.glPushMatrix();
            this.field_94145_f.func_78600_a(Block.field_72091_am, 0, 1.0F);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
        }
    }

    protected void func_94144_a(EntityMinecart p_94144_1_, float p_94144_2_, Block p_94144_3_, int p_94144_4_)
    {
        this.func_94146_a((EntityMinecartTNT)p_94144_1_, p_94144_2_, p_94144_3_, p_94144_4_);
    }
}
