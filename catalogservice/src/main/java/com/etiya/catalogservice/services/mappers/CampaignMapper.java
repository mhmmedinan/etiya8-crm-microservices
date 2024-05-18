package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.Campaign;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.CreateCampaignRequest;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.UpdateCampaignRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CampaignMapper {
    CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);
    GetAllCampaignResponse getAllCampaignResponseFromCampaign(Campaign campaign);
    Campaign campaignFromCreateCampaignRequest(CreateCampaignRequest createCampaignRequest);
    CreatedCampaignResponse createdCampaignResponseFromCampaign(Campaign campaign);
    Campaign campaignFromUpdateCampaignRequest(UpdateCampaignRequest updateCampaignRequest);
    UpdatedCapmaignResponse updatedCampaignResponseFromCampaign(Campaign campaign);
    DeletedCampaignResponse deletedCampaignResponseFromCampaign(Campaign campaign);
    GetCampaignResponse getCampaignResponseFromCampaign(Campaign campaign);

}
