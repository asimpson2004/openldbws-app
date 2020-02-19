package com.andrewsimpson.openldbws.converters.request;


import com.andrewsimpson.openldbws.dto.request.GetServiceDetailsRequest;
import com.thalesgroup.rtti._2017_10_01.ldb.GetServiceDetailsRequestParams;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GetServiceDetailsRequestConverterTest {

    private final String testServiceId = "testServiceId";

    @Test
    void from_ShouldReturnNull() {
        // Given
        final GetServiceDetailsRequest getServiceDetailsRequest = null;
        // When
        GetServiceDetailsRequestParams result = GetServiceDetailsRequestConverter.from(getServiceDetailsRequest);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final GetServiceDetailsRequest getServiceDetailsRequest = new GetServiceDetailsRequest();
        getServiceDetailsRequest.setServiceID(testServiceId);
        // When
        GetServiceDetailsRequestParams result = GetServiceDetailsRequestConverter.from(getServiceDetailsRequest);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getServiceID(), is(equalTo(testServiceId)));
    }

}