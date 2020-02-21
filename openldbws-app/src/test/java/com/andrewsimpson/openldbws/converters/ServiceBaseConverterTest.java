package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceBase;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType;
import com.thalesgroup.rtti._2012_01_13.ldb.types.ArrayOfAdhocAlert;
import com.thalesgroup.rtti._2016_02_16.ldb.types.BaseServiceItem;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ServiceBaseConverterTest {

    private final String rsid = "rsid";
    private final String sta = "sta";
    private final String eta = "eta";
    private final String std = "std";
    private final String etd = "etd";
    private final String platform = "platform";
    private final String operator = "operator";
    private final String operatorCode = "OpCode";
    private final Boolean isCircularRoute = true;
    private final Boolean isCancelled = false;
    private final Boolean filterLocationCancelled = false;
    private final ServiceType serviceType = ServiceType.FERRY ;
    private final Integer length = 5;
    private final Boolean detachFront = false;
    private final Boolean isReverseFormation = false;
    private final String cancelReason = "Broken";
    private final String delayReason = "A leaf on the track";
    private final String serviceID = "Service-id";

    @Test
    void from_ShouldReturnNull() {
        // Given
        final BaseServiceItem baseServiceItem = null;
        // When
        ServiceBase result1 = ServiceBaseConverter.from(baseServiceItem);
        ServiceBase result2 = null;
        ServiceBaseConverter.from(new BaseServiceItem(), result2);
        // Then
        assertThat(result1, is(nullValue()));
        assertThat(result2, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllParametersCorrectly() {
        // Given
        final BaseServiceItem baseServiceItem = getBaseServiceItem();
        // When
        ServiceBase result1 = ServiceBaseConverter.from(baseServiceItem);
        ServiceBase result2 = new ServiceBase();
        ServiceBaseConverter.from(baseServiceItem, result2);
        // Then
        checkResultIsValid(result1);
        checkResultIsValid(result2);
    }

    private void checkResultIsValid(ServiceBase result) {
        assertThat(result, is(notNullValue()));
        assertThat(result.getCancelReason(), is(equalTo(cancelReason)));
        assertThat(result.getDelayReason(), is(equalTo(delayReason)));
        assertThat(result.getAdhocAlerts(), is(notNullValue()));
        assertThat(result.getCancelled(), is(equalTo(isCancelled)));
        assertThat(result.getCircularRoute(), is(equalTo(isCircularRoute)));
        assertThat(result.getDetachFront(), is(equalTo(detachFront)));
        assertThat(result.getEta(), is(equalTo(eta)));
        assertThat(result.getEtd(), is(equalTo(etd)));
        assertThat(result.getFilterLocationCancelled(), is(equalTo(filterLocationCancelled)));
        assertThat(result.getLength(), is(equalTo(length)));
        assertThat(result.getOperator(), is(equalTo(operator)));
        assertThat(result.getOperatorCode(), is(equalTo(operatorCode)));
        assertThat(result.getPlatform(), is(equalTo(platform)));
        assertThat(result.getReverseFormation(), is(equalTo(isReverseFormation)));
        assertThat(result.getRsid(), is(equalTo(rsid)));
        assertThat(result.getServiceID(), is(equalTo(serviceID)));
        assertThat(result.getServiceType(), is(equalTo(com.andrewsimpson.openldbws.dto.ServiceType.FERRY)));
        assertThat(result.getSta(), is(equalTo(sta)));
        assertThat(result.getStd(), is(equalTo(std)));
    }

    private BaseServiceItem getBaseServiceItem() {
        final BaseServiceItem baseServiceItem = new BaseServiceItem();
        baseServiceItem.setRsid(rsid);
        baseServiceItem.setAdhocAlerts(new ArrayOfAdhocAlert());
        baseServiceItem.setCancelReason(cancelReason);
        baseServiceItem.setDelayReason(delayReason);
        baseServiceItem.setDetachFront(detachFront);
        baseServiceItem.setEta(eta);
        baseServiceItem.setEtd(etd);
        baseServiceItem.setFilterLocationCancelled(filterLocationCancelled);
        baseServiceItem.setIsCancelled(isCancelled);
        baseServiceItem.setIsCircularRoute(isCircularRoute);
        baseServiceItem.setIsReverseFormation(isReverseFormation);
        baseServiceItem.setLength(length);
        baseServiceItem.setOperator(operator);
        baseServiceItem.setOperatorCode(operatorCode);
        baseServiceItem.setPlatform(platform);
        baseServiceItem.setServiceID(serviceID);
        baseServiceItem.setServiceType(serviceType);
        baseServiceItem.setSta(sta);
        baseServiceItem.setStd(std);
        return baseServiceItem;
    }
}