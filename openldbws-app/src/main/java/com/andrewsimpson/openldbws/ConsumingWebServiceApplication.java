package com.andrewsimpson.openldbws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.naming.ConfigurationException;

//https://realtime.nationalrail.co.uk/ldbws/rtti_2017-10-01_ldb.wsdl

@SpringBootApplication
public class ConsumingWebServiceApplication {

    public static void main(String[] args) throws ConfigurationException {
        SpringApplication.run(ConsumingWebServiceApplication.class, args);
    }

}
