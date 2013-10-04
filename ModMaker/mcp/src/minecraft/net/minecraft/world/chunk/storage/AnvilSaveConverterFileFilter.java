package net.minecraft.world.chunk.storage;

import java.io.File;
import java.io.FilenameFilter;

class AnvilSaveConverterFileFilter implements FilenameFilter
{
    final AnvilSaveConverter field_76172_a;

    AnvilSaveConverterFileFilter(AnvilSaveConverter p_i2143_1_)
    {
        this.field_76172_a = p_i2143_1_;
    }

    public boolean accept(File p_accept_1_, String p_accept_2_)
    {
        return p_accept_2_.endsWith(".mcr");
    }
}
