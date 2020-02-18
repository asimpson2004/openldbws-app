package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Coach;
import com.andrewsimpson.openldbws.dto.DepartureBoard;
import com.thalesgroup.rtti._2017_10_01.ldb.types.CoachData;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DeparturesBoard;

public class DepartureBoardConverter {

    public static DepartureBoard from(final DeparturesBoard source) {

        if(source == null)
            return null;

        DepartureBoard destination = new DepartureBoard();
        destination.setCrs(source.getCrs());
        destination.setFilter(FilterConverter.from(source.getFilterType()));
        destination.setDestinations(DepartureListConverter.from(source.getDepartures()));
        destination.setFilterCrs(source.getFiltercrs());
        destination.setFilterLocationName(source.getFilterLocationName());
        destination.setGeneratedAt(source.getGeneratedAt().toGregorianCalendar());
        destination.setLocationName(source.getLocationName());
        destination.setNrccMessages(NrccMessageListConverter.from(source.getNrccMessages()));
        destination.setPlatformAvailable(source.isPlatformAvailable());
        destination.setServicesAvailable(source.isAreServicesAvailable());

        return destination;
    }

}
