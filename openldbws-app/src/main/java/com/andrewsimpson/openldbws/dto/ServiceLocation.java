package com.andrewsimpson.openldbws.dto;

public class ServiceLocation {

    protected String locationName;
    protected String crs;
    protected String via;
    protected String futureChangeTo;
    protected Boolean assocIsCancelled;

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

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getFutureChangeTo() {
        return futureChangeTo;
    }

    public void setFutureChangeTo(String futureChangeTo) {
        this.futureChangeTo = futureChangeTo;
    }

    public Boolean getAssocIsCancelled() {
        return assocIsCancelled;
    }

    public void setAssocIsCancelled(Boolean assocIsCancelled) {
        this.assocIsCancelled = assocIsCancelled;
    }

}
