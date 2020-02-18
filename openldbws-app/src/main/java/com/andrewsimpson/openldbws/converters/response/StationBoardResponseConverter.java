package com.andrewsimpson.openldbws.converters.response;

import com.andrewsimpson.openldbws.converters.StationBoardConverter;
import com.andrewsimpson.openldbws.dto.response.StationBoardResponse;
import com.thalesgroup.rtti._2017_10_01.ldb.StationBoardResponseType;

public class StationBoardResponseConverter {

    public static StationBoardResponse from(final StationBoardResponseType source) {

        StationBoardResponse destination = new StationBoardResponse();
        destination.setStationBoard(StationBoardConverter.from(source.getGetStationBoardResult()));
        return destination;
    }

}
