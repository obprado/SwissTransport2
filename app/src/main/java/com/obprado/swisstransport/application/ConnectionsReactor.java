package com.obprado.swisstransport.application;

import com.obprado.swisstransport.model.Connection;

import java.util.Collection;

/**
 * Created by omar on 06/12/2014.
 */
public interface ConnectionsReactor {

    public void onTripsFound(Collection<Connection> connections);
}
