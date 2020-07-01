package com.andrewsimpson.openldbws.converters.request;

import com.andrewsimpson.openldbws.dto.Filter;
import com.andrewsimpson.openldbws.dto.request.GetDeparturesRequest;
import com.thalesgroup.rtti._2017_10_01.ldb.GetDeparturesRequestParams;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GetDeparturesRequestConverterTest {

    private final String testCRS = "CRS";
    private final Integer testTimeOffset = 15;
    private final Integer testTimeWindow = 45;

    @Test
    void from_ShouldReturnNull() {
        // Given
        final GetDeparturesRequest getDeparturesRequest = null;
        // When
        GetDeparturesRequestParams result = GetDeparturesRequestConverter.from(getDeparturesRequest);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final List<String> testFilterList = createTestFilterList();
        final GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs(testCRS);
        getDeparturesRequest.setFilterList(testFilterList);
        getDeparturesRequest.setTimeOffset(testTimeOffset);
        getDeparturesRequest.setTimeWindow(testTimeWindow);
        // When
        GetDeparturesRequestParams result = GetDeparturesRequestConverter.from(getDeparturesRequest);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getCrs(), is(equalTo(testCRS)));
        assertThat(result.getTimeOffset(), is(equalTo(testTimeOffset)));
        assertThat(result.getTimeWindow(), is(equalTo(testTimeWindow)));
        assertThat(result.getFilterList(), is(notNullValue()));
        assertThat(result.getFilterList().getCrs(), is(notNullValue()));
        assertThat(result.getFilterList().getCrs().containsAll(testFilterList), is(equalTo(true)));
    }

    @Test
    void from_ShouldMapMinimumPropertiesCorrectly() {
        // Given
        final List<String> testFilterList = createTestFilterList();
        final GetDeparturesRequest getDeparturesRequest = new GetDeparturesRequest();
        getDeparturesRequest.setCrs(testCRS);
        getDeparturesRequest.setFilterList(testFilterList);
        // When
        GetDeparturesRequestParams result = GetDeparturesRequestConverter.from(getDeparturesRequest);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getCrs(), is(equalTo(testCRS)));
        assertThat(result.getTimeOffset(), is(nullValue()));
        assertThat(result.getTimeWindow(), is(nullValue()));
        assertThat(result.getFilterList(), is(notNullValue()));
        assertThat(result.getFilterList().getCrs(), is(notNullValue()));
        assertThat(result.getFilterList().getCrs().containsAll(testFilterList), is(equalTo(true)));
    }

    private List<String> createTestFilterList() {
        final List<String> testFilterList = new ArrayList<>();
        testFilterList.add("FLTR1");
        testFilterList.add("FLTR2");
        return testFilterList;
    }
}