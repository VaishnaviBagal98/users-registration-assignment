package com.assignment.com.registration.assignment.dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author Vaishnavi Bagal
 * @version 1.0
 */

@Data
@Builder
public class LoginResponse {
    private String token;

    private long expiresIn;
}