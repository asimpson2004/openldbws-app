package com.andrewsimpson.openldbws.controllers;

import com.andrewsimpson.openldbws.dto.request.GetBoardRequest;
import com.andrewsimpson.openldbws.dto.request.GetDeparturesRequest;
import com.andrewsimpson.openldbws.dto.request.GetServiceDetailsRequest;
import com.andrewsimpson.openldbws.dto.response.*;
import com.andrewsimpson.openldbws.services.DepartureBoardService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DepartureBoardRestController {

    private DepartureBoardService departureBoardService;

    public DepartureBoardRestController(DepartureBoardService departureBoardService) {
        this.departureBoardService = departureBoardService;
    }

    @GetMapping(value = "/departureBoard", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StationBoardResponse getDepartureBoard(@RequestBody GetBoardRequest getBoardRequest) {
        return departureBoardService.getDepartureBoard(getBoardRequest);
    }

    @GetMapping(value = "/departureBoardWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StationBoardWithDetailsResponse getDepartureBoardWithDetails(@RequestBody GetBoardRequest getBoardRequest) {
        return departureBoardService.getDepartureBoardWithDetails(getBoardRequest);
    }

    @GetMapping(value = "/arrivalBoard", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StationBoardResponse getArrivalBoard(@RequestBody GetBoardRequest getBoardRequest) {
        return departureBoardService.getArrivalBoard(getBoardRequest);
    }

    @GetMapping(value = "/arrivalBoardWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StationBoardWithDetailsResponse getArrivalBoardWithDetails(@RequestBody GetBoardRequest getBoardRequest) {
        return departureBoardService.getArrivalBoardWithDetails(getBoardRequest);
    }

    @GetMapping(value = "/arrivalDepartureBoard", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StationBoardResponse getArrivalDepartureBoard(@RequestBody GetBoardRequest getBoardRequest) {
        return departureBoardService.getArrivalDepartureBoard(getBoardRequest);
    }

    @GetMapping(value = "/arrivalDepartureBoardWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StationBoardWithDetailsResponse getArrivalDepartureBoardWithDetails(@RequestBody GetBoardRequest getBoardRequest) {
        return departureBoardService.getArrivalDepartureBoardWithDetails(getBoardRequest);
    }

    @GetMapping(value = "/fastestDepartures", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DeparturesBoardResponse getFastestDepartures(@RequestBody GetDeparturesRequest getDeparturesRequest) {
        return departureBoardService.getFastestDepartures(getDeparturesRequest);
    }

    @GetMapping(value = "/fastestDeparturesWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DeparturesBoardWithDetailsResponse getFastestDeparturesWithDetails(@RequestBody GetDeparturesRequest getDeparturesRequest) {
        return departureBoardService.getFastestDeparturesWithDetails(getDeparturesRequest);
    }

    @GetMapping(value = "/nextDepartures", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DeparturesBoardResponse getNextDepartures(@RequestBody GetDeparturesRequest getDeparturesRequest) {
        return departureBoardService.getNextDepartures(getDeparturesRequest);
    }

    @GetMapping(value = "/nextDeparturesWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DeparturesBoardWithDetailsResponse getNextDeparturesWithDetails(@RequestBody GetDeparturesRequest getDeparturesRequest) {
        return departureBoardService.getFastestDeparturesWithDetails(getDeparturesRequest);
    }

    @GetMapping(value = "/serviceDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ServiceDetailsResponse getServiceDetails(@RequestBody GetServiceDetailsRequest getServiceDetailsRequest) {
        return departureBoardService.getServiceDetails(getServiceDetailsRequest);
    }
}
