package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceLocation;
import com.thalesgroup.rtti._2015_11_27.ldb.types.ArrayOfServiceLocations;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ServiceLocationListConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ArrayOfServiceLocations arrayOfServiceLocations = null;
        // When
        List<ServiceLocation> result = ServiceLocationListConverter.from(arrayOfServiceLocations);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final ArrayOfServiceLocations arrayOfServiceLocations = new ArrayOfServiceLocations();
        arrayOfServiceLocations.getLocation().add(new com.thalesgroup.rtti._2015_11_27.ldb.types.ServiceLocation());
        arrayOfServiceLocations.getLocation().add(new com.thalesgroup.rtti._2015_11_27.ldb.types.ServiceLocation());
        // When
        List<ServiceLocation> result = ServiceLocationListConverter.from(arrayOfServiceLocations);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(equalTo(2)));
    }
}