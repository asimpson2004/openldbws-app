package com.andrewsimpson.openldbws.commands;

import java.util.List;

public class StationBoard extends StationBoardBase {

    protected List<Service> trainServices;
    protected List<Service> busServices;
    protected List<Service> ferryServices;

    public List<Service> getTrainServices() {
        return trainServices;
    }

    public void setTrainServices(List<Service> trainServices) {
        this.trainServices = trainServices;
    }

    public List<Service> getBusServices() {
        return busServices;
    }

    public void setBusServices(List<Service> busServices) {
        this.busServices = busServices;
    }

    public List<Service> getFerryServices() {
        return ferryServices;
    }

    public void setFerryServices(List<Service> ferryServices) {
        this.ferryServices = ferryServices;
    }

}
