package com.example.ipd_team_klean.security;

import com.example.ipd_team_klean.Entity.Admin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@Slf4j
public class TokenProvider {
    private  static  final  String SECRET_KEY = "NMA8JPctFuna59f511ffff23257uuiuffff54ak";

    Date now  = new Date();

    long tokenPeriod = 1000L * 60L * 10L; //토큰 유효 시간

    long refreshPeriod =1000L * 60L * 60L * 24L * 30L * 3L; //refresh토큰 유효시간

    public  String create(Admin admin){
        Date expiryDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
        Date expiryDaterefresh = Date.from(Instant.now().plus(3,ChronoUnit.DAYS));
        Token token = new Token(Jwts.builder()
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .setSubject(admin.getEmail())
                .setIssuer("ipd")
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .compact(),
                Jwts.builder()
                        .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                        .setSubject(admin.getEmail())
                        .setIssuer("ipd")
                        .setIssuedAt(new Date())
                        .setExpiration(expiryDaterefresh)
                        .compact());

        return token.getToken();
    }
    public boolean booleanexp (String token){
        boolean booltoken = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration().after(new Date());
        return booltoken;
    }

    // 토큰 검증
    public String validateAndGetUserEmail(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
