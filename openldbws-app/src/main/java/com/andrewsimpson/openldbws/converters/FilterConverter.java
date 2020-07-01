package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.Filter;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.FilterType;

public class FilterConverter {

    public static Filter from(FilterType filterType) {

        if(filterType == null)
            return null;

        switch (filterType) {
            case TO:
                return Filter.TO;
            case FROM:
                return Filter.FROM;
        }

        return null;
    }

    public static FilterType from(Filter filter) {

        if(filter == null)
            return null;

        switch (filter) {
            case TO: {
                return FilterType.TO;
            }
            case FROM: {
                return FilterType.FROM;
            }
        }

        return null;
    }

}
