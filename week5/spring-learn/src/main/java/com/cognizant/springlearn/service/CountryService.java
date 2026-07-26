package com.cognizant.springlearn.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;

/**
 * CountryService (as specified in docx, REST hands on 2).
 * Loads country data from country.xml Spring configuration.
 */
@Service
public class CountryService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryService.class);

    /**
     * Returns all countries loaded from country.xml
     */
    public List<Country> getAllCountries() {
        LOGGER.info("START getAllCountries");
        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        // Load all 4 countries by their bean IDs
        Country india = context.getBean("country", Country.class);
        Country us = context.getBean("US", Country.class);
        Country japan = context.getBean("JP", Country.class);
        Country germany = context.getBean("DE", Country.class);

        List<Country> countries = Arrays.asList(india, us, japan, germany);
        LOGGER.debug("countries={}", countries);
        LOGGER.info("END getAllCountries");
        return countries;
    }

    /**
     * Returns a country matching the given code (case insensitive).
     * As specified in docx: "Make a case insensitive matching"
     */
    public Country getCountry(String code) {
        LOGGER.info("START getCountry. code={}", code);
        List<Country> countries = getAllCountries();
        Country result = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
        LOGGER.debug("result={}", result);
        LOGGER.info("END getCountry");
        return result;
    }
}