package com.etiya.catalogservice.services.dtos.requests.campaignRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCampaignRequest {
    private String name;
    private String description;
    private String code;
}