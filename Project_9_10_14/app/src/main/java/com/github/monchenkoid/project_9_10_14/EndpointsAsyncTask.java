package com.github.monchenkoid.project_9_10_14;

import android.os.AsyncTask;
import android.util.Log;

import com.github.monchenkoid.project_9_10_14.backend.timBeanApi.TimBeanApi;
import com.github.monchenkoid.project_9_10_14.backend.timBeanApi.model.TIMBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Irina Monchenko on 21.12.2014.
 */
public class EndpointsAsyncTask extends AsyncTask<TIMBean, Void, Void> {
    private static TimBeanApi timBeanApiService = null;
    private Long id;

    @Override
    protected Void doInBackground(TIMBean... bean) {
        if (timBeanApiService == null) {  // Only do this once
            TimBeanApi.Builder builder = new TimBeanApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
            // end options for devappserver
            timBeanApiService = builder.build();
        }
        /*TODO write normal universal AsyncTask */
        try {
            timBeanApiService.insertTIMBean(bean[0]).execute();
        } catch (IOException e) {
            Log.d("must die", e.getMessage());
        }
        return null;
    }

}