package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Service;
import com.thalesgroup.rtti._2015_11_27.ldb.types.ArrayOfServiceLocations;
import com.thalesgroup.rtti._2017_10_01.ldb.types.FormationData;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ServiceConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ServiceItem serviceItem = null;
        // When
        Service result = ServiceConverter.from(serviceItem);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final ServiceItem serviceItem = new ServiceItem();
        serviceItem.setCurrentDestinations(new ArrayOfServiceLocations());
        serviceItem.setCurrentOrigins(new ArrayOfServiceLocations());
        serviceItem.setDestination(new ArrayOfServiceLocations());
        serviceItem.setFormation(new FormationData());
        serviceItem.setOrigin(new ArrayOfServiceLocations());
        // When
        Service result = ServiceConverter.from(serviceItem);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getCurrentDestinations(), is(notNullValue()));
        assertThat(result.getCurrentOrigins(), is(notNullValue()));
        assertThat(result.getDestination(), is(notNullValue()));
        assertThat(result.getFormation(), is(notNullValue()));
        assertThat(result.getOrigin(), is(notNullValue()));
    }
}