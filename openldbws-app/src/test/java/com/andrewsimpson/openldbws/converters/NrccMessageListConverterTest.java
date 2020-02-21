package com.andrewsimpson.openldbws.converters;

import com.thalesgroup.rtti._2012_01_13.ldb.types.ArrayOfNRCCMessages;
import com.thalesgroup.rtti._2012_01_13.ldb.types.NRCCMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class NrccMessageListConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ArrayOfNRCCMessages arrayOfNRCCMessages = null;
        // When
        List<String> result = NrccMessageListConverter.from(arrayOfNRCCMessages);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final ArrayOfNRCCMessages arrayOfNRCCMessages = new ArrayOfNRCCMessages();
        arrayOfNRCCMessages.getMessage().add(new NRCCMessage());
        arrayOfNRCCMessages.getMessage().add(new NRCCMessage());
        arrayOfNRCCMessages.getMessage().add(new NRCCMessage());
        // When
        List<String> result = NrccMessageListConverter.from(arrayOfNRCCMessages);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(equalTo(3)));
    }
}