package com.andrewsimpson.openldbws.converters;

import com.andrewsimpson.openldbws.dto.ServiceDetailsBase;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.BaseServiceDetails;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ServiceDetailsBaseConverterTest {

    private final String ata = "ata";
    private final String atd = "atd";
    private final String cancelReason = "cancelReason";
    private final String crs = "crs";
    private final String delayReason = "delayReason";
    private final Boolean detachFront = false;
    private final String eta = "eta";
    private final String etd = "etd";
    private final Boolean isCancelled = false;
    private final Boolean isReverseFormation = true;
    private final Integer length = 4;
    private final String locationName = "locationName";
    private final String operator = "operator";
    private final String operatorCode = "opCode";
    private final String overdueMessage = "overdue";
    private final String platform = "platform";
    private final String rsid = "rsid";
    private final String sta = "sta";
    private final String std = "std";


    @Test
    void from_ShouldReturnNull() {
        // Given
        final BaseServiceDetails baseServiceDetails = null;
        // When
        ServiceDetailsBase result = ServiceDetailsBaseConverter.from(baseServiceDetails);
        // Then
        assertThat(result, is(nullValue()));
    }

    @Test
    void from_ShouldMapAllPropertiesCorrectly() {
        // Given
        final BaseServiceDetails baseServiceDetails = getBaseServiceDetails();
        // When
        ServiceDetailsBase result1 = ServiceDetailsBaseConverter.from(baseServiceDetails);
        ServiceDetailsBase result2 = new ServiceDetailsBase();
        ServiceDetailsBaseConverter.from(baseServiceDetails, result2);
        // Then
        checkResultIsValid(result1);
        checkResultIsValid(result2);
    }

    private void checkResultIsValid(ServiceDetailsBase result) {
        assertThat(result, is(notNullValue()));
        assertThat(result.getAta(), is(equalTo(ata)));
        assertThat(result.getAtd(), is(equalTo(atd)));
        assertThat(result.getCancelReason(), is(equalTo(cancelReason)));
        assertThat(result.getCrs(), is(equalTo(crs)));
        assertThat(result.getDelayReason(), is(equalTo(delayReason)));
        assertThat(result.getDetachFront(), is(equalTo(detachFront)));
        assertThat(result.getEta(), is(equalTo(eta)));
        assertThat(result.getEtd(), is(equalTo(etd)));
        assertThat(result.getGeneratedAt(), is(notNullValue()));
        assertThat(result.getCancelled(), is(equalTo(isCancelled)));
        assertThat(result.getReverseFormation(), is(equalTo(isReverseFormation)));
        assertThat(result.getLength(), is(equalTo(length)));
        assertThat(result.getLocationName(), is(equalTo(locationName)));
        assertThat(result.getOperator(), is(equalTo(operator)));
        assertThat(result.getOperatorCode(), is(equalTo(operatorCode)));
        assertThat(result.getOverdueMessage(), is(equalTo(overdueMessage)));
        assertThat(result.getPlatform(), is(equalTo(platform)));
        assertThat(result.getRsid(), is(equalTo(rsid)));
        assertThat(result.getServiceType(), is(equalTo(com.andrewsimpson.openldbws.dto.ServiceType.FERRY)));
        assertThat(result.getSta(), is(equalTo(sta)));
        assertThat(result.getStd(), is(equalTo(std)));
    }

    private BaseServiceDetails getBaseServiceDetails() {
        final BaseServiceDetails baseServiceDetails = new BaseServiceDetails();
        baseServiceDetails.setAta(ata);
        baseServiceDetails.setAtd(atd);
        baseServiceDetails.setCancelReason(cancelReason);
        baseServiceDetails.setCrs(crs);
        baseServiceDetails.setDelayReason(delayReason);
        baseServiceDetails.setDetachFront(detachFront);
        baseServiceDetails.setEta(eta);
        baseServiceDetails.setEtd(etd);

        try {
            XMLGregorianCalendar generatedAt = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
            baseServiceDetails.setGeneratedAt(generatedAt);
        } catch (DatatypeConfigurationException ex) {}

        baseServiceDetails.setIsCancelled(isCancelled);
        baseServiceDetails.setIsReverseFormation(isReverseFormation);
        baseServiceDetails.setLength(length);
        baseServiceDetails.setLocationName(locationName);
        baseServiceDetails.setOperator(operator);
        baseServiceDetails.setOperatorCode(operatorCode);
        baseServiceDetails.setOverdueMessage(overdueMessage);
        baseServiceDetails.setPlatform(platform);
        baseServiceDetails.setRsid(rsid);
        baseServiceDetails.setServiceType(ServiceType.FERRY);
        baseServiceDetails.setSta(sta);
        baseServiceDetails.setStd(std);
        return baseServiceDetails;
    }

}