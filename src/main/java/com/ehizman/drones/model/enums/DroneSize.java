package com.ehizman.drones.model.enums;

public enum DroneSize {
    LARGE(500.0),
    MEDIUM(300.0),
    SMALL(150.00);

    private final double weight;

    DroneSize(double weight) {
        this.weight = weight;
    }

    public Double getWeight(){
        return weight;
    }
}
