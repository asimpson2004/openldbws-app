package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfServiceItemsWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItemWithCallingPoints;

import java.util.ArrayList;
import java.util.List;

public class ServiceWithCallingPointsListConverter {

    public static List<ServiceWithCallingPoints> from(final ArrayOfServiceItemsWithCallingPoints source) {

        if(source == null)
            return null;

        List<ServiceWithCallingPoints> destination = new ArrayList<>();
        for(ServiceItemWithCallingPoints serviceItemWithCallingPoints : source.getService()) {
            destination.add(ServiceWithCallingPointsConverter.from(serviceItemWithCallingPoints));
        }

        return destination;
    }
}
