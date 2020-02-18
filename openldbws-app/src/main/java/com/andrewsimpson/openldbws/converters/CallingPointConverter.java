package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.CallingPoint;

public class CallingPointConverter {

    public static CallingPoint from(final com.thalesgroup.rtti._2017_10_01.ldb.types.CallingPoint source) {

        if(source == null)
            return null;

        CallingPoint destination = new CallingPoint();
        destination.getAdhocAlerts().addAll(AdhocAlertsConverter.from(source.getAdhocAlerts()));
        destination.setAt(source.getAt());
        destination.setCancelled(source.isIsCancelled());
        destination.setCrs(source.getCrs());
        destination.setDetatchFront(source.isDetachFront());
        destination.setEt(source.getEt());
        destination.setFormation(FormationConverter.from(source.getFormation()));
        destination.setLength(source.getLength());
        destination.setLocationName(source.getLocationName());
        destination.setSt(source.getSt());
        
        return destination;
    }

}
