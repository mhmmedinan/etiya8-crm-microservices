package com.etiya.catalogservice.services.dtos.responses.campaignProductOfferResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCampaignProductOfferResponse {
    private String id;
    private LocalDate deletedDate;
}
