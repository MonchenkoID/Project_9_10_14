package com.github.monchenkoid.project_9_10_14.auth;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.auth.auth.GoogleOAuthHelper;


public class LoginActivity extends ActionBarActivity {


    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(GoogleOAuthHelper.AUTORIZATION_URL);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return GoogleOAuthHelper.proceedRedirectURL(LoginActivity.this, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });


    }


}
