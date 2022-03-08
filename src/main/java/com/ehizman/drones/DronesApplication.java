package com.ehizman.drones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DronesApplication {
    public static void main(String[] args) {
        SpringApplication.run(DronesApplication.class, args);
    }
}
