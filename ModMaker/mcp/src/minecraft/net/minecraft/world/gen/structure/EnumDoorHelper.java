package net.minecraft.world.gen.structure;

class EnumDoorHelper
{
    static final int[] field_75245_a = new int[EnumDoor.values().length];

    static
    {
        try
        {
            field_75245_a[EnumDoor.OPENING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            ;
        }

        try
        {
            field_75245_a[EnumDoor.WOOD_DOOR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1)
        {
            ;
        }

        try
        {
            field_75245_a[EnumDoor.GRATES.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2)
        {
            ;
        }

        try
        {
            field_75245_a[EnumDoor.IRON_DOOR.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3)
        {
            ;
        }
    }
}
