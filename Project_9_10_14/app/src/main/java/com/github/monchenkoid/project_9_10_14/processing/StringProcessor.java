package com.github.monchenkoid.project_9_10_14.processing;

import com.github.monchenkoid.project_9_10_14.source.HttpDataSource;
import com.github.monchenkoid.project_9_10_14.source.RawDataSource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Irina Monchenko on 19.10.2014.
 */
public class StringProcessor implements Processor<String, InputStream> {
    @Override
    public String process(InputStream inputStream) throws Exception {
        InputStreamReader inputStreamReader = null;
        BufferedReader in = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            in = new BufferedReader(inputStreamReader);
            String str;
            StringBuilder builder = new StringBuilder();
            while ((str = in.readLine()) != null) {
                builder.append(str);
            }
            return builder.toString();
        } finally {
           /* HttpDataSource.close(in);
            HttpDataSource.close(inputStreamReader);
            HttpDataSource.close(inputStream);*/
            RawDataSource.close(in);
            RawDataSource.close(inputStreamReader);
            RawDataSource.close(inputStream);
        }



    }
}