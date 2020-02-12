package com.andrewsimpson.openldbws.services;

import com.andrewsimpson.openldbws.commands.*;


public interface DepartureBoardService {

    StationBoardResponse getDepartureBoard(GetBoardRequest getBoardRequest);
    StationBoardWithDetailsResponse getDepartureBoardWithDetails(GetBoardRequest getBoardRequest);

    StationBoardResponse getArrivalBoard(GetBoardRequest getBoardRequest);
    StationBoardWithDetailsResponse getArrivalBoardWithDetails(GetBoardRequest getBoardRequest);

    StationBoardResponse getArrivalDepartureBoard(GetBoardRequest getBoardRequest);
    StationBoardWithDetailsResponse getArrivalDepartureBoardWithDetails(GetBoardRequest getBoardRequest);

    DeparturesBoardResponse getFastestDepartures(GetDeparturesRequest getDeparturesRequest);
    DeparturesBoardWithDetailsResponse getFastestDeparturesWithDetails(GetDeparturesRequest getDeparturesRequest);

    DeparturesBoardResponse getNextDepartures(GetDeparturesRequest getDeparturesRequest);
    DeparturesBoardWithDetailsResponse getNextDeparturesWithDetails(GetDeparturesRequest getDeparturesRequest);

    ServiceDetailsResponse getServiceDetails(GetServiceDetailsRequest getServiceDetailsRequest);
}
