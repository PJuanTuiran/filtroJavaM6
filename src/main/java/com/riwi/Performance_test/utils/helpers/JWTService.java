package com.riwi.Performance_test.utils.helpers;

import com.riwi.Performance_test.domain.models.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Component
public class JWTService {

        private final String SECRET_KEY = "WN1cGVWVzhZHyc2VjcmV0YWVzhZHZpbmU=";

        public SecretKey getKey() {
            byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
            return Keys.hmacShaKeyFor(keyBytes);
        }

        public String generateJWT(Map<String, Object> claims, UserEntity user) {
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(user.getUsername())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 100 * 60 * 60 * 24))
                    .signWith(getKey())
                    .compact();
        }


        public String getToken(UserEntity user) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", user.getUsername());
            claims.put("roles", user.getRoles().name());

            return generateJWT(claims, user);
        }

        public Claims getALlClaims(String token) {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();


        }

        public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
            final Claims claims = getALlClaims(token);
            return claimsResolver.apply(claims);
        }

        public String getUsernameFromToken(String token) {
            return getClaim(token, Claims::getSubject);
        }
}
