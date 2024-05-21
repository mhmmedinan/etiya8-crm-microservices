package com.etiya.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JwtService {
    private static final String SECRET_KEY = "12023660c1601aaada3da96a4a80612e291ec33b28f60b58191f8b2845eb237bc978efb4d339d0b09f285cda79c5d67eef4458d6cefbd592ac663c783d1a64ee";
    private static final long EXPIRATION = 600000;

    public String generateToken(String userName, List<String> roles) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles);
        return createToken(claims, userName);
    }

    public Boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    public List<String> extractRoles(String token) {
        return getClaimsFromToken(token).get("roles", List.class);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    private Date extractExpiration(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
