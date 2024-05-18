package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.CampaignProductOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignProductOfferRepository extends JpaRepository<CampaignProductOffer, String> {
    List<CampaignProductOffer> findByProductOfferId(String productOfferId);
}
