package com.github.monchenkoid.project_9_10_14.gson.serialize;

import com.github.monchenkoid.project_9_10_14.bo.models.Relationship;
import com.github.monchenkoid.project_9_10_14.bo.models.TIM;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by Irina Monchenko on 18.01.2015.
 */
public class TimSerializer implements JsonSerializer<TIM> {

    @Override
    public JsonElement serialize(TIM src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject result = new JsonObject();
        result.addProperty("name0", src.getName0());
        result.addProperty("name1", src.getName1());
        result.addProperty("name2", src.getName2());
        result.addProperty("name3", src.getName3());
        result.addProperty("name4", src.getName4());

        result.addProperty("dUng1", src.getdUng1());
        result.addProperty("dUng2", src.getdUng2());
        result.addProperty("dUng3", src.getdUng3());
        result.addProperty("dUng4", src.getdUng4());

        result.addProperty("reign1", src.getReign1());
        result.addProperty("reign2", src.getReign2());
        result.addProperty("reign3", src.getReign3());
        result.addProperty("reign4", src.getReign4());
        result.addProperty("reign5", src.getReign5());
        result.addProperty("reign6", src.getReign6());
        result.addProperty("reign7", src.getReign7());
        result.addProperty("reign8", src.getReign8());
        result.addProperty("reign9", src.getReign9());
        result.addProperty("reign10", src.getReign10());
        result.addProperty("reign11", src.getReign11());

        result.addProperty("modelA1", src.getModelA1());
        result.addProperty("modelA2", src.getModelA2());
        result.addProperty("modelA3", src.getModelA3());
        result.addProperty("modelA4", src.getModelA4());
        result.addProperty("modelA5", src.getModelA5());
        result.addProperty("modelA6", src.getModelA6());
        result.addProperty("modelA7", src.getModelA7());
        result.addProperty("modelA8", src.getModelA8());

        JsonObject mRelationships = new JsonObject();
        result.add("Relationship", mRelationships);

        if (src.getRelationships() != null) {
            for (Relationship relationship : src.getRelationships()) {
                mRelationships.add(relationship.getmNameRelationship(), context.serialize(relationship));
            }

        }
        return result;

    }
}
