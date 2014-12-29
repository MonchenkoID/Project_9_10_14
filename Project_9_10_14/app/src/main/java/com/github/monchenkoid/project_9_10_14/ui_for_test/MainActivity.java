package com.github.monchenkoid.project_9_10_14.ui_for_test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.asynctasks.EndpointsAsyncTask;
import com.github.monchenkoid.project_9_10_14.backend.timBeanApi.model.TIMBean;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TIMBean timBean = new TIMBean();
        timBean.setId(1234567890777L);
        timBean.setName("Balzak");
        Log.d(String.valueOf("test"), "begin asynctask");
        ArrayList<TIMBean> tim;

        try {
            tim = new EndpointsAsyncTask().execute(timBean).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //TIMBean timBean = (TIMBean) getIntent().getSerializableExtra();
        Log.d(String.valueOf("test"), "end asynctask");
    }


}
