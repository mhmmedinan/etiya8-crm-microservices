package com.etiyacrm.customerservice.services.dtos.responses.cityresponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedCityResponse {
    private String id;
    private LocalDateTime deletedDate;
}
