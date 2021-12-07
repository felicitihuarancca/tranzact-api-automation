package com.automation.api.entities;

import lombok.Data;

import java.util.List;

@Data
public class Country {
    private String name;
    private List<String> topLevelDomain;
    private String alpha2Code;
    private String alpha3Code;
    private List<String> callingCodes;
    private String capital;
    private List<String> altSpellings;
    private String region;

}
