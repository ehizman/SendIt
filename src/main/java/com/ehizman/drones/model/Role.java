package com.ehizman.drones.model;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ehizman.drones.model.Permission.*;

@Getter
@NoArgsConstructor
public enum Role {
    USER(Sets.newHashSet(CHECK_PACKAGE_DETAILS, ADD_NEW_PACKAGE)),
    ADMIN(Sets.newHashSet(CHECK_PACKAGE_DETAILS, ADD_NEW_PACKAGE, FETCH_ALL_DRONES, ADD_NEW_DRONE));

    @Id
    private Long id;

    private Set<Permission> permissions;

    Role(HashSet<Permission> permissions) {
        this.permissions = permissions;
    }

    public void removePermission(Permission permission){
        permissions.remove(permission);
    }

    public void addPermission(Permission permission){
        permissions.add(permission);
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
