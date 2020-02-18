package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceLocation;
import com.thalesgroup.rtti._2015_11_27.ldb.types.ArrayOfServiceLocations;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfServiceItems;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;

import java.util.ArrayList;
import java.util.List;

public class ServiceLocationListConverter {

    public static List<ServiceLocation> from(final ArrayOfServiceLocations source) {

        if(source == null)
            return null;

        List<ServiceLocation> destination = new ArrayList<>();
        for(com.thalesgroup.rtti._2015_11_27.ldb.types.ServiceLocation serviceLocation : source.getLocation()) {
            destination.add(ServiceLocationConverter.from(serviceLocation));
        }

        return  destination;
    }
}
