package com.ehizman.drones.services;

import com.ehizman.drones.model.Drone;
import com.ehizman.drones.repositories.DroneRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DroneServiceImpl implements DroneService{
    @Autowired
    DroneRepository droneRepository;

    @Override
    public List<Drone> findAllDrones() {
        return droneRepository.findAll();
    }
}
