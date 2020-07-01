package com.andrewsimpson.openldbws.configuration;

import com.thalesgroup.rtti._2017_10_01.ldb.Ldb;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LDBWSConfiguration {

    @Bean
    public Ldb getLdb() {
        return new Ldb();
    }
}
