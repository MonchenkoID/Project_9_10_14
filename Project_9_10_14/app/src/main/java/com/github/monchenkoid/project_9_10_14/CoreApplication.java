package com.github.monchenkoid.project_9_10_14;

import android.app.Application;
import android.content.Context;

import com.firebase.client.Firebase;
import com.github.monchenkoid.project_9_10_14.source.FirebaseHttpDataSource;

/**
 * Created by Irina Monchenko on 19.10.2014.
 */
public class CoreApplication extends Application {

    private FirebaseHttpDataSource mFirebaseHttpDataSource;

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

    @Override
    public Object getSystemService(String name) {

        if (FirebaseHttpDataSource.KEY.equals(name)) {
            return getFirebaseHttpDataSource();
        } else {
            return super.getSystemService(name);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Context context, String key) {
        if (context == null || key == null) {
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


    private Object getFirebaseHttpDataSource() {
        if (mFirebaseHttpDataSource == null) {
            synchronized (FirebaseHttpDataSource.class) {
                if (mFirebaseHttpDataSource == null) {
                    mFirebaseHttpDataSource = new FirebaseHttpDataSource();
                }
            }
        }
        return mFirebaseHttpDataSource;
    }
}