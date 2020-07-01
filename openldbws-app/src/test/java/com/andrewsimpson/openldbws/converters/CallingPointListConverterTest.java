package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.CallingPointList;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.CallingPoint;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CallingPointListConverterTest {

    private final List<CallingPoint> callingPoints = new ArrayList<>();
    private final Boolean assocIsCancelled = true;
    private final Boolean serviceChangeRequired = false;
    private final ServiceType serviceType = ServiceType.TRAIN;

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ArrayOfCallingPoints arrayOfCallingPoints = null;
        // When
        final CallingPointList result = CallingPointListConverter.from(arrayOfCallingPoints);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        callingPoints.add(new CallingPoint());
        callingPoints.add(new CallingPoint());
        final ArrayOfCallingPoints arrayOfCallingPoints = new ArrayOfCallingPoints();
        arrayOfCallingPoints.setAssocIsCancelled(assocIsCancelled);
        arrayOfCallingPoints.setServiceChangeRequired(serviceChangeRequired);
        arrayOfCallingPoints.setServiceType(serviceType);
        arrayOfCallingPoints.getCallingPoint().addAll(callingPoints);
        // When
        final CallingPointList result = CallingPointListConverter.from(arrayOfCallingPoints);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getAssocIsCancelled(), is(equalTo(assocIsCancelled)));
        assertThat(result.getServiceChangeRequired(), is(equalTo(serviceChangeRequired)));
        assertThat(result.getServiceType(), is(equalTo(com.andrewsimpson.openldbws.dto.ServiceType.TRAIN)));
        assertThat(result.getCallingPoints(), is(notNullValue()));
        assertThat(result.getCallingPoints().size(), is(equalTo(callingPoints.size())));
    }

}