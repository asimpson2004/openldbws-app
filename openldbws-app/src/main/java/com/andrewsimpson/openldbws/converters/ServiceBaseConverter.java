package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceBase;
import com.thalesgroup.rtti._2016_02_16.ldb.types.BaseServiceItem;

public class ServiceBaseConverter {

    public static ServiceBase from(final BaseServiceItem source) {
        ServiceBase destination = new ServiceBase();
        return from(source, destination);
    }

    public static ServiceBase from(final BaseServiceItem source, ServiceBase destination) {

        if(source == null || destination == null)
            return null;

        destination.setAdhocAlerts(AdhocAlertsConverter.from(source.getAdhocAlerts()));
        destination.setCancelled(source.isIsCancelled());
        destination.setCancelReason(source.getCancelReason());
        destination.setCircularRoute(source.isIsCircularRoute());
        destination.setDelayReason(source.getDelayReason());
        destination.setDetachFront(source.isDetachFront());
        destination.setEta(source.getEta());
        destination.setEtd(source.getEtd());
        destination.setFilterLocationCancelled(source.isFilterLocationCancelled());
        destination.setLength(source.getLength());
        destination.setOperator(source.getOperator());
        destination.setOperatorCode(source.getOperatorCode());
        destination.setPlatform(source.getPlatform());
        destination.setReverseFormation(source.isIsReverseFormation());
        destination.setRsid(source.getRsid());
        destination.setServiceID(source.getServiceID());
        destination.setServiceType(ServiceTypeConverter.from(source.getServiceType()));
        destination.setSta(source.getSta());
        destination.setStd(source.getStd());
        
        return destination;
    }

}
