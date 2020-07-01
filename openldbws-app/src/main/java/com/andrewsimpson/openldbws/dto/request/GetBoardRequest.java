package com.andrewsimpson.openldbws.dto.request;

import com.andrewsimpson.openldbws.constraints.groups.BoardRequestGroup;
import com.andrewsimpson.openldbws.constraints.groups.DetailedBoardRequestGroup;
import com.andrewsimpson.openldbws.dto.Filter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class GetBoardRequest {

    @NotNull
    @Min(0)
    @Max(value = 150, groups = BoardRequestGroup.class)
    @Max(value = 10, groups = DetailedBoardRequestGroup.class)
    protected Integer numRows;

    @NotNull
    @Size(max = 3, min = 3)
    protected String crs;
    @Size(max = 3, min = 3)
    protected String filterCrs;

    protected Filter filter;

    @Min(-120)
    @Max(120)
    protected Integer timeOffset;

    @Min(-120)
    @Max(120)
    protected Integer timeWindow;

    public Integer getNumRows() {
        return numRows;
    }

    public void setNumRows(Integer numRows) {
        this.numRows = numRows;
    }

    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    public String getFilterCrs() {
        return filterCrs;
    }

    public void setFilterCrs(String filterCrs) {
        this.filterCrs = filterCrs;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public Integer getTimeOffset() {
        return timeOffset;
    }

    public void setTimeOffset(Integer timeOffset) {
        this.timeOffset = timeOffset;
    }

    public Integer getTimeWindow() {
        return timeWindow;
    }

    public void setTimeWindow(Integer timeWindow) {
        this.timeWindow = timeWindow;
    }

}
