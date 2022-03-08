package com.ehizman.drones.model;

import com.ehizman.drones.model.enums.DroneSize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

import static com.ehizman.drones.util.Commons.generateId;

@Document
@Getter
@Setter
public class Drone {
    @Id
    private String id;
    private String registrationId;

    private DroneSize size;

    public Drone() {
        this.id = "DRN-" + generateId();
    }

    @Override
    public String toString() {
        return "Drone{" +
                "id='" + id + '\'' +
                ", registrationId='" + registrationId + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drone drone = (Drone) o;
        return Objects.equals(id, drone.id) && Objects.equals(registrationId, drone.registrationId) && size == drone.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationId, size);
    }
}
