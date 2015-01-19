package com.github.monchenkoid.project_9_10_14.gson.serialize;

import com.github.monchenkoid.project_9_10_14.bo.models.TIM;
import com.github.monchenkoid.project_9_10_14.bo.models.TIMGroup;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by Irina Monchenko on 19.01.2015.
 */
public class TIMGroupSerializer implements JsonSerializer<TIMGroup>
{
    @Override
    public JsonElement serialize(TIMGroup src, Type typeOfSrc, JsonSerializationContext context)
    {
        JsonObject result = new JsonObject();
        for (TIM tim : src.getAdmins())
        {
            result.add(tim.getName0(), context.serialize(tim));
        }
        return result;
    }
}