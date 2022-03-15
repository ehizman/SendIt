package com.ehizman.drones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum Permission {
    CHECK_PACKAGE_DETAILS("package:read"),
    ADD_NEW_PACKAGE("package:write"),
    FETCH_ALL_DRONES("drone:read"),
    ADD_NEW_DRONE("drone:write");

    private final Set<Role> roles = new HashSet<>();

    private String permission;

    @Id
    private Long id;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permission='" + permission + '\'' +
                '}';
    }
}
