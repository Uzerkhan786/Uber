package com.example.uberauthservice.Controllers;

import com.example.uberauthservice.Service.AuthService;
import com.example.uberauthservice.Service.JwtService;
import com.example.uberauthservice.dtos.AuthRequestDto;
import com.example.uberauthservice.dtos.PassengerDto;
import com.example.uberauthservice.dtos.PassengerRequestDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

 private final AuthService authService;
 private final AuthenticationManager authenticationManager;
private final JwtService jwtService;
    public AuthController(AuthService authService,AuthenticationManager authenticationManager,JwtService jwtService ) {
     this.authService = authService;
     this.authenticationManager = authenticationManager;
    this.jwtService = jwtService;
    }
@PostMapping("/signup")
    public ResponseEntity<?>  AuthSingupController(@RequestBody PassengerRequestDto passengerRequestDto){

      PassengerDto passengerDto = this.authService.AuthPassengerService(passengerRequestDto);
      return new ResponseEntity<>(passengerDto, HttpStatus.OK);

    }
    private String t;

    @PostMapping("/signin")
    public ResponseEntity<?>AuthSigninController(@RequestBody AuthRequestDto authRequestDto, HttpServletResponse response){
        Authentication authentication=authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(),authRequestDto.getPassword()));
        if (authentication.isAuthenticated()){
            String token=jwtService.createToken(authRequestDto.getEmail());
            t=token;
            ResponseCookie cookie= ResponseCookie.from("jwtToken",token).
                    httpOnly(false).
                    secure(false).
                    path("/").
                    maxAge(3600).
                    build();
            //System.out.println(cookie);
            response.setHeader(HttpHeaders.SET_COOKIE,cookie.toString());
            return new ResponseEntity<>("Token is ", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("User not found",HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<?> ValidateController(HttpServletRequest request){
         for(Cookie cookie:request.getCookies()){
             System.out.println("name is "+ cookie.getName());
             System.out.println("value is "+ cookie.getValue());
             String user=jwtService.extractUserName(cookie.getValue());
             System.out.println(user);
         }
         return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
