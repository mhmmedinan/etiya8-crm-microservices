package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Campaign;
import com.etiya.catalogservice.entities.CampaignProductOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign,String> {

}
