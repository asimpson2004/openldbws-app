package com.andrewsimpson.openldbws.services;

import com.andrewsimpson.openldbws.ConsumingWebServiceApplication;
import com.andrewsimpson.openldbws.converters.request.GetBoardRequestConverter;
import com.andrewsimpson.openldbws.converters.request.GetDeparturesRequestConverter;
import com.andrewsimpson.openldbws.converters.request.GetServiceDetailsRequestConverter;
import com.andrewsimpson.openldbws.converters.response.*;
import com.andrewsimpson.openldbws.dto.StationBoardWithDetails;
import com.andrewsimpson.openldbws.dto.request.GetBoardRequest;
import com.andrewsimpson.openldbws.dto.request.GetDeparturesRequest;
import com.andrewsimpson.openldbws.dto.request.GetServiceDetailsRequest;
import com.andrewsimpson.openldbws.dto.response.*;
import com.andrewsimpson.openldbws.exceptions.ConfigurationException;
import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldb.*;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import java.util.List;

@Service
public class DepartureBoardServiceImpl implements DepartureBoardService {

    private String LDB_TOKEN;
    private static final Logger logger = LoggerFactory.getLogger(ConsumingWebServiceApplication.class);
    private static final boolean DEBUG = false;

    private Ldb ldbWebService;
    private LDBServiceSoap ldbSoapService;

    public DepartureBoardServiceImpl(@Value("${ldbws.token}") String LDB_TOKEN, Ldb ldbWebService) {
        this.LDB_TOKEN = LDB_TOKEN;
        this.ldbWebService = ldbWebService;
        ldbSoapService = ldbWebService.getLDBServiceSoap12();

        if (DEBUG) {
            Client client = ClientProxy.getClient(ldbSoapService);
            client.getInInterceptors().add(new LoggingInInterceptor());
            client.getOutInterceptors().add(new LoggingOutInterceptor());
        }
    }

    @Override
    public StationBoardResponse getDepartureBoard(GetBoardRequest getBoardRequest) {

        AccessToken accessToken = getAccessToken(LDB_TOKEN);

        GetBoardRequestParams params = GetBoardRequestConverter.from(getBoardRequest);

        StationBoardResponseType departureBoard = ldbSoapService.getDepartureBoard(params, accessToken);

        StationBoardResponse response = StationBoardResponseConverter.from(departureBoard);

        return response;
    }

    @Override
    public StationBoardWithDetailsResponse getDepartureBoardWithDetails(GetBoardRequest getBoardRequest) {

        AccessToken accessToken = getAccessToken(LDB_TOKEN);

        GetBoardRequestParams params = GetBoardRequestConverter.from(getBoardRequest);

        StationBoardWithDetailsResponseType stationBoardWithDetailsResponseType = ldbSoapService.getDepBoardWithDetails(params, accessToken);

        StationBoardWithDetailsResponse response = StationBoardWithDetailsResponseConverter.from(stationBoardWithDetailsResponseType);

        return response;
    }

    @Override
    public StationBoardResponse getArrivalBoard(GetBoardRequest getBoardRequest) {

        AccessToken accessToken = getAccessToken(LDB_TOKEN);

        GetBoardRequestParams params = GetBoardRequestConverter.from(getBoardRequest);

        StationBoardResponseType stationBoardResponseType = ldbSoapService.getArrivalBoard(params, accessToken);

        StationBoardResponse response = StationBoardResponseConverter.from(stationBoardResponseType);

        return response;
    }

    @Override
    public StationBoardWithDetailsResponse getArrivalBoardWithDetails(GetBoardRequest getBoardRequest) {

        AccessToken accessToken = getAccessToken(LDB_TOKEN);

        GetBoardRequestParams params = GetBoardRequestConverter.from(getBoardRequest);

        StationBoardWithDetailsResponseType stationBoardWithDetailsResponseType = ldbSoapService.getArrBoardWithDetails(params, accessToken);

        StationBoardWithDetailsResponse response = StationBoardWithDetailsResponseConverter.from(stationBoardWithDetailsResponseType);

        return response;
    }

