package com.andrewsimpson.openldbws.dto.request;

import com.andrewsimpson.openldbws.constraints.groups.DeparturesRequestGroup;
import com.andrewsimpson.openldbws.constraints.groups.DetailedDeparturesRequestGroup;
import com.andrewsimpson.openldbws.constraints.groups.FastestDeparturesRequestGroup;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class GetDeparturesRequest {

    @NotNull
    @Size(min = 3, max = 3)
    protected String crs;

    @NotNull
    @Size(min = 1, max = 25, groups = DeparturesRequestGroup.class)
    @Size(min = 1, max = 15, groups = FastestDeparturesRequestGroup.class)
    @Size(min = 1, max = 10, groups = DetailedDeparturesRequestGroup.class)
    protected List<@Size(min = 3, max = 3) String> filterList;

    @Min(-120)
    @Max(120)
    protected Integer timeOffset;

    @Min(-120)
    @Max(120)
    protected Integer timeWindow;

    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    public List<String> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<String> filterList) {
        this.filterList = filterList;
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
