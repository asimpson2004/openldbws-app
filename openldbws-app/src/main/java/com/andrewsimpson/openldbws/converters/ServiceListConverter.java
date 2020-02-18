package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Service;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfServiceItems;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;

import java.util.ArrayList;
import java.util.List;

public class ServiceListConverter {

    public static List<Service> from(final ArrayOfServiceItems source) {

        if(source == null)
            return null;

        List<Service> destination = new ArrayList<>();
        for(ServiceItem serviceItem : source.getService()) {
            destination.add(ServiceConverter.from(serviceItem));
        }

        return destination;
    }
}
