package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Formation;
import com.andrewsimpson.openldbws.dto.Service;
import com.andrewsimpson.openldbws.dto.ServiceLocation;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;

import java.util.List;

public class ServiceConverter {

    public static Service from(final ServiceItem source) {

        if(source == null)
            return null;

        Service destination = new Service();
        ServiceBaseConverter.from(source, destination);
        destination.setCurrentDestinations(ServiceLocationListConverter.from(source.getCurrentDestinations()));
        destination.setCurrentOrigins(ServiceLocationListConverter.from(source.getCurrentOrigins()));
        destination.setDestination(ServiceLocationListConverter.from(source.getDestination()));
        destination.setFormation(FormationConverter.from(source.getFormation()));
        destination.setOrigin(ServiceLocationListConverter.from(source.getOrigin()));

        return destination;
    }

}
