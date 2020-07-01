package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Coach;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfCoaches;
import com.thalesgroup.rtti._2017_10_01.ldb.types.CoachData;

import java.util.ArrayList;
import java.util.List;

public class CoachListConverter {

    public static List<Coach> from(final ArrayOfCoaches source) {

        if(source == null)
            return null;

        List<Coach> destination = new ArrayList<>();
        for(CoachData coachData : source.getCoach()) {
            destination.add(CoachConverter.from(coachData));
        }

        return destination;
    }
}
