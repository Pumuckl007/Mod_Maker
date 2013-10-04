package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.ResourceManagerReloadListener;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class TextureManager implements Tickable, ResourceManagerReloadListener
{
    private final Map field_110585_a = Maps.newHashMap();
    private final Map field_130089_b = Maps.newHashMap();
    private final List field_110583_b = Lists.newArrayList();
    private final Map field_110584_c = Maps.newHashMap();
    private ResourceManager field_110582_d;

    public TextureManager(ResourceManager p_i1284_1_)
    {
        this.field_110582_d = p_i1284_1_;
    }

    public void func_110577_a(ResourceLocation p_110577_1_)
    {
        Object object = (TextureObject)this.field_110585_a.get(p_110577_1_);

        if (object == null)
        {
            object = new SimpleTexture(p_110577_1_);
            this.func_110579_a(p_110577_1_, (TextureObject)object);
        }

        TextureUtil.func_94277_a(((TextureObject)object).func_110552_b());
    }

    public ResourceLocation func_130087_a(int p_130087_1_)
    {
        return (ResourceLocation)this.field_130089_b.get(Integer.valueOf(p_130087_1_));
    }

    public boolean func_130088_a(ResourceLocation p_130088_1_, TextureMap p_130088_2_)
    {
        if (this.func_110580_a(p_130088_1_, p_130088_2_))
        {
            this.field_130089_b.put(Integer.valueOf(p_130088_2_.func_130086_a()), p_130088_1_);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean func_110580_a(ResourceLocation p_110580_1_, TickableTextureObject p_110580_2_)
    {
        if (this.func_110579_a(p_110580_1_, p_110580_2_))
        {
            this.field_110583_b.add(p_110580_2_);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean func_110579_a(ResourceLocation p_110579_1_, TextureObject p_110579_2_)
    {
        boolean flag = true;

        try
        {
            ((TextureObject)p_110579_2_).func_110551_a(this.field_110582_d);
        }
        catch (IOException ioexception)
        {
            Minecraft.func_71410_x().func_98033_al().func_98235_b("Failed to load texture: " + p_110579_1_, ioexception);
            p_110579_2_ = TextureUtil.field_111001_a;
            this.field_110585_a.put(p_110579_1_, p_110579_2_);
            flag = false;
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.func_85055_a(throwable, "Registering texture");
            CrashReportCategory crashreportcategory = crashreport.func_85058_a("Resource location being registered");
            crashreportcategory.func_71507_a("Resource location", p_110579_1_);
            crashreportcategory.func_71500_a("Texture object class", new TextureManagerINNER1(this, (TextureObject)p_110579_2_));
            throw new ReportedException(crashreport);
        }

        this.field_110585_a.put(p_110579_1_, p_110579_2_);
        return flag;
    }

    public TextureObject func_110581_b(ResourceLocation p_110581_1_)
    {
        return (TextureObject)this.field_110585_a.get(p_110581_1_);
    }

    public ResourceLocation func_110578_a(String p_110578_1_, DynamicTexture p_110578_2_)
    {
        Integer integer = (Integer)this.field_110584_c.get(p_110578_1_);

        if (integer == null)
        {
            integer = Integer.valueOf(1);
        }
        else
        {
            integer = Integer.valueOf(integer.intValue() + 1);
        }

        this.field_110584_c.put(p_110578_1_, integer);
        ResourceLocation resourcelocation = new ResourceLocation(String.format("dynamic/%s_%d", new Object[] {p_110578_1_, integer}));
        this.func_110579_a(resourcelocation, p_110578_2_);
        return resourcelocation;
    }

    public void func_110550_d()
    {
        Iterator iterator = this.field_110583_b.iterator();

        while (iterator.hasNext())
        {
            Tickable tickable = (Tickable)iterator.next();
            tickable.func_110550_d();
        }
    }

    public void func_110549_a(ResourceManager p_110549_1_)
    {
        Iterator iterator = this.field_110585_a.entrySet().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();
            this.func_110579_a((ResourceLocation)entry.getKey(), (TextureObject)entry.getValue());
        }
    }
}
