package com.github.monchenkoid.project_9_10_14.source;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

import com.github.monchenkoid.project_9_10_14.CoreApplication;
import com.github.monchenkoid.project_9_10_14.MainActivity;
import com.github.monchenkoid.project_9_10_14.R;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import com.github.monchenkoid.project_9_10_14.MainActivity;

import static java.lang.Integer.valueOf;

/**
 * Created by Irina Monchenko on 23.10.2014.
 */
public class RawDataSource implements DataSource<InputStream, Integer>  {

    public static final String KEY = "RawDataSource";
    public static InputStream inputStream;

    public static RawDataSource get(Context context) {
        inputStream = context.getResources().openRawResource(R.raw.test);
        return CoreApplication.get(context, KEY);
    }


    @Override
    public InputStream getResult(Integer s) throws Exception {


        return inputStream;
    }

    public static void close(Closeable in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
