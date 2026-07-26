package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

/**
 * Exercise 1: Run the Application — load Spring context and test.
 * Exercise 2: Test the Configuration — verify DI is working.
 *
 * Docx says: "Create a main class to load the Spring context
 * and test the configuration."
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {

        System.out.println("=== Library Management System Starting ===");

        // Load the Spring ApplicationContext from XML config
        // This is where Spring reads applicationContext.xml,
        // creates all beans, and injects dependencies automatically.
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\nSpring context loaded successfully.");

        // Get the BookService bean from the context
        // Spring already injected BookRepository into it via setter DI
        BookService bookService = context.getBean("bookService", BookService.class);

        System.out.println("\n--- Testing BookService (Exercise 1 & 2) ---");
        bookService.addBook("Spring in Action");
        String found = bookService.findBook("Spring in Action");
        System.out.println("Found: " + found);

        System.out.println("\n=== Application Finished ===");

        // Close context to release resources
        ((ClassPathXmlApplicationContext) context).close();
    }
}