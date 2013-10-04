package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TextureUtil
{
    private static final IntBuffer field_111000_c = GLAllocation.func_74527_f(4194304);
    public static final DynamicTexture field_111001_a = new DynamicTexture(16, 16);
    public static final int[] field_110999_b = field_111001_a.func_110565_c();

    public static int func_110996_a()
    {
        return GL11.glGenTextures();
    }

    public static int func_110987_a(int p_110987_0_, BufferedImage p_110987_1_)
    {
        return func_110989_a(p_110987_0_, p_110987_1_, false, false);
    }

    public static void func_110988_a(int p_110988_0_, int[] p_110988_1_, int p_110988_2_, int p_110988_3_)
    {
        func_94277_a(p_110988_0_);
        func_110998_a(p_110988_1_, p_110988_2_, p_110988_3_, 0, 0, false, false);
    }

    public static void func_110998_a(int[] p_110998_0_, int p_110998_1_, int p_110998_2_, int p_110998_3_, int p_110998_4_, boolean p_110998_5_, boolean p_110998_6_)
    {
        int i1 = 4194304 / p_110998_1_;
        func_110992_b(p_110998_5_);
        func_110997_a(p_110998_6_);
        int j1;

        for (int k1 = 0; k1 < p_110998_1_ * p_110998_2_; k1 += p_110998_1_ * j1)
        {
            int l1 = k1 / p_110998_1_;
            j1 = Math.min(i1, p_110998_2_ - l1);
            int i2 = p_110998_1_ * j1;
            func_110994_a(p_110998_0_, k1, i2);
            GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, 0, p_110998_3_, p_110998_4_ + l1, p_110998_1_, j1, GL12.GL_BGRA, GL12.GL_UNSIGNED_INT_8_8_8_8_REV, field_111000_c);
        }
    }

    public static int func_110989_a(int p_110989_0_, BufferedImage p_110989_1_, boolean p_110989_2_, boolean p_110989_3_)
    {
        func_110991_a(p_110989_0_, p_110989_1_.getWidth(), p_110989_1_.getHeight());
        return func_110995_a(p_110989_0_, p_110989_1_, 0, 0, p_110989_2_, p_110989_3_);
    }

    public static void func_110991_a(int p_110991_0_, int p_110991_1_, int p_110991_2_)
    {
        func_94277_a(p_110991_0_);
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, p_110991_1_, p_110991_2_, 0, GL12.GL_BGRA, GL12.GL_UNSIGNED_INT_8_8_8_8_REV, (IntBuffer)null);
    }

    public static int func_110995_a(int p_110995_0_, BufferedImage p_110995_1_, int p_110995_2_, int p_110995_3_, boolean p_110995_4_, boolean p_110995_5_)
    {
        func_94277_a(p_110995_0_);
        func_110993_a(p_110995_1_, p_110995_2_, p_110995_3_, p_110995_4_, p_110995_5_);
        return p_110995_0_;
    }

    private static void func_110993_a(BufferedImage p_110993_0_, int p_110993_1_, int p_110993_2_, boolean p_110993_3_, boolean p_110993_4_)
    {
        int k = p_110993_0_.getWidth();
        int l = p_110993_0_.getHeight();
        int i1 = 4194304 / k;
        int[] aint = new int[i1 * k];
        func_110992_b(p_110993_3_);
        func_110997_a(p_110993_4_);

        for (int j1 = 0; j1 < k * l; j1 += k * i1)
        {
            int k1 = j1 / k;
            int l1 = Math.min(i1, l - k1);
            int i2 = k * l1;
            p_110993_0_.getRGB(0, k1, k, l1, aint, 0, k);
            func_110990_a(aint, i2);
            GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, 0, p_110993_1_, p_110993_2_ + k1, k, l1, GL12.GL_BGRA, GL12.GL_UNSIGNED_INT_8_8_8_8_REV, field_111000_c);
        }
    }

    private static void func_110997_a(boolean p_110997_0_)
    {
        if (p_110997_0_)
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
        }
        else
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
        }
    }

    private static void func_110992_b(boolean p_110992_0_)
    {
        if (p_110992_0_)
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        }
        else
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        }
    }

    private static void func_110990_a(int[] p_110990_0_, int p_110990_1_)
    {
        func_110994_a(p_110990_0_, 0, p_110990_1_);
    }

    private static void func_110994_a(int[] p_110994_0_, int p_110994_1_, int p_110994_2_)
    {
        int[] aint1 = p_110994_0_;

        if (Minecraft.func_71410_x().field_71474_y.field_74337_g)
        {
            aint1 = func_110985_a(p_110994_0_);
        }

        field_111000_c.clear();
        field_111000_c.put(aint1, p_110994_1_, p_110994_2_);
        field_111000_c.position(0).limit(p_110994_2_);
    }

    static void func_94277_a(int p_94277_0_)
    {
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, p_94277_0_);
    }

    public static int[] func_110986_a(ResourceManager p_110986_0_, ResourceLocation p_110986_1_) throws IOException
    {
        BufferedImage bufferedimage = ImageIO.read(p_110986_0_.func_110536_a(p_110986_1_).func_110527_b());
        int i = bufferedimage.getWidth();
        int j = bufferedimage.getHeight();
        int[] aint = new int[i * j];
        bufferedimage.getRGB(0, 0, i, j, aint, 0, i);
        return aint;
    }

    public static int[] func_110985_a(int[] p_110985_0_)
    {
        int[] aint1 = new int[p_110985_0_.length];

        for (int i = 0; i < p_110985_0_.length; ++i)
        {
            int j = p_110985_0_[i] >> 24 & 255;
            int k = p_110985_0_[i] >> 16 & 255;
            int l = p_110985_0_[i] >> 8 & 255;
            int i1 = p_110985_0_[i] & 255;
            int j1 = (k * 30 + l * 59 + i1 * 11) / 100;
            int k1 = (k * 30 + l * 70) / 100;
            int l1 = (k * 30 + i1 * 70) / 100;
            aint1[i] = j << 24 | j1 << 16 | k1 << 8 | l1;
        }

        return aint1;
    }

    static
    {
        int i = -16777216;
        int j = -524040;
        int[] aint = new int[] { -524040, -524040, -524040, -524040, -524040, -524040, -524040, -524040};
        int[] aint1 = new int[] { -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216};
        int k = aint.length;

        for (int l = 0; l < 16; ++l)
        {
            System.arraycopy(l < k ? aint : aint1, 0, field_110999_b, 16 * l, k);
            System.arraycopy(l < k ? aint1 : aint, 0, field_110999_b, 16 * l + k, k);
        }

        field_111001_a.func_110564_a();
    }
}
