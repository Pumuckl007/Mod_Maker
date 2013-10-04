package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class GuiMerchant extends GuiContainer
{
    private static final ResourceLocation field_110418_t = new ResourceLocation("textures/gui/container/villager.png");
    private IMerchant field_74203_o;
    private GuiButtonMerchant field_74202_p;
    private GuiButtonMerchant field_74201_q;
    private int field_74200_r;
    private String field_94082_v;

    public GuiMerchant(InventoryPlayer p_i1096_1_, IMerchant p_i1096_2_, World p_i1096_3_, String p_i1096_4_)
    {
        super(new ContainerMerchant(p_i1096_1_, p_i1096_2_, p_i1096_3_));
        this.field_74203_o = p_i1096_2_;
        this.field_94082_v = p_i1096_4_ != null && p_i1096_4_.length() >= 1 ? p_i1096_4_ : I18n.func_135053_a("entity.Villager.name");
    }

    public void func_73866_w_()
    {
        super.func_73866_w_();
        int i = (this.field_73880_f - this.field_74194_b) / 2;
        int j = (this.field_73881_g - this.field_74195_c) / 2;
        this.field_73887_h.add(this.field_74202_p = new GuiButtonMerchant(1, i + 120 + 27, j + 24 - 1, true));
        this.field_73887_h.add(this.field_74201_q = new GuiButtonMerchant(2, i + 36 - 19, j + 24 - 1, false));
        this.field_74202_p.field_73742_g = false;
        this.field_74201_q.field_73742_g = false;
    }

    protected void func_74189_g(int p_74189_1_, int p_74189_2_)
    {
        this.field_73886_k.func_78276_b(this.field_94082_v, this.field_74194_b / 2 - this.field_73886_k.func_78256_a(this.field_94082_v) / 2, 6, 4210752);
        this.field_73886_k.func_78276_b(I18n.func_135053_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        MerchantRecipeList merchantrecipelist = this.field_74203_o.func_70934_b(this.field_73882_e.field_71439_g);

        if (merchantrecipelist != null)
        {
            this.field_74202_p.field_73742_g = this.field_74200_r < merchantrecipelist.size() - 1;
            this.field_74201_q.field_73742_g = this.field_74200_r > 0;
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        boolean flag = false;

        if (p_73875_1_ == this.field_74202_p)
        {
            ++this.field_74200_r;
            flag = true;
        }
        else if (p_73875_1_ == this.field_74201_q)
        {
            --this.field_74200_r;
            flag = true;
        }

        if (flag)
        {
            ((ContainerMerchant)this.field_74193_d).func_75175_c(this.field_74200_r);
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);

            try
            {
                dataoutputstream.writeInt(this.field_74200_r);
                this.field_73882_e.func_71391_r().func_72552_c(new Packet250CustomPayload("MC|TrSel", bytearrayoutputstream.toByteArray()));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110418_t);
        int k = (this.field_73880_f - this.field_74194_b) / 2;
        int l = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(k, l, 0, 0, this.field_74194_b, this.field_74195_c);
        MerchantRecipeList merchantrecipelist = this.field_74203_o.func_70934_b(this.field_73882_e.field_71439_g);

        if (merchantrecipelist != null && !merchantrecipelist.isEmpty())
        {
            int i1 = this.field_74200_r;
            MerchantRecipe merchantrecipe = (MerchantRecipe)merchantrecipelist.get(i1);

            if (merchantrecipe.func_82784_g())
            {
                this.field_73882_e.func_110434_K().func_110577_a(field_110418_t);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glDisable(GL11.GL_LIGHTING);
                this.func_73729_b(this.field_74198_m + 83, this.field_74197_n + 21, 212, 0, 28, 21);
                this.func_73729_b(this.field_74198_m + 83, this.field_74197_n + 51, 212, 0, 28, 21);
            }
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        MerchantRecipeList merchantrecipelist = this.field_74203_o.func_70934_b(this.field_73882_e.field_71439_g);

        if (merchantrecipelist != null && !merchantrecipelist.isEmpty())
        {
            int k = (this.field_73880_f - this.field_74194_b) / 2;
            int l = (this.field_73881_g - this.field_74195_c) / 2;
            int i1 = this.field_74200_r;
            MerchantRecipe merchantrecipe = (MerchantRecipe)merchantrecipelist.get(i1);
            GL11.glPushMatrix();
            ItemStack itemstack = merchantrecipe.func_77394_a();
            ItemStack itemstack1 = merchantrecipe.func_77396_b();
            ItemStack itemstack2 = merchantrecipe.func_77397_d();
            RenderHelper.func_74520_c();
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glEnable(GL11.GL_COLOR_MATERIAL);
            GL11.glEnable(GL11.GL_LIGHTING);
            field_74196_a.field_77023_b = 100.0F;
            field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.func_110434_K(), itemstack, k + 36, l + 24);
            field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e.func_110434_K(), itemstack, k + 36, l + 24);

            if (itemstack1 != null)
            {
                field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.func_110434_K(), itemstack1, k + 62, l + 24);
                field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e.func_110434_K(), itemstack1, k + 62, l + 24);
            }

            field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.func_110434_K(), itemstack2, k + 120, l + 24);
            field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e.func_110434_K(), itemstack2, k + 120, l + 24);
            field_74196_a.field_77023_b = 0.0F;
            GL11.glDisable(GL11.GL_LIGHTING);

            if (this.func_74188_c(36, 24, 16, 16, p_73863_1_, p_73863_2_))
            {
                this.func_74184_a(itemstack, p_73863_1_, p_73863_2_);
            }
            else if (itemstack1 != null && this.func_74188_c(62, 24, 16, 16, p_73863_1_, p_73863_2_))
            {
                this.func_74184_a(itemstack1, p_73863_1_, p_73863_2_);
            }
            else if (this.func_74188_c(120, 24, 16, 16, p_73863_1_, p_73863_2_))
            {
                this.func_74184_a(itemstack2, p_73863_1_, p_73863_2_);
            }

            GL11.glPopMatrix();
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            RenderHelper.func_74519_b();
        }
    }

    public IMerchant func_74199_h()
    {
        return this.field_74203_o;
    }

    static ResourceLocation func_110417_h()
    {
        return field_110418_t;
    }
}
