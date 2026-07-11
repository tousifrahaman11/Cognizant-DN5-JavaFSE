package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

/**
 * Main application class (as specified in docx, Hands on 1).
 *
 * Docx says:
 * - Include Logger using LoggerFactory
 * - Get countryService from ApplicationContext
 * - Call testGetAllCountries() in main()
 * - LOGGER.info("Inside main")
 */
@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        // Get ApplicationContext from SpringApplication.run()
        // (docx explicitly says to capture the return value)
        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        // Get CountryService bean from context
        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside main");

        // Run all test methods in order
        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
    }

    /**
     * Hands on 1: Get all countries
     */
    private static void testGetAllCountries() {
        LOGGER.info("Start - testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End - testGetAllCountries");
    }

    /**
     * Hands on 6: Find country by code
     */
    private static void testFindCountryByCode() {
        LOGGER.info("Start - testFindCountryByCode");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country={}", country);
        LOGGER.info("End - testFindCountryByCode");
    }

    /**
     * Hands on 7: Add new country
     */
    private static void testAddCountry() {
        LOGGER.info("Start - testAddCountry");
        Country newCountry = new Country("JP", "Japan");
        countryService.addCountry(newCountry);
        Country found = countryService.findCountryByCode("JP");
        LOGGER.debug("Added and found: {}", found);
        LOGGER.info("End - testAddCountry");
    }

    /**
     * Hands on 8: Update country
     */
    private static void testUpdateCountry() {
        LOGGER.info("Start - testUpdateCountry");
        countryService.updateCountry("JP", "Japan Updated");
        Country updated = countryService.findCountryByCode("JP");
        LOGGER.debug("Updated country: {}", updated);
        LOGGER.info("End - testUpdateCountry");
    }

    /**
     * Hands on 9: Delete country
     */
    private static void testDeleteCountry() {
        LOGGER.info("Start - testDeleteCountry");
        countryService.deleteCountry("JP");
        LOGGER.debug("Country JP deleted successfully.");
        LOGGER.info("End - testDeleteCountry");
    }
}