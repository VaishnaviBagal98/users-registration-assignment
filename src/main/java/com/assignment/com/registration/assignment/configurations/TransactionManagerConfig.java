package com.assignment.com.registration.assignment.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
public class TransactionManagerConfig {

    @Bean("mongotrans")
    public MongoTransactionManager transactionManagerMongo(MongoDatabaseFactory databaseFactory){
        return new MongoTransactionManager(databaseFactory);
    }

    @Bean("transactionManager")
    public JpaTransactionManager transactionManagerJpa(){
        return new JpaTransactionManager();
    }

}
