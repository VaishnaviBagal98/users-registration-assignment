package com.assignment.com.registration.assignment.mongoDB.repository;

import com.assignment.com.registration.assignment.mongoDB.entity.UserMetaData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserMetaDataRepository extends MongoRepository<UserMetaData, String> {
}
