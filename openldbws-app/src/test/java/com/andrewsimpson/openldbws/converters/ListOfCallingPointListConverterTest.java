package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.CallingPointList;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfArrayOfCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfCallingPoints;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ListOfCallingPointListConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ArrayOfArrayOfCallingPoints arrayOfArrayOfCallingPoints = null;
        // When
        List<CallingPointList> result = ListOfCallingPointListConverter.from(arrayOfArrayOfCallingPoints);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final ArrayOfArrayOfCallingPoints arrayOfArrayOfCallingPoints = new ArrayOfArrayOfCallingPoints();
        arrayOfArrayOfCallingPoints.getCallingPointList().add(new ArrayOfCallingPoints());
        arrayOfArrayOfCallingPoints.getCallingPointList().add(new ArrayOfCallingPoints());
        // When
        List<CallingPointList> result = ListOfCallingPointListConverter.from(arrayOfArrayOfCallingPoints);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(equalTo(2)));
    }
}