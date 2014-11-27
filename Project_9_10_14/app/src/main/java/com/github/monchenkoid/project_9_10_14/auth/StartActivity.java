package com.github.monchenkoid.project_9_10_14.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import com.github.monchenkoid.project_9_10_14.R;


public class StartActivity extends ActionBarActivity {

    public static final int REQUEST_LOGIN = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

    }


    public void onGoogleClick(View view) {

        startActivityForResult(new Intent(this, LoginActivity.class), REQUEST_LOGIN);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_LOGIN && resultCode == RESULT_OK) {
            Log.i("StartActivity", "TOKEN : " + data.getStringExtra("token"));
            Log.i("StartActivity", "EXPIRES : " + data.getStringExtra("expires"));
            Log.i("StartActivity", "REFRESH : " + data.getStringExtra("refresh"));
            //TO DO Add accountmanager save token
            Intent intent = new Intent(this,UserPageActivity.class);
            intent.putExtra("token",data.getStringExtra("token"));
            startActivity(intent);


        } else {
            finish();
        }
    }


}
