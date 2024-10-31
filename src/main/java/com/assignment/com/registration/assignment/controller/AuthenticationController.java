package com.assignment.com.registration.assignment.controller;

import com.assignment.com.registration.assignment.dto.request.LoginUserDto;
import com.assignment.com.registration.assignment.dto.request.RegisterUserDto;
import com.assignment.com.registration.assignment.dto.response.LoginResponse;
import com.assignment.com.registration.assignment.postgres.entity.User;
import com.assignment.com.registration.assignment.service.AuthenticationService;
import com.assignment.com.registration.assignment.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vaishnavi Bagal
 * @version 1.0
 */

@RequestMapping("/auth")
@RestController
@Slf4j
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        log.info("Signup process started");
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        UserDetails authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = LoginResponse.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();
        log.info("Login process started");
        return ResponseEntity.ok(loginResponse);
    }
}