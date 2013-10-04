package net.minecraft.util;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

public class MessageComponentSerializer implements JsonDeserializer, JsonSerializer
{
    public ChatMessageComponent func_111056_a(JsonElement p_111056_1_, Type p_111056_2_, JsonDeserializationContext p_111056_3_)
    {
        ChatMessageComponent chatmessagecomponent = new ChatMessageComponent();
        JsonObject jsonobject = (JsonObject)p_111056_1_;
        JsonElement jsonelement1 = jsonobject.get("text");
        JsonElement jsonelement2 = jsonobject.get("translate");
        JsonElement jsonelement3 = jsonobject.get("color");
        JsonElement jsonelement4 = jsonobject.get("bold");
        JsonElement jsonelement5 = jsonobject.get("italic");
        JsonElement jsonelement6 = jsonobject.get("underlined");
        JsonElement jsonelement7 = jsonobject.get("obfuscated");

        if (jsonelement3 != null && jsonelement3.isJsonPrimitive())
        {
            EnumChatFormatting enumchatformatting = EnumChatFormatting.func_96300_b(jsonelement3.getAsString());

            if (enumchatformatting == null || !enumchatformatting.func_96302_c())
            {
                throw new JsonParseException("Given color (" + jsonelement3.getAsString() + ") is not a valid selection");
            }

            chatmessagecomponent.func_111059_a(enumchatformatting);
        }

        if (jsonelement4 != null && jsonelement4.isJsonPrimitive())
        {
            chatmessagecomponent.func_111071_a(Boolean.valueOf(jsonelement4.getAsBoolean()));
        }

        if (jsonelement5 != null && jsonelement5.isJsonPrimitive())
        {
            chatmessagecomponent.func_111063_b(Boolean.valueOf(jsonelement5.getAsBoolean()));
        }

        if (jsonelement6 != null && jsonelement6.isJsonPrimitive())
        {
            chatmessagecomponent.func_111081_c(Boolean.valueOf(jsonelement6.getAsBoolean()));
        }

        if (jsonelement7 != null && jsonelement7.isJsonPrimitive())
        {
            chatmessagecomponent.func_111061_d(Boolean.valueOf(jsonelement7.getAsBoolean()));
        }

        if (jsonelement1 != null)
        {
            if (jsonelement1.isJsonArray())
            {
                JsonArray jsonarray = jsonelement1.getAsJsonArray();
                Iterator iterator = jsonarray.iterator();

                while (iterator.hasNext())
                {
                    JsonElement jsonelement8 = (JsonElement)iterator.next();

                    if (jsonelement8.isJsonPrimitive())
                    {
                        chatmessagecomponent.func_111079_a(jsonelement8.getAsString());
                    }
                    else if (jsonelement8.isJsonObject())
                    {
                        chatmessagecomponent.func_111073_a(this.func_111056_a(jsonelement8, p_111056_2_, p_111056_3_));
                    }
                }
            }
            else if (jsonelement1.isJsonPrimitive())
            {
                chatmessagecomponent.func_111079_a(jsonelement1.getAsString());
            }
        }
        else if (jsonelement2 != null && jsonelement2.isJsonPrimitive())
        {
            JsonElement jsonelement9 = jsonobject.get("using");

            if (jsonelement9 != null)
            {
                if (jsonelement9.isJsonArray())
                {
                    ArrayList arraylist = Lists.newArrayList();
                    Iterator iterator1 = jsonelement9.getAsJsonArray().iterator();

                    while (iterator1.hasNext())
                    {
                        JsonElement jsonelement10 = (JsonElement)iterator1.next();

                        if (jsonelement10.isJsonPrimitive())
                        {
                            arraylist.add(jsonelement10.getAsString());
                        }
                        else if (jsonelement10.isJsonObject())
                        {
                            arraylist.add(this.func_111056_a(jsonelement10, p_111056_2_, p_111056_3_));
                        }
                    }

                    chatmessagecomponent.func_111080_a(jsonelement2.getAsString(), arraylist.toArray());
                }
                else if (jsonelement9.isJsonPrimitive())
                {
                    chatmessagecomponent.func_111080_a(jsonelement2.getAsString(), new Object[] {jsonelement9.getAsString()});
                }
            }
            else
            {
                chatmessagecomponent.func_111072_b(jsonelement2.getAsString());
            }
        }

        return chatmessagecomponent;
    }

    public JsonElement func_111055_a(ChatMessageComponent p_111055_1_, Type p_111055_2_, JsonSerializationContext p_111055_3_)
    {
        JsonObject jsonobject = new JsonObject();

        if (p_111055_1_.func_111065_a() != null)
        {
            jsonobject.addProperty("color", p_111055_1_.func_111065_a().func_96297_d());
        }

        if (p_111055_1_.func_111058_b() != null)
        {
            jsonobject.addProperty("bold", p_111055_1_.func_111058_b());
        }

        if (p_111055_1_.func_111064_c() != null)
        {
            jsonobject.addProperty("italic", p_111055_1_.func_111064_c());
        }

        if (p_111055_1_.func_111067_d() != null)
        {
            jsonobject.addProperty("underlined", p_111055_1_.func_111067_d());
        }

        if (p_111055_1_.func_111076_e() != null)
        {
            jsonobject.addProperty("obfuscated", p_111055_1_.func_111076_e());
        }

        if (p_111055_1_.func_111075_f() != null)
        {
            jsonobject.addProperty("text", p_111055_1_.func_111075_f());
        }
        else if (p_111055_1_.func_111074_g() != null)
        {
            jsonobject.addProperty("translate", p_111055_1_.func_111074_g());

            if (p_111055_1_.func_111069_h() != null && !p_111055_1_.func_111069_h().isEmpty())
            {
                jsonobject.add("using", this.func_111057_b(p_111055_1_, p_111055_2_, p_111055_3_));
            }
        }
        else if (p_111055_1_.func_111069_h() != null && !p_111055_1_.func_111069_h().isEmpty())
        {
            jsonobject.add("text", this.func_111057_b(p_111055_1_, p_111055_2_, p_111055_3_));
        }

        return jsonobject;
    }

    private JsonArray func_111057_b(ChatMessageComponent p_111057_1_, Type p_111057_2_, JsonSerializationContext p_111057_3_)
    {
        JsonArray jsonarray = new JsonArray();
        Iterator iterator = p_111057_1_.func_111069_h().iterator();

        while (iterator.hasNext())
        {
            ChatMessageComponent chatmessagecomponent1 = (ChatMessageComponent)iterator.next();

            if (chatmessagecomponent1.func_111075_f() != null)
            {
                jsonarray.add(new JsonPrimitive(chatmessagecomponent1.func_111075_f()));
            }
            else
            {
                jsonarray.add(this.func_111055_a(chatmessagecomponent1, p_111057_2_, p_111057_3_));
            }
        }

        return jsonarray;
    }

    public Object deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_)
    {
        return this.func_111056_a(p_deserialize_1_, p_deserialize_2_, p_deserialize_3_);
    }

    public JsonElement serialize(Object p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_)
    {
        return this.func_111055_a((ChatMessageComponent)p_serialize_1_, p_serialize_2_, p_serialize_3_);
    }
}
