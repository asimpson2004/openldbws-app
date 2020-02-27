package com.andrewsimpson.openldbws.dto.request;

import javax.validation.constraints.NotNull;

public class GetServiceDetailsRequest {

    @NotNull
    protected String serviceID;

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

}
