package com.assignment.com.registration.assignment.service;

import com.assignment.com.registration.assignment.entity.User;

/**
 * @author Vaishnavi Bagal
 * @version 1.0
 */

public interface UserService {

    void sendWelcomeEmail(User user);

    void syncToCRM(User user);

    void thirdPartySystem(User user);
}
