package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.DepartureWithCallingPoints;
import com.andrewsimpson.openldbws.dto.Formation;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DepartureItemWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.FormationData;

public class FormationConverter {

    public static Formation from(final FormationData source) {

        if(source == null)
            return null;

        Formation destination = new Formation();
        destination.setAverageLoading(source.getAvgLoading());
        destination.setCoaches(CoachListConverter.from(source.getCoaches()));

        return destination;
    }

}
