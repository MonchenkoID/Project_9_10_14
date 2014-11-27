package com.github.monchenkoid.project_9_10_14.auth;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.github.monchenkoid.project_9_10_14.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;


public class UserPageActivity extends ActionBarActivity {


    static String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
        token = getIntent().getStringExtra("token");
        new executeHttpGet().execute();

    }


    private class executeHttpGet extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            findViewById(android.R.id.progress).setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(String... args) {
            BufferedReader in = null;
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI("https://www.googleapis.com/oauth2/v2/userinfo?fields=id%2Cname&access_token=" + token));
                HttpResponse response = client.execute(request);
                in = new BufferedReader
                        (new InputStreamReader(response.getEntity().getContent()));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
                in.close();
                String page = sb.toString();
                return page;

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            String empty = "Данных не существует";
            return empty;
        }

        @Override
        protected void onPostExecute(String page) {
            String name = "";
            int id;
                    findViewById(android.R.id.progress).setVisibility(View.GONE);
            TextView tView = (TextView) findViewById(R.id.token);
            tView.setText(page);
            try {
                JSONObject dataJsonObj = new JSONObject(page);
                name=dataJsonObj.getString("name");
                id = dataJsonObj.getInt("id");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            tView.setText(name);
        }
    }


}
