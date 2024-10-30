package com.assignment.com.registration.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity(name = "user_data")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Name is mandatory")
    @Length(min = 1, message = "Name cannot be blank")
    private String name;

    @Email(message = "Please provide a valid email address")
    private String email;

    @NotNull(message = "User type is mandatory")
    @Length(min = 1, message = "User type cannot be blank")
    private String userType;
}
