package com.github.monchenkoid.project_9_10_14.gson.deserialize;

import com.github.monchenkoid.project_9_10_14.bo.models.TIM;
import com.github.monchenkoid.project_9_10_14.utils.Log;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Irina Monchenko on 19.01.2015.
 */
public class TimDeserializer implements JsonDeserializer<TIM>
{
    @Override
    public TIM deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
            JsonParseException
    {

        JsonObject jsonObject = json.getAsJsonObject();

        TIM tim = new TIM(jsonObject.get("name0").getAsString());
        Log.i(TimDeserializer.class.getSimpleName(), jsonObject.get("name0").getAsString());
            tim.setName1(jsonObject.get("name1").getAsString());
            tim.setName2(jsonObject.get("name2").getAsString());
            tim.setName3(jsonObject.get("name3").getAsString());
            tim.setName4(jsonObject.get("name4").getAsString());

            tim.setdUng1(jsonObject.get("dUng1").getAsString());
            tim.setdUng2(jsonObject.get("dUng2").getAsString());
            tim.setdUng3(jsonObject.get("dUng3").getAsString());
            tim.setdUng4(jsonObject.get("dUng4").getAsString());

            tim.setReign1(jsonObject.get("reign1").getAsString());
            tim.setReign2(jsonObject.get("reign2").getAsString());
            tim.setReign3(jsonObject.get("reign3").getAsString());
            tim.setReign4(jsonObject.get("reign4").getAsString());
            tim.setReign5(jsonObject.get("reign5").getAsString());
            tim.setReign6(jsonObject.get("reign6").getAsString());
            tim.setReign7(jsonObject.get("reign7").getAsString());
            tim.setReign8(jsonObject.get("reign8").getAsString());
            tim.setReign9(jsonObject.get("reign9").getAsString());
            tim.setReign10(jsonObject.get("reign10").getAsString());
            tim.setReign11(jsonObject.get("reign11").getAsString());

            tim.setModelA1("I - интуиция возможностей");
            tim.setModelA2("L - структурная логика");
            tim.setModelA3("F - силовая сенсорика");
            tim.setModelA4("R - этика отношений");
            tim.setModelA5("S - сенсорика ощущений");
            tim.setModelA6("E - этика эмоций");
            tim.setModelA7("T - интуиция времени");
            tim.setModelA8("P - деловая логика");



        return tim;
    }
}