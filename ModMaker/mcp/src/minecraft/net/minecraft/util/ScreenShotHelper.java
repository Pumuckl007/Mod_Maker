package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.IntBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class ScreenShotHelper
{
    private static final DateFormat field_74295_a = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    private static IntBuffer field_74293_b;
    private static int[] field_74294_c;

    public static String func_74291_a(File p_74291_0_, int p_74291_1_, int p_74291_2_)
    {
        return func_74292_a(p_74291_0_, (String)null, p_74291_1_, p_74291_2_);
    }

    public static String func_74292_a(File p_74292_0_, String p_74292_1_, int p_74292_2_, int p_74292_3_)
    {
        try
        {
            File file2 = new File(p_74292_0_, "screenshots");
            file2.mkdir();
            int k = p_74292_2_ * p_74292_3_;

            if (field_74293_b == null || field_74293_b.capacity() < k)
            {
                field_74293_b = BufferUtils.createIntBuffer(k);
                field_74294_c = new int[k];
            }

            GL11.glPixelStorei(GL11.GL_PACK_ALIGNMENT, 1);
            GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
            field_74293_b.clear();
            GL11.glReadPixels(0, 0, p_74292_2_, p_74292_3_, GL12.GL_BGRA, GL12.GL_UNSIGNED_INT_8_8_8_8_REV, field_74293_b);
            field_74293_b.get(field_74294_c);
            func_74289_a(field_74294_c, p_74292_2_, p_74292_3_);
            BufferedImage bufferedimage = new BufferedImage(p_74292_2_, p_74292_3_, 1);
            bufferedimage.setRGB(0, 0, p_74292_2_, p_74292_3_, field_74294_c, 0, p_74292_2_);
            File file3;

            if (p_74292_1_ == null)
            {
                file3 = func_74290_a(file2);
            }
            else
            {
                file3 = new File(file2, p_74292_1_);
            }

            ImageIO.write(bufferedimage, "png", file3);
            return "Saved screenshot as " + file3.getName();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return "Failed to save: " + exception;
        }
    }

    private static File func_74290_a(File p_74290_0_)
    {
        String s = field_74295_a.format(new Date()).toString();
        int i = 1;

        while (true)
        {
            File file2 = new File(p_74290_0_, s + (i == 1 ? "" : "_" + i) + ".png");

            if (!file2.exists())
            {
                return file2;
            }

            ++i;
        }
    }

    private static void func_74289_a(int[] p_74289_0_, int p_74289_1_, int p_74289_2_)
    {
        int[] aint1 = new int[p_74289_1_];
        int k = p_74289_2_ / 2;

        for (int l = 0; l < k; ++l)
        {
            System.arraycopy(p_74289_0_, l * p_74289_1_, aint1, 0, p_74289_1_);
            System.arraycopy(p_74289_0_, (p_74289_2_ - 1 - l) * p_74289_1_, p_74289_0_, l * p_74289_1_, p_74289_1_);
            System.arraycopy(aint1, 0, p_74289_0_, (p_74289_2_ - 1 - l) * p_74289_1_, p_74289_1_);
        }
    }
}
