package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class BlockDropper extends BlockDispenser
{
    private final IBehaviorDispenseItem field_96474_cR = new BehaviorDefaultDispenseItem();

    protected BlockDropper(int p_i2194_1_)
    {
        super(p_i2194_1_);
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        this.field_94336_cN = p_94332_1_.func_94245_a("furnace_side");
        this.field_94463_c = p_94332_1_.func_94245_a("furnace_top");
        this.field_94462_cO = p_94332_1_.func_94245_a(this.func_111023_E() + "_front_horizontal");
        this.field_96473_e = p_94332_1_.func_94245_a(this.func_111023_E() + "_front_vertical");
    }

    protected IBehaviorDispenseItem func_96472_a(ItemStack p_96472_1_)
    {
        return this.field_96474_cR;
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityDropper();
    }

    protected void func_82526_n(World p_82526_1_, int p_82526_2_, int p_82526_3_, int p_82526_4_)
    {
        BlockSourceImpl blocksourceimpl = new BlockSourceImpl(p_82526_1_, p_82526_2_, p_82526_3_, p_82526_4_);
        TileEntityDispenser tileentitydispenser = (TileEntityDispenser)blocksourceimpl.func_82619_j();

        if (tileentitydispenser != null)
        {
            int l = tileentitydispenser.func_70361_i();

            if (l < 0)
            {
                p_82526_1_.func_72926_e(1001, p_82526_2_, p_82526_3_, p_82526_4_, 0);
            }
            else
            {
                ItemStack itemstack = tileentitydispenser.func_70301_a(l);
                int i1 = p_82526_1_.func_72805_g(p_82526_2_, p_82526_3_, p_82526_4_) & 7;
                IInventory iinventory = TileEntityHopper.func_96117_b(p_82526_1_, (double)(p_82526_2_ + Facing.field_71586_b[i1]), (double)(p_82526_3_ + Facing.field_71587_c[i1]), (double)(p_82526_4_ + Facing.field_71585_d[i1]));
                ItemStack itemstack1;

                if (iinventory != null)
                {
                    itemstack1 = TileEntityHopper.func_94117_a(iinventory, itemstack.func_77946_l().func_77979_a(1), Facing.field_71588_a[i1]);

                    if (itemstack1 == null)
                    {
                        itemstack1 = itemstack.func_77946_l();

                        if (--itemstack1.field_77994_a == 0)
                        {
                            itemstack1 = null;
                        }
                    }
                    else
                    {
                        itemstack1 = itemstack.func_77946_l();
                    }
                }
                else
                {
                    itemstack1 = this.field_96474_cR.func_82482_a(blocksourceimpl, itemstack);

                    if (itemstack1 != null && itemstack1.field_77994_a == 0)
                    {
                        itemstack1 = null;
                    }
                }

                tileentitydispenser.func_70299_a(l, itemstack1);
            }
        }
    }
}
