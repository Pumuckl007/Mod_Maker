package net.minecraft.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class WeightedRandom
{
    public static int func_76272_a(Collection p_76272_0_)
    {
        int i = 0;
        WeightedRandomItem weightedrandomitem;

        for (Iterator iterator = p_76272_0_.iterator(); iterator.hasNext(); i += weightedrandomitem.field_76292_a)
        {
            weightedrandomitem = (WeightedRandomItem)iterator.next();
        }

        return i;
    }

    public static WeightedRandomItem func_76273_a(Random p_76273_0_, Collection p_76273_1_, int p_76273_2_)
    {
        if (p_76273_2_ <= 0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            int j = p_76273_0_.nextInt(p_76273_2_);
            Iterator iterator = p_76273_1_.iterator();
            WeightedRandomItem weightedrandomitem;

            do
            {
                if (!iterator.hasNext())
                {
                    return null;
                }

                weightedrandomitem = (WeightedRandomItem)iterator.next();
                j -= weightedrandomitem.field_76292_a;
            }
            while (j >= 0);

            return weightedrandomitem;
        }
    }

    public static WeightedRandomItem func_76271_a(Random p_76271_0_, Collection p_76271_1_)
    {
        return func_76273_a(p_76271_0_, p_76271_1_, func_76272_a(p_76271_1_));
    }

    public static int func_76270_a(WeightedRandomItem[] p_76270_0_)
    {
        int i = 0;
        WeightedRandomItem[] aweightedrandomitem1 = p_76270_0_;
        int j = p_76270_0_.length;

        for (int k = 0; k < j; ++k)
        {
            WeightedRandomItem weightedrandomitem = aweightedrandomitem1[k];
            i += weightedrandomitem.field_76292_a;
        }

        return i;
    }

    public static WeightedRandomItem func_76269_a(Random p_76269_0_, WeightedRandomItem[] p_76269_1_, int p_76269_2_)
    {
        if (p_76269_2_ <= 0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            int j = p_76269_0_.nextInt(p_76269_2_);
            WeightedRandomItem[] aweightedrandomitem1 = p_76269_1_;
            int k = p_76269_1_.length;

            for (int l = 0; l < k; ++l)
            {
                WeightedRandomItem weightedrandomitem = aweightedrandomitem1[l];
                j -= weightedrandomitem.field_76292_a;

                if (j < 0)
                {
                    return weightedrandomitem;
                }
            }

            return null;
        }
    }

    public static WeightedRandomItem func_76274_a(Random p_76274_0_, WeightedRandomItem[] p_76274_1_)
    {
        return func_76269_a(p_76274_0_, p_76274_1_, func_76270_a(p_76274_1_));
    }
}
