package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.StitcherException;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class TextureMap extends AbstractTexture implements TickableTextureObject, IconRegister
{
    public static final ResourceLocation field_110575_b = new ResourceLocation("textures/atlas/blocks.png");
    public static final ResourceLocation field_110576_c = new ResourceLocation("textures/atlas/items.png");
    private final List field_94258_i = Lists.newArrayList();
    private final Map field_110574_e = Maps.newHashMap();
    private final Map field_94252_e = Maps.newHashMap();
    public final int field_94255_a;
    public final String field_94254_c;
    private final TextureAtlasSprite field_94249_f = new TextureAtlasSprite("missingno");

    public TextureMap(int p_i1281_1_, String p_i1281_2_)
    {
        this.field_94255_a = p_i1281_1_;
        this.field_94254_c = p_i1281_2_;
        this.func_110573_f();
    }

    private void func_110569_e()
    {
        this.field_94249_f.func_110968_a(Lists.newArrayList(new int[][] {TextureUtil.field_110999_b}));
        this.field_94249_f.func_110966_b(16);
        this.field_94249_f.func_110969_c(16);
    }

    public void func_110551_a(ResourceManager p_110551_1_) throws IOException
    {
        this.func_110569_e();
        this.func_110571_b(p_110551_1_);
    }

    public void func_110571_b(ResourceManager p_110571_1_)
    {
        int i = Minecraft.func_71369_N();
        Stitcher stitcher = new Stitcher(i, i, true);
        this.field_94252_e.clear();
        this.field_94258_i.clear();
        Iterator iterator = this.field_110574_e.entrySet().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();
            ResourceLocation resourcelocation = new ResourceLocation((String)entry.getKey());
            TextureAtlasSprite textureatlassprite = (TextureAtlasSprite)entry.getValue();
            ResourceLocation resourcelocation1 = new ResourceLocation(resourcelocation.func_110624_b(), String.format("%s/%s%s", new Object[] {this.field_94254_c, resourcelocation.func_110623_a(), ".png"}));

            try
            {
                textureatlassprite.func_130100_a(p_110571_1_.func_110536_a(resourcelocation1));
            }
            catch (RuntimeException runtimeexception)
            {
                Minecraft.func_71410_x().func_98033_al().func_98232_c(String.format("Unable to parse animation metadata from %s: %s", new Object[] {resourcelocation1, runtimeexception.getMessage()}));
                continue;
            }
            catch (IOException ioexception)
            {
                Minecraft.func_71410_x().func_98033_al().func_98232_c("Using missing texture, unable to load: " + resourcelocation1);
                continue;
            }

            stitcher.func_110934_a(textureatlassprite);
        }

        stitcher.func_110934_a(this.field_94249_f);

        try
        {
            stitcher.func_94305_f();
        }
        catch (StitcherException stitcherexception)
        {
            throw stitcherexception;
        }

        TextureUtil.func_110991_a(this.func_110552_b(), stitcher.func_110935_a(), stitcher.func_110936_b());
        HashMap hashmap = Maps.newHashMap(this.field_110574_e);
        Iterator iterator1 = stitcher.func_94309_g().iterator();
        TextureAtlasSprite textureatlassprite1;

        while (iterator1.hasNext())
        {
            textureatlassprite1 = (TextureAtlasSprite)iterator1.next();
            String s = textureatlassprite1.func_94215_i();
            hashmap.remove(s);
            this.field_94252_e.put(s, textureatlassprite1);

            try
            {
                TextureUtil.func_110998_a(textureatlassprite1.func_110965_a(0), textureatlassprite1.func_94211_a(), textureatlassprite1.func_94216_b(), textureatlassprite1.func_130010_a(), textureatlassprite1.func_110967_i(), false, false);
            }
            catch (Throwable throwable)
            {
                CrashReport crashreport = CrashReport.func_85055_a(throwable, "Stitching texture atlas");
                CrashReportCategory crashreportcategory = crashreport.func_85058_a("Texture being stitched together");
                crashreportcategory.func_71507_a("Atlas path", this.field_94254_c);
                crashreportcategory.func_71507_a("Sprite", textureatlassprite1);
                throw new ReportedException(crashreport);
            }

            if (textureatlassprite1.func_130098_m())
            {
                this.field_94258_i.add(textureatlassprite1);
            }
            else
            {
                textureatlassprite1.func_130103_l();
            }
        }

        iterator1 = hashmap.values().iterator();

        while (iterator1.hasNext())
        {
            textureatlassprite1 = (TextureAtlasSprite)iterator1.next();
            textureatlassprite1.func_94217_a(this.field_94249_f);
        }
    }

    private void func_110573_f()
    {
        this.field_110574_e.clear();
        int i;
        int j;

        if (this.field_94255_a == 0)
        {
            Block[] ablock = Block.field_71973_m;
            i = ablock.length;

            for (j = 0; j < i; ++j)
            {
                Block block = ablock[j];

                if (block != null)
                {
                    block.func_94332_a(this);
                }
            }

            Minecraft.func_71410_x().field_71438_f.func_94140_a(this);
            RenderManager.field_78727_a.func_94178_a(this);
        }

        Item[] aitem = Item.field_77698_e;
        i = aitem.length;

        for (j = 0; j < i; ++j)
        {
            Item item = aitem[j];

            if (item != null && item.func_94901_k() == this.field_94255_a)
            {
                item.func_94581_a(this);
            }
        }
    }

    public TextureAtlasSprite func_110572_b(String p_110572_1_)
    {
        TextureAtlasSprite textureatlassprite = (TextureAtlasSprite)this.field_94252_e.get(p_110572_1_);

        if (textureatlassprite == null)
        {
            textureatlassprite = this.field_94249_f;
        }

        return textureatlassprite;
    }

    public void func_94248_c()
    {
        TextureUtil.func_94277_a(this.func_110552_b());
        Iterator iterator = this.field_94258_i.iterator();

        while (iterator.hasNext())
        {
            TextureAtlasSprite textureatlassprite = (TextureAtlasSprite)iterator.next();
            textureatlassprite.func_94219_l();
        }
    }

    public Icon func_94245_a(String p_94245_1_)
    {
        if (p_94245_1_ == null)
        {
            (new RuntimeException("Don\'t register null!")).printStackTrace();
        }

        Object object = (TextureAtlasSprite)this.field_110574_e.get(p_94245_1_);

        if (object == null)
        {
            if (this.field_94255_a == 1)
            {
                if ("clock".equals(p_94245_1_))
                {
                    object = new TextureClock(p_94245_1_);
                }
                else if ("compass".equals(p_94245_1_))
                {
                    object = new TextureCompass(p_94245_1_);
                }
                else
                {
                    object = new TextureAtlasSprite(p_94245_1_);
                }
            }
            else
            {
                object = new TextureAtlasSprite(p_94245_1_);
            }

            this.field_110574_e.put(p_94245_1_, object);
        }

        return (Icon)object;
    }

    public int func_130086_a()
    {
        return this.field_94255_a;
    }

    public void func_110550_d()
    {
        this.func_94248_c();
    }
}
