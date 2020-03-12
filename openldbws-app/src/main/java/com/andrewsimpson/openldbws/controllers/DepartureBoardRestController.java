package com.andrewsimpson.openldbws.controllers;

import com.andrewsimpson.openldbws.constraints.groups.*;
import com.andrewsimpson.openldbws.dto.request.GetBoardRequest;
import com.andrewsimpson.openldbws.dto.request.GetDeparturesRequest;
import com.andrewsimpson.openldbws.dto.request.GetServiceDetailsRequest;
import com.andrewsimpson.openldbws.services.DepartureBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity getDepartureBoard(@Validated(BoardRequestGroup.class) @RequestBody GetBoardRequest getBoardRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());

        return ResponseEntity.ok().body(departureBoardService.getDepartureBoard(getBoardRequest));
    }

    @GetMapping(value = "/departureBoardWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getDepartureBoardWithDetails(@Validated(DetailedBoardRequestGroup.class) @RequestBody GetBoardRequest getBoardRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());

        return ResponseEntity.ok().body(departureBoardService.getDepartureBoardWithDetails(getBoardRequest));
    }

    @GetMapping(value = "/arrivalBoard", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getArrivalBoard(@Validated(BoardRequestGroup.class) @RequestBody GetBoardRequest getBoardRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());

        return ResponseEntity.ok().body(departureBoardService.getArrivalBoard(getBoardRequest));
    }

    @GetMapping(value = "/arrivalBoardWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getArrivalBoardWithDetails(@Validated(DetailedBoardRequestGroup.class) @RequestBody GetBoardRequest getBoardRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());

        return ResponseEntity.ok().body(departureBoardService.getArrivalBoardWithDetails(getBoardRequest));
    }

    @GetMapping(value = "/arrivalDepartureBoard", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getArrivalDepartureBoard(@Validated(BoardRequestGroup.class) @RequestBody GetBoardRequest getBoardRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());

        return ResponseEntity.ok().body(departureBoardService.getArrivalDepartureBoard(getBoardRequest));
    }

    @GetMapping(value = "/arrivalDepartureBoardWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getArrivalDepartureBoardWithDetails(@Validated(DetailedBoardRequestGroup.class) @RequestBody GetBoardRequest getBoardRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());

        return ResponseEntity.ok().body(departureBoardService.getArrivalDepartureBoardWithDetails(getBoardRequest));
    }

    @GetMapping(value = "/fastestDepartures", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getFastestDepartures(@Validated(FastestDeparturesRequestGroup.class) @RequestBody GetDeparturesRequest getDeparturesRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());

        return ResponseEntity.ok().body(departureBoardService.getFastestDepartures(getDeparturesRequest));
    }

    @GetMapping(value = "/fastestDeparturesWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getFastestDeparturesWithDetails(@Validated(DetailedDeparturesRequestGroup.class) @RequestBody GetDeparturesRequest getDeparturesRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());

        return ResponseEntity.ok().body(departureBoardService.getFastestDeparturesWithDetails(getDeparturesRequest));
    }

    @GetMapping(value = "/nextDepartures", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getNextDepartures(@Validated(DeparturesRequestGroup.class) @RequestBody GetDeparturesRequest getDeparturesRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());

        return ResponseEntity.ok().body(departureBoardService.getNextDepartures(getDeparturesRequest));
    }

    @GetMapping(value = "/nextDeparturesWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getNextDeparturesWithDetails(@Validated(DetailedDeparturesRequestGroup.class) @RequestBody GetDeparturesRequest getDeparturesRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());

        return ResponseEntity.ok().body(departureBoardService.getNextDeparturesWithDetails(getDeparturesRequest));
    }

    @GetMapping(value = "/serviceDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getServiceDetails(@Validated @RequestBody GetServiceDetailsRequest getServiceDetailsRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());

        return ResponseEntity.ok().body(departureBoardService.getServiceDetails(getServiceDetailsRequest));
    }

}
