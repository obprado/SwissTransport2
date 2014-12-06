package com.obprado.swisstransport.model;

import java.util.Date;

/**
 * Created by omar on 06/12/2014.
 */
public class Connection {

    private String name;
    private Date departure;
    private String location;

    public Connection(String name, Date departure, String location) {
        this.name = name;
        this.departure = departure;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Date getDeparture() {
        return departure;
    }

    public String getLocation() {
        return location;
    }
}
