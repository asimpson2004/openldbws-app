package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ToiletAvailability;
import com.thalesgroup.rtti._2017_10_01.ldb.commontypes.ToiletAvailabilityType;
import com.thalesgroup.rtti._2017_10_01.ldb.commontypes.ToiletStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ToiletAvailabilityConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ToiletAvailabilityType toiletAvailabilityType = null;
        // When
        ToiletAvailability result = ToiletAvailabilityConverter.from(toiletAvailabilityType);
        // Then
        assertThat(result,is(nullValue()));
    }

    @Test
    void from_ShouldMapStatusUnknownCorrectly() {
        // Given
        final ToiletAvailabilityType toiletAvailabilityType = new ToiletAvailabilityType();
        toiletAvailabilityType.setStatus(ToiletStatus.UNKNOWN);
        // When
        ToiletAvailability result = ToiletAvailabilityConverter.from(toiletAvailabilityType);
        // Then
        assertThat(result,is(equalTo(ToiletAvailability.UNKNOWN)));
    }

    @Test
    void from_ShouldMapStatusInServiceCorrectly() {
        // Given
        final ToiletAvailabilityType toiletAvailabilityType = new ToiletAvailabilityType();
        toiletAvailabilityType.setStatus(ToiletStatus.IN_SERVICE);
        // When
        ToiletAvailability result = ToiletAvailabilityConverter.from(toiletAvailabilityType);
        // Then
        assertThat(result,is(equalTo(ToiletAvailability.IN_SERVICE)));
    }

    @Test
    void from_ShouldMapStatusNotInServiceCorrectly() {
        // Given
        final ToiletAvailabilityType toiletAvailabilityType = new ToiletAvailabilityType();
        toiletAvailabilityType.setStatus(ToiletStatus.NOT_IN_SERVICE);
        // When
        ToiletAvailability result = ToiletAvailabilityConverter.from(toiletAvailabilityType);
        // Then
        assertThat(result,is(equalTo(ToiletAvailability.NOT_IN_SERVICE)));
    }
}