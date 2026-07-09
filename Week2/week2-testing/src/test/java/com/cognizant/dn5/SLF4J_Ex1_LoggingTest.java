package com.cognizant.dn5;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 1: Logging Error Messages and Warning Levels
 * Task: Demonstrate logging error messages and warning levels using SLF4J.
 * Solution matches the PDF exactly (using LoggerFactory pattern).
 */
public class SLF4J_Ex1_LoggingTest {

    // Standard SLF4J logger setup — same pattern from the PDF
    private static final Logger logger =
            LoggerFactory.getLogger(SLF4J_Ex1_LoggingTest.class);

    @Test
    public void testLoggingLevels() {
        // These match the PDF's LoggingExample class exactly
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.info("This is an info message");
        logger.debug("This is a debug message");

        System.out.println("SLF4J logging test completed - check console for log output.");
    }
}