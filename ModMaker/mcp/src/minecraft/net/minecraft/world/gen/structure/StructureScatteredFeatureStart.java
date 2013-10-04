package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class StructureScatteredFeatureStart extends StructureStart
{
    public StructureScatteredFeatureStart() {}

    public StructureScatteredFeatureStart(World p_i2060_1_, Random p_i2060_2_, int p_i2060_3_, int p_i2060_4_)
    {
        super(p_i2060_3_, p_i2060_4_);
        BiomeGenBase biomegenbase = p_i2060_1_.func_72807_a(p_i2060_3_ * 16 + 8, p_i2060_4_ * 16 + 8);

        if (biomegenbase != BiomeGenBase.field_76782_w && biomegenbase != BiomeGenBase.field_76792_x)
        {
            if (biomegenbase == BiomeGenBase.field_76780_h)
            {
                ComponentScatteredFeatureSwampHut componentscatteredfeatureswamphut = new ComponentScatteredFeatureSwampHut(p_i2060_2_, p_i2060_3_ * 16, p_i2060_4_ * 16);
                this.field_75075_a.add(componentscatteredfeatureswamphut);
            }
            else
            {
                ComponentScatteredFeatureDesertPyramid componentscatteredfeaturedesertpyramid = new ComponentScatteredFeatureDesertPyramid(p_i2060_2_, p_i2060_3_ * 16, p_i2060_4_ * 16);
                this.field_75075_a.add(componentscatteredfeaturedesertpyramid);
            }
        }
        else
        {
            ComponentScatteredFeatureJunglePyramid componentscatteredfeaturejunglepyramid = new ComponentScatteredFeatureJunglePyramid(p_i2060_2_, p_i2060_3_ * 16, p_i2060_4_ * 16);
            this.field_75075_a.add(componentscatteredfeaturejunglepyramid);
        }

        this.func_75072_c();
    }
}
