package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceWithCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItemWithCallingPoints;

import java.text.Normalizer;

public class ServiceWithCallingPointsConverter {

    public static ServiceWithCallingPoints from(final ServiceItemWithCallingPoints source) {

        if(source == null)
            return null;

        ServiceWithCallingPoints destination = new ServiceWithCallingPoints();
        destination.setPreviousCallingPoints(ListOfCallingPointListConverter.from(source.getPreviousCallingPoints()));
        destination.setSubsequentCallingPoints(ListOfCallingPointListConverter.from(source.getSubsequentCallingPoints()));
        destination.setAdhocAlerts(AdhocAlertsConverter.from(source.getAdhocAlerts()));
        destination.setCancelled(source.isIsCancelled());
        destination.setCancelReason(source.getCancelReason());
        destination.setCircularRoute(source.isIsCircularRoute());
        destination.setCurrentDestinations(ServiceLocationListConverter.from(source.getCurrentDestinations()));
        destination.setCurrentOrigins(ServiceLocationListConverter.from(source.getCurrentOrigins()));
        destination.setDelayReason(source.getDelayReason());
        destination.setDestination(ServiceLocationListConverter.from(source.getDestination()));
        destination.setDetachFront(source.isDetachFront());
        destination.setEta(source.getEta());
        destination.setEtd(source.getEtd());
        destination.setFilterLocationCancelled(source.isFilterLocationCancelled());
        destination.setFormation(FormationConverter.from(source.getFormation()));
        destination.setLength(source.getLength());
        destination.setOperator(source.getOperator());
        destination.setOperatorCode(source.getOperatorCode());
        destination.setOrigin(ServiceLocationListConverter.from(source.getOrigin()));
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
