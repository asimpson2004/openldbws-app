package com.andrewsimpson.openldbws.converters;

import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfServiceItemsWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.StationBoardWithDetails;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StationBoardWithDetailsConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final StationBoardWithDetails stationBoardWithDetails = null;
        // When
        com.andrewsimpson.openldbws.dto.StationBoardWithDetails result = StationBoardWithDetailsConverter.from(stationBoardWithDetails);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final StationBoardWithDetails stationBoardWithDetails = new StationBoardWithDetails();
        stationBoardWithDetails.setBusServices(new ArrayOfServiceItemsWithCallingPoints());
        stationBoardWithDetails.setFerryServices(new ArrayOfServiceItemsWithCallingPoints());
        stationBoardWithDetails.setTrainServices(new ArrayOfServiceItemsWithCallingPoints());
        // When
        com.andrewsimpson.openldbws.dto.StationBoardWithDetails result = StationBoardWithDetailsConverter.from(stationBoardWithDetails);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getBusServices(), is(notNullValue()));
        assertThat(result.getFerryServices(), is(notNullValue()));
        assertThat(result.getTrainServices(), is(notNullValue()));
    }

}