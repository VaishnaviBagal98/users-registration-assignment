package com.assignment.com.registration.assignment.controller;

import com.assignment.com.registration.assignment.entity.User;
import com.assignment.com.registration.assignment.service.UserRegistrationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody User user) {
        log.info("Inside the UserRegistrationService");
        return userRegistrationService.registerUser(user);
    }
}
