package com.etiya.catalogservice.services.dtos.requests.productOfferRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductOfferRequest {
    private String name;
    private String description;
    private double totalPrice;
    private String productId;
}
