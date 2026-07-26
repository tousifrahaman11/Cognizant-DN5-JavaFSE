package com.cognizant.springlearn.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * JWT utility class (as specified in docx, JWT hands on).
 * Generates a JWT token for authenticated users.
 */
@Component
public class JwtUtil {

    // Secret key — must be at least 256 bits for HS256
    private static final String SECRET =
            "cognizant-dn5-secret-key-must-be-long-enough-32chars";

    private static final long EXPIRY_MS = 1000 * 60 * 60; // 1 hour

    /**
     * Generate a JWT token for the given username.
     * Docx says: "create JWT, set token expiry"
     */
    public String generateToken(String username) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRY_MS))
                .signWith(key)
                .compact();
    }
}