package net.minecraft.client.audio;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

@SideOnly(Side.CLIENT)
class SoundPoolProtocolHandler extends URLStreamHandler
{
    final SoundPool field_110658_a;

    SoundPoolProtocolHandler(SoundPool p_i1327_1_)
    {
        this.field_110658_a = p_i1327_1_;
    }

    protected URLConnection openConnection(URL p_openConnection_1_)
    {
        return new SoundPoolURLConnection(this.field_110658_a, p_openConnection_1_, (SoundPoolProtocolHandler)null);
    }
}
