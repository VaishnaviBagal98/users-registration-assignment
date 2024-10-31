package com.assignment.com.registration.assignment.service;

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
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMetaDataRepository userMetaDataRepository;

    public User getUserDetail(String userId){
        return userRepository.findById(UUID.fromString(userId)).get();
    }

    public UserMetaData getUserMetaData(String userId){
        log.info("Start getUserMetaData");
        return userMetaDataRepository.findById(userId).get();
    }



}
