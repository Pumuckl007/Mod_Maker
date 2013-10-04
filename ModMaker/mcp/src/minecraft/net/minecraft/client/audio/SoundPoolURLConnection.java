package net.minecraft.client.audio;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
class SoundPoolURLConnection extends URLConnection
{
    private final ResourceLocation field_110659_b;

    final SoundPool field_110660_a;

    private SoundPoolURLConnection(SoundPool p_i1328_1_, URL p_i1328_2_)
    {
        super(p_i1328_2_);
        this.field_110660_a = p_i1328_1_;
        this.field_110659_b = new ResourceLocation(p_i1328_2_.getPath());
    }

    public void connect() {}

    public InputStream getInputStream()
    {
        try
        {
            return SoundPool.func_110655_a(this.field_110660_a).func_110536_a(this.field_110659_b).func_110527_b();
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    SoundPoolURLConnection(SoundPool p_i1329_1_, URL p_i1329_2_, SoundPoolProtocolHandler p_i1329_3_)
    {
        this(p_i1329_1_, p_i1329_2_);
    }
}
