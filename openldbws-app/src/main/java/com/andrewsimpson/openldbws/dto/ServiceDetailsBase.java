package com.andrewsimpson.openldbws.dto;

import java.util.GregorianCalendar;

public class ServiceDetailsBase {

    protected GregorianCalendar generatedAt;
    protected Service service;
    protected String locationName;
    protected String crs;
    protected String operator;
    protected String operatorCode;
    protected String rsid;
    protected Boolean cancelled;
    protected String cancelReason;
    protected String delayReason;
    protected String overdueMessage;
    protected Integer length;
    protected Boolean reverseFormation;
    protected String platform;
    protected String sta;
    protected String eta;
    protected String ata;
    protected String std;
    protected String etd;
    protected String atd;

    public GregorianCalendar getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(GregorianCalendar generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

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

    public String getRsid() {
        return rsid;
    }

    public void setRsid(String rsid) {
        this.rsid = rsid;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
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

    public String getOverdueMessage() {
        return overdueMessage;
    }

    public void setOverdueMessage(String overdueMessage) {
        this.overdueMessage = overdueMessage;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getReverseFormation() {
        return reverseFormation;
    }

    public void setReverseFormation(Boolean reverseFormation) {
        this.reverseFormation = reverseFormation;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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

    public String getAta() {
        return ata;
    }

    public void setAta(String ata) {
        this.ata = ata;
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

    public String getAtd() {
        return atd;
    }

    public void setAtd(String atd) {
        this.atd = atd;
    }

}
