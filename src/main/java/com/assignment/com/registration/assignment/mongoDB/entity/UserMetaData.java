package com.assignment.com.registration.assignment.mongoDB.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserMetaData {
    private String id;
    private HashMap<String,String> userPreference;
    private HashMap<String,String> settings;
}
