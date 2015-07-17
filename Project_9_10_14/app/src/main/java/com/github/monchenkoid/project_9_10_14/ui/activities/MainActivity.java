package com.github.monchenkoid.project_9_10_14.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.github.monchenkoid.project_9_10_14.R;

/**
 * @author Iryna Monchenko
 * @version on 14.01.2015
 */

public class MainActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Crashlytics.start(this);
        setContentView(R.layout.activity_main);
    }

    public void onOkClick(View view) {
    }
}
