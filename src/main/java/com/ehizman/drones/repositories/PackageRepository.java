package com.ehizman.drones.repositories;

import com.ehizman.drones.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PackageRepository extends JpaRepository<Package, String> {
}
