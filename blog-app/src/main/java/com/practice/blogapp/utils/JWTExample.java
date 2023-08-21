package com.practice.blogapp.utils;

import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTExample {

    public static void main(String[] args) {
        // Generate a secure key for HS512
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        // Sample claims
        String subject = "abcd12345";
        Date expirationDate = new Date(System.currentTimeMillis() + 3600000); // 1 hour from now

        // Generate a JWT
        String jwt = Jwts.builder()
                .setSubject(subject)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();

        System.out.println("Generated JWT: " + jwt);

        // Verify the JWT
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt);
            System.out.println("JWT is valid.");
        } catch (Exception e) {
            System.out.println("JWT is not valid: " + e.getMessage());
        }
    }
}
