package com.andrewsimpson.openldbws.converters.response;

import com.andrewsimpson.openldbws.dto.response.StationBoardResponse;
import com.andrewsimpson.openldbws.dto.response.StationBoardWithDetailsResponse;
import com.thalesgroup.rtti._2017_10_01.ldb.StationBoardResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.StationBoardWithDetailsResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.StationBoardWithDetails;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StationBoardWithDetailsResponseConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final StationBoardWithDetailsResponseType stationBoardWithDetailsResponseType = null;
        // When
        final StationBoardWithDetailsResponse result = StationBoardWithDetailsResponseConverter.from(stationBoardWithDetailsResponseType);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final StationBoardWithDetailsResponseType stationBoardWithDetailsResponseType = new StationBoardWithDetailsResponseType();
        stationBoardWithDetailsResponseType.setGetStationBoardResult(new StationBoardWithDetails());
        // When
        final StationBoardWithDetailsResponse result = StationBoardWithDetailsResponseConverter.from(stationBoardWithDetailsResponseType);
        // Then
        assertThat(result, is(notNullValue()));
    }

}