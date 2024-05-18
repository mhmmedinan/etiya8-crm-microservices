package com.etiya.catalogservice.services.dtos.requests.productRequests;

import com.etiya.catalogservice.entities.Campaign;
import com.etiya.catalogservice.entities.Catalog;
import com.etiya.catalogservice.entities.ProductOffer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private String name;
    private String description;
}
