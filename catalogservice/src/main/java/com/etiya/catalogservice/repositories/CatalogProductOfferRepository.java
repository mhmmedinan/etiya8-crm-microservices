package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.CatalogProductOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogProductOfferRepository extends JpaRepository<CatalogProductOffer, String> {
    CatalogProductOffer findByProductOfferId (String productOfferId);
}
