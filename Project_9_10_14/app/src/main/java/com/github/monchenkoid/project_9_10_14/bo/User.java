package com.github.monchenkoid.project_9_10_14.bo;

import org.json.JSONObject;

/**
 * Created by Irina Monchenko on 23.10.2014.
 */
public class User extends JSONObjectWrapper {

    private static final String NAME = "name";
    private static final String ID = "id";

    public User(String jsonObject) {
        super(jsonObject);
    }

    public User(JSONObject jsonObject) {
        super(jsonObject);
    }

    public String getName() {
        return getString(NAME);
    }

    public Long getId() {
        return getLong(ID);
    }

}
