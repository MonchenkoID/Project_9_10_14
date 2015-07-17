package com.github.monchenkoid.project_9_10_14.source;

/**
 * @author Iryna Monchenko
 * @version on 24.12.2014
 */

public interface DataSource<Result, Params> {
    Result getResult(Params params) throws Exception;
}
