package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.DepartureBoard;
import com.andrewsimpson.openldbws.dto.Filter;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.FilterType;
import com.thalesgroup.rtti._2012_01_13.ldb.types.ArrayOfNRCCMessages;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfDepartureItems;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DeparturesBoard;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DepartureBoardConverterTest {

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
        final DeparturesBoard departuresBoard = null;
        // When
        DepartureBoard result = DepartureBoardConverter.from(departuresBoard);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final DeparturesBoard departuresBoard = new DeparturesBoard();
        departuresBoard.setDepartures(new ArrayOfDepartureItems());
        departuresBoard.setAreServicesAvailable(areServicesAvailable);
        departuresBoard.setCrs(crsValue);
        departuresBoard.setFiltercrs(crsFilter);
        departuresBoard.setFilterLocationName(filterLocationName);
        departuresBoard.setFilterType(FilterType.FROM);
        departuresBoard.setLocationName(locationName);
        departuresBoard.setNrccMessages(arrayOfNRCCMessages);
        departuresBoard.setPlatformAvailable(platformAvailable);
        final XMLGregorianCalendar generatedAt;
        try {
            generatedAt = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
            departuresBoard.setGeneratedAt(generatedAt);
        } catch (DatatypeConfigurationException ex) {}

        // When
        DepartureBoard result = DepartureBoardConverter.from(departuresBoard);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getDestinations(), is(notNullValue()));
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