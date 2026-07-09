package com.cognizant.dn5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Exercise 1: Setting Up JUnit
 * Scenario: Set up JUnit in your Java project to start writing unit tests.
 */
public class JUnit_Ex1_SetupTest {

    @Test
    public void testJUnitIsWorking() {
        // If this test runs and passes, JUnit 5 is correctly set up.
        int result = 2 + 3;
        assertEquals(5, result, "Basic math should work: 2 + 3 = 5");
        System.out.println("JUnit 5 setup verified successfully.");
    }
}