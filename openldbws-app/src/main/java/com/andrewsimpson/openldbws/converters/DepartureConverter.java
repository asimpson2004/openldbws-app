package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Departure;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DepartureItem;

public class DepartureConverter {

    public static Departure from(final DepartureItem source) {

        if(source == null)
            return null;

        Departure destination = new Departure();
        destination.setCrs(source.getCrs());
        destination.setService(ServiceConverter.from(source.getService()));
        return destination;
    }

}
