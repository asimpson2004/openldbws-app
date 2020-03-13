package com.andrewsimpson.openldbws.services;

import com.thalesgroup.rtti._2017_10_01.ldb.Ldb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;

class DepartureBoardServiceImplTest {

    private final String token = "testToken";

    @Mock
    private Ldb ldbWebService;

    DepartureBoardServiceImpl departureBoardService;

    @BeforeEach
    public void setup() {
        initMocks(this);
        departureBoardService = new DepartureBoardServiceImpl(token, ldbWebService);
    }

    @Test
    void departureBoardServiceImpl_ShouldSetParemeters() {
        // Given

        // When

        // Then

    }

    @Test
    void getDepartureBoard_ShouldReturnStationBoardResponse() {
        // Given

        // When

        // Then

    }

    @Test
    void getDepartureBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() {
        // Given

        // When

        // Then

    }

    @Test
    void getArrivalBoard_ShouldReturnStationBoardResponse() {
        // Given

        // When

        // Then

    }

    @Test
    void getArrivalBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() {
        // Given

        // When

        // Then

    }

    @Test
    void getArrivalDepartureBoard_ShouldReturnStationBoardResponse() {
        // Given

        // When

        // Then

    }

    @Test
    void getArrivalDepartureBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() {
        // Given

        // When

        // Then

    }

    @Test
    void getFastestDepartures_ShouldReturnDeparturesBoardResponse() {
        // Given

        // When

        // Then

    }

    @Test
    void getFastestDeparturesWithDetails_ShouldReturnDeparturesBoardWithDetailsResponse() {
        // Given

        // When

        // Then

    }

    @Test
    void getNextDepartures_ShouldReturnDeparturesBoardResponse() {
        // Given

        // When

        // Then

    }

    @Test
    void getNextDeparturesWithDetails_ShouldReturnDeparturesBoardWithDetailsResponse() {
        // Given

        // When

        // Then

    }

    @Test
    void getServiceDetails_ShouldReturnServiceDetailsResponse() {
        // Given

        // When

        // Then

    }

    @Test
    void getAccessToken_ShouldReturnAccessToken() {
        // Given

        // When

        // Then

    }
}