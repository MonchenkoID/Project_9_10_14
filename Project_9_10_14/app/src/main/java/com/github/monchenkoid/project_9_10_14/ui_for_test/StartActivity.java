package com.github.monchenkoid.project_9_10_14.ui_for_test;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.github.monchenkoid.project_9_10_14.R;


public class StartActivity extends ActionBarActivity {

    private static final String TAG = StartActivity.class.getSimpleName();
    private ProgressDialog mAuthProgressDialog;
    private Firebase mFirebaseRef;
    private AuthData mAuthData;
    private static Button mPasswordLoginButton;
    private static EditText mUserEmail, mUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // new EndpointsAsyncTask().execute(new TIMBean());

        mPasswordLoginButton = (Button) findViewById(R.id.login_btn);
        mPasswordLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginWithPassword();
            }
        });

        mUserEmail = (EditText) findViewById(R.id.login);
        mUserPassword = (EditText) findViewById(R.id.password);
        /* Create the Firebase ref that is used for all authentication with Firebase */
        mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));
        /* Setup the progress dialog that is displayed later when authenticating with Firebase */
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle(getString(R.string.loading));
        mAuthProgressDialog.setMessage(getString(R.string.auth_firebase));
        mAuthProgressDialog.setCancelable(false);
        mAuthProgressDialog.show();

        /* Check if the user is authenticated with Firebase already. If this is the case we can set the authenticated
         * user and hide hide any login buttons */
        mFirebaseRef.addAuthStateListener(new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                mAuthProgressDialog.hide();
                setAuthenticatedUser(authData);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* If a user is currently authenticated, display a logout menu */
        if (this.mAuthData != null) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Unauthenticate from Firebase and from providers where necessary.
     */
    private void logout() {
        if (this.mAuthData != null) {
            /* logout of Firebase */
            mFirebaseRef.unauth();
            /* Update authenticated user and show login buttons */
            setAuthenticatedUser(null);
        }
    }

    /**
     * Once a user is logged in, take the mAuthData provided from Firebase and "use" it.
     */
    public void setAuthenticatedUser(AuthData authData) {
        if (authData != null) {
            /* Hide all the login buttons */
            mPasswordLoginButton.setVisibility(View.GONE);
            /* show a provider specific status text */
            String name = null;
            if (authData.getProvider().equals("password")) {
                name = authData.getUid();
            } else {
                Log.e(TAG, "Invalid provider: " + authData.getProvider());
            }
            if (name != null) {
                Log.i(TAG, "Logged in as " + name + " (" + authData.getProvider() + ")");
                startActivity(new Intent(this, MainActivity.class));
                mAuthProgressDialog.cancel();
                finish();
            }
        } else {
            /* No authenticated user show all the login buttons */
            mPasswordLoginButton.setVisibility(View.VISIBLE);
        }
        this.mAuthData = authData;
        /* invalidate options menu to hide/show the logout button */
        supportInvalidateOptionsMenu();
    }

    public class AuthFirebaseHandler implements Firebase.AuthResultHandler {

        private final String provider;

        public AuthFirebaseHandler(String provider) {
            this.provider = provider;
        }

        @Override
        public void onAuthenticated(AuthData authData) {
            mAuthProgressDialog.hide();
            Log.i(TAG, provider + " auth successful");
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
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void loginWithPassword() {
        mAuthProgressDialog.show();
        mFirebaseRef.authWithPassword(mUserEmail.getText().toString(), mUserPassword.getText().toString(), new AuthFirebaseHandler("password"));
    }

}