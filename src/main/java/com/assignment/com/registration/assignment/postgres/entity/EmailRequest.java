package com.assignment.com.registration.assignment.postgres.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 *
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "from_email")
    private String from;
    @Column(name = "to_email")
    private String to;
    private String subject;
    private String body;
    private String status;
    @Builder.Default
    private Integer retryCount = 0;
    private String userId;
}
