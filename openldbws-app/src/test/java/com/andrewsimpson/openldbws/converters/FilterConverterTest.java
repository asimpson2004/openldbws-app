package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Filter;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.FilterType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FilterConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final FilterType filterType = null;
        // When
        Filter result = FilterConverter.from(filterType);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapFilterTypeToCorrectly() {
        // Given
        final FilterType filterType = FilterType.TO;
        // When
        Filter result = FilterConverter.from(filterType);
        // Then
        assertThat(result, is(equalTo(Filter.TO)));
    }

    @Test
    void from_ShouldMapFilterTypeFromCorrectly() {
        // Given
        final FilterType filterType = FilterType.FROM;
        // When
        Filter result = FilterConverter.from(filterType);
        // Then
        assertThat(result, is(equalTo(Filter.FROM)));
    }

    @Test
    void from_ShouldMapFilterToCorrectly() {
        // Given
        final Filter filter = Filter.TO;
        // When
        FilterType result = FilterConverter.from(filter);
        // Then
        assertThat(result, is(equalTo(FilterType.TO)));
    }

    @Test
    void from_ShouldMapFilterFromCorrectly() {
        // Given
        final Filter filter = Filter.FROM;
        // When
        FilterType result = FilterConverter.from(filter);
        // Then
        assertThat(result, is(equalTo(FilterType.FROM)));
    }

}