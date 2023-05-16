package it_academy.Rest_api.endpoints;

import it_academy.framework.PropertiesReader;

public class OnlinerEndpoints {

    public static String getCatalogProductEndPoint(){
        return PropertiesReader.getEndPointsProperty("Products.sushivesla");
    }
}
