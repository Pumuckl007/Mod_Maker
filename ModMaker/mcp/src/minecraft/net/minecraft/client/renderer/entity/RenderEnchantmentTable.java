package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEnchantmentTable extends TileEntitySpecialRenderer
{
    private static final ResourceLocation field_110636_a = new ResourceLocation("textures/entity/enchanting_table_book.png");
    private ModelBook field_76902_a = new ModelBook();

    public void func_76901_a(TileEntityEnchantmentTable p_76901_1_, double p_76901_2_, double p_76901_4_, double p_76901_6_, float p_76901_8_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76901_2_ + 0.5F, (float)p_76901_4_ + 0.75F, (float)p_76901_6_ + 0.5F);
        float f1 = (float)p_76901_1_.field_70378_a + p_76901_8_;
        GL11.glTranslatef(0.0F, 0.1F + MathHelper.func_76126_a(f1 * 0.1F) * 0.01F, 0.0F);
        float f2;

        for (f2 = p_76901_1_.field_70380_h - p_76901_1_.field_70381_i; f2 >= (float)Math.PI; f2 -= ((float)Math.PI * 2F))
        {
            ;
        }

        while (f2 < -(float)Math.PI)
        {
            f2 += ((float)Math.PI * 2F);
        }

        float f3 = p_76901_1_.field_70381_i + f2 * p_76901_8_;
        GL11.glRotatef(-f3 * 180.0F / (float)Math.PI, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(80.0F, 0.0F, 0.0F, 1.0F);
        this.func_110628_a(field_110636_a);
        float f4 = p_76901_1_.field_70377_c + (p_76901_1_.field_70375_b - p_76901_1_.field_70377_c) * p_76901_8_ + 0.25F;
        float f5 = p_76901_1_.field_70377_c + (p_76901_1_.field_70375_b - p_76901_1_.field_70377_c) * p_76901_8_ + 0.75F;
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

        float f6 = p_76901_1_.field_70372_g + (p_76901_1_.field_70371_f - p_76901_1_.field_70372_g) * p_76901_8_;
        GL11.glEnable(GL11.GL_CULL_FACE);
        this.field_76902_a.func_78088_a((Entity)null, f1, f4, f5, f6, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_)
    {
        this.func_76901_a((TileEntityEnchantmentTable)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
