package com.example.uberauthservice.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService implements CommandLineRunner {
  @Value("${jwt.secret}")
    private String SECRET;
   @Value("${jwt.expiry}")
    private int expiry;

    public SecretKey getSignKey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }
   public String createToken(Map<String,Object>payload,String email){
       return Jwts.builder().
                claims(payload).
               subject(email).
               issuedAt(new Date(System.currentTimeMillis())).
               expiration(new Date(System.currentTimeMillis() + expiry)).
               signWith(getSignKey()).
               compact();
   }

   public String createToken(String email){

        return createToken(new HashMap<>(),email);
   }
  public Claims extractAllClaim(String token){
        return Jwts.
                parser().
                verifyWith(getSignKey()).
                build().parseSignedClaims(token).
                getPayload();
  }
   public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        Claims claims = extractAllClaim(token);
        return claimsResolver.apply(claims);

   }

   public String extractUserName(String token){

        return extractClaim(token,Claims::getSubject);
   }

   public Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
   }

   public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
   }

   public String extractPhoneNumber(String token,String payload){
        Claims claims=extractAllClaim(token);
        return (String) claims.get(payload);
   }

   public boolean validateToken(String token,String email){
        String username=extractUserName(token);
        return (username.equals(email)) &&  !isTokenExpired(token);
   }
    @Override
    public void run(String... args) throws Exception {
        Map<String,Object>mp=new HashMap<>();
        mp.put("email","abc@123");
        mp.put("phoneNumber","9770353390");
        String result=createToken(mp,"uzer@12");
        //System.out.println(extractUserName(result));
       // System.out.println(extractPhoneNumber(result,"phoneNumber"));
        //System.out.println(validateToken(result));
        //System.out.println(isTokenExpired(result));
        System.out.println(validateToken(result,null));

    }
}

