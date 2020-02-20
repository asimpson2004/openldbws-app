package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.StationBoardBase;
import com.thalesgroup.rtti._2015_11_27.ldb.types.BaseStationBoard;

import java.util.logging.Filter;

public class StationBoardBaseConverter {

    public static StationBoardBase from(final BaseStationBoard source) {

        if(source == null)
            return null;

        StationBoardBase destination = new StationBoardBase();
        return from(source, destination);
    }

    public static StationBoardBase from(final BaseStationBoard source, StationBoardBase destination) {

        if(source == null)
            return null;

        destination.setCrs(source.getCrs());
        destination.setFilter(FilterConverter.from(source.getFilterType()));
        destination.setFilterCrs(source.getFiltercrs());
        destination.setFilterLocationName(source.getFilterLocationName());
        destination.setGeneratedAt(source.getGeneratedAt() != null ? source.getGeneratedAt().toGregorianCalendar() : null);
        destination.setLocationName(source.getLocationName());
        destination.setNrccMessages(NrccMessageListConverter.from(source.getNrccMessages()));
        destination.setPlatformAvailable(source.isPlatformAvailable());
        destination.setServicesAvailable(source.isAreServicesAvailable());

        return destination;
    }

}
