package com.github.monchenkoid.project_9_10_14.processing;


import com.github.monchenkoid.project_9_10_14.bo.models.TIM;
import com.github.monchenkoid.project_9_10_14.bo.models.TIMGroup;
import com.github.monchenkoid.project_9_10_14.garbage.TIMObject;
import com.github.monchenkoid.project_9_10_14.gson.deserialize.TimDeserializer;
import com.github.monchenkoid.project_9_10_14.gson.deserialize.TimGroupDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irina Monchenko on 23.10.2014.
 */
public class TIMArrayProcessor implements Processor<List<TIM>, InputStream> {

    @Override
    public List<TIM> process(InputStream inputStream) throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(TIMGroup.class, new TimGroupDeserializer())
                .registerTypeAdapter(TIM.class, new TimDeserializer())
                .create();
        String string = new StringProcessor().process(inputStream);
        //JsonObject jsonObject = string.getAsJsonObject();
        //JSONArray array = new JSONArray(gson.fromJson(string, TIM.class));


      List<TIM> timArray = null;
        TIMGroup tim = gson.fromJson(string, TIMGroup.class);

      timArray =  tim.getAdmins();

        return timArray;
    }

}