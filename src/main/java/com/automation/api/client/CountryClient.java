package com.automation.api.client;

import com.automation.api.entities.Country;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class CountryClient extends BaseClient {

    protected final static String COUNTRY_ENDPOINT = "/all";
    protected final static String COUNTRY_ALPHA_ENDPOINT = "/alpha/%s";
    protected final static String API_KEY = "b8ba87753a97c7cf1ef50916458e8ff1";

    /**
     * Get all countries.
     * @return response
     */
    public ClientResponse getAllCountries() {
        return client.resource(BASE_URL+COUNTRY_ENDPOINT+"?access_key="+API_KEY)
                .get(ClientResponse.class);
    }

    /**
     * Get Country by alpha code.
     * @param alphaCode
     * @return response
     */
    public ClientResponse getCountry(String alphaCode) {
        WebResource webResource = client.resource(BASE_URL+ String.format(COUNTRY_ALPHA_ENDPOINT, alphaCode)+ "?access_key="+API_KEY);
        return webResource.accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
    }

    /**
     * Create Country.
     * @param country
     * @return response
     */
    public ClientResponse createCountry(Country country) {
        WebResource webResource = client.resource(BASE_URL);
        return webResource
                .type(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, country);
    }
}
