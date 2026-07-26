package com.cognizant.dn5;

/**
 * Simulates an external API dependency.
 * In production this would call a real external service.
 * In tests, Mockito will mock this interface.
 */
public interface ExternalApi {
    String getData();
}