    @Override
    public StationBoardResponse getArrivalDepartureBoard(GetBoardRequest getBoardRequest) {

        AccessToken accessToken = getAccessToken(LDB_TOKEN);

        GetBoardRequestParams params = GetBoardRequestConverter.from(getBoardRequest);

        StationBoardResponseType stationBoardResponseType = ldbSoapService.getArrivalBoard(params, accessToken);

        StationBoardResponse response = StationBoardResponseConverter.from(stationBoardResponseType);

        return response;
    }

    @Override
    public StationBoardWithDetailsResponse getArrivalDepartureBoardWithDetails(GetBoardRequest getBoardRequest) {

        AccessToken accessToken = getAccessToken(LDB_TOKEN);

        GetBoardRequestParams params = GetBoardRequestConverter.from(getBoardRequest);

        StationBoardWithDetailsResponseType stationBoardWithDetailsResponseType = ldbSoapService.getArrDepBoardWithDetails(params, accessToken);

        StationBoardWithDetailsResponse response = StationBoardWithDetailsResponseConverter.from(stationBoardWithDetailsResponseType);

        return response;
    }

    @Override
    public DeparturesBoardResponse getFastestDepartures(GetDeparturesRequest getDeparturesRequest) {

        AccessToken accessToken = getAccessToken(LDB_TOKEN);

        GetDeparturesRequestParams params = GetDeparturesRequestConverter.from(getDeparturesRequest);

        DeparturesBoardResponseType departuresBoardResponseType = ldbSoapService.getFastestDepartures(params, accessToken);

        DeparturesBoardResponse response = DeparturesBoardResponseConverter.from(departuresBoardResponseType);

        return response;
    }

    @Override
    public DeparturesBoardWithDetailsResponse getFastestDeparturesWithDetails(GetDeparturesRequest getDeparturesRequest) {

        AccessToken accessToken = getAccessToken(LDB_TOKEN);

        GetDeparturesRequestParams params = GetDeparturesRequestConverter.from(getDeparturesRequest);

        DeparturesBoardWithDetailsResponseType departuresBoardWithDetailsResponseType = ldbSoapService.getFastestDeparturesWithDetails(params, accessToken);

        DeparturesBoardWithDetailsResponse response = DeparturesBoardWithDetailsResponseConverter.from(departuresBoardWithDetailsResponseType);

        return response;
    }

    @Override
    public DeparturesBoardResponse getNextDepartures(GetDeparturesRequest getDeparturesRequest) {

        AccessToken accessToken = getAccessToken(LDB_TOKEN);

        GetDeparturesRequestParams params = GetDeparturesRequestConverter.from(getDeparturesRequest);

        DeparturesBoardResponseType departuresBoardResponseType = ldbSoapService.getNextDepartures(params, accessToken);

        DeparturesBoardResponse response = DeparturesBoardResponseConverter.from(departuresBoardResponseType);

        return response;
    }

    @Override
    public DeparturesBoardWithDetailsResponse getNextDeparturesWithDetails(GetDeparturesRequest getDeparturesRequest) {

        AccessToken accessToken = getAccessToken(LDB_TOKEN);

        GetDeparturesRequestParams params = GetDeparturesRequestConverter.from(getDeparturesRequest);

        DeparturesBoardWithDetailsResponseType departuresBoardWithDetailsResponseType = ldbSoapService.getNextDeparturesWithDetails(params, accessToken);

        DeparturesBoardWithDetailsResponse response = DeparturesBoardWithDetailsResponseConverter.from(departuresBoardWithDetailsResponseType);

        return response;
    }

    @Override
    public ServiceDetailsResponse getServiceDetails(GetServiceDetailsRequest getServiceDetailsRequest) {

        AccessToken accessToken = getAccessToken(LDB_TOKEN);

        GetServiceDetailsRequestParams params = GetServiceDetailsRequestConverter.from(getServiceDetailsRequest);

        ServiceDetailsResponseType serviceDetailsResponseType = ldbSoapService.getServiceDetails(params, accessToken);

        ServiceDetailsResponse response = ServiceDetailsResponseConverter.from(serviceDetailsResponseType);

        return response;
    }

    private AccessToken getAccessToken(String token) {
        if (token.isEmpty()) {
            //throw new ConfigurationException("Please the OpenLDBWS token");
        }

        AccessToken accessToken = new AccessToken();
        accessToken.setTokenValue(token);
        return accessToken;
    }
}
