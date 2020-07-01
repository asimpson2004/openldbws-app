package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.CallingPointList;
import com.andrewsimpson.openldbws.dto.Formation;
import com.andrewsimpson.openldbws.dto.ServiceDetails;

import java.util.List;

public class ServiceDetailsConverter {

    public static ServiceDetails from(final com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceDetails source) {

        if(source == null)
            return null;

        ServiceDetails destination = new ServiceDetails();
        ServiceDetailsBaseConverter.from(source, destination);
        destination.setAdhocAlerts(AdhocAlertsConverter.from(source.getAdhocAlerts()));
        destination.setFormation(FormationConverter.from(source.getFormation()));
        destination.setPreviousCallingPoints(ListOfCallingPointListConverter.from(source.getPreviousCallingPoints()));
        destination.setSubsequentCallingPoints(ListOfCallingPointListConverter.from(source.getSubsequentCallingPoints()));

        return destination;
    }

}
