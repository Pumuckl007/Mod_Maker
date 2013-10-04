package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.model.ModelSquid;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.RenderEnderCrystal;
import net.minecraft.client.renderer.tileentity.RenderItemFrame;
import net.minecraft.client.renderer.tileentity.RenderWitherSkull;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderManager
{
    public Map field_78729_o = new HashMap();
    public static RenderManager field_78727_a = new RenderManager();
    private FontRenderer field_78736_p;
    public static double field_78725_b;
    public static double field_78726_c;
    public static double field_78723_d;
    public TextureManager field_78724_e;
    public ItemRenderer field_78721_f;
    public World field_78722_g;
    public EntityLivingBase field_78734_h;
    public EntityLivingBase field_96451_i;
    public float field_78735_i;
    public float field_78732_j;
    public GameSettings field_78733_k;
    public double field_78730_l;
    public double field_78731_m;
    public double field_78728_n;
    public static boolean field_85095_o;

    private RenderManager()
    {
        this.field_78729_o.put(EntityCaveSpider.class, new RenderCaveSpider());
        this.field_78729_o.put(EntitySpider.class, new RenderSpider());
        this.field_78729_o.put(EntityPig.class, new RenderPig(new ModelPig(), new ModelPig(0.5F), 0.7F));
        this.field_78729_o.put(EntitySheep.class, new RenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
        this.field_78729_o.put(EntityCow.class, new RenderCow(new ModelCow(), 0.7F));
        this.field_78729_o.put(EntityMooshroom.class, new RenderMooshroom(new ModelCow(), 0.7F));
        this.field_78729_o.put(EntityWolf.class, new RenderWolf(new ModelWolf(), new ModelWolf(), 0.5F));
        this.field_78729_o.put(EntityChicken.class, new RenderChicken(new ModelChicken(), 0.3F));
        this.field_78729_o.put(EntityOcelot.class, new RenderOcelot(new ModelOcelot(), 0.4F));
        this.field_78729_o.put(EntitySilverfish.class, new RenderSilverfish());
        this.field_78729_o.put(EntityCreeper.class, new RenderCreeper());
        this.field_78729_o.put(EntityEnderman.class, new RenderEnderman());
        this.field_78729_o.put(EntitySnowman.class, new RenderSnowMan());
        this.field_78729_o.put(EntitySkeleton.class, new RenderSkeleton());
        this.field_78729_o.put(EntityWitch.class, new RenderWitch());
        this.field_78729_o.put(EntityBlaze.class, new RenderBlaze());
        this.field_78729_o.put(EntityZombie.class, new RenderZombie());
        this.field_78729_o.put(EntitySlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
        this.field_78729_o.put(EntityMagmaCube.class, new RenderMagmaCube());
        this.field_78729_o.put(EntityPlayer.class, new RenderPlayer());
        this.field_78729_o.put(EntityGiantZombie.class, new RenderGiantZombie(new ModelZombie(), 0.5F, 6.0F));
        this.field_78729_o.put(EntityGhast.class, new RenderGhast());
        this.field_78729_o.put(EntitySquid.class, new RenderSquid(new ModelSquid(), 0.7F));
        this.field_78729_o.put(EntityVillager.class, new RenderVillager());
        this.field_78729_o.put(EntityIronGolem.class, new RenderIronGolem());
        this.field_78729_o.put(EntityBat.class, new RenderBat());
        this.field_78729_o.put(EntityDragon.class, new RenderDragon());
        this.field_78729_o.put(EntityEnderCrystal.class, new RenderEnderCrystal());
        this.field_78729_o.put(EntityWither.class, new RenderWither());
        this.field_78729_o.put(Entity.class, new RenderEntity());
        this.field_78729_o.put(EntityPainting.class, new RenderPainting());
        this.field_78729_o.put(EntityItemFrame.class, new RenderItemFrame());
        this.field_78729_o.put(EntityLeashKnot.class, new RenderLeashKnot());
        this.field_78729_o.put(EntityArrow.class, new RenderArrow());
        this.field_78729_o.put(EntitySnowball.class, new RenderSnowball(Item.field_77768_aD));
        this.field_78729_o.put(EntityEnderPearl.class, new RenderSnowball(Item.field_77730_bn));
        this.field_78729_o.put(EntityEnderEye.class, new RenderSnowball(Item.field_77748_bA));
        this.field_78729_o.put(EntityEgg.class, new RenderSnowball(Item.field_77764_aP));
        this.field_78729_o.put(EntityPotion.class, new RenderSnowball(Item.field_77726_bs, 16384));
        this.field_78729_o.put(EntityExpBottle.class, new RenderSnowball(Item.field_77809_bD));
        this.field_78729_o.put(EntityFireworkRocket.class, new RenderSnowball(Item.field_92104_bU));
        this.field_78729_o.put(EntityLargeFireball.class, new RenderFireball(2.0F));
        this.field_78729_o.put(EntitySmallFireball.class, new RenderFireball(0.5F));
        this.field_78729_o.put(EntityWitherSkull.class, new RenderWitherSkull());
        this.field_78729_o.put(EntityItem.class, new RenderItem());
        this.field_78729_o.put(EntityXPOrb.class, new RenderXPOrb());
        this.field_78729_o.put(EntityTNTPrimed.class, new RenderTNTPrimed());
        this.field_78729_o.put(EntityFallingSand.class, new RenderFallingSand());
        this.field_78729_o.put(EntityMinecartTNT.class, new RenderTntMinecart());
        this.field_78729_o.put(EntityMinecartMobSpawner.class, new RenderMinecartMobSpawner());
        this.field_78729_o.put(EntityMinecart.class, new RenderMinecart());
        this.field_78729_o.put(EntityBoat.class, new RenderBoat());
        this.field_78729_o.put(EntityFishHook.class, new RenderFish());
        this.field_78729_o.put(EntityHorse.class, new RenderHorse(new ModelHorse(), 0.75F));
        this.field_78729_o.put(EntityLightningBolt.class, new RenderLightningBolt());
        Iterator iterator = this.field_78729_o.values().iterator();

        while (iterator.hasNext())
        {
            Render render = (Render)iterator.next();
            render.func_76976_a(this);
        }
    }

    public Render func_78715_a(Class p_78715_1_)
    {
        Render render = (Render)this.field_78729_o.get(p_78715_1_);

        if (render == null && p_78715_1_ != Entity.class)
        {
            render = this.func_78715_a(p_78715_1_.getSuperclass());
            this.field_78729_o.put(p_78715_1_, render);
        }

        return render;
    }

    public Render func_78713_a(Entity p_78713_1_)
    {
        return this.func_78715_a(p_78713_1_.getClass());
    }

    public void func_78718_a(World p_78718_1_, TextureManager p_78718_2_, FontRenderer p_78718_3_, EntityLivingBase p_78718_4_, EntityLivingBase p_78718_5_, GameSettings p_78718_6_, float p_78718_7_)
    {
        this.field_78722_g = p_78718_1_;
        this.field_78724_e = p_78718_2_;
        this.field_78733_k = p_78718_6_;
        this.field_78734_h = p_78718_4_;
        this.field_96451_i = p_78718_5_;
        this.field_78736_p = p_78718_3_;

        if (p_78718_4_.func_70608_bn())
        {
            int i = p_78718_1_.func_72798_a(MathHelper.func_76128_c(p_78718_4_.field_70165_t), MathHelper.func_76128_c(p_78718_4_.field_70163_u), MathHelper.func_76128_c(p_78718_4_.field_70161_v));

            if (i == Block.field_71959_S.field_71990_ca)
            {
                int j = p_78718_1_.func_72805_g(MathHelper.func_76128_c(p_78718_4_.field_70165_t), MathHelper.func_76128_c(p_78718_4_.field_70163_u), MathHelper.func_76128_c(p_78718_4_.field_70161_v));
                int k = j & 3;
                this.field_78735_i = (float)(k * 90 + 180);
                this.field_78732_j = 0.0F;
            }
        }
        else
        {
            this.field_78735_i = p_78718_4_.field_70126_B + (p_78718_4_.field_70177_z - p_78718_4_.field_70126_B) * p_78718_7_;
            this.field_78732_j = p_78718_4_.field_70127_C + (p_78718_4_.field_70125_A - p_78718_4_.field_70127_C) * p_78718_7_;
        }

        if (p_78718_6_.field_74320_O == 2)
        {
            this.field_78735_i += 180.0F;
        }

        this.field_78730_l = p_78718_4_.field_70142_S + (p_78718_4_.field_70165_t - p_78718_4_.field_70142_S) * (double)p_78718_7_;
        this.field_78731_m = p_78718_4_.field_70137_T + (p_78718_4_.field_70163_u - p_78718_4_.field_70137_T) * (double)p_78718_7_;
        this.field_78728_n = p_78718_4_.field_70136_U + (p_78718_4_.field_70161_v - p_78718_4_.field_70136_U) * (double)p_78718_7_;
    }

    public void func_78720_a(Entity p_78720_1_, float p_78720_2_)
    {
        if (p_78720_1_.field_70173_aa == 0)
        {
            p_78720_1_.field_70142_S = p_78720_1_.field_70165_t;
            p_78720_1_.field_70137_T = p_78720_1_.field_70163_u;
            p_78720_1_.field_70136_U = p_78720_1_.field_70161_v;
        }

        double d0 = p_78720_1_.field_70142_S + (p_78720_1_.field_70165_t - p_78720_1_.field_70142_S) * (double)p_78720_2_;
        double d1 = p_78720_1_.field_70137_T + (p_78720_1_.field_70163_u - p_78720_1_.field_70137_T) * (double)p_78720_2_;
        double d2 = p_78720_1_.field_70136_U + (p_78720_1_.field_70161_v - p_78720_1_.field_70136_U) * (double)p_78720_2_;
        float f1 = p_78720_1_.field_70126_B + (p_78720_1_.field_70177_z - p_78720_1_.field_70126_B) * p_78720_2_;
        int i = p_78720_1_.func_70070_b(p_78720_2_);

        if (p_78720_1_.func_70027_ad())
        {
            i = 15728880;
        }

        int j = i % 65536;
        int k = i / 65536;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.func_78719_a(p_78720_1_, d0 - field_78725_b, d1 - field_78726_c, d2 - field_78723_d, f1, p_78720_2_);
    }

    public void func_78719_a(Entity p_78719_1_, double p_78719_2_, double p_78719_4_, double p_78719_6_, float p_78719_8_, float p_78719_9_)
    {
        Render render = null;

        try
        {
            render = this.func_78713_a(p_78719_1_);

            if (render != null && this.field_78724_e != null)
            {
                if (field_85095_o && !p_78719_1_.func_82150_aj())
                {
                    try
                    {
                        this.func_85094_b(p_78719_1_, p_78719_2_, p_78719_4_, p_78719_6_, p_78719_8_, p_78719_9_);
                    }
                    catch (Throwable throwable)
                    {
                        throw new ReportedException(CrashReport.func_85055_a(throwable, "Rendering entity hitbox in world"));
                    }
                }

                try
                {
                    render.func_76986_a(p_78719_1_, p_78719_2_, p_78719_4_, p_78719_6_, p_78719_8_, p_78719_9_);
                }
                catch (Throwable throwable1)
                {
                    throw new ReportedException(CrashReport.func_85055_a(throwable1, "Rendering entity in world"));
                }

                try
                {
                    render.func_76979_b(p_78719_1_, p_78719_2_, p_78719_4_, p_78719_6_, p_78719_8_, p_78719_9_);
                }
                catch (Throwable throwable2)
                {
                    throw new ReportedException(CrashReport.func_85055_a(throwable2, "Post-rendering entity in world"));
                }
            }
        }
        catch (Throwable throwable3)
        {
            CrashReport crashreport = CrashReport.func_85055_a(throwable3, "Rendering entity in world");
            CrashReportCategory crashreportcategory = crashreport.func_85058_a("Entity being rendered");
            p_78719_1_.func_85029_a(crashreportcategory);
            CrashReportCategory crashreportcategory1 = crashreport.func_85058_a("Renderer details");
            crashreportcategory1.func_71507_a("Assigned renderer", render);
            crashreportcategory1.func_71507_a("Location", CrashReportCategory.func_85074_a(p_78719_2_, p_78719_4_, p_78719_6_));
            crashreportcategory1.func_71507_a("Rotation", Float.valueOf(p_78719_8_));
            crashreportcategory1.func_71507_a("Delta", Float.valueOf(p_78719_9_));
            throw new ReportedException(crashreport);
        }
    }

    private void func_85094_b(Entity p_85094_1_, double p_85094_2_, double p_85094_4_, double p_85094_6_, float p_85094_8_, float p_85094_9_)
    {
        GL11.glDepthMask(false);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPushMatrix();
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78370_a(255, 255, 255, 32);
        double d3 = (double)(-p_85094_1_.field_70130_N / 2.0F);
        double d4 = (double)(-p_85094_1_.field_70130_N / 2.0F);
        double d5 = (double)(p_85094_1_.field_70130_N / 2.0F);
        double d6 = (double)(-p_85094_1_.field_70130_N / 2.0F);
        double d7 = (double)(-p_85094_1_.field_70130_N / 2.0F);
        double d8 = (double)(p_85094_1_.field_70130_N / 2.0F);
        double d9 = (double)(p_85094_1_.field_70130_N / 2.0F);
        double d10 = (double)(p_85094_1_.field_70130_N / 2.0F);
        double d11 = (double)p_85094_1_.field_70131_O;
        tessellator.func_78377_a(p_85094_2_ + d3, p_85094_4_ + d11, p_85094_6_ + d4);
        tessellator.func_78377_a(p_85094_2_ + d3, p_85094_4_, p_85094_6_ + d4);
        tessellator.func_78377_a(p_85094_2_ + d5, p_85094_4_, p_85094_6_ + d6);
        tessellator.func_78377_a(p_85094_2_ + d5, p_85094_4_ + d11, p_85094_6_ + d6);
        tessellator.func_78377_a(p_85094_2_ + d9, p_85094_4_ + d11, p_85094_6_ + d10);
        tessellator.func_78377_a(p_85094_2_ + d9, p_85094_4_, p_85094_6_ + d10);
        tessellator.func_78377_a(p_85094_2_ + d7, p_85094_4_, p_85094_6_ + d8);
        tessellator.func_78377_a(p_85094_2_ + d7, p_85094_4_ + d11, p_85094_6_ + d8);
        tessellator.func_78377_a(p_85094_2_ + d5, p_85094_4_ + d11, p_85094_6_ + d6);
        tessellator.func_78377_a(p_85094_2_ + d5, p_85094_4_, p_85094_6_ + d6);
        tessellator.func_78377_a(p_85094_2_ + d9, p_85094_4_, p_85094_6_ + d10);
        tessellator.func_78377_a(p_85094_2_ + d9, p_85094_4_ + d11, p_85094_6_ + d10);
        tessellator.func_78377_a(p_85094_2_ + d7, p_85094_4_ + d11, p_85094_6_ + d8);
        tessellator.func_78377_a(p_85094_2_ + d7, p_85094_4_, p_85094_6_ + d8);
        tessellator.func_78377_a(p_85094_2_ + d3, p_85094_4_, p_85094_6_ + d4);
        tessellator.func_78377_a(p_85094_2_ + d3, p_85094_4_ + d11, p_85094_6_ + d4);
        tessellator.func_78381_a();
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDepthMask(true);
    }

    public void func_78717_a(World p_78717_1_)
    {
        this.field_78722_g = p_78717_1_;
    }

    public double func_78714_a(double p_78714_1_, double p_78714_3_, double p_78714_5_)
    {
        double d3 = p_78714_1_ - this.field_78730_l;
        double d4 = p_78714_3_ - this.field_78731_m;
        double d5 = p_78714_5_ - this.field_78728_n;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    public FontRenderer func_78716_a()
    {
        return this.field_78736_p;
    }

    public void func_94178_a(IconRegister p_94178_1_)
    {
        Iterator iterator = this.field_78729_o.values().iterator();

        while (iterator.hasNext())
        {
            Render render = (Render)iterator.next();
            render.func_94143_a(p_94178_1_);
        }
    }
}
