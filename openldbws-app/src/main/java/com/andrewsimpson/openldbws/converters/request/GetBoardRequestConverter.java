package com.andrewsimpson.openldbws.converters.request;

import com.andrewsimpson.openldbws.converters.FilterConverter;
import com.andrewsimpson.openldbws.dto.request.GetBoardRequest;
import com.thalesgroup.rtti._2017_10_01.ldb.GetBoardRequestParams;

public class GetBoardRequestConverter {

    public static GetBoardRequestParams from(GetBoardRequest source) {

        GetBoardRequestParams destination = new GetBoardRequestParams();
        destination.setCrs(source.getCrs());
        destination.setFilterCrs(source.getFilterCrs());
        destination.setTimeOffset(source.getTimeOffset());
        destination.setTimeWindow(source.getTimeWindow());

        if(null != source.getFilter()) {
            destination.setFilterType(FilterConverter.from(source.getFilter()));
        }

        if(null != source.getNumRows()) {
            destination.setNumRows(source.getNumRows());
        }

        return destination;
    }
}
