package com.ehizman.drones.repositories;

import com.ehizman.drones.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DroneRepository extends JpaRepository<Drone, String> {
}
