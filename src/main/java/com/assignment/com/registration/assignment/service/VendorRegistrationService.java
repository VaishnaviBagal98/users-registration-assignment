package com.assignment.com.registration.assignment.service;

import com.assignment.com.registration.assignment.postgres.entity.EmailRequest;
import com.assignment.com.registration.assignment.postgres.entity.User;
import com.assignment.com.registration.assignment.postgres.repository.EmailRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class holds all the operation w.r.t Admin user
 *
 * @author Vaishnavi Bagal
 * @version 1.0
 */

@Service("Vendor")
@Slf4j
public class VendorRegistrationService implements RegistrationService {
    @Autowired
    private EmailRequestRepository emailRequestRepository;

    @Override
    public void sendWelcomeEmail(User user) {
        EmailRequest emailRequest = EmailRequest.builder()
                .to(user.getEmail())
                .from("vaishnavibagal1998@gmail.com")
                .subject("Registration Successful")
                .body("You are registered as Vendor")
                .status("PENDING")
                .userId(user.getId().toString())
                .build();

        log.info("Saving email request details for Vendor user");
        emailRequestRepository.save(emailRequest);
    }

    @Override
    public void syncToCRM(User user) {

    }

    @Override
    public void thirdPartySystem(User user) {

    }
}
