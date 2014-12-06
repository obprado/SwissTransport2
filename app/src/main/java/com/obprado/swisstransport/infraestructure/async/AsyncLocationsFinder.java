package com.obprado.swisstransport.infraestructure.async;

import android.os.AsyncTask;

import com.obprado.swisstransport.application.LocationsReactor;
import com.obprado.swisstransport.infraestructure.rest.LocationsRestAdapter;

import java.util.Collection;

/**
 * Created by omar on 06/12/2014.
 */
public class AsyncLocationsFinder extends AsyncTask<Void, Void, Collection<String>> {

    private LocationsReactor reactor;
    private String partialLocation;
    private LocationsRestAdapter restClient;

    public AsyncLocationsFinder(LocationsReactor reactor, String partialLocation, LocationsRestAdapter restClient) {
        this.reactor = reactor;
        this.partialLocation = partialLocation;
        this.restClient = restClient;
    }

    @Override
    protected Collection<String> doInBackground(Void... voids) {
        return restClient.findLocations(partialLocation);
    }


    @Override
    protected void onPostExecute(Collection<String> locations) {
        super.onPostExecute(locations);
        reactor.onLocationsFound(locations);
    }
}
