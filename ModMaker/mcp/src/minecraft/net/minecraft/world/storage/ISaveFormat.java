package net.minecraft.world.storage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.util.IProgressUpdate;

public interface ISaveFormat
{
    ISaveHandler func_75804_a(String s, boolean flag);

    @SideOnly(Side.CLIENT)
    List func_75799_b() throws AnvilConverterException;

    void func_75800_d();

    @SideOnly(Side.CLIENT)
    WorldInfo func_75803_c(String s);

    boolean func_75802_e(String s);

    @SideOnly(Side.CLIENT)
    void func_75806_a(String s, String s1);

    boolean func_75801_b(String s);

    boolean func_75805_a(String s, IProgressUpdate iprogressupdate);

    @SideOnly(Side.CLIENT)
    boolean func_90033_f(String s);
}
