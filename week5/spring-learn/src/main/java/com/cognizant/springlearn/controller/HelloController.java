package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello World REST endpoint (as specified in docx, Hands on 2).
 *
 * Docx says:
 * Method: GET
 * URL: /hello
 * Controller: com.cognizant.spring-learn.controller.HelloController
 * Method: sayHello()
 * Returns: "Hello World!!"
 */
@RestController
public class HelloController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("START sayHello");
        LOGGER.info("END sayHello");
        return "Hello World!!";
    }
}