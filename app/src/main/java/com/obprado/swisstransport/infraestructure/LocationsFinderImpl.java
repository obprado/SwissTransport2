package com.obprado.swisstransport.infraestructure;

import com.obprado.swisstransport.application.LocationsFinder;
import com.obprado.swisstransport.application.LocationsReactor;
import com.obprado.swisstransport.infraestructure.async.AsyncLocationsFinder;
import com.obprado.swisstransport.infraestructure.rest.LocationsRestAdapter;

/**
 * Created by omar on 06/12/2014.
 */
public class LocationsFinderImpl implements LocationsFinder {

    @Override
    public void findLocations(String partialLocation, LocationsReactor processor) {
        AsyncLocationsFinder asyncLocationsFinder = new AsyncLocationsFinder(processor, partialLocation, new LocationsRestAdapter());
        asyncLocationsFinder.execute();
    }
}
