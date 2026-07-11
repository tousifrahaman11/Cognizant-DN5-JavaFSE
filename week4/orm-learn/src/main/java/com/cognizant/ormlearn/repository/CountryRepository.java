package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

/**
 * Repository interface (as specified in docx, Hands on 1).
 *
 * Docx says:
 * "Create new interface named CountryRepository that extends
 * JpaRepository<Country, String>"
 *
 * By extending JpaRepository, we get these methods for FREE:
 * - findAll()       → get all countries
 * - findById(code)  → find by primary key
 * - save(country)   → insert or update
 * - deleteById(code)→ delete by primary key
 *
 * No implementation code needed — Spring Data JPA generates it.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    // Spring Data JPA provides all CRUD methods automatically.
    // This is the key advantage over raw Hibernate.
}