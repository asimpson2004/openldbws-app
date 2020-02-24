package com.andrewsimpson.openldbws.converters;

import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfServiceItems;
import com.thalesgroup.rtti._2017_10_01.ldb.types.StationBoard;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StationBoardConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final StationBoard stationBoard = null;
        // When
        com.andrewsimpson.openldbws.dto.StationBoard result = StationBoardConverter.from(stationBoard);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final StationBoard stationBoard = new StationBoard();
        stationBoard.setBusServices(new ArrayOfServiceItems());
        stationBoard.setFerryServices(new ArrayOfServiceItems());
        stationBoard.setTrainServices(new ArrayOfServiceItems());
        // When
        com.andrewsimpson.openldbws.dto.StationBoard result = StationBoardConverter.from(stationBoard);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getBusServices(), is(notNullValue()));
        assertThat(result.getFerryServices(), is(notNullValue()));
        assertThat(result.getTrainServices(), is(notNullValue()));
    }

}