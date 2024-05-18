package com.etiya.catalogservice.services.dtos.responses.catalogResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedCatalogResponse {
    private String id;
    private String name;
}
