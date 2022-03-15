package com.ehizman.drones.services;

import com.ehizman.drones.model.Drone;

import java.util.List;

public interface DroneService {
    List<Drone> findAllDrones();
}
