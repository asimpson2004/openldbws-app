package com.andrewsimpson.openldbws.converters.response;

import com.andrewsimpson.openldbws.dto.response.ServiceDetailsResponse;
import com.thalesgroup.rtti._2017_10_01.ldb.ServiceDetailsResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceDetails;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ServiceDetailsResponseConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ServiceDetailsResponseType serviceDetailsResponseType = null;
        // When
        final ServiceDetailsResponse result = ServiceDetailsResponseConverter.from(serviceDetailsResponseType);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final ServiceDetailsResponseType serviceDetailsResponseType = new ServiceDetailsResponseType();
        serviceDetailsResponseType.setGetServiceDetailsResult(new ServiceDetails());
        // When
        final ServiceDetailsResponse result = ServiceDetailsResponseConverter.from(serviceDetailsResponseType);
        // Then
        assertThat(result, is(notNullValue()));
    }

}