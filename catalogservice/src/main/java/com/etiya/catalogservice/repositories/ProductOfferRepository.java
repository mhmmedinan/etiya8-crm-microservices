package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.ProductOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOfferRepository extends JpaRepository<ProductOffer, String> {
}
