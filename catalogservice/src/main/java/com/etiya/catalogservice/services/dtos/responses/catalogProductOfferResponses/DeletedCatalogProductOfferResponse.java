package com.etiya.catalogservice.services.dtos.responses.catalogProductOfferResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCatalogProductOfferResponse {
    private String id;
    private LocalDate deletedDate;
}
