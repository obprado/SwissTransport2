package com.obprado.swisstransport.infraestructure.rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by omar on 06/12/2014.
 */
public class LocationsRestAdapter {

    public static final String LOCATIONS_URI = "http://transport.opendata.ch/v1/locations?query=";

    public Collection<String> findLocations(String partialLocation){
        String JSON = downloadJSON(partialLocation);
        return parseJSON(JSON);
    }

    private String downloadJSON(String partialLocation){
        return AdapterCommon.downloadJSON(LOCATIONS_URI + partialLocation);
    }

    private Collection<String> parseJSON(String json) {
        try {
            ArrayList<String> locations = new ArrayList<String>();
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("stations");
            for (int i=0; i < jsonArray.length(); i++){
                locations.add(jsonArray.getJSONObject(i).getString("name"));
            }
            return locations;
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
