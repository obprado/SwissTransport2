package com.obprado.swisstransport.application;

import com.obprado.swisstransport.model.Connection;

import java.util.Collection;

/**
 * Created by omar on 06/12/2014.
 */
class FindConnections implements Task, ConnectionsReactor {

    private ConnectionsFinder finder;
    private String origin;
    private ConnectionsDisplay display;

    @Override
    public void execute() {
        finder.tripsFrom(origin, this);
    }

    @Override
    public void onTripsFound(Collection<Connection> connections) {
        display.updateConnections(connections);
    }
}
