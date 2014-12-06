package com.obprado.swisstransport.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.obprado.swisstransport.R;
import com.obprado.swisstransport.model.Connection;

/**
 * Created by omar on 06/12/2014.
 */
public class StringAdapter extends ArrayAdapter<String> {
    private Context context;
    private String[] connections;

    public StringAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.connections = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View connectionRow = inflater.inflate(R.layout.suggestion_row, parent, false);

        TextView suggestionView = (TextView) connectionRow.findViewById(R.id.suggestion);

        suggestionView.setText(connections[position]);

        return connectionRow;
    }
}
