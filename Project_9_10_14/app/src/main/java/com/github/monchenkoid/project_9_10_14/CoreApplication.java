package com.github.monchenkoid.project_9_10_14;

import android.app.Application;
import android.content.Context;

/**
 * Created by Irina Monchenko on 19.10.2014.
 */
public class  CoreApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public Object getSystemService(String name) {
        return super.getSystemService(name);
    }

    public static <T> T get(Context context, String key) {
        if (context == null || key == null){
            throw new IllegalArgumentException("Context and key must not be null");
        }
        T systemService = (T) context.getSystemService(key);
        if (systemService == null) {
            context = context.getApplicationContext();
            systemService = (T) context.getSystemService(key);
        }
        if (systemService == null) {
            throw new IllegalStateException(key + " not available");
        }
        return systemService;
    }
}