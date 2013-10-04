package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiFurnace extends GuiContainer
{
    private static final ResourceLocation field_110410_t = new ResourceLocation("textures/gui/container/furnace.png");
    private TileEntityFurnace field_74204_o;

    public GuiFurnace(InventoryPlayer p_i1091_1_, TileEntityFurnace p_i1091_2_)
    {
        super(new ContainerFurnace(p_i1091_1_, p_i1091_2_));
        this.field_74204_o = p_i1091_2_;
    }

    protected void func_74189_g(int p_74189_1_, int p_74189_2_)
    {
        String s = this.field_74204_o.func_94042_c() ? this.field_74204_o.func_70303_b() : I18n.func_135053_a(this.field_74204_o.func_70303_b());
        this.field_73886_k.func_78276_b(s, this.field_74194_b / 2 - this.field_73886_k.func_78256_a(s) / 2, 6, 4210752);
        this.field_73886_k.func_78276_b(I18n.func_135053_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110410_t);
        int k = (this.field_73880_f - this.field_74194_b) / 2;
        int l = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(k, l, 0, 0, this.field_74194_b, this.field_74195_c);
        int i1;

        if (this.field_74204_o.func_70400_i())
        {
            i1 = this.field_74204_o.func_70403_d(12);
            this.func_73729_b(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.field_74204_o.func_70397_c(24);
        this.func_73729_b(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }
}
