package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceType;

public class ServiceTypeConverter {

    public static ServiceType from(final com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType source) {

        if(source == null)
            return null;

        switch(source) {
            case TRAIN:
                return ServiceType.TRAIN;
            case BUS:
                return ServiceType.BUS;
            case FERRY:
                return ServiceType.FERRY;
        }

        return null;
    }
}
