package com.github.monchenkoid.project_9_10_14.ui_for_test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.asynctasks.EndpointsAsyncTask;
import com.github.monchenkoid.project_9_10_14.backend.timBeanApi.model.TIMBean;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TIMBean timBean = new TIMBean();
        timBean.setId(1234567890777L);
        timBean.setName("Balzak");
        new EndpointsAsyncTask().execute(timBean);
        //TIMBean timBean = (TIMBean) getIntent().getSerializableExtra();
    }


}
