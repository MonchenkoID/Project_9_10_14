package com.github.monchenkoid.project_9_10_14.garbage;

import android.os.AsyncTask;
import android.util.Log;

import com.github.monchenkoid.project_9_10_14.backend.timBeanApi.TimBeanApi;
import com.github.monchenkoid.project_9_10_14.backend.timBeanApi.model.TIMBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irina Monchenko on 21.12.2014.
 */
public class EndpointsAsyncTask extends AsyncTask<TIMBean, Void, ArrayList<TIMBean>> {
    private static TimBeanApi timBeanApiService = null;
    private Long id;

    @Override
    protected ArrayList<TIMBean> doInBackground(TIMBean... bean) {
        Log.d(String.valueOf("test"), "asynctask");
        if (timBeanApiService == null) {  // Only do this once
            TimBeanApi.Builder builder = new TimBeanApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
            // end options for devappserver
            timBeanApiService = builder.build();
            Log.d(String.valueOf("test"), "build service");
        }
        /*TODO write normal universal AsyncTask */
        try {
            Log.d(String.valueOf("test"), "try");
            // timBeanApiService.insertTIMBean(bean[0]).execute();
            // Log.d(String.valueOf("test"), bean[0].toString());
            List<TIMBean> remoteTims = timBeanApiService.getTIMBeans().execute().getItems();
            ArrayList<TIMBean> taskList = new ArrayList<TIMBean>();
            if (remoteTims != null) {

                for (TIMBean taskBean : remoteTims) {
                    TIMBean timm = new TIMBean();
                    timm.setId(taskBean.getId());

                    timm.setName(taskBean.getName());
                    Log.d(String.valueOf("test"), "id " + taskBean.getId() + " name " + taskBean.getName());
                    taskList.add(timm);
                }


                //  Log.d(String.valueOf("test"), "WIN");
            }
            return taskList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}