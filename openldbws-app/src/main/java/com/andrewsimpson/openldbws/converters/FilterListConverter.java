package com.andrewsimpson.openldbws.converters;

import com.thalesgroup.rtti._2017_10_01.ldb.GetDeparturesRequestParams;

import java.util.List;

public class FilterListConverter {

    public static GetDeparturesRequestParams.FilterList from(final List<String> source) {

        if(source == null)
            return null;

        GetDeparturesRequestParams.FilterList destination = new GetDeparturesRequestParams.FilterList();
        destination.getCrs().addAll(source);

        return destination;
    }
}
