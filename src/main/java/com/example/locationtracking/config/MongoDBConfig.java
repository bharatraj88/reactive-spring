package com.example.locationtracking.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.stereotype.Component;

@Configuration
public class MongoDBConfig extends AbstractMongoConfiguration {

    @Value("${app.db.database}")
    private String database;

    @Value("${app.db.host}")
    private String host;

    @Value("${app.db.port}")
    private int port;
    @Override
    public MongoClient mongoClient() {
        return new MongoClient(this.host, this.port);
    }

    @Override
    protected String getDatabaseName() {
        return this.database;
    }
}
