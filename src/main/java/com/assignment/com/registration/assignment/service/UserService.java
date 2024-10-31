package com.assignment.com.registration.assignment.service;

import com.assignment.com.registration.assignment.dto.request.UpdateUserDto;
import com.assignment.com.registration.assignment.mongoDB.entity.UserMetaData;
import com.assignment.com.registration.assignment.mongoDB.repository.UserMetaDataRepository;
import com.assignment.com.registration.assignment.postgres.entity.User;
import com.assignment.com.registration.assignment.postgres.repository.UserRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMetaDataRepository userMetaDataRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User getUserDetail(String userId){
        return userRepository.findById(UUID.fromString(userId)).get();
    }

    public UserMetaData getUserMetaData(String userId){
        log.info("Start getUserMetaData");
        return userMetaDataRepository.findById(userId).get();
    }

    @Transactional(value = "chainedTransactionManager")
    public void deleteUser(String userId){
        if (userRepository.existsById(UUID.fromString(userId))) {
            userRepository.deleteById(UUID.fromString(userId));
            userMetaDataRepository.deleteById(userId);
        } else {
           throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional(value = "chainedTransactionManager")
    public User updateUser(UpdateUserDto updateUserDto){
        Optional<User> existingUser = userRepository.findById(UUID.fromString(updateUserDto.getId()));
        if (existingUser.isPresent()) {
            User user = existingUser.get();

            userRepository.save(
            User.builder()
                    .userType(Objects.nonNull(updateUserDto.getUserType())?updateUserDto.getUserType():user.getUserType())
                    .email(Objects.nonNull(updateUserDto.getEmail())?updateUserDto.getEmail():user.getEmail())
                    .password(Objects.nonNull(updateUserDto.getPassword())?passwordEncoder.encode(updateUserDto.getPassword()):user.getPassword())
                    .name(Objects.nonNull(updateUserDto.getName())?updateUserDto.getName():user.getName())
                    .id(user.getId())
                    .build());

            UserMetaData exitingUserMetaData = userMetaDataRepository.findById(updateUserDto.getId()).get();

            userMetaDataRepository.save(
                    UserMetaData.builder()
                            .userPreference(Objects.nonNull(updateUserDto.getUserPreference())?updateUserDto.getUserPreference():exitingUserMetaData.getUserPreference())
                            .settings(Objects.nonNull(updateUserDto.getSettings())?updateUserDto.getSettings():exitingUserMetaData.getSettings())
                            .build()
            );
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return userRepository.findById(UUID.fromString(updateUserDto.getId())).get();
    }


}
