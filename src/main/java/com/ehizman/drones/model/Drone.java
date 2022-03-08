package com.ehizman.drones.model;

import com.ehizman.drones.model.enums.DroneSize;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;

import static com.ehizman.drones.util.Commons.generateId;

@Entity
public class Drone {
    @Id
    private String id;
    private String registrationId;
    private DroneSize size;

    public Drone() {
        this.id = "DRN-" + generateId();
    }


}
