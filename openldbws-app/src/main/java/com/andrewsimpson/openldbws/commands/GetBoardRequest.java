package com.andrewsimpson.openldbws.commands;

public class GetBoardRequest {

    protected Integer numRows;
    protected String crs;
    protected String filterCrs;
    protected Filter filter;
    protected Integer timeOffset;
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
