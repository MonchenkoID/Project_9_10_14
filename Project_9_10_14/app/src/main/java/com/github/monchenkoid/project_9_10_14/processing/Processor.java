package com.github.monchenkoid.project_9_10_14.processing;

/**
 * Created by Irina Monchenko on 14.01.2015.
 */
public interface Processor<ProcessingResult, Source>
{

	ProcessingResult process(Source source) throws Exception;

}
