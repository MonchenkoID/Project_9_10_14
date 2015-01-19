package com.github.monchenkoid.project_9_10_14.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.garbage.TIMGsonModel;

/**
 * Created by Irina Monchenko on 23.10.2014.
 */
public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TIMGsonModel timGsonModel = (TIMGsonModel) getIntent().getSerializableExtra("item");
        ((TextView) findViewById(R.id.name)).setText(timGsonModel.getName());
        ((TextView) findViewById(R.id.mbti)).setText(timGsonModel.getMbti());
    }

}