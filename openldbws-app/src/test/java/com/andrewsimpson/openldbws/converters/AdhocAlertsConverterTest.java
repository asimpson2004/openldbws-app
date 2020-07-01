package com.andrewsimpson.openldbws.converters;

import com.thalesgroup.rtti._2012_01_13.ldb.types.ArrayOfAdhocAlert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AdhocAlertsConverterTest {

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ArrayOfAdhocAlert arrayOfAdhocAlert = null;
        // When
        final List<String> result = AdhocAlertsConverter.from(arrayOfAdhocAlert);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        List<String> adHocAlertText = new ArrayList<>();
        adHocAlertText.add("Alert1");
        adHocAlertText.add("Alert2");
        final ArrayOfAdhocAlert arrayOfAdhocAlert = new ArrayOfAdhocAlert();
        arrayOfAdhocAlert.getAdhocAlertText().addAll(adHocAlertText);
        // When
        final List<String> result = AdhocAlertsConverter.from(arrayOfAdhocAlert);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.containsAll(adHocAlertText), is(equalTo(true)));
    }

}