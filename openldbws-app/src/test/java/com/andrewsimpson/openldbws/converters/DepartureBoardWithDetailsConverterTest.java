package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.DepartureBoardWithDetails;
import com.andrewsimpson.openldbws.dto.Filter;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.FilterType;
import com.thalesgroup.rtti._2012_01_13.ldb.types.ArrayOfNRCCMessages;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfDepartureItemsWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DeparturesBoardWithDetails;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DepartureBoardWithDetailsConverterTest {

    private final Boolean areServicesAvailable = true;
    private final String crsValue = "crs";
    private final String crsFilter = "fltr";
    private final String filterLocationName = "filterLocation";
    private final String locationName = "location";
    private final ArrayOfNRCCMessages arrayOfNRCCMessages = new ArrayOfNRCCMessages();
    private final Boolean platformAvailable = true;

    @Test
    void from_ShouldReturnNull() {
        // Given
        final DeparturesBoardWithDetails departuresBoardWithDetails = null;
        // When
        DepartureBoardWithDetails result = DepartureBoardWithDetailsConverter.from(departuresBoardWithDetails);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final DeparturesBoardWithDetails departuresBoardWithDetails = new DeparturesBoardWithDetails();
        departuresBoardWithDetails.setDepartures(new ArrayOfDepartureItemsWithCallingPoints());
        departuresBoardWithDetails.setAreServicesAvailable(areServicesAvailable);
        departuresBoardWithDetails.setCrs(crsValue);
        departuresBoardWithDetails.setFiltercrs(crsFilter);
        departuresBoardWithDetails.setFilterLocationName(filterLocationName);
        departuresBoardWithDetails.setFilterType(FilterType.FROM);
        departuresBoardWithDetails.setLocationName(locationName);
        departuresBoardWithDetails.setNrccMessages(arrayOfNRCCMessages);
        departuresBoardWithDetails.setPlatformAvailable(platformAvailable);
        final XMLGregorianCalendar generatedAt;
        try {
            generatedAt = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
            departuresBoardWithDetails.setGeneratedAt(generatedAt);
        } catch (DatatypeConfigurationException ex) {}
        // When
        DepartureBoardWithDetails result = DepartureBoardWithDetailsConverter.from(departuresBoardWithDetails);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getDepartureWithCallingPoints(), is(notNullValue()));
        assertThat(result.getCrs(), is(equalTo(crsValue)));
        assertThat(result.getFilter(), is(equalTo(Filter.FROM)));
        assertThat(result.getFilterCrs(), is(equalTo(crsFilter)));
        assertThat(result.getFilterLocationName(), is(equalTo(filterLocationName)));
        assertThat(result.getGeneratedAt(), is(notNullValue()));
        assertThat(result.getLocationName(), is(equalTo(locationName)));
        assertThat(result.getNrccMessages(), is(notNullValue()));
        assertThat(result.getPlatformAvailable(), is(equalTo(platformAvailable)));
        assertThat(result.getServicesAvailable(), is(equalTo(areServicesAvailable)));
    }
}