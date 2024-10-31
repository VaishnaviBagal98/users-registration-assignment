package com.assignment.com.registration.assignment.service;

import com.assignment.com.registration.assignment.mongoDB.entity.UserMetaData;
import com.assignment.com.registration.assignment.postgres.entity.User;

/**
 * @author Vaishnavi Bagal
 * @version 1.0
 */

public interface RegistrationService {

    void sendWelcomeEmail(User user);

    void syncToCRM(User user);

    void thirdPartySystem(User user);
}
