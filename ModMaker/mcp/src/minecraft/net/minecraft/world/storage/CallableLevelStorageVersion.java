package net.minecraft.world.storage;

import java.util.concurrent.Callable;

class CallableLevelStorageVersion implements Callable
{
    final WorldInfo field_85113_a;

    CallableLevelStorageVersion(WorldInfo p_i2154_1_)
    {
        this.field_85113_a = p_i2154_1_;
    }

    public String func_85112_a()
    {
        String s = "Unknown?";

        try
        {
            switch (WorldInfo.func_85121_j(this.field_85113_a))
            {
                case 19132:
                    s = "McRegion";
                    break;
                case 19133:
                    s = "Anvil";
            }
        }
        catch (Throwable throwable)
        {
            ;
        }

        return String.format("0x%05X - %s", new Object[] {Integer.valueOf(WorldInfo.func_85121_j(this.field_85113_a)), s});
    }

    public Object call()
    {
        return this.func_85112_a();
    }
}
