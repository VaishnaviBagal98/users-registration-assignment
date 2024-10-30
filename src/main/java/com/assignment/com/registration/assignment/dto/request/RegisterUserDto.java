package com.assignment.com.registration.assignment.dto.request;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;

    private String password;

    private String fullName;
}
