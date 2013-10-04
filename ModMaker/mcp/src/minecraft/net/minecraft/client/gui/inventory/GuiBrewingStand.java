package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerBrewingStand;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiBrewingStand extends GuiContainer
{
    private static final ResourceLocation field_110420_t = new ResourceLocation("textures/gui/container/brewing_stand.png");
    private TileEntityBrewingStand field_74217_o;

    public GuiBrewingStand(InventoryPlayer p_i1081_1_, TileEntityBrewingStand p_i1081_2_)
    {
        super(new ContainerBrewingStand(p_i1081_1_, p_i1081_2_));
        this.field_74217_o = p_i1081_2_;
    }

    protected void func_74189_g(int p_74189_1_, int p_74189_2_)
    {
        String s = this.field_74217_o.func_94042_c() ? this.field_74217_o.func_70303_b() : I18n.func_135053_a(this.field_74217_o.func_70303_b());
        this.field_73886_k.func_78276_b(s, this.field_74194_b / 2 - this.field_73886_k.func_78256_a(s) / 2, 6, 4210752);
        this.field_73886_k.func_78276_b(I18n.func_135053_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110420_t);
        int k = (this.field_73880_f - this.field_74194_b) / 2;
        int l = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(k, l, 0, 0, this.field_74194_b, this.field_74195_c);
        int i1 = this.field_74217_o.func_70355_t_();

        if (i1 > 0)
        {
            int j1 = (int)(28.0F * (1.0F - (float)i1 / 400.0F));

            if (j1 > 0)
            {
                this.func_73729_b(k + 97, l + 16, 176, 0, 9, j1);
            }

            int k1 = i1 / 2 % 7;

            switch (k1)
            {
                case 0:
                    j1 = 29;
                    break;
                case 1:
                    j1 = 24;
                    break;
                case 2:
                    j1 = 20;
                    break;
                case 3:
                    j1 = 16;
                    break;
                case 4:
                    j1 = 11;
                    break;
                case 5:
                    j1 = 6;
                    break;
                case 6:
                    j1 = 0;
            }

            if (j1 > 0)
            {
                this.func_73729_b(k + 65, l + 14 + 29 - j1, 185, 29 - j1, 12, j1);
            }
        }
    }
}
