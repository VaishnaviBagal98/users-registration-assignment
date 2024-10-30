package com.assignment.com.registration.assignment.service;

import com.assignment.com.registration.assignment.entity.EmailRequest;
import com.assignment.com.registration.assignment.entity.User;
import com.assignment.com.registration.assignment.repository.EmailRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class holds all the operation w.r.t Customer user
 * @author Vaishnavi Bagal
 * @version 1.0
 */

@Service("Customer")
@Slf4j
public class CustomerUserService implements UserService {

    @Autowired
    private EmailRequestRepository emailRequestRepository;

    @Override
    public void sendWelcomeEmail(User user) {
        EmailRequest emailRequest = EmailRequest.builder()
                .to(user.getEmail())
                .from("vaishnavibagal1998@gmail.com")
                .subject("Registration Successful")
                .body("You are registered as Customer")
                .status("PENDING")
                .userId(user.getId().toString())
                .build();

        log.info("Saving email request details for Customer user");
        emailRequestRepository.save(emailRequest);
        
    }

    @Override
    public void syncToCRM(User user) {

    }

    @Override
    public void thirdPartySystem(User user) {

    }
}
