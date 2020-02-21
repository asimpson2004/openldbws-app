package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.DepartureWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DepartureItemWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItemWithCallingPoints;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DepartureWithCallingPointsConverterTest {

    private final String crsValue = "crs";

    @Test
    void from_ShouldReturnNull() {
        // Given
        final DepartureItemWithCallingPoints departureItemWithCallingPoints = null;
        // When
        DepartureWithCallingPoints result = DepartureWithCallingPointsConverter.from(departureItemWithCallingPoints);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final DepartureItemWithCallingPoints departureItemWithCallingPoints = new DepartureItemWithCallingPoints();
        departureItemWithCallingPoints.setCrs(crsValue);
        departureItemWithCallingPoints.setService(new ServiceItemWithCallingPoints());
        // When
        DepartureWithCallingPoints result = DepartureWithCallingPointsConverter.from(departureItemWithCallingPoints);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getCrs(), is(equalTo(crsValue)));
        assertThat(result.getServiceWithCallingPoints(), is(notNullValue()));
    }

}