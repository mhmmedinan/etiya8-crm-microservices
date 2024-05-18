package com.etiya.catalogservice.services.dtos.responses.campaignResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCampaignResponse {
    private String id;
    private LocalDate deletedDate;
}
