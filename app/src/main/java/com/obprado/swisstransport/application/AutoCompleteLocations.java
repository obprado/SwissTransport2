package com.obprado.swisstransport.application;

import java.util.Collection;

/**
 * Created by omar on 06/12/2014.
 */
public class AutoCompleteLocations implements LocationsReactor{

    private LocationsDisplay locationsDisplay;
    private LocationsFinder finder;

    public AutoCompleteLocations(LocationsDisplay locationsDisplay, LocationsFinder finder) {
        this.locationsDisplay = locationsDisplay;
        this.finder = finder;
    }

    public void autocomplete(String partial){
        finder.findLocations(partial, this);
    }

    @Override
    public void onLocationsFound(Collection<String> locations) {
        locationsDisplay.updateLocations(locations);
    }
}
