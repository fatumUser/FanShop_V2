package com.example.fanshopV2.repositories;

import com.example.fanshopV2.entitys.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}
