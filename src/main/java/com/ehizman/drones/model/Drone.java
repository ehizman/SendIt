package com.ehizman.drones.model;

import com.ehizman.drones.model.enums.DroneSize;
import com.ehizman.drones.model.enums.DroneState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

import static com.ehizman.drones.util.Commons.generateId;

@Document
@NoArgsConstructor
@Getter
@Setter
public class Drone {
    @Id
    private String droneId;

    private DroneSize size;

    private DroneState state;

    public Drone(String droneSize) {
        this.droneId = "DRN-" + generateId();
        this.state = DroneState.IDLE;
        this.size = DroneSize.valueOf(droneSize);
    }

    @Override
    public String toString() {
        return "Drone{" +
                "id='" + droneId + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drone drone = (Drone) o;
        return Objects.equals(droneId, drone.droneId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droneId);
    }
}
