package com.obprado.swisstransport.application;

/**
 * Created by omar on 06/12/2014.
 */
public interface LocationsFinder {

    public void findLocations(String partialLocation, LocationsReactor processor);
}
