package com.andrewsimpson.openldbws.converters.request;

import com.andrewsimpson.openldbws.dto.request.GetServiceDetailsRequest;
import com.thalesgroup.rtti._2017_10_01.ldb.GetServiceDetailsRequestParams;

public class GetServiceDetailsRequestConverter {

    public static GetServiceDetailsRequestParams from(final GetServiceDetailsRequest source) {

        if(source == null)
            return null;

        GetServiceDetailsRequestParams destination = new GetServiceDetailsRequestParams();
        destination.setServiceID(source.getServiceID());

        return destination;
    }

}
