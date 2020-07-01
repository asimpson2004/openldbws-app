package com.andrewsimpson.openldbws.converters.response;

import com.andrewsimpson.openldbws.dto.response.StationBoardResponse;
import com.thalesgroup.rtti._2017_10_01.ldb.StationBoardResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.StationBoard;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StationBoardResponseConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final StationBoardResponseType stationBoardResponseType = null;
        // When
        final StationBoardResponse result = StationBoardResponseConverter.from(stationBoardResponseType);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final StationBoardResponseType stationBoardResponseType = new StationBoardResponseType();
        stationBoardResponseType.setGetStationBoardResult(new StationBoard());
        // When
        final StationBoardResponse result = StationBoardResponseConverter.from(stationBoardResponseType);
        // Then
        assertThat(result, is(notNullValue()));
    }

}