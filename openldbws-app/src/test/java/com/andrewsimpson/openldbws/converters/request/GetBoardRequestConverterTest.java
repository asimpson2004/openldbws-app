package com.andrewsimpson.openldbws.converters.request;

import com.andrewsimpson.openldbws.dto.Filter;
import com.andrewsimpson.openldbws.dto.request.GetBoardRequest;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.FilterType;
import com.thalesgroup.rtti._2017_10_01.ldb.GetBoardRequestParams;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GetBoardRequestConverterTest {

    private final String testCRS = "CRS";
    private final Integer testTimeWindow = 90;
    private final Integer testTimeOfset = 10;
    private final Integer testNumRows = 5;
    private final String testFilterCRS = "FLTR";
    private final Filter testFilter = Filter.FROM;

    @Test void from_ShouldReturnNull() {
        // Given
        final GetBoardRequest getBoardRequest = null;
        // When
        GetBoardRequestParams result = GetBoardRequestConverter.from(getBoardRequest);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs(testCRS);
        getBoardRequest.setTimeWindow(testTimeWindow);
        getBoardRequest.setTimeOffset(testTimeOfset);
        getBoardRequest.setNumRows(testNumRows);
        getBoardRequest.setFilterCrs(testFilterCRS);
        getBoardRequest.setFilter(testFilter);
        // When
        GetBoardRequestParams result = GetBoardRequestConverter.from(getBoardRequest);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getCrs(), is(equalTo(testCRS)));
        assertThat(result.getTimeWindow(), is(equalTo(testTimeWindow)));
        assertThat(result.getTimeOffset(), is(equalTo(testTimeOfset)));
        assertThat(result.getNumRows(), is(equalTo(testNumRows)));
        assertThat(result.getFilterCrs(), is(equalTo(testFilterCRS)));
        assertThat(result.getFilterType(), is(equalTo(FilterType.FROM)));
    }

    @Test
    void from_ShouldMapMinimumPropertiesCorrectly() {
        // Given
        final GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setCrs(testCRS);
        getBoardRequest.setNumRows(testNumRows);
        // When
        GetBoardRequestParams result = GetBoardRequestConverter.from(getBoardRequest);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getCrs(), is(equalTo(testCRS)));
        assertThat(result.getNumRows(), is(equalTo(testNumRows)));
        assertThat(result.getTimeWindow(), is(nullValue()));
        assertThat(result.getTimeOffset(), is(nullValue()));
        assertThat(result.getFilterCrs(), is(nullValue()));
        assertThat(result.getFilterType(), is(nullValue()));
    }

}