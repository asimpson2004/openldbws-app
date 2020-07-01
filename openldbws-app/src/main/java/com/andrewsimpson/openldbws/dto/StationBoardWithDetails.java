package com.andrewsimpson.openldbws.dto;

import java.util.List;

public class StationBoardWithDetails extends StationBoardBase {

    protected List<ServiceWithCallingPoints> trainServices;
    protected List<ServiceWithCallingPoints> busServices;
    protected List<ServiceWithCallingPoints> ferryServices;

    public List<ServiceWithCallingPoints> getTrainServices() {
        return trainServices;
    }

    public void setTrainServices(List<ServiceWithCallingPoints> trainServices) {
        this.trainServices = trainServices;
    }

    public List<ServiceWithCallingPoints> getBusServices() {
        return busServices;
    }

    public void setBusServices(List<ServiceWithCallingPoints> busServices) {
        this.busServices = busServices;
    }

    public List<ServiceWithCallingPoints> getFerryServices() {
        return ferryServices;
    }

    public void setFerryServices(List<ServiceWithCallingPoints> ferryServices) {
        this.ferryServices = ferryServices;
    }

}
