package com.imprenta.service_auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secretito;
    public String generarToken(String nombreUsuario, List<String> roles) {
        long dosHoritas = 1000 * 60 * 60 * 2 ; // 2 horitas
        return Jwts.builder()
            .setSubject(nombreUsuario)
            .claim("roles", roles)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + dosHoritas))
            .signWith(Keys.hmacShaKeyFor(secretito.getBytes()), SignatureAlgorithm.HS256)
            .compact();
    }

}
