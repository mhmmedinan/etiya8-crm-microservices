package com.etiya.basketservice.repositories;

import com.etiya.basketservice.entities.Basket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BasketRepository extends MongoRepository<Basket, String> {
}
