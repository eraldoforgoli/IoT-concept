package com.IoT.config;

import com.IoT.repository.Config;
import com.IoT.repository.GadgetDAO;
import com.IoT.repository.IConfig;
import com.IoT.repository.IGadgetDAO;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private static final String host = "localhost";
    private static final int port = 27017;

    @Bean
    public IGadgetDAO gadgetDAO() {
        return new GadgetDAO(getConfig());
    }

    @Bean
    public IConfig getConfig() {
        return new Config(getMongoClient());
    }

    @Bean
    public MongoClient getMongoClient() {
        return new MongoClient(host, port);
    }

}
