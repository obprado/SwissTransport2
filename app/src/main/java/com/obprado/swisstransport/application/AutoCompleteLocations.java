package com.obprado.swisstransport.application;

import java.util.Collection;

/**
 * Created by omar on 06/12/2014.
 */
public class AutoCompleteLocations implements LocationsReactor{

    private Display<Collection<String>> locationsDisplay;
    private LocationsFinder finder;

    public AutoCompleteLocations(Display<Collection<String>> locationsDisplay, LocationsFinder finder) {
        this.locationsDisplay = locationsDisplay;
        this.finder = finder;
    }

    public void autocomplete(String partial){
        finder.findLocations(partial, this);
    }

    @Override
    public void onLocationsFound(Collection<String> locations) {
        locationsDisplay.display(locations);
    }
}
