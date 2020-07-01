package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Departure;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfDepartureItems;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DepartureItem;

import java.util.ArrayList;
import java.util.List;

public class DepartureListConverter {

    public static List<Departure> from(final ArrayOfDepartureItems source) {

        if(source == null)
            return null;

        List<Departure> departures = new ArrayList<>();
        for(DepartureItem departureItem : source.getDestination()) {
            departures.add(DepartureConverter.from(departureItem));
        }

        return departures;
    }
}
