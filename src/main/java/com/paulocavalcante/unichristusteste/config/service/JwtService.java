package com.paulocavalcante.unichristusteste.config.service;

import java.security.Key;
import java.util.Base64;
import java.util.Optional;

import com.auth0.jwt.interfaces.Claim;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import com.paulocavalcante.unichristusteste.entity.Usuario;

@Service
public class JwtService {

    private final String SECRET_KEY = "6253bcb5ca3596cb70c438510dea7ab7d8ed40dfd2fe8c704473e3d7ba725bf6";

    public Object generateTokenUser(Optional<Usuario> user) {
        return null;
    }


    public String extractUserEmail(String token) {
        return null;
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKeys())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKeys() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
