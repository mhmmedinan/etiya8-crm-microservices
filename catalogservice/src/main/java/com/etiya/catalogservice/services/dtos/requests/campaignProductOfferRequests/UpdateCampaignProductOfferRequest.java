package com.etiya.catalogservice.services.dtos.requests.campaignProductOfferRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCampaignProductOfferRequest {
    private String productOfferId;
    private String campaignId;
}
