package com.JWT.Security.demo.Security;

import com.JWT.Security.demo.Service.UserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

//@Component
//public class JwtUtility {
//
//    private final String secret = "JWT";
//
//    public String generateToken(UserDetails user){
//
//        String roles = user.getAuthorities().stream()
//                .map(GrantedAuthority :: getAuthority)
//                .collect(Collectors.joining(","));
//
//
//        return Jwts.builder()
//                .setSubject(user.getUsername())
//                .claim("roles",roles)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
//                .signWith(SignatureAlgorithm.HS256,secret)
//                .compact();
//    }
//
//
//    public String extractUsername(String token){
//        return extractAllClaims(token).getSubject();
//    }
//
//    private String extractRoles(String token){
//        return extractAllClaims(token).get("roles",String.class);
//    }
//
//    protected boolean validateToken(String token, UserDetails user){
//        return extractAllClaims(token).equals(user.getUsername()) && !istokenExpired(token);
//    }
//    //istokenExpired
//    private boolean istokenExpired(String token) {
//        return extractAllClaims(token).getExpiration().before(new Date());
//    }
//
//
//    private Claims extractAllClaims(String token){
//        return Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//}

//@Component
//public class JwtUtility{
//
//    public final String secret = "secret";
//
//    public String generateToken(UserDetails userDetails) {
//
//        Map<String,Object> claims = new HashMap<>();
//        claims.put("Roles",userDetails.getAuthorities()
//                .stream().map(GrantedAuthority::getAuthority)
//                .toList());
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(userDetails.getUsername())
//                .signWith(SignatureAlgorithm.HS256,secret)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()*1000*60*60))
//                .compact();
//    }
//
//    public Claims extractClaims(String token){
//        return Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public String extractUsername(String token){
//        return extractClaims(token).getSubject();
//    }
//
//    public boolean isExpired(String token){
//        return extractClaims(token).getExpiration().before(new Date());
//    }
//
//    public boolean validateToken(String token, UserDetails  userDetails){
//        return extractClaims(token).equals(userDetails.getUsername()) && !isExpired(token);
//    }


@Component
public class JwtUtility {

    private final String secretKey = "JWT_SECRET_KEY";

    public String generateToken(UserDetails userDetails) {

       Map<String,Object> claims = new HashMap<>();
       claims.put("roles",userDetails.getAuthorities()
               .stream()
               .map(GrantedAuthority::  getAuthority)
               .toList());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((System.currentTimeMillis() * 1000 * 60 * 60)))
                .compact();

    }

    public Claims extractClaims(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }


    public boolean validateToken(String token, UserDetails userDetails){
        return extractClaims(token).equals(userDetails.getUsername()) && !isExpired(token);
    }

    public boolean isExpired(String token){
        return extractClaims(token).getExpiration().before(new Date());
    }

    public String extractUsername(String token){
        return extractClaims(token).getSubject();
    }


}
