package com.github.monchenkoid.project_9_10_14.processing;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Iryna Monchenko
 * @version on 08.02.2015
 */
public abstract class WrapperArrayProcessor<T> implements Processor<List<T>, InputStream> {

    @Override
    public List<T> process(InputStream inputStream) throws Exception {
        String string = new StringProcessor().process(inputStream);
        JSONArray array = new JSONArray(string);
        List<T> noteArray = new ArrayList<>(array.length());
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            noteArray.add(createObject(jsonObject));
        }
        return noteArray;
    }

    protected abstract T createObject(JSONObject jsonObject);
}