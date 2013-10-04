package net.minecraft.entity.ai.attributes;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.server.management.LowerStringMap;

public class ServersideAttributeMap extends BaseAttributeMap
{
    private final Set field_111162_d = Sets.newHashSet();
    protected final Map field_111163_c = new LowerStringMap();

    public ModifiableAttributeInstance func_111159_c(Attribute p_111159_1_)
    {
        return (ModifiableAttributeInstance)super.func_111151_a(p_111159_1_);
    }

    public ModifiableAttributeInstance func_111158_b(String p_111158_1_)
    {
        AttributeInstance attributeinstance = super.func_111152_a(p_111158_1_);

        if (attributeinstance == null)
        {
            attributeinstance = (AttributeInstance)this.field_111163_c.get(p_111158_1_);
        }

        return (ModifiableAttributeInstance)attributeinstance;
    }

    public AttributeInstance func_111150_b(Attribute p_111150_1_)
    {
        if (this.field_111153_b.containsKey(p_111150_1_.func_111108_a()))
        {
            throw new IllegalArgumentException("Attribute is already registered!");
        }
        else
        {
            ModifiableAttributeInstance modifiableattributeinstance = new ModifiableAttributeInstance(this, p_111150_1_);
            this.field_111153_b.put(p_111150_1_.func_111108_a(), modifiableattributeinstance);

            if (p_111150_1_ instanceof RangedAttribute && ((RangedAttribute)p_111150_1_).func_111116_f() != null)
            {
                this.field_111163_c.put(((RangedAttribute)p_111150_1_).func_111116_f(), modifiableattributeinstance);
            }

            this.field_111154_a.put(p_111150_1_, modifiableattributeinstance);
            return modifiableattributeinstance;
        }
    }

    public void func_111149_a(ModifiableAttributeInstance p_111149_1_)
    {
        if (p_111149_1_.func_111123_a().func_111111_c())
        {
            this.field_111162_d.add(p_111149_1_);
        }
    }

    public Set func_111161_b()
    {
        return this.field_111162_d;
    }

    public Collection func_111160_c()
    {
        HashSet hashset = Sets.newHashSet();
        Iterator iterator = this.func_111146_a().iterator();

        while (iterator.hasNext())
        {
            AttributeInstance attributeinstance = (AttributeInstance)iterator.next();

            if (attributeinstance.func_111123_a().func_111111_c())
            {
                hashset.add(attributeinstance);
            }
        }

        return hashset;
    }

    public AttributeInstance func_111152_a(String p_111152_1_)
    {
        return this.func_111158_b(p_111152_1_);
    }

    public AttributeInstance func_111151_a(Attribute p_111151_1_)
    {
        return this.func_111159_c(p_111151_1_);
    }
}
