package com.andrewsimpson.openldbws.dto;

import java.util.List;

public class CallingPointList {

    protected List<CallingPoint> callingPoints;
    protected Service service;
    protected Boolean serviceChangeRequired;
    protected Boolean assocIsCancelled;

    public List<CallingPoint> getCallingPoints() {
        return callingPoints;
    }

    public void setCallingPoints(List<CallingPoint> callingPoints) {
        this.callingPoints = callingPoints;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Boolean getServiceChangeRequired() {
        return serviceChangeRequired;
    }

    public void setServiceChangeRequired(Boolean serviceChangeRequired) {
        this.serviceChangeRequired = serviceChangeRequired;
    }

    public Boolean getAssocIsCancelled() {
        return assocIsCancelled;
    }

    public void setAssocIsCancelled(Boolean assocIsCancelled) {
        this.assocIsCancelled = assocIsCancelled;
    }
}
