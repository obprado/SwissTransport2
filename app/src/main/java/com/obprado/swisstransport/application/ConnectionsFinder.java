package com.obprado.swisstransport.application;

/**
 * Created by omar on 06/12/2014.
 */
public interface ConnectionsFinder {

    public void tripsFrom(String origin, ConnectionsReactor processor);
}
