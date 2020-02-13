package com.andrewsimpson.openldbws.dto;

public class DepartureWithCallingPoints {

    protected ServiceWithCallingPoints serviceWithCallingPoints;
    protected String crs;

    public ServiceWithCallingPoints getServiceWithCallingPoints() {
        return serviceWithCallingPoints;
    }

    public void setServiceWithCallingPoints(ServiceWithCallingPoints serviceWithCallingPoints) {
        this.serviceWithCallingPoints = serviceWithCallingPoints;
    }

    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }
}
