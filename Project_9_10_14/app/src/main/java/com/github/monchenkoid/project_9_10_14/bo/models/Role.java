package com.github.monchenkoid.project_9_10_14.bo.models;

import android.util.Log;

/**
 * Created by Irina Monchenko on 17.01.2015.
 */
public class Role<T> {

    private static final String TAG = "ROLE";
    private T role;

    public Role(T mRole) {
        this.role = mRole;
    }

    public T getRole() {
        return role;
    }

    public void showType() {
        Log.i(TAG, "Тип T: " + role.getClass().getName());
    }
}
