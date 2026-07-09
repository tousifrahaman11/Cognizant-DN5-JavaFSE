package com.cognizant.dn5;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Exercise 4: AAA Pattern, Test Fixtures, Setup and Teardown Methods
 * Scenario: Organize tests using Arrange-Act-Assert pattern
 * and use setup/teardown methods.
 */
public class JUnit_Ex4_AAAPatternTest {

    private int[] numbers;

    // @BeforeEach runs before EVERY test method — this is "setup"
    @BeforeEach
    public void setUp() {
        numbers = new int[]{1, 2, 3, 4, 5};
        System.out.println("Setup: numbers array initialized.");
    }

    // @AfterEach runs after EVERY test method — this is "teardown"
    @AfterEach
    public void tearDown() {
        numbers = null;
        System.out.println("Teardown: numbers array cleared.");
    }

    @Test
    public void testSum() {
        // ARRANGE — already done in setUp()

        // ACT
        int sum = 0;
        for (int n : numbers) sum += n;

        // ASSERT
        assertEquals(15, sum);
        System.out.println("testSum passed: sum = " + sum);
    }

    @Test
    public void testLength() {
        // ARRANGE — already done in setUp()

        // ACT
        int length = numbers.length;

        // ASSERT
        assertEquals(5, length);
        System.out.println("testLength passed: length = " + length);
    }
}