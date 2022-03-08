package com.ehizman.drones.repositories;

import com.ehizman.drones.model.Package;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PackageRepository extends MongoRepository<Package, String> {
}
