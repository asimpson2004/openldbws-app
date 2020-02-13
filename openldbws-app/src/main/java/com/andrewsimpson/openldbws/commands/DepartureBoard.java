package com.andrewsimpson.openldbws.commands;

import java.util.GregorianCalendar;
import java.util.List;

public class DepartureBoard extends StationBoardBase {

    protected List<Departure> destinations;

    public List<Departure> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Departure> destinations) {
        this.destinations = destinations;
    }
}
