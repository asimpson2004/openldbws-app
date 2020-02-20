package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Coach;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfCoaches;
import com.thalesgroup.rtti._2017_10_01.ldb.types.CoachData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CoachListConverterTest {

    private final List<CoachData> coachData = new ArrayList<>();

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ArrayOfCoaches arrayOfCoaches = null;
        // When
        List<Coach> result = CoachListConverter.from(arrayOfCoaches);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllParametersCorrectly() {
        // Given
        coachData.add(new CoachData());
        coachData.add(new CoachData());
        final ArrayOfCoaches arrayOfCoaches = new ArrayOfCoaches();
        arrayOfCoaches.getCoach().addAll(coachData);
        // When
        List<Coach> result = CoachListConverter.from(arrayOfCoaches);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(equalTo(coachData.size())));
    }

}