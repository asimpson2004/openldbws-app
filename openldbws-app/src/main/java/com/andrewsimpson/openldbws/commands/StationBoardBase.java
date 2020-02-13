package com.andrewsimpson.openldbws.commands;

import java.util.GregorianCalendar;
import java.util.List;

public class StationBoardBase {

    protected GregorianCalendar generatedAt;
    protected String locationName;
    protected String crs;
    protected String filterLocationName;
    protected String filterCrs;
    protected Filter filter;
    protected List<String> nrccMessages;
    protected Boolean platformAvailable;
    protected Boolean servicesAvailable;

    public GregorianCalendar getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(GregorianCalendar generatedAt) {
        this.generatedAt = generatedAt;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    public String getFilterLocationName() {
        return filterLocationName;
    }

    public void setFilterLocationName(String filterLocationName) {
        this.filterLocationName = filterLocationName;
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

    public List<String> getNrccMessages() {
        return nrccMessages;
    }

    public void setNrccMessages(List<String> nrccMessages) {
        this.nrccMessages = nrccMessages;
    }

    public Boolean getPlatformAvailable() {
        return platformAvailable;
    }

    public void setPlatformAvailable(Boolean platformAvailable) {
        this.platformAvailable = platformAvailable;
    }

    public Boolean getServicesAvailable() {
        return servicesAvailable;
    }

    public void setServicesAvailable(Boolean servicesAvailable) {
        this.servicesAvailable = servicesAvailable;
    }
}
