package com.github.monchenkoid.project_9_10_14.bo.models;

import android.util.Log;

/**
 * Created by Irina Monchenko on 17.01.2015.
 */
public class Role<T> {

    private T role;
    private String TAG = "ROLE";

    Role(T mRole) {
        role = mRole;
    }

    T getRole() {
        return role;
    }

    void showType() {
        Log.i(TAG, "Тип T: " + role.getClass().getName());
    }
}
