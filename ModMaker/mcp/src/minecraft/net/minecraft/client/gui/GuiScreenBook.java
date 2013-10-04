package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiScreenBook extends GuiScreen
{
    private static final ResourceLocation field_110405_a = new ResourceLocation("textures/gui/book.png");
    private final EntityPlayer field_74169_a;
    private final ItemStack field_74167_b;
    private final boolean field_74168_c;
    private boolean field_74166_d;
    private boolean field_74172_m;
    private int field_74170_n;
    private int field_74171_o = 192;
    private int field_74180_p = 192;
    private int field_74179_q = 1;
    private int field_74178_r;
    private NBTTagList field_74177_s;
    private String field_74176_t = "";
    private GuiButtonNextPage field_74175_u;
    private GuiButtonNextPage field_74174_v;
    private GuiButton field_74173_w;
    private GuiButton field_74183_x;
    private GuiButton field_74182_y;
    private GuiButton field_74181_z;

    public GuiScreenBook(EntityPlayer p_i1080_1_, ItemStack p_i1080_2_, boolean p_i1080_3_)
    {
        this.field_74169_a = p_i1080_1_;
        this.field_74167_b = p_i1080_2_;
        this.field_74168_c = p_i1080_3_;

        if (p_i1080_2_.func_77942_o())
        {
            NBTTagCompound nbttagcompound = p_i1080_2_.func_77978_p();
            this.field_74177_s = nbttagcompound.func_74761_m("pages");

            if (this.field_74177_s != null)
            {
                this.field_74177_s = (NBTTagList)this.field_74177_s.func_74737_b();
                this.field_74179_q = this.field_74177_s.func_74745_c();

                if (this.field_74179_q < 1)
                {
                    this.field_74179_q = 1;
                }
            }
        }

        if (this.field_74177_s == null && p_i1080_3_)
        {
            this.field_74177_s = new NBTTagList("pages");
            this.field_74177_s.func_74742_a(new NBTTagString("1", ""));
            this.field_74179_q = 1;
        }
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        ++this.field_74170_n;
    }

    public void func_73866_w_()
    {
        this.field_73887_h.clear();
        Keyboard.enableRepeatEvents(true);

        if (this.field_74168_c)
        {
            this.field_73887_h.add(this.field_74183_x = new GuiButton(3, this.field_73880_f / 2 - 100, 4 + this.field_74180_p, 98, 20, I18n.func_135053_a("book.signButton")));
            this.field_73887_h.add(this.field_74173_w = new GuiButton(0, this.field_73880_f / 2 + 2, 4 + this.field_74180_p, 98, 20, I18n.func_135053_a("gui.done")));
            this.field_73887_h.add(this.field_74182_y = new GuiButton(5, this.field_73880_f / 2 - 100, 4 + this.field_74180_p, 98, 20, I18n.func_135053_a("book.finalizeButton")));
            this.field_73887_h.add(this.field_74181_z = new GuiButton(4, this.field_73880_f / 2 + 2, 4 + this.field_74180_p, 98, 20, I18n.func_135053_a("gui.cancel")));
        }
        else
        {
            this.field_73887_h.add(this.field_74173_w = new GuiButton(0, this.field_73880_f / 2 - 100, 4 + this.field_74180_p, 200, 20, I18n.func_135053_a("gui.done")));
        }

        int i = (this.field_73880_f - this.field_74171_o) / 2;
        byte b0 = 2;
        this.field_73887_h.add(this.field_74175_u = new GuiButtonNextPage(1, i + 120, b0 + 154, true));
        this.field_73887_h.add(this.field_74174_v = new GuiButtonNextPage(2, i + 38, b0 + 154, false));
        this.func_74161_g();
    }

    public void func_73874_b()
    {
        Keyboard.enableRepeatEvents(false);
    }

    private void func_74161_g()
    {
        this.field_74175_u.field_73748_h = !this.field_74172_m && (this.field_74178_r < this.field_74179_q - 1 || this.field_74168_c);
        this.field_74174_v.field_73748_h = !this.field_74172_m && this.field_74178_r > 0;
        this.field_74173_w.field_73748_h = !this.field_74168_c || !this.field_74172_m;

        if (this.field_74168_c)
        {
            this.field_74183_x.field_73748_h = !this.field_74172_m;
            this.field_74181_z.field_73748_h = this.field_74172_m;
            this.field_74182_y.field_73748_h = this.field_74172_m;
            this.field_74182_y.field_73742_g = this.field_74176_t.trim().length() > 0;
        }
    }

    private void func_74163_a(boolean p_74163_1_)
    {
        if (this.field_74168_c && this.field_74166_d)
        {
            if (this.field_74177_s != null)
            {
                while (this.field_74177_s.func_74745_c() > 1)
                {
                    NBTTagString nbttagstring = (NBTTagString)this.field_74177_s.func_74743_b(this.field_74177_s.func_74745_c() - 1);

                    if (nbttagstring.field_74751_a != null && nbttagstring.field_74751_a.length() != 0)
                    {
                        break;
                    }

                    this.field_74177_s.func_74744_a(this.field_74177_s.func_74745_c() - 1);
                }

                if (this.field_74167_b.func_77942_o())
                {
                    NBTTagCompound nbttagcompound = this.field_74167_b.func_77978_p();
                    nbttagcompound.func_74782_a("pages", this.field_74177_s);
                }
                else
                {
                    this.field_74167_b.func_77983_a("pages", this.field_74177_s);
                }

                String s = "MC|BEdit";

                if (p_74163_1_)
                {
                    s = "MC|BSign";
                    this.field_74167_b.func_77983_a("author", new NBTTagString("author", this.field_74169_a.func_70005_c_()));
                    this.field_74167_b.func_77983_a("title", new NBTTagString("title", this.field_74176_t.trim()));
                    this.field_74167_b.field_77993_c = Item.field_77823_bG.field_77779_bT;
                }

                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);

                try
                {
                    Packet.func_73270_a(this.field_74167_b, dataoutputstream);
                    this.field_73882_e.func_71391_r().func_72552_c(new Packet250CustomPayload(s, bytearrayoutputstream.toByteArray()));
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73742_g)
        {
            if (p_73875_1_.field_73741_f == 0)
            {
                this.field_73882_e.func_71373_a((GuiScreen)null);
                this.func_74163_a(false);
            }
            else if (p_73875_1_.field_73741_f == 3 && this.field_74168_c)
            {
                this.field_74172_m = true;
            }
            else if (p_73875_1_.field_73741_f == 1)
            {
                if (this.field_74178_r < this.field_74179_q - 1)
                {
                    ++this.field_74178_r;
                }
                else if (this.field_74168_c)
                {
                    this.func_74165_h();

                    if (this.field_74178_r < this.field_74179_q - 1)
                    {
                        ++this.field_74178_r;
                    }
                }
            }
            else if (p_73875_1_.field_73741_f == 2)
            {
                if (this.field_74178_r > 0)
                {
                    --this.field_74178_r;
                }
            }
            else if (p_73875_1_.field_73741_f == 5 && this.field_74172_m)
            {
                this.func_74163_a(true);
                this.field_73882_e.func_71373_a((GuiScreen)null);
            }
            else if (p_73875_1_.field_73741_f == 4 && this.field_74172_m)
            {
                this.field_74172_m = false;
            }

            this.func_74161_g();
        }
    }

    private void func_74165_h()
    {
        if (this.field_74177_s != null && this.field_74177_s.func_74745_c() < 50)
        {
            this.field_74177_s.func_74742_a(new NBTTagString("" + (this.field_74179_q + 1), ""));
            ++this.field_74179_q;
            this.field_74166_d = true;
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        super.func_73869_a(p_73869_1_, p_73869_2_);

        if (this.field_74168_c)
        {
            if (this.field_74172_m)
            {
                this.func_74162_c(p_73869_1_, p_73869_2_);
            }
            else
            {
                this.func_74164_b(p_73869_1_, p_73869_2_);
            }
        }
    }

    private void func_74164_b(char p_74164_1_, int p_74164_2_)
    {
        switch (p_74164_1_)
        {
            case 22:
                this.func_74160_b(GuiScreen.func_73870_l());
                return;
            default:
                switch (p_74164_2_)
                {
                    case 14:
                        String s = this.func_74158_i();

                        if (s.length() > 0)
                        {
                            this.func_74159_a(s.substring(0, s.length() - 1));
                        }

                        return;
                    case 28:
                    case 156:
                        this.func_74160_b("\n");
                        return;
                    default:
                        if (ChatAllowedCharacters.func_71566_a(p_74164_1_))
                        {
                            this.func_74160_b(Character.toString(p_74164_1_));
                        }
                }
        }
    }

    private void func_74162_c(char p_74162_1_, int p_74162_2_)
    {
        switch (p_74162_2_)
        {
            case 14:
                if (!this.field_74176_t.isEmpty())
                {
                    this.field_74176_t = this.field_74176_t.substring(0, this.field_74176_t.length() - 1);
                    this.func_74161_g();
                }

                return;
            case 28:
            case 156:
                if (!this.field_74176_t.isEmpty())
                {
                    this.func_74163_a(true);
                    this.field_73882_e.func_71373_a((GuiScreen)null);
                }

                return;
            default:
                if (this.field_74176_t.length() < 16 && ChatAllowedCharacters.func_71566_a(p_74162_1_))
                {
                    this.field_74176_t = this.field_74176_t + Character.toString(p_74162_1_);
                    this.func_74161_g();
                    this.field_74166_d = true;
                }
        }
    }

    private String func_74158_i()
    {
        if (this.field_74177_s != null && this.field_74178_r >= 0 && this.field_74178_r < this.field_74177_s.func_74745_c())
        {
            NBTTagString nbttagstring = (NBTTagString)this.field_74177_s.func_74743_b(this.field_74178_r);
            return nbttagstring.toString();
        }
        else
        {
            return "";
        }
    }

    private void func_74159_a(String p_74159_1_)
    {
        if (this.field_74177_s != null && this.field_74178_r >= 0 && this.field_74178_r < this.field_74177_s.func_74745_c())
        {
            NBTTagString nbttagstring = (NBTTagString)this.field_74177_s.func_74743_b(this.field_74178_r);
            nbttagstring.field_74751_a = p_74159_1_;
            this.field_74166_d = true;
        }
    }

    private void func_74160_b(String p_74160_1_)
    {
        String s1 = this.func_74158_i();
        String s2 = s1 + p_74160_1_;
        int i = this.field_73886_k.func_78267_b(s2 + "" + EnumChatFormatting.BLACK + "_", 118);

        if (i <= 118 && s2.length() < 256)
        {
            this.func_74159_a(s2);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_73882_e.func_110434_K().func_110577_a(field_110405_a);
        int k = (this.field_73880_f - this.field_74171_o) / 2;
        byte b0 = 2;
        this.func_73729_b(k, b0, 0, 0, this.field_74171_o, this.field_74180_p);
        String s;
        String s1;
        int l;

        if (this.field_74172_m)
        {
            s = this.field_74176_t;

            if (this.field_74168_c)
            {
                if (this.field_74170_n / 6 % 2 == 0)
                {
                    s = s + "" + EnumChatFormatting.BLACK + "_";
                }
                else
                {
                    s = s + "" + EnumChatFormatting.GRAY + "_";
                }
            }

            s1 = I18n.func_135053_a("book.editTitle");
            l = this.field_73886_k.func_78256_a(s1);
            this.field_73886_k.func_78276_b(s1, k + 36 + (116 - l) / 2, b0 + 16 + 16, 0);
            int i1 = this.field_73886_k.func_78256_a(s);
            this.field_73886_k.func_78276_b(s, k + 36 + (116 - i1) / 2, b0 + 48, 0);
            String s2 = String.format(I18n.func_135053_a("book.byAuthor"), new Object[] {this.field_74169_a.func_70005_c_()});
            int j1 = this.field_73886_k.func_78256_a(s2);
            this.field_73886_k.func_78276_b(EnumChatFormatting.DARK_GRAY + s2, k + 36 + (116 - j1) / 2, b0 + 48 + 10, 0);
            String s3 = I18n.func_135053_a("book.finalizeWarning");
            this.field_73886_k.func_78279_b(s3, k + 36, b0 + 80, 116, 0);
        }
        else
        {
            s = String.format(I18n.func_135053_a("book.pageIndicator"), new Object[] {Integer.valueOf(this.field_74178_r + 1), Integer.valueOf(this.field_74179_q)});
            s1 = "";

            if (this.field_74177_s != null && this.field_74178_r >= 0 && this.field_74178_r < this.field_74177_s.func_74745_c())
            {
                NBTTagString nbttagstring = (NBTTagString)this.field_74177_s.func_74743_b(this.field_74178_r);
                s1 = nbttagstring.toString();
            }

            if (this.field_74168_c)
            {
                if (this.field_73886_k.func_78260_a())
                {
                    s1 = s1 + "_";
                }
                else if (this.field_74170_n / 6 % 2 == 0)
                {
                    s1 = s1 + "" + EnumChatFormatting.BLACK + "_";
                }
                else
                {
                    s1 = s1 + "" + EnumChatFormatting.GRAY + "_";
                }
            }

            l = this.field_73886_k.func_78256_a(s);
            this.field_73886_k.func_78276_b(s, k - l + this.field_74171_o - 44, b0 + 16, 0);
            this.field_73886_k.func_78279_b(s1, k + 36, b0 + 16 + 16, 116, 0);
        }

        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    static ResourceLocation func_110404_g()
    {
        return field_110405_a;
    }
}
