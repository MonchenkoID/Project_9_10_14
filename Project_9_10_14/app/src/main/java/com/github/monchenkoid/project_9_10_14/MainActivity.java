package com.github.monchenkoid.project_9_10_14;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Irina Monchenko on 19.10.2014.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogIn(View view) {
    }

    public void onRegistration(View view) {
        Toast toast = Toast.makeText(this.getApplicationContext(), "Представим что тут регистрация через гмыло", Toast.LENGTH_LONG);
        toast.show();
    }
}