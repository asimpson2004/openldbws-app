package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.DepartureWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DepartureItemWithCallingPoints;

public class DepartureWithCallingPointsConverter {

    public static DepartureWithCallingPoints from(final DepartureItemWithCallingPoints source) {

        if(source == null)
            return null;

        DepartureWithCallingPoints destination = new DepartureWithCallingPoints();
        destination.setCrs(source.getCrs());
        destination.setServiceWithCallingPoints(ServiceWithCallingPointsConverter.from(source.getService()));

        return destination;
    }

}
