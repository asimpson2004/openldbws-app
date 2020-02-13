package com.andrewsimpson.openldbws.dto;

public class Departure {
    protected Service service;
    protected String crs;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }
}
