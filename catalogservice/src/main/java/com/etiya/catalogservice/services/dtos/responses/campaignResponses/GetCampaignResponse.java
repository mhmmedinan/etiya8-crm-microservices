package com.etiya.catalogservice.services.dtos.responses.campaignResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCampaignResponse {
    private String id;
    private String name;
    private String description;
    private String code;
}
