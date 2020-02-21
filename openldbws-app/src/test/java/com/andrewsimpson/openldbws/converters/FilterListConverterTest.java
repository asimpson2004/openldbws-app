package com.andrewsimpson.openldbws.converters;

import com.thalesgroup.rtti._2017_10_01.ldb.GetDeparturesRequestParams;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FilterListConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final List<String> filterList = null;
        // When
        GetDeparturesRequestParams.FilterList result = FilterListConverter.from(filterList);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final List<String> filterList = new ArrayList<>();
        filterList.add("FLTR1");
        filterList.add("FLTR2");
        // When
        GetDeparturesRequestParams.FilterList result = FilterListConverter.from(filterList);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getCrs(), is(notNullValue()));
        assertThat(result.getCrs().containsAll(filterList), is(equalTo(true)));
    }
}