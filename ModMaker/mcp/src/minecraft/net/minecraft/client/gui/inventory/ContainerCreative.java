package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

@SideOnly(Side.CLIENT)
class ContainerCreative extends Container
{
    public List field_75185_e = new ArrayList();

    public ContainerCreative(EntityPlayer p_i1086_1_)
    {
        InventoryPlayer inventoryplayer = p_i1086_1_.field_71071_by;
        int i;

        for (i = 0; i < 5; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.func_75146_a(new Slot(GuiContainerCreative.func_74229_i(), i * 9 + j, 9 + j * 18, 18 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.func_75146_a(new Slot(inventoryplayer, i, 9 + i * 18, 112));
        }

        this.func_75183_a(0.0F);
    }

    public boolean func_75145_c(EntityPlayer p_75145_1_)
    {
        return true;
    }

    public void func_75183_a(float p_75183_1_)
    {
        int i = this.field_75185_e.size() / 9 - 5 + 1;
        int j = (int)((double)(p_75183_1_ * (float)i) + 0.5D);

        if (j < 0)
        {
            j = 0;
        }

        for (int k = 0; k < 5; ++k)
        {
            for (int l = 0; l < 9; ++l)
            {
                int i1 = l + (k + j) * 9;

                if (i1 >= 0 && i1 < this.field_75185_e.size())
                {
                    GuiContainerCreative.func_74229_i().func_70299_a(l + k * 9, (ItemStack)this.field_75185_e.get(i1));
                }
                else
                {
                    GuiContainerCreative.func_74229_i().func_70299_a(l + k * 9, (ItemStack)null);
                }
            }
        }
    }

    public boolean func_75184_d()
    {
        return this.field_75185_e.size() > 45;
    }

    protected void func_75133_b(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_) {}

    public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        if (p_82846_2_ >= this.field_75151_b.size() - 9 && p_82846_2_ < this.field_75151_b.size())
        {
            Slot slot = (Slot)this.field_75151_b.get(p_82846_2_);

            if (slot != null && slot.func_75216_d())
            {
                slot.func_75215_d((ItemStack)null);
            }
        }

        return null;
    }

    public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_)
    {
        return p_94530_2_.field_75221_f > 90;
    }

    public boolean func_94531_b(Slot p_94531_1_)
    {
        return p_94531_1_.field_75224_c instanceof InventoryPlayer || p_94531_1_.field_75221_f > 90 && p_94531_1_.field_75223_e <= 162;
    }
}
