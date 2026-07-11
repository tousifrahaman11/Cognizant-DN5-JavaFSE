package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Persistence Class (as specified in docx, Hands on 1).
 *
 * Docx says:
 * - @Entity maps this class to the 'country' database table
 * - @Table specifies the exact table name
 * - @Id marks the primary key
 * - @Column maps each field to its database column name
 *
 * Table: country
 * Columns: co_code (PK), co_name
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    // Default constructor required by JPA/Hibernate
    public Country() {}

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }
}