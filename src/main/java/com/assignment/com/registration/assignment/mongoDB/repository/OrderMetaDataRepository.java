package com.assignment.com.registration.assignment.mongoDB.repository;

import com.assignment.com.registration.assignment.mongoDB.entity.OrderMetaData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMetaDataRepository extends MongoRepository<OrderMetaData,Long> {
}
