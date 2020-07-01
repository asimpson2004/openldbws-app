package com.andrewsimpson.openldbws.dto;

import java.util.List;

public class Service extends ServiceBase {

    protected Formation formation;

    protected List<ServiceLocation> origin;
    protected List<ServiceLocation> destination;
    protected List<ServiceLocation> currentOrigins;
    protected List<ServiceLocation> currentDestinations;

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public List<ServiceLocation> getOrigin() {
        return origin;
    }

    public void setOrigin(List<ServiceLocation> origin) {
        this.origin = origin;
    }

    public List<ServiceLocation> getDestination() {
        return destination;
    }

    public void setDestination(List<ServiceLocation> destination) {
        this.destination = destination;
    }

    public List<ServiceLocation> getCurrentOrigins() {
        return currentOrigins;
    }

    public void setCurrentOrigins(List<ServiceLocation> currentOrigins) {
        this.currentOrigins = currentOrigins;
    }

    public List<ServiceLocation> getCurrentDestinations() {
        return currentDestinations;
    }

    public void setCurrentDestinations(List<ServiceLocation> currentDestinations) {
        this.currentDestinations = currentDestinations;
    }

}
