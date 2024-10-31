package com.assignment.com.registration.assignment.service;

import com.assignment.com.registration.assignment.dto.request.RegisterUserDto;
import com.assignment.com.registration.assignment.mongoDB.entity.UserMetaData;
import com.assignment.com.registration.assignment.mongoDB.repository.UserMetaDataRepository;
import com.assignment.com.registration.assignment.postgres.entity.User;
import com.assignment.com.registration.assignment.postgres.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * This class holds all type of user registration
 *
 * @author Vaishnavi Bagal
 * @version 1.0
 */

@Service
@Slf4j
public class UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMetaDataRepository userMetaDataRepository;

    @Autowired
    private ApplicationContext applicationContext;

//    @Transactional(value = "chainedTransactionManager")
    public User registerUser(RegisterUserDto registerUserDto) {

        RegistrationService registrationService;

        log.info("Starting UserRegistrationService {}",registerUserDto);
        try {
            registrationService = (RegistrationService) applicationContext.getBean(registerUserDto.getUserType());
        } catch (Exception ex) {
            throw new RuntimeException("User Type Not Supported");
        }

        User user = User.builder()
                .name(registerUserDto.getName())
                .email(registerUserDto.getEmail())
                .password(registerUserDto.getPassword())
                .userType(registerUserDto.getUserType())
                .build();
        User createduser = userRepository.save(user);

        UserMetaData userMetaData = UserMetaData.builder()
                .userPreference(registerUserDto.getUserPreference())
                .settings(registerUserDto.getSettings())
                .id(createduser.getId().toString())
                .build();

        UserMetaData createUserMetaData = userMetaDataRepository.save(userMetaData);

        log.info("Sending Welcome email");
        registrationService.sendWelcomeEmail(user);

        return createduser;
    }


}
