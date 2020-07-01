package com.andrewsimpson.openldbws.converters.request;

import com.andrewsimpson.openldbws.converters.FilterListConverter;
import com.andrewsimpson.openldbws.dto.request.GetDeparturesRequest;
import com.thalesgroup.rtti._2017_10_01.ldb.GetDeparturesRequestParams;

public class GetDeparturesRequestConverter {

    public static GetDeparturesRequestParams from(final GetDeparturesRequest source) {

        if(source == null)
            return null;

        GetDeparturesRequestParams destination = new GetDeparturesRequestParams();
        destination.setCrs(source.getCrs());
        destination.setFilterList(FilterListConverter.from(source.getFilterList()));
        destination.setTimeOffset(source.getTimeOffset());
        destination.setTimeWindow(source.getTimeWindow());

        return destination;
    }
}
