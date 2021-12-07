package com.automation.api.util;

import com.sun.jersey.api.client.ClientResponse;

public class ClientResponseUtils {

    public static <T> T getEntity(ClientResponse response, Class<T> outputType){

        if (response == null){

            throw new IllegalArgumentException("Response is null, cannot return entity.");

        }
        if (response.hasEntity()){

            return response.getEntity(outputType);

        }
        return null;
    }
}
