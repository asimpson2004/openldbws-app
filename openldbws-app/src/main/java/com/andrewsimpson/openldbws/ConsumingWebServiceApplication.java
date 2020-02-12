package com.andrewsimpson.openldbws;

import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldb.GetBoardRequestParams;
import com.thalesgroup.rtti._2017_10_01.ldb.LDBServiceSoap;
import com.thalesgroup.rtti._2017_10_01.ldb.Ldb;
import com.thalesgroup.rtti._2017_10_01.ldb.StationBoardResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.naming.ConfigurationException;
import java.util.List;

//https://realtime.nationalrail.co.uk/ldbws/rtti_2017-10-01_ldb.wsdl

@SpringBootApplication
public class ConsumingWebServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(ConsumingWebServiceApplication.class);

    private static final String LDB_TOKEN = "";
    private static final boolean DEBUG = false;

    public static void main(String[] args) throws ConfigurationException {

        if (LDB_TOKEN.isEmpty()) {
            throw new ConfigurationException("Please configure your OpenLDBWS token in GetDepartureBoardExample!");
        }

        AccessToken accessToken = new AccessToken();
        accessToken.setTokenValue(LDB_TOKEN);

        Ldb soap = new Ldb();
        LDBServiceSoap soapService = soap.getLDBServiceSoap12();

        /*
         * To examine the request and responses sent to the service, set DEBUG to true above
         */
        if (DEBUG) {
            Client client = ClientProxy.getClient(soapService);
            client.getInInterceptors().add(new LoggingInInterceptor());
            client.getOutInterceptors().add(new LoggingOutInterceptor());
        }

        GetBoardRequestParams params = new GetBoardRequestParams();
        params.setCrs("RNH");

        StationBoardResponseType departureBoard = soapService.getDepartureBoard(params, accessToken);

        logger.info("Trains at {}", departureBoard.getGetStationBoardResult().getLocationName());
        logger.info("===============================================================================");

        List<ServiceItem> service = departureBoard.getGetStationBoardResult().getTrainServices().getService();

        for (ServiceItem si : service) {

            logger.info("{} to {} - {}", si.getStd(), si.getDestination().getLocation().get(0).getLocationName(), si.getEtd());

        }

        SpringApplication.run(ConsumingWebServiceApplication.class, args);
    }


}
