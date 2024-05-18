package com.etiya.catalogservice.services.dtos.responses.productResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedProductResponse {
    private String id;
    private LocalDate deletedDate;
}
