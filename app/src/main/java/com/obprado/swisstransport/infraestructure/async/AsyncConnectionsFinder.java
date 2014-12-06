package com.obprado.swisstransport.infraestructure.async;

import android.os.AsyncTask;

import com.obprado.swisstransport.application.ConnectionsReactor;
import com.obprado.swisstransport.infraestructure.rest.ConnectionsRestAdapter;
import com.obprado.swisstransport.model.Connection;

import java.util.Collection;

/**
 * Created by omar on 06/12/2014.
 */
public class AsyncConnectionsFinder extends AsyncTask<Void, Void, Collection<Connection>> {

    private ConnectionsReactor reactor;
    private ConnectionsRestAdapter restClient;
    private String location;

    public AsyncConnectionsFinder(ConnectionsReactor reactor, ConnectionsRestAdapter restClient, String location) {
        this.reactor = reactor;
        this.restClient = restClient;
        this.location = location;
    }

    @Override
    protected Collection<Connection> doInBackground(Void... voids) {
        return restClient.findConnections(location);
    }

    @Override
    protected void onPostExecute(Collection<Connection> connections) {
        super.onPostExecute(connections);
        reactor.onTripsFound(connections);
    }
}
