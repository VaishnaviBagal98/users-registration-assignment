package com.assignment.com.registration.assignment.dto.request;

import lombok.Data;
import java.util.HashMap;


@Data
public class RegisterUserDto {
    private String email;
    private String password;
    private String name;
    private String userType;
    private HashMap<String,String> userPreference;
    private HashMap<String,String> settings;
}
