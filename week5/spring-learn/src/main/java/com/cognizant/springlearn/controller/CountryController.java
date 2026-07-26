package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;

/**
 * Country REST endpoints (as specified in docx, Hands on 2).
 *
 * Endpoints:
 * GET /country         → returns India only
 * GET /countries       → returns all countries
 * GET /countries/{code}→ returns country by code (case insensitive)
 */
@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    /**
     * GET /country - returns India country bean from spring XML
     */
    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START getCountryIndia");
        List<Country> all = countryService.getAllCountries();
        Country india = all.stream()
                .filter(c -> c.getCode().equals("IN"))
                .findFirst().orElse(null);
        LOGGER.debug("country={}", india);
        LOGGER.info("END getCountryIndia");
        return india;
    }

    /**
     * GET /countries - returns all countries
     */
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START getAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("END getAllCountries");
        return countries;
    }

    /**
     * GET /countries/{code} - returns country by code (case insensitive)
     */
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START getCountry. code={}", code);
        Country country = countryService.getCountry(code);
        LOGGER.debug("country={}", country);
        LOGGER.info("END getCountry");
        return country;
    }
}