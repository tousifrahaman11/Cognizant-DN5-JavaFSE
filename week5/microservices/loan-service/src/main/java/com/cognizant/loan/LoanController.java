package com.cognizant.loan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Loan Microservice Controller (as specified in docx).
 * Method: GET
 * Endpoint: /loans/{number}
 * Returns: dummy loan response (no backend connectivity)
 */
@RestController
public class LoanController {

    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable String number) {
        // Dummy response as specified in docx
        return new Loan("H00987987972342", "car", 400000, 3258, 18);
    }
}