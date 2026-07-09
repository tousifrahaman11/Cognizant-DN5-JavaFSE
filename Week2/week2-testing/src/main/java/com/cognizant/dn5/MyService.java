package com.cognizant.dn5;

/**
 * Service class that depends on ExternalApi.
 * This is the class we want to test — by mocking
 * ExternalApi, we isolate MyService completely.
 */
public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}