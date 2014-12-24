package com.github.monchenkoid.project_9_10_14;

import android.os.AsyncTask;
import android.util.Log;

import com.github.monchenkoid.project_9_10_14.backend.myApi.MyApi;
import com.github.monchenkoid.project_9_10_14.backend.myApi.model.TIMBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Irina Monchenko on 21.12.2014.
 */
public class EndpointsAsyncTask extends AsyncTask<TIMBean, Void, Void> {
    private static MyApi myApiService = null;
    private Long id;

    @Override
    protected Void doInBackground(TIMBean... bean) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
            // end options for devappserver

            myApiService = builder.build();
        }

      TIMBean beann = new TIMBean();
        beann.setId(12553L);
        beann.setName("win!!????");

        try {
             myApiService.storeMy(beann).execute();
        } catch (IOException e) {
            Log.d("bla",e.getMessage());
        }
        return null;
    }

}