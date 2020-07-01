package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.StationBoardWithDetails;

public class StationBoardWithDetailsConverter {

    public static StationBoardWithDetails from(final com.thalesgroup.rtti._2017_10_01.ldb.types.StationBoardWithDetails source) {

        if(source == null)
            return null;

        StationBoardWithDetails destination = new StationBoardWithDetails();
        StationBoardBaseConverter.from(source, destination);
        destination.setTrainServices(ServiceWithCallingPointsListConverter.from(source.getTrainServices()));
        destination.setBusServices(ServiceWithCallingPointsListConverter.from(source.getBusServices()));
        destination.setFerryServices(ServiceWithCallingPointsListConverter.from(source.getFerryServices()));

        return destination;
    }

}
