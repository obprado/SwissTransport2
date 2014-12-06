package com.obprado.swisstransport.application;

/**
 * Created by omar on 06/12/2014.
 */
public class FindConnectionsInLoop {

    private LoopExecutor loopExecutor;
    private FindConnections findConnections;

    public FindConnectionsInLoop(LoopExecutor loopExecutor, FindConnections findConnections) {
        this.loopExecutor = loopExecutor;
        this.findConnections = findConnections;
    }

    public void find(String origin){
        loopExecutor.executePeriodically(findConnections, 60);
    }
}
