package net.minecraft.world;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class GameRules
{
    private TreeMap field_82771_a = new TreeMap();

    public GameRules()
    {
        this.func_82769_a("doFireTick", "true");
        this.func_82769_a("mobGriefing", "true");
        this.func_82769_a("keepInventory", "false");
        this.func_82769_a("doMobSpawning", "true");
        this.func_82769_a("doMobLoot", "true");
        this.func_82769_a("doTileDrops", "true");
        this.func_82769_a("commandBlockOutput", "true");
        this.func_82769_a("naturalRegeneration", "true");
        this.func_82769_a("doDaylightCycle", "true");
    }

    public void func_82769_a(String p_82769_1_, String p_82769_2_)
    {
        this.field_82771_a.put(p_82769_1_, new GameRuleValue(p_82769_2_));
    }

    public void func_82764_b(String p_82764_1_, String p_82764_2_)
    {
        GameRuleValue gamerulevalue = (GameRuleValue)this.field_82771_a.get(p_82764_1_);

        if (gamerulevalue != null)
        {
            gamerulevalue.func_82757_a(p_82764_2_);
        }
        else
        {
            this.func_82769_a(p_82764_1_, p_82764_2_);
        }
    }

    public String func_82767_a(String p_82767_1_)
    {
        GameRuleValue gamerulevalue = (GameRuleValue)this.field_82771_a.get(p_82767_1_);
        return gamerulevalue != null ? gamerulevalue.func_82756_a() : "";
    }

    public boolean func_82766_b(String p_82766_1_)
    {
        GameRuleValue gamerulevalue = (GameRuleValue)this.field_82771_a.get(p_82766_1_);
        return gamerulevalue != null ? gamerulevalue.func_82758_b() : false;
    }

    public NBTTagCompound func_82770_a()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound("GameRules");
        Iterator iterator = this.field_82771_a.keySet().iterator();

        while (iterator.hasNext())
        {
            String s = (String)iterator.next();
            GameRuleValue gamerulevalue = (GameRuleValue)this.field_82771_a.get(s);
            nbttagcompound.func_74778_a(s, gamerulevalue.func_82756_a());
        }

        return nbttagcompound;
    }

    public void func_82768_a(NBTTagCompound p_82768_1_)
    {
        Collection collection = p_82768_1_.func_74758_c();
        Iterator iterator = collection.iterator();

        while (iterator.hasNext())
        {
            NBTBase nbtbase = (NBTBase)iterator.next();
            String s = nbtbase.func_74740_e();
            String s1 = p_82768_1_.func_74779_i(nbtbase.func_74740_e());
            this.func_82764_b(s, s1);
        }
    }

    public String[] func_82763_b()
    {
        return (String[])this.field_82771_a.keySet().toArray(new String[0]);
    }

    public boolean func_82765_e(String p_82765_1_)
    {
        return this.field_82771_a.containsKey(p_82765_1_);
    }
}
