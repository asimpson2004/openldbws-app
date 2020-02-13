package com.andrewsimpson.openldbws.dto;

import java.util.List;

public class ServiceDetails extends ServiceDetailsBase {

    protected List<String> adhocAlerts;
    protected Formation formation;
    protected List<CallingPointList> previousCallingPoints;
    protected List<CallingPointList> subsequentCallingPoints;

    public List<String> getAdhocAlerts() {
        return adhocAlerts;
    }

    public void setAdhocAlerts(List<String> adhocAlerts) {
        this.adhocAlerts = adhocAlerts;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public List<CallingPointList> getPreviousCallingPoints() {
        return previousCallingPoints;
    }

    public void setPreviousCallingPoints(List<CallingPointList> previousCallingPoints) {
        this.previousCallingPoints = previousCallingPoints;
    }

    public List<CallingPointList> getSubsequentCallingPoints() {
        return subsequentCallingPoints;
    }

    public void setSubsequentCallingPoints(List<CallingPointList> subsequentCallingPoints) {
        this.subsequentCallingPoints = subsequentCallingPoints;
    }
}
