package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Country model class (as specified in docx, Hands on 4).
 * Docx says: include debug log in constructor and all getters/setters.
 */
public class Country {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    // Docx: "Implement empty parameter constructor with debug log"
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        LOGGER.debug("Inside getCode. code={}", code);
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode. code={}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName. name={}", name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName. name={}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }
}