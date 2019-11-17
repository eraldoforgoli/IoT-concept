package com.IoT.Repository;


import com.mongodb.*;


public class Config {

    private MongoClient mongo;
    private DB db;


    public Config() {
        MongoClient mongo = new MongoClient("localhost", 27017);
        db = mongo.getDB("local");
    }

    public MongoClient getClient() {
        if (mongo == null) {
            return new MongoClient("localhost", 27017);
        } else
            return mongo;
    }

}

