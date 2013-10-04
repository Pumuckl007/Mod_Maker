package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class GuiContainerCreative extends InventoryEffectRenderer
{
    private static final ResourceLocation field_110424_t = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
    private static InventoryBasic field_74242_o = new InventoryBasic("tmp", true, 45);
    private static int field_74241_p = CreativeTabs.field_78030_b.func_78021_a();
    private float field_74240_q;
    private boolean field_74239_r;
    private boolean field_74238_s;
    private GuiTextField field_74237_t;
    private List field_74236_u;
    private Slot field_74235_v;
    private boolean field_74234_w;
    private CreativeCrafting field_82324_x;

    public GuiContainerCreative(EntityPlayer p_i1088_1_)
    {
        super(new ContainerCreative(p_i1088_1_));
        p_i1088_1_.field_71070_bA = this.field_74193_d;
        this.field_73885_j = true;
        p_i1088_1_.func_71064_a(AchievementList.field_76004_f, 1);
        this.field_74195_c = 136;
        this.field_74194_b = 195;
    }

    public void func_73876_c()
    {
        if (!this.field_73882_e.field_71442_b.func_78758_h())
        {
            this.field_73882_e.func_71373_a(new GuiInventory(this.field_73882_e.field_71439_g));
        }
    }

    protected void func_74191_a(Slot p_74191_1_, int p_74191_2_, int p_74191_3_, int p_74191_4_)
    {
        this.field_74234_w = true;
        boolean flag = p_74191_4_ == 1;
        p_74191_4_ = p_74191_2_ == -999 && p_74191_4_ == 0 ? 4 : p_74191_4_;
        ItemStack itemstack;
        InventoryPlayer inventoryplayer;

        if (p_74191_1_ == null && field_74241_p != CreativeTabs.field_78036_m.func_78021_a() && p_74191_4_ != 5)
        {
            inventoryplayer = this.field_73882_e.field_71439_g.field_71071_by;

            if (inventoryplayer.func_70445_o() != null)
            {
                if (p_74191_3_ == 0)
                {
                    this.field_73882_e.field_71439_g.func_71021_b(inventoryplayer.func_70445_o());
                    this.field_73882_e.field_71442_b.func_78752_a(inventoryplayer.func_70445_o());
                    inventoryplayer.func_70437_b((ItemStack)null);
                }

                if (p_74191_3_ == 1)
                {
                    itemstack = inventoryplayer.func_70445_o().func_77979_a(1);
                    this.field_73882_e.field_71439_g.func_71021_b(itemstack);
                    this.field_73882_e.field_71442_b.func_78752_a(itemstack);

                    if (inventoryplayer.func_70445_o().field_77994_a == 0)
                    {
                        inventoryplayer.func_70437_b((ItemStack)null);
                    }
                }
            }
        }
        else
        {
            int l;

            if (p_74191_1_ == this.field_74235_v && flag)
            {
                for (l = 0; l < this.field_73882_e.field_71439_g.field_71069_bz.func_75138_a().size(); ++l)
                {
                    this.field_73882_e.field_71442_b.func_78761_a((ItemStack)null, l);
                }
            }
            else
            {
                ItemStack itemstack1;

                if (field_74241_p == CreativeTabs.field_78036_m.func_78021_a())
                {
                    if (p_74191_1_ == this.field_74235_v)
                    {
                        this.field_73882_e.field_71439_g.field_71071_by.func_70437_b((ItemStack)null);
                    }
                    else if (p_74191_4_ == 4 && p_74191_1_ != null && p_74191_1_.func_75216_d())
                    {
                        itemstack1 = p_74191_1_.func_75209_a(p_74191_3_ == 0 ? 1 : p_74191_1_.func_75211_c().func_77976_d());
                        this.field_73882_e.field_71439_g.func_71021_b(itemstack1);
                        this.field_73882_e.field_71442_b.func_78752_a(itemstack1);
                    }
                    else if (p_74191_4_ == 4 && this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() != null)
                    {
                        this.field_73882_e.field_71439_g.func_71021_b(this.field_73882_e.field_71439_g.field_71071_by.func_70445_o());
                        this.field_73882_e.field_71442_b.func_78752_a(this.field_73882_e.field_71439_g.field_71071_by.func_70445_o());
                        this.field_73882_e.field_71439_g.field_71071_by.func_70437_b((ItemStack)null);
                    }
                    else
                    {
                        this.field_73882_e.field_71439_g.field_71069_bz.func_75144_a(p_74191_1_ == null ? p_74191_2_ : SlotCreativeInventory.func_75240_a((SlotCreativeInventory)p_74191_1_).field_75222_d, p_74191_3_, p_74191_4_, this.field_73882_e.field_71439_g);
                        this.field_73882_e.field_71439_g.field_71069_bz.func_75142_b();
                    }
                }
                else if (p_74191_4_ != 5 && p_74191_1_.field_75224_c == field_74242_o)
                {
                    inventoryplayer = this.field_73882_e.field_71439_g.field_71071_by;
                    itemstack = inventoryplayer.func_70445_o();
                    ItemStack itemstack2 = p_74191_1_.func_75211_c();
                    ItemStack itemstack3;

                    if (p_74191_4_ == 2)
                    {
                        if (itemstack2 != null && p_74191_3_ >= 0 && p_74191_3_ < 9)
                        {
                            itemstack3 = itemstack2.func_77946_l();
                            itemstack3.field_77994_a = itemstack3.func_77976_d();
                            this.field_73882_e.field_71439_g.field_71071_by.func_70299_a(p_74191_3_, itemstack3);
                            this.field_73882_e.field_71439_g.field_71069_bz.func_75142_b();
                        }

                        return;
                    }

                    if (p_74191_4_ == 3)
                    {
                        if (inventoryplayer.func_70445_o() == null && p_74191_1_.func_75216_d())
                        {
                            itemstack3 = p_74191_1_.func_75211_c().func_77946_l();
                            itemstack3.field_77994_a = itemstack3.func_77976_d();
                            inventoryplayer.func_70437_b(itemstack3);
                        }

                        return;
                    }

                    if (p_74191_4_ == 4)
                    {
                        if (itemstack2 != null)
                        {
                            itemstack3 = itemstack2.func_77946_l();
                            itemstack3.field_77994_a = p_74191_3_ == 0 ? 1 : itemstack3.func_77976_d();
                            this.field_73882_e.field_71439_g.func_71021_b(itemstack3);
                            this.field_73882_e.field_71442_b.func_78752_a(itemstack3);
                        }

                        return;
                    }

                    if (itemstack != null && itemstack2 != null && itemstack.func_77969_a(itemstack2))
                    {
                        if (p_74191_3_ == 0)
                        {
                            if (flag)
                            {
                                itemstack.field_77994_a = itemstack.func_77976_d();
                            }
                            else if (itemstack.field_77994_a < itemstack.func_77976_d())
                            {
                                ++itemstack.field_77994_a;
                            }
                        }
                        else if (itemstack.field_77994_a <= 1)
                        {
                            inventoryplayer.func_70437_b((ItemStack)null);
                        }
                        else
                        {
                            --itemstack.field_77994_a;
                        }
                    }
                    else if (itemstack2 != null && itemstack == null)
                    {
                        inventoryplayer.func_70437_b(ItemStack.func_77944_b(itemstack2));
                        itemstack = inventoryplayer.func_70445_o();

                        if (flag)
                        {
                            itemstack.field_77994_a = itemstack.func_77976_d();
                        }
                    }
                    else
                    {
                        inventoryplayer.func_70437_b((ItemStack)null);
                    }
                }
                else
                {
                    this.field_74193_d.func_75144_a(p_74191_1_ == null ? p_74191_2_ : p_74191_1_.field_75222_d, p_74191_3_, p_74191_4_, this.field_73882_e.field_71439_g);

                    if (Container.func_94532_c(p_74191_3_) == 2)
                    {
                        for (l = 0; l < 9; ++l)
                        {
                            this.field_73882_e.field_71442_b.func_78761_a(this.field_74193_d.func_75139_a(45 + l).func_75211_c(), 36 + l);
                        }
                    }
                    else if (p_74191_1_ != null)
                    {
                        itemstack1 = this.field_74193_d.func_75139_a(p_74191_1_.field_75222_d).func_75211_c();
                        this.field_73882_e.field_71442_b.func_78761_a(itemstack1, p_74191_1_.field_75222_d - this.field_74193_d.field_75151_b.size() + 9 + 36);
                    }
                }
            }
        }
    }

    public void func_73866_w_()
    {
        if (this.field_73882_e.field_71442_b.func_78758_h())
        {
            super.func_73866_w_();
            this.field_73887_h.clear();
            Keyboard.enableRepeatEvents(true);
            this.field_74237_t = new GuiTextField(this.field_73886_k, this.field_74198_m + 82, this.field_74197_n + 6, 89, this.field_73886_k.field_78288_b);
            this.field_74237_t.func_73804_f(15);
            this.field_74237_t.func_73786_a(false);
            this.field_74237_t.func_73790_e(false);
            this.field_74237_t.func_73794_g(16777215);
            int i = field_74241_p;
            field_74241_p = -1;
            this.func_74227_b(CreativeTabs.field_78032_a[i]);
            this.field_82324_x = new CreativeCrafting(this.field_73882_e);
            this.field_73882_e.field_71439_g.field_71069_bz.func_75132_a(this.field_82324_x);
        }
        else
        {
            this.field_73882_e.func_71373_a(new GuiInventory(this.field_73882_e.field_71439_g));
        }
    }

    public void func_73874_b()
    {
        super.func_73874_b();

        if (this.field_73882_e.field_71439_g != null && this.field_73882_e.field_71439_g.field_71071_by != null)
        {
            this.field_73882_e.field_71439_g.field_71069_bz.func_82847_b(this.field_82324_x);
        }

        Keyboard.enableRepeatEvents(false);
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if (field_74241_p != CreativeTabs.field_78027_g.func_78021_a())
        {
            if (GameSettings.func_100015_a(this.field_73882_e.field_71474_y.field_74310_D))
            {
                this.func_74227_b(CreativeTabs.field_78027_g);
            }
            else
            {
                super.func_73869_a(p_73869_1_, p_73869_2_);
            }
        }
        else
        {
            if (this.field_74234_w)
            {
                this.field_74234_w = false;
                this.field_74237_t.func_73782_a("");
            }

            if (!this.func_82319_a(p_73869_2_))
            {
                if (this.field_74237_t.func_73802_a(p_73869_1_, p_73869_2_))
                {
                    this.func_74228_j();
                }
                else
                {
                    super.func_73869_a(p_73869_1_, p_73869_2_);
                }
            }
        }
    }

    private void func_74228_j()
    {
        ContainerCreative containercreative = (ContainerCreative)this.field_74193_d;
        containercreative.field_75185_e.clear();
        Item[] aitem = Item.field_77698_e;
        int i = aitem.length;
        int j;

        for (j = 0; j < i; ++j)
        {
            Item item = aitem[j];

            if (item != null && item.func_77640_w() != null)
            {
                item.func_77633_a(item.field_77779_bT, (CreativeTabs)null, containercreative.field_75185_e);
            }
        }

        Enchantment[] aenchantment = Enchantment.field_77331_b;
        i = aenchantment.length;

        for (j = 0; j < i; ++j)
        {
            Enchantment enchantment = aenchantment[j];

            if (enchantment != null && enchantment.field_77351_y != null)
            {
                Item.field_92105_bW.func_92113_a(enchantment, containercreative.field_75185_e);
            }
        }

        Iterator iterator = containercreative.field_75185_e.iterator();
        String s = this.field_74237_t.func_73781_b().toLowerCase();

        while (iterator.hasNext())
        {
            ItemStack itemstack = (ItemStack)iterator.next();
            boolean flag = false;
            Iterator iterator1 = itemstack.func_82840_a(this.field_73882_e.field_71439_g, this.field_73882_e.field_71474_y.field_82882_x).iterator();

            while (true)
            {
                if (iterator1.hasNext())
                {
                    String s1 = (String)iterator1.next();

                    if (!s1.toLowerCase().contains(s))
                    {
                        continue;
                    }

                    flag = true;
                }

                if (!flag)
                {
                    iterator.remove();
                }

                break;
            }
        }

        this.field_74240_q = 0.0F;
        containercreative.func_75183_a(0.0F);
    }

    protected void func_74189_g(int p_74189_1_, int p_74189_2_)
    {
        CreativeTabs creativetabs = CreativeTabs.field_78032_a[field_74241_p];

        if (creativetabs.func_78019_g())
        {
            this.field_73886_k.func_78276_b(I18n.func_135053_a(creativetabs.func_78024_c()), 8, 6, 4210752);
        }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        if (p_73864_3_ == 0)
        {
            int l = p_73864_1_ - this.field_74198_m;
            int i1 = p_73864_2_ - this.field_74197_n;
            CreativeTabs[] acreativetabs = CreativeTabs.field_78032_a;
            int j1 = acreativetabs.length;

            for (int k1 = 0; k1 < j1; ++k1)
            {
                CreativeTabs creativetabs = acreativetabs[k1];

                if (this.func_74232_a(creativetabs, l, i1))
                {
                    return;
                }
            }
        }

        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
    }

    protected void func_73879_b(int p_73879_1_, int p_73879_2_, int p_73879_3_)
    {
        if (p_73879_3_ == 0)
        {
            int l = p_73879_1_ - this.field_74198_m;
            int i1 = p_73879_2_ - this.field_74197_n;
            CreativeTabs[] acreativetabs = CreativeTabs.field_78032_a;
            int j1 = acreativetabs.length;

            for (int k1 = 0; k1 < j1; ++k1)
            {
                CreativeTabs creativetabs = acreativetabs[k1];

                if (this.func_74232_a(creativetabs, l, i1))
                {
                    this.func_74227_b(creativetabs);
                    return;
                }
            }
        }

        super.func_73879_b(p_73879_1_, p_73879_2_, p_73879_3_);
    }

    private boolean func_74226_k()
    {
        return field_74241_p != CreativeTabs.field_78036_m.func_78021_a() && CreativeTabs.field_78032_a[field_74241_p].func_78017_i() && ((ContainerCreative)this.field_74193_d).func_75184_d();
    }

    private void func_74227_b(CreativeTabs p_74227_1_)
    {
        int i = field_74241_p;
        field_74241_p = p_74227_1_.func_78021_a();
        ContainerCreative containercreative = (ContainerCreative)this.field_74193_d;
        this.field_94077_p.clear();
        containercreative.field_75185_e.clear();
        p_74227_1_.func_78018_a(containercreative.field_75185_e);

        if (p_74227_1_ == CreativeTabs.field_78036_m)
        {
            Container container = this.field_73882_e.field_71439_g.field_71069_bz;

            if (this.field_74236_u == null)
            {
                this.field_74236_u = containercreative.field_75151_b;
            }

            containercreative.field_75151_b = new ArrayList();

            for (int j = 0; j < container.field_75151_b.size(); ++j)
            {
                SlotCreativeInventory slotcreativeinventory = new SlotCreativeInventory(this, (Slot)container.field_75151_b.get(j), j);
                containercreative.field_75151_b.add(slotcreativeinventory);
                int k;
                int l;
                int i1;

                if (j >= 5 && j < 9)
                {
                    k = j - 5;
                    l = k / 2;
                    i1 = k % 2;
                    slotcreativeinventory.field_75223_e = 9 + l * 54;
                    slotcreativeinventory.field_75221_f = 6 + i1 * 27;
                }
                else if (j >= 0 && j < 5)
                {
                    slotcreativeinventory.field_75221_f = -2000;
                    slotcreativeinventory.field_75223_e = -2000;
                }
                else if (j < container.field_75151_b.size())
                {
                    k = j - 9;
                    l = k % 9;
                    i1 = k / 9;
                    slotcreativeinventory.field_75223_e = 9 + l * 18;

                    if (j >= 36)
                    {
                        slotcreativeinventory.field_75221_f = 112;
                    }
                    else
                    {
                        slotcreativeinventory.field_75221_f = 54 + i1 * 18;
                    }
                }
            }

            this.field_74235_v = new Slot(field_74242_o, 0, 173, 112);
            containercreative.field_75151_b.add(this.field_74235_v);
        }
        else if (i == CreativeTabs.field_78036_m.func_78021_a())
        {
            containercreative.field_75151_b = this.field_74236_u;
            this.field_74236_u = null;
        }

        if (this.field_74237_t != null)
        {
            if (p_74227_1_ == CreativeTabs.field_78027_g)
            {
                this.field_74237_t.func_73790_e(true);
                this.field_74237_t.func_73805_d(false);
                this.field_74237_t.func_73796_b(true);
                this.field_74237_t.func_73782_a("");
                this.func_74228_j();
            }
            else
            {
                this.field_74237_t.func_73790_e(false);
                this.field_74237_t.func_73805_d(true);
                this.field_74237_t.func_73796_b(false);
            }
        }

        this.field_74240_q = 0.0F;
        containercreative.func_75183_a(0.0F);
    }

    public void func_73867_d()
    {
        super.func_73867_d();
        int i = Mouse.getEventDWheel();

        if (i != 0 && this.func_74226_k())
        {
            int j = ((ContainerCreative)this.field_74193_d).field_75185_e.size() / 9 - 5 + 1;

            if (i > 0)
            {
                i = 1;
            }

            if (i < 0)
            {
                i = -1;
            }

            this.field_74240_q = (float)((double)this.field_74240_q - (double)i / (double)j);

            if (this.field_74240_q < 0.0F)
            {
                this.field_74240_q = 0.0F;
            }

            if (this.field_74240_q > 1.0F)
            {
                this.field_74240_q = 1.0F;
            }

            ((ContainerCreative)this.field_74193_d).func_75183_a(this.field_74240_q);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        boolean flag = Mouse.isButtonDown(0);
        int k = this.field_74198_m;
        int l = this.field_74197_n;
        int i1 = k + 175;
        int j1 = l + 18;
        int k1 = i1 + 14;
        int l1 = j1 + 112;

        if (!this.field_74238_s && flag && p_73863_1_ >= i1 && p_73863_2_ >= j1 && p_73863_1_ < k1 && p_73863_2_ < l1)
        {
            this.field_74239_r = this.func_74226_k();
        }

        if (!flag)
        {
            this.field_74239_r = false;
        }

        this.field_74238_s = flag;

        if (this.field_74239_r)
        {
            this.field_74240_q = ((float)(p_73863_2_ - j1) - 7.5F) / ((float)(l1 - j1) - 15.0F);

            if (this.field_74240_q < 0.0F)
            {
                this.field_74240_q = 0.0F;
            }

            if (this.field_74240_q > 1.0F)
            {
                this.field_74240_q = 1.0F;
            }

            ((ContainerCreative)this.field_74193_d).func_75183_a(this.field_74240_q);
        }

        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        CreativeTabs[] acreativetabs = CreativeTabs.field_78032_a;
        int i2 = acreativetabs.length;

        for (int j2 = 0; j2 < i2; ++j2)
        {
            CreativeTabs creativetabs = acreativetabs[j2];

            if (this.func_74231_b(creativetabs, p_73863_1_, p_73863_2_))
            {
                break;
            }
        }

        if (this.field_74235_v != null && field_74241_p == CreativeTabs.field_78036_m.func_78021_a() && this.func_74188_c(this.field_74235_v.field_75223_e, this.field_74235_v.field_75221_f, 16, 16, p_73863_1_, p_73863_2_))
        {
            this.func_74190_a(I18n.func_135053_a("inventory.binSlot"), p_73863_1_, p_73863_2_);
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
    }

    protected void func_74184_a(ItemStack p_74184_1_, int p_74184_2_, int p_74184_3_)
    {
        if (field_74241_p == CreativeTabs.field_78027_g.func_78021_a())
        {
            List list = p_74184_1_.func_82840_a(this.field_73882_e.field_71439_g, this.field_73882_e.field_71474_y.field_82882_x);
            CreativeTabs creativetabs = p_74184_1_.func_77973_b().func_77640_w();

            if (creativetabs == null && p_74184_1_.field_77993_c == Item.field_92105_bW.field_77779_bT)
            {
                Map map = EnchantmentHelper.func_82781_a(p_74184_1_);

                if (map.size() == 1)
                {
                    Enchantment enchantment = Enchantment.field_77331_b[((Integer)map.keySet().iterator().next()).intValue()];
                    CreativeTabs[] acreativetabs = CreativeTabs.field_78032_a;
                    int k = acreativetabs.length;

                    for (int l = 0; l < k; ++l)
                    {
                        CreativeTabs creativetabs1 = acreativetabs[l];

                        if (creativetabs1.func_111226_a(enchantment.field_77351_y))
                        {
                            creativetabs = creativetabs1;
                            break;
                        }
                    }
                }
            }

            if (creativetabs != null)
            {
                list.add(1, "" + EnumChatFormatting.BOLD + EnumChatFormatting.BLUE + I18n.func_135053_a(creativetabs.func_78024_c()));
            }

            for (int i1 = 0; i1 < list.size(); ++i1)
            {
                if (i1 == 0)
                {
                    list.set(i1, "\u00a7" + Integer.toHexString(p_74184_1_.func_77953_t().field_77937_e) + (String)list.get(i1));
                }
                else
                {
                    list.set(i1, EnumChatFormatting.GRAY + (String)list.get(i1));
                }
            }

            this.func_102021_a(list, p_74184_2_, p_74184_3_);
        }
        else
        {
            super.func_74184_a(p_74184_1_, p_74184_2_, p_74184_3_);
        }
    }

    protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderHelper.func_74520_c();
        CreativeTabs creativetabs = CreativeTabs.field_78032_a[field_74241_p];
        CreativeTabs[] acreativetabs = CreativeTabs.field_78032_a;
        int k = acreativetabs.length;
        int l;

        for (l = 0; l < k; ++l)
        {
            CreativeTabs creativetabs1 = acreativetabs[l];
            this.field_73882_e.func_110434_K().func_110577_a(field_110424_t);

            if (creativetabs1.func_78021_a() != field_74241_p)
            {
                this.func_74233_a(creativetabs1);
            }
        }

        this.field_73882_e.func_110434_K().func_110577_a(new ResourceLocation("textures/gui/container/creative_inventory/tab_" + creativetabs.func_78015_f()));
        this.func_73729_b(this.field_74198_m, this.field_74197_n, 0, 0, this.field_74194_b, this.field_74195_c);
        this.field_74237_t.func_73795_f();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int i1 = this.field_74198_m + 175;
        k = this.field_74197_n + 18;
        l = k + 112;
        this.field_73882_e.func_110434_K().func_110577_a(field_110424_t);

        if (creativetabs.func_78017_i())
        {
            this.func_73729_b(i1, k + (int)((float)(l - k - 17) * this.field_74240_q), 232 + (this.func_74226_k() ? 0 : 12), 0, 12, 15);
        }

        this.func_74233_a(creativetabs);

        if (creativetabs == CreativeTabs.field_78036_m)
        {
            GuiInventory.func_110423_a(this.field_74198_m + 43, this.field_74197_n + 45, 20, (float)(this.field_74198_m + 43 - p_74185_2_), (float)(this.field_74197_n + 45 - 30 - p_74185_3_), this.field_73882_e.field_71439_g);
        }
    }

    protected boolean func_74232_a(CreativeTabs p_74232_1_, int p_74232_2_, int p_74232_3_)
    {
        int k = p_74232_1_.func_78020_k();
        int l = 28 * k;
        byte b0 = 0;

        if (k == 5)
        {
            l = this.field_74194_b - 28 + 2;
        }
        else if (k > 0)
        {
            l += k;
        }

        int i1;

        if (p_74232_1_.func_78023_l())
        {
            i1 = b0 - 32;
        }
        else
        {
            i1 = b0 + this.field_74195_c;
        }

        return p_74232_2_ >= l && p_74232_2_ <= l + 28 && p_74232_3_ >= i1 && p_74232_3_ <= i1 + 32;
    }

    protected boolean func_74231_b(CreativeTabs p_74231_1_, int p_74231_2_, int p_74231_3_)
    {
        int k = p_74231_1_.func_78020_k();
        int l = 28 * k;
        byte b0 = 0;

        if (k == 5)
        {
            l = this.field_74194_b - 28 + 2;
        }
        else if (k > 0)
        {
            l += k;
        }

        int i1;

        if (p_74231_1_.func_78023_l())
        {
            i1 = b0 - 32;
        }
        else
        {
            i1 = b0 + this.field_74195_c;
        }

        if (this.func_74188_c(l + 3, i1 + 3, 23, 27, p_74231_2_, p_74231_3_))
        {
            this.func_74190_a(I18n.func_135053_a(p_74231_1_.func_78024_c()), p_74231_2_, p_74231_3_);
            return true;
        }
        else
        {
            return false;
        }
    }

    protected void func_74233_a(CreativeTabs p_74233_1_)
    {
        boolean flag = p_74233_1_.func_78021_a() == field_74241_p;
        boolean flag1 = p_74233_1_.func_78023_l();
        int i = p_74233_1_.func_78020_k();
        int j = i * 28;
        int k = 0;
        int l = this.field_74198_m + 28 * i;
        int i1 = this.field_74197_n;
        byte b0 = 32;

        if (flag)
        {
            k += 32;
        }

        if (i == 5)
        {
            l = this.field_74198_m + this.field_74194_b - 28;
        }
        else if (i > 0)
        {
            l += i;
        }

        if (flag1)
        {
            i1 -= 28;
        }
        else
        {
            k += 64;
            i1 += this.field_74195_c - 4;
        }

        GL11.glDisable(GL11.GL_LIGHTING);
        this.func_73729_b(l, i1, j, k, 28, b0);
        this.field_73735_i = 100.0F;
        field_74196_a.field_77023_b = 100.0F;
        l += 6;
        i1 += 8 + (flag1 ? 1 : -1);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        ItemStack itemstack = new ItemStack(p_74233_1_.func_78016_d());
        field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.func_110434_K(), itemstack, l, i1);
        field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e.func_110434_K(), itemstack, l, i1);
        GL11.glDisable(GL11.GL_LIGHTING);
        field_74196_a.field_77023_b = 0.0F;
        this.field_73735_i = 0.0F;
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73741_f == 0)
        {
            this.field_73882_e.func_71373_a(new GuiAchievements(this.field_73882_e.field_71413_E));
        }

        if (p_73875_1_.field_73741_f == 1)
        {
            this.field_73882_e.func_71373_a(new GuiStats(this, this.field_73882_e.field_71413_E));
        }
    }

    public int func_74230_h()
    {
        return field_74241_p;
    }

    static InventoryBasic func_74229_i()
    {
        return field_74242_o;
    }
}
