package com.cognizant.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Account Microservice Controller (as specified in docx).
 * Method: GET
 * Endpoint: /accounts/{number}
 * Returns: dummy account response (no backend connectivity)
 */
@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {
        // Dummy response as specified in docx
        return new Account("00987987973432", "savings", 234343);
    }
}