package net.minecraft.util;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;

public class ChatMessageComponent
{
    private static final Gson field_111089_a = (new GsonBuilder()).registerTypeAdapter(ChatMessageComponent.class, new MessageComponentSerializer()).create();
    private EnumChatFormatting field_111087_b;
    private Boolean field_111088_c;
    private Boolean field_111085_d;
    private Boolean field_111086_e;
    private Boolean field_111083_f;
    private String field_111084_g;
    private String field_111090_h;
    private List field_111091_i;

    public ChatMessageComponent() {}

    public ChatMessageComponent(ChatMessageComponent p_i1399_1_)
    {
        this.field_111087_b = p_i1399_1_.field_111087_b;
        this.field_111088_c = p_i1399_1_.field_111088_c;
        this.field_111085_d = p_i1399_1_.field_111085_d;
        this.field_111086_e = p_i1399_1_.field_111086_e;
        this.field_111083_f = p_i1399_1_.field_111083_f;
        this.field_111084_g = p_i1399_1_.field_111084_g;
        this.field_111090_h = p_i1399_1_.field_111090_h;
        this.field_111091_i = p_i1399_1_.field_111091_i == null ? null : Lists.newArrayList(p_i1399_1_.field_111091_i);
    }

    public ChatMessageComponent func_111059_a(EnumChatFormatting p_111059_1_)
    {
        if (p_111059_1_ != null && !p_111059_1_.func_96302_c())
        {
            throw new IllegalArgumentException("Argument is not a valid color!");
        }
        else
        {
            this.field_111087_b = p_111059_1_;
            return this;
        }
    }

    public EnumChatFormatting func_111065_a()
    {
        return this.field_111087_b;
    }

    public ChatMessageComponent func_111071_a(Boolean p_111071_1_)
    {
        this.field_111088_c = p_111071_1_;
        return this;
    }

    public Boolean func_111058_b()
    {
        return this.field_111088_c;
    }

    public ChatMessageComponent func_111063_b(Boolean p_111063_1_)
    {
        this.field_111085_d = p_111063_1_;
        return this;
    }

    public Boolean func_111064_c()
    {
        return this.field_111085_d;
    }

    public ChatMessageComponent func_111081_c(Boolean p_111081_1_)
    {
        this.field_111086_e = p_111081_1_;
        return this;
    }

    public Boolean func_111067_d()
    {
        return this.field_111086_e;
    }

    public ChatMessageComponent func_111061_d(Boolean p_111061_1_)
    {
        this.field_111083_f = p_111061_1_;
        return this;
    }

    public Boolean func_111076_e()
    {
        return this.field_111083_f;
    }

    protected String func_111075_f()
    {
        return this.field_111084_g;
    }

    protected String func_111074_g()
    {
        return this.field_111090_h;
    }

    protected List func_111069_h()
    {
        return this.field_111091_i;
    }

    public ChatMessageComponent func_111073_a(ChatMessageComponent p_111073_1_)
    {
        if (this.field_111084_g == null && this.field_111090_h == null)
        {
            if (this.field_111091_i != null)
            {
                this.field_111091_i.add(p_111073_1_);
            }
            else
            {
                this.field_111091_i = Lists.newArrayList(new ChatMessageComponent[] {p_111073_1_});
            }
        }
        else
        {
            this.field_111091_i = Lists.newArrayList(new ChatMessageComponent[] {new ChatMessageComponent(this), p_111073_1_});
            this.field_111084_g = null;
            this.field_111090_h = null;
        }

        return this;
    }

    public ChatMessageComponent func_111079_a(String p_111079_1_)
    {
        if (this.field_111084_g == null && this.field_111090_h == null)
        {
            if (this.field_111091_i != null)
            {
                this.field_111091_i.add(func_111066_d(p_111079_1_));
            }
            else
            {
                this.field_111084_g = p_111079_1_;
            }
        }
        else
        {
            this.field_111091_i = Lists.newArrayList(new ChatMessageComponent[] {new ChatMessageComponent(this), func_111066_d(p_111079_1_)});
            this.field_111084_g = null;
            this.field_111090_h = null;
        }

        return this;
    }

    public ChatMessageComponent func_111072_b(String p_111072_1_)
    {
        if (this.field_111084_g == null && this.field_111090_h == null)
        {
            if (this.field_111091_i != null)
            {
                this.field_111091_i.add(func_111077_e(p_111072_1_));
            }
            else
            {
                this.field_111090_h = p_111072_1_;
            }
        }
        else
        {
            this.field_111091_i = Lists.newArrayList(new ChatMessageComponent[] {new ChatMessageComponent(this), func_111077_e(p_111072_1_)});
            this.field_111084_g = null;
            this.field_111090_h = null;
        }

        return this;
    }

    public ChatMessageComponent func_111080_a(String p_111080_1_, Object ... p_111080_2_)
    {
        if (this.field_111084_g == null && this.field_111090_h == null)
        {
            if (this.field_111091_i != null)
            {
                this.field_111091_i.add(func_111082_b(p_111080_1_, p_111080_2_));
            }
            else
            {
                this.field_111090_h = p_111080_1_;
                this.field_111091_i = Lists.newArrayList();
                Object[] aobject = p_111080_2_;
                int i = p_111080_2_.length;

                for (int j = 0; j < i; ++j)
                {
                    Object object1 = aobject[j];

                    if (object1 instanceof ChatMessageComponent)
                    {
                        this.field_111091_i.add((ChatMessageComponent)object1);
                    }
                    else
                    {
                        this.field_111091_i.add(func_111066_d(object1.toString()));
                    }
                }
            }
        }
        else
        {
            this.field_111091_i = Lists.newArrayList(new ChatMessageComponent[] {new ChatMessageComponent(this), func_111082_b(p_111080_1_, p_111080_2_)});
            this.field_111084_g = null;
            this.field_111090_h = null;
        }

        return this;
    }

