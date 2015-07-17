package com.github.monchenkoid.project_9_10_14.bo.models;

import android.util.Log;

/**
 * @author Iryna Monchenko
 * @version on 17.01.2015
 */

public class Role<T> {

    private static final String TAG = "ROLE";
    private final T mRole;

    public Role(T role) {
        this.mRole = role;
    }

    public T getRole() {
        return mRole;
    }

    public void showType() {
        Log.i(TAG, "Тип T: " + mRole.getClass().getName());
    }
}
