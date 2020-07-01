package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.CallingPoint;
import com.andrewsimpson.openldbws.dto.CallingPointList;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfArrayOfCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfCallingPoints;

import java.util.ArrayList;
import java.util.List;

public class ListOfCallingPointListConverter {

    public static List<CallingPointList> from(final ArrayOfArrayOfCallingPoints source) {

        if(source == null)
            return null;

        List<CallingPointList> destination = new ArrayList<>();
        for(ArrayOfCallingPoints arrayOfCallingPoints : source.getCallingPointList()){
            destination.add(CallingPointListConverter.from(arrayOfCallingPoints));
        }

        return destination;
    }
}
