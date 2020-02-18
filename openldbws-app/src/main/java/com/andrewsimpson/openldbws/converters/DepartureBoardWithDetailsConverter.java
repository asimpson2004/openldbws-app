package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.DepartureBoardWithDetails;
import com.andrewsimpson.openldbws.dto.DepartureWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DepartureItemWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.DeparturesBoardWithDetails;

import java.util.ArrayList;
import java.util.List;

public class DepartureBoardWithDetailsConverter {

    public static DepartureBoardWithDetails from(final DeparturesBoardWithDetails source) {

        if(source == null)
            return null;

        DepartureBoardWithDetails destination = new DepartureBoardWithDetails();
        destination.setCrs(source.getCrs());
        destination.setFilter(FilterConverter.from(source.getFilterType()));
        destination.setFilterCrs(source.getFiltercrs());
        destination.setFilterLocationName(source.getFilterLocationName());
        destination.setGeneratedAt(source.getGeneratedAt().toGregorianCalendar());
        destination.setLocationName(source.getLocationName());
        destination.setNrccMessages(NrccMessageListConverter.from(source.getNrccMessages()));
        destination.setPlatformAvailable(source.isPlatformAvailable());
        destination.setServicesAvailable(source.isAreServicesAvailable());

        List<DepartureWithCallingPoints> departureWithCallingPointsList = new ArrayList<>();
        for(DepartureItemWithCallingPoints departureItemWithCallingPoints : source.getDepartures().getDestination()) {
            departureWithCallingPointsList.add(DepartureWithCallingPointsConverter.from(departureItemWithCallingPoints));
        }

        destination.setDepartureWithCallingPoints(departureWithCallingPointsList);
        return destination;
    }

}
