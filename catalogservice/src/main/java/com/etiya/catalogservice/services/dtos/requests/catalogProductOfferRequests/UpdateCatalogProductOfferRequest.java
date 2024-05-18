package com.etiya.catalogservice.services.dtos.requests.catalogProductOfferRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCatalogProductOfferRequest {
    private String productOfferId;
    private String catalogId;
}
