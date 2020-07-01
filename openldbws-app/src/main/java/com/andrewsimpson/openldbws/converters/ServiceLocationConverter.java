package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceLocation;

public class ServiceLocationConverter {

    public static ServiceLocation from(final com.thalesgroup.rtti._2015_11_27.ldb.types.ServiceLocation source) {

        if(source == null)
            return null;

        ServiceLocation destination = new ServiceLocation();
        destination.setAssocIsCancelled(source.isAssocIsCancelled());
        destination.setCrs(source.getCrs());
        destination.setFutureChangeTo(source.getFutureChangeTo());
        destination.setLocationName(source.getLocationName());
        destination.setVia(source.getVia());

        return destination;
    }

}
