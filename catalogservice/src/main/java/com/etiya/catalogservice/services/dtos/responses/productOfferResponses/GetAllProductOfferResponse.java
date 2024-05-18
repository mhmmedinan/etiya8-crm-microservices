package com.etiya.catalogservice.services.dtos.responses.productOfferResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductOfferResponse {
    private String id;
    private String name;
    private String description;
    private double totalPrice;
    private String productId;
}
