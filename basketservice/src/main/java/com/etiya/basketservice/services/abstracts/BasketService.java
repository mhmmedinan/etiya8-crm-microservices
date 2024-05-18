package com.etiya.basketservice.services.abstracts;

import com.etiya.basketservice.entities.Basket;

public interface BasketService {
    void add(String customerId, String productOfferId);
}
