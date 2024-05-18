package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.services.dtos.requests.campaignRequests.CreateCampaignRequest;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.UpdateCampaignRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.*;

import java.util.List;

public interface CampaignService {
    CreatedCampaignResponse add(CreateCampaignRequest createCampaignRequest);
    UpdatedCapmaignResponse update(UpdateCampaignRequest updateCampaignRequest, String id);
    List<GetAllCampaignResponse> getAll();
    GetCampaignResponse getById(String id);
    DeletedCampaignResponse delete(String id);
}
