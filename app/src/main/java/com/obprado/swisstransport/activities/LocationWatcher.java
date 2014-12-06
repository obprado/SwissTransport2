package com.obprado.swisstransport.activities;

import android.text.Editable;
import android.text.TextWatcher;

import com.obprado.swisstransport.application.AutoCompleteLocations;

/**
 * Created by omar on 06/12/2014.
 */
public class LocationWatcher implements TextWatcher {

    private AutoCompleteLocations autoCompleteLocations;

    public LocationWatcher(AutoCompleteLocations autoCompleteLocations) {
        this.autoCompleteLocations = autoCompleteLocations;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable.length() > 0) {
            autoCompleteLocations.autocomplete(editable.toString());
        }
    }
}
