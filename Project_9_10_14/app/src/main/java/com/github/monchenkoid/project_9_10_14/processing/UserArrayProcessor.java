package com.github.monchenkoid.project_9_10_14.processing;

import com.github.monchenkoid.project_9_10_14.bo.User;

import org.json.JSONObject;

/**
 * Created by Irina Monchenko on 23.10.2014.
 */
public class UserArrayProcessor extends WrapperArrayProcessor<User> {

    @Override
    protected User createObject(JSONObject jsonObject) {
        return new User(jsonObject);
    }

}