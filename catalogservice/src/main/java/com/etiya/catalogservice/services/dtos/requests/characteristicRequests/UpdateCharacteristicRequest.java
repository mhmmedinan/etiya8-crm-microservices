package com.etiya.catalogservice.services.dtos.requests.characteristicRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCharacteristicRequest {
    private String name;
    private String description;
}
