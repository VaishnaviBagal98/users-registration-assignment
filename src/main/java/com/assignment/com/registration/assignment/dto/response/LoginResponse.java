package com.assignment.com.registration.assignment.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String token;

    private long expiresIn;
}