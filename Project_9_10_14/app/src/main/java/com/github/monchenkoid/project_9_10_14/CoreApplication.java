package com.github.monchenkoid.project_9_10_14;

import android.app.Application;
import android.content.Context;

import com.github.monchenkoid.project_9_10_14.source.HttpDataSource;
import com.github.monchenkoid.project_9_10_14.source.RawDataSource;

/**
 * Created by Irina Monchenko on 19.10.2014.
 */
public class  CoreApplication extends Application {

    private HttpDataSource mHttpDataSource;
    private RawDataSource mRawDataSource;

    @Override
    public void onCreate() {
        super.onCreate();
        mHttpDataSource = new HttpDataSource();
        mRawDataSource = new RawDataSource();
    }

    @Override
    public Object getSystemService(String name) {
        if (HttpDataSource.KEY.equals(name)) {
            //for android kitkat +
            if (mHttpDataSource == null) {
                mHttpDataSource = new HttpDataSource();
            }
            return mHttpDataSource;
        }
        if (RawDataSource.KEY.equals(name)){
            if (mRawDataSource == null) {
                mRawDataSource = new RawDataSource();
            }
            return mRawDataSource;
        }
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