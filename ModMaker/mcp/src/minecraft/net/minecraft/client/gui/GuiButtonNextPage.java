package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
class GuiButtonNextPage extends GuiButton
{
    private final boolean field_73755_j;

    public GuiButtonNextPage(int p_i1079_1_, int p_i1079_2_, int p_i1079_3_, boolean p_i1079_4_)
    {
        super(p_i1079_1_, p_i1079_2_, p_i1079_3_, 23, 13, "");
        this.field_73755_j = p_i1079_4_;
    }

    public void func_73737_a(Minecraft p_73737_1_, int p_73737_2_, int p_73737_3_)
    {
        if (this.field_73748_h)
        {
            boolean flag = p_73737_2_ >= this.field_73746_c && p_73737_3_ >= this.field_73743_d && p_73737_2_ < this.field_73746_c + this.field_73747_a && p_73737_3_ < this.field_73743_d + this.field_73745_b;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            p_73737_1_.func_110434_K().func_110577_a(GuiScreenBook.func_110404_g());
            int k = 0;
            int l = 192;

            if (flag)
            {
                k += 23;
            }

            if (!this.field_73755_j)
            {
                l += 13;
            }

            this.func_73729_b(this.field_73746_c, this.field_73743_d, k, l, 23, 13);
        }
    }
}
