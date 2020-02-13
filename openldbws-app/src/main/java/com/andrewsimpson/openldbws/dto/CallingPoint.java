package com.andrewsimpson.openldbws.dto;


import java.util.List;

public class CallingPoint {

    protected String locationName;
    protected String crs;
    protected String st;
    protected String et;
    protected String at;
    protected Boolean cancelled;
    protected Integer length;
    protected Boolean detatchFront;
    protected Formation formation;
    protected List<String> adhocAlerts;

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

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getDetatchFront() {
        return detatchFront;
    }

    public void setDetatchFront(Boolean detatchFront) {
        this.detatchFront = detatchFront;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public List<String> getAdhocAlerts() {
        return adhocAlerts;
    }

    public void setAdhocAlerts(List<String> adhocAlerts) {
        this.adhocAlerts = adhocAlerts;
    }
}
