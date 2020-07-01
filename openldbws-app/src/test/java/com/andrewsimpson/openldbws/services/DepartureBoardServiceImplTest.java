package com.andrewsimpson.openldbws.services;

import com.andrewsimpson.openldbws.dto.request.GetBoardRequest;
import com.andrewsimpson.openldbws.dto.request.GetDeparturesRequest;
import com.andrewsimpson.openldbws.dto.request.GetServiceDetailsRequest;
import com.andrewsimpson.openldbws.dto.response.*;
import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldb.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.mockito.MockitoAnnotations.initMocks;

class DepartureBoardServiceImplTest {

    private final String token = "testToken";

    @Mock
    private LDBServiceSoap ldbServiceSoap;

    @Mock
    private Ldb ldbWebService;

    DepartureBoardServiceImpl departureBoardService;

    @BeforeEach
    public void setup() {
        initMocks(this);

        Mockito.when(this.ldbWebService.getLDBServiceSoap12()).thenReturn(ldbServiceSoap);

        departureBoardService = new DepartureBoardServiceImpl(token, ldbWebService);
    }

    @Test
    void getDepartureBoard_ShouldReturnStationBoardResponse() {
        // Given
        StationBoardResponseType stationBoardResponseType = new StationBoardResponseType();
        Mockito.when(this.ldbServiceSoap.getDepartureBoard(Mockito.any(), Mockito.any())).thenReturn(stationBoardResponseType);

        // When
        StationBoardResponse result = this.departureBoardService.getDepartureBoard(new GetBoardRequest());

        // Then
        Mockito.verify(this.ldbServiceSoap, times(1)).getDepartureBoard(Mockito.any(), Mockito.any());
        assertThat(result, is(notNullValue()));
    }

    @Test
    void getDepartureBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() {
        // Given
        StationBoardWithDetailsResponseType stationBoardWithDetailsResponseType = new StationBoardWithDetailsResponseType();
        Mockito.when(this.ldbServiceSoap.getDepBoardWithDetails(Mockito.any(), Mockito.any())).thenReturn(stationBoardWithDetailsResponseType);

        // When
        StationBoardWithDetailsResponse result = this.departureBoardService.getDepartureBoardWithDetails(new GetBoardRequest());

        // Then
        Mockito.verify(this.ldbServiceSoap, times(1)).getDepBoardWithDetails(Mockito.any(), Mockito.any());
        assertThat(result, is(notNullValue()));
    }

    @Test
    void getArrivalBoard_ShouldReturnStationBoardResponse() {
        // Given
        StationBoardResponseType stationBoardResponseType = new StationBoardResponseType();
        Mockito.when(this.ldbServiceSoap.getArrivalBoard(Mockito.any(), Mockito.any())).thenReturn(stationBoardResponseType);

        // When
        StationBoardResponse result = this.departureBoardService.getArrivalBoard(new GetBoardRequest());

        // Then
        Mockito.verify(this.ldbServiceSoap, times(1)).getArrivalBoard(Mockito.any(), Mockito.any());
        assertThat(result, is(notNullValue()));
    }

    @Test
    void getArrivalBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() {
        // Given
        StationBoardWithDetailsResponseType stationBoardWithDetailsResponseType = new StationBoardWithDetailsResponseType();
        Mockito.when(this.ldbServiceSoap.getArrBoardWithDetails(Mockito.any(), Mockito.any())).thenReturn(stationBoardWithDetailsResponseType);

        // When
        StationBoardWithDetailsResponse result = this.departureBoardService.getArrivalBoardWithDetails(new GetBoardRequest());

        // Then
        Mockito.verify(this.ldbServiceSoap, times(1)).getArrBoardWithDetails(Mockito.any(), Mockito.any());
        assertThat(result, is(notNullValue()));
    }

    @Test
    void getArrivalDepartureBoard_ShouldReturnStationBoardResponse() {
        // Given
        StationBoardResponseType stationBoardResponseType = new StationBoardResponseType();
        Mockito.when(this.ldbServiceSoap.getArrivalDepartureBoard(Mockito.any(), Mockito.any())).thenReturn(stationBoardResponseType);

        // When
        StationBoardResponse result = this.departureBoardService.getArrivalDepartureBoard(new GetBoardRequest());

        // Then
        Mockito.verify(this.ldbServiceSoap, times(1)).getArrivalDepartureBoard(Mockito.any(), Mockito.any());
        assertThat(result, is(notNullValue()));
    }

