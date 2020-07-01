package com.andrewsimpson.openldbws.dto;


import java.util.List;

public class ServiceBase {

    protected String rsid;
    protected String sta;
    protected String eta;
    protected String std;
    protected String etd;
    protected String platform;
    protected String operator;
    protected String operatorCode;
    protected Boolean isCircularRoute;
    protected Boolean isCancelled;
    protected Boolean filterLocationCancelled;
    protected ServiceType serviceType;
    protected Integer length;
    protected Boolean detachFront;
    protected Boolean isReverseFormation;
    protected String cancelReason;
    protected String delayReason;
    protected String serviceID;
    protected List<String> adhocAlerts;

    public String getRsid() {
        return rsid;
    }

    public void setRsid(String rsid) {
        this.rsid = rsid;
    }

    public String getSta() {
        return sta;
    }

    public void setSta(String sta) {
        this.sta = sta;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getEtd() {
        return etd;
    }

    public void setEtd(String etd) {
        this.etd = etd;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public Boolean getCircularRoute() {
        return isCircularRoute;
    }

    public void setCircularRoute(Boolean circularRoute) {
        isCircularRoute = circularRoute;
    }

    public Boolean getCancelled() {
        return isCancelled;
    }

    public void setCancelled(Boolean cancelled) {
        isCancelled = cancelled;
    }

    public Boolean getFilterLocationCancelled() {
        return filterLocationCancelled;
    }

    public void setFilterLocationCancelled(Boolean filterLocationCancelled) {
        this.filterLocationCancelled = filterLocationCancelled;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getDetachFront() {
        return detachFront;
    }

    public void setDetachFront(Boolean detachFront) {
        this.detachFront = detachFront;
    }

    public Boolean getReverseFormation() {
        return isReverseFormation;
    }

    public void setReverseFormation(Boolean reverseFormation) {
        isReverseFormation = reverseFormation;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public List<String> getAdhocAlerts() {
        return adhocAlerts;
    }

    public void setAdhocAlerts(List<String> adhocAlerts) {
        this.adhocAlerts = adhocAlerts;
    }
}
