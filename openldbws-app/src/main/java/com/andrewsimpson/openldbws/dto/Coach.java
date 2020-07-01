package com.andrewsimpson.openldbws.dto;

public class Coach {

    protected String coachClass;
    protected ToiletAvailability toiletAvailability;
    protected Long loading;
    protected String number;

    public String getCoachClass() {
        return coachClass;
    }

    public void setCoachClass(String coachClass) {
        this.coachClass = coachClass;
    }

    public ToiletAvailability getToiletAvailability() {
        return toiletAvailability;
    }

    public void setToiletAvailability(ToiletAvailability toiletAvailability) {
        this.toiletAvailability = toiletAvailability;
    }

    public Long getLoading() {
        return loading;
    }

    public void setLoading(Long loading) {
        this.loading = loading;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
