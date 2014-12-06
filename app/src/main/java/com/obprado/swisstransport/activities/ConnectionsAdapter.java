package com.obprado.swisstransport.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.obprado.swisstransport.R;
import com.obprado.swisstransport.model.Connection;

/**
 * Created by omar on 06/12/2014.
 */
public class ConnectionsAdapter extends ArrayAdapter<Connection> {

    private Context context;
    private Connection[] connections;

    public ConnectionsAdapter(Context context, int resource, Connection[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.connections = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View connectionRow = inflater.inflate(R.layout.connection_row, parent, false);

        TextView name = (TextView) connectionRow.findViewById(R.id.name);
        TextView departureDate = (TextView) connectionRow.findViewById(R.id.departure);
        TextView destination = (TextView) connectionRow.findViewById(R.id.destination);

        name.setText(connections[position].getName());
        departureDate.setText(connections[position].getHourAndMinutes());
        destination.setText(connections[position].getLocation());

        return connectionRow;
    }
}
