package com.hardworking.training.service;

import com.hardworking.training.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Service
public class JWTService {
    private final String SECRET_KEY = "hangechen-ascending";
    private final String ISSUER = "com.hardworking";
    private final long  EXPIRATION_TIME=86400*2000;
    public String generateToken(User user){
        //JWT signature algorithm using to sign the token
        SignatureAlgorithm  signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());

        Claims claims = Jwts.claims();
        claims.setId(String.valueOf(user.getId()));
        claims.setSubject(user.getName());
        claims.setIssuedAt(new Date(System.currentTimeMillis()));
        claims.setIssuer(ISSUER);
        claims.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME));


        JwtBuilder builder = Jwts.builder().setClaims(claims).signWith(signatureAlgorithm,signingKey);
        return builder.compact();
    }
    public User decyptToken(String token){
        return null;
    }
}
