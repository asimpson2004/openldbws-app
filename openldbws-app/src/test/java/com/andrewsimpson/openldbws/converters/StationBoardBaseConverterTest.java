package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Filter;
import com.andrewsimpson.openldbws.dto.StationBoardBase;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.FilterType;
import com.thalesgroup.rtti._2012_01_13.ldb.types.ArrayOfNRCCMessages;
import com.thalesgroup.rtti._2015_11_27.ldb.types.BaseStationBoard;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StationBoardBaseConverterTest {

    private final Boolean areServicesAvailable = true;
    private final String crs = "crs";
    private final String filterCrs = "filterCrs";
    private final String filterLocationName = "filterLocationName";
    private final String locationName = "locationName";
    private final Boolean platformAvailable = true;

    @Test
    void from_ShouldReturnNull() {
        // Given
        final BaseStationBoard baseStationBoard = null;
        // When
        StationBoardBase result1 = StationBoardBaseConverter.from(baseStationBoard);
        StationBoardBase result2 = null;
        StationBoardBaseConverter.from(baseStationBoard, result2);
        // Then
        assertThat(result1, is(nullValue()));
        assertThat(result2, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final BaseStationBoard baseStationBoard = getBaseStationBoard();
        // When
        StationBoardBase result1 = StationBoardBaseConverter.from(baseStationBoard);
        StationBoardBase result2 = new StationBoardBase();
        StationBoardBaseConverter.from(baseStationBoard, result2);
        // Then
        checkResultIsValid(result1);
        checkResultIsValid(result2);
    }

    private void checkResultIsValid(StationBoardBase result) {
        assertThat(result, is(notNullValue()));
        assertThat(result.getCrs(), is(equalTo(crs)));
        assertThat(result.getFilter(), is(equalTo(Filter.FROM)));
        assertThat(result.getFilterCrs(), is(equalTo(filterCrs)));
        assertThat(result.getFilterLocationName(), is(equalTo(filterLocationName)));
        assertThat(result.getGeneratedAt(), is(notNullValue()));
        assertThat(result.getLocationName(), is(equalTo(locationName)));
        assertThat(result.getNrccMessages(), is(notNullValue()));
        assertThat(result.getPlatformAvailable(), is(equalTo(platformAvailable)));
        assertThat(result.getServicesAvailable(), is(equalTo(areServicesAvailable)));
    }

    private BaseStationBoard getBaseStationBoard() {
        final BaseStationBoard baseStationBoard = new BaseStationBoard();
        baseStationBoard.setAreServicesAvailable(areServicesAvailable);
        baseStationBoard.setCrs(crs);
        baseStationBoard.setFiltercrs(filterCrs);
        baseStationBoard.setFilterLocationName(filterLocationName);
        baseStationBoard.setFilterType(FilterType.FROM);
        try {
            final XMLGregorianCalendar generatedAt = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
            baseStationBoard.setGeneratedAt(generatedAt);
        } catch (DatatypeConfigurationException ex) {}
        baseStationBoard.setLocationName(locationName);
        baseStationBoard.setNrccMessages(new ArrayOfNRCCMessages());
        baseStationBoard.setPlatformAvailable(platformAvailable);
        return baseStationBoard;
    }

}