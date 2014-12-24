package com.github.monchenkoid.project_9_10_14.callbacks;

import android.util.Log;

/**
 * Created by Irina Monchenko on 24.12.2014.
 */

public abstract class AuthFirebaseCallback<Result> {

    @Override
    public void onDataLoadStart() {
        Log.d("SimpleCallback", "onDataLoadStart");
    }

    @Override
    public void onError(Exception e) {
        Log.e("SimpleCallback", "onError", e);
    }

}