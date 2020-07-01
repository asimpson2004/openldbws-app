package com.andrewsimpson.openldbws.converters;

import com.thalesgroup.rtti._2012_01_13.ldb.types.ArrayOfNRCCMessages;
import com.thalesgroup.rtti._2012_01_13.ldb.types.NRCCMessage;

import java.util.ArrayList;
import java.util.List;

public class NrccMessageListConverter {

    public static List<String> from(final ArrayOfNRCCMessages source) {

        if(source == null)
            return null;

        List<String> destination = new ArrayList<>();
        for(NRCCMessage nrccMessage : source.getMessage()) {
            destination.add(nrccMessage.getValue());
        }

        return destination;
    }
}
