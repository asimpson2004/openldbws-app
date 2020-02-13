package com.andrewsimpson.openldbws.commands;

import java.util.List;

public class ServiceWithCallingPoints extends Service {
    protected List<CallingPointList>  previousCallingPoints;
    protected List<CallingPointList>  subsequentCallingPoints;

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
