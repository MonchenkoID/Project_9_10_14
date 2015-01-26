package com.github.monchenkoid.project_9_10_14.processing;

import com.github.monchenkoid.project_9_10_14.bo.models.TypeInfMet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by shiza on 24.01.2015.
 */
public class GsonSerializerProcessor  implements Processor<String,Object> {

    @Override
    public String process(Object object) throws Exception {

        Gson gson = new Gson();
        Type type = new TypeToken<Object>() {}.getType();
        String json = gson.toJson(object, type);

        return json;
    }
}
