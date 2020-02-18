package com.andrewsimpson.openldbws.converters.response;

import com.andrewsimpson.openldbws.converters.ServiceDetailsConverter;
import com.andrewsimpson.openldbws.dto.response.ServiceDetailsResponse;
import com.thalesgroup.rtti._2017_10_01.ldb.ServiceDetailsResponseType;

public class ServiceDetailsResponseConverter {

    public static ServiceDetailsResponse from(final ServiceDetailsResponseType source) {

        ServiceDetailsResponse destination = new ServiceDetailsResponse();
        destination.setServiceDetails(ServiceDetailsConverter.from(source.getGetServiceDetailsResult()));
        return destination;
    }

}
