package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceLocation;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ServiceLocationConverterTest {

    private final String locationName = "locationName";
    private final String crs = "crs";
    private final String futureChangeTo = "futureChangeTo";
    private final String via = "via";
    private final Boolean assocIsCancelled = false;

    @Test
    void from_ShouldReturnNull() {
        // Given
        final com.thalesgroup.rtti._2015_11_27.ldb.types.ServiceLocation serviceLocation = null;
        // When
        ServiceLocation result = ServiceLocationConverter.from(serviceLocation);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final com.thalesgroup.rtti._2015_11_27.ldb.types.ServiceLocation serviceLocation = new com.thalesgroup.rtti._2015_11_27.ldb.types.ServiceLocation();
        serviceLocation.setLocationName(locationName);
        serviceLocation.setAssocIsCancelled(assocIsCancelled);
        serviceLocation.setCrs(crs);
        serviceLocation.setFutureChangeTo(futureChangeTo);
        serviceLocation.setVia(via);
        // When
        ServiceLocation result = ServiceLocationConverter.from(serviceLocation);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getAssocIsCancelled(), is(equalTo(assocIsCancelled)));
        assertThat(result.getCrs(), is(equalTo(crs)));
        assertThat(result.getFutureChangeTo(), is(equalTo(futureChangeTo)));
        assertThat(result.getLocationName(), is(equalTo(locationName)));
        assertThat(result.getVia(), is(equalTo(via)));
    }

}