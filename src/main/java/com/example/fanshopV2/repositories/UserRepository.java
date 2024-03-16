package com.example.fanshopV2.repositories;

import com.example.fanshopV2.entitys.User;
import org.springframework.data.repository.CrudRepository;
import org.yaml.snakeyaml.events.Event;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    Long findById(Event.ID id);
}
