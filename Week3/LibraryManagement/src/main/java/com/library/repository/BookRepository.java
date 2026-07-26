package com.library.repository;

/**
 * Exercise 1: Configuring a Basic Spring Application
 * Exercise 2: Implementing Dependency Injection
 *
 * Scenario (from docx): Library management system backend.
 * BookRepository handles direct data access operations.
 * This will be injected into BookService by Spring IoC.
 */
public class BookRepository {

    public void addBook(String bookName) {
        System.out.println("BookRepository: Adding book -> " + bookName);
    }

    public String findBook(String bookName) {
        System.out.println("BookRepository: Finding book -> " + bookName);
        return bookName;
    }
}