package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Formation;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfCoaches;
import com.thalesgroup.rtti._2017_10_01.ldb.types.FormationData;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FormationConverterTest {

    private final Long averageLoading = 100L;

    @Test
    void from_ShouldReturnNull() {
        // Given
        final FormationData formationData = null;
        // When
        Formation result = FormationConverter.from(formationData);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final FormationData formationData = new FormationData();
        formationData.setAvgLoading(averageLoading);
        formationData.setCoaches(new ArrayOfCoaches());
        // When
        Formation result = FormationConverter.from(formationData);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getAverageLoading(), is(equalTo(averageLoading)));
        assertThat(result.getCoaches(), is(notNullValue()));
    }
}