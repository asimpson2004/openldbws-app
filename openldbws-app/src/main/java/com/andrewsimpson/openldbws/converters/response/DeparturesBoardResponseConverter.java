package com.andrewsimpson.openldbws.converters.response;

import com.andrewsimpson.openldbws.converters.DepartureBoardConverter;
import com.andrewsimpson.openldbws.dto.response.DeparturesBoardResponse;
import com.thalesgroup.rtti._2017_10_01.ldb.DeparturesBoardResponseType;

public class DeparturesBoardResponseConverter {

    public static DeparturesBoardResponse from(final DeparturesBoardResponseType source) {

        if(source == null)
            return null;

        DeparturesBoardResponse destination = new DeparturesBoardResponse();
        destination.setDepartureBoard(DepartureBoardConverter.from(source.getDeparturesBoard()));

        return destination;
    }

}
