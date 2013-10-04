package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class InventoryEffectRenderer extends GuiContainer
{
    private boolean field_74222_o;

    public InventoryEffectRenderer(Container p_i1089_1_)
    {
        super(p_i1089_1_);
    }

    public void func_73866_w_()
    {
        super.func_73866_w_();

        if (!this.field_73882_e.field_71439_g.func_70651_bq().isEmpty())
        {
            this.field_74198_m = 160 + (this.field_73880_f - this.field_74194_b - 200) / 2;
            this.field_74222_o = true;
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);

        if (this.field_74222_o)
        {
            this.func_74221_h();
        }
    }

    private void func_74221_h()
    {
        int i = this.field_74198_m - 124;
        int j = this.field_74197_n;
        boolean flag = true;
        Collection collection = this.field_73882_e.field_71439_g.func_70651_bq();

        if (!collection.isEmpty())
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_LIGHTING);
            int k = 33;

            if (collection.size() > 5)
            {
                k = 132 / (collection.size() - 1);
            }

            for (Iterator iterator = this.field_73882_e.field_71439_g.func_70651_bq().iterator(); iterator.hasNext(); j += k)
            {
                PotionEffect potioneffect = (PotionEffect)iterator.next();
                Potion potion = Potion.field_76425_a[potioneffect.func_76456_a()];
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.field_73882_e.func_110434_K().func_110577_a(field_110408_a);
                this.func_73729_b(i, j, 0, 166, 140, 32);

                if (potion.func_76400_d())
                {
                    int l = potion.func_76392_e();
                    this.func_73729_b(i + 6, j + 7, 0 + l % 8 * 18, 198 + l / 8 * 18, 18, 18);
                }

                String s = I18n.func_135053_a(potion.func_76393_a());

                if (potioneffect.func_76458_c() == 1)
                {
                    s = s + " II";
                }
                else if (potioneffect.func_76458_c() == 2)
                {
                    s = s + " III";
                }
                else if (potioneffect.func_76458_c() == 3)
                {
                    s = s + " IV";
                }

                this.field_73886_k.func_78261_a(s, i + 10 + 18, j + 6, 16777215);
                String s1 = Potion.func_76389_a(potioneffect);
                this.field_73886_k.func_78261_a(s1, i + 10 + 18, j + 6 + 10, 8355711);
            }
        }
    }
}
