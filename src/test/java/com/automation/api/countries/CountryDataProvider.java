package com.automation.api.countries;

import org.testng.annotations.DataProvider;

public class CountryDataProvider {
    @DataProvider(name = "countries")
    public static Object[][] countryData() {
        return new Object[][] {
                {"US"},
                {"DE"},
                {"GB"}
        };
    }

    @DataProvider(name = "invalidCountries")
    public static Object[][] invalidCountryData() {
        return new Object[][] {
                {"XX"},
                {"XY"},
                {"XZ"}
        };
    }
}
