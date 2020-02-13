package com.andrewsimpson.openldbws.commands;

import java.util.List;

public class DepartureBoardWithDetails extends StationBoardBase {

    protected List<DepartureWithCallingPoints> departureWithCallingPoints;

    public List<DepartureWithCallingPoints> getDepartureWithCallingPoints() {
        return departureWithCallingPoints;
    }

    public void setDepartureWithCallingPoints(List<DepartureWithCallingPoints> departureWithCallingPoints) {
        this.departureWithCallingPoints = departureWithCallingPoints;
    }
}
