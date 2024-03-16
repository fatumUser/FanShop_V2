package com.example.fanshopV2.repositories;

import com.example.fanshopV2.entitys.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvatarRepo extends JpaRepository<Avatar, String> {
    /*List<Avatar> findById(String id);*/
}
