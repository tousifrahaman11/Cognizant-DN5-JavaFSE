package com.cognizant.dn5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 * Exercise 1: Mocking and Stubbing
 * Scenario: Test a service that depends on an external API.
 * Use Mockito to mock the API and stub its methods.
 * Solution matches the PDF exactly.
 */
public class Mockito_Ex1_MockingTest {

    @Test
    public void testExternalApi() {
        // ARRANGE: Create mock object for ExternalApi
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub: when getData() is called, return "Mock Data"
        when(mockApi.getData()).thenReturn("Mock Data");

        // Inject mock into service
        MyService service = new MyService(mockApi);

        // ACT
        String result = service.fetchData();

        // ASSERT
        assertEquals("Mock Data", result);
        System.out.println("Mockito stubbing verified: result = " + result);
    }
}