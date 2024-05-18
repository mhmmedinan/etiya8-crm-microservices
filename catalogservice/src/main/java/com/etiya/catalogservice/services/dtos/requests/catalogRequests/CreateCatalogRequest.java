package com.etiya.catalogservice.services.dtos.requests.catalogRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCatalogRequest {
    private String name;
}
