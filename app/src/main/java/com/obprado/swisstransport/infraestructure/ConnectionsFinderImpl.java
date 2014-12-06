package com.obprado.swisstransport.infraestructure;

import com.obprado.swisstransport.application.ConnectionsFinder;
import com.obprado.swisstransport.application.ConnectionsReactor;
import com.obprado.swisstransport.infraestructure.async.AsyncConnectionsFinder;
import com.obprado.swisstransport.infraestructure.rest.ConnectionsRestAdapter;

/**
 * Created by omar on 06/12/2014.
 */
public class ConnectionsFinderImpl implements ConnectionsFinder {

    @Override
    public void tripsFrom(String origin, ConnectionsReactor processor) {
        AsyncConnectionsFinder connectionsFinder = new AsyncConnectionsFinder(processor, new ConnectionsRestAdapter(), origin);
        connectionsFinder.execute();
    }
}
