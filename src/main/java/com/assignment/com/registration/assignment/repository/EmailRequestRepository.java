package com.assignment.com.registration.assignment.repository;

import com.assignment.com.registration.assignment.entity.EmailRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * This Interface responsible for saving email request to database
 * @author Vaishnavi Bagal
 * @version 1.0
 */

@Repository
public interface EmailRequestRepository extends JpaRepository<EmailRequest, UUID> {
    @Query(value = "select * from email_request where status = 'PENDING' or (status = 'FAILED' and retry_count < 3)", nativeQuery = true)
    List<EmailRequest> findAllEligibleRequest();

}

