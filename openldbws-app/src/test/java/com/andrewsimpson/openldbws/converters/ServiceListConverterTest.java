package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Service;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfServiceItems;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ServiceListConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ArrayOfServiceItems arrayOfServiceItems = null;
        // When
        List<Service> result = ServiceListConverter.from(arrayOfServiceItems);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final ArrayOfServiceItems arrayOfServiceItems = new ArrayOfServiceItems();
        arrayOfServiceItems.getService().add(new ServiceItem());
        arrayOfServiceItems.getService().add(new ServiceItem());
        arrayOfServiceItems.getService().add(new ServiceItem());
        // When
        List<Service> result = ServiceListConverter.from(arrayOfServiceItems);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(equalTo(3)));
    }

}