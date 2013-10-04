package net.minecraft.profiler;

import java.util.HashMap;
import java.util.TimerTask;
import net.minecraft.util.HttpUtil;

class PlayerUsageSnooperThread extends TimerTask
{
    final PlayerUsageSnooper field_76344_a;

    PlayerUsageSnooperThread(PlayerUsageSnooper p_i1562_1_)
    {
        this.field_76344_a = p_i1562_1_;
    }

    public void run()
    {
        if (PlayerUsageSnooper.func_76473_a(this.field_76344_a).func_70002_Q())
        {
            HashMap hashmap;

            synchronized (PlayerUsageSnooper.func_76474_b(this.field_76344_a))
            {
                hashmap = new HashMap(PlayerUsageSnooper.func_76469_c(this.field_76344_a));
                hashmap.put("snooper_count", Integer.valueOf(PlayerUsageSnooper.func_76466_d(this.field_76344_a)));
            }

            HttpUtil.func_76183_a(PlayerUsageSnooper.func_76473_a(this.field_76344_a).func_98033_al(), PlayerUsageSnooper.func_76475_e(this.field_76344_a), hashmap, true);
        }
    }
}
