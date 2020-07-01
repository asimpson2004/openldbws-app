package com.andrewsimpson.openldbws.converters;

import com.thalesgroup.rtti._2012_01_13.ldb.types.ArrayOfAdhocAlert;

import java.util.ArrayList;
import java.util.List;

public class AdhocAlertsConverter {

    public static List<String> from(final ArrayOfAdhocAlert source) {

        if(source == null)
            return null;

        List<String> destination = new ArrayList<>();
        destination.addAll(source.getAdhocAlertText());

        return destination;
    }
}
