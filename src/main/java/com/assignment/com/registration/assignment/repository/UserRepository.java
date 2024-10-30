package com.assignment.com.registration.assignment.repository;

import com.assignment.com.registration.assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * This Interface responsible for saving email user to database
 *
 * @author Vaishnavi Bagal
 * @version 1.0
 */

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

}
