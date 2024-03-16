package com.example.fanshopV2.repositories;

import com.example.fanshopV2.entitys.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
