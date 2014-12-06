package com.obprado.swisstransport.infraestructure.rest;

import com.obprado.swisstransport.model.Connection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by omar on 06/12/2014.
 */
public class ConnectionsRestAdapter {

    public static final String CONNECTIONS_URI = "http://transport.opendata.ch/v1/stationboard?limit=10?station=";

    public Collection<Connection> findConnections(String location){
        String JSON = downloadJSON(location);
        return parseStationBoard(JSON);
    }

    private String downloadJSON(String location) {
        return AdapterCommon.downloadJSON(CONNECTIONS_URI + location);
    }

    private Collection<Connection> parseStationBoard(String json) {
        try {
            ArrayList<Connection> connections = new ArrayList<Connection>();
            JSONObject jsonStationBoard = new JSONObject(json);
            JSONArray jsonConnections = jsonStationBoard.getJSONArray("stationboard");
            for (int i = 0; i < jsonConnections.length(); i++){
                connections.add(parseConnection(jsonConnections.getJSONObject(i)));
            }
            return connections;
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Connection parseConnection(JSONObject jsonConnection) {
        try {
            String name = jsonConnection.getString("name");
            Date departureDate = new Date(jsonConnection.getJSONObject("stop").getString("departure"));
            String destination = jsonConnection.getString("to");
            return new Connection(name, departureDate, destination);
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
