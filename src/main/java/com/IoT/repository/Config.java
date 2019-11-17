package com.IoT.repository;

import com.mongodb.*;

public class Config {

    private MongoClient mongoClient;
    private DB db;


    public Config(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        db = mongoClient.getDB("local");
    }

    MongoClient getClient() {
        return mongoClient;
    }

    DB getDb() {
        return db;
    }
}

