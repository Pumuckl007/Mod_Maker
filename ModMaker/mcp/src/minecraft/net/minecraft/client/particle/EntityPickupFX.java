package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class EntityPickupFX extends EntityFX
{
    private Entity field_70591_a;
    private Entity field_70595_aq;
    private int field_70594_ar;
    private int field_70593_as;
    private float field_70592_at;

    public EntityPickupFX(World p_i1233_1_, Entity p_i1233_2_, Entity p_i1233_3_, float p_i1233_4_)
    {
        super(p_i1233_1_, p_i1233_2_.field_70165_t, p_i1233_2_.field_70163_u, p_i1233_2_.field_70161_v, p_i1233_2_.field_70159_w, p_i1233_2_.field_70181_x, p_i1233_2_.field_70179_y);
        this.field_70591_a = p_i1233_2_;
        this.field_70595_aq = p_i1233_3_;
        this.field_70593_as = 3;
        this.field_70592_at = p_i1233_4_;
    }

    public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        float f6 = ((float)this.field_70594_ar + p_70539_2_) / (float)this.field_70593_as;
        f6 *= f6;
        double d0 = this.field_70591_a.field_70165_t;
        double d1 = this.field_70591_a.field_70163_u;
        double d2 = this.field_70591_a.field_70161_v;
        double d3 = this.field_70595_aq.field_70142_S + (this.field_70595_aq.field_70165_t - this.field_70595_aq.field_70142_S) * (double)p_70539_2_;
        double d4 = this.field_70595_aq.field_70137_T + (this.field_70595_aq.field_70163_u - this.field_70595_aq.field_70137_T) * (double)p_70539_2_ + (double)this.field_70592_at;
        double d5 = this.field_70595_aq.field_70136_U + (this.field_70595_aq.field_70161_v - this.field_70595_aq.field_70136_U) * (double)p_70539_2_;
        double d6 = d0 + (d3 - d0) * (double)f6;
        double d7 = d1 + (d4 - d1) * (double)f6;
        double d8 = d2 + (d5 - d2) * (double)f6;
        int i = MathHelper.func_76128_c(d6);
        int j = MathHelper.func_76128_c(d7 + (double)(this.field_70129_M / 2.0F));
        int k = MathHelper.func_76128_c(d8);
        int l = this.func_70070_b(p_70539_2_);
        int i1 = l % 65536;
        int j1 = l / 65536;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)i1 / 1.0F, (float)j1 / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        d6 -= field_70556_an;
        d7 -= field_70554_ao;
        d8 -= field_70555_ap;
        RenderManager.field_78727_a.func_78719_a(this.field_70591_a, (double)((float)d6), (double)((float)d7), (double)((float)d8), this.field_70591_a.field_70177_z, p_70539_2_);
    }

    public void func_70071_h_()
    {
        ++this.field_70594_ar;

        if (this.field_70594_ar == this.field_70593_as)
        {
            this.func_70106_y();
        }
    }

    public int func_70537_b()
    {
        return 3;
    }
}