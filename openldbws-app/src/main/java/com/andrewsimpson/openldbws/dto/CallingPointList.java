package com.andrewsimpson.openldbws.dto;

import java.util.List;

public class CallingPointList {

    protected List<CallingPoint> callingPoints;
    protected ServiceType serviceType;
    protected Boolean serviceChangeRequired;
    protected Boolean assocIsCancelled;

    public List<CallingPoint> getCallingPoints() {
        return callingPoints;
    }

    public void setCallingPoints(List<CallingPoint> callingPoints) {
        this.callingPoints = callingPoints;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
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
