package com.ehizman.drones.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "deliveries")
public class Delivery {
    private String sourceAddress;
    private String destinationAddress;
    private Long sourceLongitude;
    private Long sourceLatitude;
    private Long DestinationLongitude;
    private Long DestinationLatitude;
    private LocalDateTime deliveryInitiationDateAndTime;
    private LocalDateTime deliveryCompletionDateAndTime;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private Set<Item> items;
}
