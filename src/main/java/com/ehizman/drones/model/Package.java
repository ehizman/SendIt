package com.ehizman.drones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

import static com.ehizman.drones.util.Commons.generateId;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Package {
    @Id
    private String packageId;
    @OneToMany
    private Set<Item> items;

    public Package() {
        packageId = generateId();
    }
}
