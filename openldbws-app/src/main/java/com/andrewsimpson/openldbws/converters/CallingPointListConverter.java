package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.CallingPoint;
import com.andrewsimpson.openldbws.dto.CallingPointList;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfCallingPoints;

import java.util.ArrayList;
import java.util.List;

public class CallingPointListConverter {

    public static CallingPointList from(final ArrayOfCallingPoints source) {

        if(source == null)
            return null;

        CallingPointList destination = new CallingPointList();
        destination.setAssocIsCancelled(source.isAssocIsCancelled());
        destination.setServiceType(ServiceTypeConverter.from(source.getServiceType()));
        destination.setServiceChangeRequired(source.isServiceChangeRequired());

        List<CallingPoint> callingPoints = new ArrayList<>();
        for (com.thalesgroup.rtti._2017_10_01.ldb.types.CallingPoint callingPoint: source.getCallingPoint()) {
            callingPoints.add(CallingPointConverter.from(callingPoint));
        }

        destination.setCallingPoints(callingPoints);

        return destination;
    }

}
