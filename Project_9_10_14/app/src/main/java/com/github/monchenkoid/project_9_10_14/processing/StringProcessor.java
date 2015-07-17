package com.github.monchenkoid.project_9_10_14.processing;

import com.github.monchenkoid.project_9_10_14.source.HttpDataSource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Iryna Monchenko
 * @version on 19.10.2014
 */

public class StringProcessor implements Processor<String, InputStream> {

    @Override
    public String process(InputStream inputStream) throws Exception {
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String string;
            StringBuilder builder = new StringBuilder();
            while ((string = bufferedReader.readLine()) != null) {
                builder.append(string);
            }
            return builder.toString();
        } finally {
            HttpDataSource.close(bufferedReader);
            HttpDataSource.close(inputStreamReader);
            HttpDataSource.close(inputStream);
        }
    }
}
