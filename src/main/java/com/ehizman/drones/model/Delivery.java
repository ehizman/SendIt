package com.ehizman.drones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor

@Document
@Getter
@Setter
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
    private String id;

    private Set<Item> items;

    @Override
    public String toString() {
        return "Delivery{" +
                "sourceAddress='" + sourceAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", sourceLongitude=" + sourceLongitude +
                ", sourceLatitude=" + sourceLatitude +
                ", DestinationLongitude=" + DestinationLongitude +
                ", DestinationLatitude=" + DestinationLatitude +
                ", deliveryInitiationDateAndTime=" + deliveryInitiationDateAndTime +
                ", deliveryCompletionDateAndTime=" + deliveryCompletionDateAndTime +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return sourceLongitude.equals(delivery.sourceLongitude) && sourceLatitude.equals(delivery.sourceLatitude) && DestinationLongitude.equals(delivery.DestinationLongitude) && DestinationLatitude.equals(delivery.DestinationLatitude) && deliveryInitiationDateAndTime.equals(delivery.deliveryInitiationDateAndTime) && deliveryCompletionDateAndTime.equals(delivery.deliveryCompletionDateAndTime) && id.equals(delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceLongitude, sourceLatitude, DestinationLongitude, DestinationLatitude, deliveryInitiationDateAndTime, deliveryCompletionDateAndTime, id);
    }
}
