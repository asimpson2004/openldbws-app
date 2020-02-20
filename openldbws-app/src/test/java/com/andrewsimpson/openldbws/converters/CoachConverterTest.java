package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Coach;
import com.andrewsimpson.openldbws.dto.ToiletAvailability;
import com.thalesgroup.rtti._2017_10_01.ldb.commontypes.ToiletAvailabilityType;
import com.thalesgroup.rtti._2017_10_01.ldb.commontypes.ToiletStatus;
import com.thalesgroup.rtti._2017_10_01.ldb.types.CoachData;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CoachConverterTest {

    private final String coachClass = "class";
    private final Long loading = 1234L;
    private final String number = "X1234";
    private final ToiletAvailabilityType toiletAvailabilityType = new ToiletAvailabilityType();

    @Test
    void from_ShouldReturnNull() {
        // Given
        final CoachData coachData = null;
        // When
        Coach result = CoachConverter.from(coachData);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        toiletAvailabilityType.setStatus(ToiletStatus.IN_SERVICE);
        final CoachData coachData = new CoachData();
        coachData.setCoachClass(coachClass);
        coachData.setLoading(loading);
        coachData.setNumber(number);
        coachData.setToilet(toiletAvailabilityType);
        // When
        Coach result = CoachConverter.from(coachData);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getCoachClass(), is(equalTo(coachClass)));
        assertThat(result.getLoading(), is(equalTo(loading)));
        assertThat(result.getNumber(), is(equalTo(number)));
        assertThat(result.getToiletAvailability(), is(equalTo(ToiletAvailability.IN_SERVICE)));
    }
}