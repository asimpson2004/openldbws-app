package com.andrewsimpson.openldbws.converters.response;

import com.andrewsimpson.openldbws.converters.DepartureBoardWithDetailsConverter;
import com.andrewsimpson.openldbws.dto.response.DeparturesBoardWithDetailsResponse;
import com.thalesgroup.rtti._2017_10_01.ldb.DeparturesBoardWithDetailsResponseType;

public class DeparturesBoardWithDetailsResponseConverter {

    public static DeparturesBoardWithDetailsResponse from(final DeparturesBoardWithDetailsResponseType source) {

        if(source == null)
            return null;

        DeparturesBoardWithDetailsResponse destination = new DeparturesBoardWithDetailsResponse();
        destination.setDepartureBoardWithDetails(DepartureBoardWithDetailsConverter.from(source.getDeparturesBoard()));
        return destination;
    }

}
