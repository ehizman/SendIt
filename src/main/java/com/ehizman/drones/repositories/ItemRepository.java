package com.ehizman.drones.repositories;

import com.ehizman.drones.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, String> {
}
