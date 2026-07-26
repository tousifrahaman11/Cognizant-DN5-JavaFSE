package com.library.service;

import com.library.repository.BookRepository;

/**
 * Exercise 1: Configuring a Basic Spring Application
 * Exercise 2: Implementing Dependency Injection
 *
 * Scenario (from docx): BookService depends on BookRepository.
 * Spring IoC will inject BookRepository into BookService via setter
 * injection (as specified in Exercise 2 steps).
 */
public class BookService {

    // This will be injected by Spring — not created manually with "new"
    private BookRepository bookRepository;

    /**
     * Exercise 2: Setter method for BookRepository DI.
     * The docx explicitly says "Ensure that BookService class
     * has a setter method for BookRepository."
     */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected by Spring.");
    }

    public void addBook(String bookName) {
        System.out.println("BookService: addBook() called.");
        bookRepository.addBook(bookName);
    }

    public String findBook(String bookName) {
        System.out.println("BookService: findBook() called.");
        return bookRepository.findBook(bookName);
    }
}