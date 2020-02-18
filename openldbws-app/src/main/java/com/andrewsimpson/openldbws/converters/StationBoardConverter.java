package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.StationBoard;

public class StationBoardConverter {

    public static StationBoard from(final com.thalesgroup.rtti._2017_10_01.ldb.types.StationBoard source) {

        if(source == null)
            return null;

        StationBoard destination = new StationBoard();
        StationBoardBaseConverter.from(source, destination);
        destination.setTrainServices(ServiceListConverter.from(source.getTrainServices()));
        destination.setBusServices(ServiceListConverter.from(source.getBusServices()));
        destination.setFerryServices(ServiceListConverter.from(source.getFerryServices()));

        return destination;
    }

}
