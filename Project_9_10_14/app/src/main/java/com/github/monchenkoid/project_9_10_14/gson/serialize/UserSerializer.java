package com.github.monchenkoid.project_9_10_14.gson.serialize;

import com.github.monchenkoid.project_9_10_14.bo.models.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by Irina Monchenko on 18.01.2015.
 */
public class UserSerializer implements JsonSerializer<User> {

    @Override
    public JsonElement serialize(User src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject result = new JsonObject();

        result.addProperty("user_id", src.getId());
        result.addProperty("user_name", src.getName());
        result.addProperty("user_lastname", src.getLastName());
        result.addProperty("user_state", src.getState());
        result.addProperty("user_country_natale", src.getCountryNatale());
        result.addProperty("user_city_natale", src.getCityNatale());
        result.addProperty("user_gender", src.getGender());
        result.addProperty("user_date_birthday", src.getUserDateBirthday().toString());
        result.add("Role", context.serialize(src.getRole()));
        result.add("TIM", context.serialize(src.getTimObject()));

        return result;
    }
}


