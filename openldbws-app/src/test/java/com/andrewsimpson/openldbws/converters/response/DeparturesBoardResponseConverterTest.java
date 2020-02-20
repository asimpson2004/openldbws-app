package com.andrewsimpson.openldbws.converters.response;

import com.andrewsimpson.openldbws.dto.response.DeparturesBoardResponse;
import com.thalesgroup.rtti._2017_10_01.ldb.DeparturesBoardResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DeparturesBoard;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DeparturesBoardResponseConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final DeparturesBoardResponseType departuresBoardResponseType = null;
        // When
        final DeparturesBoardResponse result = DeparturesBoardResponseConverter.from(departuresBoardResponseType);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final DeparturesBoardResponseType departuresBoardResponseType = new DeparturesBoardResponseType();
        departuresBoardResponseType.setDeparturesBoard(new DeparturesBoard());
        // When
        final DeparturesBoardResponse result = DeparturesBoardResponseConverter.from(departuresBoardResponseType);
        // Then
        assertThat(result, is(notNullValue()));
    }

}