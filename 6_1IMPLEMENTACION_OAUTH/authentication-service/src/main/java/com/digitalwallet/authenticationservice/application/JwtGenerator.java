package com.digitalwallet.authenticationservice.application;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtGenerator {
    private final Environment environment;

    public String generateToken(String subject) {
        long EXPIRATION_TIME = 600000L;
        Key keyGenerated = getSigningKey();
        System.out.println(keyGenerated.getEncoded());
        return "Bearer ".concat(Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(keyGenerated, SignatureAlgorithm.HS256)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact());
    }

    private Key getSigningKey() {
        String SECRET_KEY = environment.getProperty("token.key");
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
