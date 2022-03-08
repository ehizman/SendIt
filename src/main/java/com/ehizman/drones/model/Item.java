package com.ehizman.drones.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import static com.ehizman.drones.util.Commons.generateId;

@Entity
public class Item {
    private String itemName;
    private Double itemWeight;
    @Id
    private String id;

    public Item() {
        id = "ITEM-" + generateId();
    }
}
