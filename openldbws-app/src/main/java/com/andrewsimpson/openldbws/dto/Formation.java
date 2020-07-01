package com.andrewsimpson.openldbws.dto;

import java.util.List;

public class Formation {

    protected Long averageLoading;
    protected List<Coach> coaches;

    public Long getAverageLoading() {
        return averageLoading;
    }

    public void setAverageLoading(Long averageLoading) {
        this.averageLoading = averageLoading;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }
}
