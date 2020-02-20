package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.CallingPoint;
import com.thalesgroup.rtti._2012_01_13.ldb.types.ArrayOfAdhocAlert;
import com.thalesgroup.rtti._2017_10_01.ldb.types.FormationData;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CallingPointConverterTest {

    private final ArrayOfAdhocAlert arrayOfAdhocAlert = new ArrayOfAdhocAlert();
    private final String atValue = "at";
    private final String crsValue = "CRS";
    private final Boolean detachFront = true;
    private final String etValue = "et";
    private final FormationData formationData = new FormationData();
    private final Boolean isCancelled = false;
    private final Integer lengthValue = 4;
    private final String locationNameValue = "location";
    private final String stValue = "st";

    @Test
    void from_ShouldReturnNull() {
        // Given
        final com.thalesgroup.rtti._2017_10_01.ldb.types.CallingPoint callingPoint = null;
        // When
        final CallingPoint result = CallingPointConverter.from(callingPoint);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllParametersCorrectly() {

        // Given
        final com.thalesgroup.rtti._2017_10_01.ldb.types.CallingPoint callingPoint = new com.thalesgroup.rtti._2017_10_01.ldb.types.CallingPoint();
        callingPoint.setAdhocAlerts(arrayOfAdhocAlert);
        callingPoint.setAt(atValue);
        callingPoint.setCrs(crsValue);
        callingPoint.setDetachFront(detachFront);
        callingPoint.setEt(etValue);
        callingPoint.setFormation(formationData);
        callingPoint.setIsCancelled(isCancelled);
        callingPoint.setLength(lengthValue);
        callingPoint.setLocationName(locationNameValue);
        callingPoint.setSt(stValue);
        // When
        final CallingPoint result = CallingPointConverter.from(callingPoint);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getAdhocAlerts(), is(notNullValue()));
        assertThat(result.getAt(), is(equalTo(atValue)));
        assertThat(result.getCrs(), is(equalTo(crsValue)));
        assertThat(result.getDetatchFront(), is(equalTo(detachFront)));
        assertThat(result.getEt(), is(equalTo(etValue)));
        assertThat(result.getFormation(), is(notNullValue()));
        assertThat(result.getCancelled(), is(equalTo(isCancelled)));
        assertThat(result.getLength(), is(equalTo(lengthValue)));
        assertThat(result.getLocationName(), is(equalTo(locationNameValue)));
        assertThat(result.getSt(), is(equalTo(stValue)));
    }

}