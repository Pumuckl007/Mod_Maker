package net.minecraft.client.resources;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.FileFilter;

@SideOnly(Side.CLIENT)
final class ResourcePackRepositoryFilter implements FileFilter
{
    public boolean accept(File p_accept_1_)
    {
        boolean flag = p_accept_1_.isFile() && p_accept_1_.getName().endsWith(".zip");
        boolean flag1 = p_accept_1_.isDirectory() && (new File(p_accept_1_, "pack.mcmeta")).isFile();
        return flag || flag1;
    }
}
