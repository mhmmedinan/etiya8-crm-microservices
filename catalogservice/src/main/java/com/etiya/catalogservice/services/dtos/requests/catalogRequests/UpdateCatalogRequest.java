package com.etiya.catalogservice.services.dtos.requests.catalogRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCatalogRequest {
    private String name;
}
