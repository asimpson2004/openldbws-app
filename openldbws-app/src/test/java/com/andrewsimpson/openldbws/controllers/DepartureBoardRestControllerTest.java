package com.andrewsimpson.openldbws.controllers;

import com.andrewsimpson.openldbws.dto.response.StationBoardResponse;
import com.andrewsimpson.openldbws.services.DepartureBoardService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class DepartureBoardRestControllerTest {

    @Mock
    private DepartureBoardService departureBoardService;

    @InjectMocks
    private DepartureBoardRestController departureBoardRestController;

    @Test
    void getDepartureBoard_ShouldReturnBadRequest() {

    }

    @Test
    void getDepartureBoard_ShouldReturnStationBoardResponse() {

    }

    @Test
    void getDepartureBoardWithDetails_ShouldReturnBadRequest() {

    }

    @Test
    void getDepartureBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() {

    }

    @Test
    void getArrivalBoard_ShouldReturnBadRequest() {

    }

    @Test
    void getArrivalBoard_ShouldReturnStationBoardResponse() {

    }

    @Test
    void getArrivalBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() {

    }

    @Test
    void getArrivalBoardWithDetails_ShouldReturnBadRequest() {

    }

    @Test
    void getArrivalDepartureBoard_ShouldReturnBadRequest() {

    }

    @Test
    void getArrivalDepartureBoard_ShouldReturnStationBoardResponse() {

    }

    @Test
    void getArrivalDepartureBoardWithDetails_ShouldReturnBadRequest() {

    }

    @Test
    void getArrivalDepartureBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() {

    }

    @Test
    void getFastestDepartures_ShouldReturnBadRequest() {

    }

    @Test
    void getFastestDepartures_ShouldReturnDeparturesBoardResponse() {

    }

    @Test
    void getFastestDeparturesWithDetails_ShouldReturnBadRequest() {

    }

    @Test
    void getFastestDeparturesWithDetails_ShouldReturnDeparturesBoardWithDetailsResponse() {

    }

    @Test
    void getNextDepartures_ShouldReturnBadRequest() {

    }

    @Test
    void getNextDepartures_ShouldReturnDeparturesBoardResponse() {

    }

    @Test
    void getNextDeparturesWithDetails_ShouldReturnBadRequest() {

    }

    @Test
    void getNextDeparturesWithDetails_ShouldReturnDeparturesBoardWithDetailsResponse() {

    }

    @Test
    void getServiceDetails_ShouldReturnBadRequest() {

    }

    @Test
    void getServiceDetails_ShouldReturnServiceDetailsResponse() {

    }

}