package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Coach;
import com.thalesgroup.rtti._2017_10_01.ldb.types.CoachData;

public class CoachConverter {

    public static Coach from(final CoachData source) {

        if(source == null)
            return null;

        Coach destination = new Coach();
        destination.setCoachClass(source.getCoachClass());
        destination.setLoading(source.getLoading());
        destination.setNumber(source.getNumber());
        destination.setToiletAvailability(ToiletAvailabilityConverter.from(source.getToilet()));

        return destination;
    }

}
