package com.github.monchenkoid.project_9_10_14;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import com.github.monchenkoid.project_9_10_14.backend.registration.Registration;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