    @Test
    void getArrivalDepartureBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() {
        // Given
        StationBoardWithDetailsResponseType stationBoardWithDetailsResponseType = new StationBoardWithDetailsResponseType();
        Mockito.when(this.ldbServiceSoap.getArrDepBoardWithDetails(Mockito.any(), Mockito.any())).thenReturn(stationBoardWithDetailsResponseType);

        // When
        StationBoardWithDetailsResponse result = this.departureBoardService.getArrivalDepartureBoardWithDetails(new GetBoardRequest());

        // Then
        Mockito.verify(this.ldbServiceSoap, times(1)).getArrDepBoardWithDetails(Mockito.any(), Mockito.any());
        assertThat(result, is(notNullValue()));
    }

    @Test
    void getFastestDepartures_ShouldReturnDeparturesBoardResponse() {
        // Given
        DeparturesBoardResponseType departuresBoardResponseType = new DeparturesBoardResponseType();
        Mockito.when(this.ldbServiceSoap.getFastestDepartures(Mockito.any(), Mockito.any())).thenReturn(departuresBoardResponseType);

        // When
        DeparturesBoardResponse result = this.departureBoardService.getFastestDepartures(new GetDeparturesRequest());

        // Then
        Mockito.verify(this.ldbServiceSoap, times(1)).getFastestDepartures(Mockito.any(), Mockito.any());
        assertThat(result, is(notNullValue()));
    }

    @Test
    void getFastestDeparturesWithDetails_ShouldReturnDeparturesBoardWithDetailsResponse() {
        // Given
        DeparturesBoardWithDetailsResponseType departuresBoardWithDetailsResponseType = new DeparturesBoardWithDetailsResponseType();
        Mockito.when(this.ldbServiceSoap.getFastestDeparturesWithDetails(Mockito.any(), Mockito.any())).thenReturn(departuresBoardWithDetailsResponseType);

        // When
        DeparturesBoardWithDetailsResponse result = this.departureBoardService.getFastestDeparturesWithDetails(new GetDeparturesRequest());

        // Then
        Mockito.verify(this.ldbServiceSoap, times(1)).getFastestDeparturesWithDetails(Mockito.any(), Mockito.any());
        assertThat(result, is(notNullValue()));
    }

    @Test
    void getNextDepartures_ShouldReturnDeparturesBoardResponse() {
        // Given
        DeparturesBoardResponseType departuresBoardResponseType = new DeparturesBoardResponseType();
        Mockito.when(this.ldbServiceSoap.getNextDepartures(Mockito.any(), Mockito.any())).thenReturn(departuresBoardResponseType);

        // When
        DeparturesBoardResponse result = this.departureBoardService.getNextDepartures(new GetDeparturesRequest());

        // Then
        Mockito.verify(this.ldbServiceSoap, times(1)).getNextDepartures(Mockito.any(), Mockito.any());
        assertThat(result, is(notNullValue()));
    }

    @Test
    void getNextDeparturesWithDetails_ShouldReturnDeparturesBoardWithDetailsResponse() {
        // Given
        DeparturesBoardWithDetailsResponseType departuresBoardWithDetailsResponseType = new DeparturesBoardWithDetailsResponseType();
        Mockito.when(this.ldbServiceSoap.getNextDeparturesWithDetails(Mockito.any(), Mockito.any())).thenReturn(departuresBoardWithDetailsResponseType);

        // When
        DeparturesBoardWithDetailsResponse result = this.departureBoardService.getNextDeparturesWithDetails(new GetDeparturesRequest());

        // Then
        Mockito.verify(this.ldbServiceSoap, times(1)).getNextDeparturesWithDetails(Mockito.any(), Mockito.any());
        assertThat(result, is(notNullValue()));
    }

    @Test
    void getServiceDetails_ShouldReturnServiceDetailsResponse() {
        // Given
        ServiceDetailsResponseType serviceDetailsResponseType = new ServiceDetailsResponseType();
        Mockito.when(this.ldbServiceSoap.getServiceDetails(Mockito.any(), Mockito.any())).thenReturn(serviceDetailsResponseType);

        // When
        ServiceDetailsResponse result = this.departureBoardService.getServiceDetails(new GetServiceDetailsRequest());

        // Then
        Mockito.verify(this.ldbServiceSoap, times(1)).getServiceDetails(Mockito.any(), Mockito.any());
        assertThat(result, is(notNullValue()));
    }

    @Test
    void getAccessToken_ShouldReturnAccessToken() {
        // Given

        // When
        AccessToken result = this.departureBoardService.getAccessToken(token);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getTokenValue(), is(equalTo(token)));
    }
}