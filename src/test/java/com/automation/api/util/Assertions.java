package com.automation.api.util;

import com.sun.jersey.api.client.ClientResponse;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class Assertions {

    public Logger log = Logger.getLogger(Assertions.class);

    protected void assertOkResponse(ClientResponse response) {
        assertResponse(response, ClientResponse.Status.OK.getStatusCode());
    }

    protected void assertNotFoundResponse(ClientResponse response) {
        assertResponse(response, ClientResponse.Status.NOT_FOUND.getStatusCode());
    }

    private void assertResponse(ClientResponse response, int statusCode) {
        Assert.assertEquals(
                response.getStatus(),
                statusCode,
                "UNEXPECTED STATUS CODE."
        );
    }
}
