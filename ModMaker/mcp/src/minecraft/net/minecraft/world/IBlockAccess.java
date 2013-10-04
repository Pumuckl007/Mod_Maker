package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3Pool;
import net.minecraft.world.biome.BiomeGenBase;

public interface IBlockAccess
{
    int func_72798_a(int i, int j, int k);

    TileEntity func_72796_p(int i, int j, int k);

    @SideOnly(Side.CLIENT)
    int func_72802_i(int i, int j, int k, int l);

    int func_72805_g(int i, int j, int k);

    @SideOnly(Side.CLIENT)
    float func_72808_j(int i, int j, int k, int l);

    @SideOnly(Side.CLIENT)
    float func_72801_o(int i, int j, int k);

    Material func_72803_f(int i, int j, int k);

    @SideOnly(Side.CLIENT)
    boolean func_72804_r(int i, int j, int k);

    boolean func_72809_s(int i, int j, int k);

    @SideOnly(Side.CLIENT)
    boolean func_72799_c(int i, int j, int k);

    @SideOnly(Side.CLIENT)
    BiomeGenBase func_72807_a(int i, int j);

    @SideOnly(Side.CLIENT)
    int func_72800_K();

    @SideOnly(Side.CLIENT)
    boolean func_72806_N();

    @SideOnly(Side.CLIENT)
    boolean func_72797_t(int i, int j, int k);

    Vec3Pool func_82732_R();

    int func_72879_k(int i, int j, int k, int l);
}
