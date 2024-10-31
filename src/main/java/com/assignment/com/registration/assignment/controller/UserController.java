package com.assignment.com.registration.assignment.controller;

import com.assignment.com.registration.assignment.dto.request.UpdateUserDto;
import com.assignment.com.registration.assignment.mongoDB.entity.UserMetaData;
import com.assignment.com.registration.assignment.postgres.entity.User;
import com.assignment.com.registration.assignment.postgres.repository.UserRepository;
import com.assignment.com.registration.assignment.service.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/metadata/{userId}")
    @Cacheable(value = "userMetaData",key="#userId")
    public ResponseEntity<UserMetaData> getUserMetaData(@NotNull @PathVariable("userId") String userId){
            return ResponseEntity.ok(userService.getUserMetaData(userId));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllItems() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getItemById(@PathVariable UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping()
    @CachePut(value = "userMetaData",key="#userDetails.userId")
    public ResponseEntity<User> updateItem(@RequestBody UpdateUserDto updateUserDto) {

    }

    @CacheEvict(value = "userMetaData",key="#userId")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
