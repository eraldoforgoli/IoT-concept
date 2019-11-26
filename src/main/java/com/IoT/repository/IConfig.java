package com.IoT.repository;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public interface IConfig {
    MongoClient getClient();

    DB getDb();
}
