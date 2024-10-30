package com.assignment.com.registration.assignment.service;

import com.assignment.com.registration.assignment.repository.EmailRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * This service implemented to send email to user for notifications.
 *
 * @author Vaishnavi Bagal
 * @version 1.0
 */
@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private EmailRequestRepository emailRequestRepository;

    @Scheduled(fixedDelay = 1000)
    public void sendMail() {
        log.info("Checking for email requests");
        emailRequestRepository.findAllEligibleRequest().forEach(
                emailRequest -> {
                    try {
                        log.info("Starting email send for {}", emailRequest.getId());
                        SimpleMailMessage message = new SimpleMailMessage();
                        message.setFrom("vaishnavibagal1998@gmail.com");
                        message.setTo(emailRequest.getTo());
                        message.setSubject(emailRequest.getSubject());
                        message.setText(emailRequest.getBody());
                        emailSender.send(message);
                        emailRequest.setStatus("Successful");
                        log.info("Email sent SuccessFul for {}", emailRequest.getId());
                    } catch (Exception e) {
                        log.error("Email sent Failed {}", e.getMessage());
                        emailRequest.setStatus("FAILED");
                        emailRequest.setRetryCount(emailRequest.getRetryCount() + 1);
                    }
                    emailRequestRepository.save(emailRequest);
                }
        );

    }


}
