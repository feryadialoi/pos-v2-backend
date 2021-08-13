package com.gdi.posbackend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtUtil {
    public String generateAccessToken(Long userId, String subject, String tokenId) {
        Date expiresAt = new Date(System.currentTimeMillis() + JwtAuthenticationProperties.EXPIRATION_TIME);

        Algorithm sign = Algorithm.HMAC512(JwtAuthenticationProperties.KEY.getBytes());

        return JWT.create()
                .withSubject(subject)
                .withIssuedAt(new Date())
                .withClaim("tokenId", tokenId)
                .withClaim("userId", userId)
                .withExpiresAt(expiresAt)
                .sign(sign);
    }

    public String generateAccessToken(String accessToken) {
        return generateAccessToken(
                getUserId(accessToken),
                getSubject(accessToken),
                getTokenId(accessToken)
        );
    }

    public String generateRefreshToken(String tokenId) {
        Date expiresAt = new Date(System.currentTimeMillis() + JwtAuthenticationProperties.REFRESH_EXPIRATION_TIME);

        Algorithm sign = Algorithm.HMAC512(JwtAuthenticationProperties.KEY.getBytes());

        return JWT.create()
                .withIssuedAt(new Date())
                .withClaim("tokenId", tokenId)
                .withExpiresAt(expiresAt)
                .sign(sign);
    }

    public DecodedJWT verifyToken(String token) {
        return JWT.require(Algorithm.HMAC512(JwtAuthenticationProperties.KEY.getBytes()))
                .build()
                .verify(token);
    }

    public DecodedJWT decode(String token) {
        return JWT.decode(token);
    }


    public Long getUserId(DecodedJWT decodedJWT) {
        return decodedJWT.getClaim("userId").asLong();
    }

    public Long getUserId(String accessToken) {
        return getUserId(decode(accessToken));
    }

    public String getTokenId(String token) {
        return getTokenId(decode(token));
    }

    public String getTokenId(DecodedJWT decodedJWT) {
        return decodedJWT.getClaim("tokenId").asString();
    }

    public String getSubject(String accessToken) {
        return getSubject(decode(accessToken));
    }

    public String getSubject(DecodedJWT decodedJWT) {
        return decodedJWT.getSubject();
    }
}
