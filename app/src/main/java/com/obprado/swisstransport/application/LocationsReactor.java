package com.obprado.swisstransport.application;

import java.util.Collection;

/**
 * Created by omar on 06/12/2014.
 */
public interface LocationsReactor {

    public void onLocationsFound(Collection<String> locations);
}