    public String toString()
    {
        return this.func_111068_a(false);
    }

    public String func_111068_a(boolean p_111068_1_)
    {
        return this.func_111070_a(p_111068_1_, (EnumChatFormatting)null, false, false, false, false);
    }

    public String func_111070_a(boolean p_111070_1_, EnumChatFormatting p_111070_2_, boolean p_111070_3_, boolean p_111070_4_, boolean p_111070_5_, boolean p_111070_6_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        EnumChatFormatting enumchatformatting1 = this.field_111087_b == null ? p_111070_2_ : this.field_111087_b;
        boolean flag5 = this.field_111088_c == null ? p_111070_3_ : this.field_111088_c.booleanValue();
        boolean flag6 = this.field_111085_d == null ? p_111070_4_ : this.field_111085_d.booleanValue();
        boolean flag7 = this.field_111086_e == null ? p_111070_5_ : this.field_111086_e.booleanValue();
        boolean flag8 = this.field_111083_f == null ? p_111070_6_ : this.field_111083_f.booleanValue();

        if (this.field_111090_h != null)
        {
            if (p_111070_1_)
            {
                func_111060_a(stringbuilder, enumchatformatting1, flag5, flag6, flag7, flag8);
            }

            if (this.field_111091_i != null)
            {
                String[] astring = new String[this.field_111091_i.size()];

                for (int i = 0; i < this.field_111091_i.size(); ++i)
                {
                    astring[i] = ((ChatMessageComponent)this.field_111091_i.get(i)).func_111070_a(p_111070_1_, enumchatformatting1, flag5, flag6, flag7, flag8);
                }

                stringbuilder.append(StatCollector.func_74837_a(this.field_111090_h, astring));
            }
            else
            {
                stringbuilder.append(StatCollector.func_74838_a(this.field_111090_h));
            }
        }
        else if (this.field_111084_g != null)
        {
            if (p_111070_1_)
            {
                func_111060_a(stringbuilder, enumchatformatting1, flag5, flag6, flag7, flag8);
            }

            stringbuilder.append(this.field_111084_g);
        }
        else
        {
            ChatMessageComponent chatmessagecomponent;

            if (this.field_111091_i != null)
            {
                for (Iterator iterator = this.field_111091_i.iterator(); iterator.hasNext(); stringbuilder.append(chatmessagecomponent.func_111070_a(p_111070_1_, enumchatformatting1, flag5, flag6, flag7, flag8)))
                {
                    chatmessagecomponent = (ChatMessageComponent)iterator.next();

                    if (p_111070_1_)
                    {
                        func_111060_a(stringbuilder, enumchatformatting1, flag5, flag6, flag7, flag8);
                    }
                }
            }
        }

        return stringbuilder.toString();
    }

    private static void func_111060_a(StringBuilder p_111060_0_, EnumChatFormatting p_111060_1_, boolean p_111060_2_, boolean p_111060_3_, boolean p_111060_4_, boolean p_111060_5_)
    {
        if (p_111060_1_ != null)
        {
            p_111060_0_.append(p_111060_1_);
        }
        else if (p_111060_2_ || p_111060_3_ || p_111060_4_ || p_111060_5_)
        {
            p_111060_0_.append(EnumChatFormatting.RESET);
        }

        if (p_111060_2_)
        {
            p_111060_0_.append(EnumChatFormatting.BOLD);
        }

        if (p_111060_3_)
        {
            p_111060_0_.append(EnumChatFormatting.ITALIC);
        }

        if (p_111060_4_)
        {
            p_111060_0_.append(EnumChatFormatting.UNDERLINE);
        }

        if (p_111060_5_)
        {
            p_111060_0_.append(EnumChatFormatting.OBFUSCATED);
        }
    }

    @SideOnly(Side.CLIENT)
    public static ChatMessageComponent func_111078_c(String p_111078_0_)
    {
        try
        {
            return (ChatMessageComponent)field_111089_a.fromJson(p_111078_0_, ChatMessageComponent.class);
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.func_85055_a(throwable, "Deserializing Message");
            CrashReportCategory crashreportcategory = crashreport.func_85058_a("Serialized Message");
            crashreportcategory.func_71507_a("JSON string", p_111078_0_);
            throw new ReportedException(crashreport);
        }
    }

    public static ChatMessageComponent func_111066_d(String p_111066_0_)
    {
        ChatMessageComponent chatmessagecomponent = new ChatMessageComponent();
        chatmessagecomponent.func_111079_a(p_111066_0_);
        return chatmessagecomponent;
    }

    public static ChatMessageComponent func_111077_e(String p_111077_0_)
    {
        ChatMessageComponent chatmessagecomponent = new ChatMessageComponent();
        chatmessagecomponent.func_111072_b(p_111077_0_);
        return chatmessagecomponent;
    }

    public static ChatMessageComponent func_111082_b(String p_111082_0_, Object ... p_111082_1_)
    {
        ChatMessageComponent chatmessagecomponent = new ChatMessageComponent();
        chatmessagecomponent.func_111080_a(p_111082_0_, p_111082_1_);
        return chatmessagecomponent;
    }

    public String func_111062_i()
    {
        return field_111089_a.toJson(this);
    }
}
