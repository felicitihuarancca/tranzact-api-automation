package com.automation.api.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;

public class BaseClient {

    protected Client client = getClient();
    protected static String  BASE_URL = "http://api.countrylayer.com/v2";

    public Client getClient() {

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);

        client = Client.create(clientConfig);
        client.setFollowRedirects(true);
        client.addFilter(new LoggingFilter(System.out));

        return client;
    }
}
