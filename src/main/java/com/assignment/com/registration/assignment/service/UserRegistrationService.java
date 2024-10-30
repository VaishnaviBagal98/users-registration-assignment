package com.assignment.com.registration.assignment.service;

import com.assignment.com.registration.assignment.entity.User;
import com.assignment.com.registration.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * This class holds all type of user registration
 * @author Vaishnavi Bagal
 * @version 1.0
 */

@Service
@Slf4j
public class UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationContext applicationContext;

    public User registerUser(User user) {
        log.info("Inside the UserRegistrationService");
        User createduser = userRepository.save(user);
        UserService userService;
        try {
            userService = (UserService) applicationContext.getBean(user.getUserType());
        } catch (Exception ex) {
            throw new RuntimeException("User Type Not Supported");
        }

        userService.sendWelcomeEmail(user);
        

        return createduser;
    }


}
