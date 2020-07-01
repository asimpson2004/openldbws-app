package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Departure;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DepartureItem;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DepartureConverterTest {

    private final String crsValue = "CRS";

    @Test
    void from_ShouldReturnNull() {
        // Given
        final DepartureItem departureItem = null;
        // When
        Departure result = DepartureConverter.from(departureItem);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final DepartureItem departureItem = new DepartureItem();
        departureItem.setCrs(crsValue);
        departureItem.setService(new ServiceItem());
        // When
        Departure result = DepartureConverter.from(departureItem);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getCrs(), is(equalTo(crsValue)));
        assertThat(result.getService(), is(notNullValue()));
    }
}