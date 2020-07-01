package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceDetails;
import com.thalesgroup.rtti._2012_01_13.ldb.types.ArrayOfAdhocAlert;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfArrayOfCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.FormationData;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class ServiceDetailsConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceDetails serviceDetails = null;
        // When
        ServiceDetails result = ServiceDetailsConverter.from(serviceDetails);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceDetails serviceDetails = new com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceDetails();
        serviceDetails.setAdhocAlerts(new ArrayOfAdhocAlert());
        serviceDetails.setFormation(new FormationData());
        serviceDetails.setPreviousCallingPoints(new ArrayOfArrayOfCallingPoints());
        serviceDetails.setSubsequentCallingPoints(new ArrayOfArrayOfCallingPoints());
        // When
        final ServiceDetails result = ServiceDetailsConverter.from(serviceDetails);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getAdhocAlerts(), is(notNullValue()));
        assertThat(result.getFormation(), is(notNullValue()));
        assertThat(result.getPreviousCallingPoints(), is(notNullValue()));
        assertThat(result.getSubsequentCallingPoints(), is(notNullValue()));
    }
}