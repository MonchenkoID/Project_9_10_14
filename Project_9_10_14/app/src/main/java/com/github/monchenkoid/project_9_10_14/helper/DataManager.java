package com.github.monchenkoid.project_9_10_14.helper;

import android.os.Handler;

import com.github.monchenkoid.project_9_10_14.processing.Processor;
import com.github.monchenkoid.project_9_10_14.source.DataSource;

/**
 * Created by Irina Monchenko on 19.10.2014.
 */
public final class DataManager {

    private DataManager() {
    }

    public static <ProcessingResult, DataSourceResult, Params> void loadData(
            final Callback<ProcessingResult> callback,
            final Params params,
            final DataSource<DataSourceResult, Params> dataSource,
            final Processor<ProcessingResult, DataSourceResult> processor) {
        if (callback == null) {
            throw new IllegalArgumentException("callback can't be null");
        }
        final Handler handler = new Handler();
        callback.onDataLoadStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final DataSourceResult result = dataSource.getResult(params);
                    final ProcessingResult processingResult = processor.process(result);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onDone(processingResult);
                        }
                    });
                } catch (final Exception e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onError(e);
                        }
                    });
                }
            }
        }).start();
    }

    public interface Callback<Result> {

        void onDataLoadStart();

        void onDone(Result data);

        void onError(Exception e);
    }

}
