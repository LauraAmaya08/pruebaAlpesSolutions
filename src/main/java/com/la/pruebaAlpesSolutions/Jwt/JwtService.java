package com.la.pruebaAlpesSolutions.Jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;


//Servicio que genera los tokens

@Service
public class JwtService {

    private static final String LLAVE = "SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJVADSadQssw5cM";

    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, LLAVE)
                .compact();
    }
}
