package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfServiceItemsWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItemWithCallingPoints;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ServiceWithCallingPointsListConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ArrayOfServiceItemsWithCallingPoints arrayOfServiceItemsWithCallingPoints = null;
        // When
        List<ServiceWithCallingPoints> result = ServiceWithCallingPointsListConverter.from(arrayOfServiceItemsWithCallingPoints);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final ArrayOfServiceItemsWithCallingPoints arrayOfServiceItemsWithCallingPoints = new ArrayOfServiceItemsWithCallingPoints();
        arrayOfServiceItemsWithCallingPoints.getService().add(new ServiceItemWithCallingPoints());
        arrayOfServiceItemsWithCallingPoints.getService().add(new ServiceItemWithCallingPoints());
        arrayOfServiceItemsWithCallingPoints.getService().add(new ServiceItemWithCallingPoints());
        // When
        List<ServiceWithCallingPoints> result = ServiceWithCallingPointsListConverter.from(arrayOfServiceItemsWithCallingPoints);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(equalTo(3)));
    }

}