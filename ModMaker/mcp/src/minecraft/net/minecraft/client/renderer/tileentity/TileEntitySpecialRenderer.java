package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public abstract class TileEntitySpecialRenderer
{
    protected TileEntityRenderer field_76898_b;

    public abstract void func_76894_a(TileEntity tileentity, double d0, double d1, double d2, float f);

    protected void func_110628_a(ResourceLocation p_110628_1_)
    {
        TextureManager texturemanager = this.field_76898_b.field_76960_e;

        if (texturemanager != null)
        {
            texturemanager.func_110577_a(p_110628_1_);
        }
    }

    public void func_76893_a(TileEntityRenderer p_76893_1_)
    {
        this.field_76898_b = p_76893_1_;
    }

    public void func_76896_a(World p_76896_1_) {}

    public FontRenderer func_76895_b()
    {
        return this.field_76898_b.func_76954_a();
    }
}
