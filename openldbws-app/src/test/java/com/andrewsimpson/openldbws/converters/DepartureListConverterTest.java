package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Departure;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfDepartureItems;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DepartureItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DepartureListConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ArrayOfDepartureItems arrayOfDepartureItems = null;
        // When
        List<Departure> result = DepartureListConverter.from(arrayOfDepartureItems);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final ArrayOfDepartureItems arrayOfDepartureItems = new ArrayOfDepartureItems();
        arrayOfDepartureItems.getDestination().add(new DepartureItem());
        arrayOfDepartureItems.getDestination().add(new DepartureItem());
        arrayOfDepartureItems.getDestination().add(new DepartureItem());
        // When
        List<Departure> result = DepartureListConverter.from(arrayOfDepartureItems);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(equalTo(3)));
    }
}