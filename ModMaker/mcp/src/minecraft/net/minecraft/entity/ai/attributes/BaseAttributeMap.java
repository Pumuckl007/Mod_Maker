package net.minecraft.entity.ai.attributes;

import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.server.management.LowerStringMap;

public abstract class BaseAttributeMap
{
    protected final Map field_111154_a = new HashMap();
    protected final Map field_111153_b = new LowerStringMap();

    public AttributeInstance func_111151_a(Attribute p_111151_1_)
    {
        return (AttributeInstance)this.field_111154_a.get(p_111151_1_);
    }

    public AttributeInstance func_111152_a(String p_111152_1_)
    {
        return (AttributeInstance)this.field_111153_b.get(p_111152_1_);
    }

    public abstract AttributeInstance func_111150_b(Attribute attribute);

    public Collection func_111146_a()
    {
        return this.field_111153_b.values();
    }

    public void func_111149_a(ModifiableAttributeInstance p_111149_1_) {}

    public void func_111148_a(Multimap p_111148_1_)
    {
        Iterator iterator = p_111148_1_.entries().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();
            AttributeInstance attributeinstance = this.func_111152_a((String)entry.getKey());

            if (attributeinstance != null)
            {
                attributeinstance.func_111124_b((AttributeModifier)entry.getValue());
            }
        }
    }

    public void func_111147_b(Multimap p_111147_1_)
    {
        Iterator iterator = p_111147_1_.entries().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();
            AttributeInstance attributeinstance = this.func_111152_a((String)entry.getKey());

            if (attributeinstance != null)
            {
                attributeinstance.func_111124_b((AttributeModifier)entry.getValue());
                attributeinstance.func_111121_a((AttributeModifier)entry.getValue());
            }
        }
    }
}
