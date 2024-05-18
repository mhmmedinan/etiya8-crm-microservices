package com.etiya.catalogservice.services.dtos.responses.catalogResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCatalogResponse {
    private String id;
    private LocalDate deletedDate;
}
