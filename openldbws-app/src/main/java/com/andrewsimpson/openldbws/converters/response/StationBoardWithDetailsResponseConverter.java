package com.andrewsimpson.openldbws.converters.response;

import com.andrewsimpson.openldbws.converters.StationBoardWithDetailsConverter;
import com.andrewsimpson.openldbws.dto.response.StationBoardWithDetailsResponse;
import com.thalesgroup.rtti._2017_10_01.ldb.StationBoardWithDetailsResponseType;

public class StationBoardWithDetailsResponseConverter {

    public static StationBoardWithDetailsResponse from(final StationBoardWithDetailsResponseType source) {

        if(source == null)
            return null;

        StationBoardWithDetailsResponse destination = new StationBoardWithDetailsResponse();
        destination.setStationBoardWithDetails(StationBoardWithDetailsConverter.from(source.getGetStationBoardResult()));
        return destination;
    }

}
