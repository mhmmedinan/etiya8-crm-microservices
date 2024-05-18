package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.CampaignProductOffer;
import com.etiya.catalogservice.services.dtos.requests.campaignProductOfferRequests.CreateCampaignProductOfferRequest;
import com.etiya.catalogservice.services.dtos.requests.campaignProductOfferRequests.UpdateCampaignProductOfferRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CampaignProductOfferMapper {
    CampaignProductOfferMapper INSTANCE = Mappers.getMapper(CampaignProductOfferMapper.class);

    @Mapping(source = "campaign.id", target = "campaignId")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    GetAllCampaignProductOfferResponse getAllCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    @Mapping(source = "campaignId", target = "campaign.id")
    @Mapping(source = "productOfferId", target = "productOffer.id")
    CampaignProductOffer campaignProductOfferFromCreateCampaignProductOfferRequest(CreateCampaignProductOfferRequest createCampaignProductOfferRequest);
    @Mapping(source = "campaign.id", target = "campaignId")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    CreatedCampaignProductOfferResponse createdCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    @Mapping(source = "campaignId", target = "campaign.id")
    @Mapping(source = "productOfferId", target = "productOffer.id")
    CampaignProductOffer campaignProductOfferFromUpdateCampaignProductOfferRequest(UpdateCampaignProductOfferRequest updateCampaignProductOfferRequest);
    @Mapping(source = "campaign.id", target = "campaignId")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    UpdatedCampaignProductOfferResponse updatedCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    DeletedCampaignProductOfferResponse deletedCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
    @Mapping(source = "campaign.id", target = "campaignId")
    @Mapping(source = "productOffer.id", target = "productOfferId")
    GetCampaignProductOfferResponse getCampaignProductOfferResponseFromCampaignProductOffer(CampaignProductOffer campaignProductOffer);
}
