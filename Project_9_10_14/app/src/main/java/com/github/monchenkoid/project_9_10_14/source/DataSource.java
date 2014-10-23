package com.github.monchenkoid.project_9_10_14.source;

/**
 * Created by Irina Monchenko on 19.10.2014.
 */
public interface DataSource<Result,Params>{

    Result getResult(Params params) throws Exception;

}