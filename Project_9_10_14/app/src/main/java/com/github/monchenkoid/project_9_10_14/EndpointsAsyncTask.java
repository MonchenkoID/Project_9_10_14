package com.github.monchenkoid.project_9_10_14;

import android.os.AsyncTask;
import android.util.Log;

import com.github.monchenkoid.project_9_10_14.backend.myApi.MyApi;
import com.github.monchenkoid.project_9_10_14.backend.myApi.model.MyBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Irina Monchenko on 21.12.2014.
 */
public class EndpointsAsyncTask extends AsyncTask<MyBean, Void, Void> {
    private static MyApi myApiService = null;
    private Long id;

    @Override
    protected Void doInBackground(MyBean... bean) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
            // end options for devappserver

            myApiService = builder.build();
        }

      MyBean beann = new MyBean();
        beann.setId(123L);
        beann.setData("win!!");

        try {
             myApiService.storeMy(beann).execute();
        } catch (IOException e) {
            Log.d("bla",e.getMessage());
        }
        return null;
    }

}