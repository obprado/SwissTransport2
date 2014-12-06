package com.obprado.swisstransport.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.obprado.swisstransport.R;
import com.obprado.swisstransport.application.AutoCompleteLocations;
import com.obprado.swisstransport.application.ConnectionsDisplay;
import com.obprado.swisstransport.application.FindConnections;
import com.obprado.swisstransport.application.LocationsDisplay;
import com.obprado.swisstransport.infraestructure.ConnectionsFinderImpl;
import com.obprado.swisstransport.infraestructure.LocationsFinderImpl;
import com.obprado.swisstransport.model.Connection;

import java.util.Collection;


public class transportSearch extends Activity implements LocationsDisplay, ConnectionsDisplay {

    private EditText locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_search);

        locationText = (EditText)findViewById(R.id.location);
        LocationWatcher locationWatcher = new LocationWatcher(new AutoCompleteLocations(this, new LocationsFinderImpl()));
        locationText.addTextChangedListener(locationWatcher);
    }

    @Override
    public void updateConnections(Collection<Connection> connections) {
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(new ConnectionsAdapter(this, 0, connections.toArray(new Connection[connections.size()])));
    }

    @Override
    public void updateLocations(Collection<String> locations) {
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(new StringAdapter(this, 0, locations.toArray(new String[locations.size()])));
    }

    public void findConnections(View v) {
        FindConnections findConnections = new FindConnections(new ConnectionsFinderImpl(), locationText.getText().toString(),this);
        findConnections.execute();
    }
}
