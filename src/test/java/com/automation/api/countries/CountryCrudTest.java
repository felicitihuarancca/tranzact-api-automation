package com.automation.api.countries;

import com.automation.api.client.CountryClient;
import com.automation.api.entities.Country;
import com.automation.api.util.Assertions;
import com.sun.jersey.api.client.ClientResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CountryCrudTest extends Assertions {

    CountryClient countryClient;

    public CountryCrudTest() {
        this.countryClient = new CountryClient();
    }

    @Test(description = "Get all countries test")
    public void getAllCountries() throws InterruptedException {
        ClientResponse clientResponse = countryClient.getAllCountries();
        assertOkResponse(clientResponse);
        log.info(clientResponse.getStatus());
        Thread.sleep(5000);
    }

    @Test(description = "Get country test", dataProviderClass = CountryDataProvider.class, dataProvider = "countries")
    public void getCountry(String alphaCode) throws InterruptedException {
        log.info("Get Country "+ alphaCode);
        ClientResponse clientResponse = countryClient.getCountry(alphaCode);
        log.info("Validate status code");
        assertOkResponse(clientResponse);
        Country c = clientResponse.getEntity(Country.class);
        log.info("Validate Alpha2Code expected");
        Assert.assertEquals(c.getAlpha2Code(), alphaCode, "THE ALPHA CODE WAS NOT AS EXPECTED");
        Thread.sleep(5000);
    }

    @Test(description = "Get invalid countries test", dataProviderClass = CountryDataProvider.class, dataProvider = "invalidCountries")
    public void getInvalidCountry(String alphaCode) throws InterruptedException {
        log.info("Get Country "+ alphaCode);
        ClientResponse clientResponse = countryClient.getCountry(alphaCode);
        log.info("Validate status code");
        assertNotFoundResponse(clientResponse);
        Thread.sleep(5000);
    }

    @Test(description = "Create a country test")
    public void createCountry() throws InterruptedException {
        log.info("Create Country ");
        ClientResponse clientResponse = countryClient.createCountry(newCountry());
        log.info("Validate status code");
        assertOkResponse(clientResponse);
        Thread.sleep(5000);
    }

    public Country newCountry() {
        List<String> topLevel = new ArrayList<String>();
        List<String> codes = new ArrayList<String>();
        List<String> spelling = new ArrayList<String>();
        topLevel.add(".cof");
        codes.add("65");
        spelling.add("AX");
        spelling.add("XX");
        Country country = new Country();
        country.setName("country");
        country.setTopLevelDomain(topLevel);
        country.setAlpha2Code("CO");
        country.setAlpha3Code("COG");
        country.setCallingCodes(codes);
        country.setCapital("capital");
        country.setAltSpellings(spelling);
        country.setRegion("Europa");
        return country;
    }
}
