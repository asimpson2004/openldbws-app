package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceDetailsBase;
import com.thalesgroup.rtti._2017_10_01.ldb.types.BaseServiceDetails;

public class ServiceDetailsBaseConverter {

    public static ServiceDetailsBase from(final BaseServiceDetails source) {

        if(source == null)
            return null;

        ServiceDetailsBase destination = new ServiceDetailsBase();
        return from(source, destination);
    }
    public static ServiceDetailsBase from(final BaseServiceDetails source, ServiceDetailsBase destination) {

        if(source == null)
            return null;

        destination.setAta(source.getAta());
        destination.setAtd(source.getAtd());
        destination.setCancelled(source.isIsCancelled());
        destination.setCancelReason(source.getCancelReason());
        destination.setCrs(source.getCrs());
        destination.setDelayReason(source.getDelayReason());
        destination.setEta(source.getEta());
        destination.setGeneratedAt(source.getGeneratedAt() != null ? source.getGeneratedAt().toGregorianCalendar() : null);
        destination.setEtd(source.getEtd());
        destination.setLength(source.getLength());
        destination.setLocationName(source.getLocationName());
        destination.setOperator(source.getOperator());
        destination.setOperatorCode(source.getOperatorCode());
        destination.setOverdueMessage(source.getOverdueMessage());
        destination.setPlatform(source.getPlatform());
        destination.setReverseFormation(source.isIsReverseFormation());
        destination.setRsid(source.getRsid());
        destination.setServiceType(ServiceTypeConverter.from(source.getServiceType()));
        destination.setSta(source.getSta());
        destination.setStd(source.getStd());

        return destination;
    }

}
