package com.IoT.repository;

import com.mongodb.*;


public class Config implements IConfig {

    private MongoClient mongoClient;
    private DB db;

    public Config(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        db = mongoClient.getDB("local");
    }

    public MongoClient getClient() {
        return mongoClient;
    }

    public DB getDb() {
        return db;
    }
}

