package com.ehizman.drones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.Set;

import static com.ehizman.drones.util.Commons.generateId;

@AllArgsConstructor
@Getter
@Setter
@Document
public class Package {
    @Id
    private String packageId;
    private Set<Item> items;

    public Package() {
        packageId = generateId();
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageId='" + packageId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return packageId.equals(aPackage.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageId);
    }
}
