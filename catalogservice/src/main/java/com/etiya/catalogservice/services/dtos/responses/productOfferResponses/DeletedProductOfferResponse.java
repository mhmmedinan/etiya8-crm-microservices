package com.etiya.catalogservice.services.dtos.responses.productOfferResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedProductOfferResponse {
    private String id;
    private LocalDate deletedDate;
}
