package com.etiya.catalogservice.services.dtos.responses.characteristicValueResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCharacteristicValueResponse {
    private String id;
    private String value;
    private boolean isActive;
    private String characteristicId;

}
