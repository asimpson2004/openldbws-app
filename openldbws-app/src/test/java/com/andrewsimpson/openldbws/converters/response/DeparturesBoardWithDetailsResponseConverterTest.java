package com.andrewsimpson.openldbws.converters.response;

import com.andrewsimpson.openldbws.dto.response.DeparturesBoardWithDetailsResponse;
import com.thalesgroup.rtti._2017_10_01.ldb.DeparturesBoardWithDetailsResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DeparturesBoardWithDetails;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DeparturesBoardWithDetailsResponseConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final DeparturesBoardWithDetailsResponseType departuresBoardWithDetailsResponseType = null;
        // When
        final DeparturesBoardWithDetailsResponse result = DeparturesBoardWithDetailsResponseConverter.from(departuresBoardWithDetailsResponseType);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final DeparturesBoardWithDetailsResponseType departuresBoardWithDetailsResponseType = new DeparturesBoardWithDetailsResponseType();
        departuresBoardWithDetailsResponseType.setDeparturesBoard(new DeparturesBoardWithDetails());
        // When
        final DeparturesBoardWithDetailsResponse result = DeparturesBoardWithDetailsResponseConverter.from(departuresBoardWithDetailsResponseType);
        // Then
        assertThat(result, is(notNullValue()));
    }

}