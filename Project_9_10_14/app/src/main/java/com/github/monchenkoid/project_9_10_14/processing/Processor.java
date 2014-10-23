package com.github.monchenkoid.project_9_10_14.processing;

/**
 * Created by Irina Monchenko on 19.10.2014.
 */
public interface Processor<ProcessingResult, Source> {

    ProcessingResult process(Source source) throws Exception;

}
