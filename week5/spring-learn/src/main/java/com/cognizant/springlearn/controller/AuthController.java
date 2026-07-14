package com.cognizant.springlearn.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.security.JwtUtil;

/**
 * Authentication endpoint (as specified in docx, JWT hands on).
 * POST /authenticate with username + password → returns JWT token.
 */
@RestController
public class AuthController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestBody Map<String, String> credentials) {

        LOGGER.info("START authenticate");

        String username = credentials.get("username");
        String password = credentials.get("password");

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        String token = jwtUtil.generateToken(auth.getName());
        LOGGER.debug("JWT generated for user: {}", username);
        LOGGER.info("END authenticate");

        return Map.of("token", token);
    }
}