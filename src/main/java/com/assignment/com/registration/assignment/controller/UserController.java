package com.assignment.com.registration.assignment.controller;

import com.assignment.com.registration.assignment.mongoDB.entity.UserMetaData;
import com.assignment.com.registration.assignment.service.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/metadata/{userId}")
//    @Cacheable(value = "userMetaData",key="#userId")
    public ResponseEntity<UserMetaData> getUserMetaData(@NotNull @PathVariable("userId") String userId){
            return ResponseEntity.ok(userService.getUserMetaData(userId));
    }


}
