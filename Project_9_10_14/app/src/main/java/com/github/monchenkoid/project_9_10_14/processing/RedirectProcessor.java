package com.github.monchenkoid.project_9_10_14.processing;

/**
 * Created by Irina Monchenko on 19.10.2014.
 */
public class RedirectProcessor<DataSourceResult> implements Processor<DataSourceResult, DataSourceResult> {
    @Override
    public DataSourceResult process(DataSourceResult dataSourceResult) throws Exception {
        return dataSourceResult;
    }
}