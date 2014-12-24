package com.github.monchenkoid.project_9_10_14.source;

import android.content.Context;

import com.firebase.client.Firebase;
import com.github.monchenkoid.project_9_10_14.CoreApplication;

/**
 * Created by Irina Monchenko on 24.12.2014.
 */
public class FirebaseHttpDataSource implements DataSource<Firebase, String> {

    public static final String KEY = "HttpDataSource";

    private Firebase mFirebase;

    public static FirebaseHttpDataSource get(Context context) {
        return CoreApplication.get(context, KEY);
    }

    @Override
    public Firebase getResult(String p) throws Exception {
        mFirebase = new Firebase(p);
        return mFirebase;
    }

}
