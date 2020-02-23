package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ServiceTypeConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType serviceType = null;
        // When
        ServiceType result = ServiceTypeConverter.from(serviceType);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapTrainCorrectly() {
        // Given
        final com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType serviceType = com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType.TRAIN;
        // When
        ServiceType result = ServiceTypeConverter.from(serviceType);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(ServiceType.TRAIN)));
    }

    @Test
    void from_ShouldMapBusCorrectly() {
        // Given
        final com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType serviceType = com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType.BUS;
        // When
        ServiceType result = ServiceTypeConverter.from(serviceType);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(ServiceType.BUS)));
    }

    @Test
    void from_ShouldMapFerryCorrectly() {
        // Given
        final com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType serviceType = com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType.FERRY;
        // When
        ServiceType result = ServiceTypeConverter.from(serviceType);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(ServiceType.FERRY)));
    }

}