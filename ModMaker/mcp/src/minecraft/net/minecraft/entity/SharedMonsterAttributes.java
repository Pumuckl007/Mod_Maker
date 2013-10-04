package net.minecraft.entity;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.logging.ILogAgent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class SharedMonsterAttributes
{
    public static final Attribute field_111267_a = (new RangedAttribute("generic.maxHealth", 20.0D, 0.0D, Double.MAX_VALUE)).func_111117_a("Max Health").func_111112_a(true);
    public static final Attribute field_111265_b = (new RangedAttribute("generic.followRange", 32.0D, 0.0D, 2048.0D)).func_111117_a("Follow Range");
    public static final Attribute field_111266_c = (new RangedAttribute("generic.knockbackResistance", 0.0D, 0.0D, 1.0D)).func_111117_a("Knockback Resistance");
    public static final Attribute field_111263_d = (new RangedAttribute("generic.movementSpeed", 0.699999988079071D, 0.0D, Double.MAX_VALUE)).func_111117_a("Movement Speed").func_111112_a(true);
    public static final Attribute field_111264_e = new RangedAttribute("generic.attackDamage", 2.0D, 0.0D, Double.MAX_VALUE);

    public static NBTTagList func_111257_a(BaseAttributeMap p_111257_0_)
    {
        NBTTagList nbttaglist = new NBTTagList();
        Iterator iterator = p_111257_0_.func_111146_a().iterator();

        while (iterator.hasNext())
        {
            AttributeInstance attributeinstance = (AttributeInstance)iterator.next();
            nbttaglist.func_74742_a(func_111261_a(attributeinstance));
        }

        return nbttaglist;
    }

    private static NBTTagCompound func_111261_a(AttributeInstance p_111261_0_)
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        Attribute attribute = p_111261_0_.func_111123_a();
        nbttagcompound.func_74778_a("Name", attribute.func_111108_a());
        nbttagcompound.func_74780_a("Base", p_111261_0_.func_111125_b());
        Collection collection = p_111261_0_.func_111122_c();

        if (collection != null && !collection.isEmpty())
        {
            NBTTagList nbttaglist = new NBTTagList();
            Iterator iterator = collection.iterator();

            while (iterator.hasNext())
            {
                AttributeModifier attributemodifier = (AttributeModifier)iterator.next();

                if (attributemodifier.func_111165_e())
                {
                    nbttaglist.func_74742_a(func_111262_a(attributemodifier));
                }
            }

            nbttagcompound.func_74782_a("Modifiers", nbttaglist);
        }

        return nbttagcompound;
    }

    private static NBTTagCompound func_111262_a(AttributeModifier p_111262_0_)
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.func_74778_a("Name", p_111262_0_.func_111166_b());
        nbttagcompound.func_74780_a("Amount", p_111262_0_.func_111164_d());
        nbttagcompound.func_74768_a("Operation", p_111262_0_.func_111169_c());
        nbttagcompound.func_74772_a("UUIDMost", p_111262_0_.func_111167_a().getMostSignificantBits());
        nbttagcompound.func_74772_a("UUIDLeast", p_111262_0_.func_111167_a().getLeastSignificantBits());
        return nbttagcompound;
    }

    public static void func_111260_a(BaseAttributeMap p_111260_0_, NBTTagList p_111260_1_, ILogAgent p_111260_2_)
    {
        for (int i = 0; i < p_111260_1_.func_74745_c(); ++i)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)p_111260_1_.func_74743_b(i);
            AttributeInstance attributeinstance = p_111260_0_.func_111152_a(nbttagcompound.func_74779_i("Name"));

            if (attributeinstance != null)
            {
                func_111258_a(attributeinstance, nbttagcompound);
            }
            else if (p_111260_2_ != null)
            {
                p_111260_2_.func_98236_b("Ignoring unknown attribute \'" + nbttagcompound.func_74779_i("Name") + "\'");
            }
        }
    }

    private static void func_111258_a(AttributeInstance p_111258_0_, NBTTagCompound p_111258_1_)
    {
        p_111258_0_.func_111128_a(p_111258_1_.func_74769_h("Base"));

        if (p_111258_1_.func_74764_b("Modifiers"))
        {
            NBTTagList nbttaglist = p_111258_1_.func_74761_m("Modifiers");

            for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
            {
                AttributeModifier attributemodifier = func_111259_a((NBTTagCompound)nbttaglist.func_74743_b(i));
                AttributeModifier attributemodifier1 = p_111258_0_.func_111127_a(attributemodifier.func_111167_a());

                if (attributemodifier1 != null)
                {
                    p_111258_0_.func_111124_b(attributemodifier1);
                }

                p_111258_0_.func_111121_a(attributemodifier);
            }
        }
    }

    public static AttributeModifier func_111259_a(NBTTagCompound p_111259_0_)
    {
        UUID uuid = new UUID(p_111259_0_.func_74763_f("UUIDMost"), p_111259_0_.func_74763_f("UUIDLeast"));
        return new AttributeModifier(uuid, p_111259_0_.func_74779_i("Name"), p_111259_0_.func_74769_h("Amount"), p_111259_0_.func_74762_e("Operation"));
    }
}