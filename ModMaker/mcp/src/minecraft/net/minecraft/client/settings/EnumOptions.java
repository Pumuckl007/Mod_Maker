package net.minecraft.client.settings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public enum EnumOptions
{
    MUSIC("options.music", true, false),
    SOUND("options.sound", true, false),
    INVERT_MOUSE("options.invertMouse", false, true),
    SENSITIVITY("options.sensitivity", true, false),
    FOV("options.fov", true, false),
    GAMMA("options.gamma", true, false),
    RENDER_DISTANCE("options.renderDistance", false, false),
    VIEW_BOBBING("options.viewBobbing", false, true),
    ANAGLYPH("options.anaglyph", false, true),
    ADVANCED_OPENGL("options.advancedOpengl", false, true),
    FRAMERATE_LIMIT("options.framerateLimit", false, false),
    DIFFICULTY("options.difficulty", false, false),
    GRAPHICS("options.graphics", false, false),
    AMBIENT_OCCLUSION("options.ao", false, false),
    GUI_SCALE("options.guiScale", false, false),
    RENDER_CLOUDS("options.renderClouds", false, true),
    PARTICLES("options.particles", false, false),
    CHAT_VISIBILITY("options.chat.visibility", false, false),
    CHAT_COLOR("options.chat.color", false, true),
    CHAT_LINKS("options.chat.links", false, true),
    CHAT_OPACITY("options.chat.opacity", true, false),
    CHAT_LINKS_PROMPT("options.chat.links.prompt", false, true),
    USE_SERVER_TEXTURES("options.serverTextures", false, true),
    SNOOPER_ENABLED("options.snooper", false, true),
    USE_FULLSCREEN("options.fullscreen", false, true),
    ENABLE_VSYNC("options.vsync", false, true),
    SHOW_CAPE("options.showCape", false, true),
    TOUCHSCREEN("options.touchscreen", false, true),
    CHAT_SCALE("options.chat.scale", true, false),
    CHAT_WIDTH("options.chat.width", true, false),
    CHAT_HEIGHT_FOCUSED("options.chat.height.focused", true, false),
    CHAT_HEIGHT_UNFOCUSED("options.chat.height.unfocused", true, false);
    private final boolean field_74385_A;
    private final boolean field_74386_B;
    private final String field_74387_C;

    public static EnumOptions func_74379_a(int p_74379_0_)
    {
        EnumOptions[] aenumoptions = values();
        int j = aenumoptions.length;

        for (int k = 0; k < j; ++k)
        {
            EnumOptions enumoptions = aenumoptions[k];

            if (enumoptions.func_74381_c() == p_74379_0_)
            {
                return enumoptions;
            }
        }

        return null;
    }

    private EnumOptions(String p_i1015_3_, boolean p_i1015_4_, boolean p_i1015_5_)
    {
        this.field_74387_C = p_i1015_3_;
        this.field_74385_A = p_i1015_4_;
        this.field_74386_B = p_i1015_5_;
    }

    public boolean func_74380_a()
    {
        return this.field_74385_A;
    }

    public boolean func_74382_b()
    {
        return this.field_74386_B;
    }

    public int func_74381_c()
    {
        return this.ordinal();
    }

    public String func_74378_d()
    {
        return this.field_74387_C;
    }
}
