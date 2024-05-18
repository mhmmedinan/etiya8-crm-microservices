package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
