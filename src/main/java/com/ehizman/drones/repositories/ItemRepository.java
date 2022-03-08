package com.ehizman.drones.repositories;

import com.ehizman.drones.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ItemRepository extends MongoRepository<Item, String> {
}
