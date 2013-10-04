package net.minecraft.item;

public enum EnumArmorMaterial
{
    CLOTH(5, new int[]{1, 3, 2, 1}, 15),
    CHAIN(15, new int[]{2, 5, 4, 1}, 12),
    IRON(15, new int[]{2, 6, 5, 2}, 9),
    GOLD(7, new int[]{2, 5, 3, 1}, 25),
    DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
    private int field_78048_f;
    private int[] field_78049_g;
    private int field_78055_h;

    private EnumArmorMaterial(int p_i1827_3_, int[] p_i1827_4_, int p_i1827_5_)
    {
        this.field_78048_f = p_i1827_3_;
        this.field_78049_g = p_i1827_4_;
        this.field_78055_h = p_i1827_5_;
    }

    public int func_78046_a(int p_78046_1_)
    {
        return ItemArmor.func_77877_c()[p_78046_1_] * this.field_78048_f;
    }

    public int func_78044_b(int p_78044_1_)
    {
        return this.field_78049_g[p_78044_1_];
    }

    public int func_78045_a()
    {
        return this.field_78055_h;
    }

    public int func_82845_b()
    {
        return this == CLOTH ? Item.field_77770_aF.field_77779_bT : (this == CHAIN ? Item.field_77703_o.field_77779_bT : (this == GOLD ? Item.field_77717_p.field_77779_bT : (this == IRON ? Item.field_77703_o.field_77779_bT : (this == DIAMOND ? Item.field_77702_n.field_77779_bT : 0))));
    }
}
