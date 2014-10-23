package com.github.monchenkoid.project_9_10_14.callbacks;

import android.util.Log;

import com.github.monchenkoid.project_9_10_14.helper.DataManager;

/**
 * Created by Irina Monchenko on 19.10.2014.
 */
public  abstract class SimpleCallback<Result> implements DataManager.Callback {

    @Override
    public void onDataLoadStart() {
        Log.d("SimpleCallback", "onDataLoadStart");
    }

    @Override
    public void onError(Exception e) {
        Log.e("SimpleCallback", "onError", e);
    }

}
