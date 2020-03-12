package com.andrewsimpson.openldbws.controllers;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.andrewsimpson.openldbws.dto.Filter;
import com.andrewsimpson.openldbws.dto.request.GetBoardRequest;
import com.andrewsimpson.openldbws.dto.request.GetDeparturesRequest;
import com.andrewsimpson.openldbws.dto.request.GetServiceDetailsRequest;
import com.andrewsimpson.openldbws.dto.response.*;
import com.andrewsimpson.openldbws.services.DepartureBoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class DepartureBoardRestControllerTest {

    private static final String DEPARTURE_BOARD_URI = "/api/departureBoard";
    private static final String DEPARTURE_BOARD_WITH_DETAILS_URI = "/api/departureBoardWithDetails";
    private static final String ARRIVAL_BOARD_URI = "/api/arrivalBoard";
    private static final String ARRIVAL_BOARD_WITH_DETAILS_URI = "/api/arrivalBoardWithDetails";
    private static final String ARRIVAL_DEPARTURE_BOARD_URI = "/api/arrivalDepartureBoard";
    private static final String ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI = "/api/arrivalDepartureBoardWithDetails";
    private static final String FASTEST_DEPARTURES_URI = "/api/fastestDepartures";
    private static final String FASTEST_DEPARTURES_WITH_DETAILS_URI = "/api/fastestDeparturesWithDetails";
    private static final String NEXT_DEPARTURES_URI = "/api/nextDepartures";
    private static final String NEXT_DEPARTURES_WITH_DETAILS_URI = "/api/nextDeparturesWithDetails";
    private static final String SERVICE_DETAILS_URI = "/api/serviceDetails";

    @Mock
    private DepartureBoardService departureBoardService;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        initMocks(this);
        final DepartureBoardRestController departureBoardRestController = new DepartureBoardRestController(departureBoardService);
        mvc = MockMvcBuilders.standaloneSetup(departureBoardRestController).build();
    }

    @Test
    void getDepartureBoard_NullNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoard_LowNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(-1);

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoard_HighNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(151);

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoard_NullCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoard_ShortCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("R");
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoard_LongCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNHH");
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
            .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoard_LowTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(-121);

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoard_HighTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(121);

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoard_LowTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(-121);

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoard_HighTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(121);

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoard_ShouldReturnStationBoardResponse() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(120);
        getBoardRequest.setTimeOffset(0);
        getBoardRequest.setFilter(Filter.TO);
        getBoardRequest.setFilterCrs("LIV");

        StationBoardResponse stationBoardResponse = new StationBoardResponse();
        Mockito.when(this.departureBoardService.getDepartureBoard(Mockito.any())).thenReturn(stationBoardResponse);

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(stationBoardResponse)));
    }


    @Test
    void getDepartureBoardWithDetails_NullNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        // When
        mvcPerformWithJson(DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoardWithDetails_LowNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(-1);
        // When
        mvcPerformWithJson(DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoardWithDetails_HighNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(11);
        // When
        mvcPerformWithJson(DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoardWithDetails_NullCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setNumRows(5);
        // When
        mvcPerformWithJson(DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoardWithDetails_ShortCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("R");
        getBoardRequest.setNumRows(5);
        // When
        mvcPerformWithJson(DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoardWithDetails_LongCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNHH");
        getBoardRequest.setNumRows(5);
        // When
        mvcPerformWithJson(DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoardWithDetails_LowTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(-121);
        // When
        mvcPerformWithJson(DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoardWithDetails_HighTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(121);
        // When
        mvcPerformWithJson(DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoardWithDetails_LowTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(-121);
        // When
        mvcPerformWithJson(DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoardWithDetails_HighTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(121);
        // When
        mvcPerformWithJson(DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(120);
        getBoardRequest.setTimeOffset(0);
        getBoardRequest.setFilter(Filter.TO);
        getBoardRequest.setFilterCrs("LIV");

        StationBoardWithDetailsResponse stationBoardWithDetailsResponse = new StationBoardWithDetailsResponse();
        Mockito.when(this.departureBoardService.getDepartureBoardWithDetails(Mockito.any())).thenReturn(stationBoardWithDetailsResponse);

        // When
        mvcPerformWithJson(DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(stationBoardWithDetailsResponse)));
    }

    @Test
    void getArrivalBoard_NullNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getArrivalBoard_LowNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(-1);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getArrivalBoard_HighNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(151);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoard_NullCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoard_ShortCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("R");
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoard_LongCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNHH");
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoard_LowTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(-121);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoard_HighTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(121);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoard_LowTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(-121);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoard_HighTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(121);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoard_ShouldReturnStationBoardResponse() throws Exception{
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(120);
        getBoardRequest.setTimeOffset(0);
        getBoardRequest.setFilter(Filter.TO);
        getBoardRequest.setFilterCrs("LIV");

        StationBoardResponse stationBoardResponse = new StationBoardResponse();
        Mockito.when(this.departureBoardService.getArrivalBoard(Mockito.any())).thenReturn(stationBoardResponse);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(stationBoardResponse)));

    }

    @Test
    void getArrivalBoardWithDetails_NullNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoardWithDetails_LowNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(-1);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoardWithDetails_HighNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(11);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoardWithDetails_NullCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoardWithDetails_ShortCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("R");
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoardWithDetails_LongCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNHH");
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoardWithDetails_LowTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(-121);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoardWithDetails_HighTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(121);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoardWithDetails_LowTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(-121);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoardWithDetails_HighTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(121);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(120);
        getBoardRequest.setTimeOffset(0);
        getBoardRequest.setFilter(Filter.TO);
        getBoardRequest.setFilterCrs("LIV");

        StationBoardWithDetailsResponse stationBoardWithDetailsResponse = new StationBoardWithDetailsResponse();
        Mockito.when(this.departureBoardService.getArrivalBoardWithDetails(Mockito.any())).thenReturn(stationBoardWithDetailsResponse);

        // When
        mvcPerformWithJson(ARRIVAL_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(stationBoardWithDetailsResponse)));
    }

    @Test
    void getArrivalDepartureBoard_NullNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoard_LowNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(-1);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoard_HighNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(151);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoard_NullCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoard_ShortCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("R");
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoard_LongCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNHH");
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoard_LowTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(-121);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoard_HighTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(121);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoard_LowTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(-121);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoard_HighTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(121);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoard_ShouldReturnStationBoardResponse() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(120);
        getBoardRequest.setTimeOffset(0);
        getBoardRequest.setFilter(Filter.TO);
        getBoardRequest.setFilterCrs("LIV");

        StationBoardResponse stationBoardResponse = new StationBoardResponse();

        Mockito.when(this.departureBoardService.getArrivalDepartureBoard(Mockito.any())).thenReturn(stationBoardResponse);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(stationBoardResponse)));
    }

    @Test
    void getArrivalDepartureBoardWithDetails_NullNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoardWithDetails_LowNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(-1);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoardWithDetails_HighNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(11);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoardWithDetails_NullCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoardWithDetails_ShortCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("R");
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoardWithDetails_LongCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNHH");
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoardWithDetails_LowTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(-121);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoardWithDetails_HighTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeOffset(121);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoardWithDetails_LowTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(-121);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoardWithDetails_HighTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(121);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getArrivalDepartureBoardWithDetails_ShouldReturnStationBoardWithDetailsResponse() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");
        getBoardRequest.setNumRows(5);
        getBoardRequest.setTimeWindow(120);
        getBoardRequest.setTimeOffset(0);
        getBoardRequest.setFilter(Filter.TO);
        getBoardRequest.setFilterCrs("LIV");

        StationBoardWithDetailsResponse stationBoardWithDetailsResponse = new StationBoardWithDetailsResponse();
        Mockito.when(this.departureBoardService.getArrivalDepartureBoardWithDetails(Mockito.any())).thenReturn(stationBoardWithDetailsResponse);

        // When
        mvcPerformWithJson(ARRIVAL_DEPARTURE_BOARD_WITH_DETAILS_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(stationBoardWithDetailsResponse)));
    }

    @Test
    void getFastestDepartures_NullCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_ShortCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("R");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_LongCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNHH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_NullFiltersList_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_ShortFiltersList_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_LongFiltersList_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        for(int i = 0; i < 16; i++) {
            filtersList.add("LIV");
        }
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_ShortFiltersListCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("L");

        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_LongFiltersListCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIVV");

        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_LowTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeOffset(-121);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_HighTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeOffset(121);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_LowTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(-121);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_HighTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(121);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDepartures_ShouldReturnDeparturesBoardResponse() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(120);
        getDeparturesRequest.setTimeOffset(0);

        DeparturesBoardResponse departuresBoardResponse = new DeparturesBoardResponse();
        Mockito.when(this.departureBoardService.getFastestDepartures(Mockito.any())).thenReturn(departuresBoardResponse);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(departuresBoardResponse)));

    }

    @Test
    void getFastestDeparturesWithDetails_NullCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getFastestDeparturesWithDetails_ShortCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("R");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getFastestDeparturesWithDetails_LongCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNHH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getFastestDeparturesWithDetails_NullFiltersList_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getFastestDeparturesWithDetails_ShortFiltersList_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getFastestDeparturesWithDetails_LongFiltersList_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        for(int i = 0; i < 11; i++) {
            filtersList.add("LIV");
        }
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getFastestDeparturesWithDetails_ShortFiltersListCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("L");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getFastestDeparturesWithDetails_LongFiltersListCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIVV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getFastestDeparturesWithDetails_LowTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeOffset(-121);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getFastestDeparturesWithDetails_HighTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeOffset(121);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());

    }

    @Test
    void getFastestDeparturesWithDetails_LowTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(-121);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDeparturesWithDetails_HighTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(121);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFastestDeparturesWithDetails_ShouldReturnDeparturesBoardWithDetailsResponse() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(120);
        getDeparturesRequest.setTimeOffset(0);

        DeparturesBoardWithDetailsResponse departuresBoardWithDetailsResponse = new DeparturesBoardWithDetailsResponse();
        Mockito.when(this.departureBoardService.getFastestDeparturesWithDetails(Mockito.any())).thenReturn(departuresBoardWithDetailsResponse);

        // When
        mvcPerformWithJson(FASTEST_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
                // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(departuresBoardWithDetailsResponse)));
    }

    @Test
    void getNextDepartures_NullCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_ShortCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("R");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_LongCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNHH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_NullFiltersList_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_ShortFiltersList_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_LongFiltersList_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            filtersList.add("LIV");
        }
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_ShortFiltersListCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("L");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_LongFiltersListCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIVV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_LowTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeOffset(-121);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_HighTimeOffset_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeOffset(121);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_LowTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(-121);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_HighTimeWindow_ShouldReturnBadRequest() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(121);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDepartures_ShouldReturnDeparturesBoardResponse() throws Exception {
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(120);
        getDeparturesRequest.setTimeOffset(0);

        DeparturesBoardResponse departuresBoardResponse = new DeparturesBoardResponse();
        Mockito.when(this.departureBoardService.getNextDepartures(Mockito.any())).thenReturn(departuresBoardResponse);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(departuresBoardResponse)));

    }

    @Test
    void getNextDeparturesWithDetails_NullCRS_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_ShortCRS_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("R");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_LongCRS_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNHH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_NullFiltersList_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_ShortFiltersList_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_LongFiltersList_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        for(int i = 0; i < 11; i++) {
            filtersList.add("LIV");
        }
        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_ShortFiltersCRS_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("L");

        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_LongFiltersCRS_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIVV");

        getDeparturesRequest.setFilterList(filtersList);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_LowTimeOffset_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeOffset(-121);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_HighTimeOffset_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeOffset(121);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_LowTimeWindow_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(-121);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_HighTimeWindow_ShouldReturnBadRequest() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(121);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getNextDeparturesWithDetails_ShouldReturnDeparturesBoardWithDetailsResponse() throws Exception{
        // Given
        GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs("RNH");
        List<String> filtersList = new ArrayList<>();
        filtersList.add("LIV");
        getDeparturesRequest.setFilterList(filtersList);
        getDeparturesRequest.setTimeWindow(120);
        getDeparturesRequest.setTimeOffset(0);

        DeparturesBoardWithDetailsResponse departuresBoardWithDetailsResponse = new DeparturesBoardWithDetailsResponse();
        Mockito.when(this.departureBoardService.getNextDeparturesWithDetails(Mockito.any())).thenReturn(departuresBoardWithDetailsResponse);

        // When
        mvcPerformWithJson(NEXT_DEPARTURES_WITH_DETAILS_URI, asJsonString(getDeparturesRequest))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(departuresBoardWithDetailsResponse)));
    }

    @Test
    void getServiceDetails_NullServiceId_ShouldReturnBadRequest()  throws Exception {
        // Given
        GetServiceDetailsRequest getServiceDetailsRequest = new GetServiceDetailsRequest();

        // When
        mvcPerformWithJson(SERVICE_DETAILS_URI, asJsonString(getServiceDetailsRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getServiceDetails_ShouldReturnServiceDetailsResponse() throws Exception {
        // Given
        GetServiceDetailsRequest getServiceDetailsRequest = new GetServiceDetailsRequest();
        getServiceDetailsRequest.setServiceID("serviceId");

        ServiceDetailsResponse serviceDetailsResponse = new ServiceDetailsResponse();
        Mockito.when(this.departureBoardService.getServiceDetails(Mockito.any())).thenReturn(serviceDetailsResponse);

        // When
        mvcPerformWithJson(SERVICE_DETAILS_URI, asJsonString(getServiceDetailsRequest))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(serviceDetailsResponse)));
    }

    private ResultActions mvcPerformWithJson(final String uri, final String json) throws Exception  {
        return this.mvc.perform(get(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}