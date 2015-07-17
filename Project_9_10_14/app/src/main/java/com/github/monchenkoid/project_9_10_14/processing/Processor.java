package com.github.monchenkoid.project_9_10_14.processing;

/**
 * @author Iryna Monchenko
 * @version on 14.01.2015
 */

public interface Processor<ProcessingResult, Source> {
    ProcessingResult process(Source source) throws Exception;
}
