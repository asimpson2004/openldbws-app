package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceWithCallingPoints;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType;
import com.thalesgroup.rtti._2012_01_13.ldb.types.ArrayOfAdhocAlert;
import com.thalesgroup.rtti._2015_11_27.ldb.types.ArrayOfServiceLocations;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ArrayOfArrayOfCallingPoints;
import com.thalesgroup.rtti._2017_10_01.ldb.types.FormationData;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItemWithCallingPoints;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ServiceWithCallingPointsConverterTest {

    private final String cancelReason = "cancelReason";
    private final String delayReason = "delayReason";
    private final Boolean detachFront = false;
    private final String eta = "eta";
    private final String etd = "etd";
    private final Boolean isCancelled = false;
    private final Boolean isReverseFormation = true;
    private final Integer length = 4;
    private final String operator = "operator";
    private final String operatorCode = "opCode";
    private final String platform = "platform";
    private final String rsid = "rsid";
    private final String sta = "sta";
    private final String std = "std";
    private final Boolean filterLocationCancelled = false;
    private final Boolean isCircularRoute = false;
    private final String serviceId = "service-Id";

    @Test
    void from_ShouldReturnNull() {
        // Given
        final ServiceItemWithCallingPoints serviceItemWithCallingPoints = null;
        // When
        ServiceWithCallingPoints result = ServiceWithCallingPointsConverter.from(serviceItemWithCallingPoints);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final ServiceItemWithCallingPoints serviceItemWithCallingPoints = new ServiceItemWithCallingPoints();
        serviceItemWithCallingPoints.setPreviousCallingPoints(new ArrayOfArrayOfCallingPoints());
        serviceItemWithCallingPoints.setSubsequentCallingPoints(new ArrayOfArrayOfCallingPoints());
        serviceItemWithCallingPoints.setAdhocAlerts(new ArrayOfAdhocAlert());
        serviceItemWithCallingPoints.setCancelReason(cancelReason);
        serviceItemWithCallingPoints.setDelayReason(delayReason);
        serviceItemWithCallingPoints.setDetachFront(detachFront);
        serviceItemWithCallingPoints.setEta(eta);
        serviceItemWithCallingPoints.setEtd(etd);
        serviceItemWithCallingPoints.setFilterLocationCancelled(filterLocationCancelled);
        serviceItemWithCallingPoints.setIsCancelled(isCancelled);
        serviceItemWithCallingPoints.setIsCircularRoute(isCircularRoute);
        serviceItemWithCallingPoints.setIsReverseFormation(isReverseFormation);
        serviceItemWithCallingPoints.setLength(length);
        serviceItemWithCallingPoints.setOperator(operator);
        serviceItemWithCallingPoints.setOperatorCode(operatorCode);
        serviceItemWithCallingPoints.setPlatform(platform);
        serviceItemWithCallingPoints.setServiceID(serviceId);
        serviceItemWithCallingPoints.setServiceType(ServiceType.TRAIN);
        serviceItemWithCallingPoints.setSta(sta);
        serviceItemWithCallingPoints.setStd(std);
        serviceItemWithCallingPoints.setCurrentDestinations(new ArrayOfServiceLocations());
        serviceItemWithCallingPoints.setCurrentOrigins(new ArrayOfServiceLocations());
        serviceItemWithCallingPoints.setDestination(new ArrayOfServiceLocations());
        serviceItemWithCallingPoints.setFormation(new FormationData());
        serviceItemWithCallingPoints.setOrigin(new ArrayOfServiceLocations());
        serviceItemWithCallingPoints.setRsid(rsid);
        // When
        ServiceWithCallingPoints result = ServiceWithCallingPointsConverter.from(serviceItemWithCallingPoints);
        // Then
        assertThat(result, is(notNullValue()));
        assertThat(result.getCancelReason(), is(equalTo(cancelReason)));
        assertThat(result.getDelayReason(), is(equalTo(delayReason)));
        assertThat(result.getPreviousCallingPoints(), is(notNullValue()));
        assertThat(result.getSubsequentCallingPoints(), is(notNullValue()));
        assertThat(result.getAdhocAlerts(), is(notNullValue()));
        assertThat(result.getCancelled(), is(equalTo(isCancelled)));
        assertThat(result.getCircularRoute(), is(equalTo(isCircularRoute)));
        assertThat(result.getCurrentDestinations(), is(notNullValue()));
        assertThat(result.getCurrentOrigins(), is(notNullValue()));
        assertThat(result.getDestination(), is(notNullValue()));
        assertThat(result.getDetachFront(), is(equalTo(detachFront)));
        assertThat(result.getEta(), is(equalTo(eta)));
        assertThat(result.getEtd(), is(equalTo(etd)));
        assertThat(result.getFilterLocationCancelled(), is(equalTo(filterLocationCancelled)));
        assertThat(result.getFormation(), is(notNullValue()));
        assertThat(result.getLength(), is(equalTo(length)));
        assertThat(result.getOperator(), is(equalTo(operator)));
        assertThat(result.getOperatorCode(), is(equalTo(operatorCode)));
        assertThat(result.getOrigin(), is(notNullValue()));
        assertThat(result.getPlatform(), is(equalTo(platform)));
        assertThat(result.getReverseFormation(), is(equalTo(isReverseFormation)));
        assertThat(result.getRsid(), is(equalTo(rsid)));
        assertThat(result.getServiceID(), is(equalTo(serviceId)));
        assertThat(result.getServiceType(), is(equalTo(com.andrewsimpson.openldbws.dto.ServiceType.TRAIN)));
        assertThat(result.getSta(), is(equalTo(sta)));
        assertThat(result.getStd(), is(equalTo(std)));
    }

}