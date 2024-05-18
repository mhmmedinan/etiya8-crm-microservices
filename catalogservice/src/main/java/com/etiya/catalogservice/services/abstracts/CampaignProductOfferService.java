package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.services.dtos.requests.campaignProductOfferRequests.CreateCampaignProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.campaignProductOfferRequests.UpdateCampaignProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.*;

import java.util.List;

public interface CampaignProductOfferService {
    CreatedCampaignProductOfferResponse add(CreateCampaignProductOfferRequest createCampaignProductOfferRequest);
    UpdatedCampaignProductOfferResponse update(UpdateCampaignProductOfferRequest updateCampaignProductOfferRequest, String id);
    List<GetAllCampaignProductOfferResponse> getAll();
    List<GetCampaignProductOfferResponse> findByProductOfferId(String id);
    DeletedCampaignProductOfferResponse delete(String id);

}
