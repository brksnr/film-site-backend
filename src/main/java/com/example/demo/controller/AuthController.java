package com.example.demo.controller;


import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.exceptions.ApiException;
import com.example.demo.memberEntity.Member;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;


    @Autowired
    public AuthController(AuthenticationService authenticationService, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }



    @PostMapping("/register")
    public ResponseEntity<Member> register(@RequestBody RegistrationRequest request) {
        Member registeredMember = authenticationService.register(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );
        return ResponseEntity.ok(registeredMember);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Member member = authenticationService.login(loginRequest.getEmail(), loginRequest.getPassword());

        if (member != null) {
            String token = jwtService.generateToken(member.getEmail());

            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            loginResponse.setUsername(member.getUsername());
            loginResponse.setEmail(member.getEmail());

            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyToken(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);

        if (jwtService.validateToken(token)) {
            String username = jwtService.extractUsername(token);
            return ResponseEntity.ok("Token valid for user: " + username);
        } else {
            return ResponseEntity.status(401).body("Invalid token");
        }
    }








}
