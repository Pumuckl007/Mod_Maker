package net.minecraft.client.resources.data;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.lang.reflect.Type;
import java.util.ArrayList;

@SideOnly(Side.CLIENT)
public class AnimationMetadataSectionSerializer extends BaseMetadataSectionSerializer implements JsonSerializer
{
    public AnimationMetadataSection func_110493_a(JsonElement p_110493_1_, Type p_110493_2_, JsonDeserializationContext p_110493_3_)
    {
        ArrayList arraylist = Lists.newArrayList();
        JsonObject jsonobject = (JsonObject)p_110493_1_;
        int i = this.func_110485_a(jsonobject.get("frametime"), "frametime", Integer.valueOf(1), 1, Integer.MAX_VALUE);
        int j;

        if (jsonobject.has("frames"))
        {
            try
            {
                JsonArray jsonarray = jsonobject.getAsJsonArray("frames");

                for (j = 0; j < jsonarray.size(); ++j)
                {
                    JsonElement jsonelement1 = jsonarray.get(j);
                    AnimationFrame animationframe = this.func_110492_a(j, jsonelement1);

                    if (animationframe != null)
                    {
                        arraylist.add(animationframe);
                    }
                }
            }
            catch (ClassCastException classcastexception)
            {
                throw new JsonParseException("Invalid animation->frames: expected array, was " + jsonobject.get("frames"), classcastexception);
            }
        }

        int k = this.func_110485_a(jsonobject.get("width"), "width", Integer.valueOf(-1), 1, Integer.MAX_VALUE);
        j = this.func_110485_a(jsonobject.get("height"), "height", Integer.valueOf(-1), 1, Integer.MAX_VALUE);
        return new AnimationMetadataSection(arraylist, k, j, i);
    }

    private AnimationFrame func_110492_a(int p_110492_1_, JsonElement p_110492_2_)
    {
        if (p_110492_2_.isJsonPrimitive())
        {
            try
            {
                return new AnimationFrame(p_110492_2_.getAsInt());
            }
            catch (NumberFormatException numberformatexception)
            {
                throw new JsonParseException("Invalid animation->frames->" + p_110492_1_ + ": expected number, was " + p_110492_2_, numberformatexception);
            }
        }
        else if (p_110492_2_.isJsonObject())
        {
            JsonObject jsonobject = p_110492_2_.getAsJsonObject();
            int j = this.func_110485_a(jsonobject.get("time"), "frames->" + p_110492_1_ + "->time", Integer.valueOf(-1), 1, Integer.MAX_VALUE);
            int k = this.func_110485_a(jsonobject.get("index"), "frames->" + p_110492_1_ + "->index", (Integer)null, 0, Integer.MAX_VALUE);
            return new AnimationFrame(k, j);
        }
        else
        {
            return null;
        }
    }

    public JsonElement func_110491_a(AnimationMetadataSection p_110491_1_, Type p_110491_2_, JsonSerializationContext p_110491_3_)
    {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("frametime", Integer.valueOf(p_110491_1_.func_110469_d()));

        if (p_110491_1_.func_110474_b() != -1)
        {
            jsonobject.addProperty("width", Integer.valueOf(p_110491_1_.func_110474_b()));
        }

        if (p_110491_1_.func_110471_a() != -1)
        {
            jsonobject.addProperty("height", Integer.valueOf(p_110491_1_.func_110471_a()));
        }

        if (p_110491_1_.func_110473_c() > 0)
        {
            JsonArray jsonarray = new JsonArray();

            for (int i = 0; i < p_110491_1_.func_110473_c(); ++i)
            {
                if (p_110491_1_.func_110470_b(i))
                {
                    JsonObject jsonobject1 = new JsonObject();
                    jsonobject1.addProperty("index", Integer.valueOf(p_110491_1_.func_110468_c(i)));
                    jsonobject1.addProperty("time", Integer.valueOf(p_110491_1_.func_110472_a(i)));
                    jsonarray.add(jsonobject1);
                }
                else
                {
                    jsonarray.add(new JsonPrimitive(Integer.valueOf(p_110491_1_.func_110468_c(i))));
                }
            }

            jsonobject.add("frames", jsonarray);
        }

        return jsonobject;
    }

    public String func_110483_a()
    {
        return "animation";
    }

    public Object deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_)
    {
        return this.func_110493_a(p_deserialize_1_, p_deserialize_2_, p_deserialize_3_);
    }

    public JsonElement serialize(Object p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_)
    {
        return this.func_110491_a((AnimationMetadataSection)p_serialize_1_, p_serialize_2_, p_serialize_3_);
    }
}
