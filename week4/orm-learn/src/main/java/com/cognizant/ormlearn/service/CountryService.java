package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

/**
 * Service class (as specified in docx, Hands on 1 + 6 + 7 + 8 + 9).
 *
 * Docx says:
 * - @Service annotation at class level
 * - @Autowired to inject CountryRepository
 * - @Transactional on every method
 * - Spring manages Hibernate sessions automatically
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    /**
     * Hands on 1: Get all countries
     * Docx: "Include new method getAllCountries() that returns a list"
     */
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    /**
     * Hands on 6: Find country by code
     * Docx: "Get the country based on findById() built in method.
     *        If not found, throw exception."
     */
    @Transactional
    public Country findCountryByCode(String code) {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new RuntimeException("Country not found: " + code);
        }
        return result.get();
    }

    /**
     * Hands on 7: Add a new country
     * Docx: "Invoke save() method of repository"
     */
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    /**
     * Hands on 8: Update a country
     * Docx: "Get reference using findById(), update name, call save()"
     */
    @Transactional
    public void updateCountry(String code, String newName) {
        Optional<Country> result = countryRepository.findById(code);
        if (result.isPresent()) {
            Country country = result.get();
            country.setName(newName);
            countryRepository.save(country);
        }
    }

    /**
     * Hands on 9: Delete a country
     * Docx: "Call deleteById() method of repository"
     */
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
}