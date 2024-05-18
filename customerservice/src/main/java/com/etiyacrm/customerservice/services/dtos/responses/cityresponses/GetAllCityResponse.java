package com.etiyacrm.customerservice.services.dtos.responses.cityresponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCityResponse {
    private String id;
    private String name;
}
