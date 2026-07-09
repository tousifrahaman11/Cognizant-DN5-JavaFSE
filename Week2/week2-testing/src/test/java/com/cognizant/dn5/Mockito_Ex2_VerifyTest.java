package com.cognizant.dn5;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

/**
 * Exercise 2: Verifying Interactions
 * Scenario: Ensure that a method is called with specific arguments.
 * Solution matches the PDF exactly.
 */
public class Mockito_Ex2_VerifyTest {

    @Test
    public void testVerifyInteraction() {
        // ARRANGE: Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // ACT
        service.fetchData();

        // ASSERT: Verify that getData() was called exactly once
        verify(mockApi).getData();
        System.out.println("Mockito verification passed: getData() was called.");
    }
}