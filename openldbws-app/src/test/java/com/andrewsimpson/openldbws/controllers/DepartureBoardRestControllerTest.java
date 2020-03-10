package com.andrewsimpson.openldbws.controllers;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.andrewsimpson.openldbws.dto.Filter;
import com.andrewsimpson.openldbws.dto.request.GetBoardRequest;
import com.andrewsimpson.openldbws.dto.response.StationBoardResponse;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class DepartureBoardRestControllerTest {

    private static final String DEPARTUREBOARD_URI = "/api/departureBoard";

    @Mock
    private DepartureBoardService departureBoardService;

    private MockMvc mvc;

    private DepartureBoardRestController departureBoardRestController;

    @BeforeEach
    public void setup() {
        initMocks(this);
        departureBoardRestController = new DepartureBoardRestController(departureBoardService);
        mvc = MockMvcBuilders.standaloneSetup(departureBoardRestController).build();
    }

    @Test
    void getDepartureBoard_NullNumRows_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs("RNH");

        // When
        mvcPerformWithJson(DEPARTUREBOARD_URI, asJsonString(getBoardRequest))
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
        mvcPerformWithJson(DEPARTUREBOARD_URI, asJsonString(getBoardRequest))
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
        mvcPerformWithJson(DEPARTUREBOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    void getDepartureBoard_NullCRS_ShouldReturnBadRequest() throws Exception {
        // Given
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setNumRows(5);

        // When
        mvcPerformWithJson(DEPARTUREBOARD_URI, asJsonString(getBoardRequest))
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
        mvcPerformWithJson(DEPARTUREBOARD_URI, asJsonString(getBoardRequest))
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
        mvcPerformWithJson(DEPARTUREBOARD_URI, asJsonString(getBoardRequest))
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
        mvcPerformWithJson(DEPARTUREBOARD_URI, asJsonString(getBoardRequest))
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
        mvcPerformWithJson(DEPARTUREBOARD_URI, asJsonString(getBoardRequest))
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
        mvcPerformWithJson(DEPARTUREBOARD_URI, asJsonString(getBoardRequest))
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
        mvcPerformWithJson(DEPARTUREBOARD_URI, asJsonString(getBoardRequest))
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
        mvcPerformWithJson(DEPARTUREBOARD_URI, asJsonString(getBoardRequest))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(stationBoardResponse)));
    }

    @Test
    void getDepartureBoardWithDetails_ShouldReturnBadRequest() {
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
    void getArrivalBoard_ShouldReturnBadRequest() {
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
    void getArrivalBoardWithDetails_ShouldReturnBadRequest() {
        // Given

        // When

        // Then

    }

    @Test
    void getArrivalDepartureBoard_ShouldReturnBadRequest() {
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
    void getArrivalDepartureBoardWithDetails_ShouldReturnBadRequest() {
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
    void getFastestDepartures_ShouldReturnBadRequest() {
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
    void getFastestDeparturesWithDetails_ShouldReturnBadRequest() {
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
    void getNextDepartures_ShouldReturnBadRequest() {
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
    void getNextDeparturesWithDetails_ShouldReturnBadRequest() {
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
    void getServiceDetails_ShouldReturnBadRequest() {
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