package com.etiya.basketservice.repositories;

import com.etiya.basketservice.entities.BasketItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BasketItemRepository extends MongoRepository<BasketItem, String> {
}
