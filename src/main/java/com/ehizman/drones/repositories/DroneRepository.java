package com.ehizman.drones.repositories;

import com.ehizman.drones.model.Drone;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DroneRepository extends MongoRepository<Drone, String> {
}
