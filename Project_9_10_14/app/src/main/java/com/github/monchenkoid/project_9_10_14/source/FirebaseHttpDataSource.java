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
        //download data and return

        mFirebase = new Firebase(p);
        // Read all the text returned by the server

        return mFirebase;
    }

}
