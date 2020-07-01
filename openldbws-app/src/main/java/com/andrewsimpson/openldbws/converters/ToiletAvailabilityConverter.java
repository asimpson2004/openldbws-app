package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ToiletAvailability;
import com.thalesgroup.rtti._2017_10_01.ldb.commontypes.ToiletAvailabilityType;

public class ToiletAvailabilityConverter {

    public static ToiletAvailability from(ToiletAvailabilityType toiletAvailabilityType) {

        if(toiletAvailabilityType == null)
            return null;

        switch (toiletAvailabilityType.getStatus()) {
            case UNKNOWN:
                return ToiletAvailability.UNKNOWN;
            case IN_SERVICE:
                return ToiletAvailability.IN_SERVICE;
            case NOT_IN_SERVICE:
                return ToiletAvailability.NOT_IN_SERVICE;
        }

        return null;
    }

}
