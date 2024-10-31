package com.assignment.com.registration.assignment.mongoDB.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMetaData {

    private Long id;
    private HashMap<String,String> orderNotes;
    private HashMap<String,String> specialFlags;
}
