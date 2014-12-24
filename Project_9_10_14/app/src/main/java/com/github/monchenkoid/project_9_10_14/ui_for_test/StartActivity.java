package com.github.monchenkoid.project_9_10_14.ui_for_test;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.asynctasks.EndpointsAsyncTask;
import com.github.monchenkoid.project_9_10_14.backend.timBeanApi.model.TIMBean;


public class StartActivity extends ActionBarActivity {

    private static final String TAG = StartActivity.class.getSimpleName();
    private ProgressDialog mAuthProgressDialog;
    private Firebase mFirebase;
    private AuthData mAuthData;
    private static Button mPasswordLoginButton;
    private static EditText mUserEmail, mUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);




        mPasswordLoginButton = (Button) findViewById(R.id.login_btn);
        mPasswordLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginWithPassword();
            }
        });

        mUserEmail = (EditText) findViewById(R.id.login);
        mUserPassword = (EditText) findViewById(R.id.password);
        mFirebase = new Firebase(getResources().getString(R.string.firebase_url));
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle(getString(R.string.loading));
        mAuthProgressDialog.setMessage(getString(R.string.auth_firebase));
        mAuthProgressDialog.setCancelable(false);
        mAuthProgressDialog.show();

        /* Check if the user is authenticated with Firebase already. If this is the case we can set the authenticated
         * user and hide hide any login buttons */
        mFirebase.addAuthStateListener(new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                mAuthProgressDialog.hide();
                setAuthenticatedUser(authData);
            }
        });
    }

    public void setAuthenticatedUser(AuthData authData) {
        if (authData != null) {
            /* Hide all the login buttons */
            mPasswordLoginButton.setVisibility(View.GONE);
            /* show a provider specific status text */
            String name = null;
            if (authData.getProvider().equals(getString(R.string.tag_password))) {
                name = authData.getUid();
            } else {
                Log.e(TAG, getString(R.string.invalid_provider) + authData.getProvider());
            }
            if (name != null) {
                Log.i(TAG, getString(R.string.logged_in_as) + name + " (" + authData.getProvider() + ")");
                startActivity(new Intent(this, MainActivity.class));
                mAuthProgressDialog.cancel();
                finish();
            }
        } else {
            mPasswordLoginButton.setVisibility(View.VISIBLE);
        }
        this.mAuthData = authData;

    }

    public class AuthFirebaseHandler implements Firebase.AuthResultHandler {

        private final String provider;

        public AuthFirebaseHandler(String provider) {
            this.provider = provider;
        }

        @Override
        public void onAuthenticated(AuthData authData) {
            mAuthProgressDialog.hide();
            Log.i(TAG, provider + getString(R.string.auth_succefull));
            setAuthenticatedUser(authData);
        }

        @Override
        public void onAuthenticationError(FirebaseError firebaseError) {
            mAuthProgressDialog.hide();
            showErrorDialog(firebaseError.toString());
        }
    }

    public void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.error))
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void loginWithPassword() {
        mAuthProgressDialog.show();
        mFirebase.authWithPassword(mUserEmail.getText().toString(), mUserPassword.getText().toString(), new AuthFirebaseHandler(getString(R.string.tag_password)));
    }

}