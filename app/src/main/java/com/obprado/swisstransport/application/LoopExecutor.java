package com.obprado.swisstransport.application;

/**
 * Created by omar on 06/12/2014.
 */
public interface LoopExecutor {

    public void executePeriodically(Task task, int periodInSeconds);
}
