package com.ehizman.drones.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Objects;

import static com.ehizman.drones.util.Commons.generateId;

@Document
@Getter
@Setter
public class Item {
    private String itemName;
    private Double itemWeight;
    @Id
    private String id;

    public Item() {
        id = "ITEM-" + generateId();
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemWeight=" + itemWeight +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemName.equals(item.itemName) && itemWeight.equals(item.itemWeight) && id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemWeight, id);
    }
}
