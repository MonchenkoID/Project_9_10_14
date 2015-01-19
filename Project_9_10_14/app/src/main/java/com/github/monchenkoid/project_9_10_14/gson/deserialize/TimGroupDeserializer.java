package com.github.monchenkoid.project_9_10_14.gson.deserialize;

import com.github.monchenkoid.project_9_10_14.bo.models.TIM;
import com.github.monchenkoid.project_9_10_14.bo.models.TIMGroup;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Irina Monchenko on 19.01.2015.
 */
public class TimGroupDeserializer implements JsonDeserializer<TIMGroup> {
    @Override
    public TIMGroup deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
            JsonParseException {
        TIMGroup result = new TIMGroup();
        JsonObject jsonObject = json.getAsJsonObject();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            TIM tim = context.deserialize(entry.getValue(), TIM.class);
            tim.setName0(entry.getKey());
            result.addTIM(tim);
        }

        return result;
    }
}